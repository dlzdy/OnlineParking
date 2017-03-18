/**
 * Project Name:onlineParking
 * File Name:ParkMnageController.java
 * Package Name:com.yz.ParkDemo.controller.park
 * Date:2015年9月25日下午5:19:00
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.park;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;

import net.sf.json.JSONObject;

/**
 * ClassName:ParkMnageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 停车场管理 --->停车场信息
 * Date:     2015年9月25日 下午5:19:00 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */

@Controller
public class ParkMnageController {
	
		
	@Autowired 
	ParkingManagerService pmService ;
	
	@Autowired
	ParkingInfoService pInfoService ;
	
	@Autowired
	ChargingStandardsService csService ;//收费标准的
	
	@RequestMapping(value="/findParkList")
	public ModelAndView findParkList(HttpServletRequest request){
		String uID = request.getParameter("userID") ; //通过用户id 查询停车场id
		
		String userManagerInfo = pmService.getParkingManagerByParkingManagerId(uID) ;
		JSONObject obj = JSONObject.fromObject(userManagerInfo);
		JSONObject obj1 =  obj.getJSONObject("datas");
		String parkingInfoId = (String) obj1.get("parkingInfoId");
		
		String parkInfo =pInfoService.getParkingInfoById(parkingInfoId) ;
		ModelAndView  mv = new ModelAndView() ;
		mv.addObject("parkInfo",parkInfo) ;
		mv.setViewName("parking/park/parkinfo");
		return mv ;
	}
}

