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
import com.zp.recruit.entity.AllPosition;
import com.zp.recruit.entity.Tb_position;
import com.zp.recruit.service.IAllPositionService;
import com.zp.recruit.service.ITb_positionService;

/***
 * 职位管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/position/")
@CrossOrigin
public class PositionController extends BaseController{
	
	@Autowired
	private ITb_positionService iTb_positionService;
	@Autowired
	private IAllPositionService iAllPositionService;
	
	/***
	 * 查询职位
	 * @param size
	 * @param current
	 * @param p_state 传入1查询启动的，传入0查询停用的，不传查询所有
	 * @param p_id  不传查所有，传入可根据ID 查询
	 * @return
	 */
	@RequestMapping(value = "selectAllPositionList",method = RequestMethod.POST)
	@ResponseBody
	public Object selectAllPositionList(Integer size, Integer current,Integer p_state,Integer p_id) {
		if (size == null) {
			size = 10;
		}
		if (current == null) {
			current = 1;
		}
		Page<AllPosition> page = new Page<AllPosition>(current, size);
		Page<AllPosition> listPage = iAllPositionService.selectAllPositionList(page,p_state,p_id);
		return listPage.getSize() > 0 ? 
				renderSuccess(listPage) : renderError("暂无数据");
	
	}
	
	/***
	 * 添加职位
	 * 修改职位
	 * @param tb_position
	 * @return
	 */
	@RequestMapping(value = "insertOrUpdateByObject",method = RequestMethod.POST)
	@ResponseBody
	public Object insertOrUpdateByObject(Tb_position tb_position) {
		tb_position.setP_time(new Date());
		boolean bool = iTb_positionService.insertOrUpdate(tb_position);
		return false != bool ? 
				renderSuccess("成功") : renderError("失败");
	}
	
	/***
	 * 删除职位 传入p_id
	 * @param p_id
	 * @return
	 */
	@RequestMapping(value = "deleteTbpositionById",method = RequestMethod.POST)
	@ResponseBody
	public Object deleteTbpositionById(Integer[] p_id) {
		List<Integer> stringB = Arrays.asList(p_id);
		boolean bool = iTb_positionService.deleteBatchIds(stringB);
		return false != bool ? 
				renderSuccess("删除成功") : renderError("删除失败");
	}

}
