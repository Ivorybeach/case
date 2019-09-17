package com.test.jedis;

import redis.clients.jedis.Jedis;

//最简单的jedis连接redis
public class JedisTest {

	public static void main(String[] args) {
		//一个jedis对象代表一个连接
		Jedis jedis = new Jedis("192.168.1.111",6379);
		 int i = 0;
		 long start = System.currentTimeMillis();
		 while (true) {
			long end = System.currentTimeMillis();
			// 1秒钟写入次数
			if (end - start >= 1000) {
				break;
			}
			i ++;
			jedis.set("i", i+"");
		}
		 //输出每秒写入次数，这个有点少啊。。。。
		 System.out.println(i);
		 jedis.close();
	}

	
}
