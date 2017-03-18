/**
 * Project Name:OnlineParking
 * File Name:FundAccountManageService.java
 * Package Name:com.yinzitech.onlineparking.service.fundAccountManage
 * Date:2015年10月5日上午1:05:49
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.service.fundAccountManage;

/**
 * ClassName:FundAccountManageService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月5日 上午1:05:49 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface FundAccountManageService {

	/**
	 * 
	 * selectByCustId:(通过用户custId查找资金账户详细信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param custId
	 *            用户账户编号
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectByCustId(String custId, String clientUserSecurity);

	/**
	 * 
	 * upFundAccountManageState:(修改资金用户状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param custId
	 *            用户账户编号
	 * @param fundAccountManageState
	 *            账户状态
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upFundAccountManageState(String custId, String fundAccountManageState);

	/**
	 * 
	 * upFundAccountManageAmount:(更新用户资金金额). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param custId
	 *            用户账户编号
	 * @param fundAccountManageAmount
	 *            账户名下总金额
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upFundAccountManageAmount(String custId, String fundAccountManageAmount);

	/**
	 * 
	 * getFund:(获取资金账户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param fundAccountId
	 * @param custId
	 * @param subaccountType
	 * @param fundAccountManageProperty
	 * @param fundAccountManageState
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getFund(String fundAccountId, String custId, String subaccountType, String fundAccountManageProperty,
			String fundAccountManageState, String startTime, String endTime);

	/**
	 * 
	 * getFundLimit:(获取资金账户信息分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param fundAccountId
	 * @param custId
	 * @param subaccountType
	 * @param fundAccountManageProperty
	 * @param fundAccountManageState
	 * @param startTime
	 * @param endTime
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getFundLimit(String fundAccountId, String custId, String subaccountType,
			String fundAccountManageProperty, String fundAccountManageState, String startTime, String endTime,
			int pageNumber, int pageSize);
}
