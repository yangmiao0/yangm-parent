package com.github.yangm.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

/**
 * 
 * 功能描述：
 * 
 * @Package: com.github.yangm.mybatisplus.config
 * @author: yangm
 * @date: 2018年6月28日 上午10:05:23
 * @email：1169290944@qq.com
 */
@Configuration
@MapperScan("com.github.yangm.mybatisplus.dao")
public class MybatisPlusConfig {

	/*
	 * 分页插件，自动识别数据库类型
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}
