/**
 * Project Name:OnlineParking
 * File Name:OrderMapperDao.java
 * Package Name:com.yinzitech.onlineparking.dao.order
 * Date:2015年10月28日下午6:37:53
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.order.ParkingOrder;

/**
 * ClassName:OrderMapperDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月28日 下午6:37:53 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface OrderMapperDao {
	/**
	 * 
	 * getParkingOrder:(查询全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<ParkingOrder> getParkingOrder();

	/**
	 * 
	 * getParkingOrderByUserId:(查询用户全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderId
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<ParkingOrder> getParkingOrderByUserId(
			@Param("parkingOrderClientUserId") String parkingOrderClientUserId,
			@Param("parkingOrderPayState") String parkingOrderPayState, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 
	 * getParkingOrderByHandsetManagerId:(查询手持机管理员订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<ParkingOrder> getParkingOrderByHandsetManagerId(
			@Param("parkingOrderHandsetManagerId") String parkingOrderHandsetManagerId,
			@Param("parkingOrderPayState") String parkingOrderPayState, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 
	 * getParkingOrderByParkingInfoId:(查询停车场全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderParkingInfoId
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<ParkingOrder> getParkingOrderByParkingInfoId(
			@Param("parkingOrderParkingInfoId") String parkingOrderParkingInfoId,
			@Param("parkingOrderPayState") String parkingOrderPayState, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 
	 * getParkingOrderById:(订单号查询订单 ). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public ParkingOrder getParkingOrderById(@Param("parkingOrderId") String parkingOrderId);

	/**
	 * 
	 * getParkingOrderByPayState:(用户未支付订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<ParkingOrder> getParkingOrderByPayState(
			@Param("parkingOrderClientUserId") String parkingOrderClientUserId);

	/**
	 * 
	 * querParkingOrderByPayState:(查询用户支付状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderClientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	public int querParkingOrderByPayState(@Param("parkingOrderClientUserId") String parkingOrderClientUserId);

	/**
	 * 
	 * getParkingState:(查询停车长停车数量). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 * stay
	 * 
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public int getParkingState(@Param("parkingOrderParkingInfoId") String parkingOrderParkingInfoId);

	/**
	 * 
	 * getParkingOrderByCarNo:(手机号码查询停车场订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<ParkingOrder> getParkingOrderByCarNo(@Param("parkingOrderCarNo") String parkingOrderCarNo,
			@Param("parkingOrderParkingInfoId") String parkingOrderParkingInfoId,
			@Param("parkingOrderParkingState") String parkingOrderParkingState);

	/**
	 * 
	 * queryParkOrder:(停车订单组合查询). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderId
	 * @param parkingOrderCarNo
	 * @param parkingOrderCarManageId
	 * @param parkingOrderClientUserId
	 * @param parkingOrderParkingState
	 *            stay 表示车辆在停车场中仍处理停留状态<br/>
	 *            quiet 表示车辆已经不在停车场处于停车状<br/>
	 * @param parkingOrderPayState
	 *            NoPaid 表示车辆未完成付款 <br/>
	 *            Paid 表示车辆已经完成付款'<br/>
	 * @param parkingOrderHandSetId
	 * @param parkingOrderHandsetManagerId
	 * @param parkingOrderParkingInfoId
	 * @param parkingOrderCarNumberState
	 *            1 在管车辆<br/>
	 *            0 非在管车辆<br/>
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<ParkingOrder> queryParkOrder(@Param("parkingOrderId") String parkingOrderId,
			@Param("parkingOrderCarNo") String parkingOrderCarNo,
			@Param("parkingOrderCarManageId") String parkingOrderCarManageId,
			@Param("parkingOrderClientUserId") String parkingOrderClientUserId,
			@Param("parkingOrderParkingState") String parkingOrderParkingState,
			@Param("parkingOrderPayState") String parkingOrderPayState,
			@Param("parkingOrderHandSetId") String parkingOrderHandSetId,
			@Param("parkingOrderHandsetManagerId") String parkingOrderHandsetManagerId,
			@Param("parkingOrderParkingInfoId") String parkingOrderParkingInfoId,
			@Param("parkingOrderCarNumberState") String parkingOrderCarNumberState,
			@Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("parkingOrderPayCash") String parkingOrderPayCash,
			@Param("parkingOrderType") String parkingOrderType);

}
