 /**
 * Project Name:OnlineParking
 * File Name:QueryClientUserDao.java
 * Package Name:com.yinzitech.onlineparking.dao.client
 * Date:2015年10月31日下午12:45:34
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.dao.client;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.client.user.ClientUser;

/**
 * ClassName:QueryClientUserDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午12:45:34 <br/>
 * @author   ziheng
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
/**
 * ClassName: QueryClientUserDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年10月31日 下午12:45:34 <br/>
 *
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 */
public interface QueryClientUserDao {

	public List<ClientUser> getUser(@Param("clientUserId") String clientUserId,
			@Param("clientUserCellphone") String clientUserCellphone, @Param("clientUserSex") String clientUserSex,
			@Param("startBirthday") String startBirthday, @Param("endBirthday") String endBirthday,
			@Param("startUpTime") String startUpTime, @Param("endUpTime") String endUpTime,
			@Param("clientUserActiveMark") String clientUserActiveMark,
			@Param("clientUserAutoPay") String clientUserAutoPay, @Param("registrAtionId") String registrAtionId,
			@Param("clientUserSecurity") String clientUserSecurity, @Param("clientUserType") String clientUserType);

	public int updateUser(@Param("clientUserNickName") String clientUserNickName,
			@Param("clientUserBirthday") String clientUserBirthday, @Param("clientUserSex") String clientUserSex,
			@Param("clientUserCellphone") String clientUserCellphone,
			@Param("clientUserSecurity") String clientUserSecurity);

}
