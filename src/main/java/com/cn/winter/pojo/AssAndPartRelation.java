package com.cn.winter.pojo;


/**
 * 
 * 总成和零配件的关系
 * @author Administrator
 *
 */
public class AssAndPartRelation {

	//主键
	private Integer id;
	//零件编号
	private String sPartId;
	//总成编号
	private String assId;
	//状态 0：删除 1： 正常
	private Integer rStatus;
	
	
	
	
	public AssAndPartRelation() {
		super();
	}
	public AssAndPartRelation(Integer id, String sPartId, String assId, Integer rStatus) {
		super();
		this.id = id;
		this.sPartId = sPartId;
		this.assId = assId;
		this.rStatus = rStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getsPartId() {
		return sPartId;
	}
	public void setsPartId(String sPartId) {
		this.sPartId = sPartId;
	}
	public String getAssId() {
		return assId;
	}
	public void setAssId(String assId) {
		this.assId = assId;
	}
	public Integer getrStatus() {
		return rStatus;
	}
	public void setrStatus(Integer rStatus) {
		this.rStatus = rStatus;
	}
	
	@Override
	public String toString() {
		return "AssAndPartRelation [id=" + id + ", sPartId=" + sPartId + ", assId=" + assId + ", rStatus=" + rStatus
				+ "]";
	}
	
	
}
