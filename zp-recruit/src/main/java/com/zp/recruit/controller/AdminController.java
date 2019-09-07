package com.zp.recruit.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zp.recruit.entity.Tb_manager;
import com.zp.recruit.service.ITb_managerService;
import com.zp.recruit.util.MD5Util;

/***
 * 管理员
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admins/")
@CrossOrigin
public class AdminController extends BaseController {

	private static final String appid = "wx44197de440cc1bdf"; // 微信公众号appid
	private static final String secret = "ac21fce38f2cdf2b7fdc323ff4d5e938"; // 微信公众号密钥

	@Autowired
	private ITb_managerService iTb_managerService;

	/***
	 * 管理员登录
	 * 
	 * @param tb_manager
	 * @return
	 */
	@RequestMapping(value = "adminLogin", method = RequestMethod.POST)
	@ResponseBody
	public Object adminLogin(Tb_manager tb_manager) {
		if (null != tb_manager.getM_username() && null != tb_manager.getM_password()) {
			Wrapper<Tb_manager> wrapper = new EntityWrapper<Tb_manager>();
			wrapper.where("m_username='" + tb_manager.getM_username() + "'")
					.and("m_password='" + MD5Util.getMD5(tb_manager.getM_password()) + "'");
			Tb_manager tmObject = iTb_managerService.selectOne(wrapper);
			if (null != tmObject) {
				Tb_manager model = new Tb_manager();
				model.setM_login_time(new Date());
				model.setM_id(tmObject.getM_id());
				if (tmObject.getM_login_count() != null) {
					model.setM_login_count(tmObject.getM_login_count() + 1);
				} else {
					model.setM_login_count(1);
				}
				boolean bool = iTb_managerService.updateById(model);
				return false != bool ? renderSuccess(tmObject) : renderError("登录失败");
			}
			return renderError("用户名或密码不正确");
		}
		return renderError("用户名不存在");
	}

	/***
	 * 查询所有管理员
	 * 
	 * @return
	 */
	@RequestMapping(value = "getAdminList", method = RequestMethod.POST)
	@ResponseBody
	public Object getAdminList(Integer size, Integer current) {
		if (size == null) {
			size = 7;
		}
		if (current == null) {
			current = 1;
		}
		Page<Tb_manager> page = new Page<>(current, size);
		Page<Tb_manager> listAdmin = iTb_managerService.selectPage(page);
		return listAdmin.getSize() > 0 ? renderSuccess(listAdmin) : renderError("暂无数据");
	}

	/****
	 * 添加修改管理员
	 * 
	 * @param tb_manager
	 * @return
	 */
	@RequestMapping(value = "insertOrUpdateAdminById", method = RequestMethod.POST)
	@ResponseBody
	public Object insertOrUpdateAdminById(Tb_manager tb_manager) {
		tb_manager.setM_password(MD5Util.getMD5(tb_manager.getM_password()));
		boolean bool = iTb_managerService.insertOrUpdate(tb_manager);
		return false != bool ? renderSuccess("成功") : renderError("失败");
	}
	
	/***
	 * 修改密码
	 * @param tb_manager
	 * @param upass
	 * @return
	 */
	@RequestMapping(value = "updateAdminById", method = RequestMethod.POST)
	@ResponseBody
	public Object updateAdminById(Tb_manager tb_manager,String upass) {
		if(tb_manager.getM_username() != null && tb_manager.getM_password() != null) {
			Tb_manager tbm = iTb_managerService.selectById(tb_manager.getM_id());
			if(tbm.getM_password().equals(MD5Util.getMD5(tb_manager.getM_password()))) {
				Tb_manager obj = new Tb_manager();
				obj.setM_username(tb_manager.getM_username());
				obj.setM_password(MD5Util.getMD5(upass));
				obj.setM_id(tb_manager.getM_id());
				boolean bool = iTb_managerService.updateById(obj);
				return false != bool ? 
						renderSuccess("修改成功") : renderError("修改失败");
			}else {
				return renderError("旧密码错误");
			}
		}
		return renderError("账户和密码不能为空");
	}

	/***
	 * 根据ID 删除管理员
	 * 
	 * @param mid
	 * @return
	 */
	@RequestMapping(value = "deleteAdminById", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteAdminById(Integer[] mid) {
		List<Integer> stringB = Arrays.asList(mid);
		boolean bool = iTb_managerService.deleteBatchIds(stringB);
		return false != bool ? renderSuccess("删除成功") : renderError("删除失败");
	}

	@RequestMapping("/toOpenId")
	@ResponseBody
	public Map<String, Object> getOpenId(String code, String echostr, HttpServletResponse res) throws IOException {

		if (echostr == null) {
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
			System.out.println(code);
			Map<String, Object> map = null;
			try {
				URL getUrl = new URL(url);
				HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
				http.setRequestMethod("GET");
				http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				http.setDoOutput(true);
				http.setDoInput(true);

				http.connect();
				InputStream is = http.getInputStream();
				int size = is.available();
				byte[] b = new byte[size];
				is.read(b);

				String message = new String(b, "UTF-8");

				JSONObject json = JSONObject.parseObject(message);
				System.out.println("heheh"+json);
				String openid = json.getString("openid");
				String access_token = getUser(res);
				map = getUserOpenid(res,access_token,openid);
				//map = getUser(res,access_token);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return map;
		} else {
			PrintWriter out = res.getWriter();
			out.print(echostr);
			return null;
		}
	}

	public String getUser(HttpServletResponse res) {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
		String access_token = null;
		try {
			URL getUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);

			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] b = new byte[size];
			is.read(b);

			String message = new String(b, "UTF-8");

			JSONObject json = JSONObject.parseObject(message);
			System.out.println("hahah"+json);
			access_token = json.getString("access_token");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_token;
	}
	
	public Map<String, Object> getUserOpenid(HttpServletResponse res,String access_token,String openid) {
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			URL getUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);

			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] b = new byte[size];
			is.read(b);

			String message = new String(b, "UTF-8");

			JSONObject json = JSONObject.parseObject(message);
			System.out.println("用户信息"+json);
			map.put("user", json);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}
