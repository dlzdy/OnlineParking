/**
 * Project Name:OnlineParking
 * File Name:CalfeeData.java
 * Package Name:com.yinzitech.onlineparking.utils.pojo
 * Date:2016年1月14日上午11:15:29
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils.pojo;

/**
 * ClassName:CalfeeData <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年1月14日 上午11:15:29 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class CalfeeData {
	private String startTime;

	private int parkID;

	private String parkName;

	private int billID;

	private String plate;

	private String endTime;

	private int should;

	private int advPaid;

	private int advancedFreeMintute;

	private String freeMoney;

	public String getFreeMoney() {
		return freeMoney;
	}

	public void setFreeMoney(String freeMoney) {
		this.freeMoney = freeMoney;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setParkID(int parkID) {
		this.parkID = parkID;
	}

	public int getParkID() {
		return this.parkID;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkName() {
		return this.parkName;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public int getBillID() {
		return this.billID;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getPlate() {
		return this.plate;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setShould(int should) {
		this.should = should;
	}

	public int getShould() {
		return this.should;
	}

	public void setAdvPaid(int advPaid) {
		this.advPaid = advPaid;
	}

	public int getAdvPaid() {
		return this.advPaid;
	}

	public void setAdvancedFreeMintute(int advancedFreeMintute) {
		this.advancedFreeMintute = advancedFreeMintute;
	}

	public int getAdvancedFreeMintute() {
		return this.advancedFreeMintute;
	}

}
