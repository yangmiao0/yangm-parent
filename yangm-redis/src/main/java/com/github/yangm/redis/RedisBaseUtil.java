package com.github.yangm.redis;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**   
 * 
 * 功能描述：常用操作
 * 			异常可抛到业务层捕获
 * @Package: com.github.yangm.redis.RedisBaseUtil
 * @author: yangm
 * @date: 2018年6月27日 下午5:08:15 
 * @email：1169290944@qq.com
 */
@Repository
public class RedisBaseUtil<K, V> {

	private static final Logger log = LoggerFactory.getLogger(RedisBaseUtil.class);

    @Autowired
    private RedisTemplate<K, V> redisTemplate;
    /** Map */
    @Autowired
    private HashOperations<K,K,V> hashOperations;
    /** List */
    @Autowired
    private ListOperations<K, V> listOperations;
	/**
	 * 将k，v存入缓存
	 * 永久有效期
	 * 建议使用带有效期的方法
	 * @param key    key
	 * @param value  键值
	 */
	public void setToCache(K key, V value) {
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.opsForValue().set(key, value);
			log.debug("【存入缓存】,key={},value={},redisTimeCount={}," , key, value,(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("【存入缓存】出错,key=" + key + ",value=" + value+",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
	}

	/**
	 * 将k，v存入缓存
	 * 永久有效期
	 * 建议使用带有效期的方法
	 * @param key    key
	 * @param value  键值
	 */
	public void setToHashCache(K name,K key, V value) {
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.opsForHash().put(name, key, value);
			log.debug("【存入Hash缓存】,name={},key={},value={},redisTimeCount={}," ,name, key, value,(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("【存入Hash缓存】出错,name=" + name + ",key=" + key + ",value=" + value+",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
		
	}
	
	public V getFromCache(K key) {
		long startTime = System.currentTimeMillis();
		V v = null;
		try {
            v = this.redisTemplate.opsForValue().get(key);
			log.debug("【查询缓存】,key={},redisTimeCount={}," , key, (System.currentTimeMillis()-startTime));
			return v;
		} catch (Exception e) {
			log.error("【查询缓存】出错,key=" + key +",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
		return v;
	}

	/**
	 * 从redis的Hash上获取
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public V getFromHashCache(K name,K key) {
		long startTime = System.currentTimeMillis();
		V v = null;
		try {
            v = (V) this.redisTemplate.opsForHash().get(name, key);
			log.debug("【查询HASH缓存】,name={},key={},redisTimeCount={}," ,name, key, (System.currentTimeMillis()-startTime));
			return v;
		} catch (Exception e) {
			log.error("【查询HASH缓存】出错,name=" + name + "key=" + key +",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
		return v;
		
	}
	
	public void deleteFromCache(K key) {
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.delete(key);
			log.debug("【删除缓存】,key={},redisTimeCount={}," , key, (System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("【删除缓存】出错,key=" + key +",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
	}
	
	/**
	 * 删除HASH
	 * @param key
	 */
	public void deleteFromHashCache(K name,K key) {
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.opsForHash().delete(name, key);
			log.debug("【删除HASH缓存】,name={},key={},redisTimeCount={}," , name,key, (System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("【删除HASH缓存】出错,name=" + name + ",key=" + key +",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
	}
	
	/**
	 * 将数据存入缓存，设置有效秒数
	 * @param key           key
	 * @param value         键值
	 * @param expireTime	有效秒数
	 */
	public void setToCacheSeconds(K key, V value, long expireTime) {
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
			log.debug("【存入缓存Seconds】,key={},value={},seconds={},redisTimeCount={}," , key,value,expireTime,(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("【存入缓存Seconds】出错,key=" + key + ",value=" + value+",seconds="+expireTime+",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
		
	}
	
	/**
	 * 将数据存入缓存，设置有效天数
	 * 有效天数为redis_day_min、redis_day_max之间的随机整数
	 * @param key   key
	 * @param value 键值
	 * @param days	有效天数
	 */
	public void setToCacheDays(K key, V value, int days) {
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.opsForValue().set(key, value, days, TimeUnit.DAYS);
			log.debug("【存入缓存Days】,key={},value={},days={},redisTimeCount={}," , key,value,days,(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("【存入缓存Days】出错,key=" + key + ",value=" + value+",days="+days+",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
	}
	
	/**
	 * 设置有效秒数
	 * @param key           key
	 * @param value         键值
	 * @param expireTime	有效秒数
	 */
	public void setExpireSeconds(K key,long expireTime) {
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error("【设置key的有效期Seconds】出错,key=" + key + ",seconds="+expireTime+",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
		
	}
	
	/**
	 * 获取key的剩余有效期 分钟
	 * @param key           key
	 */
	public long getExpireMinutes(K key) {
		long startTime = System.currentTimeMillis();
		long reslut = 0l;
		try {
			reslut = this.redisTemplate.getExpire(key,TimeUnit.MINUTES);
		} catch (Exception e) {
			log.error("【获取key的剩余有效期Minutes】出错,key=" + key + ",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
		return reslut;
	}
	
	/**
	 * 发布订阅消息
	 * @param channel
	 * @param message
	 */
	public void sendMessage(String channel, V message){
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.convertAndSend(channel, message);
			log.debug("【发布订阅消息】,channel={},message={},days={},redisTimeCount={}," , channel,message,(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("【发布订阅消息】出错,channel=" + channel + ",message=" + message + ",redisTimeCount=" + (System.currentTimeMillis()-startTime), e);
		}
	}
	
	/**
	 * 设置有效期
	 * @param key
	 * @param expireTime
	 */
	public void setExpireTime(K key,Date expireTime) {
		long startTime = System.currentTimeMillis();
		try {
			this.redisTemplate.expireAt(key, expireTime);
			log.debug("【设置redis有效期】,key={},expireTime={},redisTimeCount={}",key,expireTime,(System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			log.error("【设置redis有效期】出错,key=" + key + ",expireTime=" + expireTime + ",redisTimeCount="
							+ (System.currentTimeMillis() - startTime), e);
		}
	}
	
	/**
	 * key累计计数
	 * @param key
	 * @param incr
	 */
	public long incrementFromCache(K key, int incr){
		long startTime = System.currentTimeMillis();
		long reslut = 0l;
		try {
			reslut = this.redisTemplate.opsForValue().increment(key, incr);
			log.debug("【redis累计增加】,key={},incr={},reslut={},redisTimeCount={}",key,incr,reslut,(System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			log.error("【redis累计增加】出错,key={},incr={},reslut={},redisTimeCount={}",key,incr,reslut,(System.currentTimeMillis() - startTime), e);
		}
		return reslut;
	}
	
	/**
	 * key累计计数
	 * @param key
	 * @param incr
	 */
	public long incrementFromHashCache(K name, K key, int incr){
		long startTime = System.currentTimeMillis();
		long reslut = 0l;
		try {
			reslut = this.redisTemplate.opsForHash().increment(name, key, incr);
			log.debug("【redis累计增加】,name={},key={},incr={},reslut={},redisTimeCount={}",name,key,incr,reslut,(System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			log.error("【redis累计增加】出错,name={},key={},incr={},reslut={},redisTimeCount={}",name,key,incr,reslut,(System.currentTimeMillis() - startTime), e);
		}
		return reslut;
	}
	
	/**
	 * redis并发设置值
	 * @param name
	 * @param key
	 * @param value
	 * @param expireTime
	 * @return
	 */
	public boolean setIfAbsentFromCache(K key, V value,long expireTime){
		long startTime = System.currentTimeMillis();
		boolean reslut = false;
		try {
			reslut = this.redisTemplate.opsForValue().setIfAbsent(key, value);
			if (reslut && expireTime > 0) {//设置有效期
				this.redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
			}
			log.debug("【redis累计增加】,key={},value={},reslut={},redisTimeCount={}",key,value,reslut,(System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			log.error("【redis累计增加】出错,key={},value={},reslut={},redisTimeCount={}",key,value,reslut,(System.currentTimeMillis() - startTime), e);
		}
		return reslut;
	}
	
    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     */
    public void setCacheList(K key, List<V> dataList) {

        listOperations.rightPushAll(key, dataList);
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public List<V> getCacheList(K key) {

        return listOperations.range(key, 0, -1);
    }

    /**
     * 缓存Map
     */
    public void setCacheMap(K key, Map<K, V> dataMap) {
        if (dataMap == null || dataMap.isEmpty()) {

            return;
        }

        hashOperations.putAll(key, dataMap);
    }

    /**
     * 获得缓存的Map
     */
    public Map<K, V> getCacheMap(K key) {

        return hashOperations.entries(key);
    }

}
