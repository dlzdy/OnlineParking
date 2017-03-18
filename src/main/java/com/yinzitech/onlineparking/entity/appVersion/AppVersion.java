/**
 * Project Name:OnlineParking
 * File Name:AppVersion.java
 * Package Name:com.yinzitech.onlineparking.entity.appVersion
 * Date:2016年7月4日上午10:36:19
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.appVersion;

/**
 * ClassName:AppVersion <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年7月4日 上午10:36:19 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class AppVersion {
	String id;
	/**
	 * app名称
	 */
	String appName;
	/**
	 * 版本号
	 */
	String versionCode;
	/**
	 * 版本名
	 */
	String versionName;
	/**
	 * 下载地址
	 */
	String apkUrl;
	/**
	 * 更新日志
	 */
	String changeLog;
	/**
	 * 更新提醒内容
	 */
	String updateTips;
	/**
	 * 创建时间
	 */
	String createTime;

	/**
	 * 创建人id
	 */
	String createUserId;
	/**
	 * app类型
	 */
	String appType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getApkUrl() {
		return apkUrl;
	}

	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}

	public String getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(String changeLog) {
		this.changeLog = changeLog;
	}

	public String getUpdateTips() {
		return updateTips;
	}

	public void setUpdateTips(String updateTips) {
		this.updateTips = updateTips;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public AppVersion(String id, String appName, String versionCode, String versionName, String apkUrl, String changeLog,
			String updateTips, String createTime, String createUserId, String appType) {
		super();
		this.id = id;
		this.appName = appName;
		this.versionCode = versionCode;
		this.versionName = versionName;
		this.apkUrl = apkUrl;
		this.changeLog = changeLog;
		this.updateTips = updateTips;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.appType = appType;
	}

}
