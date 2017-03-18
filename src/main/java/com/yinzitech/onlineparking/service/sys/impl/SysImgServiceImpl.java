/**
 * Project Name:OnlineParking
 * File Name:SysImgServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.sys.imp
 * Date:2015年10月13日下午2:15:44
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzitech.onlineparking.dao.sys.SysImgDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.sys.SysImg;
import com.yinzitech.onlineparking.service.sys.SysImgService;

/**
 * ClassName:SysImgServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午2:15:44 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
@Service
public class SysImgServiceImpl implements SysImgService {
	@Autowired
	SysImgDao sysImgDao;

	@Override
	public String upMainImg(String sysImgUpUserName, String sysImgUpTime, String sysImgMainName,
			String sysImgMainPath) {
		String json = "";
		int i = sysImgDao.upMainImg(sysImgUpUserName, sysImgUpTime, sysImgMainName, sysImgMainPath);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新成功:" + sysImgMainName + "", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新失败", "");
		}

		return json;
	}

	@Override
	public String upIosImg(String sysImgUpUserName, String sysImgUpTime, String sysImgIosName, String sysImgIosPath,
			String sysImgIosUrl) {
		String json = "";
		int i = sysImgDao.upIosImg(sysImgUpUserName, sysImgUpTime, sysImgIosName, sysImgIosPath, sysImgIosUrl);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新成功:" + sysImgIosName + "", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新失败", "");
		}

		return json;
	}

	@Override
	public String upAndroidImg(String sysImgUpUserName, String sysImgUpTime, String sysImgAndroidName,
			String sysImgAndroidPath, String sysImgAndroidUrl) {
		String json = "";
		int i = sysImgDao.upAndroidImg(sysImgUpUserName, sysImgUpTime, sysImgAndroidName, sysImgAndroidPath,
				sysImgAndroidUrl);

		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新成功:" + sysImgAndroidName + "", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新失败", "");
		}

		return json;
	}

	@Override
	public String upServerAddress(String sysImgUpUserName, String sysImgUpTime, String sysImgServerAddres) {
		String json = "";
		int i = sysImgDao.upServerAddress(sysImgUpUserName, sysImgUpTime, sysImgServerAddres);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新成功:" + sysImgServerAddres + "", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新失败", "");
		}

		return json;
	}

	@Override
	public String getSysImg() {
		String json = "";
		SysImg sysImg = sysImgDao.getSysImg();
		if (sysImg != null) {
			json = ResultObject.obj2JsonResult("1", "查询成功", sysImg);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		return json;
	}

}
