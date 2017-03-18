/**
 * Project Name:OnlineParking
 * File Name:ChargingOrderService.java
 * Package Name:com.yinzitech.onlineparking.service.order
 * Date:2015年10月12日下午1:41:24
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.order;

/**
 * ClassName:ChargingOrderService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月12日 下午1:41:24 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ChargingOrderService {

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
	public String selectChargingOrderByAccountId(String chargingOrderId);

	/**
	 * 
	 * queryChargingOrder:(查询充值订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrder2ClientUserId
	 * @param chargingOrderChargingType
	 *            充值订单业务发起者使用的支付渠道<br/>
	 *            默认为0 值 1 支付宝支付渠道 值 2 微信支付渠道 值 3 银联宝支付渠道 如有其它 在进行递增',
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryChargingOrder(String chargingOrder2ClientUserId, String chargingOrderChargingType,
			String startTime, String endTime, String chargingOrderPaymentPlatformFeedback);

	/**
	 * 
	 * queryChargingOrderLimit:(查询充值订单分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrder2ClientUserId
	 * @param chargingOrderChargingType
	 * @param startTime
	 * @param endTime
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryChargingOrderLimit(String chargingOrder2ClientUserId, String chargingOrderChargingType,
			String startTime, String endTime, String chargingOrderPaymentPlatformFeedback, int pageNumber,
			int pageSize);

	/**
	 * 
	 * UnifiedOrder:(统一下单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrder2ClientUserId
	 *            充值目标账号
	 * @param chargingOrderChargingType
	 *            值 1 支付宝支付渠道 值 2 微信支付渠道 值 3 银联支付渠道 如有其它 在进行递增',
	 * @param chargingOrderChargingAccount
	 *            充值订单业务发起者使用的支付渠道账号
	 * @param chargingOrderAmount
	 *            充值订单充值金额
	 * @param clientUserSecurity
	 *            用户令牌
	 * @return
	 * @since JDK 1.8u60
	 */
	public String unifiedOrder(String chargingOrder2ClientUserId, String chargingOrderChargingType,
			String chargingOrderChargingAccount, String chargingOrderAmount, String clientUserSecurity);

	/**
	 * 
	 * inpour:(充值状态轮询). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param userId
	 * @param clientUserSecurity
	 * @param outTradeNo
	 * @return
	 * @since JDK 1.8u60
	 */
	public String inpour(String userId, String clientUserSecurity, String outTradeNo);

	/**
	 * 
	 * upType:(充值状态更新). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param outTradeNo
	 * @return
	 * @since JDK 1.8u60
	 */
	public boolean upType(String outTradeNo, String type);

}
