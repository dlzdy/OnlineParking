/**
 * Project Name:OnlineParking
 * File Name:NFDFlightDataTaskListener.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月29日下午5:17:50
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.yinzitech.onlineparking.utils.TimerManager;

/**
 * ClassName:NFDFlightDataTaskListener <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月29日 下午5:17:50 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class NFDFlightDataTaskListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		new TimerManager();
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

}
