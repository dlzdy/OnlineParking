/**
 * Project Name:OnlineParking
 * File Name:SecurityCore.java
 * Package Name:com.yinzitech.onlineparking.entity.securityCore
 * Date:2015年10月8日下午2:26:17
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.securityCore;

import java.io.Serializable;

/**
 * ClassName:SecurityCore <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月8日 下午2:26:17 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class SecurityCore implements Serializable {

	@Override
	public String toString() {
		return "SecurityCore [SecurityCoreId=" + SecurityCoreId + ", securityCoreAccountType=" + securityCoreAccountType
				+ ", securityCoreAccountId=" + securityCoreAccountId + ", securityCoreAccountSecurity="
				+ securityCoreAccountSecurity + ", securityCoreState=" + securityCoreState + ", securityCoreCreateTime="
				+ securityCoreCreateTime + "]";
	}

	public SecurityCore(String securityCoreId, String securityCoreAccountType, String securityCoreAccountId,
			String securityCoreAccountSecurity, String securityCoreState, String securityCoreCreateTime) {
		super();
		SecurityCoreId = securityCoreId;
		this.securityCoreAccountType = securityCoreAccountType;
		this.securityCoreAccountId = securityCoreAccountId;
		this.securityCoreAccountSecurity = securityCoreAccountSecurity;
		this.securityCoreState = securityCoreState;
		this.securityCoreCreateTime = securityCoreCreateTime;
	}

	public SecurityCore() {
		super();
	}

	public String getSecurityCoreId() {
		return SecurityCoreId;
	}

	public void setSecurityCoreId(String securityCoreId) {
		SecurityCoreId = securityCoreId;
	}

	public String getSecurityCoreAccountType() {
		return securityCoreAccountType;
	}

	public void setSecurityCoreAccountType(String securityCoreAccountType) {
		this.securityCoreAccountType = securityCoreAccountType;
	}

	public String getSecurityCoreAccountId() {
		return securityCoreAccountId;
	}

	public void setSecurityCoreAccountId(String securityCoreAccountId) {
		this.securityCoreAccountId = securityCoreAccountId;
	}

	public String getSecurityCoreAccountSecurity() {
		return securityCoreAccountSecurity;
	}

	public void setSecurityCoreAccountSecurity(String securityCoreAccountSecurity) {
		this.securityCoreAccountSecurity = securityCoreAccountSecurity;
	}

	public String getSecurityCoreState() {
		return securityCoreState;
	}

	public void setSecurityCoreState(String securityCoreState) {
		this.securityCoreState = securityCoreState;
	}

	public String getSecurityCoreCreateTime() {
		return securityCoreCreateTime;
	}

	public void setSecurityCoreCreateTime(String securityCoreCreateTime) {
		this.securityCoreCreateTime = securityCoreCreateTime;
	}

	/**
	 * 'security_core_id 密匙验证类主键 对应数据库表 security_core 对应实体类 SecurityCore 字段
	 * SecurityCoreId 数据库类型 varchar 实体类字段类型 String 长度 50 由主键生成器自动生成',
	 * 
	 */
	public String SecurityCoreId;
	/**
	 * 'security_core_account_type 密匙验证类关联账户类型 对应数据库表 security_core 对应实体类
	 * SecurityCore 字段 securityCoreAccountType 数据库类型 varchar 实体类字段类型 String 长度 3
	 * 001 表示账户类型为终端用户类 002 表示账户类型为停车场场主管理员类 003 表示账户类型为停车场手持机管理员类',
	 * 
	 */
	public String securityCoreAccountType;
	/**
	 * 'security_core_account_id 密匙验证类关联账户id 对应数据库表 security_core 对应实体类
	 * SecurityCore 字段 securityCoreAccountId 数据库类型 varchar 实体类字段类型 String 长度 50
	 * 取决于 security_core_account_type 类型 当 security_core_account_type 值为 001
	 * 表示账户类型为终端用户类 该字段表示为终端用户的id 也就是 client_usder_id 002 表示账户类型为停车场场主管理员类
	 * 该字段表示为停车场场主的id 也就是 park_manager_id 003 表示账户类型为停车场手持机管理员类 该字段表示为手持机管理员的id
	 * 也就是 hadnset_manager_id',
	 * 
	 */
	public String securityCoreAccountId;
	/**
	 * 'security_core_account_security 登录密匙 对应数据库表 security_core 对应实体类
	 * SecurityCore 字段 securityCoreAccountSecurity 数据库类型 varchar 实体类字段类型 String
	 * 长度 50 由秘钥生成器自动生成',
	 * 
	 */
	public String securityCoreAccountSecurity;
	/**
	 * 'security_core_state 密匙验证状态 对应数据库表 security_core 对应实体类 SecurityCore 字段
	 * securityCoreState 数据库类型 varchar 实体类字段类型 String 长度 7 默认为 enable 可用
	 * enable可用 disable为不可用',
	 * 
	 */
	public String securityCoreState;
	/**
	 * 'security_core_create_time 登录密匙 对应数据库表 security_core 对应实体类 SecurityCore
	 * 字段 securityCoreCreateTime 数据库类型 varchar 实体类字段类型 String 长度 20 由时间生成器自动生成
	 * 格式 YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01 13:22:22',
	 * 
	 */
	public String securityCoreCreateTime;
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = 5275818003080477818L;

}
