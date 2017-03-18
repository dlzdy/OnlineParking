/**
 * Project Name:OnlineParking
 * File Name:ParkingManagerService.java
 * Package Name:com.yinzitech.onlineparking.service.parkingSys
 * Date:2015年10月4日上午6:38:17
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.parkingSys;

/**
 * ClassName:ParkingManagerService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午6:38:17 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ParkingManagerService {
	/**
	 * 
	 * @Title: hasPhoneNumber:(查询目标手机号是否已经存在). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @return 0表示失败 1表示成功
	 * @since JDK 1.8
	 */
	public String hasPhoneNumber(String parkingManagerPhone);

	/**
	 * 
	 * parkingManagerSignUp:(停车场管理员注册). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingManagerPhone
	 *            电话号码
	 * @param parkingManagerPsd
	 *            密码
	 * @param parkingManagerName
	 *            管理员姓名
	 * @param parkingInfoId
	 *            停车场id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String parkingManagerSignUp(String parkingManagerPhone, String parkingManagerPsd, String parkingManagerName,
			String parkingInfoId);

	/**
	 * 
	 * @Title: getParkingManagerByParkingManagerId:(通过Id查询停车场管理员信息). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerId
	 * @return
	 * @since JDK 1.8
	 */
	public String getParkingManagerByParkingManagerId(String parkingManagerId);

	/**
	 * 
	 * @Title: getParkingManagerByParkingManagerPhone:(通过停车场管理员手机号查询停车场管理员信息).
	 *         <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @return
	 * @since JDK 1.8
	 */
	public String getParkingManagerByParkingManagerPhone(String parkingManagerPhone);

	/**
	 * 
	 * @Title: login:(登录验证). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @return
	 * @since JDK 1.8
	 */
	public String login(String parkingManagerPhone, String parkingManagerPsd);

	/**
	 * 
	 * @Title: updateParkingManager:(更新停车场管理员账号信息). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @param parkingInfoId
	 * @param parkingManagerCreateTime
	 * @param parkingManagerActiveMark
	 * @return
	 * @since JDK 1.8
	 */
	public String updateParkingManager(String parkingManagerPhone, String parkingManagerPsd, String parkingInfoId,
			String parkingManagerCreateTime, String parkingManagerActiveMark);

	/**
	 * 
	 * @Title: updateParkingManagerPhone:(更换停车场管理员手机号). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerId
	 * @param parkingManagerPhone
	 * @return
	 * @since JDK 1.8
	 */
	public String updateParkingManagerPhone(String parkingManagerId, String parkingManagerPhone);

	/**
	 * 
	 * @Title: updateParkingManagerPsd:(停车场管理员密码找回). <br/>
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @return
	 * @since JDK 1.8
	 */
	public String updateParkingManagerPsd(String parkingManagerPhone, String parkingManagerPsd);

	/**
	 * 
	 * @Title: selectAllParkingManager:(查询所有停车场管理员账户). <br/>
	 *
	 * @author Kevin
	 * @return
	 * @since JDK 1.8
	 */
	public String selectAllParkingManager(int pageNumber, int pageSize);

	/**
	 * 
	 * @Title: disableParkingManager:(更改停车场管理员用户状态). <br/>
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingManagerActiveMark
	 * @return
	 * @since JDK 1.8
	 */
	public String disableParkingManager(String parkingManagerPhone, String parkingManagerActiveMark);

	/**
	 * 
	 * @Title: deleteParkingManager:(删除停车场管理员用户账号,根据id). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerId
	 * @return
	 * @since JDK 1.8
	 */
	public String deleteParkingManager(String parkingManagerId);

	/**
	 * 
	 * @Title: updtaParkingInfoId:(根据停车场管理员手机号,关联停车场). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	public String updtaParkingInfoId(String parkingManagerPhone, String parkingInfoId);

	/**
	 * 
	 * getParkingInfoMapper:(获取停车场管理账户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingManagerId
	 *            管理员id
	 * @param parkingManagerPhone
	 *            管理员电话
	 * @param parkingManagerPsd
	 *            密码
	 * @param parkingInfoId
	 *            停车场id
	 * @param parkingManagerActiveMark
	 *            启用状态
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getParkingInfoMapper(String parkingManagerId, String parkingManagerPhone, String parkingManagerPsd,
			String parkingInfoId, String parkingManagerActiveMark, String parkingManagerName, int pageNumber,
			int pageSize);

	public String upParkingManager(String parkingManagerPhone, String parkingManagerPsd, String parkingManagerName,
			String parkingManagerActiveMark, String parkingInfoId, String parkingManagerId);
}
