/**
 * Project Name:OnlineParking
 * File Name:ResultObjectList.java
 * Package Name:com.yinzitech.onlineparking.entity.common
 * Date:2015年10月4日下午12:03:20
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.common;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * ClassName:ResultObjectList <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 下午12:03:20 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class ResultObjectList {

	public static String obj2JsonResult(String result, String info, List<?> datas) {

		String resultJson = "";
		ResultObjectList rr = new ResultObjectList();
		rr.setResult(result);
		if (null != info && "" != info) {
			rr.setInfo(info);
		} else {
			return null;
		}
		rr.setDatas(datas);
		ObjectMapper mapper = new ObjectMapper();
		try {
			resultJson = mapper.writeValueAsString(rr);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return resultJson;

	}

	@Override
	public String toString() {
		return "ResultObjectList [result=" + result + ", info=" + info + ", datas=" + datas + "]";
	}

	public ResultObjectList() {
		super();
	}

	public ResultObjectList(String result, String info, List<?> datas) {
		super();
		this.result = result;
		this.info = info;
		this.datas = datas;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<?> getDatas() {
		return datas;
	}

	public void setDatas(List<?> datas) {
		this.datas = datas;
	}

	/**
	 * result<br/>
	 * 结果<br/>
	 * 取值<br/>
	 * 0 表示失败<br/>
	 * 1 表示成功 <br/>
	 */
	private String result;

	/**
	 * info<br/>
	 * 交互反馈信息<br/>
	 */
	private String info;

	/**
	 * datas<br/>
	 * 交互返回数据
	 */
	private List<?> datas;

}
