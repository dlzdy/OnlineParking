/**
 * Project Name:OnlineParking
 * File Name:CheckUtils.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月8日下午4:21:44
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import com.yinzitech.onlineparking.entity.common.ResultObject;

/**
 * ClassName:CheckUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月8日 下午4:21:44 <br/>
 * 
 * @author Kevin
 * @version
 * @since JDK 1.8
 * @see
 */
public class CheckUtils {
	public static String getIdentifyingCode() {
		return "22345";
	}

	public static String checkIdentifyingCode(String str) {
		if (str.equals("22345")) {
			return ResultObject.obj2JsonResult("1", "登录成功", "");
		} else {
			return ResultObject.obj2JsonResult("0", "登录失败", "");

		}
	}

}
