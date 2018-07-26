package com.github.yangm.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
/**
 * 
 * 功能描述：
 * 
 * @Package: com.github.yangm.cloud.consumer
 * @author: yangm
 * @date: 2018年7月26日
 * @email：1169290944@qq.com
 */
//@EnableDiscoveryClient Finchley版已无需EnableEurekaClient和该注解
@EnableFeignClients(basePackages= {"com.github.yangm.cloud"})//添加扫描api类 否则无法启动
@ComponentScan("com.github.yangm.cloud")
@SpringBootApplication
public class CloudConsumerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CloudConsumerApplication.class, args);
	}
}
