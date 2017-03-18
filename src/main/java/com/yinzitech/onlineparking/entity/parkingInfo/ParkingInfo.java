/**
 * Project Name:OnlineParking
 * File Name:ParkingInfo.java
 * Package Name:com.yinzitech.onlineparking.entity.parkingInfo
 * Date:2015年10月4日上午3:18:38
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.parkingInfo;

import java.io.Serializable;

/**
 * ClassName:ParkingInfo <br/>
 * Function: 停车场信息主类,对应数据库表parking_info. <br/>
 * Date: 2015年10月4日 上午3:18:38 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class ParkingInfo implements Serializable {
	/**
	 * 
	 * Title: toString重写ToString方法<br/>
	 * Description:<br/>
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingInfo [parkingInfoId=" + parkingInfoId + ", parkingInfoName=" + parkingInfoName
				+ ", parkingInfoAddress=" + parkingInfoAddress + ", parkingInfoLongitude=" + parkingInfoLongitude
				+ ", parkingInfoLatitude=" + parkingInfoLatitude + ", parkingInfoParkingSpaces="
				+ parkingInfoParkingSpaces + ", parkingInfoRestParkingSpaces=" + parkingInfoRestParkingSpaces
				+ ", parkingInfoState=" + parkingInfoState + ", parkingInfoCreateTime=" + parkingInfoCreateTime
				+ ", parkingInfoCreateManagerType=" + parkingInfoCreateManagerType + ", parkingInfoCreateManagerId="
				+ parkingInfoCreateManagerId + "]";
	}

	/**
	 * 
	 * Title: 无参构造方法<br/>
	 * Description:<br/>
	 */
	public ParkingInfo() {
		super();
	}

	/**
	 * 
	 * Title: 全参构造方法<br/>
	 * Description:<br/>
	 * 
	 * @param parkingInfoId
	 * @param parkingInfoName
	 * @param parkingInfoAddress
	 * @param parkingInfoLongitude
	 * @param parkingInfoLatitude
	 * @param parkingInfoParkingSpaces
	 * @param parkingInfoRestParkingSpaces
	 * @param parkingInfoState
	 * @param parkingInfoCreateTime
	 * @param parkingInfoCreateManagerType
	 * @param parkingInfoCreateManagerId
	 */
	public ParkingInfo(String parkingInfoId, String parkingInfoName, String parkingInfoAddress,
			String parkingInfoLongitude, String parkingInfoLatitude, String parkingInfoParkingSpaces,
			String parkingInfoRestParkingSpaces, String parkingInfoState, String parkingInfoCreateTime,
			String parkingInfoCreateManagerType, String parkingInfoCreateManagerId) {
		super();
		this.parkingInfoId = parkingInfoId;
		this.parkingInfoName = parkingInfoName;
		this.parkingInfoAddress = parkingInfoAddress;
		this.parkingInfoLongitude = parkingInfoLongitude;
		this.parkingInfoLatitude = parkingInfoLatitude;
		this.parkingInfoParkingSpaces = parkingInfoParkingSpaces;
		this.parkingInfoRestParkingSpaces = parkingInfoRestParkingSpaces;
		this.parkingInfoState = parkingInfoState;
		this.parkingInfoCreateTime = parkingInfoCreateTime;
		this.parkingInfoCreateManagerType = parkingInfoCreateManagerType;
		this.parkingInfoCreateManagerId = parkingInfoCreateManagerId;
	}

	public String getParkingInfoId() {
		return parkingInfoId;
	}

	public void setParkingInfoId(String parkingInfoId) {
		this.parkingInfoId = parkingInfoId;
	}

	public String getParkingInfoName() {
		return parkingInfoName;
	}

	public void setParkingInfoName(String parkingInfoName) {
		this.parkingInfoName = parkingInfoName;
	}

	public String getParkingInfoAddress() {
		return parkingInfoAddress;
	}

	public void setParkingInfoAddress(String parkingInfoAddress) {
		this.parkingInfoAddress = parkingInfoAddress;
	}

	public String getParkingInfoLongitude() {
		return parkingInfoLongitude;
	}

	public void setParkingInfoLongitude(String parkingInfoLongitude) {
		this.parkingInfoLongitude = parkingInfoLongitude;
	}

	public String getParkingInfoLatitude() {
		return parkingInfoLatitude;
	}

	public void setParkingInfoLatitude(String parkingInfoLatitude) {
		this.parkingInfoLatitude = parkingInfoLatitude;
	}

	public String getParkingInfoParkingSpaces() {
		return parkingInfoParkingSpaces;
	}

	public void setParkingInfoParkingSpaces(String parkingInfoParkingSpaces) {
		this.parkingInfoParkingSpaces = parkingInfoParkingSpaces;
	}

	public String getParkingInfoRestParkingSpaces() {
		return parkingInfoRestParkingSpaces;
	}

	public void setParkingInfoRestParkingSpaces(String parkingInfoRestParkingSpaces) {
		this.parkingInfoRestParkingSpaces = parkingInfoRestParkingSpaces;
	}

	public String getParkingInfoState() {
		return parkingInfoState;
	}

	public void setParkingInfoState(String parkingInfoState) {
		this.parkingInfoState = parkingInfoState;
	}

	public String getParkingInfoCreateTime() {
		return parkingInfoCreateTime;
	}

	public void setParkingInfoCreateTime(String parkingInfoCreateTime) {
		this.parkingInfoCreateTime = parkingInfoCreateTime;
	}

	public String getParkingInfoCreateManagerType() {
		return parkingInfoCreateManagerType;
	}

	public void setParkingInfoCreateManagerType(String parkingInfoCreateManagerType) {
		this.parkingInfoCreateManagerType = parkingInfoCreateManagerType;
	}

	public String getParkingInfoCreateManagerId() {
		return parkingInfoCreateManagerId;
	}

	public void setParkingInfoCreateManagerId(String parkingInfoCreateManagerId) {
		this.parkingInfoCreateManagerId = parkingInfoCreateManagerId;
	}

	/**
	 * 'parking_info_id 停车场id 数据库表parking_info 对应实体类parkingInfo 属性
	 * parkingInfoId; 属性类型String,数据库类型varchar 长度100 数据库中不自动初始化,
	 * 新建停车场信息时由调用生成器生成',
	 * 
	 */
	public String parkingInfoId;

	/**
	 * 'parking_info_name 停车场名称 数据库表parking_info 对应实体类parkingInfo 属性
	 * parkingInfoName; 属性类型String,数据库类型varchar 长度100 数据库中不自动初始化,
	 * 新建停车场信息时由用户设置',
	 * 
	 */
	public String parkingInfoName;

	/**
	 * parkingInfoAddress<br/>
	 * 停车场地址<br/>
	 * 数据库表 parking_info<br/>
	 * 对应实体类 ParkingInfo<br/>
	 * 属性 parkingInfoAddress<br/>
	 * 属性类型 String <br/>
	 * 数据库类型 varchar<br/>
	 * 长度200<br/>
	 * 数据库中不自动初始化<br/>
	 * 由用户设置<br/>
	 */
	public String parkingInfoAddress;

	/**
	 * 'parking_info_longitude 停车场经度 数据库表parking_info 对应实体类parkingInfo 属性
	 * parkingInfoLongitude; 属性类型String,数据库类型varchar 长度50 不可为空
	 * 数据库中不自动初始化,此项字段为添加停车场信息时的必选项',
	 * 
	 */
	public String parkingInfoLongitude;

	/**
	 * 'p arking_info_latitude 停车场纬度 数据库表parking_info 对应实体类parkingInfo 属性
	 * parkingInfoLatitude;属性类型String, 数据库类型varchar 长度50 不可为空
	 * 数据库中不自动初始化,此项字段为添加停车场信息时的必选项',
	 */
	public String parkingInfoLatitude;

	/**
	 * 'parking_info_parking_spaces 停车场车位数 数据库表parking_info 对应实体类parkingInfo 属性
	 * parkingInfoParkingSpaces; 属性类型String,数据库类型varchar 长度50 不可为空
	 * 数据库中不自动初始化,此项字段为添加停车场信息时的必选项',
	 * 
	 */
	public String parkingInfoParkingSpaces;

	/**
	 * 'parking_info_rest_parking_spaces 停车场 剩余 车位数 数据库表parking_info
	 * 对应实体类parkingInfo 属性 parkingInfoRestParkingSpaces 属性类型String, 数据库类型varchar
	 * 长度50 不可为空 数据库中不自动初始化, 此项字段为添加停车场信息时的必选项 停车场剩余车位数=停车场车位数-停车场现有停车数',
	 */
	public String parkingInfoRestParkingSpaces;

	/**
	 * parking_info_state 停车场状态 数据库表 parking_info 对应实体类 ParkingInfo 属性
	 * parkingInfoState 属性类型 String ,数据库类型 varchar 长度7 默认为 enable 可用 enable可用
	 * disable为不可用
	 */
	public String parkingInfoState;

	/**
	 * 'parking_info_create_time 停车场注册日期 数据库表parking_info 对应实体类parkingInfo 属性
	 * parkingInfoCreateTime 属性类型String,数据库类型varchar 长度20 默认为空,由用户填写
	 * 格式YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒 eg:1999-01-01 13:22:22',
	 * 
	 */
	public String parkingInfoCreateTime;

	/**
	 * 'parking_info_create_manager_type 停车场信息改动人员类型 数据库表parking_info
	 * 对应实体类parkingInfo 属性 parkingInfoCreateManagerType 属性类型String,数据库类型varchar
	 * 长度2 默认为 1 后台管理员 1 后台管理员 2 停车场场主管理员',
	 * 
	 */
	public String parkingInfoCreateManagerType;

	/**
	 * 'parking_info_create_manager_id 停车场信息改动人员id
	 * 参照parking_info_create_manager_type停车场信息改动人员类型 当值 =1 时 为后台管理员id =2 时
	 * 为停车场场主管理员id 数据库表parking_info 对应实体类parkingInfo 属性
	 * parkingInfoCreateManagerId 属性类型String,数据库类型varchar 长度100 无默值
	 * ,根据操作停车场信息时,获取操作人员id (新建停车场信息,也算操作,暂定为初始化操作)',
	 * 
	 */
	public String parkingInfoCreateManagerId;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 4516899631432941358L;

}
