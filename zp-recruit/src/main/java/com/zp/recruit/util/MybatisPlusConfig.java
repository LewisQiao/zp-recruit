package com.zp.recruit.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

@Component
public class MybatisPlusConfig {
	
	
	/**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
