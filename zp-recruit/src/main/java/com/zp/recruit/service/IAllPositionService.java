package com.zp.recruit.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.zp.recruit.entity.AllPosition;

/**
 * <p>
 * 职位 服务类
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public interface IAllPositionService extends IService<AllPosition> {

	Page<AllPosition> selectAllPositionList(Page<AllPosition> page, Integer p_state,Integer p_id, Integer w_id, String p_name);

}
