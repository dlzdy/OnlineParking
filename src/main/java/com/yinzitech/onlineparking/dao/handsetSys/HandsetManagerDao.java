/**
 * Project Name:OnlineParking
 * File Name:HandsetManagerDao.java
 * Package Name:com.yinzitech.onlineparking.dao.handsetSys
 * Date:2015年10月6日上午10:40:49
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.handsetSys;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.handsetSys.HandsetManager;
import com.yinzitech.onlineparking.entity.order.HandsetOrder;

/**
 * ClassName:HandsetManagerDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月6日 上午10:40:49 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface HandsetManagerDao {
	/**
	 * 
	 * creatHandsetManager:(创建手持设备账户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerId
	 *            停车场手持机收费员用户账号主键id
	 * @param handsetManagerSecurity
	 *            停车场手持机管理员用户安全识令牌
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @param parkingInfoId
	 *            账号关联停车场id
	 * @param handsetManagerCreateTime
	 *            收费员用户账号创建时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO handset_manager (handset_id,handset_manager_id, handset_manager_security, handset_manager_phone, parking_info_id, handset_manager_create_time,handset_manager_name) VALUES (#{handsetId},#{handsetManagerId},#{handsetManagerSecurity},#{handsetManagerPhone},#{parkingInfoId},#{handsetManagerCreateTime},#{handsetManagerName})")
	public int creatHandsetManager(@Param("handsetId") String handsetId,
			@Param("handsetManagerId") String handsetManagerId,
			@Param("handsetManagerSecurity") String handsetManagerSecurity,
			@Param("handsetManagerPhone") String handsetManagerPhone, @Param("parkingInfoId") String parkingInfoId,
			@Param("handsetManagerCreateTime") String handsetManagerCreateTime,
			@Param("handsetManagerName") String handsetManagerName);

	/**
	 * 
	 * hasManagerPhone:(判断管理员电话是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT COUNT(*) c FROM handset_manager WHERE handset_manager_phone = #{handsetManagerPhone}")
	public int hasManagerPhone(@Param("handsetManagerPhone") String handsetManagerPhone);

	/**
	 * 
	 * hasActiveMark:(判断账号状态是否可用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT COUNT(*) c FROM handset_manager WHERE handset_manager_active_mark = 'enable' AND handset_manager_phone = #{handsetManagerPhone}")
	public int hasActiveMark(@Param("handsetManagerPhone") String handsetManagerPhone);

	/**
	 * 
	 * LoginHandsetManager:(手持机登录). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerSecurity
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */

	@Select("SELECT handset_id as handsetId, handset_manager_id as handsetManagerId,"
			+ " handset_manager_security as handsetManagerSecurity, handset_manager_phone as handsetManagerPhone,"
			+ " parking_info_id as parkingInfoId, handset_manager_create_time as handsetManagerCreateTime,"
			+ " handset_manager_active_mark as handsetManagerActiveMark , "
			+ "handset_registr_ation_id	as handsetRegistrAtionId ," + "handset_manager_name as handsetManagerName   "
			+ "FROM handset_manager WHERE handset_manager_phone = #{handsetManagerPhone} "
			+ "AND handset_manager_security = #{handsetManagerSecurity}")
	public HandsetManager LoginHandsetManager(@Param("handsetManagerSecurity") String handsetManagerSecurity,
			@Param("handsetManagerPhone") String handsetManagerPhone);

	/**
	 * 
	 * selectHandsetManagerByParkId:(通过停车场ID查询全部手持机信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT handset_id as handsetId, handset_manager_id as handsetManagerId,"
			+ " handset_manager_security as handsetManagerSecurity, handset_manager_phone as handsetManagerPhone,"
			+ " parking_info_id as parkingInfoId, handset_manager_create_time as handsetManagerCreateTime,"
			+ " handset_manager_active_mark as handsetManagerActiveMark , "
			+ "handset_registr_ation_id	as handsetRegistrAtionId ," + "handset_manager_name as handsetManagerName   "
			+ "     FROM handset_manager WHERE parking_info_id = #{parkingInfoId}")
	public List<HandsetManager> selectHandsetManagerByParkId(@Param("parkingInfoId") String parkingInfoId);

	/**
	 * 
	 * selectHandsetManagerByHandsetId:(通过手持机管理员ID获取手持机信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT handset_id as handsetId, handset_manager_id as handsetManagerId,"
			+ " handset_manager_security as handsetManagerSecurity, handset_manager_phone as handsetManagerPhone,"
			+ " parking_info_id as parkingInfoId, handset_manager_create_time as handsetManagerCreateTime,"
			+ " handset_manager_active_mark as handsetManagerActiveMark , "
			+ "handset_registr_ation_id	as handsetRegistrAtionId ," + "handset_manager_name as handsetManagerName   "
			+ "     FROM handset_manager WHERE handset_manager_id = #{handsetManagerId}")
	public HandsetManager selectHandsetManagerByHandManagerId(@Param("handsetManagerId") String handsetManagerId);

	/**
	 * 
	 * selectHandsetManager:(查询全部手持设备用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT handset_id as handsetId, handset_manager_id as handsetManagerId,"
			+ " handset_manager_security as handsetManagerSecurity, handset_manager_phone as handsetManagerPhone,"
			+ " parking_info_id as parkingInfoId, handset_manager_create_time as handsetManagerCreateTime,"
			+ " handset_manager_active_mark as handsetManagerActiveMark , "
			+ "handset_registr_ation_id	as handsetRegistrAtionId ," + "handset_manager_name as handsetManagerName   "
			+ " FROM handset_manager ")
	public List<HandsetManager> selectHandsetManager();

	/**
	 * 
	 * selectHandsetManagerByHandManagerPhone:(通过手持机管理员phone获取手持机信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT handset_id as handsetId, handset_manager_id as handsetManagerId,"
			+ " handset_manager_security as handsetManagerSecurity, handset_manager_phone as handsetManagerPhone,"
			+ " parking_info_id as parkingInfoId, handset_manager_create_time as handsetManagerCreateTime,"
			+ " handset_manager_active_mark as handsetManagerActiveMark , "
			+ " handset_registr_ation_id as handsetRegistrAtionId , handset_manager_name as handsetManagerName "
			+ " FROM handset_manager WHERE handset_manager_phone like #{handsetManagerPhone}")
	public HandsetManager selectHandsetManagerByHandManagerPhone(
			@Param("handsetManagerPhone") String handsetManagerPhone);

	/**
	 * 
	 * selectHandsetManagerByHandsetId:(通过手持机管理员handsetId获取手持机信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT handset_id as handsetId, handset_manager_id as handsetManagerId,"
			+ " handset_manager_security as handsetManagerSecurity, handset_manager_phone as handsetManagerPhone,"
			+ " parking_info_id as parkingInfoId, handset_manager_create_time as handsetManagerCreateTime,"
			+ " handset_manager_active_mark as handsetManagerActiveMark , "
			+ " handset_registr_ation_id as handsetRegistrAtionId , handset_manager_name as handsetManagerName "
			+ " FROM handset_manager WHERE handset_id like #{handsetId}")
	public List<HandsetManager> selectHandsetManagerByHandsetId(@Param("handsetId") String handsetId);

	/**
	 * 
	 * selectHandsetManagerByName:(通过手持机管理员name获取手持机信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT handset_id as handsetId, handset_manager_id as handsetManagerId,"
			+ " handset_manager_security as handsetManagerSecurity, handset_manager_phone as handsetManagerPhone,"
			+ " parking_info_id as parkingInfoId, handset_manager_create_time as handsetManagerCreateTime,"
			+ " handset_manager_active_mark as handsetManagerActiveMark , "
			+ " handset_registr_ation_id as handsetRegistrAtionId , handset_manager_name as handsetManagerName "
			+ " FROM handset_manager WHERE handset_manager_name like #{handsetManagerName}")
	public List<HandsetManager> selectHandsetManagerByName(@Param("handsetManagerName") String handsetManagerName);

	/**
	 * 
	 * upHandsetManagerPhone:(修改手机号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerId
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE handset_manager SET  handset_manager_phone= #{handsetManagerPhone} WHERE handset_manager_id= #{handsetManagerId}")
	public int upHandsetManagerPhone(@Param("handsetManagerId") String handsetManagerId,
			@Param("handsetManagerPhone") String handsetManagerPhone);

	/**
	 * 
	 * uphandsetManagerSecurity:(通过手机号更新安全令牌). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 * @param handsetManagerSecurity
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE handset_manager SET  handset_manager_security= #{handsetManagerSecurity} WHERE handset_manager_phone= #{handsetManagerPhone}")
	public int uphandsetManagerSecurity(@Param("handsetManagerPhone") String handsetManagerPhone,
			@Param("handsetManagerSecurity") String handsetManagerSecurity);

	/**
	 * 
	 * upActiveMark:(通过电话号码更新手持账户状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @param handsetManagerActiveMark
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE handset_manager SET  handset_manager_phone= #{handsetManagerPhone} WHERE handset_manager_active_mark= #{handsetManagerActiveMark}")
	public int upActiveMark(@Param("handsetManagerPhone") String handsetManagerPhone,
			@Param("handsetManagerActiveMark") String handsetManagerActiveMark);

	/**
	 * 
	 * upHandsetId:(更新手持设备id). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetId
	 *            手持设备ID
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE handset_manager SET  handset_id= #{handsetId} WHERE handset_manager_phone= #{handsetManagerPhone}")
	public int upHandsetId(@Param("handsetId") String handsetId,
			@Param("handsetManagerPhone") String handsetManagerPhone);

	/**
	 * 
	 * upHandsetUser:(修改收费员名称). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetId
	 *            手持设备ID
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE handset_manager SET  handset_manager_name= #{handsetManagerName} WHERE handset_manager_phone= #{handsetManagerPhone} ")
	public int upHandsetUser(@Param("handsetManagerPhone") String handsetManagerPhone,
			@Param("handsetManagerName") String handsetManagerName);

	/**
	 * 
	 * upParkingInfoId:(手持用户变更停车场). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @param handsetManagerId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE handset_manager SET parking_info_id =  #{parkingInfoId}  WHERE handset_manager_id = #{handsetManagerId}")
	public int upParkingInfoId(@Param("parkingInfoId") String parkingInfoId,
			@Param("handsetManagerId") String handsetManagerId);

	/**
	 * 
	 * addHandsetRegistrAtionId:(更新手持设备推送账户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetRegistrAtionId
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE handset_manager SET handset_registr_ation_id= #{handsetRegistrAtionId} WHERE handset_manager_phone= #{handsetManagerPhone}")
	public int addHandsetRegistrAtionId(@Param("handsetRegistrAtionId") String handsetRegistrAtionId,
			@Param("handsetManagerPhone") String handsetManagerPhone);

	/**
	 * 
	 * deleteHandsetManagerByManagerId:(通过手持机用户ID删除账户内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Delete("DELETE FROM handset_manager WHERE handset_manager_id= #{handsetManagerId}")
	public int deleteHandsetManagerByManagerId(@Param("handsetManagerId") String handsetManagerId);

	/**
	 * 
	 * getHandesetOrder:(手持用户订单统计). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param managerId
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT a.parking_info_id AS parkingInfoId ,a.handset_manager_id AS managerId, a.handset_manager_phone AS phone,"
			+ " a.handset_manager_name AS managerName,  SUM(b.parking_order_cost) AS sumCost,"
			+ " COUNT(*) orderNomber FROM  handset_manager a, parking_order b "
			+ " WHERE a.handset_manager_id = b.parking_order_handset_manager_id "
			+ " AND a.handset_manager_id = #{managerId} "
			+ " AND b.parking_order_car_exit_time  BETWEEN #{startTime} AND #{endTime}"
			+ " AND b.parking_order_pay_state= 'Paid'")
	public HandsetOrder getHandesetOrder(@Param("managerId") String managerId, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 
	 * insertHandesetOrder:(增加统计数据). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param managerId
	 * @param phone
	 * @param managerName
	 * @param sumCost
	 * @param endTime
	 * @param startTime
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO handset_order (manager_id, phone, manager_name, sum_cost, order_nomber, endTime, startTime,parking_info_id,order_id) VALUES (#{managerId}, #{phone}, #{managerName}, #{sumCost}, #{orderNomber}, #{endTime}, #{startTime},#{parkingInfoId},#{orderId})")
	public int insertHandesetOrder(@Param("managerId") String managerId, @Param("phone") String phone,
			@Param("managerName") String managerName, @Param("sumCost") String sumCost,
			@Param("orderNomber") String orderNomber, @Param("endTime") String endTime,
			@Param("startTime") String startTime, @Param("parkingInfoId") String parkingInfoId,
			@Param("orderId") String orderId);

	/**
	 * 
	 * queryHandesetOrderByManagerId:(查询手持用户统计数据). <br/>
	 * TODO(用户每日历史统计数据 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param managerId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT manager_id as managerId,phone as phone ," + "manager_name as managerName,sum_cost as sumCost,"
			+ "order_nomber as orderNomber ,endTime as endTime," + "startTime as startTime  ,order_id as orderId"
			+ " FROM handset_order WHERE manager_id = #{managerId}  ORDER BY startTime DESC")
	public List<HandsetOrder> queryHandesetOrderByManagerId(@Param("managerId") String managerId);

	/**
	 * 
	 * queryHandesetOrderByName:(手持流水byName). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param managerName
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT manager_id as managerId,phone as phone ," + "manager_name as managerName,sum_cost as sumCost,"
			+ "order_nomber as orderNomber ,endTime as endTime," + "startTime as startTime ,order_id as orderId "
			+ "FROM handset_order WHERE manager_name = #{managerName} AND manager_id = #{managerId} AND endTime BETWEEN #{startTime} AND #{endTime}")
	public List<HandsetOrder> queryHandesetOrderByName(@Param("managerName") String managerName,
			@Param("managerId") String managerId, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 
	 * queryHandesetOrderByPhone:(手持流水byPhone). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param phone
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT manager_id as managerId,phone as phone ," + "manager_name as managerName,sum_cost as sumCost,"
			+ "order_nomber as orderNomber ,endTime as endTime," + "startTime as startTime ,order_id as orderId "
			+ "FROM handset_order WHERE phone = #{phone} AND manager_id = #{managerId} AND endTime BETWEEN #{startTime} AND #{endTime}")
	public List<HandsetOrder> queryHandesetOrderByPhone(@Param("phone") String phone,
			@Param("managerId") String managerId, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

}
