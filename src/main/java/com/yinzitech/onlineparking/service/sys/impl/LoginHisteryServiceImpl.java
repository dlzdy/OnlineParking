/**
 * Project Name:OnlineParking
 * File Name:LoginHisteryServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.sys.impl
 * Date:2015年10月22日下午5:26:58
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.sys.LoginHistoryDao;
import com.yinzitech.onlineparking.entity.common.ResultObject; 
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.sys.LoginHistory;
import com.yinzitech.onlineparking.service.sys.LoginHisteryService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:LoginHisteryServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月22日 下午5:26:58 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
@Service
public class LoginHisteryServiceImpl implements LoginHisteryService {
	@Autowired
	LoginHistoryDao loginHisteryDao;
	String json = "";

	@Override
	public String creatHistory(String loginHistoryCustId, String loginHistoryType) {

		List<LoginHistory> list = loginHisteryDao.getLoginHistoryByCustId(loginHistoryCustId);
		if (list != null) {
			for (LoginHistory loginHistory : list) {
				if (loginHistory.getLoginHistoryEnd() == null) {

					String loginHistoryEnd = TimeTools.getCurrentTime();
					loginHisteryDao.upHistoryEndTime(loginHistoryEnd, loginHistory.getLoginHistoryId());
				}

			}
		}
		String loginHistoryStart = TimeTools.getCurrentTime();
		String loginHistoryId = ToolsIdGenerator.getUUID();

		int i = loginHisteryDao.creatHistory(loginHistoryId, loginHistoryCustId, loginHistoryStart, loginHistoryType);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "创建成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "创建失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String upHistoryEndTime(String loginHistoryCustId) {
		List<LoginHistory> list = loginHisteryDao.getLoginHistoryByCustId(loginHistoryCustId);
		for (LoginHistory loginHistory : list) {
			if (loginHistory.getLoginHistoryEnd() == null) {
				String loginHistoryEnd = TimeTools.getCurrentTime();
				String loginHistoryId = loginHistory.getLoginHistoryId();
				int i = loginHisteryDao.upHistoryEndTime(loginHistoryEnd, loginHistoryId);
				if (i > 0) {
					json = ResultResponse.obj2JsonResult("1", "更新退出时间成功", loginHistoryEnd);
				} else {
					json = ResultResponse.obj2JsonResult("0", "更新失败", "");
				}
			}
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String getLoginHisteryByCustId(String loginHistoryCustId,int pageNumber,int pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<LoginHistory> list = loginHisteryDao.getLoginHistoryByCustId(loginHistoryCustId);
		Page s =PageHelper.endPage();
		if (list != null) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

}
