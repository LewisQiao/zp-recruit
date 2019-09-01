package com.zp.recruit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zp.recruit.entity.AllPosition;
import com.zp.recruit.mapper.AllPositionMapper;
import com.zp.recruit.service.IAllPositionService;

/**
 * <p>
 * 职位 服务实现类
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
@Service
public class AllPositionServiceImpl extends ServiceImpl<AllPositionMapper, AllPosition> implements IAllPositionService {

	@Autowired
	private AllPositionMapper allPositionMapper;
	
	@Override
	public Page<AllPosition> selectAllPositionList(Page<AllPosition> page, Integer p_state,Integer p_id) {
		page.setRecords(allPositionMapper.selectAllPositionList(page,p_state,p_id));
		return page;
	}

}
