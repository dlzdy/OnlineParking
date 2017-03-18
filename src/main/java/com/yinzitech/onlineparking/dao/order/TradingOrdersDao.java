/**
 * Project Name:OnlineParking
 * File Name:TradingOrdersDao.java
 * Package Name:com.yinzitech.onlineparking.dao.order
 * Date:2015年10月7日下午2:48:59
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.order.InterimTradingOrder;

/**
 * ClassName:TradingOrdersDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO 交易订单 <br/>
 * Date: 2015年10月7日 下午2:48:59 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface TradingOrdersDao {
	/**
	 * 
	 * insertTradingOrder:(创建交易订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderId
	 *            用户间交易订单主键Id
	 * @param tradingOrderSrcCustId
	 *            资金账户交易付款方客户编号
	 * @param tradingOrderPayCustFundAccountId
	 *            资金账户交易付款方客户资金管理账号
	 * @param tradingOrderParkingOrderId
	 *            资金账户交易对应订单号
	 * @param tradingOrderPayeeCustId
	 *            资金账户交易收款方客户编号
	 * @param tradingOrderPayeeCustFundAccountId
	 *            资金账户交易收款方客户资金管理账号
	 * @param tradingOrderState
	 *            支付交易订单交易订单交易状态
	 * @param tradingOrderpayState
	 *            支付交易订单交易支付状态(支付)
	 * @param tradingOrderBalanceState
	 *            支付交易订单付款方,与收款方资金账户变动状态
	 * @param tradingOrderCreateTime
	 *            支付交易订单创建时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO trading_orders (trading_order_id,trading_order_src_cust_id,trading_order_pay_cust_fund_account_id,trading_order_parking_order_id,trading_order_payee_cust_id,trading_order_payee_cust_fund_account_id,trading_order_state,trading_order_pay_state,trading_order_balance_State,trading_order_tran_amount,trading_order_create_time) VALUES (#{tradingOrderId},#{tradingOrderSrcCustId},#{tradingOrderPayCustFundAccountId},#{tradingOrderParkingOrderId},#{tradingOrderPayeeCustId},#{tradingOrderPayeeCustFundAccountId},#{tradingOrderState},#{tradingOrderpayState},#{tradingOrderBalanceState},#{tradingOrderTranAmount},#{tradingOrderCreateTime})")
	public int insertTradingOrder(@Param("tradingOrderId") String tradingOrderId,
			@Param("tradingOrderSrcCustId") String tradingOrderSrcCustId,
			@Param("tradingOrderPayCustFundAccountId") String tradingOrderPayCustFundAccountId,
			@Param("tradingOrderParkingOrderId") String tradingOrderParkingOrderId,
			@Param("tradingOrderPayeeCustId") String tradingOrderPayeeCustId,
			@Param("tradingOrderPayeeCustFundAccountId") String tradingOrderPayeeCustFundAccountId,
			@Param("tradingOrderState") String tradingOrderState,
			@Param("tradingOrderpayState") String tradingOrderpayState,
			@Param("tradingOrderBalanceState") String tradingOrderBalanceState,
			@Param("tradingOrderTranAmount") String tradingOrderTranAmount,
			@Param("tradingOrderCreateTime") String tradingOrderCreateTime);

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
	@Update("UPDATE trading_orders SET trading_order_state= #{tradingOrderState} WHERE trading_order_parking_order_id = #{tradingOrderParkingOrderId}")
	public int upTradingOrderState(@Param("tradingOrderState") String tradingOrderState,
			@Param("tradingOrderParkingOrderId") String tradingOrderParkingOrderId);

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
	@Update("UPDATE trading_orders SET trading_order_pay_state= #{tradingOrderpayState} WHERE trading_order_parking_order_id = #{tradingOrderParkingOrderId}")
	public int upTradingOrderpayState(@Param("tradingOrderpayState") String tradingOrderpayState,
			@Param("tradingOrderParkingOrderId") String tradingOrderParkingOrderId);

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
	@Update("UPDATE trading_orders SET trading_order_balance_State= #{tradingOrderBalanceState} WHERE trading_order_parking_order_id = #{tradingOrderParkingOrderId}")
	public int upTradingOrderBalanceState(@Param("tradingOrderBalanceState") String tradingOrderBalanceState,
			@Param("tradingOrderParkingOrderId") String tradingOrderParkingOrderId);

	/**
	 * 
	 * upTradingOrderTranAmount:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderTranAmount
	 *            trading_order_tran_amount 支付交易订单j支付金额 对应数据库 trading_order
	 *            对应实体类 TradingOrder 对应属性 tradingOrderTranAmount 数据库字段类型 varchar
	 *            实体类字段类型 String 长度 15 数据库中自动初始化为0 设计值为 000 代表 0.00元
	 *            使用时,先乘以系数100 将实际金额转换为绝对整数后,进行运算,在运算结束后再除以系数100将换算为实际金额
	 * @param tradingOrderParkingOrderId
	 *            'trading_order_parking_order_id 资金账户交易对应订单号 唯一键标识 对应数据库
	 *            trading_order 对应实体类 TradingOrder 对应属性
	 *            tradingOrderParkingOrderId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 *            不可为空 为 fund_account_id 字段'
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE trading_orders SET  trading_order_tran_amount= #{tradingOrderTranAmount} WHERE trading_order_parking_order_id = #{tradingOrderParkingOrderId}")
	public int upTradingOrderTranAmount(@Param("tradingOrderTranAmount") String tradingOrderTranAmount,
			@Param("tradingOrderParkingOrderId") String tradingOrderParkingOrderId);

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
	@Delete("DELETE trading_orders WHERE trading_order_parking_order_id = #{tradingOrderParkingOrderId}")
	public int deleteTradingOrderByOrderId(@Param("tradingOrderParkingOrderId") String tradingOrderParkingOrderId);

	/**
	 * 
	 * queryTradingOrderByPhone:(用户电话号码查询). <br/>
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
	@Select("select a.trading_order_id as orderId , a.trading_order_create_time as createTime ,a.trading_order_state as state,"
			+ " b.client_user_cellphone as userPhone,c.parking_info_name as parkName from trading_orders a,"
			+ "client_user b,parking_info c where a.trading_order_src_cust_id  = b.client_user_id "
			+ "and a.trading_order_payee_cust_id=c.parking_info_id " + "and b.client_user_cellphone= #{userPhone} "
			+ " and a.trading_order_create_time BETWEEN #{startTime} and #{endTime}  "
			+ "and a.trading_order_pay_state=#{state}")
	public List<InterimTradingOrder> queryTradingOrderByPhone(@Param("state") String state,
			@Param("userPhone") String userPhone, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 
	 * queryTradingOrderByParkName:(停车场查询). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param state
	 * @param parkName
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select a.trading_order_id as orderId , a.trading_order_create_time as createTime ,a.trading_order_state as state,"
			+ " b.client_user_cellphone as userPhone,c.parking_info_name as parkName from trading_orders a,"
			+ "client_user b,parking_info c where a.trading_order_src_cust_id  = b.client_user_id "
			+ "and a.trading_order_payee_cust_id=c.parking_info_id and  c.parking_info_name " + "LIKE #{parkName} "
			+ " and a.trading_order_create_time BETWEEN #{startTime} and #{endTime}  "
			+ "and a.trading_order_pay_state=#{state}")
	public List<InterimTradingOrder> queryTradingOrderByParkName(@Param("parkName") String parkName,
			@Param("state") String state, @Param("startTime") String startTime, @Param("endTime") String endTime);

}
