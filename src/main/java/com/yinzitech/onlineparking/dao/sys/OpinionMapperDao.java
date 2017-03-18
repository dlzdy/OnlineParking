/**
 * Project Name:OnlineParking
 * File Name:OpinionMapperDao.java
 * Package Name:com.yinzitech.onlineparking.dao.sys
 * Date:2016年5月17日下午1:57:37
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.sys.Opinion;

/**
 * ClassName:OpinionMapperDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月17日 下午1:57:37 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface OpinionMapperDao {

	public List<Opinion> getOpinion(@Param("opinionUserPhone") String opinionUserPhone,
			@Param("startTime") String startTime, @Param("endTime") String endTime);
}
