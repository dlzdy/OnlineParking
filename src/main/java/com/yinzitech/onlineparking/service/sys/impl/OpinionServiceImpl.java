/**
 * Project Name:OnlineParking
 * File Name:OpinionServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.sys.impl
 * Date:2015年10月23日下午4:23:04
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.client.ClientUserDao;
import com.yinzitech.onlineparking.dao.client.QueryClientUserDao;
import com.yinzitech.onlineparking.dao.sys.OpinionDao;
import com.yinzitech.onlineparking.dao.sys.OpinionMapperDao;
import com.yinzitech.onlineparking.entity.client.user.ClientUser;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.sys.Opinion;
import com.yinzitech.onlineparking.service.sys.OpinionService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:OpinionServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月23日 下午4:23:04 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class OpinionServiceImpl implements OpinionService {
	@Autowired
	OpinionDao opinionDao;
	@Autowired
	ClientUserDao clientUserDao;
	@Autowired
	QueryClientUserDao qc;
	@Autowired
	OpinionMapperDao omd;

	@Override
	public String createOpinion(String opinionUserId, String opinionBody, String clientUserSecurity) {
		String json = "";

		List<ClientUser> user = qc.getUser(opinionUserId, "", "", "", "", "", "", "", "", "", "", "");
		if (user.get(0).getClientUserSecurity().equals(clientUserSecurity)) {
			String opinionId = ToolsIdGenerator.getOrderId();
			String opinionTime = TimeTools.getCurrentTime();
			ClientUser clientUser = clientUserDao.selectClientUserById(opinionUserId);
			String opinionUserNick = clientUser.getClientUserNickName();
			String opinionUserPhone = clientUser.getClientUserCellphone();
			int i = opinionDao.createOpinion(opinionId, opinionUserId, opinionUserNick, opinionUserPhone, opinionBody,
					opinionTime);
			if (i > 0) {
				json = ResultResponse.obj2JsonResult("1", "意见反馈成功", "");
			} else {
				json = ResultResponse.obj2JsonResult("0", "意见反馈失败", "");
			}
		} else {
			json = ResultResponse.obj2JsonResult("2", "令牌不匹配请重新登陆", "");
		}

		System.out.println(json);
		return json;
	}

	@Override
	public String queryOpinion(String startTime, String endTime, int pageNumber, int pageSize) {
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		List<Opinion> list = opinionDao.queryOpinion(startTime, endTime);
		Page s = PageHelper.endPage();
		if (list != null) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		return json;
	}

	@Override
	public String getOpinion(String opinionUserPhone, String startTime, String endTime, int pageNumber, int pageSize) {
		String json = "";
		String phone = "";
		PageHelper.startPage(pageNumber, pageSize);
		if (opinionUserPhone != null & opinionUserPhone != "") {
			phone = "%" + opinionUserPhone + "%";
		}
		List<Opinion> list = omd.getOpinion(phone, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list != null) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		return json;
	}

}
