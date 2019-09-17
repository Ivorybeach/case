package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.pojo.Source;

public class Main {
	
	public static void main(String[] args) {
		
		//以xml的方式初始化spring容器
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-cfg.xml");
		Source source = applicationContext.getBean(Source.class);
		System.out.println(source.getFruit());
		applicationContext.close();
	}
	
	
}
