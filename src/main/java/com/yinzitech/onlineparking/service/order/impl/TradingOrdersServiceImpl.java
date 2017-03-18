/**
 * Project Name:OnlineParking
 * File Name:TradingOrdersServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.order.impl
 * Date:2015年10月7日下午4:46:10
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.fundAccountManage.FundAccountManageDao;
import com.yinzitech.onlineparking.dao.order.OrderMapperDao;
import com.yinzitech.onlineparking.dao.order.QueryTradingOrderDao;
import com.yinzitech.onlineparking.dao.order.TradingOrdersDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.order.InterimTradingOrder;
import com.yinzitech.onlineparking.entity.order.ParkingOrder;
import com.yinzitech.onlineparking.entity.order.TradingOrders;
import com.yinzitech.onlineparking.service.order.TradingOrdersService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:TradingOrdersServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月7日 下午4:46:10 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
// @Service
public class TradingOrdersServiceImpl implements TradingOrdersService {
	@Autowired
	TradingOrdersDao tradingOrdersDao;
	@Autowired
	OrderMapperDao orderMapperDao;
	@Autowired
	FundAccountManageDao fundAccountManageDao;
	@Autowired
	QueryTradingOrderDao queryTradingOrderDao;

	// 资金账户交易付款方客户资金管理账号tradingOrderParkingOrderId
	// 支付交易订单交易订单交易状态tradingOrderpayState
	// 支付交易订单交易支付状态(支付)tradingOrderBalanceState
	// 支付交易订单交易订单交易状态 tradingOrderState
	@Override
	public String insertTradingOrder(String tradingOrderParkingOrderId, String tradingOrderState,
			String tradingOrderpayState, String tradingOrderBalanceState) {
		String json = "";
		// 通过订单ID查询订单内容
		ParkingOrder parkingOrder = orderMapperDao.getParkingOrderById(tradingOrderParkingOrderId);
		if (parkingOrder != null) {
			// 用户间交易订单主键tradingOrderId
			String tradingOrderId = ToolsIdGenerator.getOrderId();
			// 资金账户交易付款方客户编号tradingOrderSrcCustId
			String tradingOrderSrcCustId = parkingOrder.getParkingOrderClientUserId();
			// 通过用户custId查找资金账户详细信息
			// 资金账户交易付款方客户编号tradingOrderPayCustFundAccountId
			// 资金账户ID
			String tradingOrderPayCustFundAccountId = fundAccountManageDao.selectByCustId(tradingOrderSrcCustId)
					.getFundAccountId();
			// 资金账户交易对应订单号tradingOrderPayeeCustId
			// 停车场ID
			String tradingOrderPayeeCustId = parkingOrder.getParkingOrderParkingInfoId();
			// 资金账户交易收款方客户编号tradingOrderPayeeCustFundAccountId
			String tradingOrderPayeeCustFundAccountId = fundAccountManageDao.selectByCustId(tradingOrderPayeeCustId)
					.getFundAccountId();
			// 支付交易订单付款方,与收款方资金账户变动状态tradingOrderCreateTime 支付交易订单创建时间
			String tradingOrderCreateTime = TimeTools.getCurrentTime();

			int i = tradingOrdersDao.insertTradingOrder(tradingOrderId, tradingOrderSrcCustId,
					tradingOrderPayCustFundAccountId, tradingOrderParkingOrderId, tradingOrderPayeeCustId,
					tradingOrderPayeeCustFundAccountId, tradingOrderState, tradingOrderpayState,
					tradingOrderBalanceState, "000", tradingOrderCreateTime);
			if (i > 0) {
				json = ResultResponse.obj2JsonResult("1", "创建交易订单成功：" + tradingOrderId + "", tradingOrderId);
			} else {
				json = ResultResponse.obj2JsonResult("0", "创建交易订单失败", "");
			}
		} else {
			json = ResultResponse.obj2JsonResult("0", "订单不存在", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String upTradingOrderState(String tradingOrderState, String tradingOrderParkingOrderId) {
		String json = "";
		int i = tradingOrdersDao.upTradingOrderState(tradingOrderState, tradingOrderParkingOrderId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更改支付交易订单交易订单交易状态成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String upTradingOrderpayState(String tradingOrderpayState, String tradingOrderParkingOrderId) {

		String json = "";
		int i = tradingOrdersDao.upTradingOrderpayState(tradingOrderpayState, tradingOrderParkingOrderId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更改支付交易订单交易支付状态成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String upTradingOrderBalanceState(String tradingOrderBalanceState, String tradingOrderParkingOrderId) {

		String json = "";
		int i = tradingOrdersDao.upTradingOrderBalanceState(tradingOrderBalanceState, tradingOrderParkingOrderId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更改支付交易订单付款方,与收款方资金账户变动状态成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String deleteTradingOrderByOrderId(String tradingOrderParkingOrderId) {
		String json = "";
		int i = tradingOrdersDao.deleteTradingOrderByOrderId(tradingOrderParkingOrderId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "订单号删除订单信息成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "订单号删除订单信息失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String queryTradingOrderByPhone(String state, String userPhone, String startTime, String endTime,
			int pageNumber, int pageSize) {
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		List<InterimTradingOrder> interimTradingOrder = tradingOrdersDao.queryTradingOrderByPhone(state, userPhone,
				startTime, endTime);

		if (interimTradingOrder != null) {
			json = ResultObjectList.obj2JsonResult("1", "信息查询成功", interimTradingOrder);

		} else {

			json = ResultResponse.obj2JsonResult("0", "无数据", "");
		}

		return json;
	}

	@Override
	public String queryTradingOrderByParkName(String parkName, String state, String startTime, String endTime,
			int pageNumber, int pageSize) {
		String json = "";
		String park = "%" + parkName + "%";
		PageHelper.startPage(pageNumber, pageSize);
		List<InterimTradingOrder> interimTradingOrder = tradingOrdersDao.queryTradingOrderByParkName(park, state,
				startTime, endTime);
		Page s = PageHelper.endPage();
		if (interimTradingOrder != null) {
			json = ResultObject.obj2JsonResult("1", "信息查询成功", s);

		} else {

			json = ResultResponse.obj2JsonResult("0", "无数据", "");
		}

		return json;
	}

	@Override
	public String queryTradingOrders(String tradingOrderSrcCustId, String tradingOrderParkingOrderId,
			String tradingOrderPayeeCustId, String tradingOrderState, String tradingOrderpayState,
			String tradingOrderBalanceState, String startTime, String endTime) {
		String json = "";
		List<TradingOrders> list = queryTradingOrderDao.queryChargingOrder(tradingOrderSrcCustId,
				tradingOrderParkingOrderId, tradingOrderPayeeCustId, tradingOrderState, tradingOrderpayState,
				tradingOrderBalanceState, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		return json;
	}

	@Override
	public String queryTradingOrdersLimit(String tradingOrderSrcCustId, String tradingOrderParkingOrderId,
			String tradingOrderPayeeCustId, String tradingOrderState, String tradingOrderpayState,
			String tradingOrderBalanceState, String startTime, String endTime, int pageNumber, int pageSize) {

		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		List<TradingOrders> list = queryTradingOrderDao.queryChargingOrder(tradingOrderSrcCustId,
				tradingOrderParkingOrderId, tradingOrderPayeeCustId, tradingOrderState, tradingOrderpayState,
				tradingOrderBalanceState, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		return json;
	}

}
