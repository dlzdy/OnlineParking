/**
 * Project Name:OnlineParking
 * File Name:SystemUserLoginController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.login
 * Date:2015年10月19日下午2:06:26
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.service.sys.SystemManagerService;

import net.sf.json.JSONObject;


/**
 * ClassName:SystemUserLoginController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 停车场系统后台登录
 * Date:     2015年10月19日 下午2:06:26 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class SystemUserLoginController {

	@Autowired
	SystemManagerService systemManagerService ;
	/**
	 * login:用户登录
	 * @author xumingyue
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/system/systemUserlogin",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody Map<String,String> map,HttpSession session){
		String systemManagerUsername = map.get("userName") ;
		String systemManagerPsd = map.get("passWord") ;
		String result = systemManagerService.selectManagerUserByName(systemManagerUsername, systemManagerPsd) ;
		System.out.println("***result:"+result);
		JSONObject obj = JSONObject.fromObject(result); // (3)获取停车场ID
		String info = (String) obj.get("result") ;
		if(info.equals("1")){
			JSONObject obj1 = obj.getJSONObject("datas");
			String systemManagerId =(String) obj1.get("systemManagerId"); //获取停车场id
			session.setAttribute("systemManagerUsername", systemManagerUsername);
			session.setAttribute("systemManagerPsd", systemManagerPsd);
			//session.setAttribute("systemManagerId","affc432b7b644b6c9fd7e5cc3cb6d446" );
			session.setAttribute("systemManagerId", systemManagerId);
		}
		return result ;
	}
	
	/**
	 * toSystemLogin:登录成功后跳转到的界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toSystemLogin")
	public ModelAndView toSystemLogin(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/logindefault/login");
		return mv ;
	}
	
	/**
	 * sign:注册用户
	 * @author Administrator
	 * @param map
	 * @param session
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/system/systemUserSign",method=RequestMethod.POST)
	@ResponseBody
	public String sign(@RequestBody Map<String,String> map,HttpSession session){
		String systemManagerUsername = map.get("signUserName") ;
		String systemManagerPsd = map.get("signPassWord") ;
		String result = systemManagerService.creatSysteManager(systemManagerUsername, systemManagerPsd) ;

//		JSONObject obj = JSONObject.fromObject(result); // (3)获取停车场ID
//		JSONObject obj1 = obj.getJSONObject("datas");
//		String systemManagerId =(String) obj1.get("systemManagerId"); //获取停车场id
		session.setAttribute("systemManagerUsername", systemManagerUsername);
		session.setAttribute("systemManagerPsd", systemManagerPsd);
		session.setAttribute("systemManagerId","affc432b7b644b6c9fd7e5cc3cb6d446" );
//		System.out.println(result+"*********");
		return result ;
	}
	
	/**
	 * toUpdateUserInfo:跳转到用户信息修改界面<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping("/toUpdateUserInfo")
	public ModelAndView toUpdateUserInfo(){
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/logindefault/user_edit");
		
		return mv ;
	}
	
	
	
	/**
	 * updateUserInfo:更新用户信息 <br/>
	 * @author Administrator
	 * @param map
	 * @param session
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/updateUserInfo")
	@ResponseBody
	public String updateUserInfo(@RequestBody Map<String,String> map){
		
		String systemManagerPsd = map.get("newSystemManagerPsd") ;
		String systemManagerUsername = map.get("systemManagerUsername") ;
		String result  = systemManagerService.upManagerUserPsd(systemManagerPsd, systemManagerUsername) ;
		
		return result ;
	}
	/**
	 * 
	 * systemGetSession：系统后台获取seesion值
	 * @author Administrator
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/systemGetSession",method=RequestMethod.POST)
	@ResponseBody
	public String systemGetSession(HttpServletRequest request){
		HttpSession session = request.getSession() ;
		String sessionValue = (String) session.getAttribute("systemManagerUsername") ;
		System.err.println("systemGetSession:"+sessionValue);
		return "{\"result\":\""+sessionValue+"\"}" ;
	}
	
}

