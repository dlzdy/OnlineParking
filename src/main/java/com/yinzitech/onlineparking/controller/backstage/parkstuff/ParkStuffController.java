/**
 * Project Name:OnlineParking
 * File Name:ParkStuffController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.parkstuff
 * Date:2015年10月19日下午4:04:50
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.parkstuff;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.handsetSys.HandsetSysService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;

import net.sf.json.JSONObject;


/**
 * ClassName:ParkStuffController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	基础数据维护--->停车场人员维护
 * Date:     2015年10月19日 下午4:04:50 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkStuffController {
	
	@Autowired 
	ParkingInfoService parkInfoService ;
	
	@Autowired
	HandsetSysService handsetSysService ; //停车场管理员信息service
	/**
	 * toParkStuff: 跳转到停车场员工管理界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toParkStuff")
	public ModelAndView toParkStuff(){
		//首先获取所有停车场名称以及id
		String allParkInfo = parkInfoService.getParkingInfo() ;
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/basedatasmanage/park_stuff_list");
//		String stuffs = handsetSysService.getHandSet("", "", "","", "", "", "", "") ;
//		String stuff = handsetSysService.getHandSetLimit("", "", "", "", "", "", "",  "",1 ,  10) ;
//		System.err.println("分页后stuff："+stuff);
		mv.addObject("allParkInfo", allParkInfo) ;
//		mv.addObject("stuffs", stuff) ;
		return mv ;
	}
	
	/**
	 * selectParkStuff:通过停车场id 查询并显示对应点的停车场的所有员工信息
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/selectParkStuff",method=RequestMethod.POST)
	@ResponseBody
	public String selectParkStuff(@RequestBody Map<String,String> map){
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
	    String parkingInfoId = map.get("parkInfoId") ;
	    String stuffName = map.get("stuffName") ;
	    String stuffPhone = map.get("stuffPhone") ;
	    if(currentPage.equals("")||currentPage==null){
	    	currentPage = "1" ;
	    }
	    if(pageSize.equals("")||pageSize==null){
	    	pageSize = "20" ;
	    }
	    int page = Integer.parseInt(currentPage) ;
	    int pagesize = Integer.parseInt(pageSize) ;
		String stuffs = handsetSysService.getHandSetLimit
				("", "", stuffPhone,
						parkingInfoId, "", 
						stuffName, "", "", page, pagesize) ;
		System.err.println("parkingInfoId:"+parkingInfoId+";stuffName:"+stuffName+"stuffPhone:"+stuffPhone+";page:"+page+";pagesize:"+pagesize);
				//getHandSet("", "", stuffPhone, parkingInfoId, "", stuffName, "", "") ;
		return stuffs;
	}
	
	
	/**
	 * toAddStuff:跳转到添加员工界面
	 * @author Xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toSystemAddStuff")
	public ModelAndView toAddStuff(HttpServletRequest request){
		//获取停车场所有信息
	    String allParkInfo = parkInfoService.getParkingInfo();
	    
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/basedatasmanage/park_stuff_add");
		
		mv.addObject("allParkInfo", allParkInfo) ;
		return mv;
	}	
	
	/**
	 * creatHandsetManager:创建停车场员工管理用户
	 * @author xumingyue
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/creatSysHandsetManager")
	@ResponseBody 
	public String creatSysHandsetManager(@RequestBody Map<String,String> map){
		String handsetManagerPhone = map.get("handsetManagerPhone") ;
		String parkingInfoId = map.get("parkingInfoId") ;
		String handsetManagerName = map.get("handsetManagerName") ;
		String result = 
			handsetSysService.creatHandsetManager(handsetManagerPhone, parkingInfoId, handsetManagerName) ;
		return result ;
	}
	
	/**
	 * editSStuff:跳转到编辑界面<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toSysEditStuff")
	public ModelAndView toSysEditStuff(HttpServletRequest request){
		String managerId = request.getParameter("managerId") ;
		//String managerName =  request.getParameter("managerName") ;
		//首先获取所有停车场名称以及id
		String allParkInfo = parkInfoService.getParkingInfo() ;
		System.out.println("allParkInfo:"+allParkInfo);
		String handSetManager = handsetSysService.getHandSet("", managerId, "", "", "", "", "", "") ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/basedatasmanage/park_stuff_edit");
		mv.addObject("handSetManager", handSetManager) ;
		mv.addObject("allParkInfo",allParkInfo ) ;
		return mv;
	}
	
	/**
	 * editSStuff:修改手机号码<br/>
	 * @author Administrator
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/upSysHandsetManagerPhone")
	@ResponseBody
	public String upSysHandsetManagerPhone(@RequestBody Map<String,String> map){
		String success = "{\"result\":\"1\"}" ;
		String error = "{\"result\":\"0\"}" ;
		String handsetManagerId = map.get("managerId") ;
		String parkingInfoId = map.get("parkingInfoId") ;
		String handsetManagerPhone = map.get("handsetManagerPhone") ;
		String managerName = map.get("managerName") ; 
		String oldPhone = map.get("oldPhone") ; 
		System.err.println("handsetManagerId:"+handsetManagerId+";handsetManagerPhone:"+handsetManagerPhone+
		";managerName:"+managerName+";oldPhone:"+oldPhone);
		String resultName = handsetSysService.upHandsetUser(oldPhone, managerName) ;
		System.err.println("resultName:"+resultName);
		JSONObject obj = JSONObject.fromObject(resultName); 
		String r1 =(String) obj.get("result"); 
		if(r1.equals("1")){
			String resultPhone  = handsetSysService.upHandsetManagerPhone(handsetManagerId, handsetManagerPhone) ;
			handsetSysService.upParkingInfoId(parkingInfoId, handsetManagerId) ;//修改人员所属停车场
			System.err.println("resultPhone:"+resultPhone);
			JSONObject obj1 = JSONObject.fromObject(resultPhone); 
			String r2 =(String) obj1.get("result"); 
			if(r2.equals("1")){
				return success ;
			}else{
				return error ;
			}
		}else{
			return error ;
		}
	}
	
	/**
	 * deleteHandsetManagerByManagerId:停车场通过员工id 删除该员工信息
	 * @author xumingyue
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/delSysHandsetManagerByManagerId")
	@ResponseBody 
	public String  delSysHandsetManagerByManagerId(@RequestBody Map<String,String> map){
		String handsetManagerId = map.get("handsetManagerId") ;
		String stuffName = map.get("stuffName") ;
		String stuffPhone = map.get("stuffPhone") ;
		String parkInfoId = map.get("parkInfoId") ;
	    handsetSysService.deleteHandsetManagerByManagerId(handsetManagerId) ;
	    String stuffs = handsetSysService.
				getHandSet("", "", stuffPhone, parkInfoId, "", stuffName, "", "") ;//删除后  在将从前台传来得参数  重新做查询  返回界面 
		return stuffs ;
	}
	
	
	
}

