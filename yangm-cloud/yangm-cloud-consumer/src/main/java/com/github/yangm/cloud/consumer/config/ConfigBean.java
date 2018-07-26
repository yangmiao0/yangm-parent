package com.github.yangm.cloud.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**   
 * 
 * 功能描述策略配置
 * @Package: com.github.yangm.cloud.consumer.config
 * @author: yangm
 * @date: 2018年7月26日
 * @email：1169290944@qq.com
 */

@Configuration
public class ConfigBean {
	@Bean //Feign 负载均衡算法
	public IRule myRule() {
		//return new RoundRobinRule();
		return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
		//return new RetryRule();//对选定的负载均衡策略机上重试机制
		
	}
	
	/*@Bean // Ribbon + RestTemplate模式
	@LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。 
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}*/
}
