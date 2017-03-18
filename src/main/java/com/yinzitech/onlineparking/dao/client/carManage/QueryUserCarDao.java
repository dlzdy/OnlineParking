 
/**
 * Project Name:OnlineParking
 * File Name:QueryUserCarDao.java
 * Package Name:com.yinzitech.onlineparking.dao.client.carManage
 * Date:2015年11月1日上午11:47:51
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.dao.client.carManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.client.carManage.ClinetUserCarManage;

/**
 * ClassName:QueryUserCarDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月1日 上午11:47:51 <br/>
 * @author   ziheng
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */ 
public interface QueryUserCarDao {

	public List<ClinetUserCarManage> getUserCar(@Param("carManageId") String carManageId,
			@Param("clientUserId") String clientUserId, @Param("clientUserCarNo") String clientUserCarNo,
			@Param("clientUserCarActiveMark") String clientUserCarActiveMark, @Param("startTime") String startTime,
			@Param("endTime") String endTime);


}
