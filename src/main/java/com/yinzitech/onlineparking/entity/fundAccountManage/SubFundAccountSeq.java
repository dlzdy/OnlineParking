/**
 * Project Name:OnlineParking
 * File Name:SubFundAccountSeq.java
 * Package Name:com.yinzitech.onlineparking.entity.fundAccountManage
 * Date:2015年10月8日下午2:27:00
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.fundAccountManage;

import java.io.Serializable;

/**
 * ClassName:SubFundAccountSeq <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO 'sub_fund_account_seq 资金管理账户资金变动流水表 类 SubFundAcountSeq
 * 资金管理账户变动流水的核心类 通过字段下 关联的 fund_accoutn_id 关联资金管理账户 与终端资金管理账户 1:1关系'; <br/>
 * Date: 2015年10月8日 下午2:27:00 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class SubFundAccountSeq implements Serializable {

	@Override
	public String toString() {
		return "SubFundAccountSeq [subFundAccountSeqId=" + subFundAccountSeqId + ", subFundAccountSeqFundAccountId="
				+ subFundAccountSeqFundAccountId + ", subFundAccountSeqClientUserId=" + subFundAccountSeqClientUserId
				+ ", subFundAccountSeqClientUserCellphone=" + subFundAccountSeqClientUserCellphone
				+ ", subFundAccountSeqFlag=" + subFundAccountSeqFlag + ", subFundAccountSeqChangeType="
				+ subFundAccountSeqChangeType + ", subFundAccountSeqPreAmount=" + subFundAccountSeqPreAmount
				+ ", subFundAccountSeqAmount=" + subFundAccountSeqAmount + ", subFundAccountSeqRefsnOrderType="
				+ subFundAccountSeqRefsnOrderType + ", subFundAccountSeqRefsnOrderId=" + subFundAccountSeqRefsnOrderId
				+ ", subFundAccountSeqPreRefsnOrderType=" + subFundAccountSeqPreRefsnOrderType
				+ ", subFundAccountSqePreRefsnOrderId=" + subFundAccountSqePreRefsnOrderId
				+ ", subFundAccountSeqCreateTime=" + subFundAccountSeqCreateTime + "]";
	}

	public SubFundAccountSeq() {
		super();
	}

	public SubFundAccountSeq(String subFundAccountSeqId, String subFundAccountSeqFundAccountId,
			String subFundAccountSeqClientUserId, String subFundAccountSeqClientUserCellphone,
			String subFundAccountSeqFlag, String subFundAccountSeqChangeType, String subFundAccountSeqPreAmount,
			String subFundAccountSeqAmount, String subFundAccountSeqRefsnOrderType,
			String subFundAccountSeqRefsnOrderId, String subFundAccountSeqPreRefsnOrderType,
			String subFundAccountSqePreRefsnOrderId, String subFundAccountSeqCreateTime) {
		super();
		this.subFundAccountSeqId = subFundAccountSeqId;
		this.subFundAccountSeqFundAccountId = subFundAccountSeqFundAccountId;
		this.subFundAccountSeqClientUserId = subFundAccountSeqClientUserId;
		this.subFundAccountSeqClientUserCellphone = subFundAccountSeqClientUserCellphone;
		this.subFundAccountSeqFlag = subFundAccountSeqFlag;
		this.subFundAccountSeqChangeType = subFundAccountSeqChangeType;
		this.subFundAccountSeqPreAmount = subFundAccountSeqPreAmount;
		this.subFundAccountSeqAmount = subFundAccountSeqAmount;
		this.subFundAccountSeqRefsnOrderType = subFundAccountSeqRefsnOrderType;
		this.subFundAccountSeqRefsnOrderId = subFundAccountSeqRefsnOrderId;
		this.subFundAccountSeqPreRefsnOrderType = subFundAccountSeqPreRefsnOrderType;
		this.subFundAccountSqePreRefsnOrderId = subFundAccountSqePreRefsnOrderId;
		this.subFundAccountSeqCreateTime = subFundAccountSeqCreateTime;
	}

	public String getSubFundAccountSeqId() {
		return subFundAccountSeqId;
	}

	public void setSubFundAccountSeqId(String subFundAccountSeqId) {
		this.subFundAccountSeqId = subFundAccountSeqId;
	}

	public String getSubFundAccountSeqFundAccountId() {
		return subFundAccountSeqFundAccountId;
	}

	public void setSubFundAccountSeqFundAccountId(String subFundAccountSeqFundAccountId) {
		this.subFundAccountSeqFundAccountId = subFundAccountSeqFundAccountId;
	}

	public String getSubFundAccountSeqClientUserId() {
		return subFundAccountSeqClientUserId;
	}

	public void setSubFundAccountSeqClientUserId(String subFundAccountSeqClientUserId) {
		this.subFundAccountSeqClientUserId = subFundAccountSeqClientUserId;
	}

	public String getSubFundAccountSeqClientUserCellphone() {
		return subFundAccountSeqClientUserCellphone;
	}

	public void setSubFundAccountSeqClientUserCellphone(String subFundAccountSeqClientUserCellphone) {
		this.subFundAccountSeqClientUserCellphone = subFundAccountSeqClientUserCellphone;
	}

	public String getSubFundAccountSeqFlag() {
		return subFundAccountSeqFlag;
	}

	public void setSubFundAccountSeqFlag(String subFundAccountSeqFlag) {
		this.subFundAccountSeqFlag = subFundAccountSeqFlag;
	}

	public String getSubFundAccountSeqChangeType() {
		return subFundAccountSeqChangeType;
	}

	public void setSubFundAccountSeqChangeType(String subFundAccountSeqChangeType) {
		this.subFundAccountSeqChangeType = subFundAccountSeqChangeType;
	}

	public String getSubFundAccountSeqPreAmount() {
		return subFundAccountSeqPreAmount;
	}

	public void setSubFundAccountSeqPreAmount(String subFundAccountSeqPreAmount) {
		this.subFundAccountSeqPreAmount = subFundAccountSeqPreAmount;
	}

	public String getSubFundAccountSeqAmount() {
		return subFundAccountSeqAmount;
	}

	public void setSubFundAccountSeqAmount(String subFundAccountSeqAmount) {
		this.subFundAccountSeqAmount = subFundAccountSeqAmount;
	}

	public String getSubFundAccountSeqRefsnOrderType() {
		return subFundAccountSeqRefsnOrderType;
	}

	public void setSubFundAccountSeqRefsnOrderType(String subFundAccountSeqRefsnOrderType) {
		this.subFundAccountSeqRefsnOrderType = subFundAccountSeqRefsnOrderType;
	}

	public String getSubFundAccountSeqRefsnOrderId() {
		return subFundAccountSeqRefsnOrderId;
	}

	public void setSubFundAccountSeqRefsnOrderId(String subFundAccountSeqRefsnOrderId) {
		this.subFundAccountSeqRefsnOrderId = subFundAccountSeqRefsnOrderId;
	}

	public String getSubFundAccountSeqPreRefsnOrderType() {
		return subFundAccountSeqPreRefsnOrderType;
	}

	public void setSubFundAccountSeqPreRefsnOrderType(String subFundAccountSeqPreRefsnOrderType) {
		this.subFundAccountSeqPreRefsnOrderType = subFundAccountSeqPreRefsnOrderType;
	}

	public String getSubFundAccountSqePreRefsnOrderId() {
		return subFundAccountSqePreRefsnOrderId;
	}

	public void setSubFundAccountSqePreRefsnOrderId(String subFundAccountSqePreRefsnOrderId) {
		this.subFundAccountSqePreRefsnOrderId = subFundAccountSqePreRefsnOrderId;
	}

	public String getSubFundAccountSeqCreateTime() {
		return subFundAccountSeqCreateTime;
	}

	public void setSubFundAccountSeqCreateTime(String subFundAccountSeqCreateTime) {
		this.subFundAccountSeqCreateTime = subFundAccountSeqCreateTime;
	}

	/**
	 * 'sub_fund_account_seq_id 资金管理账户资金变动流水表主键 id 唯一键标识 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性 subFundAccountSeqId
	 * 数据库字段类型 varchar 实体类字段类型 String 长度50 由主键生成器生成,完成初始化',
	 * 
	 */
	public String subFundAccountSeqId;
	/**
	 * 'sub_fund_account_seq_fund_account_id 资金管理账户资金变动流水表对应用户资金管理账户 id 唯一键标识
	 * 对应数据库 sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSeqFundAccountId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 * 与用户资金管理账户 1:1对应 由主键生成器生成,完成初始化',
	 * 
	 */
	public String subFundAccountSeqFundAccountId;
	/**
	 * 'sub_fund_account_seq_client_user_id 资金管理账户资金变动流水表对应用户 id 唯一键标识 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSeqClientUserId 数据库字段类型 varchar 实体类字段类型 String 长度50 与用户账户
	 * 1:1对应 由主键生成器生成,完成初始化',
	 * 
	 */
	public String subFundAccountSeqClientUserId;
	/**
	 * 'sub_fund_account_seq_client_user_cellphone 资金管理账户资金变动流水表对应用户手机号 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSeqClientUserCellphone 数据库字段类型 varchar 实体类字段类型 String 长度50
	 * 与用户账户 1:1对应 由主键生成器生成,完成初始化',
	 * 
	 */
	public String subFundAccountSeqClientUserCellphone;
	/**
	 * 'sub_fund_account_seq_flag 资金管理账户资金变动流水中账户变动方向 唯一键标识 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性 subFundAccountSeqFlag
	 * 数据库字段类型 varchar 实体类字段类型 String 长度 1 0 来账 表示为账户收款 1 往账 表示为账户付款',
	 * 
	 */
	public String subFundAccountSeqFlag;
	/**
	 * 'sub_fund_account_seq_change_type 资金管理账户资金变动流水中账户变动类型 唯一键标识 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSeqChangeType 数据库字段类型 varchar 实体类字段类型 String 长度 2 01 充值 02
	 * 交易支付 03 提现 04 内部调账 05 结息 06 利息税 07 原交易退款 08 原交易撤销',
	 * 
	 */
	public String subFundAccountSeqChangeType;
	/**
	 * 'sub_fund_account_seq_pre_amount 资金管理账户资金变动流水中账户变动之前的账户内金额 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSeqPreAmount 数据库字段类型 varchar 实体类字段类型 String 长度 15
	 * 数据库中自动初始化为0 设计值为 000 代表 0.00元 使用时,先乘以系数100
	 * 将实际金额转换为绝对整数后,进行运算,在运算结束后再除以系数100将换算为实际金额',
	 * 
	 */
	public String subFundAccountSeqPreAmount;
	/**
	 * 'sub_fund_account_seq_amount 资金管理账户资金变动流水中账户变动的账户内金额 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性 subFundAccountSeqAmount
	 * 数据库字段类型 varchar 实体类字段类型 String 长度 15 数据库中自动初始化为0 设计值为 000 代表 0.00元
	 * 使用时,先乘以系数100 将实际金额转换为绝对整数后,进行运算,在运算结束后再除以系数100将换算为实际金额',
	 * 
	 */
	public String subFundAccountSeqAmount;
	/**
	 * 'sub_fund_account_seq_refsn_order_type 资金管理账户资金变动流水关联的订单类型 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSeqRefsnOrderType 数据库字段类型 varchar 实体类字段类型 String 长度 5 字段
	 * 001 关联支付订单 002 关联交易订单 003 关联提现订单',
	 * 
	 */
	public String subFundAccountSeqRefsnOrderType;
	/**
	 * 'sub_fund_account_seq_refsn_order_id 资金管理账户资金变动流水关联的订单id 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSeqRefsnOrderId 数据库字段类型 varchar 实体类字段类型 String 长度 50 字段
	 * sub_fund_account_seq_refsn_order_type 为 001 关联交易订单 取值为交易订单的主键 id 号
	 * trading_order_id 002 关联充值订单 取值为充值订单的主键 id 号 trading_order_id 003 关联提现订单
	 * 取值为提现订单的主键 id 号 trading_order_id',
	 * 
	 */
	public String subFundAccountSeqRefsnOrderId;
	/**
	 * 'sub_fund_account_seq_pre_refsn_order_type 资金管理账户上次资金变动流水关联的订单类型 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSeqPreRefsnOrderType 数据库字段类型 varchar 实体类字段类型 String 长度 5 字段
	 * 001 关联支付订单 002 关联交易订单 003 关联提现订单',
	 * 
	 */
	public String subFundAccountSeqPreRefsnOrderType;
	/**
	 * 'sub_fund_account_seq_pre_refsn_order_id 资金管理账户上次资金变动流水关联的订单id 对应数据库
	 * sub_fund_account_seq 对应实体类 SubFundAccountSeq 对应属性
	 * subFundAccountSqePreRefsnPrderId 数据库字段类型 varchar 实体类字段类型 String 长度 50 字段
	 * sub_fund_account_seq_pre_refsn_order_type 为 001 关联交易订单 取值为交易订单的主键 id 号
	 * trading_order_id 002 关联充值订单 取值为充值订单的主键 id 号 trading_order_id 003 关联提现订单
	 * 取值为提现订单的主键 id 号 trading_order_id',
	 * 
	 */
	public String subFundAccountSqePreRefsnOrderId;
	/**
	 * 'sub_fund_account_seq_create_time 资金账户创建时间 对应数据库 sub_fund_account_seq
	 * 对应实体类 SubFundAccountSeq 对应属性 subFundAccountSeqCreateTime 数据库字段类型 varchar
	 * 实体类字段类型 String 长度 20 默认为空,由用户填写 格式 YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒
	 * eg:1999-01-01 13:22:22',
	 * 
	 */
	public String subFundAccountSeqCreateTime;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = -4766499829776295510L;

}
