/**
 * Project Name:OnlineParking
 * File Name:ParkingInfoService.java
 * Package Name:com.yinzitech.onlineparking.service.parkingInfo
 * Date:2015年10月4日上午6:26:18
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/
package com.yinzitech.onlineparking.service.parkingInfo;

/**
 * ClassName:ParkingInfoService <br/>
 * Function: 停车场服务层. <br/>
 * Date: 2015年10月4日 上午6:26:18 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ParkingInfoService {
	/**
	 * 
	 * @Title: createParkingInfo:(新增停车场基本数据). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 *            *
	 * @param parkingInfoName
	 * @param parkingInfoAddress
	 * @param parkingInfoLongitude
	 * @param parkingInfoLatitude
	 * @param parkingInfoParkingSpaces
	 * @param parkingInfoRestParkingSpaces
	 * @param parkingInfoState
	 *            *
	 * @param parkingInfoCreateTime
	 *            *
	 * @param parkingInfoCreateManagerType
	 * @param parkingInfoCreateManagerId
	 * @return
	 * @since JDK 1.8
	 */
	public String createParkingInfo(String parkingInfoName, String parkingInfoAddress, String parkingInfoLongitude,
			String parkingInfoLatitude, String parkingInfoParkingSpaces, String parkingInfoRestParkingSpaces,
			String parkingInfoCreateManagerType, String parkingInfoCreateManagerId);

	/**
	 * 
	 * @Title: updateParkingInfo:(更新停车场基本数据). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @param parkingInfoName
	 * @param parkingInfoAddress
	 * @param parkingInfoLongitude
	 * @param parkingInfoLatitude
	 * @param parkingInfoParkingSpaces
	 * @param parkingInfoRestParkingSpaces
	 * @param parkingInfoState
	 * @param parkingInfoCreateManagerType
	 * @param parkingInfoCreateManagerId
	 * @return
	 * @since JDK 1.8
	 */
	public String updateParkingInfo(String parkingInfoId, String parkingInfoName, String parkingInfoAddress,
			String parkingInfoLongitude, String parkingInfoLatitude, String parkingInfoParkingSpaces,
			String parkingInfoRestParkingSpaces, String parkingInfoState, String parkingInfoCreateManagerType,
			String parkingInfoCreateManagerId);

	/**
	 * 
	 * @Title: updateParkingInfoState:(更新停车场基本数据parkingInfoState字段). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @param parkingInfoState
	 * @return
	 * @since JDK 1.8
	 */
	public String updateParkingInfoState(String parkingInfoId, String parkingInfoState);

	/**
	 * 
	 * @Title: getParkingInfoById:(通过停车场id查询停车场详细信息). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	public String getParkingInfoById(String parkingInfoId);

	/**
	 * 
	 * @Title: deleteParkingInfoById:(删除parkingInfoId的停车场信息). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	public String deleteParkingInfoById(String parkingInfoId);

	/**
	 * 
	 * getParkingInfo:(查询全部停车场信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getParkingInfo();

	/**
	 * 
	 * getParkingInfoLimit:(查询全部停车场信息分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getParkingInfoLimit(int pageNumber, int pageSize);

	/**
	 * 
	 * getParkInfoByLoLa:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param Lonitude
	 *            经度
	 * @param Latitude
	 *            纬度
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getParkInfoByLoLa(String Lonitude, String Latitude);

	/**
	 * 
	 * getParkingInfo:(停车场条件检索). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @param parkingInfoAddress
	 * @param parkingInfoState
	 * @param parkingInfoName
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getParkingInfo(String parkingInfoId, String parkingInfoAddress, String parkingInfoState,
			String parkingInfoName,int pageNumber, int pageSize);
}
