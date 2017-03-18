/**
 * Project Name:OnlineParking
 * File Name:QueryHandSetDao.java
 * Package Name:com.yinzitech.onlineparking.dao.handsetSys
 * Date:2015年11月1日下午1:21:56
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.dao.handsetSys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.handsetSys.HandsetManager;

/**
 * ClassName:QueryHandSetDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月1日 下午1:21:56 <br/>
 * @author   ziheng
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */ 
public interface QueryHandSetDao {

	public List<HandsetManager> getHandSet(
			@Param("handsetId") String handsetId,
			@Param("handsetManagerId") String handsetManagerId,
			@Param("handsetManagerPhone") String handsetManagerPhone,
			@Param("parkingInfoId") String parkingInfoId,
			@Param("handsetManagerActiveMark") String handsetManagerActiveMark,
			@Param("handsetManagerName") String handsetManagerName,
			@Param("startTime") String startTime,
			@Param("endTime") String endTime);
}
