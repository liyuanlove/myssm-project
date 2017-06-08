package com.cn.winter.pojo;

import java.io.Serializable;
import java.util.List;

/** 总成实例 */
public class Assembly implements Serializable {

	private static final long serialVersionUID = 1L;
	// 总成编号
	private String partId;
	// 总成名称
	private String partName;
	// 缸径
	private String diameter;
	// 零件状态：0:删除 1：正常
	private Integer partStatus;
	// 最新装配时间
	private String assembleTime;
	// 重量
	private String weight;
	// 信息
	private String desc;
	// 保留字段
	private String tags;
	// 记录录入人
	private String userId;
	// 单价
	private String price;
	//数量
	private Integer number;
	//图片
	private String picture;
	//OE编号
	private String oeNumber;
	
	// 零配件，manyToMany
	private List<SpareParts> sparePart;

	public Assembly() {
		super();
	}

	public Assembly(String partId, String partName, String diameter, Integer partStatus, String assembleTime,
			String weight, String desc, String tags, String userId, String price, String picture, String oeNumber, List<SpareParts> sparePart) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.diameter = diameter;
		this.partStatus = partStatus;
		this.assembleTime = assembleTime;
		this.weight = weight;
		this.desc = desc;
		this.tags = tags;
		this.userId = userId;
		this.price = price;
		this.sparePart = sparePart;
		this.picture = picture;
		this.oeNumber = oeNumber;
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

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter == null ? null : diameter.trim();
	}

	public Integer getPartStatus() {
		return partStatus;
	}

	public void setPartStatus(Integer partStatus) {
		this.partStatus = partStatus;
	}

	public String getAssembleTime() {
		return assembleTime;
	}

	public void setAssembleTime(String assembleTime) {
		this.assembleTime = assembleTime == null ? null : assembleTime.trim();
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight == null ? null : weight.trim();
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
	

	public List<SpareParts> getSparePart() {
		return sparePart;
	}

	public void setSparePart(List<SpareParts> sparePart) {
		this.sparePart = sparePart;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getOeNumber() {
		return oeNumber;
	}

	public void setOeNumber(String oENumber) {
		oeNumber = oENumber;
	}

	@Override
	public String toString() {
		return "Assembly [partId=" + partId + ", partName=" + partName + ", diameter=" + diameter + ", partStatus="
				+ partStatus + ", assembleTime=" + assembleTime + ", weight=" + weight + ", desc=" + desc + ", tags="
				+ tags + ", userId=" + userId + ", price=" + price + ", number=" + number + ", picture=" + picture
				+ ", oeNumber=" + oeNumber + ", sparePart=" + sparePart + "]";
	}

	

}