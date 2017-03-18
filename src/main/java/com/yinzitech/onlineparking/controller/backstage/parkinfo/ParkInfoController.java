/**
 * Project Name:OnlineParking
 * File Name:ParkInfoController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.parkinfo
 * Date:2015年10月11日下午6:22:11
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.parkinfo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;

/**
 * ClassName:ParkInfoController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月11日 下午6:22:11 <br/>
 * @author  xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkInfoController {
	@Autowired 
	ParkingInfoService parkInfoService ;
	
	
	/**
	 * toParkInfo:跳转到停车场维护界面
	 * @author xumingyue
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toParkInfo")
	public ModelAndView toParkInfo(HttpServletRequest request){
		//获取停车场所有信息
		String allParkInfo = //parkInfoService.getParkingInfo() ;
				parkInfoService.getParkingInfoLimit(1, 20) ;
		System.err.println("allParkInfo:"+allParkInfo);
		ModelAndView mv  = new ModelAndView() ;
		mv.setViewName("parkingbackstage/basedatasmanage/parkinfo_list");
		mv.addObject("allParkInfo", allParkInfo) ;
		return mv ;
		
	}
	
	//分页
	@RequestMapping(value="/selectParkInfo")
	@ResponseBody
	public String selectParkInfo(@RequestBody Map<String,String> map){
		String parkingInfoName = map.get("parkingInfoName") ;
		String parkingInfoAddress = map.get("parkingInfoAddress") ;
		String parkingInfoState = map.get("parkingInfoState") ;
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
		//获取停车场所有信息
		String allParkInfo = //parkInfoService.getParkingInfo() ;
				parkInfoService.getParkingInfo("", parkingInfoAddress, parkingInfoState, parkingInfoName, page, pagesize) ;
		
		return allParkInfo ;
	}
	
	
	@RequestMapping(value="/toAddParkInfo")
	public ModelAndView toAddParkInfo(HttpServletRequest request){
		//获取停车场所有信息
		
		ModelAndView mv  = new ModelAndView() ;
		mv.setViewName("parkingbackstage/basedatasmanage/parkinfo_add");
		return mv ;
		
	}
	
	
	/**
	 * createParkingInfo:后台创建停车场信息
	 * @author xumingyue
 	 * @param map
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/createParkingInfo",method=RequestMethod.POST)
	@ResponseBody
	public String createParkingInfo(@RequestBody Map<String,String> map,HttpServletRequest request){

	    String parkingInfoName = map.get("parkingInfoName") ; //  停车场名称
	    String parkingInfoAddress = map.get("parkingInfoAddress") ; //停车场地址
	    String parkingInfoLongitude = map.get("parkingInfoLongitude") ; // 停车场经度
	    String parkingInfoLatitude = map.get("parkingInfoLatitude") ; //场纬度
	    String parkingInfoParkingSpaces = map.get("parkingInfoParkingSpaces") ; //停车场车位数 
	    String parkingInfoRestParkingSpaces = map.get("parkingInfoRestParkingSpaces") ; // 停车场 剩余 车位数 
	    String parkingInfoCreateManagerType = map.get("parkingInfoCreateManagerType") ; //停车场信息改动人员类型
	    String parkingInfoCreateManagerId = map.get("parkingInfoCreateManagerId") ; //停车场信息改动人员id
	   
		String result = parkInfoService.createParkingInfo(parkingInfoName, parkingInfoAddress, parkingInfoLongitude, parkingInfoLatitude, parkingInfoParkingSpaces, parkingInfoRestParkingSpaces, parkingInfoCreateManagerType, parkingInfoCreateManagerId) ;
	
		return result ;
	}
	

	/**
	 * delParkInfo:删除停车场信息
	 * @author xumingyue
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/delParkInfo")
	@ResponseBody
     public String delParkInfo(@RequestBody Map<String,String> map){
    	 String parkingInfoId = map.get("parkingInfoId") ;
    	 String result = parkInfoService.deleteParkingInfoById(parkingInfoId) ;
    	 return result;
     }
	
	/**
	 * delParkInfo:跳转到编辑停车场信息界面
	 * @author xumingyue
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toEditParkInfo")
	@ResponseBody
     public ModelAndView editParkInfo(HttpServletRequest request){//@RequestBody Map<String,String> map
		 String parkingInfoId = request.getParameter("parkInfoId") ;
		 String parkInfo = parkInfoService.getParkingInfoById(parkingInfoId) ;
    	 ModelAndView mv = new ModelAndView() ;
    	 mv.setViewName("parkingbackstage/basedatasmanage/parkinfo_edit");
    	 mv.addObject("parkInfo", parkInfo) ;
    	 return mv;
     }
	
	
	/**
	 * createParkingInfo:后台创建停车场信息
	 * @author xumingyue
 	 * @param map
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/updateParkingInfo",method=RequestMethod.POST)
	@ResponseBody
	public String updateParkingInfo(@RequestBody Map<String,String> map,HttpServletRequest request){

		String parkingInfoId = map.get("parkingInfoId") ; //  停车场id
	    String parkingInfoName = map.get("parkingInfoName") ; //  停车场名称
	    String parkingInfoAddress = map.get("parkingInfoAddress") ; //停车场地址
	    String parkingInfoLongitude = map.get("parkingInfoLongitude") ; // 停车场经度
	    String parkingInfoLatitude = map.get("parkingInfoLatitude") ; //场纬度
	    String parkingInfoParkingSpaces = map.get("parkingInfoParkingSpaces") ; //停车场车位数 
	    String parkingInfoRestParkingSpaces = map.get("parkingInfoRestParkingSpaces") ; // 停车场 剩余 车位数 
	    String parkingInfoState = map.get("parkingInfoState") ; // 停车场 剩余 车位数 
	    String parkingInfoCreateManagerType = map.get("parkingInfoCreateManagerType") ; //停车场信息改动人员类型
	    String parkingInfoCreateManagerId = map.get("parkingInfoCreateManagerId") ; //停车场信息改动人员id
	    System.err.println("parkingInfoState:"+parkingInfoState);
		String result = parkInfoService.updateParkingInfo(parkingInfoId, parkingInfoName, parkingInfoAddress, parkingInfoLongitude, parkingInfoLatitude, parkingInfoParkingSpaces, parkingInfoRestParkingSpaces, parkingInfoState, parkingInfoCreateManagerType, parkingInfoCreateManagerId) ;
		return result ;
	}
	
	
	
}

