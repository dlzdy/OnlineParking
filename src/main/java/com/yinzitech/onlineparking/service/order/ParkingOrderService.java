/**
 * Project Name:OnlineParking
 * File Name:ParkingOrderService.java
 * Package Name:com.yinzitech.onlineparking.service.order
 * Date:2015年10月6日上午1:34:41
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.service.order;

import java.util.List;

/**
 * ClassName:ParkingOrderService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月6日 上午1:34:41 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */

public interface ParkingOrderService {
	/**
	 * 
	 * creatParkingOrder:(创建订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderCarNo
	 *            用户车牌号
	 * @param parkingOrderHandSetId
	 *            手持端设备ID
	 * @param parkingInfoId
	 *            停车场ID
	 * @param handsetManagerId
	 *            使用手持设备人ID
	 * @return
	 * @since JDK 1.8u60
	 */
	public String creatParkingOrder(String parkingOrderCarNo, String parkingOrderHandSetId, String parkingInfoId,
			String handsetManagerId);

	/**
	 * 
	 * updateParkingOrder:(停车场车辆出库信息修改). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderPayState
	 *            支付状态
	 * @param parkingOrderId
	 *            停车场订单Id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String updateParkingOrder(String parkingOrderPayState, String parkingOrderId);

	/**
	 * 
	 * updateparkingOrderPayState:(更新用户支付状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderPayState
	 *            支付状态
	 * @param parkingOrderId
	 *            订单ID
	 * @return
	 * @since JDK 1.8u60
	 */
	public String updateparkingOrderPayState(String parkingOrderPayState, String parkingOrderId);

	/**
	 * 
	 * selectParkingOrderAll:(查询全部订单信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectParkingOrderAll();

	/**
	 * 
	 * selectParkingOrderByUserId:(查询用户全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderClientUserId
	 *            用户ID
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectParkingOrderByUserId(String parkingOrderClientUserId, String parkingOrderPayState,
			String startTime, String endTime, String clientUserSecurity);

	/**
	 * 
	 * selectParkingOrderParkId:(查询停车场全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderParkingInfoId
	 *            停车场ID
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectParkingOrderParkId(String parkingOrderParkingInfoId, String parkingOrderPayState,
			String startTime, String endTime);

	/**
	 * 
	 * selectParkingOrderParkId:(查询手持机全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderHandsetManagerId
	 *            停车场ID
	 * @return
	 * @since JDK 1.8u60
	 */

	public String parkingOrderHandsetManagerId(String parkingOrderHandsetManagerId, String parkingOrderPayState,
			String startTime, String endTime);

	/**
	 * 
	 * selectParkingOrderById:(通过订单ID查询订单内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderId
	 *            订单ID
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectParkingOrderById(String parkingOrderId);

	/**
	 * 
	 * selectParkingOrderPayState:(查询用户支付状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderClientUserId
	 *            用户ID
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectParkingOrderPayState(String parkingOrderClientUserId);

	/**
	 * 
	 * parkingOrderParkingState:(查询停车长停车数量). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderParkingInfoId
	 *            停车场ID
	 * @return
	 * @since JDK 1.8u60
	 */
	public String parkingOrderParkingState(String parkingOrderParkingInfoId);

	/**
	 * 
	 * deleteParkingOrder:(通过订单ID删除订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderId
	 *            订单ID
	 * @return
	 * @since JDK 1.8u60
	 */
	public String deleteParkingOrder(String parkingOrderId);

	/**
	 * 
	 * selectByCarNo:(通过车牌号查询停车场订单信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderCarNo
	 * @param parkingOrderParkingInfoId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectByCarNo(String parkingOrderCarNo, String parkingOrderParkingInfoId);

	/**
	 * 
	 * updateOrderPayState:(订单支付状态更新Rest). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderPayState
	 * @param parkingOrderId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String updateOrderPayState(String parkingOrderPayState, String parkingOrderId);

	/**
	 * 
	 * selectParkingState:(通过车牌还查询车辆是否在停). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderCarNo
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectParkingState(String parkingOrderCarNo);

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
	public String queryParkOrder(String parkingOrderId, String parkingOrderCarNo, String parkingOrderCarManageId,
			String parkingOrderClientUserId, String parkingOrderParkingState, String parkingOrderPayState,
			String parkingOrderHandSetId, String parkingOrderHandsetManagerId, String parkingOrderParkingInfoId,
			String parkingOrderCarNumberState, String startTime, String endTime, String parkingOrderPayCash,
			String parkingOrderType);

	/**
	 * 
	 * OrderPayCash:(现金支付订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String OrderPayCash(String parkingOrderId, String clientUserSecurity, String clientUserId);

	/**
	 * 
	 * queryParkOrderLimit:(停车订单组合查询分页). <br/>
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
	 * @param parkingOrderPayState
	 * @param parkingOrderHandSetId
	 * @param parkingOrderHandsetManagerId
	 * @param parkingOrderParkingInfoId
	 * @param parkingOrderCarNumberState
	 * @param startTime
	 * @param endTime
	 * @param parkingOrderPayCash
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryParkOrderLimit(String parkingOrderId, String parkingOrderCarNo, String parkingOrderCarManageId,
			String parkingOrderClientUserId, String parkingOrderParkingState, String parkingOrderPayState,
			String parkingOrderHandSetId, String parkingOrderHandsetManagerId, String parkingOrderParkingInfoId,
			String parkingOrderCarNumberState, String startTime, String endTime, String parkingOrderPayCash,
			String parkingOrderType, int pageNumber, int pageSize);

	/**
	 * 
	 * enter:(汉王进场接口). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param plate
	 *            车牌号
	 * @param companyID
	 *            停车场id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String enter(String plate, String companyID);

	/**
	 * 
	 * exit:(汉王出场接口). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param plate
	 *            车牌号
	 * @param companyID
	 *            停车场id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String exit(String plate, String companyID);

	/**
	 * 
	 * countOrder:(用户未支付订单数量). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param userId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String countOrder(String userId);

	/**
	 * 
	 * CarNoList:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param CarNo
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<String> CarNoList(String CarNo);

	public List<String> stayCarNo();

}
