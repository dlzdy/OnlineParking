/**
 * Project Name:OnlineParking
 * File Name:SysImgService.java
 * Package Name:com.yinzitech.onlineparking.service.sys
 * Date:2015年10月13日上午11:19:31
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys;

/**
 * ClassName:SysImgService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 上午11:19:31 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface SysImgService {

	public String upMainImg(String sysImgUpUserName, String sysImgUpTime, String sysImgMainName, String sysImgMainPath);

	public String upIosImg(String sysImgUpUserName, String sysImgUpTime, String sysImgIosName, String sysImgIosPath,
			String sysImgIosUrl);

	public String upAndroidImg(String sysImgUpUserName, String sysImgUpTime, String sysImgAndroidName,
			String sysImgAndroidPath, String sysImgAndroidUrl);

	public String upServerAddress(String sysImgUpUserName, String sysImgUpTime, String sysImgServerAddres);

	public String getSysImg();
}
