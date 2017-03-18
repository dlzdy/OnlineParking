/**
 * Project Name:OnlineParking
 * File Name:NFDFlightDataTimerTask.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月29日下午5:16:24
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import java.util.TimerTask;

import com.yinzitech.onlineparking.core.context.springCore.SpringApplicationContext;
import com.yinzitech.onlineparking.core.math.veri.VeriUtil;
import com.yinzitech.onlineparking.service.handsetSys.HandsetSysService;

/**
 * ClassName:NFDFlightDataTimerTask <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月29日 下午5:16:24 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class NFDFlightDataTimerTask extends TimerTask {
	HandsetSysService handsetSysService;
	VeriUtil veriUtil;

	@Override
	public void run() {
		try {
			handsetSysService = (HandsetSysService) SpringApplicationContext.getBean("handsetSysService");
			handsetSysService.insertHandesetOrder();
			System.out.println("统计每日手持管理员订单成功");
			veriUtil = (VeriUtil) SpringApplicationContext.getBean("veriUtil");
			veriUtil.deleteCode();
			System.out.println("定时任务");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
