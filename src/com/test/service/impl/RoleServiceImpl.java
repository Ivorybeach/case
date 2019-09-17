package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.mapper.RoleMapper;
import com.test.pojo.Role;
import com.test.service.RoleService;

/**
 * @ClassName: RoleMapper
 * @Description:
 * @author 王逍遥
 * @date 2018年7月12日 下午12:25:09
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public Role getRoleById(Long id) {
		Role role = roleMapper.getRole(id);
		return role;
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	@Override
	public int addRole(Role role) {
		roleMapper.addRole(role);
		return 0;
	}

	@Override
	public List<Role> findAll() {
		List<Role> roleList = roleMapper.findAll();
		return roleList;
	}
	
	//验证事务管理自调用失效
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRES_NEW)
	@Override
	public int insertRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			//当前方法调用同类下addRole()方法，产生自调用失效问题
			//在main中传递两个role实例，查看这两个inert role执行在同一个事务中
			//说明Propagation.REQUIRES_NEW失效
			count += this.addRole(role);
		}
		return count;
	}
}
