package com.zp.recruit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zp.recruit.entity.AllMyDeliveryResume;
import com.zp.recruit.mapper.AllMyDeliveryResumeMapper;
import com.zp.recruit.service.IAllMyDeliveryResumeService;

/**
 * <p>
 * 用户投递简历表 服务实现类
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
@Service
public class AllMyDeliveryResumeServiceImpl extends ServiceImpl<AllMyDeliveryResumeMapper, AllMyDeliveryResume> implements IAllMyDeliveryResumeService {

	@Autowired
	private AllMyDeliveryResumeMapper allMyDeliveryResumeMapper;
	
	@Override
	public Page<AllMyDeliveryResume> getDeliveryResumeByIdOrList(Page<AllMyDeliveryResume> pageo,Integer u_id, Integer d_state) {
		pageo.setRecords(allMyDeliveryResumeMapper.getDeliveryResumeByIdOrList(pageo,u_id,d_state));
		return pageo;
	}

}
