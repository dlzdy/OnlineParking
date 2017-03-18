/**
 * Project Name:OnlineParking
 * File Name:ClinetUserCarManage.java
 * Package Name:com.yinzitech.onlineparking.entity.client.carManage
 * Date:2015年10月4日上午3:14:01
 * Copyright (c) 2015, ziheng All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.client.carManage;

import java.io.Serializable;

/**
 * ClassName:ClinetUserCarManage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午3:14:01 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class ClinetUserCarManage implements Serializable {

	@Override
	public String toString() {
		return "ClinetUserCarManage [carManageId=" + carManageId + ", clientUserId=" + clientUserId
				+ ", clientUserCarNo=" + clientUserCarNo + ", clientUserCarPosition=" + clientUserCarPosition
				+ ", clientUserCarActiveMark=" + clientUserCarActiveMark + ", carNoSettingTime=" + carNoSettingTime
				+ "]";
	}

	/**
	 * 
	 * Title: 无参构造方法<br/>
	 * Description:<br/>
	 */
	public ClinetUserCarManage() {
	}

	/**
	 * 
	 * Title: 有参构造方法<br/>
	 * Description:<br/>
	 * 
	 * @param carManageId
	 * @param clientUserId
	 * @param clientUserCarNo
	 * @param clientUserCarPosition
	 * @param clientUserCarActiveMark
	 * @param carNoSettingTime
	 */
	public ClinetUserCarManage(String carManageId, String clientUserId, String clientUserCarNo,
			String clientUserCarPosition, String clientUserCarActiveMark, String carNoSettingTime) {
		super();
		this.carManageId = carManageId;
		this.clientUserId = clientUserId;
		this.clientUserCarNo = clientUserCarNo;
		this.clientUserCarPosition = clientUserCarPosition;
		this.clientUserCarActiveMark = clientUserCarActiveMark;
		this.carNoSettingTime = carNoSettingTime;
	}

	public String getCarManageId() {
		return carManageId;
	}

	public void setCarManageId(String carManageId) {
		this.carManageId = carManageId;
	}

	public String getClientUserId() {
		return clientUserId;
	}

	public void setClientUserId(String clientUserId) {
		this.clientUserId = clientUserId;
	}

	public String getClientUserCarNo() {
		return clientUserCarNo;
	}

	public void setClientUserCarNo(String clientUserCarNo) {
		this.clientUserCarNo = clientUserCarNo;
	}

	public String getClientUserCarPosition() {
		return clientUserCarPosition;
	}

	public void setClientUserCarPosition(String clientUserCarPosition) {
		this.clientUserCarPosition = clientUserCarPosition;
	}

	public String getClientUserCarActiveMark() {
		return clientUserCarActiveMark;
	}

	public void setClientUserCarActiveMark(String clientUserCarActiveMark) {
		this.clientUserCarActiveMark = clientUserCarActiveMark;
	}

	public String getCarNoSettingTime() {
		return carNoSettingTime;
	}

	public void setCarNoSettingTime(String carNoSettingTime) {
		this.carNoSettingTime = carNoSettingTime;
	}

	/**
	 * 'car_manage_id 汽车车主用户车辆管理id 数据库表client_user_car_manage
	 * 对应实体类ClientUserCarManage 属性 carManageId; 属性类型String,数据库类型varchar 长度100
	 * 数据库中不自动初始化, 初始化时由调用ID生成器生成',
	 * 
	 */
	public String carManageId;
	/**
	 * 'client_user_id 汽车车主用户id 数据库表client_user 对应实体类ClientUser 属性 clientUserId;
	 * 属性类型String,数据库类型varchar 长度100 数据库中不自动初始化, 以此字段与用户表关联N:1关系',
	 * 
	 */
	public String clientUserId;
	/**
	 * 'client_user_car_no 汽车车主用户车牌号 数据库表client_user_car_manage
	 * 对应实体类ClientUserCarManage 属性 clientUserCarNo; 属性类型String,数据库类型varchar 长度10
	 * 数据库中不自动初始化, 初始化时由用户添加',
	 * 
	 */
	public String clientUserCarNo;
	/**
	 * 'client_user_car_position 汽车车主用户车牌号显示顺序 数据库表client_user_car_manage
	 * 对应实体类ClientUserCarManage 属性 clientUserCarPosition 属性类型String,数据库类型varchar
	 * 长度2 数据库中不自动初始化, 初始化时由用户添加时由手机端设置',
	 * 
	 */
	public String clientUserCarPosition;
	/**
	 * 'enable' COMMENT 'client_user_car_active_mark 汽车车主用户车牌号
	 * 数据库表client_user_car_manage 对应实体类ClientUserCarManage 属性
	 * clientUserCarActiveMark 属性类型String,数据库类型varchar 长度7 两个状态值 enable
	 * 表示该车牌用户设置为活跃状态 disable 表示该车牌用户不希望使用 数据库中自动初始化为disable 初始化时由用户添加',
	 * 
	 */
	public String clientUserCarActiveMark;
	/**
	 * 'car_no_setting_time 汽车车主用户设置车牌时间 数据库表client_user_car_manage
	 * 对应实体类ClientUserCarManage 属性 carNoSettingTime 属性类型String,数据库类型varchar 长度19
	 * 默认为当用户发生变动时 系统自动从后台获取时间生成 格式YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒
	 * eg:1999-01-01 13:22:22',
	 * 
	 */
	public String carNoSettingTime;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 2312241015784855030L;

}
