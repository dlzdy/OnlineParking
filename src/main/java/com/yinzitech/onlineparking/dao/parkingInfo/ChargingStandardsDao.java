/**
 * Project Name:OnlineParking
 * File Name:ChargingStandardsDao.java
 * Package Name:com.yinzitech.onlineparking.dao.parkingInfo
 * Date:2015年10月4日下午8:00:25
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

import com.yinzitech.onlineparking.entity.parkingInfo.ChargingStandards;

/**
 * ClassName:ChargingStandardsDao <br/>
 * Function: 停车场价格标准Dao层. <br/>
 * Date: 2015年10月4日 下午8:00:25 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ChargingStandardsDao {
	/**
	 * 
	 * @Title: createChargingStandards:(新建停车场资费标准). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsManagerId
	 * @param chargingStandardsManagerType
	 * @param chargingStandardsCreateTime
	 * @param chargingStandardsState
	 * @param chargingStandardsPrise
	 * @param chargingStandardsStepStart
	 * @param chargingStandardsStepEnd
	 * @param chargingStandardsStep
	 * @param parkingInfoId
	 * @param chargingStandardsId
	 * @return
	 * @since JDK 1.8
	 */
	@Insert("insert into charging_standards (charging_standards_id,parking_info_id,charging_standards_step,charging_standards_step_start,charging_standards_step_end,charging_standards_prise,charging_standards_state,charging_standards_create_time,charging_standards_manager_type,charging_standards_manager_id)values (#{chargingStandardsId},#{parkingInfoId},#{chargingStandardsStep}, #{chargingStandardsStepStart},#{chargingStandardsStepEnd},#{chargingStandardsPrise},#{chargingStandardsState},#{chargingStandardsCreateTime},#{chargingStandardsManagerType},#{chargingStandardsManagerId})")
	public int createChargingStandards(@Param("chargingStandardsId") String chargingStandardsId,
			@Param("parkingInfoId") String parkingInfoId, @Param("chargingStandardsStep") String chargingStandardsStep,
			@Param("chargingStandardsStepStart") String chargingStandardsStepStart,
			@Param("chargingStandardsStepEnd") String chargingStandardsStepEnd,
			@Param("chargingStandardsPrise") String chargingStandardsPrise,
			@Param("chargingStandardsState") String chargingStandardsState,
			@Param("chargingStandardsCreateTime") String chargingStandardsCreateTime,
			@Param("chargingStandardsManagerType") String chargingStandardsManagerType,
			@Param("chargingStandardsManagerId") String chargingStandardsManagerId);

	/* 查询 */
	/**
	 * 
	 * @Title: getChargingStandardsById:(根据chargingStandardsId查看停车场收费标准). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @return
	 * @since JDK 1.8
	 */
	@Select("select charging_standards_id as chargingStandardsId," + "parking_info_id as parkingInfoId,"
			+ "charging_standards_step as chargingStandardsStep,"
			+ "charging_standards_step_start as chargingStandardsStepStart,	"
			+ "charging_standards_step_end as chargingStandardsStepEnd,"
			+ "charging_standards_prise as chargingStandardsPrise,"
			+ "charging_standards_state as chargingStandardsState,"
			+ "charging_standards_create_time as chargingStandardsCreateTime,"
			+ "charging_standards_manager_type as chargingStandardsManagerType,"
			+ "charging_standards_manager_id as chargingStandardsManagerId "
			+ "from charging_standards where (charging_standards_id=#{chargingStandardsId})")
	public ChargingStandards getChargingStandardsById(String chargingStandardsId);

	/**
	 * 
	 * @Title: getChargingStandardsListByParkingInfoId:(查询某一停车场的资费标准). <br/>
	 *
	 * @author Kevin
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	@Select("select charging_standards_id as chargingStandardsId,parking_info_id as parkingInfoId,"
			+ "charging_standards_step as chargingStandardsStep,"
			+ "charging_standards_step_start as chargingStandardsStepStart,charging_standards_step_end as chargingStandardsStepEnd,"
			+ "charging_standards_prise as chargingStandardsPrise,"
			+ "charging_standards_state as chargingStandardsState,"
			+ "charging_standards_create_time as chargingStandardsCreateTime,"
			+ "charging_standards_manager_type as chargingStandardsManagerType,"
			+ "charging_standards_manager_id as chargingStandardsManagerId "
			+ "from charging_standards where (parking_info_id=#{parkingInfoId}) ORDER BY charging_standards_step")
	public List<ChargingStandards> getChargingStandardsListByParkingInfoId(String parkingInfoId);

	/* 更改 */
	/**
	 * 
	 * @Title: updatetChargingStandardsById:(根据停车场收费标准Id更新该收费标准). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @param parkingInfoId
	 * @param chargingStandardsStep
	 * @param chargingStandardsStepStart
	 * @param chargingStandardsStepEnd
	 * @param chargingStandardsPrise
	 * @param chargingStandardsState
	 * @param chargingStandardsManagerType
	 * @param chargingStandardsManagerId
	 * @return
	 * @since JDK 1.8
	 */
	@Update("Update charging_standards set parking_info_id = #{parkingInfoId},charging_standards_step = #{chargingStandardsStep} ,charging_standards_step_start = #{chargingStandardsStepStart} ,charging_standards_step_end = #{chargingStandardsStepEnd} ,charging_standards_prise = #{chargingStandardsPrise},charging_standards_state = #{chargingStandardsState},charging_standards_manager_type = #{chargingStandardsManagerType},charging_standards_manager_id = #{chargingStandardsManagerId} where (charging_standards_id= #{chargingStandardsId})")
	public int updatetChargingStandardsById(@Param("chargingStandardsId") String chargingStandardsId,
			@Param("parkingInfoId") String parkingInfoId, @Param("chargingStandardsStep") String chargingStandardsStep,
			@Param("chargingStandardsStepStart") String chargingStandardsStepStart,
			@Param("chargingStandardsStepEnd") String chargingStandardsStepEnd,
			@Param("chargingStandardsPrise") String chargingStandardsPrise,
			@Param("chargingStandardsState") String chargingStandardsState,
			@Param("chargingStandardsManagerType") String chargingStandardsManagerType,
			@Param("chargingStandardsManagerId") String chargingStandardsManagerId);

	/* 关联停车场修改 */
	/**
	 * 
	 * @Title: updateParkingInfoIdById:(根据停车场收费标准Id更新该收费标准关联停车场). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	@Update("update charging_standards set parking_info_id = #{parkingInfoId} where charging_standards_id = #{chargingStandardsId}")
	public int updateParkingInfoIdById(String chargingStandardsId, String parkingInfoId);

	/* state更改 */
	/**
	 * 
	 * @Title: updatetChargingStandardsStateByChargingStandardsId:(
	 *         根据停车场收费标准Id更新该收费标准状态值). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @param chargingStandardsState
	 * @return
	 * @since JDK 1.8
	 */
	@Update("update charging_standards set charging_standards_state = #{chargingStandardsState} where charging_standards_id = #{chargingStandardsId}")
	public int updatetChargingStandardsStateByChargingStandardsId(String chargingStandardsId,
			String chargingStandardsState);

	/* 删除 */
	/**
	 * * @Title:
	 * deleteChargingStandardsByChargingStandardsId:(根据停车场收费标准Id删除该收费标准). <br/>
	 *
	 * @author Kevin
	 * @param chargingStandardsId
	 * @return
	 * @since JDK 1.8
	 */
	@Delete("delete from charging_standards where charging_standards_id=#{chargingStandardsId}")
	public int deleteChargingStandardsByChargingStandardsId(@Param("chargingStandardsId") String chargingStandardsId);

	/**
	 * 
	 * getLastStepEndByParkInfoId:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT * FROM charging_standards WHERE parking_info_id = #{parkingInfoId} ORDER BY charging_standards_step  DESC LIMIT 0,1")
	public ChargingStandards getLastStepEndByParkInfoId(String parkingInfoId);
}
