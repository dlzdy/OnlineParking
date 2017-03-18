/**
 * Project Name:OnlineParking
 * File Name:QuertHandsetOrderDao.java
 * Package Name:com.yinzitech.onlineparking.dao.handsetSys
 * Date:2015年11月4日上午9:53:43
 * Copyright (c) 2015,  ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.handsetSys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.order.HandsetOrder;

/**
 * ClassName:QuertHandsetOrderDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月4日 上午9:53:43 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface QuertHandsetOrderDao {

	public List<HandsetOrder> getHandSetOrder(@Param("parkingInfoId") String parkingInfoId,
			@Param("phone") String phone, @Param("managerId") String managerId,
			@Param("managerName") String managerName, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

}
