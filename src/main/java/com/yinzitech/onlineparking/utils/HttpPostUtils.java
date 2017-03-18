/**
 * Project Name:OnlineParking
 * File Name:HttpPostUtils.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2016年1月13日下午3:41:44
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/**
 * ClassName:HttpPostUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年1月13日 下午3:41:44 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
@SuppressWarnings("deprecation")
public class HttpPostUtils {
	private static String URL = "http://api.tongtongtingche.com.cn:8083/Interface/";

	public static String executeRequest(String queryURL, JSONObject jo) {
		String url = null;
		String param = jo.toString();
		String timestamp = TimeTools.getCurrentTime();
		System.out.println("---------------------------------------");
		System.out.println("请求接口：" + queryURL);
		String signStr = "param=" + param + "&timestamp=" + timestamp + "&key=2d093e38009989ac";
		System.out.println("签名字符串:" + signStr);

		try {
			String sign = StringUtils.MD5Encode(new String(signStr.getBytes(), "UTF-8"));
			System.out.println("sign:" + sign);
			url = URL + queryURL + "?param=" + URLEncoder.encode(param, "UTF-8") + "&timestamp="
					+ URLEncoder.encode(timestamp, "UTF-8") + "&sign=" + sign;
			System.out.println("请求地址：" + url);
			String res = getHttpContent(url);
			System.out.println("返回值：" + res);
			return res;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	private static HttpClient httpclient;

	/**
	 * 获取指定url的网页内容
	 * 
	 * @param url
	 * @return
	 */
	public static String getHttpContent(String url) {
		httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;

		try {
			response = httpclient.execute(httpget);
		} catch (ClientProtocolException e1) {

			e1.printStackTrace();

		} catch (IOException e1) {

			e1.printStackTrace();

		}

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			if (entity.getContentType().getValue().indexOf("application/json") != -1) {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), HTTP.UTF_8));
					String line = null;
					StringBuffer sb = new StringBuffer();
					while (null != (line = reader.readLine())) {
						sb.append(line);
					}
					return sb.toString();
				} catch (Exception e) {
				}
				return null;
			} else {
				long len = entity.getContentLength();
				if (len != -1 && len < 2048) {
					try {
						String content = EntityUtils.toString(entity);
						return content;
					} catch (ParseException e) {
					} catch (IOException e) {
					}
				} else {

				}
			}
		}
		return null;
	}

}
