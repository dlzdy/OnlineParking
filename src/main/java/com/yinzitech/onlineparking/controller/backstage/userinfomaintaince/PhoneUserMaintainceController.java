/**
 * Project Name:OnlineParking
 * File Name:PhoneUserMaintainceController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.userinfomaintaince
 * Date:2015年10月19日下午5:22:05
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

import com.yinzitech.onlineparking.service.client.ClientUserService;

import net.sf.json.JSONObject;

/**
 * ClassName:PhoneUserMaintainceController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 用户信息维护--->手机用户管理
 * Date:     2015年10月19日 下午5:22:05 <br/>
 * @author  xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class PhoneUserMaintainceController {
	
	@Autowired
	ClientUserService clientUserService ;
	
	/**
	 * toPhoneUserManage:跳转到手机用户界面<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toPhoneUser")
	public ModelAndView toPhoneUserManage(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/userinfomiantaince/phoneusermanager_list");
		String clientUsers = clientUserService.getUser("", "", "", "", "", "", "", "", "") ;
		mv.addObject("clientUsers",clientUsers) ;
		return mv ;
	}
	
	/**
	 * selectPhoneUser:根据条件查询手机用户
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/selectPhoneUser")
	@ResponseBody
	public String selectPhoneUser(@RequestBody Map<String,String> map){
		String currentPage = map.get("currentPage") ;
		String pageSize = map.get("pageSize") ;
		if(currentPage.equals("")||currentPage==null){
			currentPage ="1" ;
		}
		if(pageSize.equals("")||pageSize==null){
			pageSize = "20" ;
		}
		String usernName = map.get("userName") ;
		String userPhone = map.get("userPhone") ;
		String sex = map.get("sex") ;
		String autoPay = map.get("autoPay") ;
		int pages = Integer.parseInt(currentPage) ;
		int pagesize = Integer.parseInt(pageSize) ;
		System.out.println("usernName:"+usernName+";userPhone:"+userPhone+";sex:"+sex+";autoPay:"+autoPay);
		String clientUsers = clientUserService.getUserLimit("", userPhone, "", "", "", "", "", "", autoPay,pages,pagesize) ; 
				//getUser("", userPhone, sex, "", "", "", "", "", autoPay) ;
		return clientUsers ;
	}
	
	/**
	 * toAddPhoneUser:跳转到添加手机用户界面<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toAddPhoneUser")
	public ModelAndView toAddPhoneUser(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/userinfomiantaince/phoneusermanager_add");
		return mv ;
	}
	
	/**
	 * toEditPhoneUser：跳转到编辑手机用户界面<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toEditPhoneUser")
	public ModelAndView toEditPhoneUser(HttpServletRequest request){
		String clientUserId = request.getParameter("clientUserId") ;
		
		String phoneUser = clientUserService.getUser(clientUserId, "", "", "", "", "", "", "", "") ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/userinfomiantaince/phoneusermanager_edit");
		mv.addObject("phoneUser", phoneUser) ;
		return mv ;
	}
	
	
	//修改用户信息
	@RequestMapping(value="/editPhoneUser")
	@ResponseBody
	public String editPhoneUser(@RequestBody Map<String,String> map){
		String clientUserId = map.get("clientUserId") ;
		String clientUserNickName = map.get("clientUserNickName") ;
		String clientUserSex = map.get("clientUserSex") ;
		String clientUserBirthday = map.get("clientUserBirthday") ;
		String clientUserCellphone = map.get("clientUserCellphone") ;
		String clientUserSecurity = map.get("clientUserSecurity") ;
		String clientUserAutoPay = map.get("clientUserAutoPay") ;
		String allResult ="" ;
		System.err.println("clientUserId:"+clientUserId);
		System.err.println("clientUserNickName:"+clientUserNickName);
		System.err.println("clientUserSex:"+clientUserSex);
		System.err.println("clientUserBirthday:"+clientUserBirthday);
		System.err.println("clientUserCellphone:"+clientUserCellphone);
		System.err.println("clientUserSecurity:"+clientUserSecurity);
		System.err.println("clientUserAutoPay:"+clientUserAutoPay);
		String result = clientUserService.updateUser(clientUserNickName, clientUserBirthday, clientUserSex, clientUserCellphone, clientUserSecurity) ;
		JSONObject obj =JSONObject.fromObject(result) ;
		String r = (String) obj.get("result") ;
		if(r.equals("1")){
			String upPayResult = clientUserService.upUserAutoPay(clientUserAutoPay, clientUserSecurity, clientUserId) ;
			JSONObject pResult = JSONObject.fromObject(upPayResult) ;
			if(pResult.equals("1")){
				allResult = "{\"result\":\"1\"}" ;
			}else{
				allResult = "{\"result\":\"1\"}" ;
			}
		}else{
			allResult = "{\"result\":\"0\"}" ;
		}
		System.err.println("allResult:"+allResult);
		return allResult;
	}
	
	/**
	 * delPhoneUser:删除手机用户<br/>
	 * @author Administrator
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/delPhoneUser")
	@ResponseBody
	public String delPhoneUser(@RequestBody Map<String,String> map){
		String clientUserId = map.get("clientUserId") ;
		String usernName = map.get("userName") ;
		String userPhone = map.get("userPhone") ;
		String sex = map.get("sex") ;
		String autoPay = map.get("autoPay") ;
		System.out.println("usernName:"+usernName+";userPhone:"+userPhone+";sex:"+sex+";autoPay:"+autoPay);
		clientUserService.deleteUserById(clientUserId) ;
		String clientUsers = clientUserService.getUser("", userPhone, sex, "", "", "", "", "", autoPay) ;
		return clientUsers ;
	}
	
	@RequestMapping(value="/updateActiveMark")
	@ResponseBody
	public String updateActiveMark(@RequestBody Map<String,String> map){
		String userPhone = map.get("userPhone") ;
		String activeMark = map.get("activeMark") ;
		String result = "" ;
		if(activeMark.equals("enable")){
			clientUserService.upUserActiveMark(userPhone, "disable") ;
		}else{
			clientUserService.upUserActiveMark(userPhone, "enable") ;
		}
		//String result = clientUserService.getUser("", userPhone, sex, "", "", "", "", "", autoPay) ;
		return result ;
	}
	
	
	//判断手机用户是否存在
	@RequestMapping(value="/checkPhoneNumber")
	@ResponseBody
	public String hasPhoneNumber(@RequestBody Map<String,String> map){
		String clientUserCellphone = map.get("clientUserCellphone") ;
		String result = clientUserService.hasPhoneNumber(clientUserCellphone, "") ;
		System.err.println("result:"+result);
		return result ;
	}
	
}

