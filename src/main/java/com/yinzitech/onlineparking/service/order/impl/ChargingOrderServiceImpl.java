/**
 * Project Name:OnlineParking
 * File Name:ChargingOrderServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.order.impl
 * Date:2015年10月12日下午1:43:30
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.order.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.client.QueryClientUserDao;
import com.yinzitech.onlineparking.dao.fundAccountManage.FundAccountManageDao;
import com.yinzitech.onlineparking.dao.order.ChargingOrderDao;
import com.yinzitech.onlineparking.dao.order.QueryChargingOrderDao;
import com.yinzitech.onlineparking.entity.client.user.ClientUser;
import com.yinzitech.onlineparking.entity.common.ResultMap;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.fundAccountManage.FundAccountManage;
import com.yinzitech.onlineparking.entity.order.ChargingOrder;
import com.yinzitech.onlineparking.service.fundAccountManage.SubFundAccountSeqService;
import com.yinzitech.onlineparking.service.order.ChargingOrderService;
import com.yinzitech.onlineparking.utils.DoubleUtils;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.PageHelper.Page;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.wexin.utils.WeixinUtils;

/**
 * ClassName:ChargingOrderServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月12日 下午1:43:30 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ChargingOrderServiceImpl implements ChargingOrderService {
	@Autowired
	ChargingOrderDao chargingOrderDao;
	@Autowired
	FundAccountManageDao fundAccountManageDao;
	@Autowired
	QueryChargingOrderDao qcod;
	@Autowired
	QueryClientUserDao qc;
	@Autowired
	SubFundAccountSeqService sf;

	/**
	 * 
	 * TODO 查询资金账户订单ById（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ChargingOrderService#selectChargingOrderByAccountId(java.lang.String)
	 */
	@Override
	public String selectChargingOrderByAccountId(String chargingOrderId) {
		String json = "";

		ChargingOrder chargingOrder = chargingOrderDao.selectChargingOrderByAccountId(chargingOrderId);

		if (chargingOrder != null) {
			chargingOrder.setChargingOrderAmount(
					String.valueOf(Double.valueOf(chargingOrder.getChargingOrderAmount()) / 100));
			json = ResultObject.obj2JsonResult("1", "查询充值订单成功", chargingOrder);

		} else {
			json = ResultResponse.obj2JsonResult("0", "暂无充值订单", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 统一下单（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ChargingOrderService#unifiedOrder(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String unifiedOrder(String chargingOrder2ClientUserId, String chargingOrderChargingType,
			String chargingOrderChargingAccount, String chargingOrderAmount, String clientUserSecurity) {
		String json = "";
		String outTradeNo = WeixinUtils.getOut_trade_no();
		// 值 1 支付宝支付渠道 值 2 微信支付渠道 值 3 银联宝支付渠道
		switch (Integer.valueOf(chargingOrderChargingType)) {
		case 1:
			chargingOrderChargingAccount = "";
			System.out.println("支付宝");
			Map<String, String> aliPay = new HashMap<>();
			creatChargingOrder(chargingOrder2ClientUserId, clientUserSecurity, outTradeNo, "NOTPAY",
					chargingOrderChargingType, chargingOrderChargingAccount, chargingOrderAmount);
			aliPay.put("out_trade_no", outTradeNo);
			json = ResultMap.obj2JsonResult("1", "订单创建成功", aliPay);
			break;
		// 微信创建支付订单
		case 2:
			chargingOrderChargingAccount = "";

			System.out.println("微信");
			Map<String, String> map = WeixinUtils.payUnifiedorder("平台充值", Integer.valueOf(chargingOrderAmount) * 100,
					"127.0.0.1", outTradeNo);
			if (map.get("return_code").equals("SUCCESS")) {
				chargingOrderAmount = String.valueOf(Double.valueOf(chargingOrderAmount));
				creatChargingOrder(chargingOrder2ClientUserId, clientUserSecurity, outTradeNo, "NOTPAY",
						chargingOrderChargingType, chargingOrderChargingAccount, chargingOrderAmount);
				map.put("out_trade_no", outTradeNo);
				json = ResultMap.obj2JsonResult("1", "订单创建成功", map);
				inpour(chargingOrder2ClientUserId, clientUserSecurity, outTradeNo);
			} else {
				json = ResultResponse.obj2JsonResult("0", "订单创建失败", "");
			}
			break;
		case 3:
			System.out.println("其他支付方式");

			break;
		default:
			break;
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * creatChargingOrder:(创建充值订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrder2ClientUserId
	 * @param clientUserSecurity
	 * @param outTradeNo
	 * @param chargingOrderPaymentPlatformFeedback
	 * @param chargingOrderChargingType
	 * @param chargingOrderChargingAccount
	 * @param chargingOrderAmount
	 * @return
	 * @since JDK 1.8u60
	 */
	private String creatChargingOrder(String chargingOrder2ClientUserId, String clientUserSecurity, String outTradeNo,
			String chargingOrderPaymentPlatformFeedback, String chargingOrderChargingType,
			String chargingOrderChargingAccount, String chargingOrderAmount) {
		String json = "";
		List<ClientUser> user = qc.getUser(chargingOrder2ClientUserId, "", "", "", "", "", "", "", "", "", "", "");
		if (user.get(0).getClientUserSecurity().equals(clientUserSecurity)) {
			// 订单号
			String chargingOrderId = ToolsIdGenerator.getOrderId();
			// 获取资金账户
			String chargingOrder2FundAccountId = fundAccountManageDao.selectByCustId(chargingOrder2ClientUserId)
					.getFundAccountId();
			// 创建时间
			String chargingOrderCreateTime = TimeTools.getCurrentTime();
			// 支付平台订单号
			String chargingOrderPaymentPlatformId = outTradeNo;
			int i = chargingOrderDao.creatChargingOrder(chargingOrderId, chargingOrder2FundAccountId,
					chargingOrder2ClientUserId, chargingOrderChargingType, chargingOrderChargingAccount,
					chargingOrderPaymentPlatformId, chargingOrderPaymentPlatformFeedback, chargingOrderAmount,
					chargingOrderCreateTime);

			if (i > 0) {
				json = "1";
			} else {
				json = "0";
			}
		}
		System.out.println(json);
		return json;

	}

	/**
	 * 
	 * TODO 充值状态轮询（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ChargingOrderService#inpour(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public String inpour(String userId, String clientUserSecurity, String outTradeNo) {
		List<ClientUser> user = qc.getUser(userId, "", "", "", "", "", "", "", "", "", "", "");
		if (user.get(0).getClientUserSecurity().equals(clientUserSecurity)) {
			String userPhone = user.get(0).getClientUserCellphone();
			ChargingOrder co = chargingOrderDao.getOutTradeNo(outTradeNo);
			if (co != null) {
				String chargingOrderId = co.getChargingOrderId();
				switch (Integer.valueOf(co.getChargingOrderChargingType())) {
				case 1:
					aliPay(userId, outTradeNo, userPhone, chargingOrderId, co.getChargingOrderPaymentPlatformFeedback(),
							co.getChargingOrderAmount());
					break;
				case 2:
					weiXinQuery(userId, outTradeNo, userPhone, chargingOrderId);
					break;

				default:
					break;
				}

			}

		}

		return null;
	}

	/**
	 * 
	 * aliPay:(支付宝支付查询). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param userId
	 * @param outTradeNo
	 * @param userPhone
	 * @param chargingOrderId
	 * @param tradeStatus
	 * @param OrderAmount
	 * @return
	 * @since JDK 1.8u60
	 */
	public String aliPay(String userId, String outTradeNo, String userPhone, String chargingOrderId, String tradeStatus,
			String OrderAmount) {

		// 获取充值前账户金额
		FundAccountManage fm = fundAccountManageDao.selectByCustId(userId);
		String amount = fm.getFundAccountManageAmount();
		System.out.println("充值金额:" + OrderAmount);
		String chargingOrderAmount = String.valueOf(Double.valueOf(OrderAmount));
		System.out.println("充值金额换算:" + chargingOrderAmount);
		Double ss = DoubleUtils.add(Double.valueOf(amount), Double.valueOf(chargingOrderAmount));
		System.out.println("账户:" + amount);
		System.out.println("账户余额:" + ss);
		// 进行账户充值
		fundAccountManageDao.upFundAccountManageAmount(userId, String.valueOf(ss));
		// 充值流水记录
		sf.creatSubFundAccountSeq(fm.getFundAccountId(), userId, userPhone, "0", "03", amount, chargingOrderAmount,
				"002", chargingOrderId);

		System.out.println("success");
		return "success";
	}

	/**
	 * 
	 * weiXinQuery:(微信轮询账单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(SUCCESS—支付成功 <br/>
	 * REFUND—转入退款 <br/>
	 * NOTPAY—未支付 <br/>
	 * CLOSED—已关闭 <br/>
	 * REVOKED—已撤销（刷卡支付）<br/>
	 * USERPAYING--用户支付中 <br/>
	 * PAYERROR--支付失败(其他原因，如银行返回失败) – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param userId
	 * @param outTradeNo
	 * @since JDK 1.8u60
	 */
	private void weiXinQuery(String userId, String outTradeNo, String userPhone, String chargingOrderId) {
		final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		final int queryTime = 300;// 总共轮询查询时间，单位秒
		final int queryPeriod = 2;// 间隔时间，单位秒
		Runnable queryRunnable = new Runnable() {
			int i = 0;
			int n = queryTime / queryPeriod;

			@Override
			public void run() {
				if (++i <= n) {
					System.out.println("查询第 " + i + " 次");
					Map<String, String> queryMap = WeixinUtils.payOrderquery(outTradeNo);

					switch (queryMap.get("trade_state")) {
					case "SUCCESS":
						chargingOrderDao.upChargingOrder("SUCCESS", outTradeNo);
						// 获取充值前账户金额
						FundAccountManage fm = fundAccountManageDao.selectByCustId(userId);
						String amount = fm.getFundAccountManageAmount();
						String OrderAmount = queryMap.get("total_fee");
						System.out.println("充值金额:" + OrderAmount);
						String chargingOrderAmount = String.valueOf(Double.valueOf(OrderAmount) / 100);
						System.out.println("充值金额换算:" + chargingOrderAmount);
						Double ss = DoubleUtils.add(Double.valueOf(amount), Double.valueOf(chargingOrderAmount));
						System.out.println("账户:" + amount);
						System.out.println("账户余额:" + ss);
						// 进行账户充值
						fundAccountManageDao.upFundAccountManageAmount(userId, String.valueOf(ss));
						// 充值流水记录
						sf.creatSubFundAccountSeq(fm.getFundAccountId(), userId, userPhone, "0", "03", amount,
								chargingOrderAmount, "002", chargingOrderId);
						// 收款成功，退出轮询
						service.shutdownNow();

						break;
					case "USERPAYING":

						service.shutdownNow();
						break;
					}

					if (i == n) {
						chargingOrderDao.upChargingOrder("CLOSED", outTradeNo);
						// 最后一次查询时，仍然没有查询到付款成功，需要撤销订单
						WeixinUtils.closeOrder(outTradeNo);
						// 退出轮询
						System.out.println("退出轮询");
						service.shutdownNow();
					}
				}
			}
		};
		service.scheduleAtFixedRate(queryRunnable, 0, queryPeriod, TimeUnit.SECONDS);

	}

	/**
	 * 
	 * TODO 查询充值订单（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.order.ChargingOrderService#queryChargingOrder(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String queryChargingOrder(String chargingOrder2ClientUserId, String chargingOrderChargingType,
			String startTime, String endTime, String chargingOrderPaymentPlatformFeedback) {
		String json = "";
		List<ChargingOrder> list = qcod.queryChargingOrder(chargingOrder2ClientUserId, chargingOrderChargingType,
				startTime, endTime, chargingOrderPaymentPlatformFeedback);
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询充值订单成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}

		return json;
	}

	@Override
	public String queryChargingOrderLimit(String chargingOrder2ClientUserId, String chargingOrderChargingType,
			String startTime, String endTime, String chargingOrderPaymentPlatformFeedback, int pageNumber,
			int pageSize) {
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		System.out.println(chargingOrder2ClientUserId);
		List<ChargingOrder> list = qcod.queryChargingOrder(chargingOrder2ClientUserId, chargingOrderChargingType,
				startTime, endTime, chargingOrderPaymentPlatformFeedback);
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询充值订单成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}

		return json;
	}

	/**
	 * 
	 * upType:(充值状态更新). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param outTradeNo
	 * @return
	 * @since JDK 1.8u60
	 */
	@Override
	public boolean upType(String outTradeNo, String type) {
		int i = chargingOrderDao.upChargingOrder(type, outTradeNo);
		Boolean bool;
		if (i > 0) {
			bool = true;
		} else {
			bool = false;
		}

		return bool;
	}

}
