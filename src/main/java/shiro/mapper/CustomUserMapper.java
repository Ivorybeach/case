package shiro.mapper;

import org.apache.ibatis.annotations.Param;

import shiro.pojo.User;

public interface CustomUserMapper {

	//根据用户名获取对象
	public User queryUserByName(String user_name);
	
	//获得用户所有角色
	public String queryUserRole(String user_name);
	
	//登录
	public User getUser(@Param("user_name")String user_name,@Param("password")String password);
}
