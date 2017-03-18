/**
 * Project Name:OnlineParking
 * File Name:AccessoryController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.accessory
 * Date:2015年10月22日上午11:15:35
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.accessory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.entity.msg.Message;
import com.yinzitech.onlineparking.service.massage.MessageService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:AccessoryController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 系统后台---->通知公告
 * Date:     2015年10月22日 上午11:15:35 <br/>
 * @author   ziheng
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class AccessoryController  {//implements HandlerExceptionResolver{
	
	@Autowired
	MessageService messageService ;
	/**
	 * toSystemAccessory:跳转到通知公告界面
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toSystemAccessory")
	public ModelAndView toSystemAccessory(){
		String allMessages = messageService.queryMessage("", "", "", 1, 20) ;
				
				//.selectHistoryMessageLimit(1, 20) ;
		//selectHistoryMessage() ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/accessory/accessory_list");
		mv.addObject("allMessages", allMessages);
		return mv ;
	}
	
	//分页搜索
	@RequestMapping(value="/selectSystemAccessory")
	@ResponseBody
	public String toSystemAccessory(@RequestBody Map<String,String> map){
		
		String msgStatus = map.get("msgStatus") ;
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
		String allMessages = messageService.queryMessage(msgStatus, startTime, endTime, pages, pagesize) ;
		System.err.println("msgStatus:"+msgStatus+";startTime:"+startTime+";endTime:"+endTime+";pages:"+pages+";pagesize:"+pagesize);
				//selectHistoryMessage() ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/accessory/accessory_list");
		mv.addObject("allMessages", allMessages);
		return allMessages ;
	}
	
	/**
	 * toEditAccessory:跳转到公告添加界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toSystemAddAccessory")
	public ModelAndView toAddAccessory(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/accessory/accessory_add");
		return mv ;
	}
	
	@RequestMapping(value="/addAccessory",method=RequestMethod.POST)
	@ResponseBody
	public String addAccessory(@RequestParam(required=false) MultipartFile file,
										@RequestParam String subject,
										@RequestParam String content,
										HttpServletRequest request){
		
		
		String fileName = file.getOriginalFilename() ;
		if(fileName!=""){
			String ext = fileName.substring(fileName.lastIndexOf("."),fileName.length()).toUpperCase();
	    	System.err.println("ext:"+ext);
	        if (!ext.equals(".BMP") && !ext.equals(".PNG") 
	        		&& !ext.equals(".GIF")&& !ext.equals(".JPG")&& !ext.equals(".JPEG")) {
	        	return "<script>window.parent.checkFileType();</script>";
	        }
	        if(file.getSize()/1024>500){
	        	System.err.println("file.getSize()/1024:"+file.getSize()/1024);
	        	return "<script>window.parent.fileExceededInfo();</script>";
	        }
	        
		}
		String saveFilePath = "" ;
		String newFileName = "" ;
		String readPath = "" ; //文件上传路径
		  // 判断文件是否为空  
        if (!file.isEmpty()) {  
        	saveFilePath = request.getSession().getServletContext().getRealPath("/") + "download" + File.separator; 
        	String oldFileName = file.getOriginalFilename() ;
        	System.err.println("文件上传路径："+readPath);
        	/* 构建文件目录 */
	        File fileDir = new File(saveFilePath);
	        if (!fileDir.exists()) {
	            fileDir.mkdirs();
	        }
	        newFileName =  new Date().getTime()+ oldFileName ;
	        readPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/download/"+newFileName;
	        try {
	            FileOutputStream out = new FileOutputStream(saveFilePath + newFileName);
	            System.err.println("文件名称："+saveFilePath+newFileName);
	            // 写入文件
	            out.write(file.getBytes());
	            out.flush();
	            out.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
        }  
  //      String newFilePath = saveFilePath+ newFileName;//文件名+图片名
