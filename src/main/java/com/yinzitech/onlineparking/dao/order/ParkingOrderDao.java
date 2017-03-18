/**
 * Project Name:OnlineParking
 * File Name:ParkingOrderDao.java
 * Package Name:com.yinzitech.onlineparking.dao.order
 * Date:2015年10月5日下午9:32:51
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.dao.order;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName:ParkingOrderDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月5日 下午9:32:51 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ParkingOrderDao {
	/**
	 * 
	 * creatParkingOrder:(创建停车场订单). <br/>
	 * TODO(需先进行车牌判定 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderId
	 *            停车订单主键Id
	 * @param parkingOrderCarNo
	 *            停车订单中停车场端发现的车牌号
	 * @param parkingOrderCarManageId
	 *            'parking_order_car_manage_id 通过 parking_order_car_no 逻辑查找到的
	 *            终端用户部分clinet_user_car_manage
	 *            终端用户车辆管理表(实体类ClientUserCarManager) 对应数据库 parking_order 对应实体类
	 *            ParkingOrder 对应属性 parkingOrderCarManageId 数据库字段类型 varchar
	 *            实体类字段类型 String 长度100 对应 逻辑中找出'
	 * @param parkingOrderClientUserId
	 *            'parking_order_client_user_id 通过 parking_order_car_manage_id
	 *            逻辑查找到的 终端用户部分clinet_user 终端用户车辆管理表(实体类ClientUser) 对应数据库
	 *            parking_order 对应实体类 ParkingOrder 对应属性 parkingOrderClientUserId
	 *            数据库字段类型 varchar 实体类字段类型 String 长度100 对应 逻辑中找出',
	 * @param parkingOrderCarEnterTime
	 *            车辆进入停车场时间
	 * @param parkingOrderHandSetId
	 *            停车订单中车辆被识别时使用的手持机id
	 * @param parkingOrderHandsetManagerId
	 *            扫描车牌的手持机的管理员id
	 * @param parkingOrderParkingInfoId
	 *            管理员所属的停车场id
	 * @param parkingOrderCarNumberState
	 *            否是Online停车平台在管车辆
	 * @param parkingOrderCreateTime
	 *            停车订单创建时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO parking_order (parking_order_id , parking_order_car_no , parking_order_car_manage_id , parking_order_client_user_id , parking_order_car_enter_time , parking_order_parking_state , parking_order_hand_set_id , parking_order_handset_manager_id , parking_order_parking_info_id , parking_order_car_number_state , parking_order_create_time , parking_order_pay_cash ,parking_order_type) VALUES (#{parkingOrderId},#{parkingOrderCarNo},#{parkingOrderCarManageId},#{parkingOrderClientUserId},#{parkingOrderCarEnterTime},'stay',#{parkingOrderHandSetId},#{parkingOrderHandsetManagerId},#{parkingOrderParkingInfoId},#{parkingOrderCarNumberState},#{parkingOrderCreateTime},#{parkingOrderPayCash},#{parkingOrderType})")
	public int creatParkingOrder(@Param("parkingOrderId") String parkingOrderId,
			@Param("parkingOrderCarNo") String parkingOrderCarNo,
			@Param("parkingOrderCarManageId") String parkingOrderCarManageId,
			@Param("parkingOrderClientUserId") String parkingOrderClientUserId,
			@Param("parkingOrderCarEnterTime") String parkingOrderCarEnterTime,
			@Param("parkingOrderHandSetId") String parkingOrderHandSetId,
			@Param("parkingOrderHandsetManagerId") String parkingOrderHandsetManagerId,
			@Param("parkingOrderParkingInfoId") String parkingOrderParkingInfoId,
			@Param("parkingOrderCarNumberState") String parkingOrderCarNumberState,
			@Param("parkingOrderCreateTime") String parkingOrderCreateTime,
			@Param("parkingOrderPayCash") String parkingOrderPayCash,
			@Param("parkingOrderType") String parkingOrderType);

	/**
	 * 
	 * updateParkingOrder:(停车场车辆出库信息修改). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderCarExitTime
	 *            车辆进入停车场时间
	 * @param parkingOrderCarStayTime
	 *            车辆停留在停车场内时间
	 * @param parkingOrderParkingState
	 *            停车订单中车辆在停车场的停车状态
	 * @param parkingOrderPayState
	 *            停车订单中车辆在停车场的停车的支付状态
	 * @param parkingOrderCost
	 *            停车订单中车辆在停车场的停车费用
	 * @param parkingOrderId
	 *            停车订单主键Id
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE parking_order SET parking_order_car_exit_time=#{parkingOrderCarExitTime}, parking_order_car_stay_time=#{parkingOrderCarStayTime}, parking_order_parking_state=#{parkingOrderParkingState},  parking_order_cost=#{parkingOrderCost} WHERE (parking_order_id=#{parkingOrderId})")
	public int updateParkingOrder(@Param("parkingOrderCarExitTime") String parkingOrderCarExitTime,
			@Param("parkingOrderCarStayTime") String parkingOrderCarStayTime,
			@Param("parkingOrderParkingState") String parkingOrderParkingState,
			@Param("parkingOrderCost") String parkingOrderCost, @Param("parkingOrderId") String parkingOrderId);

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
	 *            停车订单中车辆在停车场的停车的支付状态
	 * @param parkingOrderId
	 *            停车订单主键Id
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE parking_order SET parking_order_pay_state=#{parkingOrderPayState}  WHERE (parking_order_id=#{parkingOrderId})")
	public int updateparkingOrderPayState(@Param("parkingOrderPayState") String parkingOrderPayState,
			@Param("parkingOrderId") String parkingOrderId);
	
	/**
	 * 
	 * updateparkingOrderHandSetId:(更新手持机id). <br/>
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
	@Update("UPDATE parking_order SET parking_order_handset_manager_id = #{parkingOrderHandsetManagerId}  WHERE (parking_order_id=#{parkingOrderId})")
	public int updateparkingOrderHandSetId(@Param("parkingOrderHandsetManagerId") String parkingOrderHandsetManagerId,
			@Param("parkingOrderId") String parkingOrderId);

	/**
	 * 
	 * updateparkingOrderPayCash:(是否现金支付). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderPayCash
	 *            1是 0否
	 * @param parkingOrderId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE parking_order SET parking_order_pay_cash = #{parkingOrderPayCash}  WHERE (parking_order_id=#{parkingOrderId})")
	public int updateparkingOrderPayCash(@Param("parkingOrderPayCash") String parkingOrderPayCash,
			@Param("parkingOrderId") String parkingOrderId);

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
	 * @return
	 * @since JDK 1.8u60
	 */
	@Delete("DELETE FROM parking_order WHERE (parking_order_id=#{parkingOrderId})")
	public int deleteParkingOrder(@Param("parkingOrderId") String parkingOrderId);

}
