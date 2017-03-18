/**
 * Project Name:OnlineParking
 * File Name:SubFundAccountSeqServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.fundAccountManage.impl
 * Date:2015年10月10日下午4:55:34
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.fundAccountManage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.fundAccountManage.QuerySubFundDao;
import com.yinzitech.onlineparking.dao.fundAccountManage.SubFundAccountSeqDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.fundAccountManage.SubFundAccountSeq;
import com.yinzitech.onlineparking.service.fundAccountManage.SubFundAccountSeqService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.TimeTools;
import com.yinzitech.onlineparking.utils.PageHelper.Page;

/**
 * ClassName:SubFundAccountSeqServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月10日 下午4:55:34 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class SubFundAccountSeqServiceImpl implements SubFundAccountSeqService {
	@Autowired
	SubFundAccountSeqDao subFundAccountSeqDao;
	@Autowired
	QuerySubFundDao querySubFundDao;

	/**
	 * 
	 * TODO 通过用户ID查询账单流水（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.fundAccountManage.SubFundAccountSeqService#selectSubFundAccountSeqByClientUserId(java.lang.String)
	 */
	@Override
	public String selectSubFundAccountSeqByClientUserId(String subFundAccountSeqClientUserId) {
		String json = "";

		List<SubFundAccountSeq> list = subFundAccountSeqDao
				.selectSubFundAccountSeqByClientUserId(subFundAccountSeqClientUserId);
		if (list.size() > 0 & list != null) {
			json = ResultObjectList.obj2JsonResult("1", "查询流水成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "当前无流水记录", "");
		}

		return json;
	}

	/**
	 * 创建流水订单
	 */
	@Override
	public String creatSubFundAccountSeq(String subFundAccountSeqFundAccountId, String subFundAccountSeqClientUserId,
			String subFundAccountSeqClientUserCellphone, String subFundAccountSeqFlag,
			String subFundAccountSeqChangeType, String subFundAccountSeqPreAmount, String subFundAccountSeqAmount,
			String subFundAccountSeqRefsnOrderType, String subFundAccountSeqRefsnOrderId) {
		// 获取用户最后一笔交易流水
		SubFundAccountSeq subFund = subFundAccountSeqDao.DescByCreatTime(subFundAccountSeqClientUserId);
		String subFundAccountSeqPreRefsnOrderType = "";
		String subFundAccountSqePreRefsnOrderId = "";
		// 判断交易流水是否存在
		if (subFund != null) {
			subFundAccountSeqPreRefsnOrderType = subFund.getSubFundAccountSeqRefsnOrderType();
			subFundAccountSqePreRefsnOrderId = subFund.getSubFundAccountSeqRefsnOrderId();
		}
		String json = "";
		String subFundAccountSeqId = ToolsIdGenerator.getUUID();
		String subFundAccountSeqCreateTime = TimeTools.getCurrentTime();
		// 创建交易流水订单
		int i = subFundAccountSeqDao.creatSubFundAccountSeq(subFundAccountSeqId, subFundAccountSeqFundAccountId,
				subFundAccountSeqClientUserId, subFundAccountSeqClientUserCellphone, subFundAccountSeqFlag,
				subFundAccountSeqChangeType, subFundAccountSeqPreAmount, subFundAccountSeqAmount,
				subFundAccountSeqRefsnOrderType, subFundAccountSeqRefsnOrderId, subFundAccountSeqPreRefsnOrderType,
				subFundAccountSqePreRefsnOrderId, subFundAccountSeqCreateTime);
		if (i > 0) {
			SubFundAccountSeq subFundAccountSeq = subFundAccountSeqDao.selectBySubFundAccountSeqId(subFundAccountSeqId);
			json = ResultObject.obj2JsonResult("1", "生成流水账单成功", subFundAccountSeq);
		} else {
			json = ResultResponse.obj2JsonResult("0", "生成流水账单失败", "");
		}

		return json;
	}

	/**
	 * TODO 流水订单查询（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.fundAccountManage.SubFundAccountSeqService#getSubFund()
	 */
	@Override
	public String getSubFund(String subFundAccountSeqClientUserId, String subFundAccountSeqClientUserCellphone,
			String subFundAccountSeqFlag, String subFundAccountSeqChangeType, String subFundAccountSeqRefsnOrderType,
			String subFundAccountSeqPreRefsnOrderType, String subFundAccountSeqRefsnOrderId,
			String subFundAccountSqePreRefsnOrderId, String startTime, String endTime) {
		String json = "";
		List<SubFundAccountSeq> list = querySubFundDao.getSubFund(subFundAccountSeqClientUserId,
				subFundAccountSeqClientUserCellphone, subFundAccountSeqFlag, subFundAccountSeqChangeType,
				subFundAccountSeqRefsnOrderType, subFundAccountSeqPreRefsnOrderType, subFundAccountSeqRefsnOrderId,
				subFundAccountSqePreRefsnOrderId, startTime, endTime);
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * TODO 流水订单分页查询（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.fundAccountManage.SubFundAccountSeqService#getSubFund()
	 */
	@Override
	public String getSubFundLimit(String subFundAccountSeqClientUserId, String subFundAccountSeqClientUserCellphone,
			String subFundAccountSeqFlag, String subFundAccountSeqChangeType, String subFundAccountSeqRefsnOrderType,
			String subFundAccountSeqPreRefsnOrderType, String subFundAccountSeqRefsnOrderId,
			String subFundAccountSqePreRefsnOrderId, String startTime, String endTime, int pageNumber, int pageSize) {
		String json = "";
		PageHelper.startPage(pageNumber, pageSize);
		List<SubFundAccountSeq> list = querySubFundDao.getSubFund(subFundAccountSeqClientUserId,
				subFundAccountSeqClientUserCellphone, subFundAccountSeqFlag, subFundAccountSeqChangeType,
				subFundAccountSeqRefsnOrderType, subFundAccountSeqPreRefsnOrderType, subFundAccountSeqRefsnOrderId,
				subFundAccountSqePreRefsnOrderId, startTime, endTime);
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "查询失败", "");
		}
		System.out.println(json);
		return json;
	}

}
