/**
 * Project Name:onlineParking
 * File Name:RestPark.java
 * Package Name:com.yz.ParkDemo.Rest
 * Date:2015年9月8日下午1:49:56
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
 */ 

package com.yinzitech.onlineparking.rest.clientuser;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.yinzitech.onlineparking.core.context.springCore.SpringApplicationContext;
import com.yinzitech.onlineparking.core.math.veri.VeriUtil;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.parkingInfo.ParkPoint;
import com.yinzitech.onlineparking.service.appVersion.AppVersionService;
import com.yinzitech.onlineparking.service.client.ClientUserService;
import com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService;
import com.yinzitech.onlineparking.service.fundAccountManage.FundAccountManageService;
import com.yinzitech.onlineparking.service.handsetSys.HandsetSysService;
import com.yinzitech.onlineparking.service.massage.MessageService;
import com.yinzitech.onlineparking.service.order.ChargingOrderService;
import com.yinzitech.onlineparking.service.order.ParkingOrderService;
import com.yinzitech.onlineparking.service.order.TradingOrdersService;
import com.yinzitech.onlineparking.service.parkingInfo.ChargingStandardsService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkPointService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.securityCore.SecurityCoreService;
import com.yinzitech.onlineparking.service.sys.LoginHisteryService;
import com.yinzitech.onlineparking.service.sys.OpinionService;
import com.yinzitech.onlineparking.utils.CheckUtils;
import com.yinzitech.onlineparking.utils.NumberCountPoJo;

import net.sf.json.JSONObject;

