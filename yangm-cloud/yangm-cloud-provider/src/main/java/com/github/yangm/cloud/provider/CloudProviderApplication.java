package com.github.yangm.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * 功能描述：
 * 
 * @Package: com.github.yangm.cloud.eureka
 * @author: yangm
 * @date: 2018年7月26日
 * @email：1169290944@qq.com
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
public class CloudProviderApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CloudProviderApplication.class, args);
	}
}
