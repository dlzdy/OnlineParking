/**
 * Project Name:onlineParking
 * File Name:ParkAccessory.java
 * Package Name:com.yz.ParkDemo.controller.accessory
 * Date:2015年9月28日上午10:50:58
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.accessory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.entity.msg.Message;
import com.yinzitech.onlineparking.service.massage.MessageService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:ParkAccessory <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	通知公告
 * Date:     2015年9月28日 上午10:50:58 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkAccessoryController {
	
	
	@Autowired
	ParkingManagerService pmService ;  //用户Service
	
	
	@Autowired
	ParkingInfoService pInfoService ; //停车场信息Service
	
	@Autowired
	MessageService messageService ;
	
	/**
	 * 
	 * toRunWaterRecord:跳转到通知公告界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="toAccessory")
	public ModelAndView toRunWaterRecord(HttpServletRequest request){
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  uID存在seesion中 
		 String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		String allMessages = messageService.queryMessage("1", "", "", 1, 20) ;
				//selectHistoryMessage() ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/accessory/accessory");
		mv.addObject("parkInfo",parkInfo ) ;
		mv.addObject("allMessages",allMessages) ;
		return mv ;
	}
	
	//分頁
	@RequestMapping(value="selectAccessory")
	@ResponseBody
	public String selectAccessory(@RequestBody Map<String,String> map){
		
		String startTime = map.get("startTime") ;
		String endTime = map.get("endTime") ;
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
		System.err.println("pages:"+pages+";pagesize:"+pagesize);
		String allMessages = messageService.queryMessage("1", startTime, endTime, pages, pagesize) ;
		return allMessages ;
	}
	/**
	 * toAccDetailInfo:显示公告信息的详细界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="toAccDetailInfo")
	public ModelAndView toAccDetailInfo(HttpServletRequest request){
		String msgId = request.getParameter("msgId") ;
		String allMessages = messageService.selectHistoryMessage() ;
		JSONObject jsonobject  = JSONObject.fromObject(allMessages) ;
		 //获取一个json数组
		 JSONArray array = jsonobject.getJSONArray("datas");
		 //将json转化成消息对象集合
		 List<Message> megList = new ArrayList<Message>();
		   for (int i = 0; i < array.size(); i++) {   
		            JSONObject object = (JSONObject)array.get(i);  
		            Message message = (Message)JSONObject.toBean(object,
		            		Message.class);
		            if(message != null ){
		            	megList.add(message);
		            }  
		    }
		   //获取与传入的消息id相同的一条消息
		   Message message = null ;
		   for(int i=0 ; i < megList.size(); i++){
			  if( megList.get(i).getMsgId().equals(msgId)){
				  message = megList.get(i) ;
				  String imgUrl = message.getMsgBodyImgUrl() ;
				  if(imgUrl !=null && (!imgUrl.equals(""))){
					  System.err.println(imgUrl.substring(imgUrl.lastIndexOf("\\")+1,imgUrl.length()));
					  message.setMsgBodyImgUrl( imgUrl.substring(imgUrl.lastIndexOf("\\")+1,imgUrl.length()));
				  }
			  }
		   }
		ModelAndView mv = new ModelAndView() ;
		mv.addObject("message", message) ;
		mv.setViewName("parking/accessory/accessory_detail");
		return mv ;
	}
	
	/**
	 * toEditAccessory:跳转到通知公告编辑界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="toEditAccessory")
	public ModelAndView toEditAccessory(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/accessory/accessory_edit");
		return mv ;
	}
	
	/**
	 * toEditAccessory:跳转到公告添加界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="toAddAccessory")
	public ModelAndView toAddAccessory(HttpServletRequest request){
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/accessory/accessory_add");
		return mv ;
	}
	

	
}

