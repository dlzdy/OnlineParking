/**
 * Project Name:OnlineParking
 * File Name:ClientUserDao.java
 * Package Name:com.yinzitech.onlineparking.dao.client
 * Date:2015年10月4日上午7:13:12
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.client;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.client.user.ClientUser;

/**
 * ClassName:ClientUserDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午7:13:12 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ClientUserDao {

	/**
	 * 
	 * userLogin:(用户登录验证). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 *            汽车车主用户手机号
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return ClientUser
	 * @since JDK 1.8u60
	 */
	@Select("select client_user_id as clientUserId ,client_user_security as clientUserSecurity,"
			+ " client_user_cellphone as clientUserCellphone, client_user_sex as clientUserSex,"
			+ " client_user_nick_name as clientUserNickName, client_user_birthday as clientUserBirthday,"
			+ " client_user_sign_up_time as clientUserSignUpTime,client_user_active_mark as  clientUserActiveMark ,"
			+ "client_user_auto_pay as clientUserAutoPay ,client_user_type as clientUserType "
			+ "from client_user  where client_user_cellphone = #{clientUserCellphone} "
			+ "and client_user_security =#{clientUserSecurity}")
	public ClientUser userLogin(@Param("clientUserCellphone") String clientUserCellphone,
			@Param("clientUserSecurity") String clientUserSecurity);

	/**
	 * 
	 * insertUser:(新增汽车车主用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 *            汽车车主用户id
	 * @param clientUserCellphone
	 *            汽车车主用户手机号
	 * @param clientUserNickName
	 *            汽车车主昵称
	 * @param clientUserSignUpTime
	 *            汽车车主用户注册日期
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return int
	 * @since JDK 1.8u60
	 */

	@Insert("INSERT INTO client_user(client_user_id,client_user_cellphone,client_user_nick_name,client_user_sign_up_time)VALUES ( #{clientUserId} , #{clientUserCellphone} , #{clientUserNickName}, #{clientUserSignUpTime})")
	public int insertUser(@Param("clientUserId") String clientUserId,
			@Param("clientUserCellphone") String clientUserCellphone,
			@Param("clientUserNickName") String clientUserNickName,
			@Param("clientUserSignUpTime") String clientUserSignUpTime);

	/**
	 * 
	 * selectById:(通过用户ID查询用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select client_user_id as clientUserId ,client_user_security as clientUserSecurity,"
			+ " client_user_cellphone as clientUserCellphone, client_user_sex as clientUserSex,"
			+ " client_user_nick_name as clientUserNickName, client_user_birthday as clientUserBirthday,"
			+ " client_user_sign_up_time as clientUserSignUpTime,client_user_active_mark as  clientUserActiveMark ,"
			+ "client_user_auto_pay as clientUserAutoPay  ,client_user_type as clientUserType from client_user where client_user_id = #{clientUserId} and client_user_security = #{clientUserSecurity}")
	public ClientUser selectById(@Param("clientUserId") String clientUserId,
			@Param("clientUserSecurity") String clientUserSecurity);

	/**
	 * 
	 * selectByPhone:(通过用电话查询用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select client_user_id as clientUserId ,client_user_security as clientUserSecurity,"
			+ " client_user_cellphone as clientUserCellphone, client_user_sex as clientUserSex,"
			+ " client_user_nick_name as clientUserNickName, client_user_birthday as clientUserBirthday,"
			+ " client_user_sign_up_time as clientUserSignUpTime,client_user_active_mark as  clientUserActiveMark ,"
			+ "client_user_auto_pay as clientUserAutoPay  ,client_user_type as clientUserType from client_user where client_user_cellphone = #{clientUserCellphone} and client_user_security = #{clientUserSecurity}")
	public ClientUser selectByPhone(@Param("clientUserCellphone") String clientUserCellphone,
			@Param("clientUserSecurity") String clientUserSecurity);

	/**
	 * 
	 * updateUser:(更新用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * 
	 * @param clientUserNickName
	 *            汽车车主昵称
	 * @param clientUserBirthday
	 *            汽车车主生日
	 * @param clientUserSex
	 *            汽车车主性别
	 * @param clientUserCellphone
	 *            汽车车主电话
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return int
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE client_user SET client_user_nick_name = #{clientUserNickName}, client_user_birthday = #{clientUserBirthday},client_user_sex = #{clientUserSex} WHERE client_user_cellphone= #{clientUserCellphone} and client_user_security = #{clientUserSecurity}")
	public int updateUser(@Param("clientUserNickName") String clientUserNickName,
			@Param("clientUserBirthday") String clientUserBirthday, @Param("clientUserSex") String clientUserSex,
			@Param("clientUserCellphone") String clientUserCellphone,
			@Param("clientUserSecurity") String clientUserSecurity);

	/**
	 * 
	 * upClientUserSecurity:(更新汽车车主用户安全识令牌). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @param clientUserCellphone
	 *            汽车车主电话
	 * @return int
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE client_user SET client_user_security = #{clientUserSecurity} WHERE (client_user_cellphone= #{clientUserCellphone})")
	public int upClientUserSecurity(@Param("clientUserSecurity") String clientUserSecurity,
			@Param("clientUserCellphone") String clientUserCellphone);

	/**
	 * 
	 * upClientUserActiveMark:(修改用户激活状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(enable可用,disable为不可用).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserActiveMark
	 *            汽车车主用户激活状态标记
	 * @param clientUserCellphone
	 *            汽车车主电话
	 * @return int
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE client_user SET client_user_active_mark = #{clientUserActiveMark} WHERE (client_user_cellphone= #{clientUserCellphone})")
	public int upClientUserActiveMark(@Param("clientUserActiveMark") String clientUserActiveMark,
			@Param("clientUserCellphone") String clientUserCellphone);

	/**
	 * 
	 * upUserPhone:(更改用户手机号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 *            汽车车主用户手机号
	 * @param clientUserId
	 *            汽车车主用户id
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE client_user SET client_user_cellphone = #{clientUserCellphone} WHERE client_user_id= #{clientUserId} and client_user_security = #{clientUserSecurity}")
	public int upUserPhone(@Param("clientUserSecurity") String clientUserSecurity,
			@Param("clientUserCellphone") String clientUserCellphone, @Param("clientUserId") String clientUserId);

	/**
	 * 
	 * upUserAutoPay:(是否自动支付 0为不自动支付 1为自动支付). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserAutoPay
	 *            自动支付
	 * @param clientUserSecurity
	 *            手机令牌
	 * @param clientUserId
	 *            用户id
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE client_user SET client_user_auto_pay = #{clientUserAutoPay} WHERE client_user_id= #{clientUserId} and client_user_security = #{clientUserSecurity}")
	public int upUserAutoPay(@Param("clientUserAutoPay") String clientUserAutoPay,
			@Param("clientUserSecurity") String clientUserSecurity, @Param("clientUserId") String clientUserId);

	/**
	 * 
	 * addRegistrAtionId:(添加用户推送信息账户名). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserRegistrAtionId
	 *            推送id
	 * @param clientUserId
	 *            用户id
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE client_user SET client_user_registr_ation_id= #{clientUserRegistrAtionId} , client_user_type = #{clientUserType} WHERE client_user_id= #{clientUserId}")
	public int addRegistrAtionId(@Param("clientUserRegistrAtionId") String clientUserRegistrAtionId,
			@Param("clientUserId") String clientUserId, @Param("clientUserType") String clientUserType);

	/**
	 * 
	 * hasPhoneNumber:(查询电话号码是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 *            用户手机号码
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT count(*) c  from client_user where client_user_cellphone= #{clientUserCellphone}")
	public int hasPhoneNumber(@Param("clientUserCellphone") String clientUserCellphone);

	/**
	 * 
	 * deleteUser:(通过clientUserId删除用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 *            汽车车主ID
	 * @return int
	 * @since JDK 1.8u60
	 */
	@Delete("DELETE FROM client_user WHERE (client_user_id= #{clientUserId})")
	public int deleteUser(@Param("clientUserId") String clientUserId);

	/**
	 * 
	 * selectUser:(查询全部用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return List<ClientUser>
	 * @since JDK 1.8u60
	 */
	@Select("select client_user_id as clientUserId ,client_user_security as clientUserSecurity,"
			+ " client_user_cellphone as clientUserCellphone, client_user_sex as clientUserSex,"
			+ " client_user_nick_name as clientUserNickName, client_user_birthday as clientUserBirthday,"
			+ " client_user_sign_up_time as clientUserSignUpTime,client_user_active_mark as  clientUserActiveMark ,"
			+ "client_user_auto_pay as clientUserAutoPay ,client_user_registr_ation_id  as  clientUserRegistrAtionId  ,client_user_type as clientUserType from client_user")
	public List<ClientUser> selectUser();

	/**
	 * 
	 * hasUserSecurity:(用户验证). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @param clientUserSecurity
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT  count(*) c  from client_user where client_user_security =#{clientUserSecurity} and client_user_id = #{clientUserId}")
	public int hasUserSecurity(@Param("clientUserId") String clientUserId,
			@Param("clientUserSecurity") String clientUserSecurity);

	/**
	 * 
	 * selectClientUserById:(通过用户id查询用户（服务端内方法）). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select client_user_id as clientUserId ,client_user_security as clientUserSecurity,"
			+ " client_user_cellphone as clientUserCellphone, client_user_sex as clientUserSex,"
			+ " client_user_nick_name as clientUserNickName, client_user_birthday as clientUserBirthday,"
			+ " client_user_sign_up_time as clientUserSignUpTime,client_user_active_mark as  clientUserActiveMark ,"
			+ "client_user_auto_pay as clientUserAutoPay ,client_user_registr_ation_id  as  clientUserRegistrAtionId ,client_user_type as clientUserType  from client_user where client_user_id = #{clientUserId} ")
	public ClientUser selectClientUserById(@Param("clientUserId") String clientUserId);

	/**
	 * 
	 * selectByPhones:(通过电话号码查询用户（服务端内方法）). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select client_user_id as clientUserId ,client_user_security as clientUserSecurity,"
			+ " client_user_cellphone as clientUserCellphone, client_user_sex as clientUserSex,"
			+ " client_user_nick_name as clientUserNickName, client_user_birthday as clientUserBirthday,"
			+ " client_user_sign_up_time as clientUserSignUpTime,client_user_active_mark as  clientUserActiveMark ,"
			+ "client_user_auto_pay as clientUserAutoPay , client_user_registr_ation_id  as  clientUserRegistrAtionId ,client_user_type as clientUserType from client_user  where client_user_cellphone = #{clientUserCellphone} ")
	public ClientUser selectByPhones(@Param("clientUserCellphone") String clientUserCellphone);
}
