package com.zp.recruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zp.recruit.entity.Loginjournal;
import com.zp.recruit.mapper.LoginjournalMapper;
import com.zp.recruit.service.ILoginjournalService;

/**
 * <p>
 * 登录日志 服务实现类
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
@Service
public class LoginjournalServiceImpl extends ServiceImpl<LoginjournalMapper, Loginjournal> implements ILoginjournalService {

	@Autowired
	private LoginjournalMapper loginjournalMapper;
	
	@Override
	public List<Loginjournal> getLoginjournal(String starttime,String endtime) {
		List<Loginjournal> loginjournal = loginjournalMapper.getLoginjournal(starttime,endtime);
		return loginjournal;
	}

}
