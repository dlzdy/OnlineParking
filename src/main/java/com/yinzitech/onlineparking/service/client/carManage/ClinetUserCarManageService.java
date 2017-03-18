/**
 * Project Name:OnlineParking
 * File Name:ClinetUserCarManageService.java
 * Package Name:com.yinzitech.onlineparking.service.client.CarManage
 * Date:2015年10月4日下午9:28:25
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.client.carManage;

/**
 * ClassName:ClinetUserCarManageService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 下午9:28:25 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */

public interface ClinetUserCarManageService {
	/**
	 * 
	 * insertUserCar:(新增用户车牌号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param carManageId
	 *            汽车车主用户车辆管理id
	 * @param clientUserId
	 *            汽车车主用户id
	 * @param clientUserCarNo
	 *            汽车车主用户车牌号
	 * @param clientUserCarPosition
	 *            汽车车主用户车牌号显示顺序
	 * @param carNoSettingTime
	 *            汽车车主用户设置车牌时间
	 * @return
	 * @since JDK 1.8u60
	 */
	public String insertUserCar(String clientUserId, String clientUserCarNo, String clientUserCarPosition,
			String clientUserSecurity);

	/**
	 * 
	 * selectUserCar:(通过用户信息查询用户车辆). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectUserCar(String clientUserId, String clientUserSecurity);

	/**
	 * 
	 * hasUserCarNo:(判断车牌号是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarNo
	 * @return
	 * @since JDK 1.8u60
	 */
	public String hasUserCarNo(String clientUserCarNo);

	/**
	 * 
	 * upUserCarActiveMark:(更改车辆状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarActiveMark
	 *            enable disable
	 * @param carManageId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upUserCarActiveMark(String clientUserCarActiveMark, String carManageId, String clientUserSecurity,
			String clientUserId);

	/**
	 * 
	 * upUserCarPosition:(修改车牌号显示顺序). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarPosition
	 * @param carManageId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upUserCarPosition(String clientUserCarPosition, String carManageId, String clientUserId,
			String clientUserSecurity);

	/**
	 * 
	 * deleteUserCar:(通过UserCar删除车辆信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param carManageId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String deleteUserCarByCarManageId(String carManageId, String clientUserId, String clientUserSecurity);

	/**
	 * 
	 * getUserCar:(获取用户车辆信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param carManageId
	 * @param clientUserId
	 * @param clientUserCarNo
	 * @param clientUserCarActiveMark
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getUserCar(String carManageId, String clientUserId, String clientUserCarNo,
			String clientUserCarActiveMark, String startTime, String endTime);

	/**
	 * 
	 * getUserCarLimit:(获取用户车辆信息分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param carManageId
	 * @param clientUserId
	 * @param clientUserCarNo
	 * @param clientUserCarActiveMark
	 * @param startTime
	 * @param endTime
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getUserCarLimit(String carManageId, String clientUserId, String clientUserCarNo,
			String clientUserCarActiveMark, String startTime, String endTime, int pageNumber, int pageSize);
}
