package com.cn.winter.mapper;

import com.cn.winter.pojo.Role;

public interface RoleMapper {
	
    /**
     * 根据id删除角色(不适用)
     * @param roleId
     * @return
     */
    int deleteRoleById(Integer roleId);

    /**
     * 添加Role  满足所有属性
     * @param record
     * @return
     */
    int addAllPropertyRole(Role record);

    /**
     * 添加角色
     * @param record
     * @return
     */
    int addRole(Role record);

    /**
     * 根据id查找角色
     * @param roleId
     * @return
     */
    Role findRoleById(Integer roleId);

    /**
     * 有选择性的根据Id更新角色
     * @param record
     * @return
     */
    int updateRoleByIdSelective(Role record);

    /**
     * 根据Id更新角色
     * @param record
     * @return
     */
    int updateRoleById(Role record);
}