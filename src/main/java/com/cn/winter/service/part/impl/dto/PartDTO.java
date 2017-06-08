package com.cn.winter.service.part.impl.dto;

import com.cn.winter.pojo.Assembly;
import com.cn.winter.pojo.SpareParts;

public class PartDTO {

		// 总成编号
		private String partId;
		// 总成名称
		private String partName;
		// 零件状态：0:删除 1：正常
		private Integer partStatus;
		// 记录录入人
		private String userId;
		//数量
		private Integer number;
		//图片
		private String picture;
		
		private String price;
		
		private String lastTime;
		
		
		public PartDTO() {
			super();
		}
		public String getPartId() {
			return partId;
		}
		public void setPartId(String partId) {
			this.partId = partId;
		}
		public String getPartName() {
			return partName;
		}
		public void setPartName(String partName) {
			this.partName = partName;
		}
		public Integer getPartStatus() {
			return partStatus;
		}
		public void setPartStatus(Integer partStatus) {
			this.partStatus = partStatus;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
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
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		
		
		public String getLastTime() {
			return lastTime;
		}
		public void setLastTime(String lastTime) {
			this.lastTime = lastTime;
		}
		@Override
		public String toString() {
			return "PartDTO [partId=" + partId + ", partName=" + partName + ", partStatus=" + partStatus + ", userId="
					+ userId + ", number=" + number + ", picture=" + picture + ", price=" + price + ", lastTime="
					+ lastTime + "]";
		}
		
		
		/**
		 * 将总成装配到dto
		 * @param ass
		 * @return
		 */
		public PartDTO addAssToPartDTO(Assembly ass){
			
			this.partId = ass.getPartId();
			this.partName = ass.getPartName();
			this.partStatus = ass.getPartStatus();
			this.userId = ass.getUserId();
			this.number = ass.getNumber();
			this.picture = ass.getPicture();
			this.price = ass.getPrice();
			this.lastTime = ass.getAssembleTime();
			return this;
		}
		
		/**
		 * 将零件装配到dto
		 * @param part
		 * @return
		 */
		public PartDTO addSparePartToPartDTO(SpareParts part){
			this.partId = part.getPartId();
			this.partName = part.getPartName();
			this.partStatus = part.getStatus();
			this.userId = part.getUserId();
			this.number = part.getNumber();
			this.picture = part.getPartPicture();
			this.price = part.getPrice();
			this.lastTime = part.getAddTime();
			return this;
		}
		
		
}
