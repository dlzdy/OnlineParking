/**
 * Project Name:OnlineParking
 * File Name:CountOrderDao.java
 * Package Name:com.yinzitech.onlineparking.dao.count
 * Date:2015年11月11日上午10:57:09
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.count;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.count.CountOrder;

/**
 * ClassName:CountOrderDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月11日 上午10:57:09 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface CountOrderDao {

	public List<CountOrder> getCountOrderByDay(@Param("payState") String payState, @Param("payCash") String payCash,
			@Param("numberState") String numberState, @Param("parkingInfoId") String parkingInfoId,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	public List<CountOrder> getCountOrderByMonth(@Param("payState") String payState, @Param("payCash") String payCash,
			@Param("numberState") String numberState, @Param("parkingInfoId") String parkingInfoId,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	public List<CountOrder> getCountOrderByYear(@Param("payState") String payState, @Param("payCash") String payCash,
			@Param("numberState") String numberState, @Param("parkingInfoId") String parkingInfoId,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

}
