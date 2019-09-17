package com.test.redisTemplate;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class Pipeline {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
		SessionCallback callback = (RedisOperations ops) -> {
			for (int i = 0; i < 100000; i++) {
				int j = i + 1;
				ops.boundValueOps("pipeline_key"+j).set("pipeline_val"+j);
				ops.boundValueOps("pipeline_key"+j).get();
			}
			return null;
		};
		long start = System.currentTimeMillis();
		// 将返回结果统一储存在List中
		List<Object> result = redisTemplate.executePipelined(callback);
		long end = System.currentTimeMillis();
		System.out.println(result.size());
		// 大概在1秒钟左右返回100000结果
		System.out.println(end - start);
	}
}
