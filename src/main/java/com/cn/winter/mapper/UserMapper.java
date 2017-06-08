package com.cn.winter.mapper;

import java.util.List;

import com.cn.winter.pojo.User;

public interface UserMapper {
	
    /**
     * 通过id查找用户
     * @param userId
     * @return
     */
    int deleteUserById(Integer userId);

    /**
     * 添加用户的所有属性
     * @param record
     * @return
     */
    int addAllPropertyUser(User record);

    /**
     * 根据需要添加用户信息
     * @param record
     * @return
     */
    int addUserSelective(User record);

    /**
     * @param userId
     * @return
     */
    User findUserById(Integer userId);

    /**
     * 根据需要更新用户信息
     * @param record
     * @return
     */
    int updateUserSelective(User record);

    /**
     * 更新用户的所有属性
     * @param record
     * @return
     */
    int updateAllPropertyUser(User record);
    
    /**
     * 查找所有的用户并分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> findAllUser(int pageNum, int pageSize);
    
    /**
     * 
     * 通过手机号查找用户，用于验证
     * @param phone
     * @return
     */
    User findUserByPhone(String phone);
}