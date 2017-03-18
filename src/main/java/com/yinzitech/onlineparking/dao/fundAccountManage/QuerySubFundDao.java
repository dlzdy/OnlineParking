/**
 * Project Name:OnlineParking
 * File Name:QuerySubFundDao.java
 * Package Name:com.yinzitech.onlineparking.dao.fundAccountManage
 * Date:2015年11月1日下午12:30:53
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.dao.fundAccountManage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.fundAccountManage.SubFundAccountSeq;

 
/**
 * ClassName: QuerySubFundDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年11月1日 下午12:30:53 <br/>
 *
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 */
public interface QuerySubFundDao {

	public List<SubFundAccountSeq> getSubFund(
			@Param("subFundAccountSeqClientUserId") String subFundAccountSeqClientUserId,
			@Param("subFundAccountSeqClientUserCellphone") String subFundAccountSeqClientUserCellphone,
			@Param("subFundAccountSeqFlag") String subFundAccountSeqFlag,
			@Param("subFundAccountSeqChangeType") String subFundAccountSeqChangeType,
			@Param("subFundAccountSeqRefsnOrderType") String subFundAccountSeqRefsnOrderType,
			@Param("subFundAccountSeqPreRefsnOrderType") String subFundAccountSeqPreRefsnOrderType,
			@Param("subFundAccountSeqRefsnOrderId") String subFundAccountSeqRefsnOrderId,
			@Param("subFundAccountSqePreRefsnOrderId") String subFundAccountSqePreRefsnOrderId,
			@Param("startTime") String startTime,
			@Param("endTime") String endTime);

}
