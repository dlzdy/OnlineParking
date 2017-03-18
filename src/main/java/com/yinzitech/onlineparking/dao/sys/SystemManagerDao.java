/**
+ * Project Name:OnlineParking
 * File Name:SystemManagerDao.java
 * Package Name:com.yinzitech.onlineparking.dao.sys
 * Date:2015年10月9日下午5:35:11
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.sys.SystemManager;

/**
 * ClassName:SystemManagerDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月9日 下午5:35:11 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface SystemManagerDao {
	/**
	 * 
	 * creatSysteManager:(注册管理员帐号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerId
	 * @param systemManagerUsername
	 * @param systemManagerPsd
	 * @param systemManagerCreateTime
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO system_manager (system_manager_id , system_manager_username , system_manager_psd ,system_manager_create_time) VALUES (#{systemManagerId},#{systemManagerUsername},#{systemManagerPsd},#{systemManagerCreateTime})")
	public int creatSysteManager(@Param("systemManagerId") String systemManagerId,
			@Param("systemManagerUsername") String systemManagerUsername,
			@Param("systemManagerPsd") String systemManagerPsd,
			@Param("systemManagerCreateTime") String systemManagerCreateTime);

	/**
	 * 
	 * selectAllManagerUser:(查询全部用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT system_manager_id as systemManagerId ," + " system_manager_username as systemManagerUsername,"
			+ " system_manager_psd as systemManagerPsd,"
			+ " system_manager_phone as systemManagerPhone, system_manager_email as systemManagerEmail,"
			+ " system_manager_create_time as systemManagerCreateTime, system_manager_last_login_time as systemManagerLastLoginTime,"
			+ " system_manager_state as systemManagerState FROM system_manager")
	public List<SystemManager> selectAllManagerUser();

	/**
	 * 
	 * selectManagerUserByName:(查询用户信息(可用于登录判定)). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerUsername
	 * @param systemManagerPsd
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT system_manager_id as systemManagerId ," + " system_manager_username as systemManagerUsername,"
			+ " system_manager_psd as systemManagerPsd,"
			+ " system_manager_phone as systemManagerPhone, system_manager_email as systemManagerEmail,"
			+ " system_manager_create_time as systemManagerCreateTime, system_manager_last_login_time as systemManagerLastLoginTime,"
			+ " system_manager_state as systemManagerState FROM system_manager WHERE system_manager_username = #{systemManagerUsername}  AND system_manager_psd = #{systemManagerPsd}")
	public SystemManager selectManagerUserByName(@Param("systemManagerUsername") String systemManagerUsername,
			@Param("systemManagerPsd") String systemManagerPsd);

	/**
	 * 
	 * upLastTimeLogin:(修改用户最后登录时间). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerLastLoginTime
	 * @param systemManagerUsername
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE system_manager SET system_manager_last_login_time  = #{systemManagerLastLoginTime} WHERE  system_manager_username= #{systemManagerUsername}")
	public int upLastTimeLogin(@Param("systemManagerLastLoginTime") String systemManagerLastLoginTime,
			@Param("systemManagerUsername") String systemManagerUsername);

	/**
	 * 
	 * upManagerUserPsd:(修改密码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerPsd
	 * @param systemManagerUsername
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE system_manager SET system_manager_psd  = #{systemManagerPsd } WHERE  system_manager_username= #{systemManagerUsername}")
	public int upManagerUserPsd(@Param("systemManagerPsd") String systemManagerPsd,
			@Param("systemManagerUsername") String systemManagerUsername);

	/**
	 * 
	 * upUserInfo:(更新用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerPhone
	 * @param systemManagerEmail
	 * @param systemManagerState
	 * @param systemManagerUsername
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE system_manager SET system_manager_phone = #{systemManagerPhone}, system_manager_email= #{systemManagerEmail}, system_manager_state= #{systemManagerState}  WHERE system_manager_username= #{systemManagerUsername} ")
	public int upUserInfo(@Param("systemManagerPhone") String systemManagerPhone,
			@Param("systemManagerEmail") String systemManagerEmail,
			@Param("systemManagerState") String systemManagerState,
			@Param("systemManagerUsername") String systemManagerUsername);

	/**
	 * 
	 * deleteManagerUser:(通过用户id删除用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerUsername
	 * @return
	 * @since JDK 1.8u60
	 */
	@Delete("DELETE FROM system_manager WHERE system_manager_id = #{systemManagerId}")
	public int deleteManagerUser(@Param("systemManagerId") String systemManagerId);

}
