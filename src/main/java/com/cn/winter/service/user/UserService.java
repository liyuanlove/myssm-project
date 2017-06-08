package com.cn.winter.service.user;

import java.util.List;

import com.cn.winter.pojo.User;

/**
 * 用户service层
 * @author cdh
 *
 */
public interface UserService {

	/**
	 * 添加用户（权限必须是总经理）
	 * @param user
	 * @return
	 */
	Integer addUser(User user);
	
	/**
	 * 删除或者冻结用户
	 * @param id
	 * @param status	3删除还是2冻结
	 * @return
	 */
	Integer deleteUserById(Integer id, Integer status);
	
	
	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);
	
	/**
	 * 
	 * 查找所有的用户
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<User> findAllUser(int pageNum, int pageSize);
	
	/**
	 * 查找手机是否存在
	 * @param phone
	 * @return
	 */
	boolean findUserPhoneExist(String phone);
	
	/**
	 * 
	 * 根据用户的id查找用户的角色
	 * @param userId
	 * @return
	 */
	String findUserAuthorityByUserId(Integer userId);
	
	/**
	 * 
	 * 通过id查找用户
	 * @param userId
	 * @return
	 */
	User findUserById(Integer userId);
	
	/**
	 * 用户登录验证
	 * @param user
	 * @return 
	 */
	Integer findUserVerification(User user);
	
	/**
	 * 
	 * 根据手机号码查找用户
	 * @param phone
	 * @return
	 */
	User findUserByPhone(String phone);
	
	/**
	 * 修改用户角色
	 * @param user
	 * @return
	 */
	Integer updateUserRole(User user);
	
	/**
	 * 通过phone修改用户状态
	 * @param user
	 * @return
	 */
	Integer updateUserStatusByPhone(User user);
}
