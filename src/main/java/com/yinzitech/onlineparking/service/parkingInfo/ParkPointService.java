package com.yinzitech.onlineparking.service.parkingInfo;

import com.yinzitech.onlineparking.entity.parkingInfo.ParkPoint;

public interface ParkPointService {
	// 查询所有
	public String getParkAll();

	// 根据id查询
	public String getParkById(String parkId);

	/**
	 * 添加坐标点
	 * 
	 * @param park
	 * @return
	 */
	public String addPark(ParkPoint park);

}
