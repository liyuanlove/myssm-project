package com.cn.winter.pojo;

import java.io.Serializable;
/** 发货实例对象*/
public class Shipments implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//主键
    private Integer id;
    //发货记录录入人
    private String userId;
    //总成编号
    private String partId;
    //数量
    private String number;
    //发货时间
    private String outTime;
    //客户零件编号
    private String customerId;
    //用户名称
    private String customerName;
    //国家
    private String country;
    //信息
    private String desc;
    //预留字段
    private String tags;
    //价格
    private String totalPrice;
    

    public Shipments() {
		super();
	}
    

	public Shipments(Integer id, String userId, String partId, String number, String outTime, String customerId,
			String customerName, String country, String desc, String tags, String totalPrice) {
		super();
		this.id = id;
		this.userId = userId;
		this.partId = partId;
		this.number = number;
		this.outTime = outTime;
		this.customerId = customerId;
		this.customerName = customerName;
		this.country = country;
		this.desc = desc;
		this.tags = tags;
		this.totalPrice = totalPrice;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId == null ? null : partId.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime == null ? null : outTime.trim();
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }


	@Override
	public String toString() {
		return "Shipments [id=" + id + ", userId=" + userId + ", partId=" + partId + ", number=" + number + ", outTime="
				+ outTime + ", customerId=" + customerId + ", customerName=" + customerName + ", country=" + country
				+ ", desc=" + desc + ", tags=" + tags + ", totalPrice=" + totalPrice + "]";
	}
    
}