package com.zhitong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhitong.pojo.Information;

public interface InfoMapper {

	int addInfo(Information info);
	
	//查询单条信息，用作测试
	Information getInfo(Information info);
	
	//查询所有
	List<Information> findAll();
	
	//分页查询
	List<Information> findAllByPage(@Param("currentPage")int currentPage,@Param("pageCount")int pageCount);
	//获取记录总数
	int getCount();
	
}
