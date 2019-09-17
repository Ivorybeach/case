package shiro.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher{

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		// TODO Auto-generated method stub
		Object tokenCredentials = getCredentials(token);
        Object accountCredentials = getCredentials(info);
		return super.equals(tokenCredentials, accountCredentials);
	}

	//自定义实现密码匹配
	
	
	
}
