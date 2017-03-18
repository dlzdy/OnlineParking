/**
 * Project Name:OnlineParking
 * File Name:ParkingInfoDao.java
 * Package Name:com.yinzitech.onlineparking.dao.parkingInfo
 * Date:2015年10月4日上午6:21:48
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.parkingInfo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.parkingInfo.ParkingInfo;

/**
 * ClassName:ParkingInfoDao <br/>
 * Function: 停车场基本信息Dao层. <br/>
 * Date: 2015年10月4日 上午6:21:48 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ParkingInfoDao {
	/**
	 * @Title: insertParkingInfo:(新增停车场基本数据). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @param parkingInfoName
	 * @param parkingInfoAddress
	 * @param parkingInfoLongitude
	 * @param parkingInfoLatitude
	 * @param parkingInfoParkingSpaces
	 * @param parkingInfoRestParkingSpaces
	 * @param parkingInfoState
	 * @param parkingInfoCreateTime
	 * @param parkingInfoCreateManagerType
	 * @param parkingInfoCreateManagerId
	 * @return
	 * @since JDK 1.8
	 */
	@Insert("insert into parking_info(parking_info_id,parking_info_name,parking_info_address,parking_info_longitude,parking_info_latitude,parking_info_parking_spaces,parking_info_rest_parking_spaces,parking_info_state,parking_info_create_time,parking_info_create_manager_type,parking_info_create_manager_id)values(#{parkingInfoId},#{parkingInfoName},#{parkingInfoAddress},#{parkingInfoLongitude},#{parkingInfoLatitude},#{parkingInfoParkingSpaces},#{parkingInfoRestParkingSpaces},#{parkingInfoState},#{parkingInfoCreateTime},#{parkingInfoCreateManagerType},#{parkingInfoCreateManagerId})")
	public int insertParkingInfo(@Param("parkingInfoId") String parkingInfoId,
			@Param("parkingInfoName") String parkingInfoName, @Param("parkingInfoAddress") String parkingInfoAddress,
			@Param("parkingInfoLongitude") String parkingInfoLongitude,
			@Param("parkingInfoLatitude") String parkingInfoLatitude,
			@Param("parkingInfoParkingSpaces") String parkingInfoParkingSpaces,
			@Param("parkingInfoRestParkingSpaces") String parkingInfoRestParkingSpaces,
			@Param("parkingInfoState") String parkingInfoState,
			@Param("parkingInfoCreateTime") String parkingInfoCreateTime,
			@Param("parkingInfoCreateManagerType") String parkingInfoCreateManagerType,
			@Param("parkingInfoCreateManagerId") String parkingInfoCreateManagerId);

	/**
	 * 
	 * @Title: updateParkingInfo:(更新停车场基本数据). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @param parkingInfoName
	 * @param parkingInfoAddress
	 * @param parkingInfoLongitude
	 * @param parkingInfoLatitude
	 * @param parkingInfoParkingSpaces
	 * @param parkingInfoRestParkingSpaces
	 * @param parkingInfoState
	 * @param parkingInfoCreateTime
	 * @param parkingInfoCreateManagerType
	 * @param parkingInfoCreateManagerId
	 * @return
	 * @since JDK 1.8
	 */
	@Update("update parking_info set parking_info_name = #{parkingInfoName}, parking_info_address = #{parkingInfoAddress}, parking_info_longitude = #{parkingInfoLongitude}, parking_info_latitude = #{parkingInfoLatitude}, parking_info_parking_spaces = #{parkingInfoParkingSpaces}, parking_info_rest_parking_spaces = #{parkingInfoRestParkingSpaces}, parking_info_state = #{parkingInfoState}, parking_info_create_manager_type = #{parkingInfoCreateManagerType}, parking_info_create_manager_id = #{parkingInfoCreateManagerId} where (parking_info_id =#{parkingInfoId});")
	public int updateParkingInfo(@Param("parkingInfoId") String parkingInfoId,
			@Param("parkingInfoName") String parkingInfoName, @Param("parkingInfoAddress") String parkingInfoAddress,
			@Param("parkingInfoLongitude") String parkingInfoLongitude,
			@Param("parkingInfoLatitude") String parkingInfoLatitude,
			@Param("parkingInfoParkingSpaces") String parkingInfoParkingSpaces,
			@Param("parkingInfoRestParkingSpaces") String parkingInfoRestParkingSpaces,
			@Param("parkingInfoState") String parkingInfoState,
			@Param("parkingInfoCreateManagerType") String parkingInfoCreateManagerType,
			@Param("parkingInfoCreateManagerId") String parkingInfoCreateManagerId);

	/**
	 * 
	 * @Title: updateParkingInfoState:(更新停车场基本数据parkingInfoState字段). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @param parkingInfoState
	 * @return
	 * @since JDK 1.8
	 */
	@Update("update parking_info set parking_info_state=#{parkingInfoState} where parking_info_id=#{parkingInfoId}")
	public int updateParkingInfoState(@Param("parkingInfoId") String parkingInfoId,
			@Param("parkingInfoState") String parkingInfoState);

	/**
	 * 
	 * updateParkingSpaces:(车位信息更新). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @param parkingInfoRestParkingSpaces
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE parking_info SET parking_info_rest_parking_spaces= #{parkingInfoRestParkingSpaces} WHERE (parking_info_id= #{parkingInfoId})")
	public int updateParkingSpaces(@Param("parkingInfoId") String parkingInfoId,
			@Param("parkingInfoRestParkingSpaces") String parkingInfoRestParkingSpaces);

	/**
	 * 
	 * @Title: getParkingInfoById:(通过停车场id查询停车场详细信息). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	@Select("select parking_info_id parkingInfoId,parking_info_address parkingInfoAddress, parking_info_name parkingInfoName, parking_info_longitude parkingInfoLongitude, parking_info_latitude parkingInfoLatitude, parking_info_parking_spaces parkingInfoParkingSpaces, parking_info_rest_parking_spaces parkingInfoRestParkingSpaces, parking_info_state parkingInfoState, parking_info_create_time parkingInfoCreateTime, parking_info_create_manager_type parkingInfoCreateManagerType, parking_info_create_manager_id parkingInfoCreateManagerId from parking_info where parking_info_id = #{parkingInfoId} ")
	public ParkingInfo getParkingInfoById(String parkingInfoId);

	/**
	 * 
	 * getParkingInfo:(查询全部停车场信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select parking_info_id parkingInfoId,parking_info_address parkingInfoAddress, parking_info_name parkingInfoName, parking_info_longitude parkingInfoLongitude, parking_info_latitude parkingInfoLatitude, parking_info_parking_spaces parkingInfoParkingSpaces, parking_info_rest_parking_spaces parkingInfoRestParkingSpaces, parking_info_state parkingInfoState, parking_info_create_time parkingInfoCreateTime, parking_info_create_manager_type parkingInfoCreateManagerType, parking_info_create_manager_id parkingInfoCreateManagerId from parking_info")
	public List<ParkingInfo> getParkingInfo();

	/**
	 * 
	 * @Title: deleteParkingInfoById:(删除parkingInfoId的停车场信息). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	@Delete("delete from parking_info where (parking_info_id = #{parkingInfoId})")
	public int deleteParkingInfoById(String parkingInfoId);

	/**
	 * 
	 * getParkInfoByLoLa:(获取经纬度1km范围内的停车场). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param startLongitude
	 * @param endLongitude
	 * @param startLatitude
	 * @param endLatitude
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT parking_info_id AS parkingInfoId, parking_info_name AS parkingInfoName, parking_info_address AS parkingInfoAddress, parking_info_longitude AS parkingInfoLongitude, parking_info_latitude AS parkingInfoLatitude, parking_info_parking_spaces AS parkingInfoParkingSpaces, parking_info_rest_parking_spaces AS parkingInfoRestParkingSpaces FROM parking_info WHERE parking_info.parking_info_longitude BETWEEN #{startLongitude} AND #{endLongitude} AND parking_info_latitude BETWEEN #{startLatitude} AND #{endLatitude} ORDER BY parking_info_longitude DESC")
	public List<ParkingInfo> getParkInfoByLoLa(@Param("startLongitude") String startLongitude,
			@Param("endLongitude") String endLongitude, @Param("startLatitude") String startLatitude,
			@Param("endLatitude") String endLatitude);

}
