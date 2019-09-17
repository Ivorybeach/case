package shiro.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shiro.mapper.CustomRoleDao;
import shiro.pojo.User;
import shiro.util.PasswordHelper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	CustomRoleDao customRoleDao;

	@RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
		PasswordHelper ph = new PasswordHelper();
		UsernamePasswordToken token = new UsernamePasswordToken(username, ph.encryptPassword(password));
		//打印token信息
		System.err.println("开始打印token信息");
		System.err.println(token.getUsername());
		System.err.println(token.getPassword());
		System.err.println(token.getCredentials());
		System.err.println(token.getPrincipal());
		
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        try {
        	//在调用login()方法前，会调用UserRealm中的AuthenticationInfo()
            subject.login(token);
            System.out.println(subject.isAuthenticated());
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "password error!");
            return mv;
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "username error!");
            return mv;
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "times error");
            return mv;
        } 
        catch (AuthenticationException ae) {
        	// 捕获其他异常
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "AuthenticationException error");
            return mv;
		}
        User user = customRoleDao.getUserByUsername(username);
        subject.getSession().setAttribute("user", user);
        return new ModelAndView("success");
    }

	@RequestMapping("/regist")
	public String regist(String username,String password) {
		PasswordHelper ph = new PasswordHelper();
		String newpass = ph.encryptPassword(password);
		System.err.println(newpass);
		customRoleDao.insertUser(username, newpass);
		return "success";
	}
	
	
	
	
	
	@RequestMapping("/{page}")
	public String page(@PathVariable String page,HttpServletResponse res) {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		return page;
	}

}
