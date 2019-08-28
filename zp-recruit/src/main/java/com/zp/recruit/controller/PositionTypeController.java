package com.zp.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.zp.recruit.entity.Tb_position_type;
import com.zp.recruit.service.ITb_position_typeService;

/***
 * 职位类型管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/positionType/")
public class PositionTypeController extends BaseController{
	
	@Autowired
	private ITb_position_typeService iTb_position_typeService;
	
	/***
	 * 查询所有职位类型
	 * @param size
	 * @param current
	 * @return
	 */
	@RequestMapping(value = "selectPositionTypeByPage" ,method = RequestMethod.POST)
	@ResponseBody
	public Object selectPositionTypeByPage(Integer size,Integer current) {
		if (size == null) {
			size = 7;
		} 
		if (current == null) {
			current = 1;
		}
		Page<Tb_position_type> page = new Page<>(current,size);
		Page<Tb_position_type> pageListPage = iTb_position_typeService.selectPage(page);
		return pageListPage.getSize() > 0 ? 
				renderSuccess(pageListPage) : renderError("暂无数据");
	}
	
	/***
	 * 添加修改职位类型
	 * @param tb_position_type
	 * @return
	 */
	@RequestMapping(value = "insertOrUpdatePositionType" ,method = RequestMethod.POST)
	@ResponseBody
	public Object insertOrUpdatePositionType(Tb_position_type tb_position_type) {
		boolean bool = iTb_position_typeService.insertOrUpdate(tb_position_type);
		return false != bool ? 
				renderSuccess("成功") : renderError("失败");
	}

}
