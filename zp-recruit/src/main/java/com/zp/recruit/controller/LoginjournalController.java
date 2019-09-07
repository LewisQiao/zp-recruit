package com.zp.recruit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	 * @throws ParseException 
	 */
	@RequestMapping(value = "getLoginjournal" ,method = RequestMethod.POST)
	@ResponseBody
	public Object getLoginjournal(String starttime,String endtime) throws ParseException {
		if(starttime == null || starttime.equals("")) {
			Date now=new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse(dateFormat.format(now));
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(calendar.DATE,-10);//把日期往后增加一天.整数往后推,负数往前移动
			date=calendar.getTime(); 
			starttime = dateFormat.format(date);
		}if(endtime == null || endtime.equals("")) {
			Date now=new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        endtime = dateFormat.format(now);
		}
		List<Loginjournal> loginjournal = iLoginjournalService.getLoginjournal(starttime,endtime);
		return loginjournal.size() > 0 ? 
				renderSuccess(loginjournal) : renderError("暂无数据");
	}
	
}
