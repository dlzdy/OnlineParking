/**
 * Project Name:OnlineParking
 * File Name:ClientUser.java
 * Package Name:com.yinzitech.onlineparking.entity.client.user
 * Date:2015年10月4日上午3:12:54
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.client.user;

import java.io.Serializable;

/**
 * ClassName:ClientUser <br/>
 * Function: 终端用户数据库表. <br/>
 * 对应数据库表 client_user. <br/>
 * Date: 2015年10月4日 上午2:38:31 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class ClientUser implements Serializable {

	public ClientUser() {
		super();
	}

	public ClientUser(String clientUserId, String clientUserSecurity, String clientUserCellphone, String clientUserSex,
			String clientUserNickName, String clientUserBirthday, String clientUserSignUpTime,
			String clientUserActiveMark, String clientUserAutoPay, String clientUserRegistrAtionId,
			String clientUserType) {
		super();
		this.clientUserId = clientUserId;
		this.clientUserSecurity = clientUserSecurity;
		this.clientUserCellphone = clientUserCellphone;
		this.clientUserSex = clientUserSex;
		this.clientUserNickName = clientUserNickName;
		this.clientUserBirthday = clientUserBirthday;
		this.clientUserSignUpTime = clientUserSignUpTime;
		this.clientUserActiveMark = clientUserActiveMark;
		this.clientUserAutoPay = clientUserAutoPay;
		this.clientUserRegistrAtionId = clientUserRegistrAtionId;
		this.clientUserType = clientUserType;
	}

	@Override
	public String toString() {
		return "ClientUser [clientUserId=" + clientUserId + ", clientUserSecurity=" + clientUserSecurity
				+ ", clientUserCellphone=" + clientUserCellphone + ", clientUserSex=" + clientUserSex
				+ ", clientUserNickName=" + clientUserNickName + ", clientUserBirthday=" + clientUserBirthday
				+ ", clientUserSignUpTime=" + clientUserSignUpTime + ", clientUserActiveMark=" + clientUserActiveMark
				+ ", clientUserAutoPay=" + clientUserAutoPay + ", clientUserRegistrAtionId=" + clientUserRegistrAtionId
				+ ", clientUserType=" + clientUserType + "]";
	}

	public String getClientUserId() {
		return clientUserId;
	}

	public void setClientUserId(String clientUserId) {
		this.clientUserId = clientUserId;
	}

	public String getClientUserSecurity() {
		return clientUserSecurity;
	}

	public void setClientUserSecurity(String clientUserSecurity) {
		this.clientUserSecurity = clientUserSecurity;
	}

	public String getClientUserCellphone() {
		return clientUserCellphone;
	}

	public void setClientUserCellphone(String clientUserCellphone) {
		this.clientUserCellphone = clientUserCellphone;
	}

	public String getClientUserSex() {
		return clientUserSex;
	}

	public void setClientUserSex(String clientUserSex) {
		this.clientUserSex = clientUserSex;
	}

	public String getClientUserNickName() {
		return clientUserNickName;
	}

	public void setClientUserNickName(String clientUserNickName) {
		this.clientUserNickName = clientUserNickName;
	}

	public String getClientUserBirthday() {
		return clientUserBirthday;
	}

	public void setClientUserBirthday(String clientUserBirthday) {
		this.clientUserBirthday = clientUserBirthday;
	}

	public String getClientUserSignUpTime() {
		return clientUserSignUpTime;
	}

	public void setClientUserSignUpTime(String clientUserSignUpTime) {
		this.clientUserSignUpTime = clientUserSignUpTime;
	}

	public String getClientUserActiveMark() {
		return clientUserActiveMark;
	}

	public void setClientUserActiveMark(String clientUserActiveMark) {
		this.clientUserActiveMark = clientUserActiveMark;
	}

	public String getClientUserAutoPay() {
		return clientUserAutoPay;
	}

	public void setClientUserAutoPay(String clientUserAutoPay) {
		this.clientUserAutoPay = clientUserAutoPay;
	}

	public String getClientUserRegistrAtionId() {
		return clientUserRegistrAtionId;
	}

	public void setClientUserRegistrAtionId(String clientUserRegistrAtionId) {
		this.clientUserRegistrAtionId = clientUserRegistrAtionId;
	}

	public String getClientUserType() {
		return clientUserType;
	}

	public void setClientUserType(String clientUserType) {
		this.clientUserType = clientUserType;
	}

	/**
	 * 属性:clientUserId<br/>
	 * 用途:汽车车主用户id<br/>
	 * 对应数据库表:client_user<br/>
	 * 对应数据库字段:client_user_id<br/>
	 * 数据库类型varchar 长度100 数据库中不自动初始化, 用户新建账户时由调用生成器生成<br/>
	 */
	public String clientUserId;

	/**
	 * 属性:clientUserSecurity<br/>
	 * 用途:汽车车主用户安全识令牌<br/>
	 * 对应数据库表:client_user<br/>
	 * 对应数据库字段:client_user_security<br/>
	 * 数据库类型varchar 长度100用户注册成功后,由服务器发送到用户手机管理一份,中心服务器管理一份 关联服务 torken服务器<br/>
	 */
	public String clientUserSecurity;

	/**
	 * 属性:clientUserCellphone<br/>
	 * 用途:汽车车主用户手机号<br/>
	 * 对应数据库表:client_user<br/>
	 * 对应数据库字段:client_user_cellphone<br/>
	 * 数据库类型varchar 长度12 默认为空,由用户填写初始化,不允许为空<br/>
	 */
	public String clientUserCellphone;

	/**
	 * 属性:clientUserSex<br/>
	 * 用途:汽车车主用户性别<br/>
	 * 对应数据库表:client_user<br/>
	 * 对应数据库字段:client_user_sex<br/>
	 * 数据库类型varchar 长度6 默认为空,由用户填写初始化,不允许为空,<br/>
	 * 
	 */
	public String clientUserSex;

	/**
	 * 属性:clientUserNickName<br/>
	 * 用途:汽车车主昵称 <br/>
	 * 对应数据库表:client_user<br/>
	 * 对应数据库字段:client_user_nick_name<br/>
	 * 数据库类型varchar 长度50 默认为空,由用户填写<br/>
	 * 
	 */
	public String clientUserNickName;

	/**
	 * 属性:clientUserBirthday<br/>
	 * 用途:汽车车主用户生日<br/>
	 * 对应数据库表:client_user<br/>
	 * 对应数据库字段:client_user_birthday<br/>
	 * 数据库类型varchar 长度10 默认为空,由用户填写 格式YYYY-MM-DD 年-月-日 eg:1999-01-01<br/>
	 */
	public String clientUserBirthday;

	/**
	 * 属性:clientUserSignUpTime<br/>
	 * 用途:汽车车主用户注册日期<br/>
	 * 对应数据库表:client_user<br/>
	 * 对应数据库字段:client_user_sign_up_time<br/>
	 * 数据库类型varchar 长度19 默认为空,格式YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01
	 * 13:22:22<br/>
	 */
	public String clientUserSignUpTime;

	/**
	 * 属性:clientUserActiveMark<br/>
	 * 用途:汽车车主用户激活状态标记<br/>
	 * 对应数据库表:client_user<br/>
	 * 对应数据库字段:client_user_active_mark<br/>
	 * 数据库类型varchar 长度7 默认为enable可用 enable可用,disable为不可用
	 */
	public String clientUserActiveMark;
	/**
	 * 自动支付
	 */
	public String clientUserAutoPay;
	/**
	 * 推送账户id
	 */
	public String clientUserRegistrAtionId;
	/**
	 * 用户手机类型
	 */
	public String clientUserType;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = -1489392330443481647L;

}
