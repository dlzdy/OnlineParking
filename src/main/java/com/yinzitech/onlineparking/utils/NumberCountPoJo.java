/**
 * Project Name:OnlineParking
 * File Name:NumberCountPoJo.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2016年3月18日下午6:08:06
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

/**
 * ClassName:NumberCountPoJo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年3月18日 下午6:08:06 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class NumberCountPoJo {
	String OrderNumber;
	String MessageNumber;

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getMessageNumber() {
		return MessageNumber;
	}

	public void setMessageNumber(String messageNumber) {
		MessageNumber = messageNumber;
	}

	public NumberCountPoJo(String orderNumber, String messageNumber) {
		super();
		OrderNumber = orderNumber;
		MessageNumber = messageNumber;
	}

	public NumberCountPoJo() {
		super();
	}

	@Override
	public String toString() {
		return "NumberCountPoJo [OrderNumber=" + OrderNumber + ", MessageNumber=" + MessageNumber + "]";
	}

}
