package com.cn.winter.pojo;

import java.io.Serializable;

/* 客户类 */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//主键
    private Integer id;
    //用户编号
    private String customerId;
    //客户名称
    private String customerName;
    //客户国家
    private String country;
    //客户email
    private String email;
    //状态 0:删除 1：正常
    private String tags;
    //描述
    private String description;
    

    public Customer() {
		super();
	}

	public Customer(Integer id, String customerId, String customerName, String country, String email, String tags,
			String description) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.country = country;
		this.email = email;
		this.tags = tags;
		this.description = description;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerId=" + customerId + ", customerName=" + customerName + ", country="
				+ country + ", email=" + email + ", tags=" + tags + ", description=" + description + "]";
	}
}