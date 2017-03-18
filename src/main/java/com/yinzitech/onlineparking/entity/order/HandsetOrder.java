/**
 * Project Name:OnlineParking
 * File Name:HandesetOrder.java
 * Package Name:com.yinzitech.onlineparking.entity.order
 * Date:2015年10月23日下午1:50:26
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.order;

import java.io.Serializable;

/**
 * ClassName:HandesetOrder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月23日 下午1:50:26 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class HandsetOrder implements Serializable {

	@Override
	public String toString() {
		return "HandsetOrder [parkingInfoId=" + parkingInfoId + ", managerId=" + managerId + ", phone=" + phone
				+ ", managerName=" + managerName + ", sumCost=" + sumCost + ", orderNomber=" + orderNomber
				+ ", endTime=" + endTime + ", startTime=" + startTime + "]";
	}

	public HandsetOrder() {
		super();
	}

	public HandsetOrder(String parkingInfoId, String managerId, String phone, String managerName, String sumCost,
			String orderNomber, String endTime, String startTime) {
		super();
		this.parkingInfoId = parkingInfoId;
		this.managerId = managerId;
		this.phone = phone;
		this.managerName = managerName;
		this.sumCost = sumCost;
		this.orderNomber = orderNomber;
		this.endTime = endTime;
		this.startTime = startTime;
	}

	public String getParkingInfoId() {
		return parkingInfoId;
	}

	public void setParkingInfoId(String parkingInfoId) {
		this.parkingInfoId = parkingInfoId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getSumCost() {
		return sumCost;
	}

	public void setSumCost(String sumCost) {
		this.sumCost = sumCost;
	}

	public String getOrderNomber() {
		return orderNomber;
	}

	public void setOrderNomber(String orderNomber) {
		this.orderNomber = orderNomber;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 停车场id
	 */
	public String parkingInfoId;
	/**
	 * 手持用户id
	 */
	public String managerId;
	/**
	 * 电话号
	 */
	public String phone;
	/**
	 * 手持机用户名称
	 */
	public String managerName;
	/**
	 * 总价
	 */
	public String sumCost;
	/**
	 * 总单数
	 */
	public String orderNomber;
	/**
	 * 结束时间
	 */
	public String endTime;
	/**
	 * 起始时间
	 */
	public String startTime;
	/**
	 * 主键id
	 */
	public String orderId;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = 2781102444274385002L;

}
