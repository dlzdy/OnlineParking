/**
 * Project Name:OnlineParking
 * File Name:Message2JsonUtils.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月22日上午11:34:51
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

/**
 * ClassName:Message2JsonUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月22日 上午11:34:51 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class MessageUtils {

	public MessageUtils(String msgBody, String msgBodyImgUrl, String msgId) {
		super();
		this.msgBody = msgBody;
		this.msgBodyImgUrl = msgBodyImgUrl;
		this.msgId = msgId;
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

	public String getmsgId() {
		return msgId;
	}

	public void setmsgId(String msgId) {
		this.msgId = msgId;
	}

	String msgBody;
	String msgBodyImgUrl;
	String msgId;

}
