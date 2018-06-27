package com.github.yangm.rabbitmq.service;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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

	@RabbitListener(queues = Constant.MQ_FANOUT_QUEUE)
    public void fanoutMessage(Message message, Channel channel) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自fanoutMessage队列的消息：" + new String(message.getBody()));
        try {
        	Thread.sleep(100);
		} catch (Exception e) {
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
    public void orderMessage(Book book,Message message, Channel channel) {
        System.out.println(Thread.currentThread().getName() + " 接收到来自orderMessage队列的消息：" + book.toString());
        try {
        	Thread.sleep(100);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
