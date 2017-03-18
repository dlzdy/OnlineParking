/**
 * Project Name:OnlineParking
 * File Name:SecurityCoreService.java
 * Package Name:com.yinzitech.onlineparking.service.securityCore
 * Date:2015年10月13日下午3:33:19
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.securityCore;

/**
 * ClassName:SecurityCoreService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午3:33:19 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface SecurityCoreService {

	/* base method */
	/* 新增 */
	public String createSecurity(String securityCoreId, String securityCoreAccountType, String securityCoreAccountId,
			String securityCoreAccountSecurity, String securityCoreState, String securityCoreCreateTime);

	/* 按照密匙验证类关联账户id查询 */
	public String retrieveById(String securityCoreAccountType, String securityCoreAccountId);

	/* 按照Id查询 */
	public String retrieve(String securityCoreId);

	/* 查询所有 */
	public String retrieveList();

	/* 根据id更新所有 */
	public String update(String securityCoreId, String securityCoreAccountType, String securityCoreAccountId,
			String securityCoreAccountSecurity, String securityCoreState, String securityCoreCreateTime);

	/* 根据id更新秘钥 */
	public String updateSecurity(String securityCoreId, String securityCoreAccountSecurity);

	/* 根据秘钥管理类关联的用户Id,更新秘钥 */
	public String updateSecurityBySecurityCoreAccountId(String securityCoreAccountType, String securityCoreAccountId,
			String securityCoreAccountSecurity);

	/* 根据id更新状态 */
	public String updateState(String securityCoreId, String securityCoreState);

	/* 删除 */
	public String delete(String securityCoreId);

}
