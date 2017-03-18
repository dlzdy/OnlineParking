/**
 * Project Name:OnlineParking
 * File Name:SystemManager.java
 * Package Name:com.yinzitech.onlineparking.entity.sys
 * Date:2015年10月6日上午10:30:45
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.sys;

import java.io.Serializable;

/**
 * ClassName:SystemManager <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO system_manager Online停车后台管理员 对应实体类 systemManager
 * Online停车平台后台管理员对应的模拟对象'. <br/>
 * Date: 2015年10月6日 上午10:30:45 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class SystemManager implements Serializable {

	@Override
	public String toString() {
		return "SystemManager [systemManagerId=" + systemManagerId + ", systemManagerUsername=" + systemManagerUsername
				+ ", systemManagerPsd=" + systemManagerPsd + ", systemManagerPhone=" + systemManagerPhone
				+ ", systemManagerEmail=" + systemManagerEmail + ", systemManagerCreateTime=" + systemManagerCreateTime
				+ ", systemManagerLastLoginTime=" + systemManagerLastLoginTime + ", systemManagerState="
				+ systemManagerState + "]";
	}

	public SystemManager() {
		super();
	}

	public SystemManager(String systemManagerId, String systemManagerUsername, String systemManagerPsd,
			String systemManagerPhone, String systemManagerEmail, String systemManagerCreateTime,
			String systemManagerLastLoginTime, String systemManagerState) {
		super();
		this.systemManagerId = systemManagerId;
		this.systemManagerUsername = systemManagerUsername;
		this.systemManagerPsd = systemManagerPsd;
		this.systemManagerPhone = systemManagerPhone;
		this.systemManagerEmail = systemManagerEmail;
		this.systemManagerCreateTime = systemManagerCreateTime;
		this.systemManagerLastLoginTime = systemManagerLastLoginTime;
		this.systemManagerState = systemManagerState;
	}

	public String getSystemManagerId() {
		return systemManagerId;
	}

	public void setSystemManagerId(String systemManagerId) {
		this.systemManagerId = systemManagerId;
	}

	public String getSystemManagerUsername() {
		return systemManagerUsername;
	}

	public void setSystemManagerUsername(String systemManagerUsername) {
		this.systemManagerUsername = systemManagerUsername;
	}

	public String getSystemManagerPsd() {
		return systemManagerPsd;
	}

	public void setSystemManagerPsd(String systemManagerPsd) {
		this.systemManagerPsd = systemManagerPsd;
	}

	public String getSystemManagerPhone() {
		return systemManagerPhone;
	}

	public void setSystemManagerPhone(String systemManagerPhone) {
		this.systemManagerPhone = systemManagerPhone;
	}

	public String getSystemManagerEmail() {
		return systemManagerEmail;
	}

	public void setSystemManagerEmail(String systemManagerEmail) {
		this.systemManagerEmail = systemManagerEmail;
	}

	public String getSystemManagerCreateTime() {
		return systemManagerCreateTime;
	}

	public void setSystemManagerCreateTime(String systemManagerCreateTime) {
		this.systemManagerCreateTime = systemManagerCreateTime;
	}

	public String getSystemManagerLastLoginTime() {
		return systemManagerLastLoginTime;
	}

	public void setSystemManagerLastLoginTime(String systemManagerLastLoginTime) {
		this.systemManagerLastLoginTime = systemManagerLastLoginTime;
	}

	public String getSystemManagerState() {
		return systemManagerState;
	}

	public void setSystemManagerState(String systemManagerState) {
		this.systemManagerState = systemManagerState;
	}

	/**
	 * 'system_manager_id 后台管理员用户账号主键id 数据库表 system_manager 对应实体类 systemManager
	 * 属性 systemManagerId 属性类型String,数据库类型varchar 长度100 数据库中不自动初始化,
	 * 管理员用户账号新建时由调用生成器生成',
	 * 
	 */
	public String systemManagerId;
	/**
	 * 'system_manager_username 后台管理员用户账号 数据库表 system_manager 对应实体类
	 * systemManager 属性 systemManagerUsername 属性类型String,数据库类型varchar 长度100
	 * 数据库中不自动初始化, 管理员用户账号新建时用户设置',
	 * 
	 */
	public String systemManagerUsername;
	/**
	 * 'system_manager_psd 后台管理员用户账号密码 数据库表 system_manager 对应实体类 systemManager
	 * 属性 systemManagerPsd 属性类型String,数据库类型varchar 长度100 数据库中不自动初始化,
	 * 管理员用户账号新建时用户设置',
	 * 
	 */
	public String systemManagerPsd;
	/**
	 * 'system_manager_phone 后台管理员用户账号联络手机号 数据库表 system_manager 对应实体类
	 * systemManager 属性 systemManagerPhone 属性类型String,数据库类型varchar 长度12
	 * 数据库中不自动初始化, 管理员用户账号新建时用户设置',
	 * 
	 */
	public String systemManagerPhone;
	/**
	 * 'system_manager_email 后台管理员用户账号联络手机号 数据库表 system_manager 对应实体类
	 * systemManager 属性 systemManagerEmail 属性类型String,数据库类型varchar 长度12
	 * 数据库中不自动初始化, 管理员用户账号新建时用户设置',
	 * 
	 */
	public String systemManagerEmail;
	/**
	 * 'system_manager_create_time 系统管理员用户账号最后登录时间 数据库表 system_manager 对应实体类
	 * systemManager 属性 systemManagerCreateTime 属性类型String,数据库类型varchar 20
	 * 默认为空,系统管理用户账号创建时由生成器生成 格式YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01
	 * 13:22:22',
	 * 
	 */
	public String systemManagerCreateTime;
	/**
	 * 'system_manager_last_login_time 系统管理员用户账号最后登录时间 数据库表 system_manager 对应实体类
	 * systemManager 属性 systemManagerLastLoginTime 属性类型String,数据库类型varchar 长度20
	 * 默认为空,系统管理用户账号登录时由生成器生成 格式YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01
	 * 13:22:22',
	 * 
	 */
	public String systemManagerLastLoginTime;
	/**
	 * 'system_manager_state 系统管理员用户账号状态 数据库表 system_manager 对应实体类 systemManager
	 * 属性 systemManagerState 属性类型String,数据库类型varchar 长度7 默认为 enable 可用 enable 可用
	 * disable 为不可用',
	 * 
	 */
	public String systemManagerState;
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = -6931847224588574626L;

}
