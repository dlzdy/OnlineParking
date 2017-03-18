/**
 * Project Name:OnlineParking
 * File Name:ParkingOrderServiceImpl.java
 * Package Name:ParkingOrderService
 * Date:2015年10月6日上午1:45:50
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.order.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.client.ClientUserDao;
import com.yinzitech.onlineparking.dao.client.QueryClientUserDao;
import com.yinzitech.onlineparking.dao.client.carManage.ClinetUserCarManageDao;
import com.yinzitech.onlineparking.dao.fundAccountManage.FundAccountManageDao;
import com.yinzitech.onlineparking.dao.handsetSys.HandsetManagerDao;
import com.yinzitech.onlineparking.dao.order.OrderMapperDao;
import com.yinzitech.onlineparking.dao.order.ParkingOrderDao;
import com.yinzitech.onlineparking.dao.order.TradingOrdersDao;
import com.yinzitech.onlineparking.dao.parkingInfo.ChargingStandardsDao;
import com.yinzitech.onlineparking.dao.parkingInfo.ParkingInfoDao;
import com.yinzitech.onlineparking.entity.client.carManage.ClinetUserCarManage;
import com.yinzitech.onlineparking.entity.client.user.ClientUser;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.fundAccountManage.FundAccountManage;
import com.yinzitech.onlineparking.entity.handsetSys.HandsetManager;
import com.yinzitech.onlineparking.entity.order.ParkingOrder;
import com.yinzitech.onlineparking.entity.parkingInfo.ChargingStandards;
import com.yinzitech.onlineparking.entity.parkingInfo.ParkingInfo;
import com.yinzitech.onlineparking.service.fundAccountManage.SubFundAccountSeqService;
import com.yinzitech.onlineparking.service.order.ParkingOrderService;
import com.yinzitech.onlineparking.service.order.TradingOrdersService;
import com.yinzitech.onlineparking.utils.CountPice;
import com.yinzitech.onlineparking.utils.DoubleUtils;
import com.yinzitech.onlineparking.utils.HttpPostUtils;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.SendMassage;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.pojo.CalfeeData;
import com.yinzitech.onlineparking.utils.pojo.CalfeeRoot;

import net.sf.json.JSONObject;

import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:ParkingOrderServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月6日 上午1:45:50 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ParkingOrderServiceImpl implements ParkingOrderService {
	@Autowired
	ParkingOrderDao parkingOrderDao;
	@Autowired
	ClinetUserCarManageDao clinetUserCarManageDao;
	@Autowired
	HandsetManagerDao handsetManagerDao;
	@Autowired
	ChargingStandardsDao chargingStandardsDao;
	@Autowired
	FundAccountManageDao fundAccountManageDao;
	@Autowired
	TradingOrdersService tradingOrdersService;
	@Autowired
	ClientUserDao clientUserDao;
	@Autowired
	TradingOrdersDao tradingOrdersDao;
	@Autowired
	SubFundAccountSeqService subFundAccountSeqService;
	@Autowired
	ParkingInfoDao parkingInfoDao;
	@Autowired
	OrderMapperDao orderMapperDao;
	@Autowired
	QueryClientUserDao qc;

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @param parkingOrderId
	 *            停车订单主键Id
	 * 
	 * @param parkingOrderCarNo
	 *            停车订单中停车场端发现的车牌号
	 * @param parkingOrderCarManageId
	 *            'parking_order_car_manage_id 通过 parking_order_car_no 逻辑查找到的
	 *            终端用户部分clinet_user_car_manage
	 *            终端用户车辆管理表(实体类ClientUserCarManager) 对应数据库 parking_order 对应实体类
	 *            ParkingOrder 对应属性 parkingOrderCarManageId 数据库字段类型 varchar
	 *            实体类字段类型 String 长度100 对应 逻辑中找出'
	 * @param parkingOrderClientUserId
	 *            'parking_order_client_user_id 通过 parking_order_car_manage_id
	 *            逻辑查找到的 终端用户部分clinet_user 终端用户车辆管理表(实体类ClientUser) 对应数据库
	 *            parking_order 对应实体类 ParkingOrder 对应属性 parkingOrderClientUserId
	 *            数据库字段类型 varchar 实体类字段类型 String 长度100 对应 逻辑中找出',
	 * @param parkingOrderCarEnterTime
	 *            车辆进入停车场时间
	 * @param parkingOrderHandSetId
	 *            停车订单中车辆被识别时使用的手持机id
	 * @param parkingOrderHandsetManagerId
	 *            扫描车牌的手持机的管理员id
	 * @param parkingOrderParkingInfoId
	 *            管理员所属的停车场id
	 * @param parkingOrderCarNumberState
	 *            否是Online停车平台在管车辆
	 * @param parkingOrderCreateTime
	 *            停车订单创建时间
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#creatParkingOrder(java.lang.String,
	 *      java.lang.String)
	 */

	@Override
	public String creatParkingOrder(String parkingOrderCarNo, String parkingOrderHandSetId, String parkingInfoId,
			String handsetManagerId) {
		System.out.println("创建订单 ------------------------------------------------------");
		String json = "";
		String parkingOrderId = ToolsIdGenerator.getOrderId();
		String parkingOrderCarManageId = "";
		String parkingOrderClientUserId = "";
		String parkingOrderCarEnterTime = TimeTools.getCurrentTime();
		String parkingOrderCarNumberState = "0";
		String parkingOrderPayCash = "1";
		String parkingOrderCreateTime = TimeTools.getCurrentTime();
		String parkingOrderType = "0";
		ClientUser clientUser = null;
		// 通过车牌号获取用户车辆信息
		ClinetUserCarManage clinetUserCarManage = clinetUserCarManageDao
				.selectUserCarByclientUserCarNo(parkingOrderCarNo);
		if (clinetUserCarManage != null) {
			parkingOrderCarManageId = clinetUserCarManage.getCarManageId();
			parkingOrderClientUserId = clinetUserCarManage.getClientUserId();
			parkingOrderCarNumberState = "1";

			FundAccountManage fm = fundAccountManageDao.selectByCustId(parkingOrderClientUserId);
			clientUser = clientUserDao.selectClientUserById(parkingOrderClientUserId);

			if (fm.getFundAccountManageState().equals("00")
					&& clinetUserCarManage.getClientUserCarActiveMark().equals("enable")
					&& clientUser.getClientUserAutoPay().equals("0")) {

				parkingOrderPayCash = "0";

			}
		}

		int i = parkingOrderDao.creatParkingOrder(parkingOrderId, parkingOrderCarNo, parkingOrderCarManageId,
				parkingOrderClientUserId, parkingOrderCarEnterTime, parkingOrderHandSetId, handsetManagerId,
				parkingInfoId, parkingOrderCarNumberState, parkingOrderCreateTime, parkingOrderPayCash,
				parkingOrderType);

		if (i > 0) {
			// 获得停车场名字
			ParkingOrder parkingOrder = orderMapperDao.getParkingOrderById(parkingOrderId);
			parkingOrder.setParkingName(parkingInfoDao.getParkingInfoById(parkingInfoId).getParkingInfoName());
			json = ResultObject.obj2JsonResult("1", "订单创建成功", parkingOrder);

			String spaces = parkingInfoDao.getParkingInfoById(parkingInfoId).getParkingInfoRestParkingSpaces();
			int sp = Integer.valueOf(spaces) - 1;
			System.out.println("车位信息剩余：" + sp);
			parkingInfoDao.updateParkingSpaces(parkingInfoId, String.valueOf(sp));
			// 获取手持机使用者电话号
			HandsetManager handsetManager = handsetManagerDao.selectHandsetManagerByHandManagerId(handsetManagerId);
			String handAtionID = handsetManager.getHandsetRegistrAtionId();

			if (parkingOrderClientUserId.equals("")) {
				System.out.println(parkingOrderClientUserId);
				System.out.println(parkingOrder.getParkingOrderPayCash());
			} else {

				String userAtionId = clientUser.getClientUserRegistrAtionId();
				System.out.println(userAtionId);
				String userBody = ResultObject.obj2JsonResult("1", "车辆入场成功", parkingOrder);
				System.out.println(userBody);
				String type = clientUser.getClientUserType();
				// 向用户推送信息
				if (userAtionId.length() > 0) {
					if (type.equals("1")) {
						System.out.println("type:" + type + "userAtionId:" + userAtionId);
						SendMassage.sendUser("订单创建成功", userBody, userAtionId);
					} else {
						System.out.println("type:" + type + "userAtionId:" + userAtionId);
						SendMassage.sendUser("订单创建成功", userBody, userAtionId);
						SendMassage.sendUserPush("车辆入场成功", userBody, userAtionId);
					}

				}

			}

			String handBody = ResultResponse.obj2JsonResult("1", "订单创建成功", "订单创建成功");
			// 向手持机用户推送给信息
			SendMassage.sendHandSet("订单创建成功", handBody, handAtionID);
		} else {
			json = ResultResponse.obj2JsonResult("0", "订单创建失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 停车场车辆出库信息修改（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#updateParkingOrder(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String)
	 * 
	 * @param parkingOrderId
	 *            停车场订单Id
	 */
	@Override
	public String updateParkingOrder(String parkingOrderPayState, String parkingOrderId) {
		System.out.println("更新出库信息-------------------------------------------------------");
		String json = "";

		// 通过停车场订单ID查询 查询订单信息
		ParkingOrder parkingOrder = orderMapperDao.getParkingOrderById(parkingOrderId);
		if (parkingOrder != null) {
			if (parkingOrder.getParkingOrderClientUserId() == null
					| parkingOrder.getParkingOrderClientUserId().equals("")) {
				json = registUserIsNull(parkingOrder);
			} else {
				System.out.println("-----已注册用户订单更新------");
				// 计算车辆进出时间
				String parkingOrderCarExitTime = TimeTools.getCurrentTime();
				long time = TimeTools.mathTime(parkingOrderCarExitTime, parkingOrder.getParkingOrderCarEnterTime());
				if (time > 0) {
					String parkingOrderCarStayTime = TimeTools.getTime(time);
					String parkingOrderParkingState = "quiet";
					// 停车场id
					String parkingInfoId = parkingOrder.getParkingOrderParkingInfoId();
					List<ChargingStandards> list = chargingStandardsDao
							.getChargingStandardsListByParkingInfoId(parkingInfoId);
					// 获取计费价格
					double cost = CountPice.getPice(list, time);
					String parkingOrderCost = String.valueOf(cost);

					int i = parkingOrderDao.updateParkingOrder(parkingOrderCarExitTime, parkingOrderCarStayTime,
							parkingOrderParkingState, parkingOrderCost, parkingOrderId);
					if (i > 0) {
						// 获取手持机使用者电话号
						HandsetManager handsetManager = handsetManagerDao
								.selectHandsetManagerByHandManagerId(parkingOrder.getParkingOrderHandsetManagerId());

						String handAtionId = handsetManager.getHandsetRegistrAtionId();
						// 获取用户手机号
						ClientUser clientUser = clientUserDao
								.selectClientUserById(parkingOrder.getParkingOrderClientUserId());
						String userAtionId = clientUser.getClientUserRegistrAtionId();
						// ***************
						ParkingOrder park = orderMapperDao.getParkingOrderById(parkingOrderId);
						ParkingInfo parkingInfo = parkingInfoDao.getParkingInfoById(parkingInfoId);
						park.setParkingName(parkingInfo.getParkingInfoName());

						String userBody = ResultObject.obj2JsonResult("2", "支付金额：" + cost + "", park);
						String handBody = ResultObject.obj2JsonResult("2", "待收金额：" + cost + "", park);
						String type = clientUser.getClientUserType();

						String spaces = parkingInfoDao.getParkingInfoById(parkingInfoId)
								.getParkingInfoRestParkingSpaces();
						int sp = Integer.valueOf(spaces) + 1;
						System.out.println("车位信息剩余：" + sp);
						parkingInfoDao.updateParkingSpaces(parkingInfoId, String.valueOf(sp));
						if (clientUser.getClientUserAutoPay().equals("1")) {
							// 余额查询
							FundAccountManage fm = fundAccountManageDao
									.selectByCustId(parkingOrder.getParkingOrderClientUserId());
							if (Double.valueOf(fm.getFundAccountManageAmount()) > cost) {
								// if
								// (park.getParkingOrderPayCash().equals("0")) {

								if (userAtionId.length() > 0) {
									if (type.equals("1")) {
										SendMassage.sendUser("车辆出场成功", userBody, userAtionId);
									} else {
										SendMassage.sendUser("车辆出场成功", userBody, userAtionId);
										SendMassage.sendUserPush("车辆出场成功", userBody, userAtionId);
									}

								}
								// }
								SendMassage.sendHandSet("订单已完成", handBody, handAtionId);

								json = updateparkingOrderPayState(parkingOrderPayState, parkingOrderId);
							} else {
								// 推送 5： 余额不足
								String user_Body = ResultObject.obj2JsonResult("5", fm.getFundAccountManageAmount(),
										park);

								if (clientUser.getClientUserType().equals("1")) {
									SendMassage.sendUser("账户余额不足", user_Body, clientUser.getClientUserRegistrAtionId());
								} else {
									SendMassage.sendUser("账户余额不足", user_Body, clientUser.getClientUserRegistrAtionId());
									SendMassage.sendUserPush("账户余额不足", user_Body,
											clientUser.getClientUserRegistrAtionId());

								}
								json = ResultObject.obj2JsonResult("1", "订单更新成功：请确认支付", park);

							}

						} else {
							// if (park.getParkingOrderPayCash().equals("0")) {

							if (userAtionId.length() > 0) {
								if (type.equals("1")) {
									SendMassage.sendUser("车辆出场成功", userBody, userAtionId);
								} else {
									SendMassage.sendUser("车辆出场成功", userBody, userAtionId);
									SendMassage.sendUserPush("车辆出场成功", userBody, userAtionId);
								}

							}
							// }
							json = ResultObject.obj2JsonResult("1", "订单更新成功：请确认支付", park);
						}
					} else {
						json = ResultResponse.obj2JsonResult("0", "订单更新失败", "");
					}
				}

			}
		} else {
			json = ResultResponse.obj2JsonResult("0", "订单不存在", "");

		}
		System.out.println(json);
		return json;
	}

	public String registUserIsNull(ParkingOrder parkingOrder) {
		System.out.println("非注册用户----------------------------------------------------");
		String parkingOrderType = parkingOrder.parkingOrderType;
		String json = "";
		String parkingOrderCarExitTime = TimeTools.getCurrentTime();
		double cost = 0;
		long time = TimeTools.mathTime(parkingOrderCarExitTime, parkingOrder.getParkingOrderCarEnterTime());
		if (time > 0) {
			String parkingOrderCarStayTime = TimeTools.getTime(time);
			String parkingOrderParkingState = "quiet";
			// 停车场id
			String parkingInfoId = parkingOrder.getParkingOrderParkingInfoId();
			List<ChargingStandards> list = chargingStandardsDao.getChargingStandardsListByParkingInfoId(parkingInfoId);
			// 获取计费价格
			if (parkingOrderType.equals("0")) {

				cost = CountPice.getPice(list, time);
			} else {
				cost = calfee(parkingOrder.getParkingOrderCarNo(), parkingInfoId).getShould();

			}
			String parkingOrderCost = String.valueOf(cost);

			int i = parkingOrderDao.updateParkingOrder(parkingOrderCarExitTime, parkingOrderCarStayTime,
					parkingOrderParkingState, parkingOrderCost, parkingOrder.getParkingOrderId());
			// 更新支付方式 1为现金
			parkingOrderDao.updateparkingOrderPayCash("1", parkingOrder.getParkingOrderId());
			if (i > 0) {
				ParkingOrder po = orderMapperDao.getParkingOrderById(parkingOrder.getParkingOrderId());
				String handBody = ResultObject.obj2JsonResult("2", "待收金额：" + cost + "", po);
				// 获取手持机使用者电话号
				if (parkingOrderType.equals("0")) {
					HandsetManager handsetManager = handsetManagerDao
							.selectHandsetManagerByHandManagerId(po.getParkingOrderHandsetManagerId());
					String handAtionId = handsetManager.getHandsetRegistrAtionId();

					SendMassage.sendHandSet("订单已完成", handBody, handAtionId);
				}
				String spaces = parkingInfoDao.getParkingInfoById(parkingInfoId).getParkingInfoRestParkingSpaces();
				int sp = Integer.valueOf(spaces) + 1;
				System.out.println("车位信息剩余：" + sp);
				parkingInfoDao.updateParkingSpaces(parkingInfoId, String.valueOf(sp));
				json = ResultObject.obj2JsonResult("1", "未注册停车场用户出场成功", po);
				if (parkingOrderType.equals("1")) {
					parkingOrderDao.updateparkingOrderPayState("Paid", parkingOrder.getParkingOrderId());
				}
				return json;
			} else {
				json = ResultResponse.obj2JsonResult("0", "未注册用户出场 失败 失败 失败 ", "");
				return json;
			}
		}
		return json;
	}

	/**
	 * 
	 * state:(创建支付账单向用户推送). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderPayState
	 * @param parkingOrderId
	 * @param parkingOrder
	 * @param parkingInfoId
	 * @param cost
	 * @return
	 * @since JDK 1.8u60
	 */
	private String state(String parkingOrderPayState, String parkingOrderId, ParkingOrder parkingOrder,
			String parkingInfoId, String cost) {
		System.out.println("支付账单--------------------------------------------------");

		String json = "";
		String handPhone = "";
		String uesrPhone = "";
		String handBody = "";
		String userBody = "";
		String OrderType = parkingOrder.getParkingOrderType();
		HandsetManager handsetManager = null;
		if (OrderType.equals("0")) {

			// 获取手持机使用者电话号
			handsetManager = handsetManagerDao
					.selectHandsetManagerByHandManagerId(parkingOrder.parkingOrderHandsetManagerId);

			handPhone = handsetManager.getHandsetManagerPhone();
		}
		// 获取用户手机号
		ClientUser clientUser = clientUserDao.selectClientUserById(parkingOrder.getParkingOrderClientUserId());
		uesrPhone = clientUser.getClientUserCellphone();
		// 判断支付状态
		if (parkingOrderPayState.equals("Paid")) {

			// tradingOrderState 默认 10 订单未完成 00 等待支付 01 订单已完成'
			// tradingOrderBalanceState 默认 00 付款方与收款方均未登记账户变动
			// 01付款方已经完成登记账户变动,收款方未完成登记账户变动 02 付款方未完成登记账户变动,收款方已完成登记账户变动 03
			// 付款方与收款方均完成登记账户变动'

			tradingOrdersService.insertTradingOrder(parkingOrderId, "00", "00", "01");
			tradingOrdersDao.upTradingOrderTranAmount(cost, parkingOrderId);
			tradingOrdersService.upTradingOrderpayState("01", parkingOrderId);
			// 获得停车场名字

			ParkingOrder parking = orderMapperDao.getParkingOrderById(parkingOrderId);
			parkingOrder.setParkingName(parkingInfoDao.getParkingInfoById(parkingInfoId).getParkingInfoName());

			json = ResultObject.obj2JsonResult("1", "支付成功", parking);

			addbill(parkingOrder.getParkingOrderCarNo(), parkingInfoId, parkingOrderId);
			// 用户ID
			String srcUserId = parkingOrder.getParkingOrderClientUserId();
			// 用户custId的金额
			String srcCustAmount = fundAccountManageDao.selectByCustId(srcUserId).getFundAccountManageAmount();
			// 手持机custId的金额
			String payeeCustAmount = fundAccountManageDao.selectByCustId(parkingInfoId).getFundAccountManageAmount();
			System.out.println(srcUserId);
			System.out.println(parkingInfoId);
			double upSrcCust = DoubleUtils.minus(Double.valueOf(srcCustAmount), Double.valueOf(cost));
			double upPayeeCust = DoubleUtils.add(Double.valueOf(payeeCustAmount), Double.valueOf(cost));
			System.out.println("消费金额-----------------------------：" + cost);
			// start 更新资金账户金额
			int upSrcCustState = fundAccountManageDao.upFundAccountManageAmount(srcUserId, String.valueOf(upSrcCust));
			int upPayeeCustState = fundAccountManageDao.upFundAccountManageAmount(parkingInfoId,
					String.valueOf(upPayeeCust));

			String srcCustAmountId = fundAccountManageDao.selectByCustId(srcUserId).getFundAccountId();

			String parkAccountId = fundAccountManageDao.selectByCustId(parkingInfoId).getFundAccountId();

			// tradingOrderState 默认 10 订单未完成 00 等待支付 01 订单已完成'
			/*
			 * subFundAccountSeqChangeType 资金管理账户资金变动流水中账户变动类型 交易支付 03 提现 04
			 * 内部调账 05 结息 06 利息税 07 原交易退款 08 原交易撤销
			 */
			/*
			 * subFundAccountSeqRefsnOrderType 资金管理账户资金变动流水关联的订单类型 001 关联支付订单
			 * 002 关联交易订单 003 关联提现订单
			 */
			// subFundAccountSeqFlag 0为有账 1为收款
			// 用户流水
			// 创建用户流水
			subFundAccountSeqService.creatSubFundAccountSeq(srcCustAmountId, srcUserId, uesrPhone, "1", "03",
					String.valueOf(upSrcCust), cost, "001", parkingOrderId);
			// 创建停车场流水
			subFundAccountSeqService.creatSubFundAccountSeq(parkAccountId, parkingInfoId, handPhone, "0", "03",
					String.valueOf(upPayeeCust), cost, "001", parkingOrderId);
			if (upSrcCustState > 0 && upPayeeCustState > 0) {
				tradingOrdersService.upTradingOrderBalanceState("03", parkingOrderId);
				tradingOrdersService.upTradingOrderState("01", parkingOrderId);

				// handBody = ResultResponse.obj2JsonResult("3", "订单已完成",
				// "收款完成,本次收费:" + cost + ",账户余额：" + upPayeeCust + "");

				ParkingOrder park = orderMapperDao.getParkingOrderById(parkingOrderId);
				park.setParkingName(parkingInfoDao.getParkingInfoById(parkingInfoId).getParkingInfoName());
				handBody = ResultObject.obj2JsonResult("3", "订单已完成", park);
				userBody = ResultObject.obj2JsonResult("3", "支付完成,账户余额：" + upSrcCust + "", park);
				System.out.println(handBody);
				System.out.println(userBody);
				// 向手持机用户推送给信息
				if (OrderType.equals("0")) {
					SendMassage.sendHandSet("订单已完成", handBody, handsetManager.getHandsetRegistrAtionId());
				}
				String userAtionId = clientUser.getClientUserRegistrAtionId();
				String type = clientUser.getClientUserType();
				// if (park.getParkingOrderPayCash().equals("0")) {

				if (userAtionId.length() > 0) {
					if (type.equals("1")) {
						SendMassage.sendUser("支付成功", userBody, userAtionId);
					} else {
						SendMassage.sendUser("支付成功", userBody, userAtionId);
						SendMassage.sendUserPush("支付成功", userBody, userAtionId);
					}

				}

				// }

			} else if (upSrcCustState > 0 && upPayeeCustState < 0) {
				tradingOrdersService.upTradingOrderBalanceState("01", parkingOrderId);
			} else if (upSrcCustState < 0 && upPayeeCustState > 0) {
				tradingOrdersService.upTradingOrderBalanceState("02", parkingOrderId);
			} else {
				tradingOrdersService.upTradingOrderBalanceState("00", parkingOrderId);
			}
		}
		return json;
	}

	/**
	 * TODO 更新用户支付状态（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#updateparkingOrderPayState(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updateparkingOrderPayState(String parkingOrderPayState, String parkingOrderId) {
		String json = "";
		int i = parkingOrderDao.updateparkingOrderPayState(parkingOrderPayState, parkingOrderId); // TODO
		if (i > 0) {
			ParkingOrder parkingOrder = orderMapperDao.getParkingOrderById(parkingOrderId);
			String parkingInfoId = parkingOrder.getParkingOrderParkingInfoId();

			String cost = parkingOrder.getParkingOrderCost();
			state(parkingOrderPayState, parkingOrderId, parkingOrder, parkingInfoId, cost);
			json = ResultResponse.obj2JsonResult("1", "支付状态更新成功", parkingOrderPayState);
		} else {
			json = ResultResponse.obj2JsonResult("0", "支付状态更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 更新用户支付状态（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#updateparkingOrderPayState(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updateOrderPayState(String parkingOrderPayState, String parkingOrderId) {
		String json = "";
		int i = parkingOrderDao.updateparkingOrderPayState(parkingOrderPayState, parkingOrderId); // TODO
		if (i > 0) {
			ParkingOrder list = orderMapperDao.getParkingOrderById(parkingOrderId);
			json = ResultObject.obj2JsonResult("1", "支付状态更新成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "支付状态更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 查询全部订单信息（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#selectParkingOrderAll()
	 */
	@Override
	public String selectParkingOrderAll() {
		System.out.println("查询全部订单消息----------------------------------------------------------");
		String json = "";
		List<ParkingOrder> list = orderMapperDao.getParkingOrder();
		if (list != null) {
			for (ParkingOrder parkingOrder : list) {
				parkingOrder.setParkingName(parkingInfoDao
						.getParkingInfoById(parkingOrder.getParkingOrderParkingInfoId()).getParkingInfoName());
			}

			// 获得停车场名字

			json = ResultObject.obj2JsonResult("1", "查询全部订单信息成功", list);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询全部订单信息失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 通过用户ID查询全部订单（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#selectParkingOrderByUserId(java.lang.String)
	 */
	@Override
	public String selectParkingOrderByUserId(String parkingOrderClientUserId, String parkingOrderPayState,
			String startTime, String endTime, String clientUserSecurity) {
		String json = "";
		ClientUser user = clientUserDao.selectById(parkingOrderClientUserId, clientUserSecurity);
		if (user != null) {
			List<ParkingOrder> list = orderMapperDao.getParkingOrderByUserId(parkingOrderClientUserId,
					parkingOrderPayState, startTime, endTime);

			if (list != null) {
				for (ParkingOrder parkingOrder : list) {
					String parkingId = parkingOrder.getParkingOrderParkingInfoId();
					parkingOrder.setParkingName(parkingInfoDao
							.getParkingInfoById(parkingOrder.getParkingOrderParkingInfoId()).getParkingInfoName());

					parkingOrder.setChargingSandards(
							chargingStandardsDao.getChargingStandardsListByParkingInfoId(parkingId));
				}
				json = ResultObjectList.obj2JsonResult("1", "查询全部订单信息成功", list);
			} else {
				json = ResultObject.obj2JsonResult("0", "查询全部订单信息失败", "");
			}
		} else {
			json = ResultObject.obj2JsonResult("2", "安全令牌不匹配", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 查看停车场全部订单（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#selectParkingOrderParkId(java.lang.String)
	 */
	@Override
	public String selectParkingOrderParkId(String parkingOrderParkingInfoId, String parkingOrderPayState,
			String startTime, String endTime) {
		String json = "";

		List<ParkingOrder> list = orderMapperDao.getParkingOrderByParkingInfoId(parkingOrderParkingInfoId,
				parkingOrderPayState, startTime, endTime);

		if (list != null) {

			for (ParkingOrder parkingOrder : list) {
				parkingOrder.setParkingName(parkingInfoDao
						.getParkingInfoById(parkingOrder.getParkingOrderParkingInfoId()).getParkingInfoName());
			}
			json = ResultObject.obj2JsonResult("1", "查询全部订单信息成功", list);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询全部订单信息失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 查询订单详细信息（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#selectParkingOrderById(java.lang.String)
	 */
	@Override
	public String selectParkingOrderById(String parkingOrderId) {

		String json = "";
		ParkingOrder parkingOrder = orderMapperDao.getParkingOrderById(parkingOrderId);
		if (parkingOrder != null) {
			parkingOrder.setParkingName(parkingInfoDao.getParkingInfoById(parkingOrder.getParkingOrderParkingInfoId())
					.getParkingInfoName());
			json = ResultObject.obj2JsonResult("1", "查询全部订单信息成功", parkingOrder);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询全部订单信息失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 查询用户支付状态（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#selectParkingOrderPayState(java.lang.String)
	 */
	@Override
	public String selectParkingOrderPayState(String parkingOrderClientUserId) {
		String json = "";
		int i = orderMapperDao.querParkingOrderByPayState(parkingOrderClientUserId);
		if (i > 0) {
			json = ResultObject.obj2JsonResult("1", "订单未支付 ", "");
		} else {
			json = ResultObject.obj2JsonResult("0", "订单已经支付", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 查询停车长停车数量（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#parkingOrderParkingState(java.lang.String)
	 */
	@Override
	public String parkingOrderParkingState(String parkingOrderParkingInfoId) {
		String json = "";
		int i = orderMapperDao.getParkingState(parkingOrderParkingInfoId);
		if (i > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", "" + i + "");
		} else {
			json = ResultObject.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 通过订单id删除订单信息（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#deleteParkingOrder(java.lang.String)
	 */
	@Override
	public String deleteParkingOrder(String parkingOrderId) {
		String json = "";
		int i = parkingOrderDao.deleteParkingOrder(parkingOrderId);
		if (i > 0) {
			json = ResultObject.obj2JsonResult("1", "删除订单成功", "");
		} else {
			json = ResultObject.obj2JsonResult("0", "删除订单失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String parkingOrderHandsetManagerId(String parkingOrderHandsetManagerId, String parkingOrderPayState,
			String startTime, String endTime) {
		String json = "";
		List<ParkingOrder> list = orderMapperDao.getParkingOrderByHandsetManagerId(parkingOrderHandsetManagerId,
				parkingOrderPayState, startTime, endTime);
		if (list.size() > 0) {

			for (ParkingOrder parkingOrder : list) {
				parkingOrder.setParkingName(parkingInfoDao
						.getParkingInfoById(parkingOrder.getParkingOrderParkingInfoId()).getParkingInfoName());
			}
			json = ResultObjectList.obj2JsonResult("1", "查询手持机订单成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("1", "查询手持机订单失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 通过车牌号查询停车场订单信息（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#selectByCarNo(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String selectByCarNo(String parkingOrderCarNo, String parkingOrderParkingInfoId) {
		String json = "";
		String carNo = "%" + parkingOrderCarNo + "%";
		String parkingOrderParkingState = "";
		List<ParkingOrder> list = orderMapperDao.getParkingOrderByCarNo(carNo, parkingOrderParkingInfoId,
				parkingOrderParkingState);
		if (list.size() > 0) {

			for (ParkingOrder parkingOrder : list) {
				String parkingName = parkingInfoDao.getParkingInfoById(parkingOrder.getParkingOrderParkingInfoId())
						.getParkingInfoName();
				parkingOrder.setParkingName(parkingName);

			}
			json = ResultObjectList.obj2JsonResult("1", "通过车牌号查询订单成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 通过车牌还查询车辆是否在停（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#selectParkingState(java.lang.String)
	 */
	@Override
	public String selectParkingState(String parkingOrderCarNo) {
		String json = "";
		String carNo = "%" + parkingOrderCarNo + "%";
		String parkingOrderParkingState = "stay";
		String parkingOrderParkingInfoId = "";
		List<ParkingOrder> list = orderMapperDao.getParkingOrderByCarNo(carNo, parkingOrderParkingInfoId,
				parkingOrderParkingState);
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "车辆已在停车场停车", list.get(0));
		} else {
			json = ResultObject.obj2JsonResult("0", "车辆不再停车场可以停车", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String queryParkOrder(String parkingOrderId, String parkingOrderCarNo, String parkingOrderCarManageId,
			String parkingOrderClientUserId, String parkingOrderParkingState, String parkingOrderPayState,
			String parkingOrderHandSetId, String parkingOrderHandsetManagerId, String parkingOrderParkingInfoId,
			String parkingOrderCarNumberState, String startTime, String endTime, String parkingOrderPayCash,
			String parkingOrderType) {
		String json = "";
		String carNo = "";
		System.out.println(parkingOrderCarNo);
		if (parkingOrderCarNo != null & parkingOrderCarNo != "") {
			carNo = "%" + parkingOrderCarNo + "%";
		}
		List<ParkingOrder> list = orderMapperDao.queryParkOrder(parkingOrderId, carNo, parkingOrderCarManageId,
				parkingOrderClientUserId, parkingOrderParkingState, parkingOrderPayState, parkingOrderHandSetId,
				parkingOrderHandsetManagerId, parkingOrderParkingInfoId, parkingOrderCarNumberState, startTime, endTime,
				parkingOrderPayCash, parkingOrderType);
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
		} else {
			json = ResultObjectList.obj2JsonResult("0", "查询失败", list);
		}

		System.out.println(json);
		return json;
	}

	@Override
	public String OrderPayCash(String parkingOrderId, String clientUserSecurity, String clientUserId) {
		String json = "";
		ClientUser cu = clientUserDao.selectById(clientUserId, clientUserSecurity);
		if (cu != null) {
			int i = parkingOrderDao.updateparkingOrderPayCash("1", parkingOrderId);
			if (i > 0) {
				ParkingOrder park = orderMapperDao.getParkingOrderById(parkingOrderId);
				if (park.getParkingOrderType().equals("0")) {

					HandsetManager hm = handsetManagerDao
							.selectHandsetManagerByHandManagerId(park.getParkingOrderHandsetManagerId());

					SendMassage.sendHandSet("现金支付", ResultResponse.obj2JsonResult("4", "1", parkingOrderId),
							hm.getHandsetRegistrAtionId());
				}
				json = ResultResponse.obj2JsonResult("1", "支付方式更新成功", "");
			} else {
				json = ResultResponse.obj2JsonResult("0", "支付方式更新失败", "");
			}
		} else {
			json = ResultResponse.obj2JsonResult("2", "支付方式更新失败：令牌不匹配", "");
		}

		return json;
	}

	@Override
	public String queryParkOrderLimit(String parkingOrderId, String parkingOrderCarNo, String parkingOrderCarManageId,
			String parkingOrderClientUserId, String parkingOrderParkingState, String parkingOrderPayState,
			String parkingOrderHandSetId, String parkingOrderHandsetManagerId, String parkingOrderParkingInfoId,
			String parkingOrderCarNumberState, String startTime, String endTime, String parkingOrderPayCash,
			String parkingOrderType, int pageNumber, int pageSize) {
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		String carNo = "";
		if (parkingOrderCarNo != null & parkingOrderCarNo != "") {
			carNo = "%" + parkingOrderCarNo + "%";
		}
		List<ParkingOrder> list = orderMapperDao.queryParkOrder(parkingOrderId, carNo, parkingOrderCarManageId,
				parkingOrderClientUserId, parkingOrderParkingState, parkingOrderPayState, parkingOrderHandSetId,
				parkingOrderHandsetManagerId, parkingOrderParkingInfoId, parkingOrderCarNumberState, startTime, endTime,
				parkingOrderPayCash, parkingOrderType);

		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			String info;
			if (parkingOrderPayState.equals("Paid")) {
				info = "查询已支付账单成功";
			} else if (parkingOrderPayState.equals("NoPaid")) {
				info = "查询未支付账单成功";
			} else {
				info = "查询全部账单成功";
			}
			json = ResultObject.obj2JsonResult("1", info, s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}

		System.out.println(json);
		return json;
	}

	@Override
	public String enter(String plate, String companyID) {
		System.out.println("创建订单 ------------------------------------------------------");
		if (i <= 5) {
			addCar(plate);
		}
		String json = "";
		String parkingOrderId = ToolsIdGenerator.getOrderId();
		String parkingOrderCarManageId = "";
		String parkingOrderClientUserId = "";
		String parkingOrderCarEnterTime = TimeTools.getCurrentTime();
		String parkingOrderCarNumberState = "0";
		String parkingOrderPayCash = "1";
		String parkingOrderCreateTime = TimeTools.getCurrentTime();
		String parkingOrderType = "1";
		// 通过车牌号获取用户车辆信息
		ClinetUserCarManage clinetUserCarManage = clinetUserCarManageDao.selectUserCarByclientUserCarNo(plate);
		if (clinetUserCarManage != null) {
			parkingOrderCarManageId = clinetUserCarManage.getCarManageId();
			parkingOrderClientUserId = clinetUserCarManage.getClientUserId();
			parkingOrderCarNumberState = "1";

			FundAccountManage fm = fundAccountManageDao.selectByCustId(parkingOrderClientUserId);
			if (fm.getFundAccountManageState().equals("00")) {
				if (clinetUserCarManage.getClientUserCarActiveMark().equals("enable")) {
					parkingOrderPayCash = "0";
				}
			}
		}
		// 无
		String parkingOrderHandSetId = "";
		String handsetManagerId = "";
		int i = parkingOrderDao.creatParkingOrder(parkingOrderId, plate, parkingOrderCarManageId,
				parkingOrderClientUserId, parkingOrderCarEnterTime, parkingOrderHandSetId, handsetManagerId, companyID,
				parkingOrderCarNumberState, parkingOrderCreateTime, parkingOrderPayCash, parkingOrderType);
		if (i > 0) {
			// 获得停车场名字
			ParkingOrder parkingOrder = orderMapperDao.getParkingOrderById(parkingOrderId);
			parkingOrder.setParkingName(parkingInfoDao.getParkingInfoById(companyID).getParkingInfoName());

			String spaces = parkingInfoDao.getParkingInfoById(companyID).getParkingInfoRestParkingSpaces();
			int sp = Integer.valueOf(spaces) - 1;
			System.out.println("车位信息剩余：" + sp);
			parkingInfoDao.updateParkingSpaces(companyID, String.valueOf(sp));

			if (parkingOrderClientUserId.equals("") || parkingOrder.getParkingOrderPayCash().equals("1")) {
				System.out.println("UserId  :" + parkingOrderClientUserId);
				System.out.println("PayCash :" + parkingOrder.getParkingOrderPayCash());
			} else {
				ClientUser clientUser = clientUserDao.selectClientUserById(parkingOrderClientUserId);
				String userAtionId = clientUser.getClientUserRegistrAtionId();
				System.out.println("userAtionId:" + userAtionId);
				String userBody = ResultObject.obj2JsonResult("1", "车辆入场成功", parkingOrder);
				System.out.println("userBody   :" + userBody);
				String type = clientUser.getClientUserType();
				// 向用户推送信息
				if (userAtionId.length() > 0) {
					if (type.equals("1")) {
						System.out.println("type:" + type + "userAtionId:" + userAtionId);
						SendMassage.sendUser("订单创建成功", userBody, userAtionId);
					} else {
						System.out.println("type:" + type + "userAtionId:" + userAtionId);
						SendMassage.sendUser("订单创建成功", userBody, userAtionId);
						SendMassage.sendUserPush("车辆入场成功", userBody, userAtionId);
					}

				}

			}
			json = ResultObject.obj2JsonResult("1", "车辆入场成功", parkingOrder);
		}

		return json;
	}

	@Override
	public String exit(String plate, String companyID) {
		System.out.println("更新出库信息-------------------------------------------------------");
		String json = "";
		List<ParkingOrder> Order = orderMapperDao.queryParkOrder("", plate, "", "", "stay", "", "", "", companyID, "",
				"", "", "", "");
		if (Order.size() > 0) {
			ParkingOrder parkingOrder = Order.get(0);
			if (subCar(plate).equals(true)) {
				parkingOrderDao.updateparkingOrderPayState("Paid", parkingOrder.getParkingOrderId());
				addbill(plate, parkingOrder.getParkingOrderParkingInfoId(), parkingOrder.getParkingOrderId());
				ParkingOrder po = orderMapperDao.getParkingOrderById(parkingOrder.getParkingOrderId());
				json = ResultObject.obj2JsonResult("1", "出场成功", po);
			} else {

				// 通过停车场订单ID查询 查询订单信息

				if (parkingOrder != null) {
					if (parkingOrder.getParkingOrderClientUserId() == null
							| parkingOrder.getParkingOrderClientUserId().equals("")) {

						json = registUserIsNull(parkingOrder);

					} else {
						System.out.println("-----已注册用户订单更新------");
						// 计算车辆进出时间
						String parkingOrderCarExitTime = TimeTools.getCurrentTime();
						long time = TimeTools.mathTime(parkingOrderCarExitTime,
								parkingOrder.getParkingOrderCarEnterTime());
						if (time > 0) {
							String parkingOrderCarStayTime = TimeTools.getTime(time);
							String parkingOrderParkingState = "quiet";
							// 停车场id
							String parkingInfoId = parkingOrder.getParkingOrderParkingInfoId();
							// 获取计费价格
							double cost = calfee(plate, parkingInfoId).getShould();
							String parkingOrderCost = String.valueOf(cost);

							int i = parkingOrderDao.updateParkingOrder(parkingOrderCarExitTime, parkingOrderCarStayTime,
									parkingOrderParkingState, parkingOrderCost, parkingOrder.getParkingOrderId());
							if (i > 0) {
								// 余额查询
								FundAccountManage fm = fundAccountManageDao
										.selectByCustId(parkingOrder.getParkingOrderClientUserId());

								ParkingOrder park = orderMapperDao
										.getParkingOrderById(parkingOrder.getParkingOrderId());
								ParkingInfo parkingInfo = parkingInfoDao.getParkingInfoById(parkingInfoId);
								park.setParkingName(parkingInfo.getParkingInfoName());
								String spaces = parkingInfoDao.getParkingInfoById(parkingInfoId)
										.getParkingInfoRestParkingSpaces();
								int sp = Integer.valueOf(spaces) + 1;
								System.out.println("车位信息剩余：" + sp);
								parkingInfoDao.updateParkingSpaces(parkingInfoId, String.valueOf(sp));
								if (Double.valueOf(fm.getFundAccountManageAmount()) > cost) {
									json = updateparkingOrderPayState("Paid", park.getParkingOrderId());
								} else {
									json = updateOrderPayState("Paid", park.getParkingOrderId());
									// 推送 5： 余额不足
									String userBody = ResultObject.obj2JsonResult("5", fm.getFundAccountManageAmount(),
											park);
									ClientUser clientUser = clientUserDao
											.selectClientUserById(parkingOrder.getParkingOrderClientUserId());
									if (clientUser.getClientUserType().equals("1")) {
										SendMassage.sendUser("账户余额不足", userBody,
												clientUser.getClientUserRegistrAtionId());
									} else {
										SendMassage.sendUser("账户余额不足", userBody,
												clientUser.getClientUserRegistrAtionId());
										SendMassage.sendUserPush("账户余额不足", userBody,
												clientUser.getClientUserRegistrAtionId());

									}
								}

							} else {
								json = ResultResponse.obj2JsonResult("0", "订单更新失败", "");
							}
						}

					}
				} else {
					json = ResultResponse.obj2JsonResult("0", "订单不存在", "");

				}
			}
		} else {
			json = ResultResponse.obj2JsonResult("0", "车辆未入场", "");
		}
		System.out.println(json);
		return json;
	}

	private CalfeeData calfee(String plate, String companyID) {
		CalfeeRoot root = null;
		CalfeeData date = new CalfeeData();
		String result = null;
		JSONObject jo = new JSONObject();
		jo.accumulate("companyID", 67);
		jo.accumulate("plate", plate);
		result = HttpPostUtils.executeRequest("calfee", jo);
		ObjectMapper mapper = new ObjectMapper();
		if (result != null) {
			try {
				root = mapper.readValue(result, CalfeeRoot.class);
				date = root.getData();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			date.setShould(0);
		}
		return date;
	}

	private Boolean addbill(String plate, String companyID, String orderID) {
		boolean i = false;
		String result = "";
		CalfeeData data = calfee(plate, companyID);
		JSONObject jo = new JSONObject();
		jo.accumulate("companyID", 67);
		jo.accumulate("plate", plate);
		// jo.accumulate("parkID", data.getParkID());
		jo.accumulate("parkID", 514);
		jo.accumulate("paid", data.getShould());
		jo.accumulate("billID", data.getBillID());
		jo.accumulate("orderID", orderID);
		result = HttpPostUtils.executeRequest("addbill", jo);
		JSONObject jsonObj = JSONObject.fromObject(result);
		String success = jsonObj.get("success").toString();

		if (success.equals("true") && success != null) {
			i = true;
		}

		return i;
	}

	/**
	 * 
	 * TODO 用户停车订单未支付数量（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ParkingOrderService#countOrder(java.lang.String)
	 */
	@Override
	public String countOrder(String userId) {
		List<ParkingOrder> list = orderMapperDao.queryParkOrder("", "", "", userId, "", "NoPaid", "", "", "", "", "",
				"", "", "");
		return String.valueOf(list.size());
	}

	static int i = 0;
	static List<String> carno = new ArrayList<>();

	
	@Override
	public List<String> stayCarNo() {

		return carno;

	}
	List<String> ListCar = new ArrayList<String>();
	@Override
	public List<String> CarNoList(String CarNo) {
	
		if (CarNo.equals("")) {
		} else {
			ListCar.add(CarNo);
		}
		return ListCar;
	}

	public String addCar(String carNo) {
		List<String> list = CarNoList(null);

		for (String string : list) {
			if (carNo.equals(string)) {
				carno.add(carNo);
				i = i + 1;
				System.out.println(carno.size());
			}
		}
		return "" + i + "";
	}

	public Boolean subCar(String carNo) {
		List<String> list = CarNoList(null);
		Boolean isCar = null;
		for (String string : list) {
			if (carNo.equals(string)) {
				carno.remove(carNo);
				i = i - 1;
				isCar = true;
			} else {
				isCar = false;
			}
		}
		return isCar;
	}

}
