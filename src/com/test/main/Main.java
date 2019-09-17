package com.test.main;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.test.mapper.RoleMapper;
import com.test.pojo.Role;
import com.test.util.SqlSessionFactoryUtils;

public class Main {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		
		sqlSession=SqlSessionFactoryUtils.openSqlSession();
		//sqlSession获取mapper
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		//查询
		Role role = roleMapper.findRole("hehe","haha");
		//插入
		//Role role2 = new Role(11232343,"usernmdfd","nam994");
		//Mybatis会自动返回insert成功数
		//System.out.println(roleMapper.insertRole(role2));
		System.out.println(role.getNote()+"----------------");
		System.out.println(role.getRoleName()+"----------------");
		//业务结束后，关闭sqlSession
		sqlSession.close();
				
	}
	
}
