package com.zhitong.util;

import java.util.Random;

public class IdUtil {
	
	public static Long getId() {
		Long id;
		//获取三位随机数
		Random random = new Random();
		random.nextInt(999);
		id = random.nextInt(999)+System.currentTimeMillis();
		return id;
	}
}
