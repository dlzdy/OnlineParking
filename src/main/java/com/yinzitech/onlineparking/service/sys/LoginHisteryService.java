/**
 * Project Name:OnlineParking
 * File Name:LoginHisteryService.java
 * Package Name:com.yinzitech.onlineparking.service.sys
 * Date:2015年10月22日下午5:26:36
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys;

/**
 * ClassName:LoginHisteryService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月22日 下午5:26:36 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface LoginHisteryService {
	/**
	 * 
	 * creatHistory:(创建登录历史). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param loginHistoryCustId
	 * @param loginHistoryType
	 *            类型<br/>
	 *            0 sys<br/>
	 *            1 user<br/>
	 *            2 handSet<br/>
	 *            3 parkManager<br/>
	 * @return
	 * @since JDK 1.8u60
	 */

	public String creatHistory(String loginHistoryCustId, String loginHistoryType);

	/**
	 * 
	 * upHistoryEndTime:(更新退出时间). <br/>
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
	public String upHistoryEndTime(String loginHistoryCustId);

	/**
	 * 
	 * getLoginHisteryByCustId:(getBYCustId). <br/>
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

	public String getLoginHisteryByCustId(String loginHistoryCustId,int pageNumber,int pageSize);

	 
}
