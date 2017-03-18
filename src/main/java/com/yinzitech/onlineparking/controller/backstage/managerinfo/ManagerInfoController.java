/**
 * Project Name:OnlineParking
 * File Name:ManagerInfoController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.managerinfo
 * Date:2016年5月26日上午10:18:48
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.managerinfo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;
import com.yinzitech.onlineparking.utils.MD5andKL;

/**
 * ClassName:ManagerInfoController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年5月26日 上午10:18:48 <br/>
 * @author   ziheng
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ManagerInfoController {
	
	@Autowired 
	ParkingManagerService pmService ; 
	
	
	@Autowired
	ParkingInfoService pInfoService ;
	
	/**
	 * 
	 * toManagerInfo:(这里用一句话描述这个方法的作用). <br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toManagerInfo")
	public ModelAndView toManagerInfo(){
		
		//首先获取所有停车场名称以及id
		String allParkInfo = pInfoService.getParkingInfo() ;
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/basedatasmanage/managerinfo_list");
		mv.addObject("allParkInfo", allParkInfo) ;
		return mv ;
	}
	
	/**
	 * 
	 * selectManagerList:按条件查询
	 *
	 * @author xumingyue
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/selectManagerList")
	@ResponseBody
	public String selectManagerList(@RequestBody Map<String,String> map){
		String parkingInfoId = map.get("parkInfoId") ;
		String parkingManagerPhone  = map.get("phone") ;
		String pageNumber = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		
		System.err.println("parkingInfoId:"+parkingInfoId+";parkingManagerPhone:"+parkingManagerPhone+";pageNumber:"+pageNumber+";pageSize:"+pageSize);
	    int page = Integer.parseInt(pageNumber) ;
	    int pagesize = Integer.parseInt(pageSize) ;
		
		String getManagerList =  pmService
				.getParkingInfoMapper("", parkingManagerPhone, "", 
						parkingInfoId, "","", page, pagesize) ;
		return getManagerList ;
	}
	
	
	/**
	 * 
	 * toAddManagerInfo:(这里用一句话描述这个方法的作用). <br/>
	 * 跳转到添加管理员用户界面
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toAddManagerInfo")
	public ModelAndView toAddManagerInfo(){
		
		//首先获取所有停车场名称以及id
		String allParkInfo = pInfoService.getParkingInfo() ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/basedatasmanage/managerinfo_add");
		mv.addObject("allParkInfo", allParkInfo) ;
		return mv ;
	}
	
	@RequestMapping(value="/addManagerInfo")
	@ResponseBody
	public String  addManagerInfo(@RequestBody Map<String,String> map){
		
		String parkingInfoId = map.get("parkingInfoId") ;
		String parkingManagerName = map.get("managerName") ;
		String parkingManagerPhone = map.get("managerPhone") ;
		String parkingManagerPsd = map.get("managerPsw") ;
		
		//密码加密
		String md5code = MD5andKL.MD5(parkingManagerPsd) ;//MD5码
		String KLPsw = MD5andKL.KL(md5code) ;//加密的密码
		
		String result =  pmService
				.parkingManagerSignUp(parkingManagerPhone, KLPsw, parkingManagerName, parkingInfoId) ;
		System.err.println("addManagerInfo:"+result);
		return result ;
	}
	
	/**
	 * 
	 * toEditManagerInfo:跳转到编辑界面 <br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toEditManagerInfo")
	public ModelAndView toEditManagerInfo(HttpServletRequest request){
		
		//首先获取所有停车场名称以及id
		String allParkInfo = pInfoService.getParkingInfo() ;
		String parkingManagerPhone= request.getParameter("parkingManagerPhone") ;
		String parkManagerInfo = pmService.getParkingManagerByParkingManagerPhone(parkingManagerPhone) ;
		System.err.println("allParkInfo:"+parkManagerInfo);
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/basedatasmanage/managerinfo_edit");
		mv.addObject("allParkInfo", allParkInfo) ;
		mv.addObject("parkManagerInfo", parkManagerInfo) ;
		return mv ;
	}
	
	/**
	 * 
	 * editParkingManager:编辑用户
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/editParkingManager")
	@ResponseBody
	public String editParkingManager(@RequestBody Map<String,String> map){
		
		String parkingInfoId = map.get("parkingInfoId");
		String parkingManagerId = map.get("parkingManagerId");
		String parkingManagerName = map.get("managerName");
		String parkingManagerPhone = map.get("managerPhone");
		String parkingManagerPsd = map.get("managerPsw");
		String parkingManagerActiveMark = map.get("parkingManagerActiveMark");
		
				
		String result = pmService.upParkingManager(parkingManagerPhone, parkingManagerPsd, parkingManagerName, parkingManagerActiveMark, parkingInfoId, parkingManagerId) ;
			
		
		return result ;
	}
	
	
	/**
	 * 
	 * deleteParkingManager：删除管理员用户
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/deleteParkingManager")
	@ResponseBody
	public String deleteParkingManager(@RequestBody Map<String,String> map){
		String parkingManagerId = map.get("parkingManagerId") ;
		String result = pmService.deleteParkingManager(parkingManagerId) ;
		return  result ;
	}
	
	/**
	 * 
	 * hasPhoneNumber:判断是否有该用户
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toCheckPhoneNumber")
	@ResponseBody
	public String toCheckPhoneNumber(@RequestBody Map<String,String> map){
		
		String parkingManagerPhone = map.get("managerPhone");
		String result = pmService.hasPhoneNumber(parkingManagerPhone) ;
		return result ;
	}
	
	/**
	 * 
	 * updateParkingManagerPsd:重置密码
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/resetPsd")
	@ResponseBody
	public String resetPsd(@RequestBody Map<String,String> map){
		String parkingManagerPhone = map.get("managerPhone");
		String parkingManagerPsd = map.get("managerPsw");
		
		//密码加密
				String md5code = MD5andKL.MD5(parkingManagerPsd) ;//MD5码
				String KLPsw = MD5andKL.KL(md5code) ;//加密的密码
		
		String result = pmService.updateParkingManagerPsd(parkingManagerPhone, KLPsw) ;
		
		return result  ;
	}
	
}

