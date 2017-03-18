/**
 * Project Name:OnlineParking
 * File Name:CalfeeRoot.java
 * Package Name:com.yinzitech.onlineparking.utils.pojo
 * Date:2016年1月14日上午11:13:57
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils.pojo;

/**
 * ClassName:CalfeeRoot <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年1月14日 上午11:13:57 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class CalfeeRoot {
	private String message;

	private boolean success;

	private CalfeeData data;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean getSuccess() {
		return this.success;
	}

	public void setData(CalfeeData data) {
		this.data = data;
	}

	public CalfeeData getData() {
		return this.data;
	}

}