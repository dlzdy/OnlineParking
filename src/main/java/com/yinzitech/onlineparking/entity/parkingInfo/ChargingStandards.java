/**
 * Project Name:OnlineParking
 * File Name:ChargingStandards.java
 * Package Name:com.yinzitech.onlineparking.entity.parkingInfo
 * Date:2015年10月4日下午4:48:11
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.parkingInfo;

import java.io.Serializable;

/**
 * ClassName:ChargingStandards <br/>
 * Function: 停车场收费标准. <br/>
 * Reason: 对应实体类 ChargingStandards<br/>
 * 停车场景中停车场收费标准对应的模拟对象. <br/>
 * Date: 2015年10月4日 下午4:48:11 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see 
 */
public class ChargingStandards implements Serializable {

	/**
	 * 
	 * Title: 无参构造方法<br/>
	 * Description:<br/>
	 */
	public ChargingStandards() {
		super();
	}

	/**
	 * 
	 * Title: 全参构造方法<br/>
	 * Description:<br/>
	 * 
	 * @param chargingStandardsManagerId
	 * @param chargingStandardsManagerType
	 * @param chargingStandardsCreateTime
	 * @param chargingStandardsState
	 * @param chargingStandardsPrise
	 * @param chargingStandardsStepStart
	 * @param chargingStandardsStepEnd
	 * @param chargingStandardsStep
	 * @param parkingInfoId
	 * @param chargingStandardsId
	 */
	public ChargingStandards(String chargingStandardsManagerId, String chargingStandardsManagerType,
			String chargingStandardsCreateTime, String chargingStandardsState, String chargingStandardsPrise,
			String chargingStandardsStepStart, String chargingStandardsStepEnd, String chargingStandardsStep,
			String parkingInfoId, String chargingStandardsId) {
		super();
		this.chargingStandardsManagerId = chargingStandardsManagerId;
		this.chargingStandardsManagerType = chargingStandardsManagerType;
		this.chargingStandardsCreateTime = chargingStandardsCreateTime;
		this.chargingStandardsState = chargingStandardsState;
		this.chargingStandardsPrise = chargingStandardsPrise;
		this.chargingStandardsStepStart = chargingStandardsStepStart;
		this.chargingStandardsStepEnd = chargingStandardsStepEnd;
		this.chargingStandardsStep = chargingStandardsStep;
		this.parkingInfoId = parkingInfoId;
		this.chargingStandardsId = chargingStandardsId;
	}

	public String getChargingStandardsManagerId() {
		return chargingStandardsManagerId;
	}

	public void setChargingStandardsManagerId(String chargingStandardsManagerId) {
		this.chargingStandardsManagerId = chargingStandardsManagerId;
	}

	public String getChargingStandardsManagerType() {
		return chargingStandardsManagerType;
	}

	public void setChargingStandardsManagerType(String chargingStandardsManagerType) {
		this.chargingStandardsManagerType = chargingStandardsManagerType;
	}

	public String getChargingStandardsCreateTime() {
		return chargingStandardsCreateTime;
	}

	public void setChargingStandardsCreateTime(String chargingStandardsCreateTime) {
		this.chargingStandardsCreateTime = chargingStandardsCreateTime;
	}

	public String getChargingStandardsState() {
		return chargingStandardsState;
	}

	public void setChargingStandardsState(String chargingStandardsState) {
		this.chargingStandardsState = chargingStandardsState;
	}

	public String getChargingStandardsPrise() {
		return chargingStandardsPrise;
	}

	public void setChargingStandardsPrise(String chargingStandardsPrise) {

		this.chargingStandardsPrise = chargingStandardsPrise;
	}

	public String getChargingStandardsStepStart() {
		return chargingStandardsStepStart;
	}

	public void setChargingStandardsStepStart(String chargingStandardsStepStart) {
		this.chargingStandardsStepStart = chargingStandardsStepStart;
	}

	public String getChargingStandardsStepEnd() {
		return chargingStandardsStepEnd;
	}

	public void setChargingStandardsStepEnd(String chargingStandardsStepEnd) {
		this.chargingStandardsStepEnd = chargingStandardsStepEnd;
	}

	public String getChargingStandardsStep() {
		return chargingStandardsStep;
	}

	public void setChargingStandardsStep(String chargingStandardsStep) {
		this.chargingStandardsStep = chargingStandardsStep;
	}

	public String getParkingInfoId() {
		return parkingInfoId;
	}

	public void setParkingInfoId(String parkingInfoId) {
		this.parkingInfoId = parkingInfoId;
	}

	public String getChargingStandardsId() {
		return chargingStandardsId;
	}

	public void setChargingStandardsId(String chargingStandardsId) {
		this.chargingStandardsId = chargingStandardsId;
	}

	/**
	 * chargingStandardsManagerId<br/>
	 * 停车费用标准阶段收费标准更改动人员id<br/>
	 * 参照 charging_standards_manager_type 停车费用标准j阶段s收费标准更改人类型<br/>
	 * 当值<br/>
	 * =1 时 为后台管理员id<br/>
	 * =2 时 为停车场场主管理员id<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性 chargingStandardsManagerId<br/>
	 * 属性类型 String<br/>
	 * 数据库类型 varchar<br/>
	 * 长度100<br/>
	 * 无默值 ,根据操作停车场收费标准信息时,获取操作人员id<br/>
	 * (新建停车场信息,也算操作,暂定为初始化操作<br/>
	 * )
	 */
	private String chargingStandardsManagerId;

