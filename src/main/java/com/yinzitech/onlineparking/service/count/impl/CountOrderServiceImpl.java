/**
 * Project Name:OnlineParking
 * File Name:CountOrderServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.count.impl
 * Date:2015年11月11日上午11:22:33
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.count.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.dao.count.CountOrderDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.service.count.CountOrderService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:CountOrderServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月11日 上午11:22:33 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class CountOrderServiceImpl implements CountOrderService {
	@Autowired
	CountOrderDao countOrderDao;

	/**
	 * 
	 * TODO 停车场订单统计查询（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.count.CountOrderService#getCountOrder(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public String getCountOrder(String key, String payState, String payCash, String numberState, String parkingInfoId,
			String startTime, String endTime, int pageNumber, int pageSize) {
		String json = "";
		if (key.equals("day")) {
			PageHelper.startPage(pageNumber, pageSize);
			countOrderDao.getCountOrderByDay(payState, payCash, numberState, parkingInfoId, startTime, endTime);
			Page s = PageHelper.endPage();
			json = ResultObject.obj2JsonResult("1", "查询统计日停车订单成功", s);
		} else if (key.equals("mouth")) {
			PageHelper.startPage(pageNumber, pageSize);
			countOrderDao.getCountOrderByMonth(payState, payCash, numberState, parkingInfoId, startTime, endTime);
			Page s = PageHelper.endPage();
			json = ResultObject.obj2JsonResult("1", "查询统计月停车订单成功", s);
		} else if (key.equals("year")) {
			PageHelper.startPage(pageNumber, pageSize);
			countOrderDao.getCountOrderByYear(payState, payCash, numberState, parkingInfoId, startTime, endTime);
			Page s = PageHelper.endPage();
			json = ResultObject.obj2JsonResult("1", "查询统计年停车订单成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "参数错误", "");
		}
		System.out.println(json);
		return json;
	}

}
