package com.test.redisTemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.Jedis;

public class RedisTemplateLua {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
		// jedis连接
		Jedis jedis = (Jedis) redisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		//
		String retVal = (String) jedis.eval("return 'hehe'");
		System.out.println(retVal);
		//注意加上逗号
		jedis.eval("redis.call('set',KEYS[1],ARGV[1])", 1, "lua-key", "lua-value");
		System.out.println(jedis.get("lua-key"));
		//缓存脚本不执行，返回脚本签名
		String sha = jedis.scriptLoad("redis.call('set',KEYS[1],ARGV[1])");
		System.out.println(sha);
		//根据签名，执行缓存脚本
		jedis.evalsha(sha,1,new String[]{"hehe","haha"});
		System.out.println(jedis.get("hehe"));
	}

}
