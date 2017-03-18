/**
 * Project Name:OnlineParking
 * File Name:SMSTools.java
 * Package Name:com.yinzitech.onlineparking.core.sms
 * Date:2015年10月13日下午9:36:06
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.core.sms;

import java.util.HashMap; 

import com.cloopen.rest.sdk.CCPRestSDK; 

//import com.cloopen.rest.sdk.CCPRestSDK;

/**
 * ClassName:SMSTools <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午9:36:06 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class SMSTools {
	public static final String sandboxappPath = "app.cloopen.com";
	public static final String sandboxappPort = "8883";
	public static final String accountSid = "8a48b5515018a0f4015046a7e5e94dc7";
	public static final String accountToken = "847aa15de2934bce8915939c917b455f";
	public static final String AppId = "8a48b5515018a0f401504a9025815703";
	public static final String LIMITTIME = "2";
	public static final String SMSTMP = "41386";

	public static int sendMSM(String phoneNu, String codeNu) {
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init(sandboxappPath, sandboxappPort);//
		// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount(accountSid, accountToken);// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId(AppId);// 初始化应用ID
		result = restAPI.sendTemplateSMS(phoneNu, SMSTMP, new String[] { codeNu, LIMITTIME });

		System.out.println("SDKTestSendTemplateSMS result=" + result);
		if ("000000".equals(result.get("statusCode"))) {
			return 1;
			// return ResultResponse.obj2JsonResult("1", "用户发起对手机号为" + phoneNu +
			// "的手机发对验证码验证,成功", "");
		} else {
			return 0;
			// return ResultResponse.obj2JsonResult("0", "用户发起对手机号为" + phoneNu +
			// "的手机发对验证码验证,失败,请重新申请", "");
		}
	}

}
