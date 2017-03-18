package com.yinzitech.onlineparking.service.parkingInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.dao.parkingInfo.ParkPointDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.parkingInfo.ParkPoint;
import com.yinzitech.onlineparking.service.parkingInfo.ParkPointService;

public class ParkPointServiceImpl implements ParkPointService {

	@Autowired
	ParkPointDao parkDao;

	@Override
	public String getParkById(String parkId) {
		String result = "查询失败";
		String info = "0";
		List<ParkPoint> list = null;
		List<ParkPoint> p = parkDao.getParkById(parkId);
		if (p != null) {
			result = "查询成功";
			info = "1";
			list = p;
		}
		// TODO Auto-generated method stub
		return ResultObjectList.obj2JsonResult(result, info, list);
	}

	@Override
	public String getParkAll() {
		String result = "查询失败";
		String info = "0";
		List<ParkPoint> list = null;
		List<ParkPoint> p = parkDao.getParkAll();
		if (p != null) {
			result = "查询成功";
			info = "1";
			list = p;
		}
		// TODO Auto-generated method stub
		return ResultObjectList.obj2JsonResult(result, info, list);
	}

	@Override
	public String addPark(ParkPoint park) {
		String result = "新增失败";
		String info = "0";
		boolean p = parkDao.addPark(park);
		if (p) {
			result = "新增成功";
			info = "1";
		}
		return ResultObject.obj2JsonResult(result, info, "");
	}

}
