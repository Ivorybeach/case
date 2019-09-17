package com.zhitong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhitong.mapper.AdminMapper;
import com.zhitong.pojo.Admin;
import com.zhitong.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public Admin selectAdmin(String adminName, String password) {
		return adminMapper.selectAdmin(adminName, password);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public int addAdmin(Admin admin) {
		return adminMapper.addAdmin(admin);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public int updateAdmin(Admin admin) {
		return adminMapper.updateAdmin(admin);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public int updatePicpath(String picpath,Long id) {
		return adminMapper.updatePicpath(picpath,id);
	}
	
	

}
