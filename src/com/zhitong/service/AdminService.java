package com.zhitong.service;

import com.zhitong.pojo.Admin;

public interface AdminService {

	//查询admin
	Admin selectAdmin(String adminName,String password);
	
	//添加
	int addAdmin(Admin admin);
	
	//更新admin
	int updateAdmin(Admin admin);
	
	int updatePicpath(String picpath,Long id);
}
