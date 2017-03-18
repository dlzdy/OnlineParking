/**
 * Project Name:OnlineParking
 * File Name:ChargingOrder.java
 * Package Name:com.yinzitech.onlineparking.entity.order
 * Date:2015年10月8日下午2:31:07
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.order;

import java.io.Serializable;

/**
 * ClassName:ChargingOrder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO 'charging_order 充值订单 对应实体类 ChargingOrder 用户对用户的资金账户的充值订单'. <br/>
 * Date: 2015年10月8日 下午2:31:07 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ChargingOrder implements Serializable {

	@Override
	public String toString() {
		return "ChargingOrder [chargingOrderId=" + chargingOrderId + ", chargingOrder2FundAccountId="
				+ chargingOrder2FundAccountId + ", chargingOrder2ClientUserId=" + chargingOrder2ClientUserId
				+ ", chargingOrderChargingType=" + chargingOrderChargingType + ", chargingOrderChargingAccount="
				+ chargingOrderChargingAccount + ", chargingOrderPaymentPlatformId=" + chargingOrderPaymentPlatformId
				+ ", chargingOrderPaymentPlatformFeedback=" + chargingOrderPaymentPlatformFeedback
				+ ", chargingOrderAmount=" + chargingOrderAmount + ", chargingOrderCreateTime="
				+ chargingOrderCreateTime + "]";
	}

	public ChargingOrder() {
		super();
	}

	public ChargingOrder(String chargingOrderId, String chargingOrder2FundAccountId, String chargingOrder2ClientUserId,
			String chargingOrderChargingType, String chargingOrderChargingAccount,
			String chargingOrderPaymentPlatformId, String chargingOrderPaymentPlatformFeedback,
			String chargingOrderAmount, String chargingOrderCreateTime) {
		super();
		this.chargingOrderId = chargingOrderId;
		this.chargingOrder2FundAccountId = chargingOrder2FundAccountId;
		this.chargingOrder2ClientUserId = chargingOrder2ClientUserId;
		this.chargingOrderChargingType = chargingOrderChargingType;
		this.chargingOrderChargingAccount = chargingOrderChargingAccount;
		this.chargingOrderPaymentPlatformId = chargingOrderPaymentPlatformId;
		this.chargingOrderPaymentPlatformFeedback = chargingOrderPaymentPlatformFeedback;
		this.chargingOrderAmount = chargingOrderAmount;
		this.chargingOrderCreateTime = chargingOrderCreateTime;
	}

	public String getChargingOrderId() {
		return chargingOrderId;
	}

	public void setChargingOrderId(String chargingOrderId) {
		this.chargingOrderId = chargingOrderId;
	}

	public String getChargingOrder2FundAccountId() {
		return chargingOrder2FundAccountId;
	}

	public void setChargingOrder2FundAccountId(String chargingOrder2FundAccountId) {
		this.chargingOrder2FundAccountId = chargingOrder2FundAccountId;
	}

	public String getChargingOrder2ClientUserId() {
		return chargingOrder2ClientUserId;
	}

	public void setChargingOrder2ClientUserId(String chargingOrder2ClientUserId) {
		this.chargingOrder2ClientUserId = chargingOrder2ClientUserId;
	}

	public String getChargingOrderChargingType() {
		return chargingOrderChargingType;
	}

	public void setChargingOrderChargingType(String chargingOrderChargingType) {
		this.chargingOrderChargingType = chargingOrderChargingType;
	}

	public String getChargingOrderChargingAccount() {
		return chargingOrderChargingAccount;
	}

	public void setChargingOrderChargingAccount(String chargingOrderChargingAccount) {
		this.chargingOrderChargingAccount = chargingOrderChargingAccount;
	}

	public String getChargingOrderPaymentPlatformId() {
		return chargingOrderPaymentPlatformId;
	}

	public void setChargingOrderPaymentPlatformId(String chargingOrderPaymentPlatformId) {
		this.chargingOrderPaymentPlatformId = chargingOrderPaymentPlatformId;
	}

	public String getChargingOrderPaymentPlatformFeedback() {
		return chargingOrderPaymentPlatformFeedback;
	}

	public void setChargingOrderPaymentPlatformFeedback(String chargingOrderPaymentPlatformFeedback) {
		this.chargingOrderPaymentPlatformFeedback = chargingOrderPaymentPlatformFeedback;
	}

	public String getChargingOrderAmount() {
		return chargingOrderAmount;

	}

	public void setChargingOrderAmount(String chargingOrderAmount) {
		this.chargingOrderAmount = chargingOrderAmount;
	}

	public String getChargingOrderCreateTime() {
		return chargingOrderCreateTime;
	}

	public void setChargingOrderCreateTime(String chargingOrderCreateTime) {
		this.chargingOrderCreateTime = chargingOrderCreateTime;
	}

	/**
	 * 'charging_order_id 充值订单主键Id 唯一键标识 对应数据库 charging_order 对应实体类
	 * ChargingOrder 对应属性 chargingOrderId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 * 由主键生成器生成,完成初始化',
	 * 
	 */
	public String chargingOrderId;
	/**
	 * 'charging_order_2_fund_account_id 充值订单业务发起者充值的目标资金管理账号 对应
	 * fund_account_manage 中 fund_account_manage_id 1:1 对应数据库 charging_order
	 * 对应实体类 ChargingOrder 对应属性 chargingOrder2FundAccountId 数据库字段类型 varchar
	 * 实体类字段类型 String 长度100 不可为空',
	 * 
	 */
	public String chargingOrder2FundAccountId;
	/**
	 * 'charging_order_2_client_user_id 充值订单业务发起者充值的目标 client 用户账号 对应
	 * client_user中 client_user_id 1:1 对应数据库 charging_order 对应实体类 ChargingOrder
	 * 对应属性 chargingOrder2ClientUserId 数据库字段类型 varchar 实体类字段类型 String 长度100
	 * 不可为空',
	 * 
	 */
	public String chargingOrder2ClientUserId;
	/**
	 * 'charging_order_charging_type 充值订单业务发起者使用的支付渠道 对应数据库 charging_order 对应实体类
	 * ChargingOrder 对应属性 chargingOrderChargingType 数据库字段类型 varchar 实体类字段类型
	 * String 长度3 默认为0 值 1 支付宝支付渠道 值 2 微信支付渠道 值 3 银联宝支付渠道 如有其它 在进行递增',
	 * 
	 */
	public String chargingOrderChargingType;
	/**
	 * 'charging_order_charging_account 充值订单业务发起者使用的支付渠道账号 对应数据库 charging_order
	 * 对应实体类 ChargingOrder 对应属性 chargingOrderChargingAccount 数据库字段类型 varchar
	 * 实体类字段类型 String 长度100 不可为空 根据 harging_order_charging_type 值 1 支付宝支付渠道
	 * 为支付宝账号 值 2 微信支付渠道 为微信账号 值 3 银联宝支付渠道 为银联账号',
	 * 
	 */
	public String chargingOrderChargingAccount;
	/**
	 * 'charging_order_payment_platform_id 充值订单业务支付平台反馈的支付平台订单号,具体平台参照
	 * charging_order_charging_type 对应数据库 charging_order 对应实体类 ChargingOrder
	 * 对应属性 chargingOrderPaymentPlatformId 数据库字段类型 varchar 实体类字段类型 String 长度100
	 * 不可为空',
	 * 
	 */
	public String chargingOrderPaymentPlatformId;
	/**
	 * 'charging_order_payment_platform_feedback 充值订单业务支付平台反馈成功与否的标记
	 * charging_order_payment_platform_id附属标记 对应数据库 charging_order 对应实体类
	 * ChargingOrder 对应属性 chargingOrderPaymentPlatformFeedback 数据库字段类型 varchar
	 * 实体类字段类型 String 长度100 不可为空',
	 * 
	 */
	public String chargingOrderPaymentPlatformFeedback;
	/**
	 * 'charging_order_amount 充值订单充值金额 对应数据库 charging_order 对应实体类 ChargingOrder
	 * 对应属性 chargingOrderAmount 数据库字段类型 varchar 实体类字段类型 String 长度100 不可为空 长度 15
	 * 数据库中自动初始化为0 设计值为 000 代表 0.00元 使用时,先乘以系数100
	 * 将实际金额转换为绝对整数后,进行运算,在运算结束后再除以系数100将换算为实际金额',
	 * 
	 */
	public String chargingOrderAmount;
	/**
	 * 'charging_order_create_time 充值订单创建时间 对应数据库 charging_order 对应实体类
	 * ChargingOrder 对应属性 chargingOrderCreateTime 数据库字段类型 varchar 实体类字段类型 String
	 * 长度100 不可为空 长度 20 由订单初始化时调用时间生成器生成 格式 YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒
	 * eg:1999-01-01 13:22:22',
	 * 
	 */
	public String chargingOrderCreateTime;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = -8792913391128584661L;

}
