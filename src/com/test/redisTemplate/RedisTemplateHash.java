package com.test.redisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTemplateHash {
	
	public static void main(String[] args) {
		
	
	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
	
	String key = "role_2";
	Map<String, String> map = new HashMap<>();
	map.put("field1", "val1");
	map.put("field2", "val2");
	// 将map存入hash
	redisTemplate.opsForHash().putAll(key, map);
	// hget key field
	System.out.println(redisTemplate.opsForHash().get("role_2", "field1"));
	// hkeys key
	redisTemplate.opsForHash().keys("role_2");
	// hmset key field value
	redisTemplate.opsForHash().put("role_2", "note", "note");
	// hgetall
	redisTemplate.opsForHash().entries("role_2");
	
	
	}
}