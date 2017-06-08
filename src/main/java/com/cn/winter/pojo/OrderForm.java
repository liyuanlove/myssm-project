package com.cn.winter.pojo;

import java.io.Serializable;

/* 订单类 */
public class OrderForm  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//主键
    private Integer id;
    //订单编号
    private String orderFromId;
    //用户编号
    private String customerId;
    //订单创建时间
    private String createTime;
    //用户名称
    private String customerName;
    //订单预定开始时间
    private String startTime;
    //订单预定结束时间
    private String endTime;
    //订单状态 0：删除 1：正常 2：已发货 3：撤销
    private String orderStatus;
    //预留字段
    private String tags;
    //描述
    private String description;
    //真实发货时间
    private String outTime;
    //总价格
    private String totalPrices;

    public OrderForm() {
		super();
	}

	

	public OrderForm(Integer id, String orderFromId, String customerId, String createTime, String customerName,
			String startTime, String endTime, String orderStatus, String tags, String description, String outTime,
			String totalPrices) {
		super();
		this.id = id;
		this.orderFromId = orderFromId;
		this.customerId = customerId;
		this.createTime = createTime;
		this.customerName = customerName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.orderStatus = orderStatus;
		this.tags = tags;
		this.description = description;
		this.outTime = outTime;
		this.totalPrices = totalPrices;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderFromId() {
        return orderFromId;
    }

    public void setOrderFromId(String orderFromId) {
        this.orderFromId = orderFromId == null ? null : orderFromId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
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

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime == null ? null : outTime.trim();
    }
    
    public String getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(String totalPrices) {
        this.totalPrices = totalPrices == null ? null : totalPrices.trim();
    }

	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", orderFromId=" + orderFromId + ", customerId=" + customerId + ", createTime="
				+ createTime + ", customerName=" + customerName + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", orderStatus=" + orderStatus + ", tags=" + tags + ", description=" + description + ", outTime="
				+ outTime + ", totalPrices=" + totalPrices + "]";
	}
}