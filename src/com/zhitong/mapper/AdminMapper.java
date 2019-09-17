package com.zhitong.mapper;

import org.apache.ibatis.annotations.Param;

import com.zhitong.pojo.Admin;

public interface AdminMapper {

	//查询admin
	//这里的adminName和mapper.xml中admin_name的别名adminName对应
	Admin selectAdmin(@Param("adminName")String adminName,@Param("password")String password);
	
	//添加admin
	int addAdmin(Admin admin);

	//更新admin
	int updateAdmin(Admin admin);

	//存入图片路径
	int updatePicpath(@Param("picpath")String picpath,@Param("id")Long id);
}
