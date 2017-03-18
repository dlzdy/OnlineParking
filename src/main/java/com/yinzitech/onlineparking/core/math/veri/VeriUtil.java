/**
 * Project Name:OnlineParking
 * File Name:VeriUtil.java
 * Package Name:com.yinzitech.onlineparking.core.math.veri
 * Date:2015年10月13日下午9:32:36
 * Copyright (c) 2015, ziheng All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.core.math.veri;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.core.math.MathMethod;
import com.yinzitech.onlineparking.core.sms.SMSTools;
import com.yinzitech.onlineparking.dao.Veri4CodeDao;
import com.yinzitech.onlineparking.entity.Veri4Code;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.utils.TimeTools;

/**
 * ClassName:VeriUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午9:32:36 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class VeriUtil {
	@Autowired
	Veri4CodeDao veri4CodeDao;

	public String getVeriCode(String phoneNu) {
		String codeId = ToolsIdGenerator.getOrderId();
		String codeNu = MathMethod.radomVeriNu();
		String codeTime = TimeTools.getCurrentTime();
		/* 入库 */
		int target = veri4CodeDao.insert(codeId, codeNu, codeTime);
		if (target == 1) {
			/* TODO 调用短信发送 */
			if (SMSTools.sendMSM(phoneNu, codeNu) == 1) {
				return ResultResponse.obj2JsonResult("1", "用户发起对手机号为" + phoneNu + "的手机发起短信验证,成功", codeId);

			} else {
				return ResultResponse.obj2JsonResult("0", "用户发起对手机号为" + phoneNu + "的手机发起短信验证码,失败,请重新申请", "");

			}
		} else {
			System.err.println("用户发起对手机号为" + phoneNu + "的手机发起短信验证,失败,请重新申请");
			return ResultResponse.obj2JsonResult("0", "用户发起对手机号为" + phoneNu + "的手机发起短信验证,失败,请重新申请", "");
		}
	} 

	/**
	 * 
	 * deleteCode:(删除当天23.59.59 以前所有验证码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String deleteCode() {
		String json = "";
		String codeTime = TimeTools.getTimeslast();
		int i = veri4CodeDao.delete(codeTime);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "清空验证码成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "清空验证码失败", "");
		}

		return json;
	}

	/**
	 * 
	 * veriCode:(验证码验证). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param phoneNu
	 *            手机号
	 * @param codeId
	 *            验证id
	 * @param codeNu
	 *            验证码
	 * @return
	 * @since JDK 1.8u60
	 */
	public String veriCode(String phoneNu, String codeId, String codeNu) {
		/**
		 * 测试
		 * 
		 * 手机号 XXXXXXXXXXX 测试码 XXXX 直接通过验证
		 */
		if (phoneNu.equals("15555555555") && codeNu.equals("0000")) {
			return ResultResponse.obj2JsonResult("1", "用户手机号为" + phoneNu + "的手机短信验证成功", codeId);
		}

		/**
		 * *****************************************************测试 end
		 */

		// 通过验证id 获取验证信息
		Veri4Code v4c = veri4CodeDao.query(codeId);
		if (!(null == v4c)) {
			// 计算时间
			long m = TimeTools.mathTime(TimeTools.getCurrentTime(), v4c.getCodeTime());
			// 超时设置 单位 ：秒
			if (m <= 120) {
				if (v4c.getCodeNu().equals(codeNu)) {
					return ResultResponse.obj2JsonResult("1", "用户手机号为" + phoneNu + "的手机短信验证成功", codeId);
				} else {
					return ResultResponse.obj2JsonResult("0", "验证码错误，请重新输入。", codeId);
				}
			} else {
				return ResultResponse.obj2JsonResult("0", "短信验证超时，请重新获取。", codeId);
			}

		} else {
			return ResultResponse.obj2JsonResult("0", "验证码错误，请重新输入。", codeId);
		}
	}
}
