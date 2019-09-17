package com.test.redisTemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTemplateList {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

		// 删除链表
		redisTemplate.delete("list1");
		List<String> list = new ArrayList<>();
		list.add("node1");
		list.add("node2");
		// lpush key node，从左边批量添加数据
		redisTemplate.opsForList().leftPushAll("list1", list);
		// lindex key index
		System.out.println(redisTemplate.opsForList().index("list1", 0));
		// llen key，获取长度
		System.out.println(redisTemplate.opsForList().size("list1"));
		// rpush
		redisTemplate.opsForList().rightPush("list1", "node0");
		// rpop 从右边删除一个节点
		redisTemplate.opsForList().rightPop("list1");
		// lrange key start end 返回0,3链表内容
		redisTemplate.opsForList().range("list1", 0, 3);
	}
}
