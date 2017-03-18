/**
 * Project Name:OnlineParking
 * File Name:SecurityCoreServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.securityCore.impl
 * Date:2015年10月13日下午3:45:08
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.securityCore.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzitech.onlineparking.dao.securityCore.SecurityCoreDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.securityCore.SecurityCore;
import com.yinzitech.onlineparking.service.securityCore.SecurityCoreService;

/**
 * ClassName:SecurityCoreServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午3:45:08 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
@Service
public class SecurityCoreServiceImpl implements SecurityCoreService {
	@Autowired
	SecurityCoreDao securityCoreDao;

	/* 新增 */
	@Override
	public String createSecurity(String securityCoreId, String securityCoreAccountType, String securityCoreAccountId,
			String securityCoreAccountSecurity, String securityCoreState, String securityCoreCreateTime) {

		int target = securityCoreDao.create(securityCoreId, securityCoreAccountType, securityCoreAccountId,
				securityCoreAccountSecurity, securityCoreState, securityCoreCreateTime);
		if (target > 0) {
			System.err.println("用户id" + securityCoreAccountId + "创建秘钥成功");
			return ResultResponse.obj2JsonResult("1", "用户id" + securityCoreAccountId + "创建秘钥成功", securityCoreId);
		} else {
			System.err.println("用户id" + securityCoreAccountId + "创建秘钥失败");
			return ResultResponse.obj2JsonResult("0", "用户id" + securityCoreAccountId + "创建秘钥失败", "");

		}
	}

	@Override
	/* 按照密匙验证类关联账户id查询 */
	public String retrieveById(String securityCoreAccountType, String securityCoreAccountId) {
		SecurityCore sc = securityCoreDao.retrieveById(securityCoreAccountType, securityCoreAccountId);
		if (null != sc) {

			System.err.println("用户id为" + securityCoreAccountId + "的秘钥查询,查询成功");
			return ResultObject.obj2JsonResult("1", "查询成功", sc);
		} else {
			System.err.println("用户id为" + securityCoreAccountId + "的秘钥查询,查询失败");
			return ResultObject.obj2JsonResult("0", "查询失败", "");

		}
	}

	/* 按照Id查询 */
	@Override
	public String retrieve(String securityCoreId) {
		SecurityCore sc = securityCoreDao.retrieve(securityCoreId);
		if (null != sc) {
			System.err.println("秘钥id为" + securityCoreId + "的秘钥查询,查询成功");
			return ResultObject.obj2JsonResult("1", "查询成功", sc);
		} else {
			System.err.println("秘钥id为" + securityCoreId + "的秘钥查询,查询失败");
			return ResultObject.obj2JsonResult("0", "查询失败", "");

		}
	}

	/* 查询所有 */
	@Override
	public String retrieveList() {
		List<SecurityCore> list = securityCoreDao.retrieveList();
		if (list.size() > 0) {
			System.err.println("所有秘钥查询,查询成功");
			return ResultObjectList.obj2JsonResult("1", "查询所有秘钥成功", list);
		} else {
			System.err.println("所有秘钥查询,查询失败");
			return ResultObjectList.obj2JsonResult("0", "查询所有秘钥失败", list);

		}
	}

	/* 更新秘钥所有信息根据秘钥id */
	@Override
	public String update(String securityCoreId, String securityCoreAccountType, String securityCoreAccountId,
			String securityCoreAccountSecurity, String securityCoreState, String securityCoreCreateTime) {

		int target = securityCoreDao.update(securityCoreId, securityCoreAccountType, securityCoreAccountId,
				securityCoreAccountSecurity, securityCoreState, securityCoreCreateTime);
		if (target > 0) {
			System.err.println("秘钥id为" + securityCoreId + "的所有秘钥数据更新成功");
			return ResultObject.obj2JsonResult("1", "秘钥id为[" + securityCoreId + "]所有秘钥数据更新成功", "");
		} else {
			System.err.println("秘钥id为" + securityCoreId + "的所有秘钥数据更新失败");
			return ResultObject.obj2JsonResult("0", "秘钥id为[" + securityCoreId + "]所有秘钥数据更新失败", "");
		}
	}

	/* 根据秘钥管理类Id,更新秘钥 */
	@Override
	public String updateSecurity(String securityCoreId, String securityCoreAccountSecurity) {
		int target = securityCoreDao.updateSecurity(securityCoreId, securityCoreAccountSecurity);
		if (target > 0) {
			System.err.println("秘钥id为" + securityCoreId + "的秘钥数据更新成功");
			return ResultObject.obj2JsonResult("1", "秘钥id为[" + securityCoreId + "]更新秘钥成功", "");
		} else {
			System.err.println("秘钥id为" + securityCoreId + "的秘钥数据更新失败");
			return ResultObject.obj2JsonResult("0", "秘钥id为[" + securityCoreId + "]更新秘钥失败", "");
		}
	}

	/* 根据秘钥管理类关联的用户Id,更新秘钥 */
	@Override
	public String updateSecurityBySecurityCoreAccountId(String securityCoreAccountType, String securityCoreAccountId,
			String securityCoreAccountSecurity) {
		int target = securityCoreDao.updateSecurityBySecurityCoreAccountId(securityCoreAccountType,
				securityCoreAccountId, securityCoreAccountSecurity);
		if (target > 0) {
			System.err.println("关联的用户Id为" + securityCoreAccountId + "的秘钥数据更新成功");
			return ResultObject.obj2JsonResult("1", "关联用户id为[" + securityCoreAccountId + "]更新秘钥成功", "");
		} else {
			System.err.println("关联的用户Id为" + securityCoreAccountId + "的秘钥数据更新失败");
			return ResultObject.obj2JsonResult("0", "关联用户id为[" + securityCoreAccountId + "]更新秘钥失败", "");
		}
	}

	/* 根据id更新状态 */
	@Override
	public String updateState(String securityCoreId, String securityCoreState) {
		int target = securityCoreDao.updateState(securityCoreId, securityCoreState);
		if (target > 0) {
			System.err.println("秘钥Id为" + securityCoreId + "的秘钥状态更新成功");
			return ResultObject.obj2JsonResult("1", "秘钥id为[" + securityCoreId + "]更新秘钥状态成功", "");
		} else {
			System.err.println("秘钥Id为" + securityCoreId + "的秘钥状态更新失败");
			return ResultObject.obj2JsonResult("0", "秘钥id为[" + securityCoreId + "]更新秘钥状态失败", "");
		}
	}

	/* 删除 */
	@Override
	public String delete(String securityCoreId) {
		int target = securityCoreDao.delete(securityCoreId);
		if (target > 0) {
			System.err.println("秘钥Id为" + securityCoreId + "的秘钥状删除成功");
			return ResultObject.obj2JsonResult("1", "秘钥id为[" + securityCoreId + "]更新秘钥状态成功", "");
		} else {
			System.err.println("秘钥Id为" + securityCoreId + "的秘钥状删除失败");
			return ResultObject.obj2JsonResult("0", "秘钥id为[" + securityCoreId + "]更新秘钥状态失败", "");
		}
	}

}
