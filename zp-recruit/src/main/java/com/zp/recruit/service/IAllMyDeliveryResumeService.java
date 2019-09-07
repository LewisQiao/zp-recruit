package com.zp.recruit.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.zp.recruit.entity.AllMyDeliveryResume;

/**
 * <p>
 * 用户投递简历表 服务类
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public interface IAllMyDeliveryResumeService extends IService<AllMyDeliveryResume> {
	
	
	Page<AllMyDeliveryResume> getDeliveryResumeByIdOrList(Page<AllMyDeliveryResume> pageo,Integer u_id, Integer d_state, String p_name, String m_myphone);

}
	