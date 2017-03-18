/**
 * Project Name:OnlineParking
 * File Name:RechargeOrderMaintanceController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.ordermaintenance
 * Date:2015年10月19日下午4:52:51
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.ordermaintenance;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.order.ChargingOrderService;

/**
 * ClassName:RechargeOrderMaintanceController <br/>
 * Function: 后台订单维护---->充值订单
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月19日 下午4:52:51 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class RechargeOrderMaintanceController {
	
	@Autowired
	ChargingOrderService chargingOrderService ;
	/**
	 * toRechargeOrder:跳转到充值订单维护界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toRechargeOrder")
	public ModelAndView toRechargeOrder(){
		ModelAndView mv = new ModelAndView() ;
		//String rechargeorders = chargingOrderService.queryChargingOrder("", "", "", "") ;
		mv.setViewName("parkingbackstage/ordermaintenance/rechargeordermaintance_list"); 
		//mv.addObject("rechargeorders", rechargeorders) ;
		return mv ; 
	}
	
	/**
	 * selectRechargeOrder:根据条件查询充值订单
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/selectRechargeOrder")
	@ResponseBody
	public String toRechargeOrder(@RequestBody Map<String,String> map){
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		if(currentPage.equals("")||currentPage==null){
			currentPage ="1" ;
		}
		if(pageSize.equals("")||pageSize==null){
			pageSize = "20" ;
		}
		String phone = map.get("phone") ;
		String userID = map.get("userID") ;
		String payMentWay = map.get("payMentWay") ;
		String rechargeState = map.get("rechargeState") ;//支付状态
		String rechargeStartTime = map.get("rechargeStartTime") ;
		String rechargeEndTime = map.get("rechargeEndTime") ;
		int pages = Integer.parseInt(currentPage) ;
		int pagesize = Integer.parseInt(pageSize) ;
		System.out.println("****"+phone+payMentWay+rechargeStartTime+rechargeEndTime);
		String rechargeorders = chargingOrderService.queryChargingOrderLimit(userID, payMentWay, rechargeStartTime, rechargeEndTime, rechargeState, pages, pagesize) ;
				//queryChargingOrder(userID, payMentWay, rechargeStartTime, rechargeEndTime) ;
		System.out.println("******"+rechargeorders);
		return rechargeorders ;
	}
	
}

