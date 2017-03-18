/**
 * Project Name:OnlineParking
 * File Name:SendMassage.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月4日下午5:45:16
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * ClassName:SendMassage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 下午5:45:16 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class SendMassage {
	protected static final Logger LOG = LoggerFactory.getLogger(SendMassage.class);

	public static void sendUser(String title, String msgContent, String registrationId) {
		if (registrationId == null & registrationId.equals("")) {
			System.out.println("registrationId" + registrationId);
		} else {

			String appKey = "b5e4a675b6e614841e190dde";
			String masterSecret = "ee240505418a6fa04212895b";

			JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);

			PushPayload payload = sendMassages(title, msgContent, registrationId);

			try {
				PushResult result = jpushClient.sendPush(payload);
				LOG.info("返回结果 ： " + result);
			} catch (APIConnectionException e) {
				LOG.error("连接错误, 稍后重试", e);
			} catch (APIRequestException e) {
				LOG.error("Should review the error, and fix the request", e);
				LOG.info("HTTP Status: " + e.getStatus());
				LOG.info("Error Code: " + e.getErrorCode());
				LOG.info("Error Message: " + e.getErrorMessage());
			}
		}

	}

	public static void sendUserPush(String title, String msgContent, String registrationId) {
		if (registrationId == null & registrationId.equals("")) {
			System.out.println("registrationId" + registrationId);
		} else {

			String appKey = "b5e4a675b6e614841e190dde";
			String masterSecret = "ee240505418a6fa04212895b";

			JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);

			PushPayload payload = sendMassagesPush(title, msgContent, registrationId);

			try {
				PushResult result = jpushClient.sendPush(payload);
				LOG.info("返回结果 ： " + result);
				System.out.println(result);
			} catch (APIConnectionException e) {
				LOG.error("连接错误, 稍后重试", e);
			} catch (APIRequestException e) {
				LOG.error("Should review the error, and fix the request", e);
				LOG.info("HTTP Status: " + e.getStatus());
				LOG.info("Error Code: " + e.getErrorCode());
				LOG.info("Error Message: " + e.getErrorMessage());
			}
		}

	}

	public static void sendHandSet(String title, String msgContent, String registrationId) {
		if (registrationId == null & registrationId.equals("")) {
			System.out.println("registrationId" + registrationId);
		} else {
			String appKey = "55b4986006d653bab7511ea3";
			String masterSecret = "5af7dc20882eb88361be6a2c";
			JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);
			PushPayload payload = sendMassages(title, msgContent, registrationId);
			try {
				PushResult result = jpushClient.sendPush(payload);
				LOG.info("返回结果 ： " + result);
			} catch (APIConnectionException e) {
				LOG.error("连接错误, 稍后重试", e);
			} catch (APIRequestException e) {
				LOG.error("Should review the error, and fix the request", e);
				LOG.info("HTTP Status: " + e.getStatus());
				LOG.info("Error Code: " + e.getErrorCode());
				LOG.info("Error Message: " + e.getErrorMessage());
			}
		}
	}

	public static PushPayload sendMassages(String title, String msgContent, String registrationId) {
		return PushPayload.newBuilder().setPlatform(Platform.android_ios())
				.setAudience(Audience.registrationId(registrationId))
				.setMessage(Message.newBuilder().setTitle(title).setMsgContent(msgContent).build()).build();
	}

	//
	public static PushPayload sendMassagesPush(String title, String msgContent, String registrationId) {
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.registrationId(registrationId))
				.setOptions(Options.newBuilder().setApnsProduction(true).build())
				.setNotification(
						Notification.newBuilder()
								.addPlatformNotification(
										IosNotification.newBuilder().setAlert(title).setSound("happy").build())
								.build())
				.build();
		// return
		// PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.registrationId(registrationId))
		// .setNotification(Notification.alert(title)).build();
	}
}
