/**
 * Project Name:OnlineParking
 * File Name:fundAccountManageDao.java
 * Package Name:com.yinzitech.onlineparking.dao.fundAccountManage
 * Date:2015年10月5日上午12:40:54
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.dao.fundAccountManage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.fundAccountManage.FundAccountManage;

/**
 * ClassName: fundAccountManageDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年10月5日 上午12:40:54 <br/>
 *
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 */
public interface FundAccountManageDao {
	/**
	 * 
	 * insertFundAccountManage:(创建资金管理账户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param fundAccountId
	 *            资金管理账户id
	 * @param custId
	 *            用户账户编号
	 * @param subaccountType
	 *            关联账户号类型 type 1) 终端用户 对应client_user 使用表中的client_user_id type 2)
	 *            停车场场主 对应parking_manager 使用表中的parking_manager_id type 3) 手持机管理员
	 *            对应handset_manager使用表中的handset_manager_id
	 * @param fundAccountManageProperty
	 *            账户性质 type 1 个人用户账户 type 2 企业用户账户
	 * @param fundAccountManageCreateTime
	 *            资金账户创建时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO fund_account_manage (fund_account_id, cust_id, subaccount_type, fund_account_manage_property, fund_account_manage_create_time) VALUES (#{fundAccountId},#{custId},#{subaccountType},#{fundAccountManageProperty},#{fundAccountManageCreateTime})")
	public int insertFundAccountManage(@Param("fundAccountId") String fundAccountId, @Param("custId") String custId,
			@Param("subaccountType") String subaccountType,
			@Param("fundAccountManageProperty") String fundAccountManageProperty,
			@Param("fundAccountManageCreateTime") String fundAccountManageCreateTime);

	/**
	 * 
	 * selectByCustId:(通过用户custId查找资金账户详细信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param custId
	 *            用户ID
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT fund_account_id as fundAccountId,cust_id  as custId,"
			+ "subaccount_type as subaccountType,fund_account_manage_amount as fundAccountManageAmount,"
			+ "fund_account_manage_property as fundAccountManageProperty ,"
			+ "fund_account_manage_state as fundAccountManageState "
			+ "FROM fund_account_manage WHERE cust_id=#{custId}")
	public FundAccountManage selectByCustId(@Param("custId") String custId);

	/**
	 * 
	 * hasFundAccountManage:(判断资金账户是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param custId
	 *            用户账户编号
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT count(*) c FROM fund_account_manage WHERE cust_id =#{custId} ")
	public int hasFundAccountManage(@Param("custId") String custId);

	/**
	 * 
	 * upFundAccountManageState:(修改资金用户状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param custId
	 *            用户账户编号
	 * @param fundAccountManageState
	 *            账户状态
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE fund_account_manage SET fund_account_manage_state = #{fundAccountManageState} WHERE cust_id = #{custId}")
	public int upFundAccountManageState(@Param("custId") String custId,
			@Param("fundAccountManageState") String fundAccountManageState);

	/**
	 * 
	 * upFundAccountManageAmount:(更新用户资金金额). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param custId
	 *            用户账户编号
	 * @param fundAccountManageAmount
	 *            账户名下总金额
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE fund_account_manage SET fund_account_manage_amount=#{fundAccountManageAmount} WHERE cust_id = #{custId}")
	public int upFundAccountManageAmount(@Param("custId") String custId,
			@Param("fundAccountManageAmount") String fundAccountManageAmount);

}
