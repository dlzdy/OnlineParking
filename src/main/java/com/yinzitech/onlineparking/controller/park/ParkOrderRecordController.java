/**
 * Project Name:onlineParking
 * File Name:ParkRunWaterRecord.java
 * Package Name:com.yz.ParkDemo.controller.runwater
 * Date:2015年9月28日上午10:04:28
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.park;
 

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.order.ParkingOrderService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;

import net.sf.json.JSONObject;

/**
 * ClassName:ParkRunWaterRecord <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 流水记录
 * Date:     2015年9月28日 上午10:04:28 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkOrderRecordController {
	
	@Autowired
	ParkingManagerService pmService ;  //用户Service
	
	@Autowired
	ParkingInfoService pInfoService ; //停车场信息Service

	@Autowired
	ParkingOrderService pOrderService ;
	
	//跳转到流水记录界面
	@RequestMapping(value="toRunWaterRecord")
	@ResponseBody
	public ModelAndView toRunWaterRecord(HttpServletRequest request){
		
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  uID存在seesion中 
		String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		//查询用户所有信息 根据停车场id 查询该停车场所有订单
		String pOrders = pOrderService.queryParkOrderLimit("", "", "", "", "", "", 
				"", "", parkingInfoId,"", "", "", "", "",1,20) ;
		System.err.println("pOrders:"+pOrders);
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/orderrecorder");
		mv.addObject("parkInfo",parkInfo) ;
		mv.addObject("pOrders", pOrders) ;
		return mv ;
	}
	
	/**
	 * selectRunWaterRecord:有条件查询 <br/>
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
		@RequestMapping(value="/selectRunWaterRecord")
		@ResponseBody
		public String selectRunWaterRecord(@RequestBody Map<String,String> map){
			String currentPage = map.get("currentPage") ;
			String pageSize = map.get("pageSize") ;
			if(currentPage.equals("")||currentPage==null){
				currentPage ="1" ;
			}
			if(pageSize.equals("")||pageSize==null){
				pageSize = "20" ;
			}
			int pages = Integer.parseInt(currentPage) ;
			int pagesize = Integer.parseInt(pageSize) ;
			String parkingInfoId = map.get("parkingInfoId") ;
			String orderID = map.get("orderID") ;
			String carNo = map.get("carNo") ;
			String stuffName = map.get("stuffName") ;
			String startTime = map.get("startTime") ;
			String endTime = map.get("endTime") ;
			String payState = map.get("payState") ;
			String parkingOrderType = map.get("parkingOrderType") ;
			System.out.println("**"+parkingInfoId+orderID+stuffName+startTime+endTime+payState);
			String orders = pOrderService.queryParkOrderLimit(orderID, carNo, "", "", "", payState, 
					"", "", parkingInfoId, "", startTime, endTime,"",parkingOrderType, pages,pagesize) ;
			return orders  ;
		}
	
}

