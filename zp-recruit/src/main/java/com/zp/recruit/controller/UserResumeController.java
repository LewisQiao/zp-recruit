package com.zp.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.recruit.entity.Tb_resume;
import com.zp.recruit.service.ITb_resumeService;

/***
 * 用户添加微简历
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userResume/")
@CrossOrigin
public class UserResumeController extends BaseController{
	
	@Autowired
	private ITb_resumeService iTb_resumeService;
	
	/***
	 * 根据用户ID查询自己的微简历
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "getResumeByUid", method = RequestMethod.POST)
	@ResponseBody
	public Object getResumeByUid(Integer uid) {
		Tb_resume tbresume = iTb_resumeService.selectById(uid);
		return null != tbresume ? 
				renderSuccess(tbresume) : renderError("暂无数据");
	}
	
	/***
	 * 添加修改用户微简历
	 * 添加时需要传用户uid
	 * @param tb_resume
	 * @return
	 */
	@RequestMapping(value = "insertOrUpdateResumeByUid", method = RequestMethod.POST)
	@ResponseBody
	public Object insertOrUpdateResumeByUid(Tb_resume tb_resume) {
		boolean bool = iTb_resumeService.insertOrUpdate(tb_resume);
		return false != bool ? 
				renderSuccess("成功") : renderError("失败");
	}

}
