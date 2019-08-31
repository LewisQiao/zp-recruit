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

import com.baomidou.mybatisplus.plugins.Page;
import com.zp.recruit.entity.Tb_work_place;
import com.zp.recruit.service.ITb_work_placeService;

/***
 * 工作地点管理
 * @author Administrator
 */
@Controller
@RequestMapping("/workPlace/")
@CrossOrigin
public class WorkPlaceController extends BaseController{

	@Autowired
	private ITb_work_placeService iTb_work_placeService;
	
	
	/***
	 * 查询所有工作地点
	 * @param size
	 * @param current
	 * @return
	 */
	@RequestMapping(value = "selectWorkPlaceList" , method = RequestMethod.POST)
	@ResponseBody
	public Object selectWorkPlaceList(Integer size,Integer current) {
		if (size == null) {
			size = 7;
		} 
		if (current == null) {
			current = 1;
		}
		Page<Tb_work_place> page = new Page<>(current,size);
		Page<Tb_work_place> listWorkPlace = iTb_work_placeService.selectPage(page);
		return listWorkPlace.getSize() > 0 ? 
				renderSuccess(listWorkPlace) : renderError("暂无数据");
	}
	
	/****
	 * 根据ID 删除工作地点
	 * @return
	 */
	@RequestMapping(value = "deleteWorkPlaceById" , method = RequestMethod.POST)
	@ResponseBody
	public Object deleteWorkPlaceById(Integer[] wid) {
		List<Integer> stringB = Arrays.asList(wid);
		boolean bool = iTb_work_placeService.deleteBatchIds(stringB);
		return false != bool ? 
				renderSuccess("删除成功") : renderError("删除失败");
	}
	
	/***
	 * 添加修改工作地点
	 * @param tb_work_place
	 * @return
	 */
	@RequestMapping(value = "insertOrUpdateWorkPlace" , method = RequestMethod.POST)
	@ResponseBody
	public Object insertOrUpdateWorkPlace(Tb_work_place tb_work_place) {
		tb_work_place.setW_time(new Date());
		boolean bool = iTb_work_placeService.insertOrUpdate(tb_work_place);
		return false != bool ?
				renderSuccess("成功") : renderError("失败");
	}
	
}
