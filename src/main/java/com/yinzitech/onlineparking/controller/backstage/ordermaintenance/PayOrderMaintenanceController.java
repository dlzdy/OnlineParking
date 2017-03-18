/**
 * Project Name:OnlineParking
 * File Name:OrderMaintenanceController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.ordermaintenance
 * Date:2015年10月12日下午6:12:18
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.ordermaintenance;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.order.TradingOrdersService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;

/**
 * ClassName:OrderMaintenanceController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 停车场后台 ----> 订单维护 ----> 支付订单维护
 * Date:     2015年10月12日 下午6:12:18 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */

@Controller
public class PayOrderMaintenanceController {
	@Autowired 
	ParkingInfoService parkInfoService ;  
	
	@Autowired
	TradingOrdersService tradingOrdersService ;//支付订单维护 service 
	/**
	 * toPayOrderMaintenance:跳转到支付订单维护界面<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toPayOrderMaintenance")
	public ModelAndView toPayOrderMaintenance(){
		ModelAndView mv = new ModelAndView() ;
		//首先获取所有停车场名称以及id
		String allParkInfo = parkInfoService.getParkingInfo() ;
		String tradingOrders = tradingOrdersService.queryTradingOrders("", "",
				"", "", "","", "", "") ;
		mv.setViewName("parkingbackstage/ordermaintenance/payordermaintance_list");
		mv.addObject("allParkInfo", allParkInfo) ;
		mv.addObject("tradingOrders", tradingOrders) ;
		return mv ;
	}
	
	/**
	 * selectPayOrderMaintenance:根据查询条件 查询订单
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 * 
	 * trading_order_pay_state 支付交易订单交易支付状态(支付) 唯一键标识 对应数据库 trading_order 对应实体类 TradingOrder 
	 * 对应属性 tradingOrderpayState 
	 * 数据库字段类型 varchar 实体类字段类型 String
	 *  默认 10 未支付 00 等待支付 01 支付中 02 支付成功 03 支付失败
	 */
	@RequestMapping(value="/selectPayOrderMaintenance",method=RequestMethod.POST)
	@ResponseBody
	public String selectPayOrderMaintenance(@RequestBody Map<String,String> map){
		String parkName = map.get("parkName") ;
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		if(currentPage.equals("")||currentPage==null){
			currentPage ="1" ;
		}
		if(pageSize.equals("")||pageSize==null){
			pageSize = "20" ;
		}
		System.out.println("====parkName:"+parkName);
		String state = map.get("state") ;
		String startTime = map.get("startTime") ;
		String endTime = map.get("endTime") ;
		int pages = Integer.parseInt(currentPage) ;
		int pagesize = Integer.parseInt(pageSize) ;
		System.out.println("***"+parkName+state+startTime+endTime);
		String tradingOrders = tradingOrdersService.queryTradingOrdersLimit("", "",
				"", state, "","", startTime, endTime,pages,pagesize) ;
//				queryTradingOrders("", "",
//						"", "", state,"", startTime, endTime) ;
		return tradingOrders ;
	}
	
}

