/**
 * Project Name:OnlineParking
 * File Name:SecurityCoreDao.java
 * Package Name:com.yinzitech.onlineparking.dao.securityCore
 * Date:2015年10月13日上午11:00:21
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.securityCore;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.securityCore.SecurityCore;

/**
 * ClassName:SecurityCoreDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 上午11:00:21 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface SecurityCoreDao {

	/**
	 * 
	 * @Title: create:(新建)<br/>
	 *
	 * @author Kevin
	 * @param securityCoreId
	 * @param securityCoreAccountType
	 * @param securityCoreAccountId
	 * @param securityCoreAccountSecurity
	 * @param securityCoreState
	 * @param securityCoreCreateTime
	 * @return
	 * @since JDK 1.8
	 */
	@Insert("insert into security_core (security_core_id, security_core_account_type,security_core_account_id ,security_core_account_security ,security_core_state ,security_core_create_time ) VALUES (#{securityCoreId},#{securityCoreAccountType},#{securityCoreAccountId}, #{securityCoreAccountSecurity},#{securityCoreState}, #{securityCoreCreateTime})")
	public int create(@Param("securityCoreId") String securityCoreId,
			@Param("securityCoreAccountType") String securityCoreAccountType,
			@Param("securityCoreAccountId") String securityCoreAccountId,
			@Param("securityCoreAccountSecurity") String securityCoreAccountSecurity,
			@Param("securityCoreState") String securityCoreState,
			@Param("securityCoreCreateTime") String securityCoreCreateTime);

	/**
	 * 
	 * @Title: retrieveById:(按照密匙验证类关联账户id查询)<br/>
	 *
	 * @author Kevin
	 * @param securityCoreAccountId
	 * @return
	 * @since JDK 1.8
	 */
	/* Retrieve */
	@Select("SELECT security_core_id as securityCoreId," + "security_core_account_type as securityCoreAccountType,"
			+ "security_core_account_id as securityCoreAccountId,"
			+ "security_core_account_security as securityCoreAccountSecurity,"
			+ "security_core_state as securityCoreState," + "security_core_create_time as securityCoreCreateTime "
			+ "FROM security_core WHERE security_core_account_type = #{securityCoreAccountType} and security_core_account_id = #{securityCoreAccountId}")
	public SecurityCore retrieveById(@Param("securityCoreAccountType") String securityCoreAccountType,
			@Param("securityCoreAccountId") String securityCoreAccountId);

	/**
	 * 
	 * @Title: retrieve:(按照id查询). <br/>
	 * @Description: TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * @param: TODO(这里描述这个方法的执行流程
	 *             – 可选).<br/>
	 * @reTODO(这里描述这个方法的使用方法 – 可选).<br/>
	 *                       TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Kevin
	 * @param securityCoreId
	 * @return
	 * @since JDK 1.8
	 */
	@Select("SELECT security_core_id as securityCoreId," + "security_core_account_type as securityCoreAccountType,"
			+ "security_core_account_id as securityCoreAccountId,"
			+ "security_core_account_security as securityCoreAccountSecurity,"
			+ "security_core_state as securityCoreState," + "security_core_create_time as securityCoreCreateTime "
			+ "FROM security_core WHERE security_core_id = #{securityCoreId}")
	public SecurityCore retrieve(@Param("securityCoreId") String securityCoreId);

	/**
	 * 
	 * @Title: retrieveList:(查询所有密匙验证类). <br/>
	 *
	 * @author Kevin
	 * @param securityCoreAccountId
	 * @return List
	 * @since JDK 1.8
	 */
	@Select("SELECT security_core_id as securityCoreId," + "security_core_account_type as securityCoreAccountType,"
			+ "security_core_account_id as securityCoreAccountId,"
			+ "security_core_account_security as securityCoreAccountSecurity,"
			+ "security_core_state as securityCoreState," + "security_core_create_time as securityCoreCreateTime "
			+ "FROM security_core ")
	public List<SecurityCore> retrieveList();

	/**
	 * 
	 * @Title: update:(根据秘钥管理类Id,对秘钥进行更改). <br/>
	 * @Description: TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * @param: TODO(这里描述这个方法的执行流程
	 *             – 可选).<br/>
	 * @reTODO(这里描述这个方法的使用方法 – 可选).<br/>
	 *                       TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author Kevin
	 * @param securityCoreId
	 * @param securityCoreAccountType
	 * @param securityCoreAccountId
	 * @param securityCoreAccountSecurity
	 * @param securityCoreState
	 * @param securityCoreCreateTime
	 * @return
	 * @since JDK 1.8
	 */
	/* Update */
	@Update("UPDATE security_core set security_core_account_type=#{securityCoreAccountType},security_core_account_id=#{securityCoreAccountId},security_core_account_security=#{securityCoreAccountSecurity},security_core_state=#{securityCoreState},security_core_create_time=#{securityCoreCreateTime} where security_core_id = #{securityCoreId}")
	public int update(@Param("securityCoreId") String securityCoreId,
			@Param("securityCoreAccountType") String securityCoreAccountType,
			@Param("securityCoreAccountId") String securityCoreAccountId,
			@Param("securityCoreAccountSecurity") String securityCoreAccountSecurity,
			@Param("securityCoreState") String securityCoreState,
			@Param("securityCoreCreateTime") String securityCoreCreateTime);

	/**
	 * 
	 * @Title: updateSecurity:(根据秘钥管理类Id,更新秘钥)<br/>
	 *
	 * @author Kevin
	 * @param securityCoreId
	 * @return
	 * @since JDK 1.8
	 */
	@Update("UPDATE security_core set security_core_account_security=#{securityCoreAccountSecurity} where security_core_id = #{securityCoreId}")
	public int updateSecurity(@Param("securityCoreId") String securityCoreId,
			@Param("securityCoreAccountSecurity") String securityCoreAccountSecurity);

	/**
	 * * @Title: updateSecurityBy:(根据秘钥管理类关联的用户Id,更新秘钥). <br/>
	 *
	 * @author Kevin
	 * @param securityCoreAccountId
	 * @param securityCoreAccountSecurity
	 * @return
	 * @since JDK 1.8
	 */
	@Update("UPDATE security_core set security_core_account_security=#{securityCoreAccountSecurity} where security_core_account_type=#{securityCoreAccountType} and security_core_account_id = #{securityCoreAccountId}")
	public int updateSecurityBySecurityCoreAccountId(@Param("securityCoreAccountType") String securityCoreAccountType,
			@Param("securityCoreAccountId") String securityCoreAccountId,
			@Param("securityCoreAccountSecurity") String securityCoreAccountSecurity);

	/**
	 * 
	 * @Title: updateState:(根据秘钥管理类Id,更新状态)<br/>
	 * 
	 * @author Kevin
	 * @param securityCoreId
	 * @return
	 * @since JDK 1.8
	 */
	@Update("UPDATE security_core set security_core_state=#{securityCoreState} where security_core_id = #{securityCoreId}")
	public int updateState(@Param("securityCoreId") String securityCoreId,
			@Param("securityCoreState") String securityCoreState);

	/**
	 * 
	 * @Title: delete:(根据秘钥管理类Id,删除). <br/>
	 *
	 * @author Kevin
	 * @param securityCoreState
	 * @return
	 * @since JDK 1.8
	 */
	/* Delete */
	@Delete("delete from security_core where security_core_id = #{securityCoreId}")
	public int delete(@Param("securityCoreId") String securityCoreId);

}
