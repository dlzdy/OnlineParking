/**
 * Project Name:OnlineParking
 * File Name:ResultMap.java
 * Package Name:com.yinzitech.onlineparking.entity.common
 * Date:2015年12月17日下午1:46:48
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.entity.common;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * ClassName:ResultMap <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年12月17日 下午1:46:48 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class ResultMap {

	public static String obj2JsonResult(String result, String info, Map<String, String> datas) {
		String resultJson = "";
		ResultMap rr = new ResultMap();
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
		return "ResultMap [result=" + result + ", info=" + info + ", datas=" + datas + "]";
	}

	/**
	 * 
	 * Title: 无参构造函数<br/>
	 * Description:<br/>
	 */
	public ResultMap() {
		super();
	}

	/**
	 * 
	 * Title: 有参构造函数<br/>
	 * Description:<br/>
	 * 
	 * @param result
	 * @param info
	 * @param datas
	 */

	public ResultMap(String result, String info, Map<String, String> datas) {
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

	public Map<String, String> getDatas() {
		return datas;
	}

	public void setDatas(Map<String, String> datas) {
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
	private Map<String, String> datas;
}
