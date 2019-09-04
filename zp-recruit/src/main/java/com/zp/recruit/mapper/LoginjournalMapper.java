package com.zp.recruit.mapper;

import java.util.List;

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

	List<Loginjournal> getLoginjournal();

}