/**
 * ClassName:RestClientUser <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年9月8日 下午1:49:56 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
@Path("/rest")
public class RestClientUser {
	ClientUserService clientUserService;
	ClinetUserCarManageService clinetUserCarManageService;
	FundAccountManageService fundAccountManageService;
	HandsetSysService handsetSysService;
	ParkingOrderService parkingOrderService;
	TradingOrdersService tradingOrdersService;
	ChargingStandardsService chargingStandardsService;
	ChargingOrderService chargingOrderService;
	ParkingInfoService parkingInfoService;
	VeriUtil veriUtil;
	MessageService messageService;
	LoginHisteryService loginHisteryService;
	OpinionService opinionService;
	SecurityCoreService securityCoreService;
	AppVersionService appVersionService;
	ParkPointService parkPointService;

	/**
	 * 获取停车场坐标列表
	 * 
	 * @return
	 */
	@GET
	@Path("/getParkPointAll")
	@Produces("application/json")
	public Response getParkPointAll() {
		parkPointService = (ParkPointService) SpringApplicationContext.getBean("parkPointService");
		String result = parkPointService.getParkAll();
		return Response.status(200).entity(result).build();
	}

	/**
	 * 新增停车场座标
	 * 
	 * @return
	 */
	@GET
	@Path("/addParkPoint")
	@Produces("application/json")
	public Response addParkPoint(@QueryParam("parkId") String parkId, @QueryParam("parkName") String parkName,
			@QueryParam("lat") String lat, @QueryParam("lng") String lng, @QueryParam("lat1") String lat1,
			@QueryParam("lng1") String lng1, @QueryParam("lat2") String lat2, @QueryParam("lng2") String lng2,
			@QueryParam("lat3") String lat3, @QueryParam("lng3") String lng3) {
		parkPointService = (ParkPointService) SpringApplicationContext.getBean("parkPointService");
		ParkPoint park = new ParkPoint(parkId, parkName, lat, lng, lat1, lng1, lat2, lng2, lat3, lng3);
		String result = parkPointService.addPark(park);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * hasPhoneNumber:(判断电话号码是否已存在). <br/>
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
	@GET
	@Path("/hasPhoneNumber")
	@Produces("application/json")
	public Response hasPhoneNumber(@QueryParam("clientUserCellphone") String clientUserCellphone,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
		String result = clientUserService.hasPhoneNumber(clientUserCellphone, clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * getUserSecurity:(手机用户验证). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @param clientUserSecurity
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/getUserSecurity")
	@Produces("application/json")
	public Response getUserSecurity(@QueryParam("clientUserId") String clientUserId,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
		String result = clientUserService.getUserSecurity(clientUserId, clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * userLogin:(验证用户登录). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 *            汽车车主用户手机号
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/userLogin")
	@Produces("application/json")
	public Response userLogin(@QueryParam("clientUserCellphone") String clientUserCellphone,
			@QueryParam("clientUserSecurity") String clientUserSecurity, @QueryParam("codeId") String codeId,
			@QueryParam("codeNu") String codeNu) {
		String result = "";
		veriUtil = (VeriUtil) SpringApplicationContext.getBean("veriUtil");
		String i = veriUtil.veriCode(clientUserCellphone, codeId, codeNu);
		String yz = (String) JSONObject.fromObject(i).get("result");
		if (yz.equals("1")) {
			clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
			result = clientUserService.userLogin(clientUserCellphone, clientUserSecurity);
		} else {
			result = i;
		}
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * getVeriCode:(获取验证码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCellphone
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/getVeriCode")
	@Produces("application/json")
	public Response getVeriCode(@QueryParam("clientUserCellphone") String clientUserCellphone) {
		System.out.println(clientUserCellphone);
		veriUtil = (VeriUtil) SpringApplicationContext.getBean("veriUtil");
		String result = veriUtil.getVeriCode(clientUserCellphone);
		return Response.status(200).entity(result).build();
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
	 * 
	 * @param clientUserNickName
	 *            汽车车主昵称
	 * @param clientUserBirthday
	 *            汽车车主生日
	 * @param clientUserSex
	 *            汽车车主性别
	 * @param clientUserCellphone
	 *            汽车车主电话
	 * @param clientUserSecurity
	 *            汽车车主用户安全识令牌
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/updateUser")
	@Produces("application/json")
	public Response updateUser(@QueryParam("clientUserNickName") String clientUserNickName,
			@QueryParam("clientUserBirthday") String clientUserBirthday,
			@QueryParam("clientUserSex") String clientUserSex,
			@QueryParam("clientUserCellphone") String clientUserCellphone,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {

		clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
		String result = clientUserService.updateUser(clientUserNickName, clientUserBirthday, clientUserSex,
				clientUserCellphone, clientUserSecurity);

		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * userPayOk:(确认支付). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserSecurity
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/userPayOk")
	@Produces("application/json")
	public Response userPayOk(@QueryParam("clientUserSecurity") String clientUserSecurity,
			@QueryParam("clientUserId") String clientUserId, @QueryParam("parkingOrderId") String parkingOrderId) {
		clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
		String result = clientUserService.userPayOk(clientUserSecurity, clientUserId, parkingOrderId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * upUserPhone:(更改用户手机号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserSecurity
	 * @param clientUserCellphone
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/upUserPhone")
	@Produces("application/json")
	public Response upUserPhone(@QueryParam("clientUserSecurity") String clientUserSecurity,
			@QueryParam("clientUserCellphone") String clientUserCellphone,
			@QueryParam("clientUserId") String clientUserId, @QueryParam("codeId") String codeId,
			@QueryParam("codeNu") String codeNu) {

		String result = "";
		veriUtil = (VeriUtil) SpringApplicationContext.getBean("veriUtil");
		String i = veriUtil.veriCode(clientUserCellphone, codeId, codeNu);
		String yz = (String) JSONObject.fromObject(i).get("result");
		if (yz.equals("1")) {
			clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
			result = clientUserService.upUserPhone(clientUserSecurity, clientUserCellphone, clientUserId);
		} else {
			result = i;
		}

		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * insertUserCar:(新增用户车牌号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @param clientUserCarNo
	 * @param clientUserCarPosition
	 * @param clientUserSecurity
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/insertUserCar")
	@Produces("application/json")
	public Response insertUserCar(@QueryParam("clientUserId") String clientUserId,
			@QueryParam("clientUserCarNo") String clientUserCarNo,
			@QueryParam("clientUserCarPosition") String clientUserCarPosition,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		clinetUserCarManageService = (ClinetUserCarManageService) SpringApplicationContext
				.getBean("clinetUserCarManageService");
		String result = clinetUserCarManageService.insertUserCar(clientUserId, clientUserCarNo, clientUserCarPosition,
				clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectUserCar:(通过用户信息查询用户车辆). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserId
	 * @param clientUserSecurity
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectUserCar")
	@Produces("application/json")
	public Response selectUserCar(@QueryParam("clientUserId") String clientUserId,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		clinetUserCarManageService = (ClinetUserCarManageService) SpringApplicationContext
				.getBean("clinetUserCarManageService");
		String result = clinetUserCarManageService.selectUserCar(clientUserId, clientUserSecurity);

		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * hasUserCarNo:(判断车牌号是否存在). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarNo
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/hasUserCarNo")
	@Produces("application/json")
	public Response hasUserCarNo(@QueryParam("clientUserCarNo") String clientUserCarNo) {
		clinetUserCarManageService = (ClinetUserCarManageService) SpringApplicationContext
				.getBean("clinetUserCarManageService");
		String result = clinetUserCarManageService.hasUserCarNo(clientUserCarNo);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 获取车辆信息
	 * 
	 * @param clientUserCarNo
	 * @return
	 */
	@GET
	@Path("/getUserCar")
	@Produces("application/json")
	public Response getUserCar(@QueryParam("clientUserCarNo") String clientUserCarNo) {
		clinetUserCarManageService = (ClinetUserCarManageService) SpringApplicationContext
				.getBean("clinetUserCarManageService");
		String result = clinetUserCarManageService.getUserCar("", "", clientUserCarNo, "", "", "");
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * upUserCarActiveMark:(更改车辆状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarActiveMark
	 * @param carManageId
	 * @param clientUserSecurity
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/upUserCarActiveMark")
	@Produces("application/json")
	public Response upUserCarActiveMark(@QueryParam("clientUserCarActiveMark") String clientUserCarActiveMark,
			@QueryParam("carManageId") String carManageId, @QueryParam("clientUserSecurity") String clientUserSecurity,
			@QueryParam("clientUserId") String clientUserId) {
		clinetUserCarManageService = (ClinetUserCarManageService) SpringApplicationContext
				.getBean("clinetUserCarManageService");
		String result = clinetUserCarManageService.upUserCarActiveMark(clientUserCarActiveMark, carManageId,
				clientUserSecurity, clientUserId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * upUserCarPosition:(修改车牌号显示顺序). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param clientUserCarPosition
	 * @param carManageId
	 * @param clientUserSecurity
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/upUserCarPosition")
	@Produces("application/json")
	public Response upUserCarPosition(@QueryParam("clientUserCarPosition") String clientUserCarPosition,
			@QueryParam("carManageId") String carManageId, @QueryParam("clientUserSecurity") String clientUserSecurity,
			@QueryParam("clientUserId") String clientUserId) {
		clinetUserCarManageService = (ClinetUserCarManageService) SpringApplicationContext
				.getBean("clinetUserCarManageService");
		String result = clinetUserCarManageService.upUserCarPosition(clientUserCarPosition, carManageId, clientUserId,
				clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * deleteUserCarByCarManageId:(通过carManageId删除车辆信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param carManageId
	 * @param clientUserSecurity
	 * @param clientUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/deleteUserCarByCarManageId")
	@Produces("application/json")
	public Response deleteUserCarByCarManageId(@QueryParam("carManageId") String carManageId,
			@QueryParam("clientUserSecurity") String clientUserSecurity,
			@QueryParam("clientUserId") String clientUserId) {
		clinetUserCarManageService = (ClinetUserCarManageService) SpringApplicationContext
				.getBean("clinetUserCarManageService");
		String result = clinetUserCarManageService.deleteUserCarByCarManageId(carManageId, clientUserId,
				clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

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
	 * @param clientUserSecurity
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectByCustId")
	@Produces("application/json")
	public Response selectByCustId(@QueryParam("custId") String custId,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		fundAccountManageService = (FundAccountManageService) SpringApplicationContext
				.getBean("fundAccountManageService");
		String result = fundAccountManageService.selectByCustId(custId, clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * hasActiveMark:(判断账号状态是否可用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/hasActiveMark")
	@Produces("application/json")
	public Response hasActiveMark(@QueryParam("handsetManagerPhone") String handsetManagerPhone) {
		handsetSysService = (HandsetSysService) SpringApplicationContext.getBean("handsetSysService");
		String result = handsetSysService.hasActiveMark(handsetManagerPhone);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * LoginHandsetManager:(手持机登录). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetManagerSecurity
	 *            停车场手持机管理员用户安全识令牌
	 * @param handsetManagerPhone
	 *            停车场手持机收费员用户手机号
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/LoginHandsetManager")
	@Produces("application/json")
	public Response LoginHandsetManager(@QueryParam("handsetManagerSecurity") String handsetManagerSecurity,
			@QueryParam("handsetManagerPhone") String handsetManagerPhone, @QueryParam("handsetId") String handsetId,
			@QueryParam("codeId") String codeId, @QueryParam("codeNu") String codeNu) {

		String result = "";
		veriUtil = (VeriUtil) SpringApplicationContext.getBean("veriUtil");
		String i = veriUtil.veriCode(handsetManagerPhone, codeId, codeNu);
		String yz = (String) JSONObject.fromObject(i).get("result");
		if (yz.equals("1")) {

			handsetSysService = (HandsetSysService) SpringApplicationContext.getBean("handsetSysService");
			result = handsetSysService.LoginHandsetManager(handsetManagerSecurity, handsetManagerPhone, handsetId);
		} else {
			result = i;
		}

		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectParkingOrderById:(通过订单ID查询订单内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderId
	 *            订单ID
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectParkingOrderById")
	@Produces("application/json")
	public Response selectParkingOrderById(@QueryParam("parkingOrderId") String parkingOrderId) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result = parkingOrderService.selectParkingOrderById(parkingOrderId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * parkingOrderParkingState:(查询停车长停车数量). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderParkingInfoId
	 *            停车场ID
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/parkingOrderParkingState")
	@Produces("application/json")
	public Response parkingOrderParkingState(
			@QueryParam("parkingOrderParkingInfoId") String parkingOrderParkingInfoId) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result = parkingOrderService.parkingOrderParkingState(parkingOrderParkingInfoId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectParkingOrderByUserId:(查询用户全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderClientUserId
	 *            用户ID
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectParkingOrderByUserId")
	@Produces("application/json")
	public Response selectParkingOrderByUserId(@QueryParam("parkingOrderClientUserId") String parkingOrderClientUserId,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");

		String startTime = "";
		String endTime = "";
		String parkingOrderPayState = "";
		// int pageSize = 10;3
		// String result =
		// parkingOrderService.selectParkingOrderByUserId(parkingOrderClientUserId,
		// parkingOrderPayState,
		// startTime, endTime, clientUserSecurity, Integer.valueOf(pageNumber),
		// pageSize);
		String result = parkingOrderService.selectParkingOrderByUserId(parkingOrderClientUserId, parkingOrderPayState,
				startTime, endTime, clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * queryParkOrderLimit:(分页查询用户账单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderClientUserId
	 * @param clientUserSecurity
	 * @param payState
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */

	@GET
	@Path("/queryParkOrderLimit")
	@Produces("application/json")
	public Response queryParkOrderLimit(@QueryParam("parkingOrderClientUserId") String parkingOrderClientUserId,
			@QueryParam("clientUserSecurity") String clientUserSecurity, @QueryParam("payState") String payState,
			@QueryParam("pageNumber") String pageNumber, @QueryParam("pageSize") String pageSize) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
		String result = "";
		String userIsTrue = clientUserService.getUserSecurity(parkingOrderClientUserId, clientUserSecurity);
		JSONObject jsonObj = JSONObject.fromObject(userIsTrue);
		String res = jsonObj.getString("result").toString();
		if (res.equals("1")) {
			result = parkingOrderService.queryParkOrderLimit("", "", "", parkingOrderClientUserId, "", payState, "", "",
					"", "", "", "", "", "", Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
		} else {
			result = userIsTrue;
		}
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectParkingOrderByHandManagerId:(查询手持端全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderHandsetManagerId
	 * @param pageNumber
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectParkingOrderByHandManagerId")
	@Produces("application/json")
	public Response selectParkingOrderByHandManagerId(
			@QueryParam("parkingOrderHandsetManagerId") String parkingOrderHandsetManagerId) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String startTime = "";
		String endTime = "";
		String parkingOrderPayState = "";
		String result = parkingOrderService.parkingOrderHandsetManagerId(parkingOrderHandsetManagerId,
				parkingOrderPayState, startTime, endTime);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectParkingOrderByHandManagerIdLimit:(查询手持机账单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderHandsetManagerId
	 * @param payState
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectParkingOrderByHandManagerIdLimit")
	@Produces("application/json")
	public Response selectParkingOrderByHandManagerIdLimit(
			@QueryParam("parkingOrderHandsetManagerId") String parkingOrderHandsetManagerId,
			@QueryParam("payState") String payState, @QueryParam("pageSize") String pageSize,
			@QueryParam("pageNumber") String pageNumber) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String startTime = "";
		String endTime = "";
		String result = parkingOrderService.queryParkOrderLimit("", "", "", "", "", payState, "",
				parkingOrderHandsetManagerId, "", "", startTime, endTime, "", "", Integer.valueOf(pageNumber),
				Integer.valueOf(pageSize));
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * updateParkingOrder:(停车场车辆出库信息修改). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderPayState
	 *            支付状态
	 * @param parkingOrderId
	 *            停车场订单Id
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/updateParkingOrder")
	@Produces("application/json")
	public Response updateParkingOrder(@QueryParam("parkingOrderPayState") String parkingOrderPayState,
			@QueryParam("parkingOrderId") String parkingOrderId) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result = parkingOrderService.updateParkingOrder(parkingOrderPayState, parkingOrderId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * creatParkingOrder:(创建订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderCarNo
	 *            用户车牌号
	 * @param parkingOrderHandSetId
	 *            手持端设备ID
	 * @param parkingInfoId
	 *            停车场ID
	 * @param handsetManagerId
	 *            使用手持设备人ID
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/creatParkingOrder")
	@Produces("application/json")
	public Response creatParkingOrder(@QueryParam("parkingOrderCarNo") String parkingOrderCarNo,
			@QueryParam("parkingOrderHandSetId") String parkingOrderHandSetId,
			@QueryParam("parkingInfoId") String parkingInfoId,
			@QueryParam("handsetManagerId") String handsetManagerId) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result = parkingOrderService.creatParkingOrder(parkingOrderCarNo, parkingOrderHandSetId, parkingInfoId,
				handsetManagerId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * insertTradingOrder:(创建交易订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * 
	 * @param tradingOrderParkingOrderId
	 *            资金账户交易对应订单号
	 * @param tradingOrderState
	 *            支付交易订单交易订单交易状态
	 * @param tradingOrderpayState
	 *            支付交易订单交易支付状态(支付)
	 * @param tradingOrderBalanceState
	 *            支付交易订单付款方,与收款方资金账户变动状态
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/insertTradingOrder")
	@Produces("application/json")
	public Response insertTradingOrder(@QueryParam("tradingOrderParkingOrderId") String tradingOrderParkingOrderId,
			@QueryParam("tradingOrderState") String tradingOrderState,
			@QueryParam("tradingOrderpayState") String tradingOrderpayState,
			@QueryParam("tradingOrderBalanceState") String tradingOrderBalanceState) {
		tradingOrdersService = (TradingOrdersService) SpringApplicationContext.getBean("tradingOrdersService");
		String result = tradingOrdersService.insertTradingOrder(tradingOrderParkingOrderId, tradingOrderState,
				tradingOrderpayState, tradingOrderBalanceState);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectTradingOrderBySrcCustId:(查询付款方全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderSrcCustId
	 *            'trading_order_src_cust_id 资金账户交易付款方客户编号 唯一键标识 对应数据库
	 *            trading_order 对应实体类 TradingOrder 对应属性 tradingOrderSrcCustId
	 *            数据库字段类型 varchar 实体类字段类型 String 长度50 不可为空 为 client_user_id 字段'
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectTradingOrderBySrcCustId")
	@Produces("application/json")
	public Response selectTradingOrderBySrcCustId(@QueryParam("tradingOrderSrcCustId") String tradingOrderSrcCustId) {
		tradingOrdersService = (TradingOrdersService) SpringApplicationContext.getBean("tradingOrdersService");
		String endTime = "";
		String startTime = "";
		String tradingOrderBalanceState = "";
		String tradingOrderParkingOrderId = "";
		String tradingOrderPayeeCustId = "";
		String tradingOrderpayState = "";
		String tradingOrderState = "";
		String result = tradingOrdersService.queryTradingOrders(tradingOrderSrcCustId, tradingOrderParkingOrderId,
				tradingOrderPayeeCustId, tradingOrderState, tradingOrderpayState, tradingOrderBalanceState, startTime,
				endTime);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectTradingOrderByPayeeCustId:(查询收款方全部订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderPayeeCustId
	 *            'trading_order_payee_cust_id 资金账户交易收款方客户编号 唯一键标识 对应数据库
	 *            trading_order 对应实体类 TradingOrder 对应属性 tradingOrderPayeeCustId
	 *            数据库字段类型 varchar 实体类字段类型 String 长度50 不可为空 为 parking_info_id字段',
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectTradingOrderByPayeeCustId")
	@Produces("application/json")
	public Response selectTradingOrderByPayeeCustId(
			@QueryParam("tradingOrderPayeeCustId") String tradingOrderPayeeCustId) {
		tradingOrdersService = (TradingOrdersService) SpringApplicationContext.getBean("tradingOrdersService");
		String endTime = "";
		String startTime = "";
		String tradingOrderBalanceState = "";
		String tradingOrderParkingOrderId = "";
		String tradingOrderpayState = "";
		String tradingOrderState = "";
		String tradingOrderSrcCustId = "";
		String result = tradingOrdersService.queryTradingOrders(tradingOrderSrcCustId, tradingOrderParkingOrderId,
				tradingOrderPayeeCustId, tradingOrderState, tradingOrderpayState, tradingOrderBalanceState, startTime,
				endTime);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectTradingOrderByOrderId:(查询资金账户交易对应订单号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param tradingOrderParkingOrderId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectTradingOrderByPayeeCustId")
	@Produces("application/json")
	public Response selectTradingOrderByOrderId(
			@QueryParam("tradingOrderParkingOrderId") String tradingOrderParkingOrderId) {
		tradingOrdersService = (TradingOrdersService) SpringApplicationContext.getBean("tradingOrdersService");
		String endTime = "";
		String startTime = "";
		String tradingOrderBalanceState = "";
		String tradingOrderPayeeCustId = "";
		String tradingOrderpayState = "";
		String tradingOrderState = "";
		String tradingOrderSrcCustId = "";
		String result = tradingOrdersService.queryTradingOrders(tradingOrderSrcCustId, tradingOrderParkingOrderId,
				tradingOrderPayeeCustId, tradingOrderState, tradingOrderpayState, tradingOrderBalanceState, startTime,
				endTime);
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/getCode")
	@Produces("application/json")
	public Response getCode() {
		String result = CheckUtils.getIdentifyingCode();
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * getChargingStandardsListByParkingInfoId:(停车场收费标准byID). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingInfoId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/getChargingStandardsListByParkingInfoId")
	@Produces("application/json")
	public Response getChargingStandardsListByParkingInfoId(@QueryParam("parkingInfoId") String parkingInfoId) {

		chargingStandardsService = (ChargingStandardsService) SpringApplicationContext
				.getBean("chargingStandardsService");
		String result = chargingStandardsService.getChargingStandardsListByParkingInfoId(parkingInfoId);
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/getParkingInfoById")
	@Produces("application/json")
	public Response getParkingInfoById(@QueryParam("parkingInfoId") String parkingInfoId) {

		parkingInfoService = (ParkingInfoService) SpringApplicationContext.getBean("parkingInfoService");
		String result = parkingInfoService.getParkingInfoById(parkingInfoId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * selectByCarNo:(通过车牌号查询停车场订单信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderCarNo
	 * @param parkingOrderParkingInfoId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectByCarNo")
	@Produces("application/json")
	public Response selectByCarNo(@QueryParam("parkingOrderCarNo") String parkingOrderCarNo,
			@QueryParam("parkingOrderParkingInfoId") String parkingOrderParkingInfoId) {

		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result = parkingOrderService.selectByCarNo(parkingOrderCarNo, parkingOrderParkingInfoId);
		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/queryParkOrderByCarNo")
	@Produces("application/json")
	public Response queryParkOrderByCarNo(@QueryParam("parkingOrderCarNo") String parkingOrderCarNo) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result = parkingOrderService.queryParkOrder("", parkingOrderCarNo, "", "", "stay", "", "", "", "", "",
				"", "", "", "");
		return Response.status(200).entity(result).build();

	}

	/**
	 * 
	 * selectParkingState:(通过车牌还查询车辆是否在停). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderCarNo
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/selectParkingState")
	@Produces("application/json")
	public Response selectParkingState(@QueryParam("parkingOrderCarNo") String parkingOrderCarNo) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result = parkingOrderService.selectParkingState(parkingOrderCarNo);
		return Response.status(200).entity(result).build();

	}

	/**
	 * 
	 * unifiedOrder:(充值订单下单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param chargingOrder2ClientUserId
	 *            用户id
	 * @param chargingOrderChargingType
	 *            充值类型 // 值 1 支付宝支付渠道 值 2 微信支付渠道 值 3 银联宝支付渠道
	 * @param chargingOrderChargingAccount
	 *            充值订单业务发起者使用的支付渠道账号
	 * @param chargingOrderAmount
	 *            充值订单充值金额
	 * @param clientUserSecurity
	 *            用户令牌
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/unifiedOrder")
	@Produces("application/json")
	public Response UnifiedOrder(@QueryParam("chargingOrder2ClientUserId") String chargingOrder2ClientUserId,
			@QueryParam("chargingOrderChargingType") String chargingOrderChargingType,
			@QueryParam("chargingOrderChargingAccount") String chargingOrderChargingAccount,
			@QueryParam("chargingOrderAmount") String chargingOrderAmount,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		System.out.println("---------");
		chargingOrderService = (ChargingOrderService) SpringApplicationContext.getBean("chargingOrderService");
		String result = chargingOrderService.unifiedOrder(chargingOrder2ClientUserId, chargingOrderChargingType,
				chargingOrderChargingAccount, chargingOrderAmount, clientUserSecurity);

		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * getParkInfoByLoLa:(通过经纬度获得附近1km内停车场). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param Lonitude
	 *            经度
	 * @param Latitude
	 *            纬度
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/getParkInfoByLoLa")
	@Produces("application/json")
	public Response getParkInfoByLoLa(@QueryParam("Lonitude") String Lonitude,
			@QueryParam("Latitude") String Latitude) {
		parkingInfoService = (ParkingInfoService) SpringApplicationContext.getBean("parkingInfoService");
		String result = parkingInfoService.getParkInfoByLoLa(Lonitude, Latitude);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * addRegistrAtionId:(更新用户推送ID). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param registrAtionId
	 *            推送账户id
	 * @param clientUserSecurity
	 *            令牌
	 * @param clientUserId
	 *            用户id
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/addRegistrAtionId")
	@Produces("application/json")
	public Response addRegistrAtionId(@QueryParam("registrAtionId") String registrAtionId,
			@QueryParam("clientUserSecurity") String clientUserSecurity,
			@QueryParam("clientUserId") String clientUserId, @QueryParam("clientUserType") String clientUserType) {
		clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
		String result = clientUserService.addRegistrAtionId(registrAtionId, clientUserSecurity, clientUserId,
				clientUserType);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * addHandsetRegistrAtionId:(更新手持设备推送id). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param handsetRegistrAtionId
	 * @param handsetManagerPhone
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/addHandsetRegistrAtionId")
	@Produces("application/json")
	public Response addHandsetRegistrAtionId(@QueryParam("handsetRegistrAtionId") String handsetRegistrAtionId,
			@QueryParam("handsetManagerPhone") String handsetManagerPhone) {
		handsetSysService = (HandsetSysService) SpringApplicationContext.getBean("handsetSysService");
		String result = handsetSysService.addHandsetRegistrAtionId(handsetRegistrAtionId, handsetManagerPhone);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * quertMessageByUserIdWhereStatus:(用户消息内容查询). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgUserId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/quertMessageByUserIdWhereStatus")
	@Produces("application/json")
	public Response quertMessageByUserIdWhereStatus(@QueryParam("msgUserId") String msgUserId,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		messageService = (MessageService) SpringApplicationContext.getBean("messageService");
		String result = messageService.queryMessageByUserIdWhereStatus(msgUserId, "2", clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * updateOrderPayState:(更新用户支付状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/updateOrderPayState")
	@Produces("application/json")
	public Response updateOrderPayState(@QueryParam("parkingOrderId") String parkingOrderId) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result = parkingOrderService.updateOrderPayState("Paid", parkingOrderId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * getHandesetOrder:(查询当天截至时间订单总金额数量). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param managerId
	 *            手持用户id
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/getHandesetOrder")
	@Produces("application/json")
	public Response getHandesetOrder(@QueryParam("managerId") String managerId) {
		handsetSysService = (HandsetSysService) SpringApplicationContext.getBean("handsetSysService");
		String result = handsetSysService.getHandesetOrder(managerId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * createOpinion:(评价). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param opinionUserId
	 * @param opinionBody
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/createOpinion")
	@Produces("application/json")
	public Response createOpinion(@QueryParam("opinionUserId") String opinionUserId,
			@QueryParam("opinionBody") String opinionBody,
			@QueryParam("clientUserSecurity") String clientUserSecurity) {
		opinionService = (OpinionService) SpringApplicationContext.getBean("opinionService");
		String result = opinionService.createOpinion(opinionUserId, opinionBody, clientUserSecurity);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * queryHandesetOrderByManagerId:(查询手持用户统计数据). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param managerId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/queryHandesetOrderByManagerId")
	@Produces("application/json")
	public Response queryHandesetOrderByManagerId(@QueryParam("managerId") String managerId) {
		handsetSysService = (HandsetSysService) SpringApplicationContext.getBean("handsetSysService");
		String result = handsetSysService.queryHandesetOrderByManagerId(managerId);
		return Response.status(200).entity(result).build();
	}

	/**
	 * 
	 * queryChargingOrderByUserId:(查询用户充值记录). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param userId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/queryChargingOrderByUserId")
	@Produces("application/json")
	public Response queryChargingOrderByUserId(@QueryParam("userId") String userId) {
		chargingOrderService = (ChargingOrderService) SpringApplicationContext.getBean("chargingOrderService");
		String chargingOrderChargingType = "";
		String startTime = "";
		String endTime = "";
		String chargingOrderPaymentPlatformFeedback = "";
		String result = chargingOrderService.queryChargingOrder(userId, chargingOrderChargingType, startTime, endTime,
				chargingOrderPaymentPlatformFeedback);
		return Response.status(200).entity(result).build();

	}

	/**
	 * 
	 * queryChargingOrderLimit:(查询用户充值记录分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param userId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/queryChargingOrderLimit")
	@Produces("application/json")
	public Response queryChargingOrderLimit(@QueryParam("userId") String userId,
			@QueryParam("pageNumber") String pageNumber, @QueryParam("pageSize") String pageSize) {
		chargingOrderService = (ChargingOrderService) SpringApplicationContext.getBean("chargingOrderService");
		String chargingOrderChargingType = "";
		String startTime = "";
		String endTime = "";
		String chargingOrderPaymentPlatformFeedback = "";
		String result = chargingOrderService.queryChargingOrderLimit(userId, chargingOrderChargingType, startTime,
				endTime, chargingOrderPaymentPlatformFeedback, Integer.valueOf(pageNumber), Integer.valueOf(pageSize));

		return Response.status(200).entity(result).build();

	}

	/**
	 * 
	 * OrderPayCash:(现金支付订单). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param parkingOrderId
	 * @return
	 * @since JDK 1.8u60
	 */
	@GET
	@Path("/OrderPayCash")
	@Produces("application/json")
	public Response OrderPayCash(@QueryParam("parkingOrderId") String parkingOrderId,
			@QueryParam("clientUserSecurity") String clientUserSecurity,
			@QueryParam("clientUserId") String clientUserId) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");

		String result = parkingOrderService.OrderPayCash(parkingOrderId, clientUserSecurity, clientUserId);
		return Response.status(200).entity(result).build();
	}

	// 汉王进场接口
	@GET
	@Path("/enter")
	@Produces("application/json")
	public Response enter(@QueryParam("plate") String plate, @QueryParam("companyID") String companyID) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result;
		if (plate != null && companyID != null) {
			result = parkingOrderService.enter(plate, companyID);
		} else {
			result = "";
		}

		return Response.status(200).entity(result).build();
	}

	// 汉王出场接口
	@GET
	@Path("/exit")
	@Produces("application/json")
	public Response exit(@QueryParam("plate") String plate, @QueryParam("companyID") String companyID,
			@QueryParam("handsetManagerPhone") String handsetManagerPhone) {
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");
		String result;
		if (plate != null && companyID != null) {
			result = parkingOrderService.exit(plate, companyID);

		} else {
			result = "";
		}
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/upUserAutoPay")
	@Produces("application/json")
	public Response upUserAutoPay(@QueryParam("clientUserAutoPay") String clientUserAutoPay,
			@QueryParam("clientUserSecurity") String clientUserSecurity,
			@QueryParam("clientUserId") String clientUserId) {
		clientUserService = (ClientUserService) SpringApplicationContext.getBean("clientUserService");
		String result;
		result = clientUserService.upUserAutoPay(clientUserAutoPay, clientUserSecurity, clientUserId);
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/numberCount")
	@Produces("application/json")
	public Response numberCount(@QueryParam("userId") String userId, @Context HttpServletRequest req) {

		messageService = (MessageService) SpringApplicationContext.getBean("messageService");
		parkingOrderService = (ParkingOrderService) SpringApplicationContext.getBean("parkingOrderService");

		String result = ResultObject.obj2JsonResult("1", "查询成功",
				new NumberCountPoJo(parkingOrderService.countOrder(userId), messageService.countMessage(userId)));
		System.out.println(req.getRemoteAddr());
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/getAppVersion")
	@Produces("application/json")
	public Response getAppVersion() {
		appVersionService = (AppVersionService) SpringApplicationContext.getBean("appVersionService");
		String result = appVersionService.getAppVersion();
		System.out.println(result);
		return Response.status(200).entity(result).build();
	}
}
