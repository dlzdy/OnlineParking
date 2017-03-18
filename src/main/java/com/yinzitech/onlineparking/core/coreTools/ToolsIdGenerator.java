/**
 * Project Name:OnlineParking
 * File Name:ToolsIdGenerator.java
 * Package Name:com.yinzitech.onlineparking.core.coreTools
 * Date:2015年10月4日上午7:14:29
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.core.coreTools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * ClassName:ToolsIdGenerator <br/>
 * Function: id生成器工具类. <br/>
 * Date: 2015年10月4日 上午7:14:29 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class ToolsIdGenerator {
	public ToolsIdGenerator() {
	}

	/**
	 * 获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	/**
	 * 
	 * @Title: getOrderId:(获取订单的id). <br/>
	 * @Description: TODO(订单Id为时间戳+5位随机数字组成保证唯一).<br/>
	 *
	 * @author Kevin
	 * @return
	 * @since JDK 1.8
	 */
	public static String getOrderId() {
		String orderId = "";
		String timeStamp = getTimeStamp();
		String randomNo = randomNo();
		orderId = timeStamp + randomNo;
		return orderId;
	}

	public static String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String timeStamp = sdf.format(new Date());
		return timeStamp;
	}

	public static String randomNo() {
		StringBuffer buf = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			buf.append(random.nextInt(10));// 取三个随机数追加到StringBuffer
		}
		return buf.toString();
	}

	// public static void main(String[] args) {
	// String a = getOrderId();
	// System.err.println(a);
	// }

}
