package com.zhitong.service;

import java.util.List;

import com.zhitong.pojo.Information;

public interface InfoService {
	
	int addInfo(Information info);
	
	//查询单条信息，用作测试
	Information getInfo(Information info);
	
	//查询所有
	List<Information> findAll();
}
