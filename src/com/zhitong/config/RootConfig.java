package com.zhitong.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;



//spring容器配置
@Configuration
@ComponentScan(value="com.zhitong.*")
@EnableTransactionManagement
public class RootConfig implements TransactionManagementConfigurer{

	private DataSource dataSource;
	
	//配置数据源,连接池默认使用tomcat提供的dbcp连接池，在tomcat-dbcp.jar中
	@Bean(name="dataSource")
	public DataSource initDataSource() {
		if (dataSource != null) {
			return dataSource;
		}
		Properties props = new Properties();
		props.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		props.setProperty("username", "root");
		props.setProperty("password", "csj0221");
		props.setProperty("url", "jdbc:mysql://localhost:3306/zhitong?characterEncoding=utf-8");
		try {
			dataSource=BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	//配置sqlSessionFactory
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean initSqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(initDataSource());
		//mybatis配置文件
		Resource resource = new ClassPathResource("/mybatis/mybatis-config.xml"); 
		sqlSessionFactory.setConfigLocation(resource);
		return sqlSessionFactory;
	}
	
	//配置mapper扫描
	@Bean
	public MapperScannerConfigurer initMapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setBasePackage("com.zhitong.mapper");
		msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return msc;
	}
	
	//配置注解事务管理器
	@Override
	@Bean(name="transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(initDataSource());
		return transactionManager;
	}
	
}
