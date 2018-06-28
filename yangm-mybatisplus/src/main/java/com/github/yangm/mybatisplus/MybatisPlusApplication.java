package com.github.yangm.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

/**
 * mybaits基本集成
 * @author yangm
 *
 */
@MapperScan("com.github.yangm.mybatis.dao")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)//排除原生Druid的快速配置类
public class MybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusApplication.class, args);
	}
	
}
