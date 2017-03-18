/**
 * Project Name:OnlineParking
 * File Name:ChargingStandardsServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.parkingInfo.impl
 * Date:2015年10月5日下午2:48:52
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.parkingInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.parkingInfo.ChargingStandardsDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.parkingInfo.ChargingStandards;
import com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:ChargingStandardsServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月5日 下午2:48:52 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
// @Service
public class ChargingStandardsServiceImpl implements ChargingStandardsService {
	@Autowired
	ChargingStandardsDao chargingStandardsDao;

	/**
	 * 
	 * Title: createChargingStandards新建停车场收费标准<br/>
	 * Description:<br/>
	 * 
	 * @param parkingInfoId
	 * @param chargingStandardsStep
	 * @param chargingStandardsStepStart
	 * @param chargingStandardsStepEnd
	 * @param chargingStandardsPrise
	 * @param chargingStandardsState
	 * @param chargingStanardsManagerType
	 * @param chargingStandardsManagerId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService#createChargingStandards(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String createChargingStandards(String parkingInfoId, String chargingStandardsStep,
			String chargingStandardsStepStart, String chargingStandardsStepEnd, String chargingStandardsPrise,
			String chargingStandardsState, String chargingStanardsManagerType, String chargingStandardsManagerId) {
		/* 停车资费标准Id初始化 */
		String chargingStandardsId = ToolsIdGenerator.getUUID();
		String chargingStandardsCreateTime = TimeTools.getCurrentTime();

		int start = Integer.valueOf(chargingStandardsStepStart); // by kevin
		int end = Integer.valueOf(chargingStandardsStepEnd);// by kevin
		if (start <= end) {
			int target = chargingStandardsDao.createChargingStandards(chargingStandardsId, parkingInfoId,
					chargingStandardsStep, chargingStandardsStepStart, chargingStandardsStepEnd, chargingStandardsPrise,
					chargingStandardsState, chargingStandardsCreateTime, chargingStanardsManagerType,
					chargingStandardsManagerId);

			if (target > 0) {
				System.err.println("创建[" + chargingStandardsId + "]停车场收费标准数据成功");
				return ResultResponse.obj2JsonResult("1", "创建[" + chargingStandardsId + "]停车场收费标准数据成功",
						chargingStandardsId);
			} else {
				System.err.println("创建[" + chargingStandardsId + "]停车场收费标准数据失败");
				return ResultResponse.obj2JsonResult("0", "创建[" + chargingStandardsId + "]停车场收费标准数据失败",
						chargingStandardsId);

			}
		} else {
			System.err.println("创建[" + chargingStandardsId + "]停车场收费标准数据失败");
			return ResultResponse.obj2JsonResult("0", "创建[" + chargingStandardsId + "]停车场收费标准数据失败;开始时间小于上一个结束时间",
					chargingStandardsId);
		}

	}

	/**
	 * 
	 * Title: getChargingStandardsById根据chargingStandardsId查看停车场收费标准<br/>
	 * Description:<br/>
	 * 
	 * @param chargingStandardsId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService#getChargingStandardsById(java.lang.String)
	 */
	@Override
	public String getChargingStandardsById(String chargingStandardsId) {
		ChargingStandards cs = chargingStandardsDao.getChargingStandardsById(chargingStandardsId);
		if (null != cs) {
			System.err.println("查询[" + chargingStandardsId + "]停车场收费标准数据成功");
			return ResultObject.obj2JsonResult("1", "查询[" + chargingStandardsId + "]停车场收费标准数据成功", cs);
		} else {
			System.err.println("查询[" + chargingStandardsId + "]停车场收费标准数据失败");
			return ResultObject.obj2JsonResult("0", "查询[" + chargingStandardsId + "]停车场收费标准数据失败", cs);

		}
	}

	/**
	 * 
	 * Title: getChargingStandardsListByParkingInfoId查询某一停车场的资费标准<br/>
	 * Description:<br/>
	 * 
	 * @param parkingInfoId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService#getChargingStandardsListByParkingInfoId(java.lang.String)
	 */
	@Override
	public String getChargingStandardsListByParkingInfoId(String parkingInfoId) {
		
		List<ChargingStandards> resultList = chargingStandardsDao
				.getChargingStandardsListByParkingInfoId(parkingInfoId);
		// TODO Auto-generated method stub
		if (resultList.size() > 0) {
			System.err.println("查询[" + parkingInfoId + "]停车场收费标准数据成功");
			return ResultObjectList.obj2JsonResult("1", "查询[" + parkingInfoId + "]停车场收费标准数据成功", resultList);
		} else {
			System.err.println("查询[" + parkingInfoId + "]停车场收费标准数据失败");
			return ResultObjectList.obj2JsonResult("0", "查询[" + parkingInfoId + "]停车场收费标准数据失败", resultList);

		}
	}
	
	@Override
	public String getChargingStandardsListByParkingInfoIdLimit(String parkingInfoId,int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<ChargingStandards> resultList = chargingStandardsDao
				.getChargingStandardsListByParkingInfoId(parkingInfoId);
		Page s = PageHelper.endPage();
		// TODO Auto-generated method stub
		if (resultList.size() > 0) {
			System.err.println("查询[" + parkingInfoId + "]停车场收费标准数据成功");
			return ResultObject.obj2JsonResult("1", "查询[" + parkingInfoId + "]停车场收费标准数据成功", s);
		} else {
			System.err.println("查询[" + parkingInfoId + "]停车场收费标准数据失败");
			return ResultObjectList.obj2JsonResult("0", "查询[" + parkingInfoId + "]停车场收费标准数据失败", resultList);

		}
	}

	/**
	 * 
	 * Title: updatetChargingStandardsById根据停车场收费标准Id更新该收费标准<br/>
	 * Description:<br/>
	 * 
	 * @param chargingStandardsId
	 * @param parkingInfoId
	 * @param chargingStandardsStep
	 * @param chargingStandardsStepStart
	 * @param chargingStandardsStepEnd
	 * @param chargingStandardsPrise
	 * @param chargingStandardsState
	 * @param chargingStandardsManagerType
	 * @param chargingStandardsManagerId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService#updatetChargingStandardsById(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public String updatetChargingStandardsById(String chargingStandardsId, String parkingInfoId,
			String chargingStandardsStep, String chargingStandardsStepStart, String chargingStandardsStepEnd,
			String chargingStandardsPrise, String chargingStandardsState, String chargingStandardsManagerType,
			String chargingStandardsManagerId) {
		int target = chargingStandardsDao.updatetChargingStandardsById(chargingStandardsId, parkingInfoId,
				chargingStandardsStep, chargingStandardsStepStart, chargingStandardsStepEnd, chargingStandardsPrise,
				chargingStandardsState, chargingStandardsManagerType, chargingStandardsManagerId);

		if (target > 0) {
			System.err.println("更新[" + chargingStandardsId + "]停车场收费标准数据成功");
			return ResultResponse.obj2JsonResult("1", "更新[" + chargingStandardsId + "]停车场收费标准数据成功",
					chargingStandardsId);
		} else {
			System.err.println("更新[" + chargingStandardsId + "]停车场收费标准数据失败");
			return ResultResponse.obj2JsonResult("0", "更新[" + chargingStandardsId + "]停车场收费标准数据失败",
					chargingStandardsId);

		}
	}

	/**
	 * 
	 * Title: updateParkingInfoIdById根据停车场收费标准Id更新该收费标准关联停车场<br/>
	 * Description:<br/>
	 * 
	 * @param chargingStandardsId
	 * @param parkingInfoId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService#updateParkingInfoIdById(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updateParkingInfoIdById(String chargingStandardsId, String parkingInfoId) {
		int target = chargingStandardsDao.updateParkingInfoIdById(chargingStandardsId, parkingInfoId);
		if (target > 0) {
			System.err.println("更新[" + chargingStandardsId + "]停车场收费标准与停车场关联操作成功");
			return ResultResponse.obj2JsonResult("1", "更新[" + chargingStandardsId + "]停车场收费标准与停车场关联操作成功",
					chargingStandardsId);
		} else {
			System.err.println("更新[" + chargingStandardsId + "]停车场收费标准与停车场关联操作失败");
			return ResultResponse.obj2JsonResult("0", "更新[" + chargingStandardsId + "]停车场收费标准与停车场关联操作失败",
					chargingStandardsId);
		}
	}

	/**
	 * 
	 * Title:
	 * updatetChargingStandardsStateByChargingStandardsId根据停车场收费标准Id更新该收费标准状态值
	 * <br/>
	 * Description:<br/>
	 * 
	 * @param chargingStandardsId
	 * @param chargingStandardsState
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService#updatetChargingStandardsStateByChargingStandardsId(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updatetChargingStandardsStateByChargingStandardsId(String chargingStandardsId,
			String chargingStandardsState) {
		if (!(chargingStandardsState.equals(null)) && (!chargingStandardsState.equals(""))) {
			int target = chargingStandardsDao.updatetChargingStandardsStateByChargingStandardsId(chargingStandardsId,
					chargingStandardsState);
			if (target > 0) {
				System.err.println("更新[" + chargingStandardsId + "]停车场收费标准状态操作成功");
				return ResultResponse.obj2JsonResult("1", "更新[" + chargingStandardsId + "]停车场收费标准状态操作成功",
						chargingStandardsState);
			} else {
				System.err.println("更新[" + chargingStandardsId + "]停车场收费标准状态操作失败");
				return ResultResponse.obj2JsonResult("0", "更新[" + chargingStandardsId + "]停车场收费标准状态操作失败",
						chargingStandardsState);
			}
		} else {
			System.err.println("更新[" + chargingStandardsId + "停车场收费标准状态操作失败");
			return ResultResponse.obj2JsonResult("0",
					"更新[" + chargingStandardsId + "]停车场收费标准与停车场关联操作失败,[chargingStandardsState]只能为enable或disable不能为空",
					chargingStandardsId);
		}

	}

	/**
	 * 
	 * Title: deleteChargingStandardsByChargingStandardsId根据停车场收费标准Id删除该收费标准
	 * <br/>
	 * Description:<br/>
	 * 
	 * @param chargingStandardsId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService#deleteChargingStandardsByChargingStandardsId(java.lang.String)
	 */
	@Override
	public String deleteChargingStandardsByChargingStandardsId(String chargingStandardsId) {

		int target = chargingStandardsDao.deleteChargingStandardsByChargingStandardsId(chargingStandardsId);
		if (target > 0) {
			System.err.println("删除[" + chargingStandardsId + "]停车场收费标准状态操作成功");
			return ResultResponse.obj2JsonResult("1", "删除[" + chargingStandardsId + "]停车场收费标准状态操作成功",
					chargingStandardsId);
		} else {
			System.err.println("删除[" + chargingStandardsId + "]停车场收费标准状态操作失败");
			return ResultResponse.obj2JsonResult("0", "删除[" + chargingStandardsId + "]停车场收费标准状态操作失败",
					chargingStandardsId);
		}
	}

}
