/**
 * Project Name:OnlineParking
 * File Name:ClinetUserCarManageServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.client.carManage.impl
 * Date:2015年10月4日下午9:29:09
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.client.carManage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.client.ClientUserDao;
import com.yinzitech.onlineparking.dao.client.carManage.ClinetUserCarManageDao;
import com.yinzitech.onlineparking.dao.client.carManage.QueryUserCarDao;
import com.yinzitech.onlineparking.dao.order.OrderMapperDao;
import com.yinzitech.onlineparking.entity.client.carManage.ClinetUserCarManage;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.order.ParkingOrder;
import com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:ClinetUserCarManageServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 下午9:29:09 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ClinetUserCarManageServiceImpl implements ClinetUserCarManageService {
	@Autowired
	ClinetUserCarManageDao clinetUserCarManageDao;
	@Autowired
	ClientUserDao clientUserDao;
	@Autowired
	QueryUserCarDao queryUserCarDao;
	@Autowired
	OrderMapperDao orderMapperDao;

	/**
	 * 
	 * TODO 新增用户车牌号（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService#insertUserCar(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public String insertUserCar(String clientUserId, String clientUserCarNo, String clientUserCarPosition,
			String clientUserSecurity) {
		String json = "";
		String carManageId = ToolsIdGenerator.getUUID();
		String carNoSettingTime = TimeTools.getCurrentTime();
		int j = clientUserDao.hasUserSecurity(clientUserId, clientUserSecurity);
		if (j > 0) {

			int s = clinetUserCarManageDao.hasUserCarNo(clientUserCarNo);
			if (s < 1) {

				int i = clinetUserCarManageDao.insertUserCar(carManageId, clientUserId, clientUserCarNo,
						clientUserCarPosition, carNoSettingTime);
				if (i > 0) {
					ClinetUserCarManage clinetUserCarManage = clinetUserCarManageDao
							.selectUserCarBycarManageId(carManageId);
					json = ResultObject.obj2JsonResult("1", "新增车牌号:" + clientUserCarNo + "成功", clinetUserCarManage);
				} else {
					json = ResultObject.obj2JsonResult("0", "新增车牌号:" + clientUserCarNo + "失败", "");
				}
			} else {
				json = ResultObject.obj2JsonResult("0", "新增车牌号:" + clientUserCarNo + "失败", "");
			}
		} else {
			json = ResultObject.obj2JsonResult("2", "token验证失败", "");
		}

		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 通过用户信息查询用户车辆（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService#selectUserCar(java.lang.String)
	 */
	@Override
	public String selectUserCar(String clientUserId, String clientUserSecurity) {
		String json = "";
		int j = clientUserDao.hasUserSecurity(clientUserId, clientUserSecurity);
		if (j > 0) {
			List<ClinetUserCarManage> list = queryUserCarDao.getUserCar("", clientUserId, "", "", "", "");
			if (list != null) {
				json = ResultObjectList.obj2JsonResult("1", "查询用户车牌号信息成功", list);
			} else {
				json = ResultObject.obj2JsonResult("0", "查询用户车牌号信息失败", "");

			}
		} else {
			json = ResultObject.obj2JsonResult("2", "token验证失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 判断车牌号是否存在（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService#hasUserCarNo(java.lang.String)
	 */
	@Override
	public String hasUserCarNo(String clientUserCarNo) {
		String json = "";
		int i = clinetUserCarManageDao.hasUserCarNo(clientUserCarNo);
		if (i > 0 && i <= 1) {
			ClinetUserCarManage cc = clinetUserCarManageDao.selectUserCarByclientUserCarNo(clientUserCarNo);
			String phone = clientUserDao.selectClientUserById(cc.getClientUserId()).getClientUserCellphone();
			json = ResultObject.obj2JsonResult("1", "查询用户车牌号信息成功", phone);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询用户车牌号信息失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 更改车辆状态（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService#upUserCarActiveMark(java.lang.String,
	 *      java.lang.String)
	 */
	public String upUserCarActiveMark(String clientUserCarActiveMark, String carManageId, String clientUserSecurity,
			String clientUserId) {
		String json = "";
		int j = clientUserDao.hasUserSecurity(clientUserId, clientUserSecurity);
		if (j > 0) {
			int i = clinetUserCarManageDao.upUserCarActiveMark(clientUserCarActiveMark, carManageId);
			if (i > 0) {
				
				if (clientUserCarActiveMark.equals("enable")) {
					json = ResultObject.obj2JsonResult("1", "车辆已激活", clientUserCarActiveMark);
				}else {
					json = ResultObject.obj2JsonResult("1", "车辆已关闭", clientUserCarActiveMark);
				}
			} else {
				json = ResultObject.obj2JsonResult("0", "修改用户车牌号状态失败", "");
			}
		} else {
			json = ResultObject.obj2JsonResult("2", "token验证失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 修改车牌号显示顺序（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService#upUserCarPosition(java.lang.String,
	 *      java.lang.String)
	 */
	public String upUserCarPosition(String clientUserCarPosition, String carManageId, String clientUserId,
			String clientUserSecurity) {
		String json = "";
		int j = clientUserDao.hasUserSecurity(clientUserId, clientUserSecurity);
		if (j > 0) {
			int i = clinetUserCarManageDao.upUserCarPosition(clientUserCarPosition, carManageId);
			if (i > 0) {
				json = ResultObject.obj2JsonResult("1", "修改用户车牌号顺序成功", clientUserCarPosition);
			} else {
				json = ResultObject.obj2JsonResult("0", "修改用户车牌号顺序失败", clientUserCarPosition);
			}
		} else {
			json = ResultObject.obj2JsonResult("2", "token验证失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 通过carManageId删除车辆信息（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService#deleteUserCarByCarManageId(java.lang.String)
	 */
	public String deleteUserCarByCarManageId(String carManageId, String clientUserId, String clientUserSecurity) {
		String json = "";
		ClinetUserCarManage car = clinetUserCarManageDao.selectUserCarBycarManageId(carManageId);
		String carNo = "%" + car.getClientUserCarNo() + "%";
		String parkingOrderParkingState = "stay";
		String parkingOrderParkingInfoId = "";
		List<ParkingOrder> list = orderMapperDao.getParkingOrderByCarNo(carNo, parkingOrderParkingInfoId,
				parkingOrderParkingState);
		if (list.size() == 0) {
			int j = clientUserDao.hasUserSecurity(clientUserId, clientUserSecurity);
			if (j > 0) {
				int i = clinetUserCarManageDao.deleteUserCarByCarManageId(carManageId);
				if (i > 0) {
					json = ResultObject.obj2JsonResult("1", "删除用户车牌号成功", carManageId);
				} else {
					json = ResultObject.obj2JsonResult("0", "删除用户车牌号失败", "");
				}
			} else {
				json = ResultObject.obj2JsonResult("2", "token验证失败", "");
			}
		} else {
			json = ResultObject.obj2JsonResult("3", "车牌当前存在未结账单无法删除", "");
		}

		System.out.println(json);
		return json;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService#getUserCar()
	 */
	@Override
	public String getUserCar(String carManageId, String clientUserId, String clientUserCarNo,
			String clientUserCarActiveMark, String startTime, String endTime) {

		String json = "";
		String CarNo = "";
		if (clientUserCarNo != null & clientUserCarNo != "") {
			CarNo = "%" + clientUserCarNo + "%";
		}
		List<ClinetUserCarManage> list = queryUserCarDao.getUserCar(carManageId, clientUserId, CarNo,
				clientUserCarActiveMark, startTime, endTime);
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
		} else {
			json = ResultObject.obj2JsonResult("1", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService#getUserCar()
	 */
	@Override
	public String getUserCarLimit(String carManageId, String clientUserId, String clientUserCarNo,
			String clientUserCarActiveMark, String startTime, String endTime, int pageNumber, int pageSize) {

		String json = "";
		String CarNo = "";
		PageHelper.startPage(pageNumber, pageSize);
		if (clientUserCarNo != null & clientUserCarNo != "") {
			CarNo = "%" + clientUserCarNo + "%";
		}
		List<ClinetUserCarManage> list = queryUserCarDao.getUserCar(carManageId, clientUserId, CarNo,
				clientUserCarActiveMark, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultObject.obj2JsonResult("1", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}
}
