/**
 * Project Name:OnlineParking
 * File Name:InterimTradingOrder.java
 * Package Name:com.yinzitech.onlineparking.entity.order
 * Date:2015年10月21日下午3:17:44
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.order;

import java.io.Serializable;

/**
 * ClassName:InterimTradingOrder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月21日 下午3:17:44 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class InterimTradingOrder implements Serializable {

	@Override
	public String toString() {
		return "InterimTradingOrder [orderId=" + orderId + ", createTime=" + createTime + ", state=" + state
				+ ", userPhone=" + userPhone + ", parkName=" + parkName + "]";
	}

	public InterimTradingOrder() {
		super();
	}

	public InterimTradingOrder(String orderId, String createTime, String state, String userPhone, String parkName) {
		super();
		this.orderId = orderId;
		this.createTime = createTime;
		this.state = state;
		this.userPhone = userPhone;
		this.parkName = parkName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	/*
	 * 交易订单ID
	 */
	public String orderId;
	/*
	 * 创建时间
	 */
	public String createTime;
	/*
	 * 支付状态
	 */
	public String state;
	/*
	 * 用户手机号
	 */
	public String userPhone;
	/*
	 * 停车场名称
	 */
	public String parkName;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = -5957502076420894482L;

}
