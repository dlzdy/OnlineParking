/**
 * Project Name:OnlineParking
 * File Name:OpinionService.java
 * Package Name:com.yinzitech.onlineparking.service.sys
 * Date:2015年10月23日下午4:20:30
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys;

/**
 * ClassName:OpinionService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月23日 下午4:20:30 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface OpinionService {

	/**
	 * 
	 * createOpinion:(创建一条意见信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param opinionUserId
	 * @param opinionBody
	 * @return
	 * @since JDK 1.8u60
	 */
	public String createOpinion(String opinionUserId, String opinionBody, String clientUserSecurity);

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
	public String queryOpinion(String startTime, String endTime, int pageNumber, int pageSize);

	public String getOpinion(String opinionUserPhone, String startTime, String endTime, int pageNumber, int pageSize);

}
