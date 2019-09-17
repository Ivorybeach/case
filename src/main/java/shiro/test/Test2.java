package shiro.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shiro.mapper.CustomRoleDao;

public class Test2 {

	@Autowired
	static
	CustomRoleDao customRoleDao;
	
	public static void main(String[] args) {
		
		List<String> roles = customRoleDao.getAllRoleSn();
		for (String role : roles) {
			System.out.println(role);
		}
		
	}
	
}
