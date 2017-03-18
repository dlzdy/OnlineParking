/**
 * Project Name:OnlineParking
 * File Name:ParkingCountService.java
 * Package Name:com.yinzitech.onlineparking.service.sys
 * Date:2015年11月24日下午5:06:41
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys;

/**
 * ClassName:ParkingCountService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月24日 下午5:06:41 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ParkingCountService {
	/**
	 * 
	 * getParkingCount:(这停车场统计信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng 停车场id
	 * @param parkingId
	 *            当月月初起始时间
	 * @param mouthTime
	 *            本日起始时间
	 * @param dayTime
	 *            当前查询时间
	 * @param endTime
	 *            公告信息个数
	 * @param messageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getParkingCount(String parkingId, String mouthTime, String dayTime, String endTime, int messageSize);
}
