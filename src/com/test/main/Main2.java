package com.test.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.JavaConfig;
import com.test.pojo.Role;

//使用anno springIoC容器
public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		Role role = ctx.getBean(Role.class);
		System.out.println(role.getName()+"--------------");
		System.out.println(role.getNote()+"--------------");
		ctx.close();
	}
	
}
