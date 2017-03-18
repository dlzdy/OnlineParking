/**
 * Project Name:OnlineParking
 * File Name:FundAccountManageServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.fundAccountManage.impl
 * Date:2015年10月5日上午1:06:21
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.service.fundAccountManage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.client.ClientUserDao;
import com.yinzitech.onlineparking.dao.client.QueryClientUserDao;
import com.yinzitech.onlineparking.dao.fundAccountManage.FundAccountManageDao;
import com.yinzitech.onlineparking.dao.fundAccountManage.QueryFundAccountDao;
import com.yinzitech.onlineparking.dao.msg.MessageDao;
import com.yinzitech.onlineparking.entity.client.user.ClientUser;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.fundAccountManage.FundAccountManage;
import com.yinzitech.onlineparking.entity.msg.Message;
import com.yinzitech.onlineparking.service.fundAccountManage.FundAccountManageService;
import com.yinzitech.onlineparking.utils.PageHelper.Page;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.SendMassage;
import com.yinzitech.onlineparking.utils.TimeTools;

/**
 * ClassName:FundAccountManageServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月5日 上午1:06:21 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class FundAccountManageServiceImpl implements FundAccountManageService {
	@Autowired
	FundAccountManageDao fundAccountManageDao;
	@Autowired
	ClientUserDao clientUserDao;
	@Autowired
	QueryFundAccountDao qfa;
	@Autowired
	MessageDao messageDao;
	@Autowired
	QueryClientUserDao qc;

	/**
	 * TODO 通过用户custId查找资金账户详细信息（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.fundAccountManage.FundAccountManageService#selectByCustId(java.lang.String)
	 */
	@Override
	public String selectByCustId(String custId, String clientUserSecurity) {
		String json = "";
		ClientUser cu = clientUserDao.selectById(custId, clientUserSecurity);
		if (cu != null) {
			FundAccountManage fundAccountManage = fundAccountManageDao.selectByCustId(custId);
			if (fundAccountManage != null) {
				json = ResultObject.obj2JsonResult("1", "查找 ：" + custId + "成功", fundAccountManage);

			} else {
				json = ResultObject.obj2JsonResult("0", "查找：" + custId + "失败", "");

			}
		} else {
			json = ResultObject.obj2JsonResult("2", "令牌验证失败", "");

		}

		System.out.println(json);
		return json;
	}

	/**
	 * TODO 修改资金用户状态（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.fundAccountManage.FundAccountManageService#upFundAccountManageState(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String upFundAccountManageState(String custId, String fundAccountManageState) {
		String json = "";
		String msgBody = "";
		String msgName = "";
		int i = fundAccountManageDao.upFundAccountManageState(custId, fundAccountManageState);
		if (i > 0) {

			if (fundAccountManageState.equals("00")) {
				msgBody = "恢复资金账户成功 如有问题 请联系客服";
				msgName = "资金账户恢复";
			} else if (fundAccountManageState.equals("01")) {
				msgBody = "冻结资金账户  请联系客服";
				msgName = "冻结资金账户";
			} else if (fundAccountManageState.equals("02")) {
				msgBody = "注销资金账户  请联系客服";
				msgName = "资金账户注销";
			}
			sendStateMassge(custId, msgBody, msgName);

			json = ResultResponse.obj2JsonResult("1", "修改资金用户状态：" + fundAccountManageState + " 成功", "");

		} else {
			json = ResultResponse.obj2JsonResult("0", "修改资金用户状态：" + fundAccountManageState + " 失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * sendStateMassge:(推送消息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param custId
	 * @param msgBody
	 * @param msgName
	 * @since JDK 1.8u60
	 */
	private void sendStateMassge(String custId, String msgBody, String msgName) {
		String msgId = ToolsIdGenerator.getOrderId();
		String msgStatus = "1";
		String msgTime = TimeTools.getCurrentTime();
		messageDao.creatMessage(msgId, msgName, msgStatus, msgBody, msgTime, custId, "");
		Message message = new Message(msgId, msgName, msgStatus, msgBody, "", msgTime, "", "", "");
		String body = ResultObject.obj2JsonResult("4", "消息推送成功", message);
		List<ClientUser> cu = qc.getUser(custId, "", "", "", "", "", "", "", "", "", "","");
		SendMassage.sendUser(msgName, body, cu.get(0).getClientUserRegistrAtionId());
	}

	/**
	 * TODO 更新用户资金金额（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.fundAccountManage.FundAccountManageService#upFundAccountManageAmount(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String upFundAccountManageAmount(String custId, String fundAccountManageAmount) {
		String json = "";
		int i = fundAccountManageDao.upFundAccountManageAmount(custId, fundAccountManageAmount);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新用户资金金额：" + fundAccountManageAmount + " 成功", "");

		} else {
			json = ResultResponse.obj2JsonResult("0", "更新用户资金金额：" + fundAccountManageAmount + " 失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.fundAccountManage.FundAccountManageService#getFund()
	 */
	@Override
	public String getFund(String fundAccountId, String custId, String subaccountType, String fundAccountManageProperty,
			String fundAccountManageState, String startTime, String endTime) {
		String json = "";
		List<FundAccountManage> list = qfa.getFund(fundAccountId, custId, subaccountType, fundAccountManageProperty,
				fundAccountManageState, startTime, endTime);
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 资金账户分页查询（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.fundAccountManage.FundAccountManageService#getFundLimit(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public String getFundLimit(String fundAccountId, String custId, String subaccountType,
			String fundAccountManageProperty, String fundAccountManageState, String startTime, String endTime,
			int pageNumber, int pageSize) {
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		List<FundAccountManage> list = qfa.getFund(fundAccountId, custId, subaccountType, fundAccountManageProperty,
				fundAccountManageState, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询失败", "");
		}
		return json;
	}

}
