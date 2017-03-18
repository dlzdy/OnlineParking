/**
 * Project Name:OnlineParking
 * File Name:SystemManagerServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.sys.imp
 * Date:2015年10月13日下午3:15:38
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.sys.SystemManagerDao;
import com.yinzitech.onlineparking.entity.common.ResultObject; 
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.sys.SystemManager;
import com.yinzitech.onlineparking.service.sys.SystemManagerService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:SystemManagerServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午3:15:38 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
@Service
public class SystemManagerServiceImpl implements SystemManagerService {
	@Autowired
	SystemManagerDao systemManagerDao;

	@Override
	public String creatSysteManager(String systemManagerUsername, String systemManagerPsd) {
		String json = "";
		String systemManagerId = ToolsIdGenerator.getUUID();
		String systemManagerCreateTime = TimeTools.getCurrentTime();
		int i = systemManagerDao.creatSysteManager(systemManagerId, systemManagerUsername, systemManagerPsd,
				systemManagerCreateTime);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "创建用户成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "创建用户失败", "");
		}
		return json;
	}

	@Override
	public String selectAllManagerUser(int pageNum, int pageSize) {

		String json = "";
		PageHelper.startPage(pageNum, pageSize);
		List<SystemManager> list = systemManagerDao.selectAllManagerUser();
		Page s = PageHelper.endPage();
		if (list != null) {
			json = ResultObject.obj2JsonResult("1", "查询全部用户成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询用户失败", "");
		}

		return json;
	}

	@Override
	public String selectManagerUserByName(String systemManagerUsername, String systemManagerPsd) {
		String json = "";
		SystemManager sys = systemManagerDao.selectManagerUserByName(systemManagerUsername, systemManagerPsd);
		if (sys != null) {
			json = ResultObject.obj2JsonResult("1", "查询用户成功", sys);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询用户失败", "");
		}
		return json;
	}

	@Override
	public String upLastTimeLogin(String systemManagerLastLoginTime, String systemManagerUsername) {
		String json = "";
		int i = systemManagerDao.upLastTimeLogin(systemManagerLastLoginTime, systemManagerUsername);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新登录时间成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "登录时间更新失败", "");
		}
		return json;
	}

	@Override
	public String upManagerUserPsd(String systemManagerPsd, String systemManagerUsername) {

		String json = "";
		int i = systemManagerDao.upManagerUserPsd(systemManagerPsd, systemManagerUsername);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "密码更新成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "密码更新失败", "");
		}

		return json;
	}

	@Override
	public String upUserInfo(String systemManagerPhone, String systemManagerEmail, String systemManagerState,
			String systemManagerUsername) {
		String json = "";
		int i = systemManagerDao.upUserInfo(systemManagerPhone, systemManagerEmail, systemManagerState,
				systemManagerUsername);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "基础信息更改成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "基础信息更改失败", "");
		}

		return json;
	}

	@Override
	public String deleteManagerUser(String systemManagerId) {

		String json = "";
		int i = systemManagerDao.deleteManagerUser(systemManagerId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "删除用户成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "删除用户失败", "");
		}

		return json;
	}

}
