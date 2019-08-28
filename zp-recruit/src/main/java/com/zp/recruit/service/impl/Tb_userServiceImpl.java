package com.zp.recruit.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zp.recruit.entity.Tb_user;
import com.zp.recruit.mapper.Tb_userMapper;
import com.zp.recruit.service.ITb_userService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Tz
 * @since 2019-08-28
 */
@Service
public class Tb_userServiceImpl extends ServiceImpl<Tb_userMapper, Tb_user> implements ITb_userService {

}
