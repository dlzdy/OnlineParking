/**
 * Project Name:OnlineParking
 * File Name:TradingOrdersService.java
 * Package Name:com.yinzitech.onlineparking.service.order
 * Date:2015年10月7日下午4:42:53
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.order;

/**
 * ClassName:TradingOrdersService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月7日 下午4:42:53 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface TradingOrdersService {
	/**
	 * 
	 * insertTradingOrder:(创建交易订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderParkingOrderId
	 *            资金账户交易对应订单号
	 * @param tradingOrderState
	 *            支付交易订单交易订单交易状态
	 * @param tradingOrderpayState
	 *            支付交易订单交易支付状态(支付)
	 * @param tradingOrderBalanceState
	 *            支付交易订单付款方,与收款方资金账户变动状态
	 * @return
	 * @since JDK 1.8u60
	 */
	public String insertTradingOrder(String tradingOrderParkingOrderId, String tradingOrderState,
			String tradingOrderpayState, String tradingOrderBalanceState);

	/**
	 * 
	 * upTradingOrderState:(更改支付交易订单交易订单交易状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderState
	 *            'trading_order_state 支付交易订单交易订单交易状态 唯一键标识 对应数据库 trading_order
	 *            对应实体类 TradingOrder 对应属性 tradingOrderState 数据库字段类型 varchar
	 *            实体类字段类型 String 默认 10 订单未完成 00 等待支付 01 订单已完成'
	 * @param tradingOrderParkingOrderId
	 *            'trading_order_parking_order_id 资金账户交易对应订单号 唯一键标识 对应数据库
	 *            trading_order 对应实体类 TradingOrder 对应属性
	 *            tradingOrderParkingOrderId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 *            不可为空 为 fund_account_id 字段'
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upTradingOrderState(String tradingOrderState, String tradingOrderParkingOrderId);

	/**
	 * 
	 * upTradingOrderpayState:(更改支付交易订单交易支付状态(支付)). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderpayState
	 *            'trading_order_pay_state 支付交易订单交易支付状态(支付) 唯一键标识 对应数据库
	 *            trading_order 对应实体类 TradingOrder 对应属性 tradingOrderpayState
	 *            数据库字段类型 varchar 实体类字段类型 String 默认 10 未支付 00 等待支付 01 支付中 02
	 *            支付成功 03 支付失败',
	 * @param tradingOrderParkingOrderId
	 *            'trading_order_parking_order_id 资金账户交易对应订单号 唯一键标识 对应数据库
	 *            trading_order 对应实体类 TradingOrder 对应属性
	 *            tradingOrderParkingOrderId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 *            不可为空 为 fund_account_id 字段'
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upTradingOrderpayState(String tradingOrderpayState, String tradingOrderParkingOrderId);

	/**
	 * 
	 * upTradingOrderBalanceState:(更改支付交易订单付款方,与收款方资金账户变动状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderBalanceState
	 *            'trading_order_balance_State 支付交易订单付款方,与收款方资金账户变动状态 唯一键标识
	 *            对应数据库 trading_order 对应实体类 TradingOrder 对应属性
	 *            tradingOrderBalanceState 数据库字段类型 varchar 实体类字段类型 String 默认 00
	 *            付款方与收款方均未登记账户变动 01 付款方已经完成登记账户变动,收款方未完成登记账户变动 02
	 *            付款方未完成登记账户变动,收款方已完成登记账户变动 03 付款方与收款方均完成登记账户变动',
	 * @param tradingOrderParkingOrderId
	 *            'trading_order_parking_order_id 资金账户交易对应订单号 唯一键标识 对应数据库
	 *            trading_order 对应实体类 TradingOrder 对应属性
	 *            tradingOrderParkingOrderId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 *            不可为空 为 fund_account_id 字段'
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upTradingOrderBalanceState(String tradingOrderBalanceState, String tradingOrderParkingOrderId);

	/**
	 * 
	 * deleteTradingOrderByOrderId:(通过订单号删除订单信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderParkingOrderId
	 *            'trading_order_parking_order_id 资金账户交易对应订单号 唯一键标识 对应数据库
	 *            trading_order 对应实体类 TradingOrder 对应属性
	 *            tradingOrderParkingOrderId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 *            不可为空 为 fund_account_id 字段'
	 * @return
	 * @since JDK 1.8u60
	 */
	public String deleteTradingOrderByOrderId(String tradingOrderParkingOrderId);

	/**
	 * 
	 * queryTradingOrderByPhone:(查询交易订单信息ByPhone). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param state
	 * @param userPhone
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryTradingOrderByPhone(String state, String userPhone, String startTime, String endTime,
			int pageNumber, int pageSize);

	/**
	 * 
	 * queryTradingOrderByParkName:(查询交易订单信息状态ByParkName). <br/>
	 * TODO(模糊查询).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkName
	 * @param startTime
	 * @param endTime
	 * @param state
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryTradingOrderByParkName(String parkName, String state, String startTime, String endTime,
			int pageNumber, int pageSize);

	/**
	 * 
	 * queryChargingOrder:(查询交易订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderSrcCustId
	 * @param tradingOrderParkingOrderId
	 * @param tradingOrderPayeeCustId
	 * @param tradingOrderState
	 * @param tradingOrderpayState
	 * @param tradingOrderBalanceState
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryTradingOrders(String tradingOrderSrcCustId, String tradingOrderParkingOrderId,
			String tradingOrderPayeeCustId, String tradingOrderState, String tradingOrderpayState,
			String tradingOrderBalanceState, String startTime, String endTime);

	/**
	 * 
	 * queryTradingOrdersLimit:(交易订单分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderSrcCustId
	 * @param tradingOrderParkingOrderId
	 * @param tradingOrderPayeeCustId
	 * @param tradingOrderState
	 * @param tradingOrderpayState
	 * @param tradingOrderBalanceState
	 * @param startTime
	 * @param endTime
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryTradingOrdersLimit(String tradingOrderSrcCustId, String tradingOrderParkingOrderId,
			String tradingOrderPayeeCustId, String tradingOrderState, String tradingOrderpayState,
			String tradingOrderBalanceState, String startTime, String endTime, int pageNumber, int pageSize);
}
