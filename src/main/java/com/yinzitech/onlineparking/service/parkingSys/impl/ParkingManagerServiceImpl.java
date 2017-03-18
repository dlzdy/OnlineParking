/**
 * Project Name:OnlineParking
 * File Name:ParkingManagerServiceImpl.java
 * Package Name:com.yinzitech.onlineparking.service.parkingSys.impl
 * Date:2015年10月4日上午7:06:11
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.parkingSys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzitech.onlineparking.core.coreTools.ToolsIdGenerator;
import com.yinzitech.onlineparking.dao.parkingSys.ParkingInfoSysMapperDao;
import com.yinzitech.onlineparking.dao.parkingSys.ParkingManagerDao;
import com.yinzitech.onlineparking.entity.common.ResultObject;
import com.yinzitech.onlineparking.entity.common.ResultObjectList;
import com.yinzitech.onlineparking.entity.common.ResultResponse;
import com.yinzitech.onlineparking.entity.parkingSys.manager.ParkingManager;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;
import com.yinzitech.onlineparking.utils.PageHelper;
import com.yinzitech.onlineparking.utils.PageHelper.Page;
import com.yinzitech.onlineparking.utils.TimeTools;

/**
 * ClassName:ParkingManagerServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午7:06:11 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
@Service
public class ParkingManagerServiceImpl implements ParkingManagerService {
	@Autowired
	ParkingManagerDao parkingManagerDao;
	@Autowired
	ParkingInfoSysMapperDao pd;

	/**
	 * 
	 * Title: hasPhoneNumber查询目标手机号是否已经在平台中存在<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerPhone
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#hasPhoneNumber(java.lang.String)
	 */
	@Override
	public String hasPhoneNumber(String parkingManagerPhone) {
		int target = parkingManagerDao.hasPhoneNumber(parkingManagerPhone);
		/* 已经存在 */
		if (target > 0) {
			System.err.println("用户发起对手机号为" + parkingManagerPhone + "的停车管理员账户手机号查询,结果查询到手机号已经存在");
			return ResultResponse.obj2JsonResult("0", "该手机账户已经在系统中存在,请检查手机号或更换手机再次尝试", "");
		} else {
			System.err.println("用户发起对手机号为" + parkingManagerPhone + "的停车管理员账户手机号查询,结果查询到手机号不存在");
			return ResultResponse.obj2JsonResult("1", "该手机账户可以注册", "");

		}
	}

	/**
	 * 
	 * Title: parkingManagerSignUp停车场管理员账户注册<br/>
	 * Description:这里描述这个方法适用条件 –
	 * 目标手机号调用hasPhoneNumber方法后返回成功,后台中没有此手机号此手机号可用的情况下可以使用<br/>
	 * 
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#parkingManagerSignUp(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String parkingManagerSignUp(String parkingManagerPhone, String parkingManagerPsd, String parkingManagerName,
			String parkingInfoId) {
		/**
		 * 从id生成器工具类中生成id
		 */
		String parkingManagerId = ToolsIdGenerator.getUUID();

		String parkingManagerCreateTime = TimeTools.getCurrentTime();
		String parkingManagerActiveMark = "enable";
		int target = parkingManagerDao.insertParkingManager(parkingManagerId, parkingManagerPhone, parkingManagerPsd,
				parkingInfoId, parkingManagerCreateTime, parkingManagerActiveMark, parkingManagerName);

		if (target > 0) {
			System.err.println("用户发起对手机号为" + parkingManagerPhone + "的停车管理员账户注册申请,注册成功");
			return ResultResponse.obj2JsonResult("1", "停车管理员账户" + parkingManagerPhone + "注册成功", parkingManagerId);
		} else {
			System.err.println("用户发起对手机号为" + parkingManagerPhone + "的停车管理员账户注册申请,注册失败");
			return ResultResponse.obj2JsonResult("0", "停车管理员账户" + parkingManagerPhone + "注册失败", "");

		}
	}

	/**
	 * 
	 * Title: getParkingManagerByParkingManagerId通过Id查询停车场管理员信息<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#getParkingManagerByParkingManagerId(java.lang.String)
	 */
	@Override
	public String getParkingManagerByParkingManagerId(String parkingManagerId) {
		ParkingManager pm = parkingManagerDao.getParkingManagerByParkingManagerId(parkingManagerId);
		if (null != pm) {
			System.err.println("用户发起对停车场管理员id为" + parkingManagerId + "的停车管理员账户进行查询,查询成功");
			return ResultObject.obj2JsonResult("1", "查询成功", pm);
		} else {
			System.err.println("用户发起对停车场管理员id为" + parkingManagerId + "的停车管理员账户进行查询,查询失败");
			return ResultObject.obj2JsonResult("0", "查询失败", "");
		}
	}

	/**
	 * 
	 * Title: getParkingManagerByParkingManagerPhone通过手机号查询停车场管理员信息<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerPhone
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#getParkingManagerByParkingManagerPhone(java.lang.String)
	 */
	@Override
	public String getParkingManagerByParkingManagerPhone(String parkingManagerPhone) {

		ParkingManager pm = parkingManagerDao.getParkingManagerByParkingManagerPhone(parkingManagerPhone);
		if (null != pm) {
			System.err.println("用户发起对停车场管理员手机号为" + parkingManagerPhone + "的停车管理员账户进行查询,查询成功");
			return ResultObject.obj2JsonResult("1", "查询成功", pm);
		} else {
			System.err.println("用户发起对停车场管理员手机号为" + parkingManagerPhone + "的停车管理员账户进行查询,查询失败");
			return ResultObject.obj2JsonResult("0", "查询失败", "");
		}
	}

	/**
	 * 
	 * Title: login用户登录<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String login(String parkingManagerPhone, String parkingManagerPsd) {
		ParkingManager pm = parkingManagerDao.login(parkingManagerPhone, parkingManagerPsd);
		if (null != pm) {
			return ResultObject.obj2JsonResult("1", "登录成功", pm);
		}
		return ResultObject.obj2JsonResult("0", "登录失败", pm);
	}

	/**
	 * 
	 * Title: updateParkingManager更新停车场管理员账号信息<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @param parkingInfoId
	 * @param parkingManagerCreateTime
	 * @param parkingManagerActiveMark
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#updateParkingManager(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updateParkingManager(String parkingManagerPhone, String parkingManagerPsd, String parkingInfoId,
			String parkingManagerCreateTime, String parkingManagerActiveMark) {
		int target = parkingManagerDao.updateParkingManager(parkingManagerPhone, parkingManagerPsd, parkingInfoId,
				parkingManagerCreateTime, parkingManagerActiveMark);
		if (target > 0) {
			return ResultObject.obj2JsonResult("1", "用户对手机号:[" + parkingManagerPhone + "],更新停车场管理员账号信息成功",
					parkingManagerPhone);
		} else {
			return ResultObject.obj2JsonResult("0", "用户对手机号:[" + parkingManagerPhone + "],更新停车场管理员账号信息失败",
					parkingManagerPhone);

		}
	}

	/**
	 * 
	 * Title: updateParkingManagerPhone更换停车场管理员手机号<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerId
	 * @param parkingManagerPhone
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#updateParkingManagerPhone(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updateParkingManagerPhone(String parkingManagerId, String parkingManagerPhone) {
		int target = parkingManagerDao.updateParkingManagerPhone(parkingManagerId, parkingManagerPhone);

		if (target > 0) {
			return ResultObject.obj2JsonResult("1", "用户" + parkingManagerId + "更换手机号:[" + parkingManagerPhone + "],成功",
					parkingManagerPhone);
		} else {
			return ResultObject.obj2JsonResult("0", "用户" + parkingManagerId + "更换手机号:[" + parkingManagerPhone + "],失败",
					parkingManagerPhone);

		}
	}

	/**
	 * 
	 * Title: updateParkingManagerPsd停车场管理员密码找回<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerPhone
	 * @param parkingManagerPsd
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#updateParkingManagerPsd(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updateParkingManagerPsd(String parkingManagerPhone, String parkingManagerPsd) {
		int target = parkingManagerDao.updateParkingManagerPsd(parkingManagerPhone, parkingManagerPsd);
		if (target > 0) {
			return ResultObject.obj2JsonResult("1", "用户[" + parkingManagerPhone + "]更新密码成功", parkingManagerPhone);
		} else {
			return ResultObject.obj2JsonResult("0", "用户[" + parkingManagerPhone + "]更新密码失败", parkingManagerPhone);

		}
	}

	/**
	 * 
	 * @Title: selectAllParkingManager:(查询所有停车场管理员账户). <br/>
	 *
	 * @author Kevin
	 * @return
	 * @since JDK 1.8
	 */
	@Override
	public String selectAllParkingManager(int pageNumber, int pageSize) {

		PageHelper.startPage(pageNumber, pageSize);
		List<ParkingManager> list = parkingManagerDao.selectAllParkingManager();
		Page s = PageHelper.endPage();
		if (list.size() > 0) {
			return ResultObject.obj2JsonResult("1", "查询所有停车场管理员用户成功", s);
		} else {
			return ResultObjectList.obj2JsonResult("0", "查询所有停车场管理员用户失败", list);

		}
	}

	/**
	 * 
	 * Title: disableParkingManager更改停车场管理员用户状态<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerPhone
	 * @param parkingManagerActiveMark
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#disableParkingManager(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String disableParkingManager(String parkingManagerPhone, String parkingManagerActiveMark) {
		int target = parkingManagerDao.disableParkingManager(parkingManagerPhone, parkingManagerActiveMark);
		if (target > 0) {
			return ResultObject.obj2JsonResult("1", "手机号为[" + parkingManagerPhone + "]查询所有停车场管理员更改停车场管理员用户状态成功", "");
		} else {
			return ResultObject.obj2JsonResult("0", "手机号为[" + parkingManagerPhone + "]查询所有停车场管理员更改停车场管理员用户状态失败", "");

		}
	}

	@Override
	public String deleteParkingManager(String parkingManagerId) {
		int target = parkingManagerDao.deleteParkingManager(parkingManagerId);
		if (target > 0) {
			return ResultObject.obj2JsonResult("1", "ID为[" + parkingManagerId + "]的停车场管理员删除用户成功", "");
		} else {
			return ResultObject.obj2JsonResult("0", "ID为[" + parkingManagerId + "]的停车场管理员删除用户失败", "");

		}
	}

	/**
	 * 
	 * Title: updtaParkingInfoId根据停车场管理员手机号,关联停车场<br/>
	 * Description:<br/>
	 * 
	 * @param parkingManagerPhone
	 * @param parkingInfoId
	 * @return
	 * @see com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService#updtaParkingInfoId(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String updtaParkingInfoId(String parkingManagerPhone, String parkingInfoId) {

		int target = parkingManagerDao.updateParkingInfoId(parkingManagerPhone, parkingInfoId);
		if (target > 0) {
			return ResultObject.obj2JsonResult("1",
					"ID为[" + parkingManagerPhone + "]的停车场管理员关联id为parkingInfoId:[" + parkingInfoId + "]成功", "");
		} else {
			return ResultObject.obj2JsonResult("0",
					"ID为[" + parkingManagerPhone + "]的停车场管理员关联id为parkingInfoId:[" + parkingInfoId + "]失败", "");

		}
	}
	@Override
	public String getParkingInfoMapper(String parkingManagerId, String parkingManagerPhone, String parkingManagerPsd,
			String parkingInfoId, String parkingManagerActiveMark, String parkingManagerName, int pageNumber,
			int pageSize) {

		String json = "";
		String phone = "";
		String name = "";
		if (parkingManagerPhone != null & parkingManagerPhone != "") {
			phone = "%" + parkingManagerPhone + "%";
		}
		if (parkingManagerName != null & parkingManagerName != "") {
			name = "%" + parkingManagerName + "%";
		}
		PageHelper.startPage(pageNumber, pageSize);
		List<ParkingManager> list = pd.getParkingInfoMapper(parkingManagerId, phone, parkingManagerPsd, parkingInfoId,
				parkingManagerActiveMark, name);
		Page s = PageHelper.endPage();
		if (list != null) {
			json = ResultObject.obj2JsonResult("1", "查询成功", s);
		} else {
			json = ResultResponse.obj2JsonResult("0", "暂无数据", "");
		}

		return json;
	}

	@Override
	public String upParkingManager(String parkingManagerPhone, String parkingManagerPsd, String parkingManagerName,
			String parkingManagerActiveMark, String parkingInfoId, String parkingManagerId) {

		int target = pd.upParkingManager(parkingManagerPhone, parkingManagerPsd, parkingManagerName,
				parkingManagerActiveMark, parkingInfoId, parkingManagerId);
		if (target > 0) {
			return ResultObject.obj2JsonResult("1", "更新成功", "");
		} else {
			return ResultObject.obj2JsonResult("0", "更新失败", "");
		}

	}
}
