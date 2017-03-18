/**
 * Project Name:OnlineParking
 * File Name:Singtest.java
 * Package Name:kevinTest
 * Date:2015年12月23日上午10:07:00
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package kevinTest;

import java.util.HashMap;

import com.yinzitech.onlineparking.utils.SendMassage;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosAlert;

/**
 * ClassName:Singtest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年12月23日 上午10:07:00 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class Singtest {

	public static void main(String[] args) {
		// SendMassage.sendUser("++++ 1++", "09113e53aca", "09113e53aca");
		// SendMassage.sendUserPush("++++1 +++ ", "09113e53aca", "09113e53aca");

		testSendIosAlert();

	}

	static String appKey = "b5e4a675b6e614841e190dde";
	static String masterSecret = "ee240505418a6fa04212895b";

	JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);

	// 推送测试
	public PushResult sendIosMessageWithRegistrationID(String title, String msgContent, String... registrationID)
			throws APIConnectionException, APIRequestException {
		PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.ios())
				.setAudience(Audience.registrationId(registrationID))
				.setMessage(Message.newBuilder().setTitle(title).setMsgContent(msgContent).build()).build();
		return jpushClient.sendPush(payload);
	}

	public static void testSendIosAlert() {
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);

		IosAlert alert = IosAlert.newBuilder().setTitleAndBody("test alert", "test ios alert json")
				.setActionLocKey("PLAY").build();
		try {
			PushResult result = jpushClient.sendIosNotificationWithAlias(alert, new HashMap<String, String>(),
					"alias1");
			System.out.println(result);
		} catch (APIConnectionException e) {
			System.out.println("Connection error. Should retry later. " + e);
		} catch (APIRequestException e) {
			System.out.println("Error response from JPush server. Should review and fix it. " + e);
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}
	}

}
