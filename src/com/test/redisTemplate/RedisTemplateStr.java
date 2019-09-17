package com.test.redisTemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.test.pojo.Role;

//redistemplate操作字符串
public class RedisTemplateStr {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
		
		//设置内容：set
		redisTemplate.opsForValue().set("key1", "val1");
		redisTemplate.opsForValue().set("key2", "val2");
		//获取长度：strlent
		redisTemplate.opsForValue().size("key2");
		//修改value,返回旧值：getset
		redisTemplate.opsForValue().getAndSet("key2", "value2");
		//删除key：返回操作成功数
		//redisTemplate.delete("key1");
		//追加字符串到末尾，返回新串长度：append
		redisTemplate.opsForValue().append("key1", "zzzd");
		//如果要存储对象，valueSerilizer需要使用JdkSerializationRedisSerializer;但会出现中文乱码。。。。
		Role role = new Role(1L,"hehe");
		redisTemplate.opsForValue().set("role", role);
		applicationContext.close();
		
	}
}
