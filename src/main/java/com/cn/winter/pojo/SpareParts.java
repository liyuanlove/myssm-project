package com.cn.winter.pojo;

import java.io.Serializable;
import java.util.List;
/** 零件实例对象 */
public class SpareParts implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//零件编号
	private String partId;
	//零件名称
	private String partName;
	//数量
	private Integer number;
	//材料
	private String material;
	//生产时间
	private String productionTime;
	//信息
	private String desc;
	//状态 0：删除 1：正常
	private String tags;
	//供应商名称
	private String supplier;
	//入库时间
	private String addTime;
	//出库时间
	private String outTime;
	//记录录入人
	private String userId;
	//单价
	private String price;
	//零件图片
	private String partPicture;
	
	//状态 0：删除 1： 正常
	private Integer status;
	//总成关联 ManyToMany
	private List<Assembly> assembly;

	public SpareParts() {
		super();
	}

	public SpareParts(String partId, String partName, Integer number, String material, String productionTime,
			String desc, String tags, String supplier, String addTime, String outTime, String userId, String price, String partPicture,
			List<Assembly> assembly, Integer status) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.number = number;
		this.material = material;
		this.productionTime = productionTime;
		this.desc = desc;
		this.tags = tags;
		this.supplier = supplier;
		this.addTime = addTime;
		this.outTime = outTime;
		this.userId = userId;
		this.price = price;
		this.assembly = assembly;
		this.partPicture = partPicture;
		this.status = status;
	}

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId == null ? null : partId.trim();
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName == null ? null : partName.trim();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material == null ? null : material.trim();
	}

	public String getProductionTime() {
		return productionTime;
	}

	public void setProductionTime(String productionTime) {
		this.productionTime = productionTime == null ? null : productionTime.trim();
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier == null ? null : supplier.trim();
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime == null ? null : addTime.trim();
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime == null ? null : outTime.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price == null ? null : price.trim();
	}

	public List<Assembly> getAssembly() {
		return assembly;
	}

	public void setAssembly(List<Assembly> assembly) {
		this.assembly = assembly;
	}
	

	public String getPartPicture() {
		return partPicture;
	}

	public void setPartPicture(String partPicture) {
		this.partPicture = partPicture;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SpareParts [partId=" + partId + ", partName=" + partName + ", number=" + number + ", material="
				+ material + ", productionTime=" + productionTime + ", desc=" + desc + ", tags=" + tags + ", supplier="
				+ supplier + ", addTime=" + addTime + ", outTime=" + outTime + ", userId=" + userId + ", price=" + price
				+ ", partPicture=" + partPicture + ", status=" + status + ", assembly=" + assembly + "]";
	}


}