/**
 * Project Name:OnlineParking
 * File Name:HandsetSysService.java
 * Package Name:com.yinzitech.onlineparking.service.handsetSys
 * Date:2015年10月6日下午12:53:49
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.handsetSys;

/**
 * ClassName:HandsetSysService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月6日 下午12:53:49 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface HandsetSysService {

	/**
	 * 
	 * creatHandsetManager:(创建手持设备账户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerName
	 *            停车场手持机管理员姓名
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @param parkingInfoId
	 *            账号关联停车场id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String creatHandsetManager(String handsetManagerPhone, String parkingInfoId, String handsetManagerName);

	/**
	 * 
	 * hasManagerPhone:(判断管理员电话是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	public String hasManagerPhone(String handsetManagerPhone);

	/**
	 * 
	 * hasActiveMark:(判断账号状态是否可用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	public String hasActiveMark(String handsetManagerPhone);

	/**
	 * 
	 * LoginHandsetManager:(手持机登录). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerSecurity
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */

	public String LoginHandsetManager(String handsetManagerSecurity, String handsetManagerPhone, String handsetId);

	/**
	 * 
	 * selectHandsetManagerByParkId:(通过停车场ID查询全部停车场账户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectHandsetManagerByParkId(String parkingInfoId);

	/**
	 * 
	 * selectHandsetManagerByName:(查询手持管理员ByName). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerName
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectHandsetManagerByName(String handsetManagerName);

	/**
	 * 
	 * upHandsetManagerPhone:(修改手机号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerId
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upHandsetManagerPhone(String handsetManagerId, String handsetManagerPhone);

	/**
	 * 
	 * upActiveMark:(通过电话号码更新手持账户状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 * @param handsetManagerActiveMark
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upActiveMark(String handsetManagerPhone, String handsetManagerActiveMark);

	/**
	 * 
	 * deleteHandsetManagerByManagerId:(通过手持机用户ID删除账户内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String deleteHandsetManagerByManagerId(String handsetManagerId);

	/**
	 * 
	 * addHandsetRegistrAtionId:(更新手持设备推送id). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetRegistrAtionId
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */

	public String addHandsetRegistrAtionId(String handsetRegistrAtionId, String handsetManagerPhone);

	/**
	 * 
	 * getHandesetOrder:(查询当天截至时间订单总金额数量). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param managerId
	 *            手持用户id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getHandesetOrder(String managerId);

	/**
	 * 
	 * insertHandesetOrder:(增加统计数据). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String insertHandesetOrder();

	/**
	 * 
	 * queryHandesetOrderByManagerId:(查询手持用户统计数据). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param managerId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryHandesetOrderByManagerId(String managerId);

	/**
	 * 
	 * upHandsetUser:(修改手持机用户姓名). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetId
	 * @param handsetManagerName
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upHandsetUser(String handsetManagerPhone, String handsetManagerName);

	/**
	 * 
	 * selectHandsetManagerByManagerId:(手持id查询手持信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectHandsetManagerByManagerId(String handsetManagerId);

	/**
	 * 
	 * selectHandsetManager:(查询手持机订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param key
	 *            phone/name
	 * @param value
	 *            value
	 * @param managerId
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectHandsetManager(String key, String value, String managerId, String startTime, String endTime);

	/**
	 * 
	 * upHandsetId:(更新手持id). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetId
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upHandsetId(String handsetId, String handsetManagerPhone);

	/**
	 * 
	 * getHandSet:(获取手持设备信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetId
	 * @param handsetManagerId
	 * @param handsetManagerPhone
	 * @param parkingInfoId
	 * @param handsetManagerActiveMark
	 * @param handsetManagerName
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getHandSet(String handsetId, String handsetManagerId, String handsetManagerPhone,
			String parkingInfoId, String handsetManagerActiveMark, String handsetManagerName, String startTime,
			String endTime);

	/**
	 * 
	 * getHandSetLimit:(获取手持设备信息分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetId
	 * @param handsetManagerId
	 * @param handsetManagerPhone
	 * @param parkingInfoId
	 * @param handsetManagerActiveMark
	 * @param handsetManagerName
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getHandSetLimit(String handsetId, String handsetManagerId, String handsetManagerPhone,
			String parkingInfoId, String handsetManagerActiveMark, String handsetManagerName, String startTime,
			String endTime, int pageNumber, int pageSize);

	/**
	 * 
	 * getHandSetOrder:(获取手持机统计信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @param phone
	 * @param managerId
	 * @param managerName
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getHandSetOrder(String parkingInfoId, String phone, String managerId, String managerName,
			String startTime, String endTime);

	/**
	 * 
	 * getHandSetOrder:(获取手持机统计信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @param phone
	 * @param managerId
	 * @param managerName
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getHandSetOrderLimit(String parkingInfoId, String phone, String managerId, String managerName,
			String startTime, String endTime, int pageNumber, int pageSize);

	/**
	 * 
	 * upParkingInfoId:(手持用户变更停车场). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @param handsetManagerId
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upParkingInfoId(String parkingInfoId, String handsetManagerId);
}
