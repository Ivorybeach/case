package com.zhitong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhitong.mapper.TestMapper;
import com.zhitong.pojo.Information;
import com.zhitong.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestMapper testMapper;
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRES_NEW)
	public Information findInfo() {
		return testMapper.findInfo();
	}

}
