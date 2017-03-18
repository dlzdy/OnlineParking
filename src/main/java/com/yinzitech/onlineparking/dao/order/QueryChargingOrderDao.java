/**
 * Project Name:OnlineParking
 * File Name:QueryChargingOrderDao.java
 * Package Name:com.yinzitech.onlineparking.dao.order
 * Date:2015年10月29日下午3:24:25
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.order.ChargingOrder;

/**
 * ClassName:QueryChargingOrderDao 充值订单<br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月29日 下午3:24:25 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface QueryChargingOrderDao {
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
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<ChargingOrder> queryChargingOrder(
			@Param("chargingOrder2ClientUserId") String chargingOrder2ClientUserId,
			@Param("chargingOrderChargingType") String chargingOrderChargingType, @Param("startTime") String startTime,
			@Param("endTime") String endTime,
			@Param("chargingOrderPaymentPlatformFeedback") String chargingOrderPaymentPlatformFeedback);

}
