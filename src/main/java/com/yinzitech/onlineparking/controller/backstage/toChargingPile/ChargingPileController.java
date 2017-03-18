/**
 * Project Name:OnlineParking
 * File Name:ChargingPileController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.toChargingPile
 * Date:2016年5月26日下午3:38:39
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.toChargingPile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName:ChargingPileController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年5月26日 下午3:38:39 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ChargingPileController {
	
	
	@RequestMapping(value="/toChargingPile")
	public ModelAndView toChargingPile(){
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/chargingpile/chargingpile_list");
		return mv ;
	}
}

