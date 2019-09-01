package com.zp.recruit.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.zp.recruit.entity.AllMyDeliveryResume;
import com.zp.recruit.entity.Tb_delivery_resume;
import com.zp.recruit.service.IAllMyDeliveryResumeService;
import com.zp.recruit.service.ITb_delivery_resumeService;

/**
 * 投递简历
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/deliveryResume/")
@CrossOrigin
public class DeliveryResumeController extends BaseController{

	@Autowired
	private ITb_delivery_resumeService iTb_delivery_resumeService;
	
	@Autowired
	private IAllMyDeliveryResumeService iAllMyDeliveryResumeService;
	
	/****
	 * 用户投递简历
	 * 投递时传入：用户ID u_id，微简历ID m_id，职位ID p_id,
	 * @param Tb_delivery_resume
	 * @return
	 */
	@RequestMapping(value = "userDeliveryResume",method = RequestMethod.POST)
	@ResponseBody
	public Object userDeliveryResume(Tb_delivery_resume Tb_delivery_resume) {
		Tb_delivery_resume.setD_time(new Date());
		boolean bool = iTb_delivery_resumeService.insertOrUpdate(Tb_delivery_resume);
		return false != bool ? 
				renderSuccess("成功") : renderError("失败");
	}
	
	/****
	 * 
	 * 查询投递记录
	 * @param size
	 * @param current
	 * @param u_id 传入时 查个人投递记录  不传查所有
	 * @param d_state  管理端用 不传查所有，传入1查看状态被查看，传入2，查看邀请面试
	 * @return
	 */
	@RequestMapping(value = "getDeliveryResumeByIdOrList",method = RequestMethod.POST)
	@ResponseBody
	public Object getDeliveryResumeByIdOrList(Integer size, Integer current,Integer u_id, Integer d_state) {
		if (size == null) {
			size = 7;
		}
		if (current == null) {
			current = 1;
		}
		Page<AllMyDeliveryResume> pageo = new Page<AllMyDeliveryResume>(current, size);
		Page<AllMyDeliveryResume> listAllMyDeliveryResumes = 
				iAllMyDeliveryResumeService.getDeliveryResumeByIdOrList(pageo,u_id,d_state);
		return listAllMyDeliveryResumes.getSize() > 0 ? 
				renderSuccess(listAllMyDeliveryResumes) : renderError("暂无数据");
	}
	
	
}
