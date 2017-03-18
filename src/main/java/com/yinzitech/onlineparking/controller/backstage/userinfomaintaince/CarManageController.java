/**
 * Project Name:OnlineParking
 * File Name:CarManageController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.userinfomaintaince
 * Date:2015年10月19日下午5:34:14
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.userinfomaintaince;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService;

/**
 * ClassName:CarManageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 车辆管理
 * Date:     2015年10月19日 下午5:34:14 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class CarManageController {
  
	@Autowired
	ClinetUserCarManageService clinetUserCarManageService ;
	/**
	 * toCarManage:掉转到车辆管理界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toCarManage")
	public ModelAndView toCarManage(){
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/userinfomiantaince/carmanage_list");
		String carManagers = clinetUserCarManageService.getUserCarLimit("", "", "", "", "", "",1,20) ;
		mv.addObject("carManagers",carManagers) ;
		return mv ;
	}
	//手机用户管理模块 查询绑定车辆，调转到车辆管理界面
	@RequestMapping(value="/toChangeCarManage")
	public ModelAndView toChangeCarManage(HttpServletRequest request){
		String userID = request.getParameter("userID") ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/userinfomiantaince/carmanage_list");
		String carManagers = clinetUserCarManageService.getUserCarLimit("", userID, "", "", "", "", 1, 20) ;
		mv.addObject("carManagers",carManagers) ;
		mv.addObject("userID", userID);
		return mv ;
	}
	
	/**
	 * selectCarManage:查询绑定车辆<br/>
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/selectCarManage")
	@ResponseBody
	public String selectCarManage(@RequestBody Map<String,String> map){
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		if(currentPage.equals("")||currentPage==null){
			currentPage ="1" ;
		}
		if(pageSize.equals("")||pageSize==null){
			pageSize = "20" ;
		}
		String userID = map.get("userID") ;
		String carNo = map.get("carNo") ;
		int pages = Integer.parseInt(currentPage) ;
		int pagesize = Integer.parseInt(pageSize) ;
		String carManagers = clinetUserCarManageService.getUserCarLimit("", userID, carNo, "", "", "",pages,pagesize) ;
				
				//.getUserCar("", userID, carNo, "", "", "") ;
		System.out.println("***"+userID+"carNo:"+carNo+";carManagers:"+carManagers);
		return carManagers ;
	}
}

