/**
 * Project Name:OnlineParking
 * File Name:TimeTools.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月4日上午3:22:49
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * ClassName:TimeTools <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午3:22:49 <br/>
 * 
 * @author Kevin
 * @version
 * @since JDK 1.8
 * @see
 */
public class TimeTools {
	/**
	 * 
	 * @Title: getCurrentTime:(获取当前时间的标准字符串形如"2005-12-16 16:03:45"). <br/>
	 * @Description: 获取到当前时间的标准字符串,以YYYY-MM-DD hh:mm:ss格式.<br/>
	 * @param:
	 * @reTODO 例如在.<br/>
	 *
	 * @author Kevin
	 * @return YYYY-MM-DD hh:mm:ss格式 字符串
	 * @since JDK 1.8
	 */
	public static String getCurrentTime() {
		// 获得系统时间
		Date date = new Date();
		// 创建一个数组存放月份
		final String[] MONTH = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", };
		// 存储字符串
		StringBuffer ret = new StringBuffer();
		// 将字符串转成成String类型
		// 格式为Sat Dec 17 15:55:16 CST
		// 2005
		String dateToString = date.toString();
		// 将字符串进行拆分
		ret.append(dateToString.substring(24, 24 + 4));// append yyyy
		String sMonth = dateToString.substring(4, 4 + 3);
		// 拼接字符串
		for (int i = 0; i < 12; i++) { // append mm
			if (sMonth.equalsIgnoreCase(MONTH[i])) {
				if ((i + 1) < 10)
					ret.append("-0");
				else
					ret.append("-");
				ret.append((i + 1));
				break;
			}
		}

		ret.append("-");
		ret.append(dateToString.substring(8, 8 + 2));
		ret.append(" ");
		ret.append(dateToString.substring(11, 11 + 8));

		return ret.toString();
	}

	public static long mathTime(String endTime, String startTime) {
		System.out.println("" + startTime);
		System.out.println("" + endTime);
		// 传入时间格式生成一个SimpleDateFormat对象
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		long sec = 0;
		try {
			// 计算两个时间差多少秒
			sec = (time.parse(endTime).getTime() - time.parse(startTime).getTime()) / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		BigInteger b = new BigInteger(String.valueOf(String.valueOf(sec)));
		b = b.abs();

		return b.longValue();
	}

	public static String getTime(long mss) {
		long days = mss / (60 * 60 * 24);
		long hours = (mss % (60 * 60 * 24)) / (60 * 60);
		long minutes = (mss % (60 * 60)) / 60;
		long seconds = (mss % 60);
		String times = "";

		if (days > 0) {
			times = days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
		} else if (hours > 0) {
			times = hours + "小时" + minutes + "分钟" + seconds + "秒";
		} else if (minutes > 0) {
			times = minutes + "分钟" + seconds + "秒 ";
		} else {
			times = seconds + "秒";
		}

		return times;
	}

	/**
	 * 
	 * getTimesnight:(获取当天时间2015年10月23日00:00:00). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public static String getTimesnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		int time = (int) (cal.getTimeInMillis() / 1000 - 86400);
		System.setProperty("user.timezone", "Asia/Shanghai");
		TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
		TimeZone.setDefault(tz);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String times = format.format(new Date(time * 1000L));
		return times;
	}

	/**
	 * 
	 * getStartMouthDay:(获取当前月份第一天的时间). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public static String getStartMouthDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal_1 = Calendar.getInstance();
		cal_1.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(cal_1.getTime());
	}

	/**
	 * 
	 * getTimeslast:(获取当天最后时间). <br/>
	 * TODO(2015年10月26日 23:59:59– 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */

	public static String getTimeslast() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		int time = (int) (cal.getTimeInMillis() / 1000) - 1;
		System.setProperty("user.timezone", "Asia/Shanghai");
		TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
		TimeZone.setDefault(tz);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String times = format.format(new Date(time * 1000L));
		return times;
	}

	public static String second2date(String second) {

		Date date = new Date(Long.valueOf(second) * 1000);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String getDate = format.format(date);
		return getDate;
	}

}
