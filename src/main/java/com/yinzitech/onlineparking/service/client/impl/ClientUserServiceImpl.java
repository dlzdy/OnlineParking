/**
 * Project Name:OnlineParking
 * File Name:ClientUserServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.client.impl
 * Date:2015年10月4日上午10:07:30
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */

package com.yinzitech.onlineparking.service.client.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.client.ClientUserDao;
import com.yinzitech.onlineparking.dao.client.QueryClientUserDao;
import com.yinzitech.onlineparking.dao.fundAccountManage.FundAccountManageDao;
import com.yinzitech.onlineparking.dao.securityCore.SecurityCoreDao;
import com.yinzitech.onlineparking.entity.client.user.ClientUser;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.securityCore.SecurityCore;
import com.yinzitech.onlineparking.service.client.ClientUserService;
import com.yinzitech.onlineparking.service.order.ParkingOrderService;
import com.yinzitech.onlineparking.service.securityCore.SecurityCoreService;
import com.yinzitech.onlineparking.service.sys.LoginHisteryService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.PageHelper.Page;
import com.yinzitech.onlineparking.utils.TimeTools;

/**
 * ClassName:ClientUserServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午10:07:30 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ClientUserServiceImpl implements ClientUserService {
	@Autowired
	ClientUserDao clientUserDao;
	@Autowired
	FundAccountManageDao fundAccountManageDao;
	@Autowired
	ParkingOrderService parkingOrderService;
	@Autowired
	SecurityCoreDao sd;
	@Autowired
	SecurityCoreService securityCoreService;
	@Autowired
	LoginHisteryService loginHisteryService;
	@Autowired
	QueryClientUserDao qc;

	/**
	 * 
	 * TODO 创建用户（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.ClientUserService#createtUser(java.lang.String)
	 */
	@Override
	public String createtUser(String clientUserCellphone) {
		String json = "";
		// 生成用户id
		String clientUserId = ToolsIdGenerator.getUUID();
		// 初始化用户昵称
		String clientUserNickName = clientUserCellphone;
		// 注册日期
		String clientUserSignUpTime = TimeTools.getCurrentTime();
		// 资金账户类型
		String fundAccountManageProperty = "1";
		// 创建时间
		String fundAccountManageCreateTime = TimeTools.getCurrentTime();
		// 生成资金账户id
		String fundAccountId = ToolsIdGenerator.getUUID();
		// 资金账户类型
		String subaccountType = "1";
		// 创建新用户
		int i = clientUserDao.insertUser(clientUserId, clientUserCellphone, clientUserNickName, clientUserSignUpTime);
		if (i > 0) {

			String securityCoreId = ToolsIdGenerator.getUUID();
			String securityCoreAccountSecurity = ToolsIdGenerator.getUUID();
			String securityCoreState = "enable";
			String securityCoreCreateTime = TimeTools.getCurrentTime();
			String codeid = securityCoreService.createSecurity(securityCoreId, "001", clientUserId,
					securityCoreAccountSecurity, securityCoreState, securityCoreCreateTime);
			String sec = (String) JSONObject.fromObject(codeid).get("datas");
			String clientUserSecurity = sec;
			// 更新用户令牌
			clientUserDao.upClientUserSecurity(clientUserSecurity, clientUserCellphone);
			ClientUser clientUser = clientUserDao.selectByPhone(clientUserCellphone, clientUserSecurity);
			json = ResultObject.obj2JsonResult("1", "用户帐号：" + clientUserCellphone + "注册成功", clientUser);
			// 创建登录历史
			loginHisteryService.creatHistory(clientUser.getClientUserId(), "1");
			// 创建资金账户
			int f = fundAccountManageDao.insertFundAccountManage(fundAccountId, clientUserId, subaccountType,
					fundAccountManageProperty, fundAccountManageCreateTime);
			if (f > 0) {
				System.out.println("用户资金账户创建成功 :" + fundAccountId + "");
			} else {
				System.out.println("用户资金账户创建失败 ");
			}
		} else {
			json = ResultObject.obj2JsonResult("0", "用户帐号：" + clientUserCellphone + "注册失败", "");
		}
		return json;
	}

	/**
	 * 
	 * TODO 判断用户电话是否存在（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.ClientUserService#hasPhoneNumber(java.lang.String)
	 */
	@Override
	public String hasPhoneNumber(String clientUserCellphone, String clientUserSecurity) {
		String json = "";
		int i = clientUserDao.hasPhoneNumber(clientUserCellphone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("0", "该手机账户已经在系统中存在,请检查手机号或更换手机再次尝试", "");
		} else {
			json = ResultResponse.obj2JsonResult("1", "该手机账户可以注册", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * selectUser:(查询全部用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	@Override
	public String selectUser() {
		String json = "";
		List<ClientUser> list = clientUserDao.selectUser();
		ResultObjectList.obj2JsonResult("1", "查询全部用户成功", list);
		return json;
	}

	/**
	 * 
	 * updateUser:(更新用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserNickName
	 * @param clientUserBirthday
	 * @param clientUserSex
	 * @param clientUserCellphone
	 * @return
	 * @since JDK 1.8u60
	 */
	@Override
	public String updateUser(String clientUserNickName, String clientUserBirthday, String clientUserSex,
			String clientUserCellphone, String clientUserSecurity) {
		String json = "";
		int i = qc.updateUser(clientUserNickName, clientUserBirthday, clientUserSex, clientUserCellphone,
				clientUserSecurity);
		if (i > 0) {
			List<ClientUser> user = qc.getUser("", clientUserCellphone, "", "", "", "", "", "", "", "", "", "");
			json = ResultObject.obj2JsonResult("1", "用户：" + clientUserCellphone + "信息修改成功", user.get(0));
		} else {
			json = ResultResponse.obj2JsonResult("0", "用户：" + clientUserCellphone + "信息修改失败", "");

		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * upUserSecurity:(更新汽车车主用户安全识令牌). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserSecurity
	 * @param clientUserCellphone
	 * @return
	 * @since JDK 1.8u60
	 */
	@Override
	public String upUserSecurity(String clientUserSecurity, String clientUserCellphone) {
		String json = "";
		int i = clientUserDao.upClientUserSecurity(clientUserSecurity, clientUserCellphone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "用户：" + clientUserCellphone + "安全令牌更新成功", clientUserCellphone);
		} else {
			json = ResultResponse.obj2JsonResult("0", "用户：" + clientUserCellphone + "安全令牌更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * upUserActiveMark:(修改用户激活状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 * @param clientUserActiveMark
	 * @return
	 * @since JDK 1.8u60
	 */
	@Override
	public String upUserActiveMark(String clientUserCellphone, String clientUserActiveMark) {
		String json = "";
		int i = clientUserDao.upClientUserActiveMark(clientUserActiveMark, clientUserCellphone);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "用户：" + clientUserCellphone + "状态更新成功", clientUserCellphone);
		} else {
			json = ResultResponse.obj2JsonResult("0", "用户：" + clientUserCellphone + "状态更新失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * deleteUserById:(通过clientUserId删除用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Override
	public String deleteUserById(String clientUserId) {
		String json = "";
		int i = clientUserDao.deleteUser(clientUserId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "用户：" + clientUserId + "删除成功", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "用户：" + clientUserId + "删除失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * userLogin:(用户登录). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 * @param clientUserSecurity
	 * @return
	 * @since JDK 1.8u60
	 */
	@Override
	public String userLogin(String clientUserCellphone, String clientUserSecurity) {
		ClientUser clientUser;
		String json = "";
		// 判断用户是否存在
		int i = clientUserDao.hasPhoneNumber(clientUserCellphone);
		if (i > 0) {
			// 退出用户登录判断令牌是否为空
			if (clientUserSecurity.equals("") & clientUserSecurity == null) {
				// 获取用户信息
				clientUser = clientUserDao.userLogin(clientUserCellphone, clientUserSecurity);
				// 判断用户令牌是否一致
				if (clientUser.getClientUserSecurity().equals("")
						& clientUser.getClientUserSecurity().equals(clientUserSecurity)) {
					// 判断用户状态是否可用
					if (clientUser.getClientUserActiveMark().equals("enable")) {
						json = ResultObject.obj2JsonResult("1", "用户状态可用", clientUser);
						// 创建用户登录历史
						loginHisteryService.creatHistory(clientUser.getClientUserId(), "1");
					} else {
						json = ResultObject.obj2JsonResult("0", "账户已被冻结请联系客服", "");
					}
				} else {
					json = ResultResponse.obj2JsonResult("0", "安全令牌不匹配", "");
					String securityCoreAccountSecurity = ToolsIdGenerator.getUUID();
					System.out.println(clientUser.getClientUserId());
					String secCore = securityCoreService.updateSecurityBySecurityCoreAccountId("001",
							clientUser.getClientUserId(), securityCoreAccountSecurity);
					System.out.println(secCore);
					SecurityCore securityCore = sd.retrieveById("001", clientUser.getClientUserId());
					int a = clientUserDao.upClientUserSecurity(securityCore.getSecurityCoreAccountSecurity(),
							clientUserCellphone);
					if (a > 0) {
						json = ResultResponse.obj2JsonResult("1", "更新用户安全令牌成功", "");
						loginHisteryService.creatHistory(clientUser.getClientUserId(), "1");
					} else {
						json = ResultResponse.obj2JsonResult("0", "更新用户安全令牌失败", "");
					}

				}

			} else {
				// 判断用户状态是否可用
				ClientUser c = clientUserDao.selectByPhones(clientUserCellphone);
				if (c.getClientUserActiveMark().equals("enable")) {
					String securityCoreAccountSecurity = ToolsIdGenerator.getUUID();
					System.out.println(c.getClientUserId());
					String secCore = securityCoreService.updateSecurityBySecurityCoreAccountId("001",
							c.getClientUserId(), securityCoreAccountSecurity);
					System.out.println(secCore);
					SecurityCore securityCore = sd.retrieveById("001", c.getClientUserId());
					int a = clientUserDao.upClientUserSecurity(securityCore.getSecurityCoreAccountSecurity(),
							clientUserCellphone);
					if (a > 0) {
						ClientUser cu = clientUserDao.selectByPhones(clientUserCellphone);
						json = ResultObject.obj2JsonResult("1", "更新用户安全令牌成功", cu);
						loginHisteryService.creatHistory(cu.getClientUserId(), "1");
					} else {
						json = ResultResponse.obj2JsonResult("0", "更新用户安全令牌失败", "");
					}
				}
			}
		} else {
			json = createtUser(clientUserCellphone);
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * upUserPhone:(修改用户电话号码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Override
	public String upUserPhone(String clientUserSecurity, String clientUserCellphone, String clientUserId) {

		String json = "";
		int i = clientUserDao.upUserPhone(clientUserSecurity, clientUserCellphone, clientUserId);
		if (i > 0) {
			String securityCoreAccountSecurity = ToolsIdGenerator.getUUID();
			securityCoreService.updateSecurityBySecurityCoreAccountId("001", clientUserId, securityCoreAccountSecurity);
			clientUserDao.upClientUserSecurity(securityCoreAccountSecurity, clientUserCellphone);
			json = ResultResponse.obj2JsonResult("1", "用户：" + clientUserCellphone + "更新电话号码成功", clientUserCellphone);
		} else {
			json = ResultResponse.obj2JsonResult("0", "用户：" + clientUserCellphone + "更新电话号码失败", "");
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO * upUserAutoPay:(是否自动支付 0为不自动支付 1为自动支付). <br/>
	 * 
	 * @see com.yinzitech.onlineparking.service.client.ClientUserService#upUserAutoPay(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public String upUserAutoPay(String clientUserAutoPay, String clientUserSecurity, String clientUserId) {
		String json = "";
		String AutoPay = "";
		if (clientUserAutoPay.equals("1")) {
			AutoPay = "自动支付";
		} else {
			AutoPay = "手动支付";
		}
		int i = clientUserDao.upUserAutoPay(clientUserAutoPay, clientUserSecurity, clientUserId);
		if (i > 0) {
			json = ResultResponse.obj2JsonResult("1", "更新成功状态为：" + AutoPay + "", "");
		} else {
			json = ResultResponse.obj2JsonResult("0", "状态改变失败", "");
		}
		System.out.println(json);
		return json;
	}

	@Override
	public String userPayOk(String clientUserSecurity, String clientUserId, String parkingOrderId) {
		String json = "";
		int i = clientUserDao.hasUserSecurity(clientUserId, clientUserSecurity);
		if (i > 0) {
			String parkingOrderPayState = "Paid";
			parkingOrderService.updateparkingOrderPayState(parkingOrderPayState, parkingOrderId);
			json = "确认支付";
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 
	 * TODO 增加推送账户（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.ClientUserService#addRegistrAtionId(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public String addRegistrAtionId(String registrAtionId, String clientUserSecurity, String clientUserId,
			String clientUserType) {
		String json = "";
		List<ClientUser> list = qc.getUser("", "", "", "", "", "", "", "", "", registrAtionId, "", "");
		if (list.size() > 0) {
			for (ClientUser clientUser : list) {
				clientUserDao.addRegistrAtionId("", clientUser.clientUserId, clientUserType);
			}

		}
		int rai = clientUserDao.addRegistrAtionId(registrAtionId, clientUserId, clientUserType);
		if (rai > 0) {
			json = ResultObject.obj2JsonResult("1", "推送id增加成功：" + registrAtionId + "", registrAtionId);
			loginHisteryService.creatHistory(clientUserId, "1");
		} else {
			json = ResultObject.obj2JsonResult("0", "推送id增加失败：" + registrAtionId + "", "");
		}

		System.out.println(json);
		return json;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.ClientUserService#getUser()
	 */
	@Override
	public String getUser(String clientUserId, String clientUserCellphone, String clientUserSex, String startBirthday,
			String endBirthday, String startUpTime, String endUpTime, String clientUserActiveMark,
			String clientUserAutoPay) {
		String json = "";
		String phone = "";
		if (clientUserCellphone != null & clientUserCellphone != "") {
			phone = "%" + clientUserCellphone + "%";
		}
		List<ClientUser> list = qc.getUser(clientUserId, phone, clientUserSex, startBirthday, endBirthday, startUpTime,
				endUpTime, clientUserActiveMark, clientUserAutoPay, "", "", "");
		if (list.size() > 0) {
			json = ResultObjectList.obj2JsonResult("1", "查询成功", list);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询失败", "");
		}

		System.out.println(json);
		return json;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.yinzitech.onlineparking.service.client.ClientUserService#getUser()
	 */
	@Override
	public String getUserLimit(String clientUserId, String clientUserCellphone, String clientUserSex,
			String startBirthday, String endBirthday, String startUpTime, String endUpTime, String clientUserActiveMark,
			String clientUserAutoPay, int pageNumber, int pageSize) {
		String json = "";
		String phone = "";
		PageHelper.startPage(pageNumber, pageSize);
		if (clientUserCellphone != null & clientUserCellphone != "") {
			phone = "%" + clientUserCellphone + "%";
		}
		List<ClientUser> list = qc.getUser(clientUserId, phone, clientUserSex, startBirthday, endBirthday, startUpTime,
				endUpTime, clientUserActiveMark, clientUserAutoPay, "", "", "");
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultObject.obj2JsonResult("0", "查询失败", "");
		}

		System.out.println(json);
		return json;
	}

	@Override
	public String getUserSecurity(String clientUserId, String clientUserSecurity) {
		String json = "";
		ClientUser cu = clientUserDao.selectById(clientUserId, clientUserSecurity);
		if (cu != null) {
			json = ResultObject.obj2JsonResult("1", "验证成功", cu);
		} else {
			json = ResultResponse.obj2JsonResult("0", "令牌不一致", "");
		}
		return json;
	}

}
