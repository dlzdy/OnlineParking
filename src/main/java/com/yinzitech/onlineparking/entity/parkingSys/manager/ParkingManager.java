/**
 * Project Name:OnlineParking
 * File Name:ParkingManager.java
 * Package Name:com.yinzitech.onlineparking.entity.parkingSys.manager
 * Date:2015年10月4日上午6:33:09
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.parkingSys.manager;

import java.io.Serializable;

/**
 * ClassName:ParkingManager <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午6:33:09 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class ParkingManager implements Serializable {
	/**
	 * 
	 * Title: toString方法<br/>
	 * Description:<br/>
	 * 
	 * @return String字符串
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingManager [parkingManagerId=" + parkingManagerId + ", parkingManagerPhone=" + parkingManagerPhone
				+ ", parkingManagerPsd=" + parkingManagerPsd + ", parkingInfoId=" + parkingInfoId
				+ ", parkingManagerCreateTime=" + parkingManagerCreateTime + ", parkingManagerActiveMark="
				+ parkingManagerActiveMark + ", parkingManagerName=" + parkingManagerName + "]";
	}

	/**
	 * 
	 * Title: 无参构造方法<br/>
	 * Description:<br/>
	 */
	public ParkingManager() {
	}

	/**
	 * 
	 * Title: 有参构造方法<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerId
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @param parkingInfoId
	 * @param parkingManagerCreateTime
	 * @param parkingManagerActiveMark
	 */

	public ParkingManager(String parkingManagerId, String parkingManagerPhone, String parkingManagerPsd,
			String parkingInfoId, String parkingManagerCreateTime, String parkingManagerActiveMark,
			String parkingManagerName) {
		super();
		this.parkingManagerId = parkingManagerId;
		this.parkingManagerPhone = parkingManagerPhone;
		this.parkingManagerPsd = parkingManagerPsd;
		this.parkingInfoId = parkingInfoId;
		this.parkingManagerCreateTime = parkingManagerCreateTime;
		this.parkingManagerActiveMark = parkingManagerActiveMark;
		this.parkingManagerName = parkingManagerName;
	}

	public String getParkingManagerId() {
		return parkingManagerId;
	}

	public void setParkingManagerId(String parkingManagerId) {
		this.parkingManagerId = parkingManagerId;
	}

	public String getParkingManagerPhone() {
		return parkingManagerPhone;
	}

	public void setParkingManagerPhone(String parkingManagerPhone) {
		this.parkingManagerPhone = parkingManagerPhone;
	}

	public String getParkingManagerPsd() {
		return parkingManagerPsd;
	}

	public void setParkingManagerPsd(String parkingManagerPsd) {
		this.parkingManagerPsd = parkingManagerPsd;
	}

	public String getParkingInfoId() {
		return parkingInfoId;
	}

	public void setParkingInfoId(String parkingInfoId) {
		this.parkingInfoId = parkingInfoId;
	}

	public String getParkingManagerCreateTime() {
		return parkingManagerCreateTime;
	}

	public void setParkingManagerCreateTime(String parkingManagerCreateTime) {
		this.parkingManagerCreateTime = parkingManagerCreateTime;
	}

	public String getParkingManagerActiveMark() {
		return parkingManagerActiveMark;
	}

	public void setParkingManagerActiveMark(String parkingManagerActiveMark) {
		this.parkingManagerActiveMark = parkingManagerActiveMark;
	}

	public String getParkingManagerName() {
		return parkingManagerName;
	}

	public void setParkingManagerName(String parkingManagerName) {
		this.parkingManagerName = parkingManagerName;
	}

	/**
	 * 'parking_manager_id 停车场场主用户账号主键id 数据库表parking_manager 对应实体类parkingManager
	 * 属性 parkingManagerId 属性类型String,数据库类型varchar 长度100 数据库中不自动初始化,
	 * 用户新建账户时由调用生成器生成',
	 * 
	 */
	public String parkingManagerId;
	/**
	 * 'parking_manager_phone 停车场场主手机号 数据库表parking_manager 对应实体类parkingManager
	 * 属性 parkingManagerPhone 属性类型String,数据库类型varchar 长度12
	 * 默认为空,由用户注册时初始化,不允许为空',
	 * 
	 */
	public String parkingManagerPhone;
	/**
	 * 'parking_manager_psd 停车场场主登录密码 数据库表parking_manager 对应实体类parkingManager 属性
	 * parkingManagerPsd 属性类型String,数据库类型varchar 长度100 默认为空,由用户注册时初始化,不允许为空',
	 * 
	 */
	public String parkingManagerPsd;
	/**
	 * 'parking_info_id 停车场场主用户账号关联停车场id 数据库表parking_manager 对应实体类parkingManager
	 * 属性parkingInfoId 属性类型String,数据库类型varchar 长度100 数据库中不自动初始化,
	 * 用户新建账户时由用户手动添加配置关联',
	 * 
	 */
	public String parkingInfoId;
	/**
	 * 'parking_manager_create_time 停车场场主用户账户创建时间 数据库表parking_manager
	 * 对应实体类parkingManager 属性 parkingManagerCreateTime 属性类型String,数据库类型varchar
	 * 长度20 默认为空,停车场场主用户账号创建时由生成器生成 格式YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒
	 * eg:1999-01-01 13:22:22',
	 * 
	 */
	public String parkingManagerCreateTime;
	/**
	 * 'enable' COMMENT 'parking_manager_active_mark 停车场场主用户账号状态
	 * 数据库表parking_manager 对应实体类parkingManager 属性parkingManagerActiveMark
	 * 属性类型String,数据库类型varchar 长度7 默认为enable可用 enable可用 disable为不可用',
	 * 
	 */
	public String parkingManagerActiveMark;
	/**
	 * parking_manager_name
	 */
	public String parkingManagerName;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 5884819952367217744L;

}
