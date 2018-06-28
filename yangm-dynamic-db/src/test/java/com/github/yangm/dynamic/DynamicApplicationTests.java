package com.github.yangm.dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.github.yangm.dynamic.dao.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicApplicationTests {

	private static Logger log = LoggerFactory.getLogger(DynamicApplicationTests.class);
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void contextLoads() {
		try {
			log.info(userMapper.getUserList().toString());
			log.info(userMapper.getSlaveDate().toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
