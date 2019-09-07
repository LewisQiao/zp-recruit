package com.zp.recruit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zp.recruit.entity.Loginjournal;

/**
 * <p>
 * 登录日志 Mapper 接口
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public interface LoginjournalMapper extends BaseMapper<Loginjournal> {

	List<Loginjournal> getLoginjournal(@Param("starttime")String starttime, @Param("endtime")String endtime);

}
