/**
 * Project Name:OnlineParking
 * File Name:AppVersionImpl.java
 * Package Name:com.yinzitech.onlineparking.service.appVersion.impl
 * Date:2016年7月4日上午11:38:17
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.appVersion.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.dao.appVersion.AppVersionDao;
import com.yinzitech.onlineparking.entity.appVersion.AppVersion;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.service.appVersion.AppVersionService;

/**
 * ClassName:AppVersionImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年7月4日 上午11:38:17 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class AppVersionImpl implements AppVersionService {
	@Autowired
	AppVersionDao appVersionDao;

	@Override
	public String addAppVersion(AppVersion appVersion) {

		// TODO Auto-generated method stub
		String json = "";
		int i = appVersionDao.addAppVersion(appVersion);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "插入成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "插入失败", "");
		}
		return json;
	}

	@Override
	public String getAppVersion() {

		// TODO Auto-generated method stub
		String json = "";
		List<AppVersion> appVersion = appVersionDao.getAppVersion("", "");
		if (appVersion.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "获取app版本内容成功", appVersion.get(0));
		} else {
			json = ResultResponse.obj2JsonResult("0", "当前版本已是最新", "");
		}
		return json;
	}

	@Override
	public String upAppVersion(AppVersion appVersion) {

		// TODO Auto-generated method stub
		String json = "";
		int i = appVersionDao.upAppVersion(appVersion);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新app版本内容成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新app版本内容失败", "");
		}

		return json;
	}

	@Override
	public String getAppVersionList(String id, String appType) {

		// TODO Auto-generated method stub
		String json = "";
		List<AppVersion> appVersion = appVersionDao.getAppVersion(id, appType);
		if (appVersion != null) {

			json = ResultObjectList.obj2JsonResult("1", "获取app版本内容成功", appVersion);
		} else {
			json = ResultResponse.obj2JsonResult("0", "获取app版本内容失败", "");
		}
		return json;
	}

}
