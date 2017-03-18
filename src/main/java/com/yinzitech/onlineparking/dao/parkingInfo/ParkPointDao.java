package com.yinzitech.onlineparking.dao.parkingInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.parkingInfo.ParkPoint;
 

/**
 * ClassName:UserDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date:2016年11月7日15:43:48 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */

public interface ParkPointDao {
	// 查询所有
	public List<ParkPoint> getPark(@Param("parkName")String parkName);

	public List<ParkPoint> getParkAll();
	
	// 根据id查询
	public List<ParkPoint> getParkById(String parkId);
	
	public boolean addPark(ParkPoint park);
	
	public boolean updatePark(ParkPoint park);
	

}
