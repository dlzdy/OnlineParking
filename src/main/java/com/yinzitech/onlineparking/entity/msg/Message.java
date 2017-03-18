/**
 * Project Name:OnlineParking
 * File Name:Massage.java
 * Package Name:com.yinzitech.onlineparking.entity.msg
 * Date:2015年10月19日下午4:54:42
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.msg;

/**
 * ClassName:Massage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月19日 下午4:54:42 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class Message {

	@Override
	public String toString() {
		return "Massage [msgId=" + msgId + ", msgName=" + msgName + ", msgStatus=" + msgStatus + ", msgBody=" + msgBody
				+ ", msgBodyImgUrl=" + msgBodyImgUrl + ", msgTime=" + msgTime + ", msgSendTime=" + msgSendTime
				+ ", msgSendName=" + msgSendName + ", msgUserId=" + msgUserId + "]";
	}

	public Message() {
		super();
	}

	public Message(String msgId, String msgName, String msgStatus, String msgBody, String msgBodyImgUrl, String msgTime,
			String msgSendTime, String msgSendName, String msgUserId) {
		super();
		this.msgId = msgId;
		this.msgName = msgName;
		this.msgStatus = msgStatus;
		this.msgBody = msgBody;
		this.msgBodyImgUrl = msgBodyImgUrl;
		this.msgTime = msgTime;
		this.msgSendTime = msgSendTime;
		this.msgSendName = msgSendName;
		this.msgUserId = msgUserId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgName() {
		return msgName;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getMsgBodyImgUrl() {
		return msgBodyImgUrl;
	}

	public void setMsgBodyImgUrl(String msgBodyImgUrl) {
		this.msgBodyImgUrl = msgBodyImgUrl;
	}

	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	public String getMsgSendTime() {
		return msgSendTime;
	}

	public void setMsgSendTime(String msgSendTime) {
		this.msgSendTime = msgSendTime;
	}

	public String getMsgSendName() {
		return msgSendName;
	}

	public void setMsgSendName(String msgSendName) {
		this.msgSendName = msgSendName;
	}

	public String getMsgUserId() {
		return msgUserId;
	}

	public void setMsgUserId(String msgUserId) {
		this.msgUserId = msgUserId;
	}

	/**
	 * 消息ID
	 */
	public String msgId;
	/**
	 * 消息名称
	 */
	public String msgName;
	/**
	 * 消息状态
	 */
	public String msgStatus;
	/**
	 * 消息内容
	 */
	public String msgBody;
	/**
	 * 消息图片 url形式
	 */
	public String msgBodyImgUrl;
	/**
	 * 消息创建时间
	 */
	public String msgTime;
	/**
	 * 消息发送时间
	 */
	public String msgSendTime;
	/**
	 * 消息发送人
	 */
	public String msgSendName;
	/**
	 * 发送用户Id
	 */
	public String msgUserId;

}
