package com.zhitong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhitong.mapper.InfoMapper;
import com.zhitong.pojo.Information;
import com.zhitong.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService{

	@Autowired
	InfoMapper infoMapper;
	
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int addInfo(Information info) {
		return infoMapper.addInfo(info);
	}

	//查询单条信息，用作测试
	@Override
	public Information getInfo(Information info) {
		return infoMapper.getInfo(info);
	}

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public List<Information> findAll() {
		return infoMapper.findAll();
	}
	
	

}
