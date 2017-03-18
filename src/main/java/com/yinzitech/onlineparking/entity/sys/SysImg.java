/**
 * Project Name:OnlineParking
 * File Name:SysImg.java
 * Package Name:com.yinzitech.onlineparking.entity.sys
 * Date:2015年10月13日上午11:08:51
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.sys;

import java.io.Serializable;

/**
 * ClassName:SysImg <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 上午11:08:51 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class SysImg implements Serializable{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = -2434241761365680188L;
	@Override
	public String toString() {
		return "SysImg [sysImgId=" + sysImgId + ", sysImgUpUserName=" + sysImgUpUserName + ", sysImgUpTime="
				+ sysImgUpTime + ", sysImgCreatTime=" + sysImgCreatTime + ", sysImgMainName=" + sysImgMainName
				+ ", sysImgMainPath=" + sysImgMainPath + ", sysImgIosName=" + sysImgIosName + ", sysImgIosPath="
				+ sysImgIosPath + ", sysImgIosUrl=" + sysImgIosUrl + ", sysImgAndroidName=" + sysImgAndroidName
				+ ", sysImgAndroidPath=" + sysImgAndroidPath + ", sysImgAndroidUrl=" + sysImgAndroidUrl
				+ ", sysImgServerAddres=" + sysImgServerAddres + "]";
	}

	public SysImg() {
		super();
	}

	public SysImg(String sysImgId, String sysImgUpUserName, String sysImgUpTime, String sysImgCreatTime,
			String sysImgMainName, String sysImgMainPath, String sysImgIosName, String sysImgIosPath,
			String sysImgIosUrl, String sysImgAndroidName, String sysImgAndroidPath, String sysImgAndroidUrl,
			String sysImgServerAddres) {
		super();
		this.sysImgId = sysImgId;
		this.sysImgUpUserName = sysImgUpUserName;
		this.sysImgUpTime = sysImgUpTime;
		this.sysImgCreatTime = sysImgCreatTime;
		this.sysImgMainName = sysImgMainName;
		this.sysImgMainPath = sysImgMainPath;
		this.sysImgIosName = sysImgIosName;
		this.sysImgIosPath = sysImgIosPath;
		this.sysImgIosUrl = sysImgIosUrl;
		this.sysImgAndroidName = sysImgAndroidName;
		this.sysImgAndroidPath = sysImgAndroidPath;
		this.sysImgAndroidUrl = sysImgAndroidUrl;
		this.sysImgServerAddres = sysImgServerAddres;
	}

	public String getSysImgId() {
		return sysImgId;
	}

	public void setSysImgId(String sysImgId) {
		this.sysImgId = sysImgId;
	}

	public String getSysImgUpUserName() {
		return sysImgUpUserName;
	}

	public void setSysImgUpUserName(String sysImgUpUserName) {
		this.sysImgUpUserName = sysImgUpUserName;
	}

	public String getSysImgUpTime() {
		return sysImgUpTime;
	}

	public void setSysImgUpTime(String sysImgUpTime) {
		this.sysImgUpTime = sysImgUpTime;
	}

	public String getSysImgCreatTime() {
		return sysImgCreatTime;
	}

	public void setSysImgCreatTime(String sysImgCreatTime) {
		this.sysImgCreatTime = sysImgCreatTime;
	}

	public String getSysImgMainName() {
		return sysImgMainName;
	}

	public void setSysImgMainName(String sysImgMainName) {
		this.sysImgMainName = sysImgMainName;
	}

	public String getSysImgMainPath() {
		return sysImgMainPath;
	}

	public void setSysImgMainPath(String sysImgMainPath) {
		this.sysImgMainPath = sysImgMainPath;
	}

	public String getSysImgIosName() {
		return sysImgIosName;
	}

	public void setSysImgIosName(String sysImgIosName) {
		this.sysImgIosName = sysImgIosName;
	}

	public String getSysImgIosPath() {
		return sysImgIosPath;
	}

	public void setSysImgIosPath(String sysImgIosPath) {
		this.sysImgIosPath = sysImgIosPath;
	}

	public String getSysImgIosUrl() {
		return sysImgIosUrl;
	}

	public void setSysImgIosUrl(String sysImgIosUrl) {
		this.sysImgIosUrl = sysImgIosUrl;
	}

	public String getSysImgAndroidName() {
		return sysImgAndroidName;
	}

	public void setSysImgAndroidName(String sysImgAndroidName) {
		this.sysImgAndroidName = sysImgAndroidName;
	}

	public String getSysImgAndroidPath() {
		return sysImgAndroidPath;
	}

	public void setSysImgAndroidPath(String sysImgAndroidPath) {
		this.sysImgAndroidPath = sysImgAndroidPath;
	}

	public String getSysImgAndroidUrl() {
		return sysImgAndroidUrl;
	}

	public void setSysImgAndroidUrl(String sysImgAndroidUrl) {
		this.sysImgAndroidUrl = sysImgAndroidUrl;
	}

	public String getSysImgServerAddres() {
		return sysImgServerAddres;
	}

	public void setSysImgServerAddres(String sysImgServerAddres) {
		this.sysImgServerAddres = sysImgServerAddres;
	}

	public String sysImgId;
	public String sysImgUpUserName;
	public String sysImgUpTime;
	public String sysImgCreatTime;
	public String sysImgMainName;
	public String sysImgMainPath;
	public String sysImgIosName;
	public String sysImgIosPath;
	public String sysImgIosUrl;
	public String sysImgAndroidName;
	public String sysImgAndroidPath;
	public String sysImgAndroidUrl;
	public String sysImgServerAddres;
}
