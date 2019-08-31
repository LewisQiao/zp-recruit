package com.zp.recruit.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zp.recruit.entity.Tb_manager;
import com.zp.recruit.service.ITb_managerService;
import com.zp.recruit.util.MD5Util;
/***
 * 管理员
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admins/")
@CrossOrigin
public class AdminController extends BaseController {

	@Autowired
	private ITb_managerService iTb_managerService;

	/***
	 * 管理员登录
	 * @param tb_manager
	 * @return
	 */
	@RequestMapping(value = "adminLogin",method=RequestMethod.POST)
	@ResponseBody
	public Object adminLogin(Tb_manager tb_manager) {
		if(null != tb_manager.getM_username() && null != tb_manager.getM_password() ) {
			Wrapper<Tb_manager> wrapper = new EntityWrapper<Tb_manager>();
			wrapper.where("m_username='" + tb_manager.getM_username() + "'").and("m_password='" + MD5Util.getMD5(tb_manager.getM_password()) + "'");
			Tb_manager tmObject = iTb_managerService.selectOne(wrapper);
			if(null != tmObject) {
				Tb_manager model = new Tb_manager();
				model.setM_login_time(new Date());
				model.setM_id(tmObject.getM_id());
				if(tmObject.getM_login_count() != null) {
					model.setM_login_count(tmObject.getM_login_count()+1);
				}else {
					model.setM_login_count(1);
				}
				iTb_managerService.updateById(model);
				return renderSuccess("登录成功");
			} 
			return renderError("用户名或密码不正确");
		}
		return renderError("用户名不存在");
	}
	
	/***
	 * 查询所有管理员
	 * @return
	 */
	@RequestMapping(value = "getAdminList",method=RequestMethod.POST)
	@ResponseBody
	public Object getAdminList(Integer size,Integer current) {	
		if (size == null) {
			size = 7;
		} 
		if (current == null) {
			current = 1;
		}
		Page<Tb_manager> page = new Page<>(current,size);
		Page<Tb_manager> listAdmin = iTb_managerService.selectPage(page);
		return listAdmin.getSize() > 0 ? 
				renderSuccess(listAdmin) : renderError("暂无数据");
	}
	
	/****
	 * 添加修改管理员
	 * @param tb_manager
	 * @return
	 */
	@RequestMapping(value = "insertOrUpdateAdminById",method=RequestMethod.POST)
	@ResponseBody
	public Object insertOrUpdateAdminById(Tb_manager tb_manager) {
		tb_manager.setM_password(MD5Util.getMD5(tb_manager.getM_password()));
		boolean bool = iTb_managerService.insertOrUpdate(tb_manager);
		return false != bool ? 
				renderSuccess("成功") : renderError("失败");
	}
	
	/***
	 * 根据ID 删除管理员
	 * @param mid
	 * @return
	 */
	@RequestMapping(value = "deleteAdminById",method=RequestMethod.POST)
	@ResponseBody
	public Object deleteAdminById(Integer[] mid) {
		List<Integer> stringB = Arrays.asList(mid);
		boolean bool = iTb_managerService.deleteBatchIds(stringB);
		return false != bool ? 
				renderSuccess("删除成功") : renderError("删除失败");
	}

}
