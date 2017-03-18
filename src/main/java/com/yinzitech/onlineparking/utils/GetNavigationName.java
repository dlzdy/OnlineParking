/**
 * Project Name:OnlineParking
 * File Name:GetNavigationName.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月13日下午6:08:03
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;
/**
 * ClassName:GetNavigationName <br/>
 * Function: TODO ADD FUNCTION. <br/>
 *  通过标记获取导航名称
 * Date:     2015年10月13日 下午6:08:03 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
public class GetNavigationName {

	//通过传入的标记 获得一级导航名称
	public static String getFirstName(String M){
		 String firstName = "" ; //一级目录
		 switch(M){
		 case "1":
			 firstName = "员工管理" ;
			 break ;
		 case "2":
			 firstName = "停车场管理" ;
			 break ;
		 case "3":
			 firstName = "停车场订单记录" ;
			 break ;
		 case "4":
			 firstName = "财务管理" ;
			 break ;
		 case "5":
			 firstName = "通知公告管理" ;
			 break ;
		 }
		
		return firstName ;
	}
	
	//通过传入的标记 获得二级导航名称
	public static String getSecondName(String m){

		String secondName = "" ;//二级目录
		 switch(m)
		 {
		 case "1":
		   secondName = "财务人员管理" ; 
		   break;
		 case "2":
			secondName = "登录记录" ; 
		   break;
		 case "3":
			 secondName = "提现记录" ; 
			 break;
		 case "4":
			 secondName = "收费员管理" ; 
			 break;
		 case "5":
			 secondName = "收费员交接班记录" ; 
			 break;
		 case "6":
			 secondName = "收费员流水" ; 
			 break;
		 case "7":
			 secondName = "停车场信息" ; 
			 break;
		 case "8":
			 secondName = "收费表单" ; 
			 break;
		 case "9":
			 secondName = "设备管理" ; 
			 break;
		 case "10":
			 secondName = "收款卡号设置/支付设置" ; 
			 break;
		 case "11":
			 secondName = "停车场订单记录" ; 
			 break;
		 case "12":
			 secondName = "财务报表" ; 
			 break;
		 case "13":
			 secondName = "提现" ; 
			 break;
		 case "14":
			 secondName = "通知公告管理" ; 
			 break;
		 case "15":
			 secondName = "停车场信息维护" ; 
			 break;
		 case "16":
			 secondName = "支付订单维护" ; 
			 break;
		 case "17":
			 secondName = "banner图替换" ; 
			 break;
		 }
		
		 return secondName ;
	}
	
}

