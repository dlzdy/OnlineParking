/**
 * Project Name:OnlineParking
 * File Name:ClinetUserCarManage.java
 * Package Name:com.yinzitech.onlineparking.entity.client.carManage
 * Date:2015��10��4������3:14:01
 * Copyright (c) 2015, ziheng All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.client.carManage;

import java.io.Serializable;

/**
 * ClassName:ClinetUserCarManage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015��10��4�� ����3:14:01 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class ClinetUserCarManage implements Serializable {

	@Override
	public String toString() {
		return "ClinetUserCarManage [carManageId=" + carManageId + ", clientUserId=" + clientUserId
				+ ", clientUserCarNo=" + clientUserCarNo + ", clientUserCarPosition=" + clientUserCarPosition
				+ ", clientUserCarActiveMark=" + clientUserCarActiveMark + ", carNoSettingTime=" + carNoSettingTime
				+ "]";
	}

	/**
	 * 
	 * Title: �޲ι��췽��<br/>
	 * Description:<br/>
	 */
	public ClinetUserCarManage() {
	}

	/**
	 * 
	 * Title: �вι��췽��<br/>
	 * Description:<br/>
	 * 
	 * @param carManageId
	 * @param clientUserId
	 * @param clientUserCarNo
	 * @param clientUserCarPosition
	 * @param clientUserCarActiveMark
	 * @param carNoSettingTime
	 */
	public ClinetUserCarManage(String carManageId, String clientUserId, String clientUserCarNo,
			String clientUserCarPosition, String clientUserCarActiveMark, String carNoSettingTime) {
		super();
		this.carManageId = carManageId;
		this.clientUserId = clientUserId;
		this.clientUserCarNo = clientUserCarNo;
		this.clientUserCarPosition = clientUserCarPosition;
		this.clientUserCarActiveMark = clientUserCarActiveMark;
		this.carNoSettingTime = carNoSettingTime;
	}

	public String getCarManageId() {
		return carManageId;
	}

	public void setCarManageId(String carManageId) {
		this.carManageId = carManageId;
	}

	public String getClientUserId() {
		return clientUserId;
	}

	public void setClientUserId(String clientUserId) {
		this.clientUserId = clientUserId;
	}

	public String getClientUserCarNo() {
		return clientUserCarNo;
	}

	public void setClientUserCarNo(String clientUserCarNo) {
		this.clientUserCarNo = clientUserCarNo;
	}

	public String getClientUserCarPosition() {
		return clientUserCarPosition;
	}

	public void setClientUserCarPosition(String clientUserCarPosition) {
		this.clientUserCarPosition = clientUserCarPosition;
	}

	public String getClientUserCarActiveMark() {
		return clientUserCarActiveMark;
	}

	public void setClientUserCarActiveMark(String clientUserCarActiveMark) {
		this.clientUserCarActiveMark = clientUserCarActiveMark;
	}

	public String getCarNoSettingTime() {
		return carNoSettingTime;
	}

	public void setCarNoSettingTime(String carNoSettingTime) {
		this.carNoSettingTime = carNoSettingTime;
	}

	/**
	 * 'car_manage_id ���������û���������id ���ݿ��client_user_car_manage
	 * ��Ӧʵ����ClientUserCarManage ���� carManageId; ��������String,���ݿ�����varchar ����100
	 * ���ݿ��в��Զ���ʼ��, ��ʼ��ʱ�ɵ���ID����������',
	 * 
	 */
	public String carManageId;
	/**
	 * 'client_user_id ���������û�id ���ݿ��client_user ��Ӧʵ����ClientUser ���� clientUserId;
	 * ��������String,���ݿ�����varchar ����100 ���ݿ��в��Զ���ʼ��, �Դ��ֶ����û������N:1��ϵ',
	 * 
	 */
	public String clientUserId;
	/**
	 * 'client_user_car_no ���������û����ƺ� ���ݿ��client_user_car_manage
	 * ��Ӧʵ����ClientUserCarManage ���� clientUserCarNo; ��������String,���ݿ�����varchar ����10
	 * ���ݿ��в��Զ���ʼ��, ��ʼ��ʱ���û����',
	 * 
	 */
	public String clientUserCarNo;
	/**
	 * 'client_user_car_position ���������û����ƺ���ʾ˳�� ���ݿ��client_user_car_manage
	 * ��Ӧʵ����ClientUserCarManage ���� clientUserCarPosition ��������String,���ݿ�����varchar
	 * ����2 ���ݿ��в��Զ���ʼ��, ��ʼ��ʱ���û����ʱ���ֻ�������',
	 * 
	 */
	public String clientUserCarPosition;
	/**
	 * 'enable' COMMENT 'client_user_car_active_mark ���������û����ƺ�
	 * ���ݿ��client_user_car_manage ��Ӧʵ����ClientUserCarManage ����
	 * clientUserCarActiveMark ��������String,���ݿ�����varchar ����7 ����״ֵ̬ enable
	 * ��ʾ�ó����û�����Ϊ��Ծ״̬ disable ��ʾ�ó����û���ϣ��ʹ�� ���ݿ����Զ���ʼ��Ϊdisable ��ʼ��ʱ���û����',
	 * 
	 */
	public String clientUserCarActiveMark;
	/**
	 * 'car_no_setting_time ���������û����ó���ʱ�� ���ݿ��client_user_car_manage
	 * ��Ӧʵ����ClientUserCarManage ���� carNoSettingTime ��������String,���ݿ�����varchar ����19
	 * Ĭ��Ϊ���û������䶯ʱ ϵͳ�Զ��Ӻ�̨��ȡʱ������ ��ʽYYYY-MM-DD hh:mm:ss ��-��-�� ʱʱ�������
	 * eg:1999-01-01 13:22:22',
	 * 
	 */
	public String carNoSettingTime;

	/**
	 * serialVersionUID:TODO(��һ�仰�������������ʾʲô).
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 2312241015784855030L;

}
