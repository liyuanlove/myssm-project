package com.cn.winter.controller.login;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.winter.controller.BaseController;
import com.cn.winter.pojo.User;
import com.cn.winter.service.user.UserService;

@Controller("loginController")
public class LoginController extends BaseController{

	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value={"/","login"})
	public String toLoginInPage(){
		return "login/login";
	}
	
	
	@RequestMapping("/user_login")
	public ModelAndView toLogin(User user, String remember){
		
		
		
		//验证用户密码是否正确
		Integer flag = userService.findUserVerification(user);
		if(flag == null){
			ModelAndView mv = new ModelAndView();
			mv.addObject("data", "用户名不存在或密码错误");
			mv.setViewName("forward:/login");
			return mv;
		}else{	//成功登录(技术员)
			User u = userService.findUserByPhone(user.getPhone());
			this.request.getSession().setAttribute("userInfo", u);
			this.request.getSession().setAttribute("userRole", "technician");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/home_page");
			return mv;
		}
		
	}
	
}
