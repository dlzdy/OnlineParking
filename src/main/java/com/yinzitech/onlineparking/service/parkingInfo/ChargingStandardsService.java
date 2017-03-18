/**
 * Project Name:OnlineParking
 * File Name:ChargingStandardsService.java
 * Package Name:com.yinzitech.onlineparking.service.parkingInfo
 * Date:2015年10月5日下午1:07:16
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.parkingInfo;

/**
 * ClassName:ChargingStandardsService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月5日 下午1:07:16 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */

public interface ChargingStandardsService {
	/**
	 * 
	 * @Title: createChargingStandards:(新建停车场收费标准). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @param parkingInfoId
	 * @param chargingStandardsStep
	 * @param chargingStandardsStepStart
	 * @param chargingStandardsStepEnd
	 * @param chargingStandardsPrise
	 * @param chargingStandardsState
	 * @param chargingStandardsCreateTime
	 * @param chargingStandardsManagerType
	 * @param chargingStandardsManagerId
	 * @return
	 * @since JDK 1.8
	 */
	public String createChargingStandards(String parkingInfoId, String chargingStandardsStep,
			String chargingStandardsStepStart, String chargingStandardsStepEnd, String chargingStandardsPrise,
			String chargingStandardsState, String chargingStanardsManagerType, String chargingStandardsManagerId);

	/**
	 * 
	 * @Title: getChargingStandardsById:(根据chargingStandardsId查看停车场收费标准). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @return
	 * @since JDK 1.8
	 */
	public String getChargingStandardsById(String chargingStandardsId);

	/**
	 * 
	 * @Title: getChargingStandardsListByParkingInfoId:(查询某一停车场的资费标准). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	public String getChargingStandardsListByParkingInfoId(String parkingInfoId);

	/**
	 * 
	 * @Title: updatetChargingStandardsById:(根据停车场收费标准Id更新该收费标准). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	public String updatetChargingStandardsById(String chargingStandardsId, String parkingInfoId,
			String chargingStandardsStep, String chargingStandardsStepStart, String chargingStandardsStepEnd,
			String chargingStandardsPrise, String chargingStandardsState, String chargingStandardsManagerType,
			String chargingStandardsManagerId);

	/**
	 * 
	 * @Title: updateParkingInfoIdById:(根据停车场收费标准Id更新该收费标准关联停车场). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	public String updateParkingInfoIdById(String chargingStandardsId, String parkingInfoId);

	/**
	 * 
	 * @Title: updatetChargingStandardsStateByChargingStandardsId:(
	 *         根据停车场收费标准Id更新该收费标准状态值). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @param chargingStandardsState
	 * @return
	 * @since JDK 1.8
	 */
	public String updatetChargingStandardsStateByChargingStandardsId(String chargingStandardsId,
			String chargingStandardsState);

	/**
	 * 
	 * @Title: deleteChargingStandardsByChargingStandardsId:(根据停车场收费标准Id删除该收费标准)
	 *         . <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @return
	 * @since JDK 1.8
	 */
	public String deleteChargingStandardsByChargingStandardsId(String chargingStandardsId);

	/**
	 * 
	 * getChargingStandardsListByParkingInfoIdLimit:(查询某一停车场的资费标准分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getChargingStandardsListByParkingInfoIdLimit(String parkingInfoId, int pageNumber, int pageSize);
}
