package com.github.yangm.rabbitmq.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.github.yangm.common.constant.Constant;
import com.github.yangm.common.entity.Book;
import com.rabbitmq.client.Channel;

/**   
 * 
 * 功能描述：消费者
 * @Package: com.github.yangm.rabbitmq 
 * @author: yangm
 * @date: 2018年6月27日 下午3:27:01 
 * @email：1169290944@qq.com
 */
@Service
public class ConsumerService {

	private static final Logger log = LoggerFactory.getLogger(ConsumerService.class);
	
	@RabbitListener(queues = Constant.MQ_FANOUT_QUEUE)
    public void fanoutMessage(Message message, Channel channel) {
		log.info(Thread.currentThread().getName() + " 接收到来自fanoutMessage队列的消息：" + new String(message.getBody()));
        try {
        	Thread.sleep(100);
		} catch (Exception e) {
			//可放入异常队列记录
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//发送ack
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
	
	@RabbitListener(queues = Constant.MQ_ORDER_QUEUE)
    public void orderMessage(Book book,@Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,Channel channel) {
		log.info(Thread.currentThread().getName() + " 接收到来自orderMessage队列的消息：" + book.toString());
        try {
        	Thread.sleep(100);
		} catch (Exception e) {
			//可放入异常队列记录
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				channel.basicAck(deliveryTag, false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    }
	
}
