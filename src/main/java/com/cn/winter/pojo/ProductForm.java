package com.cn.winter.pojo;

import java.io.Serializable;
/*产品订单关联类*/
public class ProductForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//主键
    private Integer id;
    //总成编号
    private String assemblyId;
    //数量
    private String number;
    //单价
    private String price;
    //总价
    private String totalPrice;
    //缸径
    private String diameter;
    //客户产品编号
    private String customerProductId;
    //预留字段
    private String tags;
    //描述
    private String description;
    //上级订单编号
    private String orderFormId;
    //OE编号
    private String oeNumber;

    public ProductForm() {
		super();
	}

	

	public ProductForm(Integer id, String assemblyId, String number, String price, String totalPrice, String diameter,
			String customerProductId, String tags, String description, String orderFormId, String oeNumber) {
		super();
		this.id = id;
		this.assemblyId = assemblyId;
		this.number = number;
		this.price = price;
		this.totalPrice = totalPrice;
		this.diameter = diameter;
		this.customerProductId = customerProductId;
		this.tags = tags;
		this.description = description;
		this.orderFormId = orderFormId;
		this.oeNumber = oeNumber;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(String assemblyId) {
        this.assemblyId = assemblyId == null ? null : assemblyId.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter == null ? null : diameter.trim();
    }

    public String getCustomerProductId() {
        return customerProductId;
    }

    public void setCustomerProductId(String customerProductId) {
        this.customerProductId = customerProductId == null ? null : customerProductId.trim();
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

    public String getOrderFormId() {
        return orderFormId;
    }

    public void setOrderFormId(String orderFormId) {
        this.orderFormId = orderFormId == null ? null : orderFormId.trim();
    }
    

	public String getOeNumber() {
		return oeNumber;
	}



	public void setOeNumber(String oeNumber) {
		this.oeNumber = oeNumber;
	}



	@Override
	public String toString() {
		return "ProductForm [id=" + id + ", assemblyId=" + assemblyId + ", number=" + number + ", price=" + price
				+ ", totalPrice=" + totalPrice + ", diameter=" + diameter + ", customerProductId=" + customerProductId
				+ ", tags=" + tags + ", description=" + description + ", orderFormId=" + orderFormId + ", oeNumber="
				+ oeNumber + "]";
	}
}