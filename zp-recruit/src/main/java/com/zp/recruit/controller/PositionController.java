package com.zp.recruit.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.plugins.Page;
import com.zp.recruit.entity.AllPosition;
import com.zp.recruit.entity.Tb_position;
import com.zp.recruit.service.IAllPositionService;
import com.zp.recruit.service.ITb_positionService;

/***
 * 职位管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/position/")
@CrossOrigin
public class PositionController extends BaseController {

	@Autowired
	private ITb_positionService iTb_positionService;
	@Autowired
	private IAllPositionService iAllPositionService;

	/***
	 * 查询职位
	 * 
	 * @param size
	 * @param current
	 * @param p_state
	 *            传入1查询启动的，传入0查询停用的，不传查询所有
	 * @param p_id
	 *            不传查所有，传入可根据ID 查询
	 * @return
	 */
	@RequestMapping(value = "selectAllPositionList", method = RequestMethod.POST)
	@ResponseBody
	public Object selectAllPositionList(Integer size, Integer current,
			Integer p_state, Integer p_id) {
		if (size == null) {
			size = 10;
		}
		if (current == null) {
			current = 1;
		}
		Page<AllPosition> page = new Page<AllPosition>(current, size);
		Page<AllPosition> listPage = iAllPositionService
				.selectAllPositionList(page, p_state, p_id);
		return listPage.getSize() > 0
				? renderSuccess(listPage)
				: renderError("暂无数据");

	}

	/***
	 * 添加职位 修改职位
	 * 
	 * @param tb_position
	 * @return
	 */
	@RequestMapping(value = "insertOrUpdateByObject", method = RequestMethod.POST)
	@ResponseBody
	public Object insertOrUpdateByObject(Tb_position tb_position) {
		tb_position.setP_time(new Date());
		boolean bool = iTb_positionService.insertOrUpdate(tb_position);
		return false != bool ? renderSuccess("成功") : renderError("失败");
	}

	/***
	 * 删除职位 传入p_id
	 * 
	 * @param p_id
	 * @return
	 */
	@RequestMapping(value = "deleteTbpositionById", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteTbpositionById(Integer[] p_id) {
		List<Integer> stringB = Arrays.asList(p_id);
		boolean bool = iTb_positionService.deleteBatchIds(stringB);
		return false != bool ? renderSuccess("删除成功") : renderError("删除失败");
	}

	/***
	 * 上传职位logo
	 * 
	 * @param fileFieName
	 * @param request
	 * @param response
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "replaceLBTImage", method = RequestMethod.POST)
	@ResponseBody
	public Object replaceLBTImage(
			@RequestParam("logofile") MultipartFile logofile,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {

		try {
			// 获取图片原始文件名
			String originalFilename = logofile.getOriginalFilename();
			System.out.println(originalFilename);

			// 文件名使用当前时间
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());

			// 获取上传图片的扩展名(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);

			// 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
			String requestUrl = request.getScheme() // 当前链接使用的协议
					+ "://" + request.getServerName()// 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() + "/upload/" + name + "."
					+ extension;
			// 图片上传的绝对路径
			String url = request.getSession().getServletContext()
					.getRealPath("") + "/upload/" + name + "." + extension;

			File destFile = new File(url);
			if (!destFile.exists()) {
				destFile.mkdirs();
			}
			// 上传图片
			logofile.transferTo(destFile);

			return renderSuccess(requestUrl);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("服务器繁忙，上传图片失败");
		}
	}

}
