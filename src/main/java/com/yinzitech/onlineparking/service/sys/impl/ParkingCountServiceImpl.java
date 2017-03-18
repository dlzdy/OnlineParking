/**
 * Project Name:OnlineParking
 * File Name:ParkingCountServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.sys.impl
 * Date:2015年11月24日下午5:08:43
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.dao.msg.MessageDao;
import com.yinzitech.onlineparking.dao.sys.ParkingCountDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.msg.Message;
import com.yinzitech.onlineparking.entity.sys.ParkingCount;
import com.yinzitech.onlineparking.service.sys.ParkingCountService;

/**
 * ClassName:ParkingCountServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月24日 下午5:08:43 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ParkingCountServiceImpl implements ParkingCountService {
	@Autowired
	ParkingCountDao prd;
	@Autowired
	MessageDao messageDao;

	@Override
	public String getParkingCount(String parkingId, String mouthTime, String dayTime, String endTime, int messageSize) {
		String json = "";
		ParkingCount pc = prd.getParkCount(parkingId, mouthTime, dayTime, endTime);
		int i = 0;
		if (pc != null) {
			List<Message> list = messageDao.selectHistory();
			List<Message> mes = new ArrayList<>();
			if (list.size() > 0) {
				for (Message message : list) {
					i++;
					mes.add(message);
					if (i == messageSize) {
						pc.setMassage(mes);
						return ResultObject.obj2JsonResult("1", "统计查询成功", pc);
					}
				}

			}

			json = ResultObject.obj2JsonResult("1", "统计查询成功", pc);
		} else {
			json = ResultResponse.obj2JsonResult("0", "统计查询失败", "");
		}

		return json;
	}

}
