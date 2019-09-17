package com.test.jedis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
	
	public static void main(String[] args) {
		//连接池配置
		//不需要进行任何具体配置，JedisPoolConfig内部默认实现配置
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		//最大空闲数
		poolConfig.setMaxIdle(500);
		//最大连接数
		poolConfig.setMaxTotal(100);
		//最大等待时间
		poolConfig.setMaxWaitMillis(20000);
		//创建jedis pool
		JedisPool jedisPool = new JedisPool(poolConfig,"192.168.43.11");
		//从连接池中获取一个连接
		Jedis jedis = jedisPool.getResource();
		jedis.set("qqq", "ppp");
		jedisPool.close();
	}
}
