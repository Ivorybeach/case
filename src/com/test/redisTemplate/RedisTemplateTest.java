package com.test.redisTemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.test.pojo.Role;

public class RedisTemplateTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
		Role role = new Role(1L,"hahaguai");
		//存入数据,注意序列化器的选择，如果序列化器选择不对，不会报错，但数据不能写入redis
		redisTemplate.opsForValue().set("role", role); 
		redisTemplate.opsForValue().set("haha", "role");
		System.out.println(redisTemplate.opsForValue().get("key3"));
		//Role role_ = redisTemplate.opsForValue().get("role");
		System.out.println(redisTemplate.opsForValue().size("role"));
		//System.out.println(role_.getRoleName());
		applicationContext.close();
	}
	
}
