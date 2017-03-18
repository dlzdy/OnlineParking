/**
 * Project Name:OnlineParking
 * File Name:QueryTradingOrderDao.java
 * Package Name:com.yinzitech.onlineparking.service.order
 * Date:2015年10月29日下午3:46:55
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.order.TradingOrders;

/**
 * ClassName:QueryTradingOrderDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月29日 下午3:46:55 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface QueryTradingOrderDao {

	public List<TradingOrders> queryChargingOrder(@Param("tradingOrderSrcCustId") String tradingOrderSrcCustId,
			@Param("tradingOrderParkingOrderId") String tradingOrderParkingOrderId,
			@Param("tradingOrderPayeeCustId") String tradingOrderPayeeCustId,
			@Param("tradingOrderState") String tradingOrderState,
			@Param("tradingOrderpayState") String tradingOrderpayState,
			@Param("tradingOrderBalanceState") String tradingOrderBalanceState, @Param("startTime") String startTime,
			@Param("endTime") String endTime);
}
