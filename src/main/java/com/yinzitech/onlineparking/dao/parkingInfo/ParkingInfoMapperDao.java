/**
 * Project Name:OnlineParking
 * File Name:ParkingInfoMapperDap.java
 * Package Name:com.yinzitech.onlineparking.dao.parkingInfo
 * Date:2016年5月17日上午11:46:36
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.parkingInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.parkingInfo.ParkingInfo;

/**
 * ClassName:ParkingInfoMapperDap <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月17日 上午11:46:36 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ParkingInfoMapperDao {

	public List<ParkingInfo> getParkingInfo(@Param("parkingInfoId") String parkingInfoId,
			@Param("parkingInfoAddress") String parkingInfoAddress, @Param("parkingInfoState") String parkingInfoState,
			@Param("parkingInfoName") String parkingInfoName);
}
