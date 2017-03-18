/**
 * Project Name:OnlineParking
 * File Name:ParkingManagerController.java
 * Package Name:com.yinzitech.onlineparking.controller
 * Date:2015年10月4日上午9:58:25
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller;

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

import com.yinzitech.onlineparking.core.math.veri.VeriUtil;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;
import com.yinzitech.onlineparking.service.sys.ParkingCountService;
import com.yinzitech.onlineparking.service.sys.ToolsService;
import com.yinzitech.onlineparking.utils.CheckUtils;
import com.yinzitech.onlineparking.utils.MD5andKL;
import com.yinzitech.onlineparking.utils.TimeTools;

import net.sf.json.JSONObject;

/**
 * ClassName:ParkingManagerController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月4日 上午9:58:25 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkingManagerController {
		
	@Autowired 
	ParkingManagerService pmService ;
	
	@Autowired
	ParkingInfoService pInfoService ;
	
	@Autowired
	ParkingCountService pcs;
	
	@Autowired
	ToolsService toolsservice;
	
	@Autowired 
	VeriUtil veriUtil; //手机验证码
	
	//========================注册=================================
	/**
	 * parkingManagerSignUp:用户注册界面
	 * @author xumingyue
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/onlineparking/parkingManagerSignUp",method=RequestMethod.POST)
	@ResponseBody
	public String parkingManagerSignUp(@RequestBody Map<String,String> map,HttpSession session){
		String parkingManagerPhone = map.get("parkingManagerPhone") ;
		String parkingManagerPsd = map.get("parkingManagerPsd") ;
		session.setAttribute("loginname", parkingManagerPhone);
		System.err.println("注册时将登录名(手机号)loginname:"+parkingManagerPhone);
		//密码加密
		String md5code = MD5andKL.MD5(parkingManagerPsd) ;//MD5码
		String KLPsw = MD5andKL.KL(md5code) ;//加密的密码
		System.err.println("注册KLStr:"+KLPsw);
		
		String result = pmService.parkingManagerSignUp(parkingManagerPhone, KLPsw,"","") ;
		
		//根据电话号码将用户id取出 并放到session中
		String userManagerInfo = pmService.getParkingManagerByParkingManagerPhone(parkingManagerPhone) ;
		String parkingManagerId = (String) JSONObject.fromObject(userManagerInfo).get("parkingManagerId"); // 注册过程中放回 data:XXXXXXXXXXX
		session.setAttribute("uID", parkingManagerId);
	
		return result;
	}
	
	
	/**
	 * hasPhoneNumber:验证手机号是否已经注册
	 * @author xumingyue
	 * @param map
	 * @param session
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/onlineparking/hasPhoneNumber",method=RequestMethod.POST)
	@ResponseBody
	public String hasPhoneNumber(@RequestBody Map<String,String> map,HttpSession session){
		String parkingManagerPhone = map.get("parkingManagerPhone") ;
		String result = pmService.hasPhoneNumber(parkingManagerPhone) ;
		return result;
	}
	@RequestMapping(value="/hasPhoneNumber",method=RequestMethod.POST)
	@ResponseBody
	public String hasPhoneNumbers(@RequestBody Map<String,String> map,HttpSession session){
		String parkingManagerPhone = map.get("parkingManagerPhone") ;
		String result = pmService.hasPhoneNumber(parkingManagerPhone) ;
		return result;
	}
	
	
	
	
	/**
	 * toIndex:成功登录后的主界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/index")
	public ModelAndView toIndex(HttpServletRequest request,HttpSession session){
		String parkingManagerPhone = (String)session.getAttribute("loginname") ; //电话号码
		//System.err.println("phone:"+phone);
		System.err.println("index方法中获取session中的loginname:"+parkingManagerPhone);
		//String parkingManagerPhone = request.getParameter("parkingManagerPhone") ; //登录时的停车场管理员用户名 即电话号码
		session.setAttribute("loginname", parkingManagerPhone);
		
		//根据电话号码将用户id取出 并放到session中
		String userManagerInfo = pmService.getParkingManagerByParkingManagerPhone(parkingManagerPhone) ;
		System.err.println("userManagerInfo:"+userManagerInfo);
		
		 JSONObject userData = JSONObject.fromObject(userManagerInfo);
		 String parkingInfoId ="" ;
		 String parkName ="" ;
		 if(userData!=null){
			 JSONObject userDataObject =userData.getJSONObject("datas") ;
			 String parkingManagerId = (String) userDataObject.get("parkingManagerId") ;
			 parkingInfoId = (String) userDataObject.get("parkingInfoId") ;
			 parkName = pInfoService.getParkingInfoById(parkingInfoId) ;
			 session.setAttribute("uID", parkingManagerId);
		 }
		
//		String parkingManagerId = (String) JSONObject.fromObject(userManagerInfo).getJSONObject("datas").get("parkingManagerId"); // 获取用户id
//		session.setAttribute("uID", parkingManagerId);
		
		//通过用户ID获取停车场 如果停车场id为空  关联停车场
		//String parkingInfoId = (String) JSONObject.fromObject(userManagerInfo).getJSONObject("datas").get("parkingInfoId"); // 获取停车场id
		//通过停车场id 获取停车场信息
		
		if(parkingInfoId!=null&&!(parkingInfoId.equals(""))){ //如果用户名 已经关联停车场 即停车场id不为空 则通过id获取停车场名称 放在session中  在界面中获取
		JSONObject obj = JSONObject.fromObject(parkName); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String pName =(String) obj1.get("parkingInfoName"); //获取停车场名称
		session.setAttribute("parkingInfoName", pName);}
		
		
		ModelAndView mv = new ModelAndView() ;
		if(parkingInfoId==null||parkingInfoId.equals("")){
			mv.addObject("checkParkInfoId", "notExsit") ;	
		}
		mv.setViewName("system/admin/index");
		mv.addObject("parkName", parkName) ;
		return mv;
	}
	
	/**
	 * toInsertInfoId:跳转到关联停车场界面
	 *
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toInsertInfoId")
	public ModelAndView toInsertInfoId(HttpServletRequest request){
		
		String allParkInfo = pInfoService.getParkingInfo() ;
		//查询所有停车场
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("system/admin/relationpark");
		mv.addObject("allParkInfo", allParkInfo) ;
		return mv ;
	}
	
	
	@RequestMapping(value="/relativPark")
	@ResponseBody
	public String relativPark(@RequestBody Map<String,String> map,HttpServletRequest request){
		//String uID = request.getParameter("uID") ;//获取用户id
		String parkingManagerPhone = map.get("userID") ; //获取电话号码
		String parkingInfoId = map.get("parkInfoId") ;
		String result = pmService.updtaParkingInfoId(parkingManagerPhone, parkingInfoId); //通过uID将停车场id 填入数据库
		return result ;
	}
	
	
	/**
	 * 进入tab标签(界面中间内容区域)
	 * @author Xumingyue
	 * @return
	 */
	@RequestMapping(value="/tab")
	public String tab(){
		return "system/admin/tab";
	}
	
	/**
	 * 进入首页后的默认页面(界面中间内容区域)
	 * @author Xumingyue
	 * @return
	 */
	@RequestMapping(value="/login_default")
	public ModelAndView defaultPage(HttpServletRequest request){
		
		String uID=  request.getParameter("uID") ; //(1)首先获取UID  uID存在seesion中 
		 String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkName = pInfoService.getParkingInfoById(parkingInfoId) ;
		
		
		//根据当前停车场ID获取默认首页内的全部数据
		String indexData = pcs.getParkingCount(parkingInfoId, TimeTools.getStartMouthDay(),TimeTools.getTimesnight(), TimeTools.getCurrentTime(), 10);
		
		//String parkName = pInfoService.getParkingInfoById("1") ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("system/admin/default");
		mv.addObject("parkName", parkName) ;
		mv.addObject("indexData",indexData);
		mv.addObject("seviceDate",toolsservice.getSysTime());
		return mv;
	}
	
	
	//============================登录========================
	
	/**
	 * login:登录
	 * @author xumingyue
	 * @param map
	 * @param session
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/onlineparking/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody Map<String,String> map,HttpSession session){
		String parkingManagerPhone = map.get("parkingManagerPhone") ;
		String parkingManagerPsd = map.get("parkingManagerPsd") ;
		session.setAttribute("loginname", parkingManagerPhone);
		
		//密码加密
		//密码加密
		String md5code = MD5andKL.MD5(parkingManagerPsd) ;//MD5码
		String KLPsw = MD5andKL.KL(md5code) ;//加密的密码
		System.err.println("登录KLStr:"+parkingManagerPhone+";psw:"+parkingManagerPsd);
		
		String result = pmService.login(parkingManagerPhone, KLPsw) ;
		
		JSONObject or = JSONObject.fromObject(result);
		String  r =  (String) or.get("result") ;
		if(r.equals("0")){ //如果查询失败  不可以登录 直接返回提示信息
			
			return result ;
		}else{
			//根据电话号码将用户id取出 并放到session中
			String userManagerInfo = pmService.getParkingManagerByParkingManagerPhone(parkingManagerPhone) ;
			JSONObject obj = JSONObject.fromObject(userManagerInfo); // 集合转为json
			JSONObject obj1 = obj.getJSONObject("datas");
			String parkingManagerId =(String) obj1.get("parkingManagerId");
			
		//String parkingManagerId = (String)JSONObject.fromObject(userManagerInfo).getJSONObject("datas").get("parkingManagerId"); // 集合转为json
			session.setAttribute("uID", parkingManagerId);
		}
	
		return result;
	}
	
	              
	
	
	
	
	/**
	 * goEditU: 跳转到修改用户页面 ，并通过电话号码获取用户信息
	 * @author Xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/goEditU")
	public ModelAndView goEditU(HttpServletRequest request){
		//String jsonStr = parkUserService.selectParkUser("1") ;\
		String parkingManagerPhone = request.getParameter("userID") ;//userID即为 用户登录是的登录名称  --->手机号
		String uID = request.getParameter("uID") ; //获取用户id
		
		//通过用户id获取用户信息
		//根据电话号码将用户id取出 并放到session中
		String userManagerInfo = pmService.getParkingManagerByParkingManagerId(uID) ;
		JSONObject obj = JSONObject.fromObject(userManagerInfo);
		JSONObject obj1 =  obj.getJSONObject("datas");
		String parkingInfoId = (String) obj1.get("parkingInfoId");
		
		
		String parkName = pInfoService.getParkingInfoById(parkingInfoId) ;
		String user = pmService.getParkingManagerByParkingManagerPhone(parkingManagerPhone);
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("system/user/user_edit");
		mv.addObject("parkName",parkName) ;
		mv.addObject("user",user) ;
		return mv;
	}
    
	
	
	/**
	 * updateUserPhone:跳转到更换手机号界面
	 * @author xumingyue
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/updateUserPhone")
	public ModelAndView toUpdateUserPhone(HttpServletRequest request){
		//String parkingManagerPhone =  request.getParameter("userID") ;
		String uID = request.getParameter("uID") ; //获取用户id
		String user = pmService.getParkingManagerByParkingManagerId(uID) ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("system/user/edit_phone");
		mv.addObject("user",user) ;
		return mv;
	}
	
	
	/**
	 * modiUserPhone:更新手机号
	 * @author xumingyue
	 * @param map
	 * @param session
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/modiUserPhone",method=RequestMethod.POST)
	@ResponseBody
	public String modiUserPhone(@RequestBody Map<String,String> map,HttpSession session){
		String parkingManagerId = map.get("parkingManagerId") ;
		String parkingManagerPhone = map.get("parkingManagerPhone") ;
		String verifycode = map.get("verifycode") ;
	
		String checkResult = CheckUtils.checkIdentifyingCode(verifycode) ;
		JSONObject obj = JSONObject.fromObject(checkResult);
		String  r =  (String) obj.get("result") ;
		if(r.equals("0")){
			return checkResult ;
		}else{
			session.setAttribute("loginname", parkingManagerPhone);
			String result = pmService.updateParkingManagerPhone(parkingManagerId, parkingManagerPhone) ;
			return result;
		}
		
	}
	
	
	/**
	 * updateUserPass:跳转到修改用户密码
	 *
	 * @author xumingyue
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/updateUserPass")
	public ModelAndView updateUserPass(HttpServletRequest request){
		//String parkingManagerPhone = request.getParameter("userID") ;//userID即为 用户登录是的登录名称  --->手机号
		String uID =  request.getParameter("uID") ;
		String user = pmService.getParkingManagerByParkingManagerId(uID) ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("system/user/edit_pass");
		mv.addObject("user",user) ;
		return mv;
	}
	
	
	/**
	 * modieUserPass:更改用户密码
	 * @author xumingyue
	 * @param map
	 * @param session
	 * @return
	 * @since JDK 1.8u60
	 */
	
	
	//=================================密码找回============
	@RequestMapping(value="/onlineparking/updateParkingManagerPsd",method=RequestMethod.POST)
	@ResponseBody
	public String updateParkingManagerPsd(@RequestBody Map<String,String> map,HttpSession session){
		String parkingManagerPhone = map.get("parkingManagerPhone") ;
		String parkingManagerPsd = map.get("parkingManagerPsd") ;
		String md5NewPassWord = MD5andKL.KL(MD5andKL.MD5(parkingManagerPsd)) ;//将新密码加密
		String result = pmService.updateParkingManagerPsd(parkingManagerPhone, md5NewPassWord) ;
		return result;
	}
	

	//=================更改用户密码======================
	@RequestMapping(value="/updateParkingManagerPsd",method=RequestMethod.POST)
	@ResponseBody
	public String updateParkingManagerPsds(@RequestBody Map<String,String> map,HttpSession session){
		String parkingManagerPhone = map.get("parkingManagerPhone") ;
		String parkingManagerPsd = map.get("parkingManagerPsd") ;
		String myParkingManagerPsd = map.get("myParkingManagerPsd") ;//前台输入的原始密码
		System.err.println("********"+parkingManagerPhone+"*"+parkingManagerPsd+"*"+myParkingManagerPsd);
		
		//将前台输入的新密码.老密码 加密
		String md5NewPassWord = MD5andKL.KL(MD5andKL.MD5(parkingManagerPsd)) ;
		String md5MyPassWord = MD5andKL.KL(MD5andKL.MD5(myParkingManagerPsd)) ;
		
		String userManagerInfo = pmService.getParkingManagerByParkingManagerPhone(parkingManagerPhone) ;
		//获取数据库中密码
		JSONObject obj = JSONObject.fromObject(userManagerInfo) ;
		JSONObject o = obj.getJSONObject("datas") ;
		String passWord = (String) o.get("parkingManagerPsd") ;//获取数据库中加密的密码
		
		String md5OldPassWord = MD5andKL.JM(passWord);//解密 获取数据库中的MD5码
		System.err.println("数据库中的md5OldPassWord:"+md5OldPassWord+";md5NewPassWord:"+md5NewPassWord);
		
		if(!md5MyPassWord.equals(passWord)){
			System.err.println("输入的原始密码不正确");
			return "{\"result\":\"2\"}" ;//输入的原始密码不正确
		}
		
		if(md5NewPassWord.equals(md5MyPassWord)){
			System.err.println("新密码和原始密码一致 不可修改");
			return "{\"result\":\"3\"}" ;//新密码和原始密码一致 不可修改
		}
		
		String result = pmService.updateParkingManagerPsd(parkingManagerPhone, md5NewPassWord) ;
		return result;
	}
	
	/**
	 * getCode:通过手机号获取验证码
	 * @author xumingyue
	 * @param map
	 * @param session
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/onlineparking/getCode",method=RequestMethod.POST)
	@ResponseBody
	public String getCode(@RequestBody Map<String,String> map,HttpSession session){
		String clientUserCellphone = map.get("telNumber") ;
		String result = veriUtil.getVeriCode(clientUserCellphone);
		System.err.println("result:"+result);
		return result;
	}
	
	/**
	 * checkPCode:用户名 +验证码是否正确
	 * @author Administrator
	 * @param map
	 * @param session
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/onlineparking/checkPCode",method=RequestMethod.POST)
	@ResponseBody
	public String checkPCode(@RequestBody Map<String,String> map,HttpSession session){
	//	String parkingManagerPhone = map.get("parkingManagerPhone") ;
		String verifycode = map.get("verifycode") ; //前台输入的验证码
		String result = CheckUtils.checkIdentifyingCode(verifycode) ; //后台生成的验证码
		return result;
	}
	
	/**
	 * 
	 * getSession:获取session. <br/>
	 * @author Administrator
	 * @param request
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/getSession",method=RequestMethod.POST)
	@ResponseBody
	public String getSession(HttpServletRequest request){
		HttpSession session = request.getSession() ;
		String sessionValue = (String) session.getAttribute("loginname") ;
		System.err.println("sessionValue:"+sessionValue);
		return "{\"result\":\""+sessionValue+"\"}" ;
	}
	
}

