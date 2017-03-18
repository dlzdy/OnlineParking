/**
 * Project Name:OnlineParking
 * File Name:QueryFundAccountDao.java
 * Package Name:com.yinzitech.onlineparking.dao.fundAccountManage
 * Date:2015年11月1日下午12:09:45
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.dao.fundAccountManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.fundAccountManage.FundAccountManage;

 
/**
 * ClassName: QueryFundAccountDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年11月1日 下午12:09:45 <br/>
 *
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 */
public interface QueryFundAccountDao {

	public List<FundAccountManage> getFund(
			@Param("fundAccountId") String fundAccountId,
			@Param("custId") String custId,
			@Param("subaccountType") String subaccountType,
			@Param("fundAccountManageProperty") String fundAccountManageProperty,
			@Param("fundAccountManageState") String fundAccountManageState,
			@Param("startTime") String startTime,
			@Param("endTime") String endTime);

}
