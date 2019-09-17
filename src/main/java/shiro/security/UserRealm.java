package shiro.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import shiro.mapper.CustomRoleDao;
import shiro.pojo.User;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	CustomRoleDao customRoleDao;

	/**
	 * 提供用户信息返回权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		List<String> permissions = new ArrayList<String>();
		List<String> roles = new ArrayList<String>();

		if ("admin".equals(user.getUsername())) {
			// 拥有所有权限
			permissions.add("*:*");
			// 查询所有角色
			roles = customRoleDao.getAllRoleSn();
		} else {
			// 根据用户id查询该用户所具有的角色
			roles = customRoleDao.getRoleSnByUserId(user.getId());
			// 根据用户id查询该用户所具有的权限
			permissions = customRoleDao.getPermissionResourceByUserId(user.getId());
		}
		for (String role : roles) {
			System.err.println("打印roles信息");
			System.out.println("role："+role);
		}
		for (String permission : permissions) {
			System.err.println("打印permissions信息");
			System.out.println("permission："+permission);
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);
		info.addRoles(roles);
		return info;

	}

	//这个方法只是用来认证用户的，并不涉及任何roles,permission相关
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		
		// 从token中获取登录的用户名， 查询数据库返回用户信息
		String username = (String) authcToken.getPrincipal();
		User user = customRoleDao.getUserByUsername(username);
		if (user == null) {
			return null;
		} 
		String password = user.getPassword();
		// SimpleAuthenticationInfo中的第一个参数即为principle,这里是对象，也可以是string(username,id)
		// 第二个参数，credential为加密后的password,密码不加密会报错Odd number of characters.
		// 第三个参数为credentialsSalt
		// getName()对应的参数为realm_name，即UserRealm，在创建principleCollection时需要使用
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,
				ByteSource.Util.bytes(user.getUsername()), getName());
		return info;
	}
}
