/**
 * Project Name:OnlineParking
 * File Name:MassageServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.massage.impl
 * Date:2015年10月19日下午7:13:36
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.massage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.client.ClientUserDao;
import com.yinzitech.onlineparking.dao.client.QueryClientUserDao;
import com.yinzitech.onlineparking.dao.msg.MessageDao;
import com.yinzitech.onlineparking.dao.msg.MessageMapperDao;
import com.yinzitech.onlineparking.entity.client.user.ClientUser;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.msg.Message;
import com.yinzitech.onlineparking.service.massage.MessageService;
import com.yinzitech.onlineparking.utils.MessageUtils;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.SendMassage;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:MassageServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月19日 下午7:13:36 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDao messageDao;
	@Autowired
	ClientUserDao clientUserDao;
	@Autowired
	QueryClientUserDao qc;
	@Autowired
	MessageMapperDao mmd;

	@Override
	public String creatMessage(String msgName, String msgBody, String msgBodyImgUrl) {
		String json = "";

		String msgTime = TimeTools.getCurrentTime();
		String msgStatus = "0";
		List<ClientUser> list = clientUserDao.selectUser();
		int i = 0;
		for (ClientUser clientUser : list) {
			String msgId = ToolsIdGenerator.getOrderId();
			i = messageDao.creatMessage(msgId, msgName, msgStatus, msgBody, msgTime, clientUser.getClientUserId(),
					msgBodyImgUrl);
		}
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "创建成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "创建失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String upMessageByBody(String msgId, String msgName, String msgBody, String msgSendName) {
		String json = "";
		int i = 0;
		List<Message> list = messageDao.selectMessageByMsgName(msgName);
		String msgSendTime = TimeTools.getCurrentTime();
		for (Message message : list) {
			i = messageDao.upMessageByBody(message.getMsgId(), msgName, msgBody);
			messageDao.upMessagesSendInfo(msgSendTime, msgSendName, message.getMsgId());
		}

		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "消息内容更新成功", "");

		} else {
			json = ResultResponse.obj2JsonResult("0", "消息内容更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String addMessageImg(String msgBodyImgUrl, String msgName, String msgSendName) {
		String json = "";
		int i = 0;
		List<Message> list = messageDao.selectMessageByMsgName(msgName);
		String msgSendTime = TimeTools.getCurrentTime();
		for (Message message : list) {
			i = messageDao.addMessageImg(msgBodyImgUrl, message.getMsgName(), message.getMsgId());
			messageDao.upMessagesSendInfo(msgSendTime, msgSendName, message.getMsgId());
		}

		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "图片地址更新成功", "");

		} else {
			json = ResultResponse.obj2JsonResult("0", "图片地址更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String queryMessageByUserIdWhereStatus(String msgUserId, String msgStatus, String clientUserSecurity) {
		String json = "";

		List<ClientUser> user = qc.getUser(msgUserId, "", "", "", "", "", "", "", "", "", "", "");
		if (user.get(0).getClientUserSecurity().equals(clientUserSecurity)) {

			List<Message> list = messageDao.queryMessageByUserIdWhereStatus(msgUserId, "1");
			if (list != null) {
				json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
				for (Message message : list) {
					messageDao.upMessagesStatus("2", msgUserId, message.getMsgId());
				}
			} else {
				json = ResultResponse.obj2JsonResult("0", "暂无数据", "");
			}
		} else {
			json = ResultResponse.obj2JsonResult("2", "令牌不匹配请重新登陆", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String sendMessages(String msgName, String msgSendName) {
		String json = "";
		int i = 0;
		String title = "";
		String msgContent = "";
		String msgContentImgUrl = "";
		String msgId = "";
		String msgSendTime = TimeTools.getCurrentTime();
		List<Message> list = messageDao.selectMessageByMsgName(msgName);
		for (Message message : list) {
			i = messageDao.upMessagesStatus("1", message.getMsgUserId(), message.getMsgId());
			title = message.getMsgName();
			msgContent = message.getMsgBody();
			msgContentImgUrl = message.getMsgBodyImgUrl();
			msgId = message.getMsgId();
			messageDao.upMessagesSendInfo(msgSendTime, msgSendName, msgName);
		}
		if (i > 0) {
			List<ClientUser> cu = qc.getUser("", "", "", "", "", "", "", "", "", "", "", "");
			MessageUtils mu = new MessageUtils(msgContent, msgContentImgUrl, msgId);
			String body = ResultObject.obj2JsonResult("4", "消息推送成功", mu);
			System.out.println(body);
			String uid;
			for (ClientUser clientUser : cu) {
				uid = clientUser.getClientUserRegistrAtionId();
				System.out.println(uid);
				if (uid != null) {
					if (uid.length() > 0) {
						String type = clientUser.getClientUserType();
						if (type.equals("1")) {
							SendMassage.sendUser(title, body, uid);
						} else {
							SendMassage.sendUser(title, body, uid);
							SendMassage.sendUserPush(title, body, uid);
						}

					}

				}

			}

			json = ResultResponse.obj2JsonResult("1", "发送成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "暂无数据", "");
		}

		System.out.println(json);
		return json;
	}

	@Override
	public String selectHistoryMessage() {
		String json = "";
		List<Message> list = messageDao.selectHistory();
		if (list != null) {
			json = ResultObjectList.obj2JsonResult("1", "历史消息查询成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "历史小小查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String selectHistoryMessageLimit(int pageNumber, int pageSize) {
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		List<Message> list = messageDao.selectHistory();
		Page s = PageHelper.endPage();
		if (list != null) {
			json = ResultObject.obj2JsonResult("1", "历史消息查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "历史小小查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String countMessage(String userId) {
		List<Message> list = messageDao.queryMessageByUserIdWhereStatus(userId, "1");
		return String.valueOf(list.size());

	}

	@Override
	public String queryMessage(String msgStatus, String startTime, String endTime, int pageNumber, int pageSize) {
		String msgId = "";
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		List<Message> list = mmd.queryMessage(msgId, msgStatus, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list != null) {
			json = ResultObject.obj2JsonResult("1", "历史消息查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "历史消息查询失败", "");
		}
		System.out.println(json);
		return json;
	}

}
