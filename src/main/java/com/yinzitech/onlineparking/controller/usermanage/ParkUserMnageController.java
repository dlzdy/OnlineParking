/**
 * Project Name:onlineParking
 * File Name:ParkUserMnageController.java
 * Package Name:com.yz.ParkDemo.controller.user
 * Date:2015年9月25日下午4:52:28
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.usermanage;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName:ParkUserMnageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年9月25日 下午4:52:28 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkUserMnageController {
	
	/**
	 * userInfoMnage:用户信息维护
	 * @author Xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	
	@RequestMapping(value="/toUserMnage")
	public ModelAndView toUserMnage(){
		String json =  "{\"result\":\"success\",\"datas\":{\"parkName\":\"惠婷车\"}}" ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/user/usermnage");
		mv.addObject("json", json) ;
		return mv ;
	}
	
	/**
	 * saveUserInfo:保存用户信息
	 * @author xumingyue
	 * @param map
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/saveUserInfo",method=RequestMethod.POST)
	@ResponseBody
	public String saveUserInfo(@RequestBody Map<String,String> map){
		//String emain = map.get("email") ;
		String json =  "{\"result\":\"success\",\"datas\":{\"parkName\":\"惠婷车\"}}" ;
		return json ;
	}
	
	
	/**
	 * 
	 * toUserMnage:跳转到修改密码界面
	 * 修改密码
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toUserpwModi")
	public ModelAndView toUserpwModi(){
		
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/user/userpwmodi");
		return mv ;
	}
	
	/**
	 * updateUserPW:修改密码
	 *
	 * @author xumingyue
	 * @param newPassWord
	 * @param repeatPassWord
	 * @return
	 * @throws Exception
	 * @since JDK 1.8u60
	 */
	
	
	
	@RequestMapping(value="/updateUserPW",method=RequestMethod.POST)
	@ResponseBody 
	public String updateUserPW(@RequestBody Map<String,String> map ) throws Exception{
		String newpassword = map.get("newPassWord");
		//String repeatPassWord = map.get("repeatPassWord") ;
		System.out.println(newpassword);
		System.out.println("1111111111111");
		String str = "{\"result\":\"success\",\"datas\":{\"age\":\"50\"}}";
	//	ObjectMapper m = new ObjectMapper() ;
		//m.writeValueAsString(str) ;
		System.out.println("222222222222");
		return str ;
	}
}

