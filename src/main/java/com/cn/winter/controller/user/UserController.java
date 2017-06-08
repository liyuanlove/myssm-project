package com.cn.winter.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.winter.controller.BaseController;
import com.cn.winter.pojo.User;
import com.cn.winter.service.user.UserService;

/**
 * 用户控制层
 * @author Administrator
 *
 */
@Controller("userController")
public class UserController extends BaseController{

	@Resource(name="userService")
	private UserService userService;
	
	
	/**
	 * 
	 * 进入主页
	 * @return
	 */
	@RequestMapping("/to_home_page")
	public String getHomePage(){
		return "/home_page";
	}
	
	/**
	 * 进入当前用户的个人中心页面
	 * @return
	 */
	@RequestMapping("/to_user_page")
	public String getUserPage(){
		return "/personal_center";
	}
	
	/**
	 * ajax异步获取用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/get_user_info")
	public Object getUserInfo(){
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		User u = userService.findUserById(user.getUserId());
		return u;
	}
	
	/**
	 * 
	 * 进入修改密码的页面
	 * @return
	 */
	@RequestMapping("/change_user_password")
	public String toChangePasswordPage(){
		return "/change_password";
	}
	
	/**
	 * 修改密码
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping("/change_password")
	public ModelAndView changePassword(String oldPassword, String newPassword){
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		User u = userService.findUserByPhone(user.getPhone());
		if(u.getPassword().equals(oldPassword)){
			ModelAndView mv = new ModelAndView();
			u.setPassword(newPassword);
			userService.updateUser(u);
			mv.addObject("data", "密码修改成功,请重新登录");
			mv.setViewName("forward:/login");
			return mv;
		}else{
			ModelAndView mv = new ModelAndView();
			mv.addObject("data", "原始密码错误，请重试");
			mv.setViewName("forward:/change_user_password");
			return mv;
		}
		
	}
	
	/**
	 * 进入新增账号的页面
	 * @return
	 */
	@RequestMapping("/add_user")
	public String toAddNewUserPage(){
		return "add_new_user";
	}
	
	/**
	 * 新添用户
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/to_add_user")
	public Map<String, Object> addNewUser(User user){
		
		Integer count = userService.addUser(user);
		if(count == null || count == 0){
			Map<String,Object> map = new HashMap<>();
			map.put("data", 202);
			return map;
		}else{
			Map<String,Object> map = new HashMap<>();
			map.put("data", 200);
			return map;
		}
	}
	
	/**
	 * 进入账号管理的页面
	 * @return
	 */
	@RequestMapping("/into_all_user_info")
	public String intoUserInfoPage(){
		return "control_user";
	}
	
	/**
	 * 获取所有的账号信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/get_all_user_info")
	public List<User> getAllUserInfo(){
		
		List<User> list = userService.findAllUser(1, 1000);
		
		return list;
	}
	
	/**
	 * 
	 * ajax异步修改用户密码
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/change_password_ajax")
	public Map<String, Object> changePasswordByAjax(User user){
		Map<String, Object> map = new HashMap<>();
		Integer count = userService.updateUser(user);
		if(count == 1)
			map.put("data1", 200);
		else
			map.put("data1", 202);
		
		return map;
	}
	
	/**
	 * 修改用户的权限
	 * @param user
	 */
	@ResponseBody
	@RequestMapping("/change_user_role")
	public Object changeUserRole(User user){
		Integer count = userService.updateUserRole(user);
		return count;
	}
	
	/**
	 * 更改用户的状态
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/change_user_status")
	public Object changeUserStatus(User user){
		return  userService.updateUserStatusByPhone(user);
	}
	
	@RequestMapping("/logout")
	public String userLogout(){
		this.request.getSession().invalidate();
		return "redirect:/login";
	}
	
}
