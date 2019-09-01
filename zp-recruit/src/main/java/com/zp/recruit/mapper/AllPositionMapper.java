package com.zp.recruit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zp.recruit.entity.AllPosition;

/**
 * <p>
 * 职位 Mapper 接口
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public interface AllPositionMapper extends BaseMapper<AllPosition> {

	List<AllPosition> selectAllPositionList(Pagination page, @Param("p_state")Integer p_state,@Param("p_id")Integer p_id);

}
