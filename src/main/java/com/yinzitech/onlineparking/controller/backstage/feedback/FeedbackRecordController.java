/**
 * Project Name:OnlineParking
 * File Name:FeedbackRecordController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.feedback
 * Date:2015年10月27日下午3:55:09
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.feedback;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.sys.OpinionService;

/**
 * ClassName:FeedbackRecordController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 反馈记录
 * Date:     2015年10月27日 下午3:55:09 <br/>
 * @author   ziheng
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class FeedbackRecordController {
  
	@Autowired
	OpinionService opinionService ;
	/**
	 * toFeedbackRecord:掉转到用户反馈意见 界面 <br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toFeedbackRecord")
	public ModelAndView toFeedbackRecord(){
	  String opinions = opinionService.getOpinion("", "", "", 1, 20) ;
	  System.out.println("****opinions:"+opinions);
	  ModelAndView mv = new ModelAndView() ;
	  mv.setViewName("parkingbackstage/feedbackrecord/feedbackrecord_list");
	  mv.addObject("opinions", opinions) ;
	  return mv ;
  }
	//分页
	@RequestMapping(value="/selectFeedbackRecord")
	@ResponseBody
	public String selectFeedbackRecord(@RequestBody Map<String,String> map){
		String opinionUserPhone = map.get("opinionUserPhone") ;
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
		System.err.println("opinionUserPhone:"+opinionUserPhone+";startTime:"+startTime+";endTime:"+endTime+";pages:"+pages+";pagesize:"+pagesize);
	  String opinions = opinionService.getOpinion(opinionUserPhone, startTime, endTime, pages, pagesize) ;
	  return opinions ;
  }
}

