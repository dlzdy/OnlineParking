/**
 * Project Name:OnlineParking
 * File Name:SubFundAccountSeqDao.java
 * Package Name:com.yinzitech.onlineparking.dao.fundAccountManage
 * Date:2015年10月10日下午2:18:24
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.fundAccountManage;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.fundAccountManage.SubFundAccountSeq;

/**
 * ClassName:SubFundAccountSeqDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月10日 下午2:18:24 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface SubFundAccountSeqDao {
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
	@Select("SELECT sub_fund_account_seq_id as subFundAccountSeqId,"
			+ "sub_fund_account_seq_fund_account_id as subFundAccountSeqFundAccountId,"
			+ "sub_fund_account_seq_client_user_id as subFundAccountSeqClientUserId,"
			+ "sub_fund_account_seq_client_user_cellphone as subFundAccountSeqClientUserCellphone,"
			+ "sub_fund_account_seq_flag as subFundAccountSeqFlag,"
			+ " sub_fund_account_seq_change_type as subFundAccountSeqChangeType,"
			+ "sub_fund_account_seq_pre_amount as subFundAccountSeqPreAmount,"
			+ "sub_fund_account_seq_amount as subFundAccountSeqAmount,"
			+ "sub_fund_account_seq_refsn_order_type as subFundAccountSeqRefsnOrderType,"
			+ "sub_fund_account_seq_refsn_order_id as subFundAccountSeqRefsnOrderId,"
			+ "sub_fund_account_seq_pre_refsn_order_type as subFundAccountSeqPreRefsnOrderType,"
			+ "sub_fund_account_seq_pre_refsn_order_id as subFundAccountSqePreRefsnPrderId ,"
			+ "sub_fund_account_seq_create_time as subFundAccountSeqCreateTime "
			+ "FROM sub_fund_account_seq WHERE sub_fund_account_seq_client_user_id = #{subFundAccountSeqClientUserId}")
	public List<SubFundAccountSeq> selectSubFundAccountSeqByClientUserId(
			@Param("subFundAccountSeqClientUserId") String subFundAccountSeqClientUserId);

	/**
	 * 
	 * selectBySubFundAccountSeqId:(通过Id查看订单信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSeqId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT sub_fund_account_seq_id as subFundAccountSeqId,"
			+ "sub_fund_account_seq_fund_account_id as subFundAccountSeqFundAccountId,"
			+ "sub_fund_account_seq_client_user_id as subFundAccountSeqClientUserId,"
			+ "sub_fund_account_seq_client_user_cellphone as subFundAccountSeqClientUserCellphone,"
			+ "sub_fund_account_seq_flag as subFundAccountSeqFlag,"
			+ " sub_fund_account_seq_change_type as subFundAccountSeqChangeType,"
			+ "sub_fund_account_seq_pre_amount as subFundAccountSeqPreAmount,"
			+ "sub_fund_account_seq_amount as subFundAccountSeqAmount,"
			+ "sub_fund_account_seq_refsn_order_type as subFundAccountSeqRefsnOrderType,"
			+ "sub_fund_account_seq_refsn_order_id as subFundAccountSeqRefsnOrderId,"
			+ "sub_fund_account_seq_pre_refsn_order_type as subFundAccountSeqPreRefsnOrderType,"
			+ "sub_fund_account_seq_pre_refsn_order_id as subFundAccountSqePreRefsnPrderId ,"
			+ "sub_fund_account_seq_create_time as subFundAccountSeqCreateTime "
			+ " FROM sub_fund_account_seq WHERE sub_fund_account_seq_id = #{subFundAccountSeqId}")
	public SubFundAccountSeq selectBySubFundAccountSeqId(@Param("subFundAccountSeqId") String subFundAccountSeqId);

	/**
	 * 
	 * hasSubFundAccountOrderId:(判断订单是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSeqClientUserId
	 *            资金管理账户资金变动流水表对应用户 id
	 * @param subFundAccountSeqRefsnOrderId
	 *            资金管理账户资金变动流水关联的订单id
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT COUNT(*) c FROM sub_fund_account_seq WHERE sub_fund_account_seq_client_user_id = #{subFundAccountSeqClientUserId}")
	public int hasSubFundAccountOrderId(@Param("subFundAccountSeqClientUserId") String subFundAccountSeqClientUserId);

	/**
	 * 
	 * creatSubFundAccountSeq:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSeqId
	 *            资金管理账户资金变动流水表主键 id
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
	 * @param subFundAccountSeqCreateTime
	 *            资金账户创建时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO sub_fund_account_seq (sub_fund_account_seq_id, sub_fund_account_seq_fund_account_id, sub_fund_account_seq_client_user_id, sub_fund_account_seq_client_user_cellphone, sub_fund_account_seq_flag, sub_fund_account_seq_change_type, sub_fund_account_seq_pre_amount, sub_fund_account_seq_amount, sub_fund_account_seq_refsn_order_type, sub_fund_account_seq_refsn_order_id, sub_fund_account_seq_pre_refsn_order_type, sub_fund_account_seq_pre_refsn_order_id,sub_fund_account_seq_create_time) VALUES (#{subFundAccountSeqId},#{subFundAccountSeqFundAccountId},#{subFundAccountSeqClientUserId},#{subFundAccountSeqClientUserCellphone},#{subFundAccountSeqFlag},#{subFundAccountSeqChangeType},#{subFundAccountSeqPreAmount},#{subFundAccountSeqAmount},#{subFundAccountSeqRefsnOrderType},#{subFundAccountSeqRefsnOrderId},#{subFundAccountSeqPreRefsnOrderType},#{subFundAccountSqePreRefsnOrderId},#{subFundAccountSeqCreateTime})")
	public int creatSubFundAccountSeq(@Param("subFundAccountSeqId") String subFundAccountSeqId,
			@Param("subFundAccountSeqFundAccountId") String subFundAccountSeqFundAccountId,
			@Param("subFundAccountSeqClientUserId") String subFundAccountSeqClientUserId,
			@Param("subFundAccountSeqClientUserCellphone") String subFundAccountSeqClientUserCellphone,
			@Param("subFundAccountSeqFlag") String subFundAccountSeqFlag,
			@Param("subFundAccountSeqChangeType") String subFundAccountSeqChangeType,
			@Param("subFundAccountSeqPreAmount") String subFundAccountSeqPreAmount,
			@Param("subFundAccountSeqAmount") String subFundAccountSeqAmount,
			@Param("subFundAccountSeqRefsnOrderType") String subFundAccountSeqRefsnOrderType,
			@Param("subFundAccountSeqRefsnOrderId") String subFundAccountSeqRefsnOrderId,
			@Param("subFundAccountSeqPreRefsnOrderType") String subFundAccountSeqPreRefsnOrderType,
			@Param("subFundAccountSqePreRefsnOrderId") String subFundAccountSqePreRefsnOrderId,
			@Param("subFundAccountSeqCreateTime") String subFundAccountSeqCreateTime);

	/**
	 * 
	 * upSubFundAccountSeqRefsnOrderId:(更新上次资金变动订单号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSqePreRefsnOrderId
	 *            trading_order_id 订单id
	 * @param subFundAccountSeqId
	 *            资金管理账户资金变动流水表主键 id
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE sub_fund_account_seq SET sub_fund_account_seq_pre_refsn_order_id=#{subFundAccountSqePreRefsnOrderId} WHERE sub_fund_account_seq_id=#{subFundAccountSeqId}")
	public int upSubFundAccountSeqRefsnOrderId(
			@Param("subFundAccountSqePreRefsnOrderId") String subFundAccountSqePreRefsnOrderId,
			@Param("subFundAccountSeqId") String subFundAccountSeqId);

	/**
	 * 
	 * upSubFundAccountSqePhoneByClientUserId:(更新手机号码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param subFundAccountSeqClientUserId
	 *            资金管理账户资金变动流水表对应用户 id
	 * @param subFundAccountSeqClientUserCellphone
	 *            资金管理账户资金变动流水表对应用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE sub_fund_account_seq SET sub_fund_account_seq_client_user_cellphone= #{subFundAccountSeqClientUserCellphone} WHERE  sub_fund_account_seq_client_user_id = #{subFundAccountSeqClientUserId} ")
	public int upSubFundAccountSqePhoneByClientUserId(
			@Param("subFundAccountSeqClientUserId") String subFundAccountSeqClientUserId,
			@Param("subFundAccountSeqClientUserCellphone") String subFundAccountSeqClientUserCellphone);

	/**
	 * 
	 * DescByCreatTime:(获取上一次订单信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT sub_fund_account_seq_id as subFundAccountSeqId,"
			+ "sub_fund_account_seq_fund_account_id as subFundAccountSeqFundAccountId,"
			+ "sub_fund_account_seq_client_user_id as subFundAccountSeqClientUserId,"
			+ "sub_fund_account_seq_client_user_cellphone as subFundAccountSeqClientUserCellphone,"
			+ "sub_fund_account_seq_flag as subFundAccountSeqFlag,"
			+ " sub_fund_account_seq_change_type as subFundAccountSeqChangeType,"
			+ "sub_fund_account_seq_pre_amount as subFundAccountSeqPreAmount,"
			+ "sub_fund_account_seq_amount as subFundAccountSeqAmount,"
			+ "sub_fund_account_seq_refsn_order_type as subFundAccountSeqRefsnOrderType,"
			+ "sub_fund_account_seq_refsn_order_id as subFundAccountSeqRefsnOrderId,"
			+ "sub_fund_account_seq_pre_refsn_order_type as subFundAccountSeqPreRefsnOrderType,"
			+ "sub_fund_account_seq_pre_refsn_order_id as subFundAccountSqePreRefsnPrderId ,"
			+ "sub_fund_account_seq_create_time as subFundAccountSeqCreateTime "
			+ " FROM sub_fund_account_seq WHERE sub_fund_account_seq_client_user_id = #{subFundAccountSeqClientUserId} ORDER BY sub_fund_account_seq_create_time DESC LIMIT 0,1")
	public SubFundAccountSeq DescByCreatTime(
			@Param("subFundAccountSeqClientUserId") String subFundAccountSeqClientUserId);
}
