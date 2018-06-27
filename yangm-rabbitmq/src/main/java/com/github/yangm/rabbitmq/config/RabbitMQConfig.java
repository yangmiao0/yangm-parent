package com.github.yangm.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.yangm.common.constant.Constant;

/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.rabbitmq.config 
 * @author: yangm
 * @date: 2018年6月27日 下午2:21:43 
 * @email：1169290944@qq.com
 */
@Configuration
public class RabbitMQConfig {

	/**
	 * this(name, true, false)
	 * 默认值持久化
	 * @return
	 */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(Constant.MQ_FANOUT_EXCHANGE);
    }
	
    /**
     * this(name, true, false, false)
     * @return
     */
    @Bean
    public Queue fanoutMessage() {
        return new Queue(Constant.MQ_FANOUT_QUEUE);
    }
    
    @Bean
    FanoutExchange orderExchange() {
        return new FanoutExchange(Constant.MQ_ORDER_EXCHANGE);
    }
	
    @Bean
    public Queue orderMessage() {
        return new Queue(Constant.MQ_ORDER_QUEUE);
    }
    
    /**
     * 绑定
     * @param AMessage
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue fanoutMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutMessage).to(fanoutExchange);
    }
    
    @Bean
    Binding bindingExchangeOrder(Queue orderMessage,FanoutExchange orderExchange) {
    	return BindingBuilder.bind(orderMessage).to(orderExchange);
    }
    
    /**
     * 采用Jackson序列化
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
	
}
