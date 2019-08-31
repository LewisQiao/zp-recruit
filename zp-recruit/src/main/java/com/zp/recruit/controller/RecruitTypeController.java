package com.zp.recruit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.zp.recruit.entity.Tb_recruit_type;
import com.zp.recruit.service.ITb_recruit_typeService;

/***
 * 招聘类型管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/recruitType/")
@CrossOrigin
public class RecruitTypeController extends BaseController{

	@Autowired
	private ITb_recruit_typeService iTb_recruit_typeService;
	
	/***
	 * 查询所有类型
	 * @return
	 */
	@RequestMapping(value = "getRecruitTypeList", method = RequestMethod.POST)
	@ResponseBody
	public Object getRecruitTypeList(Integer size,Integer current) {
		if (size == null) {
			size = 7;
		} 
		if (current == null) {
			current = 1;
		}
		Page<Tb_recruit_type> page = new Page<>(current,size);
		Page<Tb_recruit_type> listRecruitType = iTb_recruit_typeService.selectPage(page);
		return listRecruitType.getSize() > 0 ? 
				renderSuccess(listRecruitType) : renderError("暂无数据");
	}
	
	/***
	 * 添加修改类型
	 * @param tb_recruit_type
	 * @return
	 */
	@RequestMapping(value = "insertOrUpdateRecruitById", method = RequestMethod.POST)
	@ResponseBody
	public Object insertOrUpdateRecruitById(Tb_recruit_type tb_recruit_type) {
		boolean bool = iTb_recruit_typeService.insertOrUpdate(tb_recruit_type);
		return false != bool ? 
				renderSuccess("成功") : renderError("失败");
	}
	
	/***
	 * 删除招聘类型
	 * @param rid
	 * @return
	 */
	@RequestMapping(value = "deleteRecruitById", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteRecruitById(Integer[] rid) {
		List<Integer> stringB = Arrays.asList(rid);
		boolean bool = iTb_recruit_typeService.deleteBatchIds(stringB);
		return false != bool ? 
				renderSuccess("删除成功") : renderError("删除失败");
	}
	
}
