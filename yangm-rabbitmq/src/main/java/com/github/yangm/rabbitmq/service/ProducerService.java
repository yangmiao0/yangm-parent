package com.github.yangm.rabbitmq.service;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.yangm.common.constant.Constant;
import com.github.yangm.common.entity.Book;

/**   
 * 
 * 功能描述：生产者
 * @Package: com.github.yangm.rabbitmq 
 * @author: yangm
 * @date: 2018年6月27日 下午3:27:44 
 * @email：1169290944@qq.com
 */
@Service
public class ProducerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;
	
    public void sendFanoutMsg() {
    	String sendMsg = "hello ";
        for (int i = 0; i < 10; i++) {
        	sendMsg = sendMsg + i;
        	System.out.println("sendFanoutMsg : " + sendMsg);
        	this.rabbitTemplate.convertAndSend(Constant.MQ_FANOUT_EXCHANGE,"", sendMsg);
		}
	}
    
    public void sendOrderMsg() {
    	Book book = new Book().setName("java编程").setDate(new Date());
    	System.out.println("sendOrderMsg : " + book.toString());
    	this.rabbitTemplate.convertAndSend(Constant.MQ_ORDER_EXCHANGE,"",book);
	}
    
}
