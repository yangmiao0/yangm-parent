package com.github.yangm.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.yangm.mybatis.dao.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	UserMapper userMapper;
	
	@Test
	public void contextLoads() {
		try {
			System.out.println(userMapper.getUserList().toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
