package com.zp.recruit.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.zp.recruit.entity.Loginjournal;

/**
 * <p>
 * 登录日志 服务类
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
public interface ILoginjournalService extends IService<Loginjournal> {

	List<Loginjournal> getLoginjournal();

}
