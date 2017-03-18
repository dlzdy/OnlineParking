/**
 * Project Name:OnlineParking
 * File Name:SubFundAccountSeqService.java
 * Package Name:com.yinzitech.onlineparking.service.fundAccountManage
 * Date:2015年10月10日下午4:44:02
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.fundAccountManage;

/**
 * ClassName:SubFundAccountSeqService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月10日 下午4:44:02 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface SubFundAccountSeqService {
	/**
	 * 
	 * selectSubFundAccountSeqByClientUserId:(通过用户ID查询账单流水). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSeqClientUserId
	 *            资金管理账户资金变动流水表对应用户 id
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectSubFundAccountSeqByClientUserId(String subFundAccountSeqClientUserId);

	/**
	 * 
	 * creatSubFundAccountSeq:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSeqFundAccountId
	 *            资金管理账户资金变动流水表对应用户资金管理账户 id
	 * @param subFundAccountSeqClientUserId
	 *            资金管理账户资金变动流水表对应用户 id
	 * @param subFundAccountSeqClientUserCellphone
	 *            资金管理账户资金变动流水表对应用户手机号
	 * @param subFundAccountSeqFlag
	 *            资金管理账户资金变动流水中账户变动方向 长度 1 0 来账 表示为账户收款 1 往账 表示为账户付款
	 * @param subFundAccountSeqChangeType
	 *            资金管理账户资金变动流水中账户变动类型 交易支付 03 提现 04 内部调账 05 结息 06 利息税 07 原交易退款
	 *            08 原交易撤销
	 * @param subFundAccountSeqPreAmount
	 *            资金管理账户资金变动流水中账户变动之前的账户内金额
	 * @param subFundAccountSeqAmount
	 *            资金管理账户资金变动流水中账户变动的账户内金额
	 * @param subFundAccountSeqRefsnOrderType
	 *            资金管理账户资金变动流水关联的订单类型 001 关联支付订单 002 关联交易订单 003 关联提现订单
	 * @param subFundAccountSeqRefsnOrderId
	 *            资金管理账户资金变动流水关联的订单id trading_order_id
	 * @param subFundAccountSeqPreRefsnOrderType
	 *            资金管理账户上次资金变动流水关联的订单类型 001 关联支付订单 002 关联交易订单 003 关联提现订单'
	 * @param subFundAccountSqePreRefsnOrderId
	 *            资金管理账户上次资金变动流水关联的订单id trading_order_id
	 * 
	 * @return
	 * @since JDK 1.8u60
	 */
	public String creatSubFundAccountSeq(String subFundAccountSeqFundAccountId, String subFundAccountSeqClientUserId,
			String subFundAccountSeqClientUserCellphone, String subFundAccountSeqFlag,
			String subFundAccountSeqChangeType, String subFundAccountSeqPreAmount, String subFundAccountSeqAmount,
			String subFundAccountSeqRefsnOrderType, String subFundAccountSeqRefsnOrderId);

	/**
	 * 
	 * getSubFund:(获取账单信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSeqClientUserId
	 * @param subFundAccountSeqClientUserCellphone
	 * @param subFundAccountSeqFlag
	 * @param subFundAccountSeqChangeType
	 * @param subFundAccountSeqRefsnOrderType
	 * @param subFundAccountSeqPreRefsnOrderType
	 * @param subFundAccountSeqRefsnOrderId
	 * @param subFundAccountSqePreRefsnOrderId
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getSubFund(String subFundAccountSeqClientUserId, String subFundAccountSeqClientUserCellphone,
			String subFundAccountSeqFlag, String subFundAccountSeqChangeType, String subFundAccountSeqRefsnOrderType,
			String subFundAccountSeqPreRefsnOrderType, String subFundAccountSeqRefsnOrderId,
			String subFundAccountSqePreRefsnOrderId, String startTime, String endTime);

	/**
	 * 
	 * getSubFundLimit:(获取账单信息分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSeqClientUserId
	 * @param subFundAccountSeqClientUserCellphone
	 * @param subFundAccountSeqFlag
	 * @param subFundAccountSeqChangeType
	 * @param subFundAccountSeqRefsnOrderType
	 * @param subFundAccountSeqPreRefsnOrderType
	 * @param subFundAccountSeqRefsnOrderId
	 * @param subFundAccountSqePreRefsnOrderId
	 * @param startTime
	 * @param endTime
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getSubFundLimit(String subFundAccountSeqClientUserId, String subFundAccountSeqClientUserCellphone,
			String subFundAccountSeqFlag, String subFundAccountSeqChangeType, String subFundAccountSeqRefsnOrderType,
			String subFundAccountSeqPreRefsnOrderType, String subFundAccountSeqRefsnOrderId,
			String subFundAccountSqePreRefsnOrderId, String startTime, String endTime, int pageNumber, int pageSize);
}
