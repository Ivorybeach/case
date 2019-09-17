package shiro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shiro.mapper.CustomRoleDao;
import shiro.mapper.CustomUserMapper;
import shiro.pojo.User;

/**
 * 对角色、权限进行测试
 * @author 王逍遥
 *
 */
@Controller
public class AccessController {
	
	@Autowired
	CustomRoleDao customRoleDao;
	
	//只有具备admin角色的用户可以访问，验证不通过返回accessDenied页面
	@RequestMapping("/admin")
	public String admin() {
		ModelAndView mv = new ModelAndView();
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute("user");
		//查询用户拥有的角色
		List<String> roles = customRoleDao.getRoleSnByUserId(user.getId());
		for (String role : roles) {
			System.out.println(role);
		}
		mv.addObject("roles", roles);
		//查询用户拥有的权限
		List<String> pers = customRoleDao.getPermissionResourceByUserId(user.getId());
		for (String role : roles) {
			System.out.println(role);
		}
		mv.addObject("roles", roles);
		mv.addObject("pers", pers);
		return "admin";
	}
	
	//角色admin,权限access可以访问
	@RequestMapping("/adminAccess")
	@RequiresPermissions(value="admin:access")
	public String adminAccess() {
		
		return "adminAccess";
	}
	
	
	//权限不足返回页面
	@RequestMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}

}
