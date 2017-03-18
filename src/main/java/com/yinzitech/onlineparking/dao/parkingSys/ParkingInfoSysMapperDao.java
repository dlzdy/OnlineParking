/**
 * Project Name:OnlineParking
 * File Name:ParkingInfoMapperDao.java
 * Package Name:com.yinzitech.onlineparking.dao.parkingSys
 * Date:2016年5月27日下午3:23:25
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.parkingSys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.parkingSys.manager.ParkingManager;

/**
 * ClassName:ParkingInfoMapperDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月27日 下午3:23:25 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ParkingInfoSysMapperDao {

	public List<ParkingManager> getParkingInfoMapper(@Param("parkingManagerId") String parkingManagerId,
			@Param("parkingManagerPhone") String parkingManagerPhone,
			@Param("parkingManagerPsd") String parkingManagerPsd, @Param("parkingInfoId") String parkingInfoId,
			@Param("parkingManagerActiveMark") String parkingManagerActiveMark,
			@Param("parkingManagerName") String parkingManagerName);

	public int upParkingManager(@Param("parkingManagerPhone") String parkingManagerPhone,
			@Param("parkingManagerPsd") String parkingManagerPsd,
			@Param("parkingManagerName") String parkingManagerName,
			@Param("parkingManagerActiveMark") String parkingManagerActiveMark,
			@Param("parkingInfoId") String parkingInfoId, @Param("parkingManagerId") String parkingManagerId);

}
