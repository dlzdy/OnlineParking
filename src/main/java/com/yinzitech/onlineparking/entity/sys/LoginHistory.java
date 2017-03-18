/**
 * Project Name:OnlineParking
 * File Name:LoginHistery.java
 * Package Name:com.yinzitech.onlineparking.dao.sys
 * Date:2015年10月22日下午4:57:17
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.sys;

import java.io.Serializable;

/**
 * ClassName:LoginHistery <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月22日 下午4:57:17 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class LoginHistory implements Serializable {

	@Override
	public String toString() {
		return "LoginHistery [loginHistoryId=" + loginHistoryId + ", loginHistoryCustId=" + loginHistoryCustId
				+ ", loginHistoryStart=" + loginHistoryStart + ", loginHistoryEnd=" + loginHistoryEnd
				+ ", loginHistoryType=" + loginHistoryType + "]";
	}

	public LoginHistory() {
		super();
	}

	public LoginHistory(String loginHistoryId, String loginHistoryCustId, String loginHistoryStart,
			String loginHistoryEnd, String loginHistoryType) {
		super();
		this.loginHistoryId = loginHistoryId;
		this.loginHistoryCustId = loginHistoryCustId;
		this.loginHistoryStart = loginHistoryStart;
		this.loginHistoryEnd = loginHistoryEnd;
		this.loginHistoryType = loginHistoryType;
	}

	public String getLoginHistoryId() {
		return loginHistoryId;
	}

	public void setLoginHistoryId(String loginHistoryId) {
		this.loginHistoryId = loginHistoryId;
	}

	public String getLoginHistoryCustId() {
		return loginHistoryCustId;
	}

	public void setLoginHistoryCustId(String loginHistoryCustId) {
		this.loginHistoryCustId = loginHistoryCustId;
	}

	public String getLoginHistoryStart() {
		return loginHistoryStart;
	}

	public void setLoginHistoryStart(String loginHistoryStart) {
		this.loginHistoryStart = loginHistoryStart;
	}

	public String getLoginHistoryEnd() {
		return loginHistoryEnd;
	}

	public void setLoginHistoryEnd(String loginHistoryEnd) {
		this.loginHistoryEnd = loginHistoryEnd;
	}

	public String getLoginHistoryType() {
		return loginHistoryType;
	}

	public void setLoginHistoryType(String loginHistoryType) {
		this.loginHistoryType = loginHistoryType;
	}

	/**
	 * 主键id
	 */
	public String loginHistoryId;
	/**
	 * userId
	 */
	public String loginHistoryCustId;
	/**
	 * 登录时间
	 */
	public String loginHistoryStart;
	/**
	 * 退出时间
	 */
	public String loginHistoryEnd;
	/**
	 * 类型<br/>
	 * 0 sys<br/>
	 * 1 user<br/>
	 * 2 handSet<br/>
	 * 3 parkManager<br/>
	 */
	public String loginHistoryType;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = 5447437921834021548L;

}
