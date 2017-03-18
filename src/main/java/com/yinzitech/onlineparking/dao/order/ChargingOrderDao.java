/**
 * Project Name:OnlineParking
 * File Name:ChargingOrderDao.java
 * Package Name:com.yinzitech.onlineparking.dao.order
 * Date:2015年10月12日上午11:09:22
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.order.ChargingOrder;

/**
 * ClassName:ChargingOrderDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月12日 上午11:09:22 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ChargingOrderDao {
	/**
	 * 
	 * selectChargingOrderListByAccountId:(查询资金账户全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrder2FundAccountId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT charging_order_id as chargingOrderId,"
			+ "charging_order_2_fund_account_id as chargingOrder2FundAccountId,"
			+ "charging_order_2_client_user_id as chargingOrder2ClientUserId,"
			+ "charging_order_charging_type as chargingOrderChargingType,"
			+ "charging_order_charging_account as chargingOrderChargingAccount,"
			+ "charging_order_payment_platform_id as chargingOrderPaymentPlatformId,"
			+ "charging_order_payment_platform_feedback as chargingOrderPaymentPlatformFeedback,"
			+ "charging_order_amount as chargingOrderAmount," + "charging_order_create_time as chargingOrderCreateTime "
			+ "FROM charging_order WHERE charging_order_2_fund_account_id = #{chargingOrder2FundAccountId}")
	public List<ChargingOrder> selectChargingOrderListByAccountId(
			@Param("chargingOrder2FundAccountId") String chargingOrder2FundAccountId);

	/**
	 * 
	 * queryChargingOrderByUserId:(查询用户充值记录). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrder2ClientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT charging_order_id as chargingOrderId,"
			+ "charging_order_2_fund_account_id as chargingOrder2FundAccountId,"
			+ "charging_order_2_client_user_id as chargingOrder2ClientUserId,"
			+ "charging_order_charging_type as chargingOrderChargingType,"
			+ "charging_order_charging_account as chargingOrderChargingAccount,"
			+ "charging_order_payment_platform_id as chargingOrderPaymentPlatformId,"
			+ "charging_order_payment_platform_feedback as chargingOrderPaymentPlatformFeedback,"
			+ "charging_order_amount as chargingOrderAmount," + "charging_order_create_time as chargingOrderCreateTime "
			+ "FROM charging_order WHERE charging_order_2_client_user_id = #{chargingOrder2ClientUserId} "
			+ "ORDER BY charging_order_create_time DESC ")
	public List<ChargingOrder> queryChargingOrderByUserId(
			@Param("chargingOrder2ClientUserId") String chargingOrder2ClientUserId);

	/**
	 * 
	 * selectChargingOrder:(查询资金账户订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(时间范围不能为null – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrder2FundAccountId
	 *            资金账户id
	 * @param chargingOrderChargingType
	 *            交易类型
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT charging_order_id as chargingOrderId,"
			+ "charging_order_2_fund_account_id as chargingOrder2FundAccountId,"
			+ "charging_order_2_client_user_id as chargingOrder2ClientUserId,"
			+ "charging_order_charging_type as chargingOrderChargingType,"
			+ "charging_order_charging_account as chargingOrderChargingAccount,"
			+ "charging_order_payment_platform_id as chargingOrderPaymentPlatformId,"
			+ "charging_order_payment_platform_feedback as chargingOrderPaymentPlatformFeedback,"
			+ "charging_order_amount as chargingOrderAmount," + "charging_order_create_time as chargingOrderCreateTime "
			+ "FROM charging_order  " + " WHERE 1=1  "
			+ " AND  charging_order_2_fund_account_id = #{chargingOrder2FundAccountId} "
			+ " AND charging_order_charging_type = #{chargingOrderChargingType} "
			+ " AND charging_order_create_time BETWEEN #{startTime} and #{endTime} ")
	public List<ChargingOrder> selectChargingOrder(
			@Param("chargingOrder2FundAccountId") String chargingOrder2FundAccountId,
			@Param("chargingOrderChargingType") String chargingOrderChargingType, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 
	 * selectChargingOrderByAccountId:(查询资金账户订单ById). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrderId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT charging_order_id as chargingOrderId,"
			+ "charging_order_2_fund_account_id as chargingOrder2FundAccountId,"
			+ "charging_order_2_client_user_id as chargingOrder2ClientUserId,"
			+ "charging_order_charging_type as chargingOrderChargingType,"
			+ "charging_order_charging_account as chargingOrderChargingAccount,"
			+ "charging_order_payment_platform_id as chargingOrderPaymentPlatformId,"
			+ "charging_order_payment_platform_feedback as chargingOrderPaymentPlatformFeedback,"
			+ "charging_order_amount as chargingOrderAmount," + "charging_order_create_time as chargingOrderCreateTime "
			+ " FROM charging_order WHERE charging_order_id = #{chargingOrderId}")
	public ChargingOrder selectChargingOrderByAccountId(@Param("chargingOrderId") String chargingOrderId);

	/**
	 * 
	 * getOutTradeNo:(查询资金账户订单 第三方订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrderId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT charging_order_id as chargingOrderId,"
			+ "charging_order_2_fund_account_id as chargingOrder2FundAccountId,"
			+ "charging_order_2_client_user_id as chargingOrder2ClientUserId,"
			+ "charging_order_charging_type as chargingOrderChargingType,"
			+ "charging_order_charging_account as chargingOrderChargingAccount,"
			+ "charging_order_payment_platform_id as chargingOrderPaymentPlatformId,"
			+ "charging_order_payment_platform_feedback as chargingOrderPaymentPlatformFeedback,"
			+ "charging_order_amount as chargingOrderAmount," + "charging_order_create_time as chargingOrderCreateTime "
			+ " FROM charging_order WHERE charging_order_payment_platform_id = #{chargingOrderPaymentPlatformId}")
	public ChargingOrder getOutTradeNo(@Param("chargingOrderPaymentPlatformId") String chargingOrderPaymentPlatformId);

	/**
	 * 
	 * creatChargingOrder:(创建充值订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrderId
	 *            充值订单主键Id
	 * @param chargingOrder2FundAccountId
	 *            充值目标de资金管理账号
	 * @param chargingOrder2ClientUserId
	 *            充值目标de用户账号
	 * @param chargingOrderChargingType
	 *            充值订单业务发起者使用的支付渠道<br/>
	 *            默认为0 值 1 支付宝支付渠道 值 2 微信支付渠道 值 3 银联宝支付渠道 如有其它 在进行递增',
	 * @param chargingOrderChargingAccount
	 *            充值订单业务发起者使用的支付渠道账号
	 * @param chargingOrderPaymentPlatformId
	 *            充值订单业务支付平台反馈的支付平台订单号
	 * @param chargingOrderPaymentPlatformFeedback
	 *            支付平台反馈成功与否的标记
	 * @param chargingOrderAmount
	 *            充值订单充值金额
	 * @param chargingOrderCreateTime
	 *            充值订单创建时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO charging_order (charging_order_id, charging_order_2_fund_account_id, charging_order_2_client_user_id, charging_order_charging_type, charging_order_charging_account, charging_order_payment_platform_id, charging_order_payment_platform_feedback, charging_order_amount, charging_order_create_time) VALUES (#{chargingOrderId},#{chargingOrder2FundAccountId},#{chargingOrder2ClientUserId}, #{chargingOrderChargingType},#{chargingOrderChargingAccount}, #{chargingOrderPaymentPlatformId}, #{chargingOrderPaymentPlatformFeedback}, #{chargingOrderAmount}, #{chargingOrderCreateTime})")
	public int creatChargingOrder(@Param("chargingOrderId") String chargingOrderId,
			@Param("chargingOrder2FundAccountId") String chargingOrder2FundAccountId,
			@Param("chargingOrder2ClientUserId") String chargingOrder2ClientUserId,
			@Param("chargingOrderChargingType") String chargingOrderChargingType,
			@Param("chargingOrderChargingAccount") String chargingOrderChargingAccount,
			@Param("chargingOrderPaymentPlatformId") String chargingOrderPaymentPlatformId,
			@Param("chargingOrderPaymentPlatformFeedback") String chargingOrderPaymentPlatformFeedback,
			@Param("chargingOrderAmount") String chargingOrderAmount,
			@Param("chargingOrderCreateTime") String chargingOrderCreateTime);

	/**
	 * 
	 * upChargingOrder:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrderPaymentPlatformFeedback
	 *            支付标记
	 * @param chargingOrderId
	 *            充值订单号
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE charging_order SET charging_order_payment_platform_feedback = #{chargingOrderPaymentPlatformFeedback}  WHERE (charging_order_payment_platform_id = #{chargingOrderPaymentPlatformId})")
	public int upChargingOrder(
			@Param("chargingOrderPaymentPlatformFeedback") String chargingOrderPaymentPlatformFeedback,
			@Param("chargingOrderPaymentPlatformId") String chargingOrderPaymentPlatformId);

}
