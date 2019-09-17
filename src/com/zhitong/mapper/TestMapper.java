package com.zhitong.mapper;

import com.zhitong.pojo.Information;

public interface TestMapper {

	//测试项目配置是否正常，能否成功连接数据库
	public Information findInfo();
	
}
