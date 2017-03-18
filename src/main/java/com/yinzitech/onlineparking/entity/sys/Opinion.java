/**
 * Project Name:OnlineParking
 * File Name:Opinion.java
 * Package Name:com.yinzitech.onlineparking.entity.sys
 * Date:2015年10月23日下午4:04:15
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.sys;

import java.io.Serializable;

/**
 * ClassName:Opinion <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月23日 下午4:04:15 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class Opinion implements Serializable {

	@Override
	public String toString() {
		return "Opinion [opinionId=" + opinionId + ", opinionUserId=" + opinionUserId + ", opinionUserNick="
				+ opinionUserNick + ", opinionUserPhone=" + opinionUserPhone + ", opinionBody=" + opinionBody
				+ ", opinionTime=" + opinionTime + "]";
	}

	public Opinion() {
		super();
	}

	public Opinion(String opinionId, String opinionUserId, String opinionUserNick, String opinionUserPhone,
			String opinionBody, String opinionTime) {
		super();
		this.opinionId = opinionId;
		this.opinionUserId = opinionUserId;
		this.opinionUserNick = opinionUserNick;
		this.opinionUserPhone = opinionUserPhone;
		this.opinionBody = opinionBody;
		this.opinionTime = opinionTime;
	}

	public String getOpinionId() {
		return opinionId;
	}

	public void setOpinionId(String opinionId) {
		this.opinionId = opinionId;
	}

	public String getOpinionUserId() {
		return opinionUserId;
	}

	public void setOpinionUserId(String opinionUserId) {
		this.opinionUserId = opinionUserId;
	}

	public String getOpinionUserNick() {
		return opinionUserNick;
	}

	public void setOpinionUserNick(String opinionUserNick) {
		this.opinionUserNick = opinionUserNick;
	}

	public String getOpinionUserPhone() {
		return opinionUserPhone;
	}

	public void setOpinionUserPhone(String opinionUserPhone) {
		this.opinionUserPhone = opinionUserPhone;
	}

	public String getOpinionBody() {
		return opinionBody;
	}

	public void setOpinionBody(String opinionBody) {
		this.opinionBody = opinionBody;
	}

	public String getOpinionTime() {
		return opinionTime;
	}

	public void setOpinionTime(String opinionTime) {
		this.opinionTime = opinionTime;
	}

	/**
	 * 意见主键id
	 */
	public String opinionId;
	/**
	 * 用户id
	 */
	public String opinionUserId;
	/**
	 * 用户昵称
	 */
	public String opinionUserNick;
	/**
	 * 用户电话
	 */
	public String opinionUserPhone;
	/**
	 * 内容
	 */
	public String opinionBody;
	/**
	 * 创建时间
	 */
	public String opinionTime;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = 147757355045264056L;

}
