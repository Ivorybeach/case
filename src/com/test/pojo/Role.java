package com.test.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@@Component会被扫描成一个bean,@Value注解依赖注入
@Component	
public class Role {

	@Value("hehe")
	private String name;
	@Value("haha")
	private String note;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
