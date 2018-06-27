package com.github.yangm.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.yangm.redis.RedisBaseUtil;

/**   
 * 
 * 功能描述：redis实现分布式锁案例
 * 			极限情况会出现如下问题
 * 				1、 key设值成功后，过期时间设值失败
 * 				2、当前线程业务任务未执行完成，但锁过期，导致另一个线程开始执行
 * 				等
 * @Package: com.github.yangm.redis.service 
 * @author: yangm
 * @date: 2018年6月27日 下午5:08:15 
 * @email：1169290944@qq.com
 */
@Service
public class RedisService {

	private static final Logger log = LoggerFactory.getLogger(RedisService.class);
	
	@Autowired
	RedisBaseUtil<String,Object> redisBaseUtil;
	
	public void redisService() {
		for (int i = 0; i < 5; i++) {
			//对key加10秒的锁
			if(redisBaseUtil.setIfAbsentFromCache("redis_key", "简单的分布式锁", 10)) {
				log.info("key不存在，设值成功");
			}else {
				log.info("key已存在");
			}
			if(i == 2 ) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