//       String result = messageService .creatMessage(subject, content, newFilePath) ;//
       String result = messageService .creatMessage(subject, content, readPath) ; //原本将newFilePath存入数据库，但是在详情时，截取不到文件名，现将文件名存入数据库
       return "<script>window.parent.showInfo("+result+");</script>";
	}
	
	/**
	 * sendMessage:发送消息<br/>
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/sendMessage")
	@ResponseBody
	public String sendMessage(@RequestBody Map<String,String>  map ){
		  String msgName = map.get("msgName") ;
		  String msgSendName = map.get("msgSendName") ;
		  System.out.println(msgName+"**"+msgSendName);
		  String result = messageService.sendMessages(msgName, msgSendName) ;
		   return result  ;
	}
	
	/**
	 * toAccDetailInfo:获取消息详细信息<br/>
	 * @author Administrator
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toSysAccDetailInfo")
	public ModelAndView toSysAccDetailInfo(HttpServletRequest request){
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
				  /*String imgUrl = message.getMsgBodyImgUrl() ;
				  if(imgUrl !=null && (!imgUrl.equals(""))){
					  System.err.println(imgUrl.substring(imgUrl.lastIndexOf("\\")+1,imgUrl.length()));
					  message.setMsgBodyImgUrl( imgUrl.substring(imgUrl.lastIndexOf("\\")+1,imgUrl.length()));
				  }*/
			  }
		   }
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/accessory/accessory_detail");
		mv.addObject("message",message ) ;
		return mv ;
	}
	
	/**
	 * toSysEditAccessory:跳转到修改界面<br/>
	 * @author Administrator
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toSysEditAccessory")
	public ModelAndView toSysEditAccessory(HttpServletRequest request){
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
		mv.setViewName("parkingbackstage/accessory/accessory_edit");
		mv.addObject("message",message ) ;
		return mv ;
	}
	
	@RequestMapping(value="/editSysAccessory",method=RequestMethod.POST)
	@ResponseBody
	public String editSysAccessory(@RequestParam(required=false) MultipartFile file,
										@RequestParam String msgId,
										@RequestParam String msgSendName,
										@RequestParam String subject,
										@RequestParam String content,
										HttpServletRequest request){
		String fileName = file.getOriginalFilename() ;
		if(fileName!=""){
			String ext = fileName.substring(fileName.lastIndexOf("."),fileName.length()).toUpperCase();
	    	System.err.println("ext:"+ext);
	        if (!ext.equals(".BMP") && !ext.equals(".PNG") 
	        		&& !ext.equals(".GIF")&& !ext.equals(".JPG")&& !ext.equals(".JPEG")) {
	        	return "<script>window.parent.checkFileType();</script>";
	        }
	        if(file.getSize()/1024>500){
	        	System.err.println("file.getSize()/1024:"+file.getSize()/1024);
	        	return "<script>window.parent.fileExceededInfo();</script>";
	        }
	        
		}
		/*if(file.getSize()/1024>500){
			System.err.println("file.getSize()/1024:"+file.getSize()/1024);
			return "<script>window.parent.fileExceededInfo();</script>";
		}*/
		String saveFilePath = "" ;
		  // 判断文件是否为空  
        if (!file.isEmpty()) {  
         
        	saveFilePath = request.getSession().getServletContext().getRealPath("/") + "download" + File.separator; 
        	String newFileName = new Date().getTime()+file.getOriginalFilename() ;
        	System.err.println("文件上传路径："+saveFilePath);
        	/* 构建文件目录 */
	        File fileDir = new File(saveFilePath);
	        if (!fileDir.exists()) {
	            fileDir.mkdirs();
	        }
	 
	        try {
	            FileOutputStream out = new FileOutputStream(saveFilePath +newFileName);
	            // 写入文件
	            out.write(file.getBytes());
	            out.flush();
	            out.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
        }  
       System.out.println("***msgId:"+msgId+";msgSendName:;subject:"+subject+";content:"+content);
       String result = messageService.upMessageByBody(msgId, subject, content, msgSendName) ;
       return "<script>window.parent.showInfo("+result+");</script>";
	}
	
	
}