	/**
	 * chargingStandardsManagerType<br/>
	 * 停车费用标准j阶段s收费标准更改人类型<br/>
	 * 表示这是阶梯标准中的第几阶段<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性 chargingStandardsManagerType<br/>
	 * 属性类型 String <br/>
	 * 数据库类型 varchar<br/>
	 * 长度2<br/>
	 * 默认为 1 后台管理员<br/>
	 * 1 后台管理员<br/>
	 * 2 停车场场主管理员<br/>
	 */
	private String chargingStandardsManagerType;

	/**
	 * chargingStandardsCreateTime<br/>
	 * 停车费用标准j阶段收费标准更改时间<br/>
	 * 表示这是阶梯标准中的第几阶段<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性 chargingStandardsCreateTime<br/>
	 * 属性类型 String<br/>
	 * 数据库类型 varchar<br/>
	 * 长度 19<br/>
	 * 默认为当停车费用标准j阶段收费标准发生生变动时<br/>
	 * 系统自动从后台获取时间生成<br/>
	 * 格式 YYYY-MM-DD hh:mm:ss<br/>
	 * 年-月-日 时时秒分秒秒<br/>
	 * eg:1999-01-01 13:22:22<br/>
	 */
	private String chargingStandardsCreateTime;

	/**
	 * chargingStandardsState<br/>
	 * 停车费用标准阶段s收费标准状态<br/>
	 * 表示这是阶梯标准中的第几阶段<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性 chargingStandardsState<br/>
	 * 属性类型 String <br/>
	 * 数据库类型 varchar<br/>
	 * 长度7<br/>
	 * 两个状态值<br/>
	 * enable 表示该费用标准设置为活跃状态<br/>
	 * disable 表示该费用标准为禁用状态<br/>
	 * 数据库中自动初始化为disable<br/>
	 * 初始化时由用户添加<br/>
	 * 
	 */
	private String chargingStandardsState;

	/**
	 * chargingStandardsPrise<br/>
	 * 停车费用标准j阶段s收费标准<br/>
	 * 表示这是阶梯标准中的第几阶段<br/>
	 * eg: 阶梯段停车费收取标准 0-60分钟为第一段, 收费标准为10元 则该值为10<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性 chargingStandardsPrise<br/>
	 * 属性类型 String <br/>
	 * 数据库类型 varchar<br/>
	 * 长度 4<br/>
	 * 数据库中自动初始化为0<br/>
	 * 设计值为 000 <br/>
	 * 代表 0.00元<br/>
	 * 使用时,先乘以系数100<br/>
	 * 将实际金额转换为绝对整数后,进行运算,在运算结束后再除以系数100将换算为实际金额<br/>
	 * 数据库中不自动初始化,,由设定停车场收费标准人员手工初始化<br/>
	 * 
	 */
	private String chargingStandardsPrise;

	/**
	 * chargingStandardsStepStart<br/>
	 * 停车费用标准j阶段开始时间点(以分钟计)<br/>
	 * 表示这是阶梯标准中的第几阶段<br/>
	 * eg: 阶梯段停车费收取标准 0-60分钟为第一段,则该值为0<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性 chargingStandardsStepStart<br/>
	 * 属性类型 String <br/>
	 * 数据库类型 varchar<br/>
	 * 长度 5<br/>
	 * 数据库中不自动初始化<br/>
	 * 新建停车场信息时由设置生成<br/>
	 */
	private String chargingStandardsStepStart;

	/**
	 * chargingStandardsStepEnd<br/>
	 * 停车费用标准j阶段结束时间点(以分钟计)<br/>
	 * 表示这是阶梯标准中的第几阶段<br/>
	 * eg: 阶梯段停车费收取标准 0-60分钟为第一段,则该值为60<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性 chargingStandardsStepEnd<br/>
	 * 属性类型 String<br/>
	 * 数据库类型 varchar<br/>
	 * 长度 5<br/>
	 * 数据库中不自动初始化<br/>
	 * 新建停车场信息时由设置生成<br/>
	 * 
	 */
	private String chargingStandardsStepEnd;

	/**
	 * chargingStandardsStep<br/>
	 * 停车费用标准j阶段取值<br/>
	 * 表示这是阶梯标准中的第几阶段<br/>
	 * eg: 阶梯段停车费收取标准 0-60分钟为第一段,则该取值为 1<br/>
	 * 阶梯段停车费收取标准 61-120分钟为第一段,则该取值为 2<br/>
	 * 阶梯段停车费收取标准 121-180分钟为第一段,则该取值为 3<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性 chargingStandardsStep<br/>
	 * 属性类型 String<br/>
	 * 数据库类型 varchar<br/>
	 * 长度2<br/>
	 * 数据库中不自动初始化,<br/>
	 * 新建停车场信息时由设置生成<br/>
	 */
	private String chargingStandardsStep;

	/**
	 * parkingInfoId<br/>
	 * 停车费用标准对应停车场id<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards<br/>
	 * 属性类型String<br/>
	 * 数据库类型varchar<br/>
	 * 长度100<br/>
	 * 数据库中不自动初始化<br/>
	 * 新建停车场信息时由调用生成器生成<br/>
	 */
	private String parkingInfoId;

	/**
	 * chargingStandardsId<br/>
	 * 停车场收费标准id<br/>
	 * 数据库表 charging_standards<br/>
	 * 对应实体类 ChargingStandards <br/>
	 * 属性 chargingStandardsId<br/>
	 * 属性类型String<br/>
	 * 数据库类型varchar<br/>
	 * 长度100<br/>
	 * 数据库中不自动初始化<br/>
	 * 初始化时由调用ID生成器生成<br/>
	 */
	private String chargingStandardsId;

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = -7439660465459665411L;

}
