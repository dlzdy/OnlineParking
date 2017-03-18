/**
 * Project Name:OnlineParking
 * File Name:ClinetUserCarManageDao.java
 * Package Name:com.yinzitech.onlineparking.dao.client.carManage
 * Date:2015年10月4日下午8:36:11
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.dao.client.carManage;
 

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.client.carManage.ClinetUserCarManage;

/**
 * ClassName:ClinetUserCarManageDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 下午8:36:11 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface ClinetUserCarManageDao {
	/**
	 * 
	 * insertUserCar:(新增用户车牌号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param carManageId
	 *            汽车车主用户车辆管理id
	 * @param clientUserId
	 *            汽车车主用户id
	 * @param clientUserCarNo
	 *            汽车车主用户车牌号
	 * @param clientUserCarPosition
	 *            汽车车主用户车牌号显示顺序
	 * @param carNoSettingTime
	 *            汽车车主用户设置车牌时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO clinet_user_car_manage (car_manage_id, client_user_id, client_user_car_no, client_user_car_position, car_no_setting_time) VALUES (#{carManageId}, #{clientUserId}, #{clientUserCarNo}, #{clientUserCarPosition}, #{carNoSettingTime})")
	public int insertUserCar(@Param("carManageId") String carManageId, @Param("clientUserId") String clientUserId,
			@Param("clientUserCarNo") String clientUserCarNo,
			@Param("clientUserCarPosition") String clientUserCarPosition,
			@Param("carNoSettingTime") String carNoSettingTime);


	/**
	 * 
	 * selectUserCarBycarManageId:(通过车牌ID获取车牌信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param carManageId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT car_manage_id as carManageId,client_user_id as clientUserId,"
			+ "client_user_car_no as clientUserCarNo, client_user_car_position as clientUserCarPosition,"
			+ " client_user_car_active_mark as clientUserCarActiveMark ,car_no_setting_time as carNoSettingTime "
			+ "FROM clinet_user_car_manage WHERE car_manage_id = #{carManageId}")
	public ClinetUserCarManage selectUserCarBycarManageId(@Param("carManageId") String carManageId);

	/**
	 * 
	 * selectUserCarByclientUserCarNo:(通过车牌号获取用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarNo
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT car_manage_id as carManageId,client_user_id as clientUserId,"
			+ "client_user_car_no as clientUserCarNo, client_user_car_position as clientUserCarPosition,"
			+ " client_user_car_active_mark as clientUserCarActiveMark ,car_no_setting_time as carNoSettingTime  "
			+ "FROM clinet_user_car_manage WHERE client_user_car_no = #{clientUserCarNo}")
	public ClinetUserCarManage selectUserCarByclientUserCarNo(@Param("clientUserCarNo") String clientUserCarNo);

	/**
	 * 
	 * hasUserCarNo:(判断车牌号是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarNo
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT count(*) c FROM clinet_user_car_manage WHERE client_user_car_no = #{clientUserCarNo}")
	public int hasUserCarNo(@Param("clientUserCarNo") String clientUserCarNo);

	/**
	 * 
	 * upUserCarActiveMark:(更改车辆状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarActiveMark
	 *            enable disable
	 * @param carManageId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE clinet_user_car_manage SET client_user_car_active_mark = #{clientUserCarActiveMark} WHERE car_manage_id=#{carManageId}")
	public int upUserCarActiveMark(@Param("clientUserCarActiveMark") String clientUserCarActiveMark,
			@Param("carManageId") String carManageId);

	/**
	 * 
	 * upUserCarPosition:(修改车牌号显示顺序). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarPosition
	 * @param carManageId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE clinet_user_car_manage SET client_user_car_position =#{clientUserCarPosition} WHERE car_manage_id=#{carManageId}")
	public int upUserCarPosition(@Param("clientUserCarPosition") String clientUserCarPosition,
			@Param("carManageId") String carManageId);

	/**
	 * 
	 * deleteUserCar:(通过carManageId删除车辆信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param carManageId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Delete("DELETE FROM clinet_user_car_manage WHERE car_manage_id=#{carManageId}")
	public int deleteUserCarByCarManageId(@Param("carManageId") String carManageId);

}
