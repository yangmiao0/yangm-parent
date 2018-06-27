package com.github.yangm.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 功能描述：
 * 
 * @Package: com.github.yangm.rabbitmq
 * @author: yangm
 * @date: 2018年6月27日 下午2:26:51
 * @email：1169290944@qq.com
 */
@EnableRabbit //开启基于注解的RabbitMQ模式
@SpringBootApplication
public class RabbitmqApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}
	
}
