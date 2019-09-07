package com.zp.recruit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zp.recruit.entity.AllMyDeliveryResume;

/**
 * <p>
 * 用户投递简历表 Mapper 接口
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public interface AllMyDeliveryResumeMapper extends BaseMapper<AllMyDeliveryResume> {

	List<AllMyDeliveryResume> getDeliveryResumeByIdOrList(Pagination pageo,@Param("u_id")Integer u_id, @Param("d_state")Integer d_state,  @Param("p_name")String p_name,@Param("m_myphone")String m_myphone);

}
