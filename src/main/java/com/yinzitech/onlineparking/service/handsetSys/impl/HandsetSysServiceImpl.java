/**
 * Project Name:OnlineParking
 * File Name:HandsetSysServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.handsetSys.impl
 * Date:2015年10月6日下午1:08:34
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.handsetSys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.handsetSys.HandsetManagerDao;
import com.yinzitech.onlineparking.dao.handsetSys.QuertHandsetOrderDao;
import com.yinzitech.onlineparking.dao.handsetSys.QueryHandSetDao;
import com.yinzitech.onlineparking.dao.parkingInfo.ParkingInfoDao;
import com.yinzitech.onlineparking.dao.securityCore.SecurityCoreDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.handsetSys.HandsetManager;
import com.yinzitech.onlineparking.entity.order.HandsetOrder;
import com.yinzitech.onlineparking.service.handsetSys.HandsetSysService;
import com.yinzitech.onlineparking.service.securityCore.SecurityCoreService;
import com.yinzitech.onlineparking.service.sys.LoginHisteryService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:HandsetSysServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月6日 下午1:08:34 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class HandsetSysServiceImpl implements HandsetSysService {
	@Autowired
	HandsetManagerDao handsetManagerDao;
	@Autowired
	SecurityCoreDao sd;
	@Autowired
	SecurityCoreService securityCoreService;
	@Autowired
	LoginHisteryService loginHisteryService;
	@Autowired
	ParkingInfoDao parkingInfoDao;
	@Autowired
	QueryHandSetDao qh;
	@Autowired
	QuertHandsetOrderDao qho;

	/**
	 * 
	 * TODO 创建手持设备账户（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#creatHandsetManager(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String creatHandsetManager(String handsetManagerPhone, String parkingInfoId, String handsetManagerName) {
		String json = "";
		String handsetManagerId = ToolsIdGenerator.getUUID();
		String handsetManagerCreateTime = TimeTools.getCurrentTime();
		String handsetManagerSecurity = "";

		String handsetId = "";
		int i = handsetManagerDao.creatHandsetManager(handsetId, handsetManagerId, handsetManagerSecurity,
				handsetManagerPhone, parkingInfoId, handsetManagerCreateTime, handsetManagerName);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "创建手持账户成功：" + handsetManagerPhone + "", "");

		} else {
			json = ResultResponse.obj2JsonResult("0", "创建手持账户失败：" + handsetManagerPhone + "", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 判断管理员电话是否存在（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#hasManagerPhone(java.lang.String)
	 */
	@Override
	public String hasManagerPhone(String handsetManagerPhone) {
		String json = "";
		int i = handsetManagerDao.hasManagerPhone(handsetManagerPhone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "手持账户存在：" + handsetManagerPhone + "", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "手持账户不存在：" + handsetManagerPhone + "", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 判断账号状态是否可用（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#hasActiveMark(java.lang.String)
	 */
	@Override
	public String hasActiveMark(String handsetManagerPhone) {
		String json = "";
		int i = handsetManagerDao.hasActiveMark(handsetManagerPhone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "账户：" + handsetManagerPhone + "可用", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "账户：" + handsetManagerPhone + "不可用", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String upParkingInfoId(String parkingInfoId, String handsetManagerId) {
		String json = "";
		int i = handsetManagerDao.upParkingInfoId(parkingInfoId, handsetManagerId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "账户变更：" + handsetManagerId + "成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "账户变更：" + handsetManagerId + "不成功", "");
		}

		return json;
	}

	/**
	 * 
	 * TODO 手持机登录（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#LoginHandsetManager(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String LoginHandsetManager(String handsetManagerSecurity, String handsetManagerPhone, String handsetId) {

		String json = "";
		// 判断管理员电话是否存在
		int i = handsetManagerDao.hasManagerPhone(handsetManagerPhone);
		if (i > 0) {
			HandsetManager handsetManager = handsetManagerDao.LoginHandsetManager(handsetManagerSecurity,
					handsetManagerPhone);
			String parkName = parkingInfoDao.getParkingInfoById(handsetManager.getParkingInfoId()).getParkingInfoName();
			handsetManager.setParkName(parkName);
			handsetManager.setHandsetId(handsetId);
			// 比对用户令牌

			if (handsetManagerSecurity == null & handsetManagerSecurity.equals("")) {
				// 更新用户安全令牌
				String securityCoreId = ToolsIdGenerator.getUUID();
				String securityCoreAccountSecurity = ToolsIdGenerator.getUUID();
				String securityCoreState = "enable";
				String securityCoreCreateTime = TimeTools.getCurrentTime();
				securityCoreService.createSecurity(securityCoreId, "003", handsetId, securityCoreAccountSecurity,
						securityCoreState, securityCoreCreateTime);

				int s = handsetManagerDao.uphandsetManagerSecurity(handsetManagerPhone, securityCoreAccountSecurity);
				if (s > 0) {
					json = ResultObject.obj2JsonResult("1", "更新用户安全令牌成功", handsetManager);
					loginHisteryService.creatHistory(handsetManager.getHandsetManagerId(), "2");
				} else {
					json = ResultResponse.obj2JsonResult("0", "更新用户安全令牌失败", "");
				}
			} else {
				if (handsetManager.getHandsetManagerSecurity().equals(handsetManagerSecurity)) {
					// 管理用状态是否可用
					if (handsetManager.getHandsetManagerActiveMark().equals("enable")) {
						if (handsetManager.getHandsetId() == null || handsetManager.getHandsetId().equals("")) {
							handsetManagerDao.upHandsetId(handsetId, handsetManagerPhone);
							json = ResultObject.obj2JsonResult("1", "登陆成功", handsetManager);
							loginHisteryService.creatHistory(handsetManager.getHandsetManagerId(), "2");
						} else {
							// 手持设备验证
							if (handsetManager.getHandsetId().equals(handsetId)) {

								json = ResultObject.obj2JsonResult("1", "登陆成功", handsetManager);
								loginHisteryService.creatHistory(handsetManager.getHandsetManagerId(), "2");
							} else {
								json = ResultResponse.obj2JsonResult("0", "手持设备id不匹配，请联系客服 ", "");
							}
						}

					} else {
						json = ResultObject.obj2JsonResult("0", "管理处于停用状态", "");
					}

				} else {
					json = ResultResponse.obj2JsonResult("0", "安全令牌不匹配", "");
					// 更新用户安全令牌
					String securityCoreId = ToolsIdGenerator.getUUID();
					String securityCoreAccountSecurity = ToolsIdGenerator.getUUID();
					String securityCoreState = "enable";
					String securityCoreCreateTime = TimeTools.getCurrentTime();
					securityCoreService.createSecurity(securityCoreId, "003", handsetId, securityCoreAccountSecurity,
							securityCoreState, securityCoreCreateTime);

					int s = handsetManagerDao.uphandsetManagerSecurity(handsetManagerPhone,
							securityCoreAccountSecurity);
					if (s > 0) {
						json = ResultResponse.obj2JsonResult("1", "更新用户安全令牌成功", "");
						loginHisteryService.creatHistory(handsetManager.getHandsetManagerId(), "2");
					} else {
						json = ResultResponse.obj2JsonResult("0", "更新用户安全令牌失败", "");
					}
				}
			}

		} else {
			json = ResultResponse.obj2JsonResult("0", "暂无管理员信息 ，请注册", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 通过停车场ID查询全部停车场账户（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#selectHandsetManagerByParkId(java.lang.String)
	 */
	@Override
	public String selectHandsetManagerByParkId(String parkingInfoId) {
		String json = "";
		List<HandsetManager> handsetManager = handsetManagerDao.selectHandsetManagerByParkId(parkingInfoId);
		if (handsetManager.size() != 0 & handsetManager != null) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", handsetManager);
		} else {
			json = ResultObject.obj2JsonResult("0", "暂无数据", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 手持id查询手持用户信息（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#selectHandsetManagerByManagerId(java.lang.String)
	 */
	@Override
	public String selectHandsetManagerByManagerId(String handsetManagerId) {
		String json = "";
		HandsetManager handsetManager = handsetManagerDao.selectHandsetManagerByHandManagerId(handsetManagerId);
		if (handsetManager != null) {
			json = ResultObject.obj2JsonResult("1", "查询成功", handsetManager);
		} else {
			json = ResultObject.obj2JsonResult("0", "暂无数据", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 修改手机号（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#upHandsetManagerPhone(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String upHandsetManagerPhone(String handsetManagerId, String handsetManagerPhone) {
		String json = "";
		int i = handsetManagerDao.upHandsetManagerPhone(handsetManagerId, handsetManagerPhone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新手机号成功:" + handsetManagerPhone + "", "");
		} else {

			json = ResultResponse.obj2JsonResult("0", "更新手机号失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 通过电话号码更新手持账户状态（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#upActiveMark(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String upActiveMark(String handsetManagerPhone, String handsetManagerActiveMark) {

		String json = "";
		int i = handsetManagerDao.upActiveMark(handsetManagerActiveMark, handsetManagerPhone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新状态成功:" + handsetManagerActiveMark + "", "");
		} else {

			json = ResultResponse.obj2JsonResult("0", "更新状态失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 通过手持机用户ID删除账户内容（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#deleteHandsetManagerByManagerId(java.lang.String)
	 */
	@Override
	public String deleteHandsetManagerByManagerId(String handsetManagerId) {

		String json = "";
		int i = handsetManagerDao.deleteHandsetManagerByManagerId(handsetManagerId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "删除成功：" + handsetManagerId + "", "");
		} else {

			json = ResultResponse.obj2JsonResult("0", "删除失败", "");
		}
		System.out.println(json);
		return json;
	}

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
	@Override
	public String addHandsetRegistrAtionId(String handsetRegistrAtionId, String handsetManagerPhone) {
		String json = "";
		int i = handsetManagerDao.addHandsetRegistrAtionId(handsetRegistrAtionId, handsetManagerPhone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "手持设备推送id新增成功：" + handsetRegistrAtionId + "", "");
			HandsetManager handsetManager = handsetManagerDao
					.selectHandsetManagerByHandManagerPhone(handsetManagerPhone);
			loginHisteryService.creatHistory(handsetManager.getHandsetManagerId(), "2");
		} else {
			json = ResultResponse.obj2JsonResult("0", "手持设备推送id新增失败：" + handsetRegistrAtionId + "", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO id查询手持订单（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#getHandesetOrder(java.lang.String)
	 */
	@Override
	public String getHandesetOrder(String managerId) {
		String json = "";
		String startTime = TimeTools.getTimesnight();
		String endTime = TimeTools.getCurrentTime();
		System.out.println(startTime);
		System.out.println(endTime);
		HandsetOrder handesetOrder = handsetManagerDao.getHandesetOrder(managerId, startTime, endTime);
		if (handesetOrder != null) {
			handesetOrder.setEndTime(endTime);
			json = ResultObject.obj2JsonResult("1", "手持用户订单统计成功", handesetOrder);
		} else {
			json = ResultResponse.obj2JsonResult("0", "当前时段暂无订单", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 生成手持订单（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#insertHandesetOrder()
	 */
	@Override
	public String insertHandesetOrder() {
		String json = "";
		int i = 0;
		String startTime = TimeTools.getTimesnight();
		String endTime = TimeTools.getTimeslast();
		List<HandsetManager> list = handsetManagerDao.selectHandsetManager();
		for (HandsetManager handsetManager : list) {
			if (handsetManager != null) {

				String orderId = ToolsIdGenerator.getUUID();
				HandsetOrder ho = handsetManagerDao.getHandesetOrder(handsetManager.getHandsetManagerId(), startTime,
						endTime);
				if (ho.getSumCost() != null) {
					List<HandsetOrder> handset = qho.getHandSetOrder("", "", ho.getManagerId(), "", startTime, endTime);
					if (handset.size() <= 0) {
						i = handsetManagerDao.insertHandesetOrder(ho.getManagerId(), ho.getPhone(), ho.getManagerName(),
								ho.getSumCost(), ho.getOrderNomber(), endTime, startTime, ho.getParkingInfoId(),
								orderId);
						System.out.println("新增成功：" + ho.getPhone());
					}

				} else {
					System.out.println("没有符合订单");
				}

			}
		}
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String queryHandesetOrderByManagerId(String managerId) {
		String json = "";
		List<HandsetOrder> list = handsetManagerDao.queryHandesetOrderByManagerId(managerId);
		if (list != null) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功：" + managerId + "", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String upHandsetUser(String handsetManagerPhone, String handsetManagerName) {
		String json = "";
		int i = handsetManagerDao.upHandsetUser(handsetManagerPhone, handsetManagerName);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新手机号成功:" + handsetManagerName + "", "");
		} else {

			json = ResultResponse.obj2JsonResult("0", "更新手机号失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String selectHandsetManagerByName(String handsetManagerName) {
		String json = "";
		List<HandsetManager> handsetManager = handsetManagerDao.selectHandsetManagerByName(handsetManagerName);
		if (handsetManager.size() != 0 & handsetManager != null) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", handsetManager);
		} else {
			json = ResultObject.obj2JsonResult("0", "暂无数据", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String selectHandsetManager(String key, String value, String managerId, String startTime, String endTime) {
		String json = "";
		if (key.equals("phone")) {
			List<HandsetOrder> handsetManager = handsetManagerDao.queryHandesetOrderByPhone(value, managerId, startTime,
					endTime);
			json = ResultObjectList.obj2JsonResult("1", "查询成功:" + key + "", handsetManager);
		} else if (key.equals("name")) {
			List<HandsetOrder> handsetManager = handsetManagerDao.queryHandesetOrderByName(value, managerId, startTime,
					endTime);
			json = ResultObjectList.obj2JsonResult("1", "查询成功:" + key + "", handsetManager);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String upHandsetId(String handsetId, String handsetManagerPhone) {
		String json = "";
		int i = handsetManagerDao.upHandsetId(handsetId, handsetManagerPhone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新成功：" + handsetId + "", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新失败：" + handsetId + "", "");
		}
		return json;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.handsetSys.HandsetSysService#getHandSet()
	 */
	@Override
	public String getHandSet(String handsetId, String handsetManagerId, String handsetManagerPhone,
			String parkingInfoId, String handsetManagerActiveMark, String handsetManagerName, String startTime,
			String endTime) {
		String json = "";
		String handName = "";
		String Phone = "";
		if (handsetManagerName != null & handsetManagerName != "") {
			handName = "%" + handsetManagerName + "%";
		}
		if (handsetManagerPhone != null & handsetManagerPhone != "") {
			Phone = "%" + handsetManagerPhone + "%";
		}
		List<HandsetManager> list = qh.getHandSet(handsetId, handsetManagerId, Phone, parkingInfoId,
				handsetManagerActiveMark, handName, startTime, endTime);
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String getHandSetOrder(String parkingInfoId, String phone, String managerId, String managerName,
			String startTime, String endTime) {
		String json = "";
		String name = "";
		if (managerName != null & managerName != "") {
			name = "%" + managerName + "%";
		}

		List<HandsetOrder> list = qho.getHandSetOrder(parkingInfoId, phone, managerId, name, startTime, endTime);
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		return json;
	}

	@Override
	public String getHandSetLimit(String handsetId, String handsetManagerId, String handsetManagerPhone,
			String parkingInfoId, String handsetManagerActiveMark, String handsetManagerName, String startTime,
			String endTime, int pageNumber, int pageSize) {

		String json = "";
		String handName = "";
		String Phone = "";
		if (handsetManagerName != null & handsetManagerName != "") {
			handName = "%" + handsetManagerName + "%";
		}
		if (handsetManagerPhone != null & handsetManagerPhone != "") {
			Phone = "%" + handsetManagerPhone + "%";
		}
		PageHelper.startPage(pageNumber, pageSize);
		List<HandsetManager> list = qh.getHandSet(handsetId, handsetManagerId, Phone, parkingInfoId,
				handsetManagerActiveMark, handName, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);

		return json;

	}

	@Override
	public String getHandSetOrderLimit(String parkingInfoId, String phone, String managerId, String managerName,
			String startTime, String endTime, int pageNumber, int pageSize) {
		String json = "";
		String name = "";
		if (managerName != null & managerName != "") {
			name = "%" + managerName + "%";
		}
		PageHelper.startPage(pageNumber, pageSize);
		List<HandsetOrder> list = qho.getHandSetOrder(parkingInfoId, phone, managerId, name, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		return json;
	}
}
