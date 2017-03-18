/**
 * Project Name:OnlineParking
 * File Name:LoginhistoryDao.java
 * Package Name:com.yinzitech.onlineparking.dao.sys
 * Date:2015年10月22日下午5:03:53
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.sys.LoginHistory;

/**
 * ClassName:LoginhistoryDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月22日 下午5:03:53 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface LoginHistoryDao {
	/**
	 * 
	 * creatHistory:(创建登录历史). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param loginHistoryId
	 * @param loginHistoryCustId
	 * @param loginHistoryStart
	 * @param loginHistoryType
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO login_history (login_history_id, login_history_cust_id, login_history_start, login_history_type) VALUES (#{loginHistoryId}, #{loginHistoryCustId}, #{loginHistoryStart}, #{loginHistoryType})")
	public int creatHistory(@Param("loginHistoryId") String loginHistoryId,
			@Param("loginHistoryCustId") String loginHistoryCustId,
			@Param("loginHistoryStart") String loginHistoryStart, @Param("loginHistoryType") String loginHistoryType);

	/**
	 * 
	 * upHistoryEndTime:(更新退出时间). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param loginHistoryEnd
	 * @param loginHistoryId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE login_history SET login_history_end= #{loginHistoryEnd} WHERE (login_history_id= #{loginHistoryId})")
	public int upHistoryEndTime(@Param("loginHistoryEnd") String loginHistoryEnd,
			@Param("loginHistoryId") String loginHistoryId);

	/**
	 * 
	 * getLoginhistoryByCustId:(getBYCustId). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 * 
	 * @author ziheng
	 * @param loginHistoryCustId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT login_history_id as loginHistoryId," + " login_history_cust_id as loginHistoryCustId,"
			+ " login_history_start as loginHistoryStart," + " login_history_end as loginHistoryEnd,"
			+ " login_history_type as loginHistoryType"
			+ " FROM  login_history WHERE  login_history_cust_id = #{loginHistoryCustId}")
	public List<LoginHistory> getLoginHistoryByCustId(@Param("loginHistoryCustId") String loginHistoryCustId);

}
