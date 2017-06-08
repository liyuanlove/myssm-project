package com.cn.winter.pojo;

import java.io.Serializable;
/** 供应商实例对象*/
public class Supplier implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//公司id 主键
    private Integer supplierId;
    //供应商名称
    private String supplierName;
    //公司类型
    private String supplierType;
    //供应商状态 0：正常 1：冻结 2：删除
    private String supplierStatus;
    //负责人名称
    private String userName;
    //联系电话
    private String phone;

    
    public Supplier() {
		super();
	}
    
	public Supplier(Integer supplierId, String supplierName, String supplierType, String supplierStatus,
			String userName, String phone) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierType = supplierType;
		this.supplierStatus = supplierStatus;
		this.userName = userName;
		this.phone = phone;
	}


	public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType == null ? null : supplierType.trim();
    }

    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus == null ? null : supplierStatus.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierType="
				+ supplierType + ", supplierStatus=" + supplierStatus + ", userName=" + userName + ", phone=" + phone
				+ "]";
	}
    
}