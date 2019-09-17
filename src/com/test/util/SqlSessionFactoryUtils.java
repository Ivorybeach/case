package com.test.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//用于构建SqlSessionFactory的工具类
public class SqlSessionFactoryUtils {

	private static SqlSessionFactory sqlSessionFactory=null;
	
	//采用单例模式去构建
	private SqlSessionFactoryUtils(){}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory!=null) {
			return sqlSessionFactory;
		}
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
	
	//单例模式中提供对外反问的接口
	public static SqlSession openSqlSession() {
		if (sqlSessionFactory==null) {
			getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	} 
}
