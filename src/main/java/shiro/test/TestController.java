package shiro.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import shiro.mapper.CustomRoleDao;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	CustomRoleDao customRoleDao;
	
	@RequestMapping("/getAllRolesSn")
	@ResponseBody
	public ModelAndView getAllRolesSn() {
		ModelAndView mv = new ModelAndView();
		List<String> roles = customRoleDao.getAllRoleSn();
		for (String role : roles) {
			System.out.println(role);
		}
		mv.addObject("roles", roles);
		mv.setView(new MappingJackson2JsonView());
		return mv;
		
		
	}
	
}
