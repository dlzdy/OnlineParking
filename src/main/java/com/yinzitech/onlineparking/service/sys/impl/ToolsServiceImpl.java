/**
 * Project Name:OnlineParking
 * File Name:ToolsServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.sys.impl
 * Date:2015年11月25日下午6:09:19
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys.impl;

import com.yinzitech.onlineparking.service.sys.ToolsService;
import com.yinzitech.onlineparking.utils.TimeTools;

/**
 * ClassName:ToolsServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月25日 下午6:09:19 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ToolsServiceImpl implements ToolsService {

	@Override
	public String getSysTime() {

		return TimeTools.getCurrentTime();
	}

}
