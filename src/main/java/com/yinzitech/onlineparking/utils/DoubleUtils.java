/**
 * Project Name:OnlineParking
 * File Name:DoubleUtils.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年12月21日下午12:56:17
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import java.math.BigDecimal;

/**
 * ClassName:DoubleUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年12月21日 下午12:56:17 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class DoubleUtils {
	public static Double add(Number value1, Number value2) {

		BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
		return b1.add(b2).doubleValue();
	}

	public static Double minus(Number value1, Number value2) {

		BigDecimal b1 = new BigDecimal(Double.toString(value1.doubleValue()));
		BigDecimal b2 = new BigDecimal(Double.toString(value2.doubleValue()));
		return b1.subtract(b2).doubleValue();
	}

	public static void main(String[] args) {
		
		System.out.println(minus(0.01, 0.01));
	}
}
