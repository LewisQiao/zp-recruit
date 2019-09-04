package com.zp.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.recruit.entity.Loginjournal;
import com.zp.recruit.service.ILoginjournalService;

/***
 * 统计
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/loginjournal/")
public class LoginjournalController extends BaseController{

	@Autowired
	private ILoginjournalService iLoginjournalService;
	
	/***
	 * 统计访问量
	 * @return
	 */
	@RequestMapping(value = "getLoginjournal" ,method = RequestMethod.POST)
	@ResponseBody
	public Object getLoginjournal() {
		List<Loginjournal> loginjournal = iLoginjournalService.getLoginjournal();
		return loginjournal.size() > 0 ? 
				renderSuccess(loginjournal) : renderError("暂无数据");
	}
	
}
