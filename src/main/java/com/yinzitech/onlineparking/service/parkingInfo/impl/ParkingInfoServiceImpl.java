/**
 * Project Name:OnlineParking
 * File Name:ParkingInfoServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.parkingInfo.impl
 * Date:2015年10月4日上午6:26:32
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.parkingInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.fundAccountManage.FundAccountManageDao;
import com.yinzitech.onlineparking.dao.parkingInfo.ParkingInfoDao;
import com.yinzitech.onlineparking.dao.parkingInfo.ParkingInfoMapperDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.parkingInfo.ParkingInfo;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:ParkingInfoServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午6:26:32 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
// @Service
public class ParkingInfoServiceImpl implements ParkingInfoService {
	@Autowired
	ParkingInfoDao parkingInfoDao;
	@Autowired
	FundAccountManageDao fundAccountManageDao;
	@Autowired
	ParkingInfoMapperDao pmd;

	/**
	 * 
	 * Title: createParkingInfo新增停车场基本数据<br/>
	 * Description:<br/>
	 * 
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
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService#createParkingInfo(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String createParkingInfo(String parkingInfoName, String parkingInfoAddress, String parkingInfoLongitude,
			String parkingInfoLatitude, String parkingInfoParkingSpaces, String parkingInfoRestParkingSpaces,
			String parkingInfoCreateManagerType, String parkingInfoCreateManagerId) {
		String parkingInfoId = ToolsIdGenerator.getUUID();
		String parkingInfoState = "enable";
		String parkingInfoCreateTime = TimeTools.getCurrentTime();
		int target = parkingInfoDao.insertParkingInfo(parkingInfoId, parkingInfoName, parkingInfoAddress,
				parkingInfoLongitude, parkingInfoLatitude, parkingInfoParkingSpaces, parkingInfoRestParkingSpaces,
				parkingInfoState, parkingInfoCreateTime, parkingInfoCreateManagerType, parkingInfoCreateManagerId);
		if (target > 0) {
			// 资金账户
			String fundAccountManageProperty = "2";
			String fundAccountManageCreateTime = TimeTools.getCurrentTime();
			String fundAccountId = ToolsIdGenerator.getUUID();
			String subaccountType = "2";
			int f = fundAccountManageDao.insertFundAccountManage(fundAccountId, parkingInfoId, subaccountType,
					fundAccountManageProperty, fundAccountManageCreateTime);
			if (f > 0) {
				System.out.println("用户资金账户创建成功 :" + fundAccountId + "");
			} else {
				System.out.println("用户资金账户创建失败 ");
			}

			System.err.println("创建[" + parkingInfoName + "]停车场,停车场数据成功");
			ParkingInfo parkingInfo = parkingInfoDao.getParkingInfoById(parkingInfoId);
			return ResultObject.obj2JsonResult("1", "创建[" + parkingInfoName + "]停车场,停车场数据成功", parkingInfo);
		} else {
			System.err.println("创建[" + parkingInfoName + "]停车场,停车场数据失败");
			return ResultResponse.obj2JsonResult("0", "创建[" + parkingInfoName + "]停车场,停车场数据失败", "");

		}
	}

	/**
	 * 
	 * Title: updateParkingInfo更新停车场基本数据<br/>
	 * Description:<br/>
	 * 
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
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService#updateParkingInfo(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String updateParkingInfo(String parkingInfoId, String parkingInfoName, String parkingInfoAddress,
			String parkingInfoLongitude, String parkingInfoLatitude, String parkingInfoParkingSpaces,
			String parkingInfoRestParkingSpaces, String parkingInfoState, String parkingInfoCreateManagerType,
			String parkingInfoCreateManagerId) {
		int target = parkingInfoDao.updateParkingInfo(parkingInfoId, parkingInfoName, parkingInfoAddress,
				parkingInfoLongitude, parkingInfoLatitude, parkingInfoParkingSpaces, parkingInfoRestParkingSpaces,
				parkingInfoState, parkingInfoCreateManagerType, parkingInfoCreateManagerId);
		if (target > 0) {
			System.err.println("更新[" + parkingInfoName + "]停车场,停车场数据成功");
			return ResultResponse.obj2JsonResult("1", "更新[" + parkingInfoName + "]停车场,停车场数据成功", "");
		} else {
			System.err.println("更新[" + parkingInfoName + "]停车场,停车场数据失败");
			return ResultResponse.obj2JsonResult("0", "更新[" + parkingInfoName + "]停车场,停车场数据失败", "");

		}
	}

	/**
	 * 
	 * Title: updateParkingInfoState更新停车场基本数据parkingInfoState字段<br/>
	 * Description:<br/>
	 * 
	 * @param parkingInfoId
	 * @param parkingInfoState
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService#updateParkingInfoState(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updateParkingInfoState(String parkingInfoId, String parkingInfoState) {

		int target = parkingInfoDao.updateParkingInfoState(parkingInfoId, parkingInfoState);
		if (target > 0) {
			System.err.println("更新[" + parkingInfoId + "]停车场parkingInfoState字段成功");
			return ResultResponse.obj2JsonResult("1", "更新[" + parkingInfoId + "]停车场parkingInfoState字段成功", "");
		} else {
			System.err.println("更新[" + parkingInfoId + "]停车场parkingInfoState字段失败");
			return ResultResponse.obj2JsonResult("0", "更新[" + parkingInfoId + "]停车场parkingInfoState字段成功", "");

		}
	}

	/**
	 * 
	 * Title: getParkingInfoById通过停车场id查询停车场详细信息<br/>
	 * Description:<br/>
	 * 
	 * @param parkingInfoId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService#getParkingInfoById(java.lang.String)
	 */
	@Override
	public String getParkingInfoById(String parkingInfoId) {
		ParkingInfo pi = parkingInfoDao.getParkingInfoById(parkingInfoId);
		if (null != pi) {
			System.err.println("查询[" + parkingInfoId + "]停车场数据成功");
			return ResultObject.obj2JsonResult("1", "查询[" + parkingInfoId + "]停车场数据成功", pi);
		} else {
			System.err.println("查询[" + parkingInfoId + "]停车场数据失败");
			return ResultResponse.obj2JsonResult("0", "查询[" + parkingInfoId + "]停车场数据失败", "");
		}
	}

	/**
	 * 
	 * Title: deleteParkingInfoById删除parkingInfoId的停车场信息<br/>
	 * Description:<br/>
	 * 
	 * @param parkingInfoId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService#deleteParkingInfoById(java.lang.String)
	 */
	@Override
	public String deleteParkingInfoById(String parkingInfoId) {
		int target = parkingInfoDao.deleteParkingInfoById(parkingInfoId);
		if (target > 0) {
			System.err.println("删除[" + parkingInfoId + "]停车场信息成功");
			return ResultResponse.obj2JsonResult("1", "删除[" + parkingInfoId + "]停车场信息成功", "");
		} else {
			System.err.println("删除[" + parkingInfoId + "]停车场信息失败");
			return ResultResponse.obj2JsonResult("0", "删除[" + parkingInfoId + "]停车场信息失败", "");

		}
	}

	@Override
	public String getParkingInfo() {
		String json = "";
		List<ParkingInfo> list = parkingInfoDao.getParkingInfo();
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询停车场信息成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "暂无停车场信息", "");
		}

		return json;
	}

	@Override
	public String getParkingInfoLimit(int pageNumber, int pageSize) {
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		List<ParkingInfo> list = parkingInfoDao.getParkingInfo();
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询停车场信息成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "暂无停车场信息", "");
		}

		return json;
	}

	@Override
	public String getParkInfoByLoLa(String Lonitude, String Latitude) {
		String json = "";
		String startLongitude = String.valueOf((Double.valueOf(Lonitude) - 0.005));
		String endLongitude = String.valueOf((Double.valueOf(Lonitude) + 0.005));
		String startLatitude = String.valueOf((Double.valueOf(Latitude) - 0.005));
		String endLatitude = String.valueOf((Double.valueOf(Latitude) + 0.005));
		List<ParkingInfo> list = parkingInfoDao.getParkInfoByLoLa(startLongitude, endLongitude, startLatitude,
				endLatitude);
		if (list != null) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "暂无停车场数据", "");
		}

		return json;
	}

	@Override
	public String getParkingInfo(String parkingInfoId, String parkingInfoAddress, String parkingInfoState,
			String parkingInfoName, int pageNumber, int pageSize) {
		System.out.println(parkingInfoAddress);
		String json = "";
		String Address = "";
		String Name = "";
		if (parkingInfoAddress != null & parkingInfoAddress != "") {
			Address = "%" + parkingInfoAddress + "%";
		}
		if (parkingInfoName != null & parkingInfoName != "") {
			Name = "%" + parkingInfoName + "%";
		}
		PageHelper.startPage(pageNumber, pageSize);
		List<ParkingInfo> list = pmd.getParkingInfo(parkingInfoId, Address, parkingInfoState, Name);
		Page s = PageHelper.endPage();
		if (list != null) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "暂无停车场数据", "");
		}

		return json;
	}

}
