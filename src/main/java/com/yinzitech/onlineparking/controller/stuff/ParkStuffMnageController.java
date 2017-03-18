/**
 * Project Name:onlineParking
 * File Name:ParkStuffMnageController.java
 * Package Name:com.yz.ParkDemo.controller.stuff
 * Date:2015年9月25日下午2:05:57
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.stuff;

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
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;
import com.yinzitech.onlineparking.service.sys.LoginHisteryService;

import net.sf.json.JSONObject;

/**
 * ClassName:ParkStuffMnageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 员工管理
 * Date:     2015年9月25日 下午2:05:57 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkStuffMnageController {
	
	@Autowired
	ParkingManagerService pmService ;  //用户Service
	
	@Autowired
	ParkingInfoService pInfoService ; //停车场信息Service
	 
	@Autowired
	HandsetSysService handsetSysService ; //停车场管理员信息service
	
	@Autowired
	LoginHisteryService loginHisteryService ; //员工交接班记录
	//=========================员工管理===================================
	/**
	 * 
	 * selectStuffList:查询员工列表. <br/>
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toStuffList")
	public ModelAndView toStuffList(HttpServletRequest request){
//		String M = request.getParameter("m") ;
//		String m = request.getParameter("num") ;
//		String firstName = GetNavigationName.getFirstName(M) ; //通过标记获取一级标题
//		String secondName = GetNavigationName.getSecondName(m) ;//通过标记获取二级标题
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  uID存在seesion中 
		 String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		
 		String stuffs = handsetSysService.getHandSetLimit("", "", "",parkingInfoId, "", "", "", "",1,20) ;
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/stuff/stuff_list");
		mv.addObject("parkInfo",parkInfo) ;
		mv.addObject("stuffs", stuffs) ;
//		mv.addObject("firstName", firstName) ;
//		mv.addObject("secondName", secondName) ;
		return mv;
	}
	
	/**
	 * selectStuffList:根据查询条件查询 收费员<br/>
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/selectStuffList")
	@ResponseBody
	public String  selectStuffList(@RequestBody Map<String,String> map){
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		if(currentPage.equals("")||currentPage==null){
			currentPage ="1" ;
		}
		if(pageSize.equals("")||pageSize==null){
			pageSize = "20" ;
		}
		String uID = map.get("uID") ;
		String stuffName =  map.get("stuffName") ;
		String stuffPhone =  map.get("stuffPhone") ;
		String startTime = map.get("startTime") ;
		String endTime = map.get("endTime") ;
		int pages = Integer.parseInt(currentPage) ;
		int pagesize = Integer.parseInt(pageSize) ;
		 String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		System.out.println(stuffPhone+stuffName+startTime+endTime);
		System.err.println("pages:"+pages+";pagesize:"+pagesize);
		//该接口调用不正确   后续修正？？？？？？？？？？？？？？
		String stuffs = handsetSysService.getHandSetLimit("", "", stuffPhone, parkingInfoId, "", stuffName, startTime, endTime,pages,pagesize) ;
				//getHandSet("", "", stuffPhone, "", "", stuffName, startTime, endTime) ;
		return stuffs ;
	}
	
	
	/**
	 * toAddStuff:跳转到添加员工界面
	 * @author Xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toAddStuff")
	public ModelAndView toAddStuff(HttpServletRequest request){
		String parkingInfoId = request.getParameter("parkingInfoId") ; //从前台获取停车场id
		
		//通过停车场id获取停车场信息   然后在前台获取停车名称
	    String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		
		JSONObject obj = JSONObject.fromObject(parkInfo); // 
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoName =(String) obj1.get("parkingInfoName"); //获取停车场名称
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/stuff/stuff_add");
		mv.addObject("parkingInfoName", parkingInfoName) ;
		mv.addObject("parkingInfoId", parkingInfoId) ;
		return mv;
	}	
	
	/**
	 * creatHandsetManager:创建停车场员工管理用户
	 * @author xumingyue
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/creatHandsetManager")
	@ResponseBody 
	public String creatHandsetManager(@RequestBody Map<String,String> map){
		String handsetManagerPhone = map.get("handsetManagerPhone") ;
		String parkingInfoId = map.get("parkingInfoId") ;
		String handsetManagerName = map.get("handsetManagerName") ;
		String result = 
			handsetSysService.creatHandsetManager(handsetManagerPhone, parkingInfoId, handsetManagerName) ;
		return result ;
	}
	
	
	/**
	 * hasManagerPhone:验证将要插入的停车场管理员是否存在
	 * @author xumingyue
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/hasManagerPhone")
	@ResponseBody 
	public String  hasManagerPhone(@RequestBody Map<String,String> map){
		String handsetManagerPhone = map.get("handsetManagerPhone") ;
		String result = handsetSysService.hasManagerPhone(handsetManagerPhone) ;
		return result;
	}	
	
	/**
	 * editSStuff:跳转到编辑界面<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toEditStuff")
	public ModelAndView toEditStuff(HttpServletRequest request){
		String managerId = request.getParameter("managerId") ;
		//String managerName =  request.getParameter("managerName") ;
		String handSetManager = handsetSysService.selectHandsetManagerByManagerId(managerId) ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/stuff/stuff_edit");
		mv.addObject("handSetManager", handSetManager) ;
		return mv;
	}
	
	/**
	 * editSStuff:修改手机号码<br/>
	 * @author Administrator
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/upHandsetManagerPhone",method=RequestMethod.POST)
	@ResponseBody
	public String upHandsetManagerPhone(@RequestBody Map<String,String> map){
		String success = "{\"result\":\"1\"}" ;
		String error = "{\"result\":\"0\"}" ;
		String handsetManagerId = map.get("managerId") ;
		String handsetManagerPhone = map.get("phone") ;
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
	@RequestMapping(value="/delHandsetManagerByManagerId")
	@ResponseBody 
	public String  deleteHandsetManagerByManagerId(@RequestBody Map<String,String> map){
		String handsetManagerId = map.get("handsetManagerId") ;
		String reuslt = handsetSysService.deleteHandsetManagerByManagerId(handsetManagerId) ;
		return reuslt ;
	}
	
	//=============================收费员交接班==================
	
	@RequestMapping(value="/toStuffShiftRecord")
	public ModelAndView toStuffShiftRecord(HttpServletRequest request){
		
	
		
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  uID存在seesion中 
		 String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/stuff/stuff_shiftrecord");
		mv.addObject("parkInfo",parkInfo) ;
		return mv;
	}
	
	
	//==============================收费员流水=====================
	/**
	 * :调转到收费员流水界面
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	
	@RequestMapping(value="/toStuffRunWater")
	public ModelAndView toStuffRunWater(HttpServletRequest request){
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  uID存在seesion中 
		 String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;

		//通过停车场id获取 所有订单流水
		String handsetOrders = handsetSysService.getHandSetOrderLimit
				(parkingInfoId, "",  "",  "", "",  "", 1, 20) ;
				
				//getHandSetOrder(parkingInfoId, "", "", "", "", "") ;
		System.err.println("handsetOrders:"+handsetOrders);
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/stuff/stuff_runwater");
		mv.addObject("parkInfo",parkInfo) ;
		mv.addObject("handsetOrders", handsetOrders) ;
		return mv;
	}
	
	@RequestMapping(value="/selectStuffRunWater")
	@ResponseBody
	public String selectStuffRunWater(@RequestBody Map<String,String> map){
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		if(currentPage.equals("")||currentPage==null){
			currentPage ="1" ;
		}
		if(pageSize.equals("")||pageSize==null){
			pageSize = "20" ;
		}
		String parkingInfoId = map.get("parkingInfoId");
		String startTime = map.get("startTime");
		String endTime = map.get("endTime");
		String stuffName = map.get("stuffName");
		String stuffPhone = map.get("stuffPhone");
		int pages = Integer.parseInt(currentPage) ;
		int pagesize = Integer.parseInt(pageSize) ;
		System.err.println(parkingInfoId+stuffName+stuffPhone+startTime+endTime) ;
		String handsetOrders = handsetSysService.
				getHandSetOrderLimit(parkingInfoId, stuffPhone, "", stuffName, startTime, endTime,pages,pagesize) ;
		return handsetOrders ;
	}
	
	/**
	 * toStuffRunWater:某个收费员当天的所有流水明细。
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toRunWaterDetail")
	public ModelAndView toRunWaterDetail(){
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/stuff/stuff_runwater_detail");
		return mv;
	}
	
	
}

