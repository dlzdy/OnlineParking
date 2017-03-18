/**
 * Project Name:OnlineParking
 * File Name:ClientUserService.java
 * Package Name:com.yinzitech.onlineparking.service.client
 * Date:2015年10月4日上午9:56:05
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.client;

/**
 * ClassName:ClientUserService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午9:56:05 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ClientUserService {

	/**
	 * 
	 * insertUser:(新增用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 *            汽车车主用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	public String createtUser(String clientUserCellphone);

	/**
	 * 
	 * hasPhoneNumber:(查询电话号码是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 * @return
	 * @since JDK 1.8u60
	 */
	public String hasPhoneNumber(String clientUserCellphone, String clientUserSecurity);

	/**
	 * 
	 * selectUser:(查询全部用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectUser();

	/**
	 * 
	 * updateUser:(更新用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * 
	 * @param clientUserNickName
	 *            汽车车主昵称
	 * @param clientUserBirthday
	 *            汽车车主生日
	 * @param clientUserSex
	 *            汽车车主性别
	 * @param clientUserCellphone
	 *            汽车车主电话
	 * @return
	 * @since JDK 1.8u60
	 */
	public String updateUser(String clientUserNickName, String clientUserBirthday, String clientUserSex,
			String clientUserCellphone, String clientUserSecurity);

	/**
	 * 
	 * upUserSecurity:(更新汽车车主用户安全识令牌). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @param clientUserCellphone
	 *            汽车车主用户电话
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upUserSecurity(String clientUserSecurity, String clientUserCellphone);

	/**
	 * 
	 * upUserActiveMark:(修改用户激活状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 *            汽车车主用户电话
	 * @param ActiveMark
	 *            disable 不可用 enable 可用
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upUserActiveMark(String clientUserCellphone, String clientUserActiveMark);

	/**
	 * 
	 * deleteUserById:(通过clientUserId删除用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 *            汽车车主用户id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String deleteUserById(String clientUserId);

	/**
	 * 
	 * userLogin:(验证用户登录). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 *            汽车车主用户手机号
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return
	 * @since JDK 1.8u60
	 */
	public String userLogin(String clientUserCellphone, String clientUserSecurity);

	/**
	 * 
	 * upUserPhone:(更改用户手机号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 *            汽车车主用户手机号
	 * @param clientUserId
	 *            汽车车主用户id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upUserPhone(String clientUserSecurity, String clientUserCellphone, String clientUserId);

	/**
	 * 
	 * upUserAutoPay:(是否自动支付 0为不自动支付 1为自动支付). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserAutoPay
	 * @param clientUserSecurity
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upUserAutoPay(String clientUserAutoPay, String clientUserSecurity, String clientUserId);

	/**
	 * 
	 * userPayOk:(确认支付). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserSecurity
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String userPayOk(String clientUserSecurity, String clientUserId, String parkingOrderId);

	/**
	 * 
	 * addRegistrAtionId:(更新用户推送号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param registrAtionId
	 * @param clientUserSecurity
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String addRegistrAtionId(String registrAtionId, String clientUserSecurity, String clientUserId,
			String clientUserType);

	/**
	 * 
	 * getUser:(获取用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @param clientUserCellphone
	 * @param clientUserSex
	 * @param startBirthday
	 * @param endBirthday
	 * @param startUpTime
	 * @param endUpTime
	 * @param clientUserActiveMark
	 * @param clientUserAutoPay
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getUser(String clientUserId, String clientUserCellphone, String clientUserSex, String startBirthday,
			String endBirthday, String startUpTime, String endUpTime, String clientUserActiveMark,
			String clientUserAutoPay);

	/**
	 * 
	 * getUserLimit:(获取用户信息分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @param clientUserCellphone
	 * @param clientUserSex
	 * @param startBirthday
	 * @param endBirthday
	 * @param startUpTime
	 * @param endUpTime
	 * @param clientUserActiveMark
	 * @param clientUserAutoPay
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getUserLimit(String clientUserId, String clientUserCellphone, String clientUserSex,
			String startBirthday, String endBirthday, String startUpTime, String endUpTime, String clientUserActiveMark,
			String clientUserAutoPay, int pageNumber, int pageSize);

	/**
	 * 
	 * getUserSecurity:(验证令牌). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @param clientUserSecurity
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getUserSecurity(String clientUserId, String clientUserSecurity);
}
