/**
 * Project Name:OnlineParking
 * File Name:ParkDeviceController.java
 * Package Name:com.yinzitech.onlineparking.controller.device
 * Date:2015年10月21日下午3:34:28
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.device;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.handsetSys.HandsetSysService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;

/**
 * ClassName:ParkDeviceController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 基础数据维护-----> 停车场设备管理
 * Date:     2015年10月21日 下午3:34:28 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkDeviceController {
	
	@Autowired 
	ParkingInfoService parkInfoService ;  
	
	@Autowired
	HandsetSysService handsetSysService ;
	/**
	 * toParkDevice:跳转到停车场设备管理界面
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toParkDevice")
	public ModelAndView toParkDevice(){
		String allParkInfo = parkInfoService.getParkingInfo() ;
		
		ModelAndView mv = new ModelAndView() ;
		mv.addObject("allParkInfo", allParkInfo) ;
		/*String devices = handsetSysService.getHandSet("", "", "", "", "", "", "", "");*/
		mv.setViewName("parkingbackstage/basedatasmanage/park_device_list");
		/*mv.addObject("devices", devices) ;*/
		return mv ;
	}
	
	/**
	 * selectParkDevice:停车场设备管理<br/>
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/selectSysParkDevice")
	@ResponseBody
	public String selectParkDevice(@RequestBody Map<String,String> map){
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		if(currentPage.equals("")||currentPage==null){
			currentPage = "1" ;
 		}
		if(pageSize.equals("")||pageSize==null){
			pageSize = "20" ;
		}
		int page = Integer.parseInt(currentPage) ;
		int pagesize = Integer.parseInt(pageSize) ;
		String handsetId = map.get("deviceId") ;
		String handsetManagerName = map.get("name") ;
		String parkingInfoId = map.get("parkInfoId") ;
		String handsetManagerPhone = map.get("phone") ;
		String devices = handsetSysService.getHandSetLimit
				(handsetId, "", handsetManagerPhone, parkingInfoId, "", handsetManagerName, "", "",page,pagesize) ;
				
			//	getHandSet(handsetId, "", handsetManagerPhone, parkingInfoId, "", handsetManagerName, "", "");
		return  devices;
	}
	
	/**
	 * delSysParkDevice:删除<br/>
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/delSysParkDevice")
	@ResponseBody
	public String delSysParkDevice(@RequestBody Map<String,String> map){
		String handsetId = map.get("deviceId") ;
		String handsetManagerName = map.get("name") ;
		String parkingInfoId = map.get("parkInfoId") ;
		String handsetManagerPhone = map.get("phone") ;
		String handsetManagerId = map.get("handsetManagerId") ;
		handsetSysService.deleteHandsetManagerByManagerId(handsetManagerId) ;
		String devices = handsetSysService.getHandSet(handsetId, "", handsetManagerPhone, parkingInfoId, "", handsetManagerName, "", "");//删除后 重新调用查询
		return  devices;
	}
	
	/**
	 * delBoundSysParkDevice:解除绑定<br/>
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/delBoundSysParkDevice")
	@ResponseBody
	public String delBoundSysParkDevice(@RequestBody Map<String,String> map){
		String deviceId = map.get("deviceId") ;
		String handsetManagerName = map.get("name") ;
		String parkingInfoId = map.get("parkInfoId") ;
		String phone = map.get("phone") ;
		String handsetManagerPhone = map.get("handsetManagerPhone") ;
		 handsetSysService.upHandsetId("", handsetManagerPhone) ; 
			System.err.println("devices***************");
		String devices = handsetSysService.getHandSet(deviceId, "", phone, parkingInfoId, "", handsetManagerName, "", "");//删除后 重新调用查询
		System.err.println("devices:"+devices);
		return  devices;
	}
}

