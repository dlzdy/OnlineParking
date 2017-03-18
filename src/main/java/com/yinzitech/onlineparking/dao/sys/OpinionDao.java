/**
 * Project Name:OnlineParking
 * File Name:OpinionDao.java
 * Package Name:com.yinzitech.onlineparking.dao.sys
 * Date:2015年10月23日下午4:09:00
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yinzitech.onlineparking.entity.sys.Opinion;

/**
 * ClassName:OpinionDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月23日 下午4:09:00 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface OpinionDao {
	/**
	 * 
	 * createOpinion:(创建一条意见信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param opinionId
	 * @param opinionUserId
	 * @param opinionUserNick
	 * @param opinionUserPhone
	 * @param opinionBody
	 * @param opinionTime
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO opinion (opinion_id, opinion_user_id, opinion_user_nick, opinion_user_phone, opinion_body, opinion_time) VALUES (#{opinionId}, #{opinionUserId}, #{opinionUserNick}, #{opinionUserPhone}, #{opinionBody}, #{opinionTime})")
	public int createOpinion(@Param("opinionId") String opinionId, @Param("opinionUserId") String opinionUserId,
			@Param("opinionUserNick") String opinionUserNick, @Param("opinionUserPhone") String opinionUserPhone,
			@Param("opinionBody") String opinionBody, @Param("opinionTime") String opinionTime);

	/**
	 * 
	 * queryOpinion:(查询全部意见信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT opinion_id as opinionId, opinion_user_id as opinionUserId,"
			+ " opinion_user_nick as opinionUserNick, opinion_user_phone as opinionUserPhone,"
			+ " opinion_body as opinionBody, opinion_time as opinionTime "
			+ "FROM opinion   WHERE opinion_time BETWEEN #{startTime} and #{endTime} ORDER BY  opinion_time DESC ")
	public List<Opinion> queryOpinion(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
