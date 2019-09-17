package shiro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shiro.pojo.User;

public interface CustomRoleDao {

	//查询所有roles
	List<String> getAllRoleSn();
	
	//根据用户id查询roles
	List<String> getRoleSnByUserId(Long userId);

	//根据用户id查询permission
	List<String> getPermissionResourceByUserId(Long userId);
	
	//登录，根据username查询用户
	User getUserByUsername(String username);
	
	//注册
	int insertUser(@Param("username")String username,@Param("password")String password);
}
