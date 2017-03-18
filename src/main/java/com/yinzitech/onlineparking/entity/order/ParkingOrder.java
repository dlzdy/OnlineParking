/**
 * Project Name:OnlineParking
 * File Name:ParkingOrder.java
 * Package Name:com.yinzitech.onlineparking.entity.order
 * Date:2015年10月5日下午9:10:04
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.order;

import java.io.Serializable;
import java.util.List;

import com.yinzitech.onlineparking.entity.parkingInfo.ChargingStandards;

/**
 * ClassName:ParkingOrder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO 停车信息订单 对应实体类 parkingOder 停车场景中停车场场主发生停车订单时,
 * 模拟停车用户与停车场及管理员发生关联实体对象 将停车终端用户与停车场和停车管理员进行关联 client_user parking_info 1:1' .
 * <br/>
 * Date: 2015年10月5日 下午9:10:04 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ParkingOrder implements Serializable {

	@Override
	public String toString() {
		return "ParkingOrder [parkingOrderId=" + parkingOrderId + ", parkingOrderCarNo=" + parkingOrderCarNo
				+ ", parkingOrderCarManageId=" + parkingOrderCarManageId + ", parkingOrderClientUserId="
				+ parkingOrderClientUserId + ", parkingOrderCarEnterTime=" + parkingOrderCarEnterTime
				+ ", parkingOrderCarExitTime=" + parkingOrderCarExitTime + ", parkingOrderCarStayTime="
				+ parkingOrderCarStayTime + ", parkingOrderParkingState=" + parkingOrderParkingState
				+ ", parkingOrderPayState=" + parkingOrderPayState + ", parkingOrderCost=" + parkingOrderCost
				+ ", parkingOrderHandSetId=" + parkingOrderHandSetId + ", parkingOrderHandsetManagerId="
				+ parkingOrderHandsetManagerId + ", parkingOrderParkingInfoId=" + parkingOrderParkingInfoId
				+ ", parkingOrderCarNumberState=" + parkingOrderCarNumberState + ", parkingOrderCreateTime="
				+ parkingOrderCreateTime + ", parkingName=" + parkingName + ", chargingSandards=" + chargingSandards
				+ ", parkingOrderPayCash=" + parkingOrderPayCash + ", parkingOrderType=" + parkingOrderType + "]";
	}

	public ParkingOrder() {
		super();
	}

	public ParkingOrder(String parkingOrderId, String parkingOrderCarNo, String parkingOrderCarManageId,
			String parkingOrderClientUserId, String parkingOrderCarEnterTime, String parkingOrderCarExitTime,
			String parkingOrderCarStayTime, String parkingOrderParkingState, String parkingOrderPayState,
			String parkingOrderCost, String parkingOrderHandSetId, String parkingOrderHandsetManagerId,
			String parkingOrderParkingInfoId, String parkingOrderCarNumberState, String parkingOrderCreateTime,
			String parkingName, List<ChargingStandards> chargingSandards, String parkingOrderPayCash,
			String parkingOrderType) {
		super();
		this.parkingOrderId = parkingOrderId;
		this.parkingOrderCarNo = parkingOrderCarNo;
		this.parkingOrderCarManageId = parkingOrderCarManageId;
		this.parkingOrderClientUserId = parkingOrderClientUserId;
		this.parkingOrderCarEnterTime = parkingOrderCarEnterTime;
		this.parkingOrderCarExitTime = parkingOrderCarExitTime;
		this.parkingOrderCarStayTime = parkingOrderCarStayTime;
		this.parkingOrderParkingState = parkingOrderParkingState;
		this.parkingOrderPayState = parkingOrderPayState;
		this.parkingOrderCost = parkingOrderCost;
		this.parkingOrderHandSetId = parkingOrderHandSetId;
		this.parkingOrderHandsetManagerId = parkingOrderHandsetManagerId;
		this.parkingOrderParkingInfoId = parkingOrderParkingInfoId;
		this.parkingOrderCarNumberState = parkingOrderCarNumberState;
		this.parkingOrderCreateTime = parkingOrderCreateTime;
		this.parkingName = parkingName;
		this.chargingSandards = chargingSandards;
		this.parkingOrderPayCash = parkingOrderPayCash;
		this.parkingOrderType = parkingOrderType;
	}

	public String getParkingOrderId() {
		return parkingOrderId;
	}

	public void setParkingOrderId(String parkingOrderId) {
		this.parkingOrderId = parkingOrderId;
	}

	public String getParkingOrderCarNo() {
		return parkingOrderCarNo;
	}

	public void setParkingOrderCarNo(String parkingOrderCarNo) {
		this.parkingOrderCarNo = parkingOrderCarNo;
	}

	public String getParkingOrderCarManageId() {
		return parkingOrderCarManageId;
	}

	public void setParkingOrderCarManageId(String parkingOrderCarManageId) {
		this.parkingOrderCarManageId = parkingOrderCarManageId;
	}

	public String getParkingOrderClientUserId() {
		return parkingOrderClientUserId;
	}

	public void setParkingOrderClientUserId(String parkingOrderClientUserId) {
		this.parkingOrderClientUserId = parkingOrderClientUserId;
	}

	public String getParkingOrderCarEnterTime() {
		return parkingOrderCarEnterTime;
	}

	public void setParkingOrderCarEnterTime(String parkingOrderCarEnterTime) {
		this.parkingOrderCarEnterTime = parkingOrderCarEnterTime;
	}

	public String getParkingOrderCarExitTime() {
		return parkingOrderCarExitTime;
	}

	public void setParkingOrderCarExitTime(String parkingOrderCarExitTime) {
		this.parkingOrderCarExitTime = parkingOrderCarExitTime;
	}

	public String getParkingOrderCarStayTime() {
		return parkingOrderCarStayTime;
	}

	public void setParkingOrderCarStayTime(String parkingOrderCarStayTime) {
		this.parkingOrderCarStayTime = parkingOrderCarStayTime;
	}

	public String getParkingOrderParkingState() {
		return parkingOrderParkingState;
	}

	public void setParkingOrderParkingState(String parkingOrderParkingState) {
		this.parkingOrderParkingState = parkingOrderParkingState;
	}

	public String getParkingOrderPayState() {
		return parkingOrderPayState;
	}

	public void setParkingOrderPayState(String parkingOrderPayState) {
		this.parkingOrderPayState = parkingOrderPayState;
	}

	public String getParkingOrderCost() {
		return parkingOrderCost;
	}

	public void setParkingOrderCost(String parkingOrderCost) {
		this.parkingOrderCost = parkingOrderCost;
	}

	public String getParkingOrderHandSetId() {
		return parkingOrderHandSetId;
	}

	public void setParkingOrderHandSetId(String parkingOrderHandSetId) {
		this.parkingOrderHandSetId = parkingOrderHandSetId;
	}

	public String getParkingOrderHandsetManagerId() {
		return parkingOrderHandsetManagerId;
	}

	public void setParkingOrderHandsetManagerId(String parkingOrderHandsetManagerId) {
		this.parkingOrderHandsetManagerId = parkingOrderHandsetManagerId;
	}

	public String getParkingOrderParkingInfoId() {
		return parkingOrderParkingInfoId;
	}

	public void setParkingOrderParkingInfoId(String parkingOrderParkingInfoId) {
		this.parkingOrderParkingInfoId = parkingOrderParkingInfoId;
	}

	public String getParkingOrderCarNumberState() {
		return parkingOrderCarNumberState;
	}

	public void setParkingOrderCarNumberState(String parkingOrderCarNumberState) {
		this.parkingOrderCarNumberState = parkingOrderCarNumberState;
	}

	public String getParkingOrderCreateTime() {
		return parkingOrderCreateTime;
	}

	public void setParkingOrderCreateTime(String parkingOrderCreateTime) {
		this.parkingOrderCreateTime = parkingOrderCreateTime;
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public List<ChargingStandards> getChargingSandards() {
		return chargingSandards;
	}

	public void setChargingSandards(List<ChargingStandards> chargingSandards) {
		this.chargingSandards = chargingSandards;
	}

	public String getParkingOrderPayCash() {
		return parkingOrderPayCash;
	}

	public void setParkingOrderPayCash(String parkingOrderPayCash) {
		this.parkingOrderPayCash = parkingOrderPayCash;
	}

	public String getParkingOrderType() {
		return parkingOrderType;
	}

	public void setParkingOrderType(String parkingOrderType) {
		this.parkingOrderType = parkingOrderType;
	}

	/**
	 * 'parking_order_id 停车订单主键Id 唯一键标识 对应数据库 parking_order 对应实体类 ParkingOrder
	 * 对应属性 parkingOrderId 数据库字段类型 varchar 实体类字段类型 String 长度50
	 * 由停车场端手持机或一体机识别生成',
	 * 
	 */
	public String parkingOrderId;
	/**
	 * 'parking_order_car_no 停车订单中停车场端发现的车牌号 对应数据库 parking_order 对应实体类
	 * ParkingOrder 对应属性 parkingOrderCarNo 数据库字段类型 varchar 实体类字段类型 String 长度10
	 * 对应 终端用户车辆管理表 clinet_user_car_manage 由停车场端手持机或一体机识别生成',
	 * 
	 */
	public String parkingOrderCarNo;
	/**
	 * 'parking_order_car_manage_id 通过 parking_order_car_no 逻辑查找到的
	 * 终端用户部分clinet_user_car_manage 终端用户车辆管理表(实体类ClientUserCarManager) 对应数据库
	 * parking_order 对应实体类 ParkingOrder 对应属性 parkingOrderCarManageId 数据库字段类型
	 * varchar 实体类字段类型 String 长度100 对应 逻辑中找出',
	 * 
	 */
	public String parkingOrderCarManageId;
	/**
	 * 'parking_order_client_user_id 通过 parking_order_car_manage_id 逻辑查找到的
	 * 终端用户部分clinet_user 终端用户车辆管理表(实体类ClientUser) 对应数据库 parking_order 对应实体类
	 * ParkingOrder 对应属性 parkingOrderClientUserId 数据库字段类型 varchar 实体类字段类型 String
	 * 长度100 对应 逻辑中找出',
	 * 
	 */
	public String parkingOrderClientUserId;

	/**
	 * 'parking_order_car_enter_time 车辆进入停车场时间 对应数据库 parking_order 对应实体类
	 * ParkingOrder 对应属性 parkingOrderCarEnterTime 数据库字段类型 varchar 实体类字段类型 String
	 * 长度 20 默认为空,由用户填写 格式 YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01
	 * 13:22:22',
	 * 
	 */
	public String parkingOrderCarEnterTime;
	/**
	 * 'parking_order_car_exit_time 车辆离开停车场时间 对应数据库 parking_order 对应实体类
	 * ParkingOrder 对应属性 parkingOrderCarExitTime 数据库字段类型 varchar 实体类字段类型 String
	 * 长度 20 默认为空,由用户填写 格式 YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01
	 * 13:22:22',
	 * 
	 */
	public String parkingOrderCarExitTime;

	/**
	 * 'parking_order_car_stay_time 车辆停留在停车场内时间 对应数据库 parking_order 对应实体类
	 * ParkingOrder 对应属性 parkingOrderCarStayTime 数据库字段类型 varchar 实体类字段类型 String
	 * 长度 10 逻辑字段,不能为空, 单位为秒 在发生计算时,需要进行到分,时,日,月的计算',
	 * 
	 */
	public String parkingOrderCarStayTime;

	/**
	 * 'parking_order_parking_state 停车订单中车辆在停车场的停车状态 用来标记 是否完成停车 对应数据库
	 * parking_order 对应实体类 ParkingOrder 对应属性 parkingOrderParkingState 数据库字段类型
	 * varchar 实体类字段类型 String 长度 10 逻辑字段,不能为空, 取值只有两个字段 stay 表示车辆在停车场中仍处理停留状态
	 * quiet 表示车辆已经不在停车场处于停车状态,车辆已经离开停车场',
	 * 
	 */
	public String parkingOrderParkingState;

	/**
	 * 'parking_order_pay_state 停车订单中车辆在停车场的停车的支付状态 用来标记 车辆停车后时候完成付费 对应数据库
	 * parking_order 对应实体类 ParkingOrder 对应属性 parkingOrderPayState 数据库字段类型
	 * varchar 实体类字段类型 String 长度 10 逻辑字段,不能为空, 取值只有三个字段 NoPaid 表示车辆未完成付款 Paid
	 * 表示车辆已经完成付款,cash现金支付',
	 * 
	 */
	public String parkingOrderPayState;

	/**
	 * 'parking_order_cost 停车订单中车辆在停车场的停车费用 对应数据库 parking_order 对应实体类
	 * ParkingOrder 对应属性 parkingOrderCost 数据库字段类型 varchar 实体类字段类型 String 长度 10
	 * 逻辑字段,通过 车辆在停车场中的停车时长与停车场的停车价格计算而出 精确到分 计算时以及在以后的显示中,需要注意换算',
	 * 
	 */
	public String parkingOrderCost;
	/**
	 * 'parking_order_hand_set_id 停车订单中车辆被识别时使用的手持机id 对应数据库 parking_order 对应实体类
	 * ParkingOrder 对应属性 parkingOrderHandSetId 数据库字段类型 varchar 实体类字段类型 String 长度
	 * 100 逻辑字段,不可为空',
	 * 
	 */
	public String parkingOrderHandSetId;
	/**
	 * 'parking_order_handset_manager_id 停车订单中,扫描车牌的手持机的管理员id 对应数据库
	 * parking_order 对应实体类 ParkingOrder 对应属性 parkingOrderHandsetManagerId
	 * 数据库字段类型 varchar 实体类字段类型 String 长度100 不可为空',
	 * 
	 */
	public String parkingOrderHandsetManagerId;
	/**
	 * 'parking_order_parking_info_id 停车订单中,扫描车牌的手持机的管理员所属的停车场id 对应数据库
	 * parking_order 对应实体类 ParkingOrder 对应属性 parkingOrderParkingInfoId 数据库字段类型
	 * varchar 实体类字段类型 String 长度100 不可为空',
	 * 
	 */
	public String parkingOrderParkingInfoId;
	/**
	 * 'parking_order_car_number_state 停车订单中涉及车辆是否是Online停车平台在管车辆 对应数据库
	 * parking_order 对应实体类 ParkingOrder 对应属性 parkingOrderCarNumberState 数据库字段类型
	 * varchar 实体类字段类型 String 长度1 默认值为0 0
	 * 该车辆不是Online停车平台在管车辆,只需要在手机端对车辆进行停车的计时就可以 1 该车辆为Onoline停车平台在管车辆',
	 * 
	 */
	public String parkingOrderCarNumberState;
	/**
	 * 'parking_order_create_time 停车订单创建时间 对应数据库 parking_order 对应实体类
	 * ParkingOrder 对应属性 parkingOrderCreateTime 数据库字段类型 varchar 实体类字段类型 String
	 * 长度 20 由订单初始化时调用时间生成器生成 格式 YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01
	 * 13:22:22',
	 * 
	 */
	public String parkingOrderCreateTime;
	/**
	 * 停车场名称
	 */
	public String parkingName;
	/**
	 * 停车场收费标准
	 */
	public List<ChargingStandards> chargingSandards;
	/**
	 * parking_order_pay_cash 是否现金支付 1为是0为否
	 */
	public String parkingOrderPayCash;
	/**
	 * parking_order_type 订单类型
	 */
	public String parkingOrderType;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = -7790153691348035250L;

}
