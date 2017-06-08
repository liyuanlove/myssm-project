package com.cn.winter.pojo;

import java.io.Serializable;
/* 客户编号对照表 */
public class ProductNumContrast implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//主键
    private Integer id;
    //公司总成编号
    private String assemblyId;
    //客户产品编号
    private String customerProId;
    //客户编号（唯一）
    private String customerId;
    //预留字段
    private String tags;
    //描述
    private String description;
    //OE编号
    private String oeNumber;
    
    public ProductNumContrast() {
		super();
	}

	public ProductNumContrast(Integer id, String assemblyId, String customerProId, String customerId, String tags,
			String description, String oeNumber) {
		super();
		this.id = id;
		this.assemblyId = assemblyId;
		this.customerProId = customerProId;
		this.customerId = customerId;
		this.tags = tags;
		this.description = description;
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

    public String getCustomerProId() {
        return customerProId;
    }

    public void setCustomerProId(String customerProId) {
        this.customerProId = customerProId == null ? null : customerProId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
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

    public String getOeNumber() {
        return oeNumber;
    }

    public void setOeNumber(String oeNumber) {
        this.oeNumber = oeNumber == null ? null : oeNumber.trim();
    }

	@Override
	public String toString() {
		return "ProductNumContrast [id=" + id + ", assemblyId=" + assemblyId + ", customerProId=" + customerProId
				+ ", customerId=" + customerId + ", tags=" + tags + ", description=" + description + ", oeNumber="
				+ oeNumber + "]";
	}
}