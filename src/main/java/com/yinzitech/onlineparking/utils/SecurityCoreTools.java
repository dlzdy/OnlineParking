/**
 * Project Name:OnlineParking
 * File Name:SecurityCoreTools.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月13日下午4:22:44
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.securityCore.SecurityCore;
import com.yinzitech.onlineparking.service.securityCore.SecurityCoreService;

/**
 * ClassName:SecurityCoreTools <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午4:22:44 <br/>
 * 
 * @author Kevin
 * @version
 * @since JDK 1.8
 * @see
 */
public class SecurityCoreTools {
	@Autowired
	SecurityCoreService securityCoreService;

	/* 新增 */
	public String createSecurity(String securityCoreAccountType, String securityCoreAccountId) {
		String securityCoreId = ToolsIdGenerator.getUUID();
		String securityCoreAccountSecurity = ToolsIdGenerator.getUUID();
		String securityCoreState = "enable";
		String securityCoreCreateTime = TimeTools.getCurrentTime(); 
		return securityCoreService.createSecurity(securityCoreId, securityCoreAccountType, securityCoreAccountId,
				securityCoreAccountSecurity, securityCoreState, securityCoreCreateTime);
	}

	/* 验证 */
	public String verifiSecurity(String securityCoreAccountType, String securityCoreAccountId,
			String securityCoreAccountSecurity) {
		String targetSecurityCore = securityCoreService.retrieveById(securityCoreAccountType, securityCoreAccountId);
		if (!(targetSecurityCore.equals(null)) & !("".equals(targetSecurityCore))) {
			ObjectMapper om = new ObjectMapper();
			try {
				ResultObject ro = om.readValue(targetSecurityCore, ResultObject.class);
				SecurityCore sr = (SecurityCore) ro.getDatas();
				if (sr.getSecurityCoreAccountSecurity().equals(securityCoreAccountSecurity)) {
					return ResultResponse.obj2JsonResult("1", "认证成功", "");
				} else {
					return ResultResponse.obj2JsonResult("0", "认证失败,出现异常", "");
				}
			} catch (JsonParseException e) {
				e.printStackTrace();
				return ResultResponse.obj2JsonResult("0", "认证失败,出现异常", "");
			} catch (JsonMappingException e) {
				e.printStackTrace();
				return ResultResponse.obj2JsonResult("0", "认证失败,出现异常", "");
			} catch (IOException e) {
				e.printStackTrace();
				return ResultResponse.obj2JsonResult("0", "认证失败,出现异常", "");
			}
		} else {
			return ResultResponse.obj2JsonResult("0", "认证失败,出现异常", "");

		}

	}

	/* 更换 */
	public String updateSecurityBySecurityCoreAccountId(String securityCoreAccountType, String securityCoreAccountId) {
		String securityCoreAccountSecurity = ToolsIdGenerator.getUUID();
		return securityCoreService.updateSecurityBySecurityCoreAccountId(securityCoreAccountType, securityCoreAccountId,
				securityCoreAccountSecurity);

	}

}
