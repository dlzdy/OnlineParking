/**
 * Project Name:OnlineParking
 * File Name:ParkingCountDao.java
 * Package Name:ParkingCount
 * Date:2015年11月24日下午5:10:22
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.sys;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yinzitech.onlineparking.entity.sys.ParkingCount;

/**
 * ClassName:ParkingCountDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月24日 下午5:10:22 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ParkingCountDao {

	@Select("SELECT SUM(parking_order_cost) money, COUNT(*) car, "
			+ "(SELECT COUNT(*) c FROM handset_manager WHERE parking_info_id = #{parkingId}) handManager, "
			+ "(SELECT COUNT(*) c FROM parking_manager WHERE parking_info_id = #{parkingId}) parkingManager,"
			+ "(SELECT parking_info_parking_spaces FROM parking_info WHERE parking_info_id = #{parkingId} ) spaces,"
			+ "(SELECT parking_info_rest_parking_spaces FROM parking_info WHERE parking_info_id = #{parkingId} ) lastSpaces,"
			+ "(SELECT COUNT(*) c FROM parking_order WHERE parking_order_parking_info_id = #{parkingId} AND parking_order_car_number_state = '1' AND parking_order_create_time BETWEEN #{dayTime} AND #{endTime} ) user,"
			+ "(SELECT COUNT(*) c FROM parking_order WHERE parking_order_parking_info_id = #{parkingId} AND parking_order_car_number_state = '0' AND parking_order_create_time BETWEEN #{dayTime} AND #{endTime} ) nullUser,"
			+ "(SELECT COUNT(*) c FROM parking_order WHERE parking_order_parking_info_id = #{parkingId} AND parking_order_create_time BETWEEN #{mouthTime} AND #{endTime} ) mouthOrder,"
			+ "(SELECT COUNT(*) c FROM parking_order WHERE parking_order_parking_info_id = #{parkingId} AND parking_order_create_time BETWEEN #{dayTime} AND #{endTime} ) dayOrder "
			+ "FROM parking_order WHERE parking_order_parking_info_id = #{parkingId} AND parking_order_create_time BETWEEN #{mouthTime} AND #{endTime}")
	public ParkingCount getParkCount(@Param("parkingId") String parkingId, @Param("mouthTime") String mouthTime,
			@Param("dayTime") String dayTime, @Param("endTime") String endTime);

}
