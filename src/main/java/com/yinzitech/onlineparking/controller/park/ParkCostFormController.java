/**
 * Project Name:OnlineParking
 * File Name:ParkCostFormController.java
 * Package Name:com.yinzitech.onlineparking.controller.park
 * Date:2015年10月5日下午8:23:07
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.park;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.entity.parkingInfo.ChargingStandards;
import com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:ParkCostFormController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月5日 下午8:23:07 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */

@Controller
public class ParkCostFormController {
	
	@Autowired
	ParkingManagerService pmService ;  //用户Service
	
	
	@Autowired
	ChargingStandardsService chargeStandard ; //收费标准Service
	
	@Autowired
	ParkingInfoService pInfoService ; //停车场信息Service
	/**
	 * toCostForm:跳转到费用表单
	 *
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toCostForm")
	public ModelAndView toCostForm(HttpServletRequest request){
		
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
		
		ModelAndView mv = new ModelAndView() ;
		String chargeStandars = chargeStandard.getChargingStandardsListByParkingInfoIdLimit(parkingInfoId,1,20) ;
				//getChargingStandardsListByParkingInfoId(parkingInfoId) ;

		System.out.println("resutl:****"+chargeStandars);
		mv.setViewName("parking/park/parkinfo_form_list");
		mv.addObject("chargeStandars", chargeStandars) ;
		mv.addObject("parkInfo",parkInfo ) ;
//		mv.addObject("firstName", firstName) ;
//		mv.addObject("secondName", secondName) ;
//		
		return mv  ;
	}
	
	//分页
	@RequestMapping(value="/selectCostForm")
	@ResponseBody
	public String selectCostForm(@RequestBody Map<String,String> map){
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
		String uID = map.get("uID") ;
		
		String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		String chargeStandars = chargeStandard.getChargingStandardsListByParkingInfoIdLimit(parkingInfoId,pages,pagesize) ;
		return  chargeStandars ;
	}
	
	/**
	 * getChargingStandardsList:获取停车场收费表单信息
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
//	@RequestMapping(value="/getChargingStandardsList")
//	public String getChargingStandardsList(HttpServletRequest request){
//	//	String parkingManagerPhone = request.getParameter("userID") ;
//		//String p = pmService.getParkingManagerByParkingManagerPhone(parkingManagerPhone) ;
//		String forms = chargeStandard.getChargingStandardsListByParkingInfoId("1") ;//parkingInfoId
//		return forms ;
//	}
	
	
	/**
	 * toAddChangStandards:跳转到添加表单界面
	 * @author xumingyue
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toAddChangStandards")
	public ModelAndView toAddChangStandards(HttpServletRequest request){
		
		String userID = request.getParameter("uID") ;
		String userInfo =   pmService.getParkingManagerByParkingManagerId(userID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		
		  //限定收费标准阶梯值 不可以重复  1.首先遍历所有停车场收费表单
	    String allForms = chargeStandard.getChargingStandardsListByParkingInfoId(parkingInfoId) ;
	    System.err.println("allForms:"+allForms);
	    JSONObject jsonobject  = JSONObject.fromObject(allForms) ;
		 //获取一个json数组
		 JSONArray array = jsonobject.getJSONArray("datas");
		 List<Integer> stepEnd = new ArrayList<Integer>();
		 List<Integer> step = new ArrayList<Integer>();
		   for (int i = 0; i < array.size(); i++) {   
		            JSONObject object = (JSONObject)array.get(i);
		            String chargingStandardsStepEnd = (String) object.get("chargingStandardsStepEnd") ;
		            String chargingStandardsStep= (String) object.get("chargingStandardsStep") ;
		            stepEnd.add(Integer.parseInt(chargingStandardsStepEnd)) ;
		            step.add(Integer.parseInt(chargingStandardsStep)) ;
		   }
		Integer maxStepEnd = null ;
		Integer maxStep = null;
		if(stepEnd.size()!=0){
			 maxStepEnd =   Collections.max(stepEnd)+1 ;//获取阶梯结束时间最大值
			 maxStep =   Collections.max(step)+1 ;//获取阶梯
		}
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/park/parkinfo_form_add");
		mv.addObject("maxStepEnd", maxStepEnd) ;
		mv.addObject("maxStep", maxStep) ;
		mv.addObject("allForms", allForms);
		return mv ;
	}
	
	/**
	 * parkingManagerSignUp:添加一条收费标准
	 * @author xumingyue
	 * @param map
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/addChangStandards",method=RequestMethod.POST)
	@ResponseBody
	public String parkingManagerSignUp(@RequestBody Map<String,String> map,HttpServletRequest request){
			String uID  =map.get("uID") ; //(1)首先获取UID  uID存在seesion中 
			String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
			JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
			JSONObject obj1 = obj.getJSONObject("datas");
			String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		
			String chargingStandardsManagerId =map.get("chargingStandardsManagerId") ;//(暂为初始化)如果=1 为后台管理员id =2停车场场主管理员id 根据操作停车场收费标准信息时,获取操作人员id
			String  chargingStandardsManagerType = map.get("chargingStandardsManagerType") ;//默认为 1 后台管理员 2 停车场场主管理员
			String chargingStandardsState = map.get("chargingStandardsState") ;
		    String chargingStandardsPrise = map.get("chargingStandardsPrise") ;
		    String chargingStandardsStepStart = map.get("chargingStandardsStepStart") ;
		    String chargingStandardsStepEnd = map.get("chargingStandardsStepEnd") ;
		    String chargingStandardsStep = map.get("chargingStandardsStep") ;
		    
		    //限定收费标准阶梯值 不可以重复  1.首先遍历所有停车场收费表单
		    String allForms = chargeStandard.getChargingStandardsListByParkingInfoId(parkingInfoId) ;
		    
		    JSONObject jsonobject  = JSONObject.fromObject(allForms) ;
			 //获取一个json数组
			 JSONArray array = jsonobject.getJSONArray("datas");
			 //将json转化为收费表单对象集合
			 List<ChargingStandards> megList = new ArrayList<ChargingStandards>();
			   for (int i = 0; i < array.size(); i++) {   
			            JSONObject object = (JSONObject)array.get(i);  
			            ChargingStandards standard = (ChargingStandards)JSONObject.toBean(object,
			            		ChargingStandards.class);
			            if(standard != null ){
			            	megList.add(standard);
			            }  
			    }
			   //遍历后台所有表单 中的阶梯值，并且与前台传入的街体值进行比较 如果相等 返回错误信息
			   for(int i=0 ; i < megList.size(); i++){
				  if( megList.get(i).getChargingStandardsStep().equals(chargingStandardsStep)){
					  return "{\"result\":\"2\"}" ;
				  }
			   }
		    
		    String result = chargeStandard.createChargingStandards(parkingInfoId, chargingStandardsStep, chargingStandardsStepStart, chargingStandardsStepEnd, chargingStandardsPrise, chargingStandardsState, chargingStandardsManagerType, chargingStandardsManagerId) ;
		    return result ;
		}
	
	
	/**
	 * toAddChangStandards:跳转到编辑表单
	 * @author xumingyue
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toEditChangStandards")
	public ModelAndView toEditChangStandards(HttpServletRequest request){
		
		String chargingStandardsId = request.getParameter("chargingStandardsId") ;
		
		ModelAndView mv = new ModelAndView() ;
		String chargerStandardInfo = chargeStandard.getChargingStandardsById(chargingStandardsId) ; 
		mv.setViewName("parking/park/parkinfo_form_edit");
		mv.addObject("chargerStandardInfo", chargerStandardInfo) ;
		return mv ;
	}
	
	
	/**
	 * updatetChargingStandardsById:更新停车场费用表单信息
	 * @author xumingyue
	 * @param map
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/updatetChargingStandardsById",method=RequestMethod.POST)
	@ResponseBody
	public String updatetChargingStandardsById(@RequestBody Map<String,String> map,HttpServletRequest request){
		
		    String chargingStandardsId =map.get("chargingStandardsId") ;
			String parkingInfoId =map.get("parkingInfoId") ;//(暂为初始化)如果=1 为后台管理员id =2停车场场主管理员id 根据操作停车场收费标准信息时,获取操作人员id
			String chargingStandardsManagerId =map.get("chargingStandardsManagerId") ;//(暂为初始化)如果=1 为后台管理员id =2停车场场主管理员id 根据操作停车场收费标准信息时,获取操作人员id
			String  chargingStandardsManagerType = map.get("chargingStandardsManagerType") ;//默认为 1 后台管理员 2 停车场场主管理员
			String chargingStandardsState = map.get("chargingStandardsState") ;
		    String chargingStandardsPrise = map.get("chargingStandardsPrise") ;
		    String chargingStandardsStepStart = map.get("chargingStandardsStepStart") ;
		    String chargingStandardsStepEnd = map.get("chargingStandardsStepEnd") ;
		    String chargingStandardsStep = map.get("chargingStandardsStep") ;
		    
		    //限定收费标准阶梯值 不可以重复  1.首先遍历所有停车场收费表单
		    String allForms = chargeStandard.getChargingStandardsListByParkingInfoId(parkingInfoId) ;
		    
		    JSONObject jsonobject  = JSONObject.fromObject(allForms) ;
			 //获取一个json数组
			 JSONArray array = jsonobject.getJSONArray("datas");
			 //将json转化为收费表单对象集合
			 List<ChargingStandards> megList = new ArrayList<ChargingStandards>();
			   for (int i = 0; i < array.size(); i++) {   
			            JSONObject object = (JSONObject)array.get(i);  
			            ChargingStandards standard = (ChargingStandards)JSONObject.toBean(object,
			            		ChargingStandards.class);
			            if(standard != null ){
			            	megList.add(standard);
			            }  
			    }
			   
			   //当前所要修改的 阶段结束时间必须小于下一个阶梯的开始时间
			   int nextStep = Integer.parseInt(chargingStandardsStep)+1; //下一个阶梯的值
			   System.err.println("nextStep:"+nextStep);
			   String nextStandardsStepStart = "";
			   for(int j=0 ; j<megList.size(); j++){
				   String currentStep =  megList.get(j).getChargingStandardsStep() ;
				   if(Integer.parseInt(currentStep)==nextStep){
					  nextStandardsStepStart = megList.get(j).getChargingStandardsStepStart() ;
				   }
			   }
			   System.err.println("chargingStandardsStepEnd:"+chargingStandardsStepEnd);
			   System.err.println("nextStandardsStepStart:"+nextStandardsStepStart);
			   //System.err.println(Integer.parseInt(chargingStandardsStepEnd)>=Integer.parseInt(nextStandardsStepStart));
			   if(nextStandardsStepStart!=null&&!nextStandardsStepStart.equals("")){
				   if(Integer.parseInt(chargingStandardsStepEnd)>=Integer.parseInt(nextStandardsStepStart)){//修改的阶梯结束时间大于等于下一阶梯的开始时间
					   return "{\"result\":\"3\"}" ; //如果修改的阶梯结束时间大于下一个收费标准的开始时间，则返回
				   }
			   }
			  
			   
			   
			   //遍历后台所有表单 中的阶梯值，并且与前台传入的街体值进行比较 如果相等 返回错误信息
			   for(int i=0 ; i < megList.size(); i++){
				   //如果修改中 阶梯值并没有改变，前端不显示提示信息，所以要判断是不是同一个表单的阶梯值
				  if( megList.get(i).getChargingStandardsStep().equals(chargingStandardsStep)
						  &&!megList.get(i).getChargingStandardsId().equals(chargingStandardsId)){
					  return "{\"result\":\"2\"}" ;
				  }
			   }
			   
		    String result =
		    		chargeStandard.updatetChargingStandardsById(chargingStandardsId, parkingInfoId, chargingStandardsStep, chargingStandardsStepStart, chargingStandardsStepEnd, chargingStandardsPrise, chargingStandardsState, chargingStandardsManagerType, chargingStandardsManagerId);
		    		
		    return result ;
		}
	
	/**
	 * deleteChargingStandardsByChargingStandardsId:通过id删除表单信息
	 * @author xumingyue
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/delChargeStandardsById",method=RequestMethod.POST)
	@ResponseBody
	public String deleteChargingStandardsByChargingStandardsId(@RequestBody Map<String,String> map){
		    String chargingStandardsId =map.get("chargingStandardsId") ;
		    String result = chargeStandard.deleteChargingStandardsByChargingStandardsId(chargingStandardsId) ;
		    return result ;
		}
	
	
}

