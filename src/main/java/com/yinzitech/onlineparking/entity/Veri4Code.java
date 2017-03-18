/**
 * Project Name:OnlineParking
 * File Name:Veri4Code.java
 * Package Name:com.yinzitech.onlineparking.core.math.veri
 * Date:2015年10月13日下午9:22:03
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity;

/**
 * ClassName:Veri4Code <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午9:22:03 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class Veri4Code {

	public Veri4Code() {
		super();
	}

	public Veri4Code(String codeId, String codeNu, String codeTime) {
		super();
		this.codeId = codeId;
		this.codeNu = codeNu;
		this.codeTime = codeTime;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeNu() {
		return codeNu;
	}

	public void setCodeNu(String codeNu) {
		this.codeNu = codeNu;
	}

	public String getCodeTime() {
		return codeTime;
	}

	public void setCodeTime(String codeTime) {
		this.codeTime = codeTime;
	}

	private String codeId;
	private String codeNu;
	private String codeTime;
}
