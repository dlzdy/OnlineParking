/**
 * Project Name:onlineParking
 * File Name:ParkPayMnageController.java
 * Package Name:com.yz.ParkDemo.controller.park
 * Date:2015年9月28日上午9:34:50
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.park;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;

import net.sf.json.JSONObject;

/**
 * ClassName:ParkPayMnageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 	收款卡号设置/支付设置
 * Date:     2015年9月28日 上午9:34:50 <br/>
 * @author  xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkPayMnageController {
	
	@Autowired
	ParkingManagerService pmService ;  //用户Service
	
	@Autowired
	ParkingInfoService pInfoService ; //停车场信息Service
	
	@RequestMapping(value="toPay")
	public ModelAndView toPay(HttpServletRequest request){
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  uID存在seesion中 
		 String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/pay");
		mv.addObject("parkInfo",parkInfo) ;
		return mv ;
	}
}

