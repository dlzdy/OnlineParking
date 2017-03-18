/**
 * Project Name:OnlineParking
 * File Name:CountOrder.java
 * Package Name:com.yinzitech.onlineparking.entity.count
 * Date:2015年11月11日上午10:48:30
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.count;

import java.io.Serializable;

/**
 * ClassName:CountOrder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月11日 上午10:48:30 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class CountOrder implements Serializable {

	@Override
	public String toString() {
		return "CountOrder [year=" + year + ", month=" + month + ", day=" + day + ", countCar=" + countCar + ", cost="
				+ cost + "]";
	}

	public CountOrder() {
		super();
	}

	public CountOrder(String year, String month, String day, String countCar, String cost) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.countCar = countCar;
		this.cost = cost;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCountCar() {
		return countCar;
	}

	public void setCountCar(String countCar) {
		this.countCar = countCar;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String year;
	public String month;
	public String day;
	public String countCar;
	public String cost;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8u60
	 */
	private static final long serialVersionUID = -6432936317713829253L;

}
