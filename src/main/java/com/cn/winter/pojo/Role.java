package com.cn.winter.pojo;

import java.io.Serializable;
/** 角色表*/
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//主键
    private Integer roleId;
    //角色名称：0：仓库管理员 1：技术员 2：总经理 3：超级管理员
    private String roleName;
    
    

    public Role() {
		super();
	}
    

	public Role(Integer roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}


	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }


	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
    
}