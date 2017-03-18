/**
 * Project Name:OnlineParking
 * File Name:ParkingCount.java
 * Package Name:com.yinzitech.onlineparking.entity.sys
 * Date:2015年11月24日下午4:54:39
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.sys;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:ParkingCount <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月24日 下午4:54:39 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ParkingCount implements Serializable {

	@Override
	public String toString() {
		return "ParkingCount [money=" + money + ", car=" + car + ", parkingManager=" + parkingManager + ", handManager="
				+ handManager + ", spaces=" + spaces + ", lastSpaces=" + lastSpaces + ", user=" + user + ", nullUser="
				+ nullUser + ", mouthOrder=" + mouthOrder + ", dayOrder=" + dayOrder + ", massage=" + massage + "]";
	}

	public ParkingCount() {
		super();
	}

	public ParkingCount(String money, String car, String parkingManager, String handManager, String spaces,
			String lastSpaces, String user, String nullUser, String mouthOrder, String dayOrder, List<?> massage) {
		super();
		this.money = money;
		this.car = car;
		this.parkingManager = parkingManager;
		this.handManager = handManager;
		this.spaces = spaces;
		this.lastSpaces = lastSpaces;
		this.user = user;
		this.nullUser = nullUser;
		this.mouthOrder = mouthOrder;
		this.dayOrder = dayOrder;
		this.massage = massage;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getParkingManager() {
		return parkingManager;
	}

	public void setParkingManager(String parkingManager) {
		this.parkingManager = parkingManager;
	}

	public String getHandManager() {
		return handManager;
	}

	public void setHandManager(String handManager) {
		this.handManager = handManager;
	}

	public String getSpaces() {
		return spaces;
	}

	public void setSpaces(String spaces) {
		this.spaces = spaces;
	}

	public String getLastSpaces() {
		return lastSpaces;
	}

	public void setLastSpaces(String lastSpaces) {
		this.lastSpaces = lastSpaces;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNullUser() {
		return nullUser;
	}

	public void setNullUser(String nullUser) {
		this.nullUser = nullUser;
	}

	public String getMouthOrder() {
		return mouthOrder;
	}

	public void setMouthOrder(String mouthOrder) {
		this.mouthOrder = mouthOrder;
	}

	public String getDayOrder() {
		return dayOrder;
	}

	public void setDayOrder(String dayOrder) {
		this.dayOrder = dayOrder;
	}

	public List<?> getMassage() {
		return massage;
	}

	public void setMassage(List<?> massage) {
		this.massage = massage;
	}

	/**
	 * 资金
	 */
	public String money;
	/**
	 * 车位使用次数
	 */
	public String car;
	/**
	 * 停车场后台管理员
	 */
	public String parkingManager;
	/**
	 * 收费员
	 */
	public String handManager;
	/**
	 * 车位
	 */
	public String spaces;
	/**
	 * 剩余车位
	 */
	public String lastSpaces;
	/**
	 * 注册用户
	 */
	public String user;
	/**
	 * 非注册用户
	 */
	public String nullUser;
	/**
	 * 当月订单
	 */
	public String mouthOrder;
	/**
	 * 本日订单
	 */
	public String dayOrder;
	/**
	 * 通知公告
	 */
	public List<?> massage;
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = 8783303716581249698L;

}
