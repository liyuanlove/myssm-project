package com.cn.winter.pojo;

import java.io.Serializable;

/** 用户实例对象*/
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//用户编号
    private Integer userId;
    //用户名称
    private String userName;
    //创建时间
    private String createTime;
    //用户状态 0:申请 1:正常 2:冻结 3：删除
    private Integer userStatus;
    //密码
    private String password;
    //手机号码  登录使用 唯一
    private String phone;
    //角色名称
    private Integer roldId;

    public User() {
		super();
	}

	public User(Integer userId, String userName, String createTime, Integer userStatus, String password, String phone,
			Integer roldId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.createTime = createTime;
		this.userStatus = userStatus;
		this.password = password;
		this.phone = phone;
		this.roldId = roldId;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getRoldId() {
        return roldId;
    }

    public void setRoldId(Integer roldId) {
        this.roldId = roldId;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", createTime=" + createTime + ", userStatus="
				+ userStatus + ", password=" + password + ", phone=" + phone + ", roldId=" + roldId + "]";
	}
}