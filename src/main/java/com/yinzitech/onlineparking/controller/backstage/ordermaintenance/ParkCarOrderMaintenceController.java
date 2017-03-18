/**
 * Project Name:OnlineParking
 * File Name:ParkCarOrderMaintenceController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.ordermaintenance
 * Date:2015年10月19日下午4:23:21
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

import com.yinzitech.onlineparking.service.handsetSys.HandsetSysService;
import com.yinzitech.onlineparking.service.order.ParkingOrderService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
/**
 * ClassName:ParkCarOrderMaintenceController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 订单维护---->停车订单维护
 * Date:     2015年10月19日 下午4:23:21 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkCarOrderMaintenceController {
	
	@Autowired 
	ParkingInfoService parkInfoService ;
	
	@Autowired
	ParkingOrderService pOrderService ;
	
	@Autowired
	HandsetSysService handsetSysService ;
	
	/**
	 * toParkCarOrder:跳转到停车订单管理界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toParkCarOrder")
	public ModelAndView toParkCarOrder(){
		//首先获取所有停车场名称以及id
		String allParkInfo = parkInfoService.getParkingInfo() ;
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/ordermaintenance/parkcarordermaintance_list");
		//查询用户所有信息 根据停车场id 查询该停车场所有订单
		//String pOrders = //pOrderService.queryParkOrder(parkingOrderId, parkingOrderCarNo, parkingOrderCarManageId, parkingOrderClientUserId, parkingOrderParkingState, parkingOrderPayState, parkingOrderHandSetId, parkingOrderHandsetManagerId, parkingOrderParkingInfoId, parkingOrderCarNumberState, startTime, endTime, parkingOrderPayCash) ;
		//		pOrderService.queryParkOrder("", "", "", "", "", "",
		//				"", "", "", "", "", "","");
		mv.addObject("allParkInfo", allParkInfo) ;
		//mv.addObject("pOrders", pOrders) ;
		return mv ;
	}
	
	/**
	 * selectParkOrder:根据停车场id 查询停车场订单
	 * @author xumingyue
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/selectParkOrder",method = RequestMethod.POST)
	@ResponseBody
	public String selectParkOrder(@RequestBody Map<String,String> map){
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		if(currentPage.equals("")||currentPage==null){
			currentPage ="1" ;
		}
		if(pageSize.equals("")||pageSize==null){
			pageSize = "20" ;
		}
		String stuffName = map.get("stuffName") ;
		String carNo = map.get("carNo") ;
		String payState = map.get("payState") ;
		String parkingInfoId = map.get("parkInfoId") ;
		String parkingOrderType = map.get("parkingOrderType") ;
		int pages = Integer.parseInt(currentPage) ;
		int pagesize = Integer.parseInt(pageSize) ;
		System.out.println("carNo:"+carNo+";stuffName:"+stuffName+";payState："+payState);
		//查询用户所有信息 根据停车场id 查询该停车场所有订单
		String pOrders = pOrderService.queryParkOrderLimit("", carNo, "", "", "", payState,
			"", "", parkingInfoId,"", "", "", "",parkingOrderType,pages,pagesize);
//				pOrderService.queryParkOrder("", "", "", clientUserID, "", payState,
//						"", "", parkingInfoId, "", "", "","");
		//pOrderService.queryParkOrder(parkingOrderId, parkingOrderCarNo, parkingOrderCarManageId, parkingOrderClientUserId, parkingOrderParkingState, parkingOrderPayState, parkingOrderHandSetId, parkingOrderHandsetManagerId, parkingOrderParkingInfoId, parkingOrderCarNumberState, startTime, endTime) ;
		return pOrders ;
	}
	
}

