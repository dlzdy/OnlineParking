/**
 * Project Name:OnlineParking
 * File Name:WithDrawsOrderMaintanceController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.ordermaintenance
 * Date:2015年10月19日下午4:59:47
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.ordermaintenance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName:WithDrawsOrderMaintanceController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月19日 下午4:59:47 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class WithDrawsOrderMaintanceController {
	
	@RequestMapping(value="/toWithDrawsOrder")
	public ModelAndView toWithDrawsOrder(){
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/ordermaintenance/withdrawsordermaintance_list"); 
		return mv ;
	}
}

