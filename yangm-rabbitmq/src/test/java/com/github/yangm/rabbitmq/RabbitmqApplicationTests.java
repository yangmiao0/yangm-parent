package com.github.yangm.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.yangm.rabbitmq.service.ProducerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Autowired
	ProducerService producerService;
	
	@Test
	public void contextLoads() {
		
		//producerService.sendFanoutMsg();
		producerService.sendOrderMsg();
	}

}
