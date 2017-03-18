/**
 * Project Name:onlineParking
 * File Name:ParkDeviceMnage.java
 * Package Name:com.yz.ParkDemo.controller.park
 * Date:2015年9月26日下午6:38:50
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
import com.yinzitech.onlineparking.utils.GetNavigationName;

import net.sf.json.JSONObject;

/**
 * ClassName:ParkDeviceMnage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	停车场设备管理
 * Date:     2015年9月26日 下午6:38:50 <br/>
 * @author  xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkDeviceMnageController {
	
	@Autowired
	ParkingManagerService pmService ;  //用户Service
	
	@Autowired
	ParkingInfoService pInfoService ; //停车场信息Service
	
	/**
	 * findDeviceList:查找设备列表
	 * 
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/findDeviceList")
	public ModelAndView findDeviceList(HttpServletRequest request){
		String M = request.getParameter("m") ;
		String m = request.getParameter("num") ;
		String firstName = GetNavigationName.getFirstName(M) ; //通过标记获取一级标题
		String secondName = GetNavigationName.getSecondName(m) ;//通过标记获取二级标题
		
		
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  uID存在seesion中 
		 String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/device_list");
		
		mv.addObject("parkInfo",parkInfo) ;
		mv.addObject("firstName", firstName) ;
		mv.addObject("secondName", secondName) ;
		return mv ;
	}
	
	/**
	 * toEditDevice:跳转到编辑设备界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toEditDevice")
	public ModelAndView toEditDevice(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/device_edit");
		return mv ;
	}
	
	/**
	 * toAddDevice:跳转到新增设备界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toAddDevice")
	public ModelAndView toAddDevice(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/device_add");
		return mv ;
	}

	
	//===========================================以下为收费员列表操作=========================================
	/**
	 * 
	 * toTollCollector:跳转到收费员类别界面 <br/>
	 *
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toTollCollector")
	public ModelAndView toTollCollector(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/tollcollector_list");
		return mv ;
	}
	
	/**
	 * toTollCollector:跳转到编辑界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toEditTollCollector")
	public ModelAndView toEditTollCollector(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/tollcollector_edit");
		return mv ;
	}
	
	/**
	 * toEditTollCollector:跳转到新增界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toAddTollCollector")
	public ModelAndView toAddTollCollector(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/tollcollector_add");
		return mv ;
	}
	
	
	
	
}

