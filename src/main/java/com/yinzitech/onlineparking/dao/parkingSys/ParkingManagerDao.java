/**
 * Project Name:OnlineParking
 * File Name:ParkingManagerDao.java
 * Package Name:com.yinzitech.onlineparking.dao.parkingSys
 * Date:2015年10月4日上午7:06:49
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.parkingSys;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.parkingSys.manager.ParkingManager;

/**
 * ClassName:ParkingManagerDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午7:06:49 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ParkingManagerDao {
	/**
	 * 
	 * @Title: hasPhoneNumber:(验证手机号在数据库中是否存在). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @return 如果存在 返回值>1 0为不存在
	 * @since JDK 1.8
	 */
	@Select("SELECT count(*) c from parking_manager where parking_manager_phone= #{parkingManagerPhone}")
	public int hasPhoneNumber(@Param("parkingManagerPhone") String parkingManagerPhone);

	/**
	 * 
	 * @Title: insertParkingManager:(新建停车场管理员账户). <br/>
	 *         条件 ,先判定该手机号用户是否存在调用 hasPhoneNumber
	 *
	 * @author Kevin
	 * @param parkingManagerId
	 *            停车场管理员账户Id--由id生成器生成
	 * @param parkingManagerPhone
	 *            停车场管理员手机号
	 * @param parkingManagerPsd
	 *            停车场管理员账户密码
	 * @param parkingInfoId
	 *            关联停车场--初始时为空,可通过停车场管理员账户信息更改做与停车场id的关联
	 * @param parkingManagerCreateTime
	 *            停车场管理员账户创建时间--通过时间获取工具自动获取
	 * @param parkingManagerActiveMark
	 *            停车场管理员账户状态--初始化为1 可以使用
	 * @return
	 * @since JDK 1.8
	 */
	@Insert("INSERT into parking_manager(parking_manager_id,parking_manager_phone,parking_manager_psd,parking_info_id,parking_manager_create_time,parking_manager_active_mark,parking_manager_name) values(#{parkingManagerId},#{parkingManagerPhone},#{parkingManagerPsd},#{parkingInfoId},#{parkingManagerCreateTime},#{parkingManagerActiveMark},#{parkingManagerName})")
	public int insertParkingManager(@Param("parkingManagerId") String parkingManagerId,
			@Param("parkingManagerPhone") String parkingManagerPhone,
			@Param("parkingManagerPsd") String parkingManagerPsd, @Param("parkingInfoId") String parkingInfoId,
			@Param("parkingManagerCreateTime") String parkingManagerCreateTime,
			@Param("parkingManagerActiveMark") String parkingManagerActiveMark,
			@Param("parkingManagerName") String parkingManagerName);

	/**
	 * 
	 * @Title: getParkingManagerByParkingManagerId:(通过Id查询停车场管理员信息). <br/>
	 *
	 * @author Kevin
	 * @return
	 * @since JDK 1.8
	 */
	@Select("SELECT parking_manager_id as parkingManagerId," + "parking_manager_phone as parkingManagerPhone,"
			+ "parking_manager_psd as parkingManagerPsd," + "parking_info_id as parkingInfoId,"
			+ "parking_manager_create_time as parkingManagerCreateTime,"
			+ "parking_manager_active_mark as parkingManagerActiveMark ,parking_manager_name as parkingManagerName "
			+ "from parking_manager where parking_manager_id=#{parkingManagerId}")
	public ParkingManager getParkingManagerByParkingManagerId(@Param("parkingManagerId") String parkingManagerId);

	/**
	 * 
	 * @Title: getParkingManagerByParkingManagerPhone:(通过停车场管理员手机号查询停车场管理员信息)
	 * @author Kevin
	 * @return
	 * @since JDK 1.8
	 */
	@Select("SELECT parking_manager_id as parkingManagerId," + "parking_manager_phone as parkingManagerPhone,"
			+ "parking_manager_psd as parkingManagerPsd," + "parking_info_id as parkingInfoId,"
			+ "parking_manager_create_time as parkingManagerCreateTime,"
			+ "parking_manager_active_mark as parkingManagerActiveMark ,parking_manager_name as parkingManagerName "
			+ "from parking_manager where parking_manager_phone=#{parkingManagerPhone}")
	public ParkingManager getParkingManagerByParkingManagerPhone(
			@Param("parkingManagerPhone") String parkingManagerPhone);

	/**
	 * @Title: login:(登录验证). <br/>
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @return
	 * @since JDK 1.8
	 */
	@Select("SELECT parking_manager_id as parkingManagerId," + "parking_manager_phone as parkingManagerPhone,"
			+ "parking_manager_psd as parkingManagerPsd," + "parking_info_id as parkingInfoId,"
			+ "parking_manager_create_time as parkingManagerCreateTime,"
			+ "parking_manager_active_mark as parkingManagerActiveMark , parking_manager_name as parkingManagerName "
			+ "from parking_manager where (parking_manager_phone=#{parkingManagerPhone} and parking_manager_psd=#{parkingManagerPsd})")
	public ParkingManager login(@Param("parkingManagerPhone") String parkingManagerPhone,
			@Param("parkingManagerPsd") String parkingManagerPsd);

	/**
	 * 
	 * @Title: updateParkingManager:(更新停车场管理员账号信息). <br/>
	 *         仅限更新停车场管理员账号信息使用
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @param parkingInfoId
	 * @param parkingManagerCreateTime
	 * @param parkingManagerActiveMark
	 * @return
	 * @since JDK 1.8
	 */
	@Update("UPDATE parking_manager SET parking_manager_psd = #{parkingManagerPsd},parking_info_id = #{parkingInfoId},parking_manager_create_time = #{parkingManagerCreateTime},parking_manager_active_mark = #{parkingManagerActiveMark} WHERE (parking_manager_phone = #{parkingManagerPhone})")
	public int updateParkingManager(@Param("parkingManagerPhone") String parkingManagerPhone,
			@Param("parkingManagerPsd") String parkingManagerPsd, @Param("parkingInfoId") String parkingInfoId,
			@Param("parkingManagerCreateTime") String parkingManagerCreateTime,
			@Param("parkingManagerActiveMark") String parkingManagerActiveMark);

	/* 更换手机 */
	/**
	 * 
	 * @Title: updateParkingManagerPhone:(更换停车场管理员手机号). <br/>
	 *         需要先通过getParkingManagerByParkingManagerPhone 方法获取到要更换手机的停车场管理员账户id
	 *
	 * @author Kevin
	 * @param parkingManagerId
	 * @param parkingManagerPhone
	 * @return
	 * @since JDK 1.8
	 */
	@Update("UPDATE parking_manager SET parking_manager_phone = #{parkingManagerPhone} WHERE (parking_manager_id = #{parkingManagerId})")
	public int updateParkingManagerPhone(@Param("parkingManagerId") String parkingManagerId,
			@Param("parkingManagerPhone") String parkingManagerPhone);

	/**
	 * 
	 * @Title: updateParkingManagerPsd:(停车场管理员密码找回). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @return
	 * @since JDK 1.8
	 */
	@Update("UPDATE parking_manager SET parking_manager_psd = #{parkingManagerPsd} WHERE (parking_manager_phone = #{parkingManagerPhone})")
	public int updateParkingManagerPsd(@Param("parkingManagerPhone") String parkingManagerPhone,
			@Param("parkingManagerPsd") String parkingManagerPsd);

	/**
	 * 
	 * @Title: selectAllParkingManager:(查询所有停车场管理员账户). <br/>
	 *
	 * @author Kevin
	 * @return
	 * @since JDK 1.8
	 */
	@Select("SELECT parking_manager_id as parkingManagerId," + "parking_manager_phone as parkingManagerPhone,"
			+ "parking_manager_psd as parkingManagerPsd," + "parking_info_id as parkingInfoId,"
			+ "parking_manager_create_time as parkingManagerCreateTime,"
			+ "parking_manager_active_mark as parkingManagerActiveMark ,parking_manager_name as parkingManagerName "
			+ "from parking_manager")
	public List<ParkingManager> selectAllParkingManager();

	/**
	 * 
	 * @Title: disableParkingManager:(更改停车场管理员用户状态). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @return
	 * @since JDK 1.8
	 */
	@Update("UPDATE parking_manager SET parking_manager_active_mark = #{parkingManagerActiveMark} WHERE (parking_manager_phone = #{parkingManagerPhone})")
	public int disableParkingManager(@Param("parkingManagerPhone") String parkingManagerPhone,
			@Param("parkingManagerActiveMark") String parkingManagerActiveMark);

	/**
	 * 
	 * @Title: deleteParkingManager:(删除停车场管理员用户账号,根据id). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerId
	 * @return
	 * @since JDK 1.8
	 */
	@Delete("DELETE FROM parking_manager WHERE (parking_manager_id= #{parkingManagerId})")
	public int deleteParkingManager(@Param("parkingManagerId") String parkingManagerId);

	/**
	 * 
	 * @Title: updtaParkingInfoId:(根据停车场管理员手机号,关联停车场). <br/>
	 *
	 * @author Kevin
	 * @param parkingManagerPhone
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8
	 */
	@Update("UPDATE parking_manager SET parking_info_id = #{parkingInfoId} WHERE (parking_manager_phone = #{parkingManagerPhone})")
	public int updateParkingInfoId(@Param("parkingManagerPhone") String parkingManagerPhone,
			@Param("parkingInfoId") String parkingInfoId);
}
