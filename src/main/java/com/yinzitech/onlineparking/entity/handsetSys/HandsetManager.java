/**
 * Project Name:OnlineParking
 * File Name:HandsetManager.java
 * Package Name:com.yinzitech.onlineparking.entity.handsetSys
 * Date:2015年10月6日上午10:13:43
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.handsetSys;

import java.io.Serializable;

/**
 * ClassName:HandsetManager <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO handset_manager 手持机管理员 对应countManage 用户账户信息管理核心类 主要管理账户信息 使用外键
 * foreign_key指向Id 包括 余额, 上次操作时 <br/>
 * Date: 2015年10月6日 上午10:13:43 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class HandsetManager implements Serializable {

	@Override
	public String toString() {
		return "HandsetManager [handsetId=" + handsetId + ", handsetManagerId=" + handsetManagerId
				+ ", handsetManagerSecurity=" + handsetManagerSecurity + ", handsetManagerPhone=" + handsetManagerPhone
				+ ", parkingInfoId=" + parkingInfoId + ", handsetManagerCreateTime=" + handsetManagerCreateTime
				+ ", handsetManagerActiveMark=" + handsetManagerActiveMark + ", handsetRegistrAtionId="
				+ handsetRegistrAtionId + ", handsetManagerName=" + handsetManagerName + ", parkName=" + parkName + "]";
	}

	public HandsetManager() {
		super();
	}

	public HandsetManager(String handsetId, String handsetManagerId, String handsetManagerSecurity,
			String handsetManagerPhone, String parkingInfoId, String handsetManagerCreateTime,
			String handsetManagerActiveMark, String handsetRegistrAtionId, String handsetManagerName, String parkName) {
		super();
		this.handsetId = handsetId;
		this.handsetManagerId = handsetManagerId;
		this.handsetManagerSecurity = handsetManagerSecurity;
		this.handsetManagerPhone = handsetManagerPhone;
		this.parkingInfoId = parkingInfoId;
		this.handsetManagerCreateTime = handsetManagerCreateTime;
		this.handsetManagerActiveMark = handsetManagerActiveMark;
		this.handsetRegistrAtionId = handsetRegistrAtionId;
		this.handsetManagerName = handsetManagerName;
		this.parkName = parkName;
	}

	public String getHandsetId() {
		return handsetId;
	}

	public void setHandsetId(String handsetId) {
		this.handsetId = handsetId;
	}

	public String getHandsetManagerId() {
		return handsetManagerId;
	}

	public void setHandsetManagerId(String handsetManagerId) {
		this.handsetManagerId = handsetManagerId;
	}

	public String getHandsetManagerSecurity() {
		return handsetManagerSecurity;
	}

	public void setHandsetManagerSecurity(String handsetManagerSecurity) {
		this.handsetManagerSecurity = handsetManagerSecurity;
	}

	public String getHandsetManagerPhone() {
		return handsetManagerPhone;
	}

	public void setHandsetManagerPhone(String handsetManagerPhone) {
		this.handsetManagerPhone = handsetManagerPhone;
	}

	public String getParkingInfoId() {
		return parkingInfoId;
	}

	public void setParkingInfoId(String parkingInfoId) {
		this.parkingInfoId = parkingInfoId;
	}

	public String getHandsetManagerCreateTime() {
		return handsetManagerCreateTime;
	}

	public void setHandsetManagerCreateTime(String handsetManagerCreateTime) {
		this.handsetManagerCreateTime = handsetManagerCreateTime;
	}

	public String getHandsetManagerActiveMark() {
		return handsetManagerActiveMark;
	}

	public void setHandsetManagerActiveMark(String handsetManagerActiveMark) {
		this.handsetManagerActiveMark = handsetManagerActiveMark;
	}

	public String getHandsetRegistrAtionId() {
		return handsetRegistrAtionId;
	}

	public void setHandsetRegistrAtionId(String handsetRegistrAtionId) {
		this.handsetRegistrAtionId = handsetRegistrAtionId;
	}

	public String getHandsetManagerName() {
		return handsetManagerName;
	}

	public void setHandsetManagerName(String handsetManagerName) {
		this.handsetManagerName = handsetManagerName;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	/**
	 * 'handset_id 停车场手持机ID 数据库表handset_manager 对应实体类handsetManager 属性handsetId
	 * 
	 */
	public String handsetId;
	/**
	 * 'handset_manager_id 停车场手持机收费员用户账号主键id 数据库表handset_manager
	 * 对应实体类handsetManager 属性 handsetManagerId 属性类型String,数据库类型varchar 长度100
	 * 数据库中不自动初始化, 停车场手持机收费员用户账号新建时由调用生成器生成',
	 */
	public String handsetManagerId;
	/**
	 * 'handset_manager_security 停车场手持机管理员用户安全识令牌 数据库表handset_manager
	 * 对应实体类handsetManager 属性 handsetManagerSecurity 属性类型String,数据库类型varchar
	 * 长度100 停车场手持机管理员用户注册成功后,由服务器发送到用户手机管理一份,中心服务器管理一份 关联服务 torken服务器',
	 */
	public String handsetManagerSecurity;
	/**
	 * 'handset_manager_phone 停车场手持机收费员用户手机号 数据库表handset_manager
	 * 对应实体类handsetManager 属性 handsetManagerPhone 属性类型String,数据库类型varchar 长度12
	 * 默认为空,由用户初始化时填写,不允许为空',
	 */
	public String handsetManagerPhone;
	/**
	 * 'parking_info_id 停车场手持机收费员用户账号关联停车场id 数据库表parking_manager
	 * 对应实体类parkingManager 属性parkingInfoId 属性类型String,数据库类型varchar 长度100
	 * 数据库中不自动初始化, 用户新建账户时由用户手动添加配置关联',
	 */
	public String parkingInfoId;
	/**
	 * 'handset_manager_create_time 停车场手持机收费员用户账号创建时间 数据库表handset_manager
	 * 对应实体类handsetManager 属性 handsetManagerCreateTime; 属性类型String,数据库类型varchar
	 * 20 默认为空,停车场手持机收费员用户账号创建时由生成器生成 格式YYYY-MM-DD hh:mm:ss 年-月-日 时时秒分秒秒
	 * eg:1999-01-01 13:22:22',
	 */
	public String handsetManagerCreateTime;
	/**
	 * 'handset_manager_active_mark 停车场手持机收费员用户账号状态 数据库表handset_manager
	 * 对应实体类handsetManager 属性handsetManagerActiveMark 属性类型String,数据库类型varchar
	 * 长度7 默认为enable可用 enable可用 disable为不可用',
	 */
	public String handsetManagerActiveMark;
	/**
	 * 手持设备推送id
	 */
	public String handsetRegistrAtionId;
	/**
	 * 收费员姓名
	 */
	public String handsetManagerName;
	/**
	 * 停车场名称
	 */
	public String parkName;
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */

	private static final long serialVersionUID = -2017812522082464849L;

}
