package com.test.redisTemplate;
/** 
* @ClassName: CallBackTest
* @Description: 
* @author 王逍遥
* @date 2018年8月1日 下午1:42:46 
*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import com.test.pojo.Role;

public class CallBackTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
		
		final Role role = new Role();
		role.setRoleName("heihei");
		SessionCallback<Role> callBack = new SessionCallback<Role>() {

			//通过SessionCallBack接口set/get在同一个redis连接中
			@Override
			public  Role execute(RedisOperations operations) throws DataAccessException {
				//把对象以string的形式存入redis
				//相当于redisTemplate.opsForValue().set("role_1", role);
				operations.boundValueOps("role_1").set(role);	
				return (Role) operations.boundValueOps("role_1").get();
			}
		};
		Role saveRole = (Role) redisTemplate.execute(callBack);
		System.out.println(saveRole.getRoleName());
	}
}
