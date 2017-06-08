package com.cn.winter.service.user.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.winter.mapper.RoleMapper;
import com.cn.winter.mapper.UserMapper;
import com.cn.winter.pojo.Role;
import com.cn.winter.pojo.User;
import com.cn.winter.service.user.UserService;
import com.cn.winter.utils.DateUtil;
import com.cn.winter.utils.StringUtil;
import com.github.pagehelper.PageHelper;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	UserMapper userMapper;
	@Resource
	RoleMapper roleMapper;

	public Integer addUser(User user) {
		if(user == null)
			return null;
		
		try {
			boolean flag = findUserPhoneExist(user.getPhone());
			if(flag){	//如果手机没有注册才可以进行使用
				String password = user.getPassword();
				String md5Password = StringUtil.md5(password);
				user.setPassword(md5Password);
				user.setCreateTime(DateUtil.format(new Date()));
				user.setUserStatus(1);
				Integer count = userMapper.addUserSelective(user);
				return count;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Integer deleteUserById(Integer id, Integer status) {
		
		if(id == null)
			return 0;
		if(status == null)
			return 0;
		
		//查找用户
		try {
			
			User user = userMapper.findUserById(id);
			if(user != null){
				user.setUserStatus(status);
				userMapper.updateUserSelective(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public Integer updateUser(User user) {
		
		if(user == null)
			return 0;
		
		try {
			User u = userMapper.findUserByPhone(user.getPhone());
			user.setUserId(u.getUserId());
			String password = user.getPassword();
			user.setPassword(password);
			Integer count = userMapper.updateUserSelective(user);
			
			return count;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<User> findAllUser(int pageNum, int pageSize) {
		
		try {
			
			PageHelper.startPage(pageNum, pageSize);
			List<User> list = userMapper.findAllUser(pageNum, pageSize);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean findUserPhoneExist(String phone) {
		
		if(phone == null)
			return false;
		
		try {
			
			User user = userMapper.findUserByPhone(phone);
			if(user == null)
				return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String findUserAuthorityByUserId(Integer userId) {
		
		if(userId == null)
			return null;
		
		try {
			
			User user = userMapper.findUserById(userId);
			Integer roleId = user.getRoldId();
			Role role = roleMapper.findRoleById(roleId);
			String roleName = role.getRoleName();
			return roleName;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findUserById(Integer userId) {
		
		if(userId == null)
			return null;
		try {
			
			User user = userMapper.findUserById(userId);
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public Integer findUserVerification(User user) {
		
		if(user == null)
			return null;
		
		User u = userMapper.findUserByPhone(user.getPhone());
		
		if(u == null){
			return null;
		}
			
		
		if(u.getPassword().equals(user.getPassword()) && u.getUserStatus() == 1){
			
			return u.getRoldId();
			
		}
		
		return null;
	}
	
	@Override
	public User findUserByPhone(String phone) {
		
		if(phone == null)
			return null;
		
		try {
			
			User user = userMapper.findUserByPhone(phone);
			if(user != null)
				return user;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Integer updateUserRole(User user) {
		if(user == null)
			return 0;
		
		try {
			User u = userMapper.findUserByPhone(user.getPhone());
			user.setUserId(u.getUserId());
			Integer count = userMapper.updateUserSelective(user);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Integer updateUserStatusByPhone(User user) {
		if(user == null)
			return 0;
		
		try {
			
			User u = userMapper.findUserByPhone(user.getPhone());
			user.setUserId(u.getUserId());
			user.setUserStatus(user.getUserStatus());
			Integer count = userMapper.updateUserSelective(user);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
