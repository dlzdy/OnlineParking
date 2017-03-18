/**
 * Project Name:OnlineParking
 * File Name:FundAccountManage.java
 * Package Name:com.yinzitech.onlineparking.entity.fundAccountManage
 * Date:2015年10月5日上午12:26:59
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.entity.fundAccountManage;

import java.io.Serializable;

/**
 * ClassName: FundAccountManage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO 'fund_account_manage 用户账户信息管理表 类FndAccountManage 用户账户信息管理核心类
 * 主要管理账户信息 使用外键 foreign_key指向Id 包括 余额, 上次操作时间 上次资金变动 与终端用户client_user n:1关系';
 * (可选). <br/>
 * date: 2015年10月5日 上午12:26:59 <br/>
 *
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 */
public class FundAccountManage implements Serializable {

	@Override
	public String toString() {
		return "FundAccountManage [fundAccountId=" + fundAccountId + ", custId=" + custId + ", subaccountType="
				+ subaccountType + ", fundAccountManageAmount=" + fundAccountManageAmount
				+ ", fundAccountManageProperty=" + fundAccountManageProperty + ", fundAccountManageState="
				+ fundAccountManageState + ", fundAccountManageCreateTime=" + fundAccountManageCreateTime + "]";
	}

	public FundAccountManage() {
		super();
	}

	public FundAccountManage(String fundAccountId, String custId, String subaccountType, String fundAccountManageAmount,
			String fundAccountManageProperty, String fundAccountManageState, String fundAccountManageCreateTime) {
		super();
		this.fundAccountId = fundAccountId;
		this.custId = custId;
		this.subaccountType = subaccountType;
		this.fundAccountManageAmount = fundAccountManageAmount;
		this.fundAccountManageProperty = fundAccountManageProperty;
		this.fundAccountManageState = fundAccountManageState;
		this.fundAccountManageCreateTime = fundAccountManageCreateTime;
	}

	public String getFundAccountId() {
		return fundAccountId;
	}

	public void setFundAccountId(String fundAccountId) {
		this.fundAccountId = fundAccountId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getSubaccountType() {
		return subaccountType;
	}

	public void setSubaccountType(String subaccountType) {
		this.subaccountType = subaccountType;
	}

	public String getFundAccountManageAmount() {

		return fundAccountManageAmount;
	}

	public void setFundAccountManageAmount(String fundAccountManageAmount) {
		this.fundAccountManageAmount = fundAccountManageAmount;
	}

	public String getFundAccountManageProperty() {
		return fundAccountManageProperty;
	}

	public void setFundAccountManageProperty(String fundAccountManageProperty) {
		this.fundAccountManageProperty = fundAccountManageProperty;
	}

	public String getFundAccountManageState() {
		return fundAccountManageState;
	}

	public void setFundAccountManageState(String fundAccountManageState) {
		this.fundAccountManageState = fundAccountManageState;
	}

	public String getFundAccountManageCreateTime() {
		return fundAccountManageCreateTime;
	}

	public void setFundAccountManageCreateTime(String fundAccountManageCreateTime) {
		this.fundAccountManageCreateTime = fundAccountManageCreateTime;
	}

	/**
	 * 'fund_account_id 资金管理账户id 数据库表fund_account_manage 对应实体类FundAccountManage
	 * 属性 fundAccountId; 属性类型String,数据库类型varchar 长度100 数据库中不自动初始化,
	 * 新建账户时由调用生成器生成',
	 */
	public String fundAccountId;
	/**
	 * 'cust_id 用户账户编号 这里对应三类用户 type 1) client_user中的client_user_id type 2)
	 * parking_manager中的parking_manager_id type 3)
	 * handset_manager中的handset_manager_id 数据库表fund_account_manage
	 * 对应实体类FundAccountManage 属性 custId; 属性类型String,数据库类型varchar 长度100
	 * 数据库中不自动初始化, 以此字段与用户表关联1:1关系',
	 */
	public String custId;
	/**
	 * 'subaccount_type 关联账户号类型 这里对应三类用户 type 1) 终端用户 对应client_user
	 * 使用表中的client_user_id type 2) 停车场场主 对应parking_manager
	 * 使用表中的parking_manager_id type 3) 手持机管理员
	 * 对应handset_manager使用表中的handset_manager_id 数据库表fund_account_manage
	 * 对应实体类FundAccountManage 属性 subaccountType; 属性类型String,数据库类型varchar 长度4
	 * 数据库中不自动初始化, 创建账户时,根据实际情况设置',
	 */
	public String subaccountType;
	/**
	 * 'fund_account_manage_amount 账户名下总金额 对应 数据库表fund_account_manage;
	 * 对应实体类FundAccountManage; 属性 fundAccountManageAmount;
	 * 属性类型String,数据库类型varchar 长度15 数据库中自动初始化为0 设计值为000 代表0.00元 使用时,先乘以系数100
	 * 将实际金额转换为绝对整数后,进行运算,在运算结束后再除以系数100将换算为实际金额',
	 */
	public String fundAccountManageAmount;
	/**
	 * 'fund_account_manage_property 账户性质 type 1 个人用户账户 type 2 企业用户账户 对应
	 * 数据库表fund_account_manage; 对应实体类FundAccountManage; 属性
	 * fundAccountManageProperty; 属性类型String,数据库类型char 长度1
	 * 数据库中不自动初始化,有资金账户建立时初始化设置',
	 */
	public String fundAccountManageProperty;
	/**
	 * 'fund_account_manage_state 账户状态 type 00---生效状态 type 01---冻结 type 02---注销
	 * 对应 数据库表fund_account_manage; 对应实体类FundAccountManage; 属性
	 * fundAccountManageState; 属性类型String,数据库类型char 长度2 数据库中自动初始化为00',
	 */
	public String fundAccountManageState;
	/**
	 * 'fund_account_manage_create_time 资金账户创建时间 数据库表client_user 对应实体类ClientUser
	 * 属性 fundAccountManageCreateTime 属性类型String,数据库类型varchar 长度20 默认为空,由用户填写
	 * 格式YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01 13:22:22',
	 */
	public String fundAccountManageCreateTime;
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60 
	 */
	private static final long serialVersionUID = -4629836175086557476L;

}
