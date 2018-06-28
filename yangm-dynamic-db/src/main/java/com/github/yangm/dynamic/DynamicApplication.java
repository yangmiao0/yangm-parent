package com.github.yangm.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于注解的多数据源
 * 如果使用mybatisplus，可直接使用mybatisplus的多数据源
 * @author yangm
 *
 */
@SpringBootApplication
public class DynamicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicApplication.class, args);
	}
	
}
