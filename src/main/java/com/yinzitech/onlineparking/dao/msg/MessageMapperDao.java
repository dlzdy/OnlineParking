/**
 * Project Name:OnlineParking
 * File Name:MessageMapperDao.java
 * Package Name:com.yinzitech.onlineparking.dao.msg
 * Date:2016年5月17日下午1:39:59
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.msg;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.msg.Message;

/**
 * ClassName:MessageMapperDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月17日 下午1:39:59 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface MessageMapperDao {

	public List<Message> queryMessage(@Param("msgId") String msgId, @Param("msgStatus") String msgStatus,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

}
