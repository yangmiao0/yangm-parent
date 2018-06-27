package com.github.yangm.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mybaits基本集成
 * @author yangm
 *
 */
@MapperScan("com.github.yangm.mybatis.dao")
@SpringBootApplication
public class MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
	
}
