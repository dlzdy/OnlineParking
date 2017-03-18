/**
 * Project Name:OnlineParking
 * File Name:TradingOrders.java
 * Package Name:com.yinzitech.onlineparking.entity.order
 * Date:2015年10月7日下午2:39:31
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.order;

import java.io.Serializable;

/**
 * ClassName:TradingOrders <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: 交易订单 对应实体类 TradingOders 用户对用户的之间资金账户交易发生变动的订单'. <br/>
 * Date: 2015年10月7日 下午2:39:31 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class TradingOrders implements Serializable {

	@Override
	public String toString() {
		return "TradingOrders [tradingOrderId=" + tradingOrderId + ", tradingOrderSrcCustId=" + tradingOrderSrcCustId
				+ ", tradingOrderPayCustFundAccountId=" + tradingOrderPayCustFundAccountId
				+ ", tradingOrderParkingOrderId=" + tradingOrderParkingOrderId + ", tradingOrderPayeeCustId="
				+ tradingOrderPayeeCustId + ", tradingOrderPayeeCustFundAccountId=" + tradingOrderPayeeCustFundAccountId
				+ ", tradingOrderState=" + tradingOrderState + ", tradingOrderpayState=" + tradingOrderpayState
				+ ", tradingOrderBalanceState=" + tradingOrderBalanceState + ", tradingOrderCreateTime="
				+ tradingOrderCreateTime + "]";
	}

	public TradingOrders() {
		super();
	}

	public TradingOrders(String tradingOrderId, String tradingOrderSrcCustId, String tradingOrderPayCustFundAccountId,
			String tradingOrderParkingOrderId, String tradingOrderPayeeCustId,
			String tradingOrderPayeeCustFundAccountId, String tradingOrderState, String tradingOrderpayState,
			String tradingOrderBalanceState, String tradingOrderCreateTime) {
		super();
		this.tradingOrderId = tradingOrderId;
		this.tradingOrderSrcCustId = tradingOrderSrcCustId;
		this.tradingOrderPayCustFundAccountId = tradingOrderPayCustFundAccountId;
		this.tradingOrderParkingOrderId = tradingOrderParkingOrderId;
		this.tradingOrderPayeeCustId = tradingOrderPayeeCustId;
		this.tradingOrderPayeeCustFundAccountId = tradingOrderPayeeCustFundAccountId;
		this.tradingOrderState = tradingOrderState;
		this.tradingOrderpayState = tradingOrderpayState;
		this.tradingOrderBalanceState = tradingOrderBalanceState;
		this.tradingOrderCreateTime = tradingOrderCreateTime;
	}

	public String getTradingOrderId() {
		return tradingOrderId;
	}

	public void setTradingOrderId(String tradingOrderId) {
		this.tradingOrderId = tradingOrderId;
	}

	public String getTradingOrderSrcCustId() {
		return tradingOrderSrcCustId;
	}

	public void setTradingOrderSrcCustId(String tradingOrderSrcCustId) {
		this.tradingOrderSrcCustId = tradingOrderSrcCustId;
	}

	public String getTradingOrderPayCustFundAccountId() {
		return tradingOrderPayCustFundAccountId;
	}

	public void setTradingOrderPayCustFundAccountId(String tradingOrderPayCustFundAccountId) {
		this.tradingOrderPayCustFundAccountId = tradingOrderPayCustFundAccountId;
	}

	public String getTradingOrderParkingOrderId() {
		return tradingOrderParkingOrderId;
	}

	public void setTradingOrderParkingOrderId(String tradingOrderParkingOrderId) {
		this.tradingOrderParkingOrderId = tradingOrderParkingOrderId;
	}

	public String getTradingOrderPayeeCustId() {
		return tradingOrderPayeeCustId;
	}

	public void setTradingOrderPayeeCustId(String tradingOrderPayeeCustId) {
		this.tradingOrderPayeeCustId = tradingOrderPayeeCustId;
	}

	public String getTradingOrderPayeeCustFundAccountId() {
		return tradingOrderPayeeCustFundAccountId;
	}

	public void setTradingOrderPayeeCustFundAccountId(String tradingOrderPayeeCustFundAccountId) {
		this.tradingOrderPayeeCustFundAccountId = tradingOrderPayeeCustFundAccountId;
	}

	public String getTradingOrderState() {
		return tradingOrderState;
	}

	public void setTradingOrderState(String tradingOrderState) {
		this.tradingOrderState = tradingOrderState;
	}

	public String getTradingOrderpayState() {
		return tradingOrderpayState;
	}

	public void setTradingOrderpayState(String tradingOrderpayState) {
		this.tradingOrderpayState = tradingOrderpayState;
	}

	public String getTradingOrderBalanceState() {
		return tradingOrderBalanceState;
	}

	public void setTradingOrderBalanceState(String tradingOrderBalanceState) {
		this.tradingOrderBalanceState = tradingOrderBalanceState;
	}

	public String getTradingOrderCreateTime() {
		return tradingOrderCreateTime;
	}

	public void setTradingOrderCreateTime(String tradingOrderCreateTime) {
		this.tradingOrderCreateTime = tradingOrderCreateTime;
	}

	/**
	 * 'trading_order_id 用户间交易订单主键Id 唯一键标识 对应数据库 trading_order 对应实体类
	 * TradingOrder 对应属性 tradingOrderId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 * 由主键生成器生成,完成初始化',
	 * 
	 */
	public String tradingOrderId;
	/**
	 * 'trading_order_src_cust_id 资金账户交易付款方客户编号 唯一键标识 对应数据库 trading_order 对应实体类
	 * TradingOrder 对应属性 tradingOrderSrcCustId 数据库字段类型 varchar 实体类字段类型 String
	 * 长度50 不可为空 为 client_user_id 字段',
	 * 
	 */
	public String tradingOrderSrcCustId;
	/**
	 * 'trading_order_pay_cust_fund_account_id 资金账户交易付款方客户资金管理账号 id 唯一键标识 对应数据库
	 * trading_order 对应实体类f TradingOrder 对应属性 tradingOrderPayCustFundAccountId
	 * 数据库字段类型 varchar 实体类字段类型 String 长度50 不可为空 为 fund_account_id 字段',
	 * 
	 */
	public String tradingOrderPayCustFundAccountId;
	/**
	 * 'trading_order_parking_order_id 资金账户交易对应订单号 唯一键标识 对应数据库 trading_order
	 * 对应实体类 TradingOrder 对应属性 tradingOrderParkingOrderId 数据库字段类型 varchar
	 * 实体类字段类型 String 长度50 不可为空 为 fund_account_id 字段',
	 * 
	 */
	public String tradingOrderParkingOrderId;
	/**
	 * 'trading_order_payee_cust_id 资金账户交易收款方客户编号 唯一键标识 对应数据库 trading_order
	 * 对应实体类 TradingOrder 对应属性 tradingOrderPayeeCustId 数据库字段类型 varchar 实体类字段类型
	 * String 长度50 不可为空 为 parking_info_id字段',
	 * 
	 */
	public String tradingOrderPayeeCustId;
	/**
	 * 'trading_order_payee_cust_fund_account_id 资金账户交易收款方客户资金管理账号 id 唯一键标识
	 * 对应数据库 trading_order 对应实体类f TradingOrder 对应属性
	 * tradingOrderPayeeCustFundAccountId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 * 不可为空 为 fund_account_id 字段',
	 * 
	 */
	public String tradingOrderPayeeCustFundAccountId;
	/**
	 * 'trading_order_state 支付交易订单交易订单交易状态 唯一键标识 对应数据库 trading_order 对应实体类
	 * TradingOrder 对应属性 tradingOrderState 数据库字段类型 varchar 实体类字段类型 String 默认 10
	 * 订单未完成 00 等待支付 01 订单已完成',
	 * 
	 */
	public String tradingOrderState;
	/**
	 * 'trading_order_pay_state 支付交易订单交易支付状态(支付) 唯一键标识 对应数据库 trading_order 对应实体类
	 * TradingOrder 对应属性 tradingOrderpayState 数据库字段类型 varchar 实体类字段类型 String 默认
	 * 10 未支付 00 等待支付 01 支付中 02 支付成功 03 支付失败',
	 * 
	 */
	public String tradingOrderpayState;
	/**
	 * 'trading_order_balance_State 支付交易订单付款方,与收款方资金账户变动状态 唯一键标识 对应数据库
	 * trading_order 对应实体类 TradingOrder 对应属性 tradingOrderBalanceState 数据库字段类型
	 * varchar 实体类字段类型 String 默认 00 付款方与收款方均未登记账户变动 01
	 * 付款方已经完成登记账户变动,收款方未完成登记账户变动 02 付款方未完成登记账户变动,收款方已完成登记账户变动 03
	 * 付款方与收款方均完成登记账户变动',
	 * 
	 */
	public String tradingOrderBalanceState;

	/**
	 * trading_order_tran_amount 支付交易订单j支付金额 对应数据库 trading_order 对应实体类
	 * TradingOrder 对应属性 tradingOrderTranAmount 数据库字段类型 varchar 实体类字段类型 String
	 * 长度 15 数据库中自动初始化为0 设计值为 000 代表 0.00元 使用时,先乘以系数100
	 * 将实际金额转换为绝对整数后,进行运算,在运算结束后再除以系数100将换算为实际金额
	 */

	public String tradingOrderTranAmount;
	/**
	 * 'trading_order_create_time 支付交易订单创建时间 对应数据库 trading_order 对应实体类
	 * TradingOrder 对应属性 tradingOrderCreateTime 数据库字段类型 varchar 实体类字段类型 String
	 * 长度 20 由订单初始化时调用时间生成器生成 格式 YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01
	 * 13:22:22',
	 * 
	 */
	public String tradingOrderCreateTime;
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = 7662771907984264686L;

}
