/**
 * Project Name:OnlineParking
 * File Name:StringUtils.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2016年1月13日下午4:06:52
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;

/**
 * ClassName:StringUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年1月13日 下午4:06:52 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class StringUtils {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/**
	 * 替换掉引号
	 * 
	 * @param str
	 * @return 替换掉引号的字符串
	 */
	public static String replaceQuotes(String str) {
		if (str == null)
			return "";
		return str.replaceAll("\'", "''");
	}

	/**
	 * 获取图片的完整路径，方法如下：设eventID ＝ 10241，则其路径为： mediaRoot/01/02/event10241/
	 * 即：01×100×100 + 02×100 = 10200，就是10241去掉个位和十位数的值。
	 * 
	 * @param eventID
	 */
	public static String genMediaPath(int recID) {
		long path1, path2;
		path1 = Math.round(recID / 10000);
		path2 = Math.round((recID - path1 * 10000) / 100);
		String dir1, dir2;
		if (path1 < 10) {
			dir1 = "0" + String.valueOf(path1);
		} else {
			dir1 = String.valueOf(path1);
		}
		if (path2 < 10) {
			dir2 = "0" + String.valueOf(path2);
		} else {
			dir2 = String.valueOf(path2);
			;
		}
		return dir1 + "/" + dir2 + "/Event" + recID;
	}

	/**
	 * 字符串MD5加密
	 * 
	 * @param origin
	 *            源字符串
	 * @return MD5加密后的大写字符串
	 */
	public static String MD5Encode(String origin) {
		String resultString = null;
		resultString = origin;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
		} catch (Exception ex) {

		}
		return resultString.toUpperCase();
	}

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 得到文件的后缀名
	 * 
	 * @param fileName
	 * @return 文件的后缀名
	 */
	public static String getFileExt(String fileName) {
		if (fileName != null) {
			int i = fileName.lastIndexOf('.');
			if (i != -1) {
				return fileName.substring(i + 1);
			}
		}
		return "";
	}

	/**
	 * 将值为null的字符串改为""
	 * 
	 * @param str
	 * @return 将 "null" 改为 "" 的字符串
	 */
	public static String nullToStr(String str) {
		if (str == null)
			return "";
		else
			return str;
	}

	/**
	 * 根据url获取页面内容转为字符串返回
	 * 
	 * @param strUrl
	 * @return 页面内容
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String getContent(String strUrl) throws UnsupportedEncodingException, IOException {
		URL url = new URL(strUrl);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		String s = "";
		StringBuffer sb = new StringBuffer("");
		while ((s = br.readLine()) != null) {
			sb.append(s + "\r\n");
		}
		br.close();
		return sb.toString();
	}

	/**
	 * 将字符串转为ASCII码，并使用分隔符隔开
	 * 
	 * @param str
	 * @param spliter
	 * @return
	 */
	public static String strToASCIIWithSpliter(String str, String spliter) {
		if (str == null) {
			return null;
		}
		char[] chars = str.toCharArray();
		String strCode = "";
		for (int i = 0; i < chars.length; i++) {// 输出结果
			if (i == 0) {
				strCode += "" + (int) chars[i];
			} else {
				strCode += spliter + (int) chars[i];
			}
		}
		return strCode;
	}

	/**
	 * 将使用分隔符转为ASCII码的字符串转为字符串
	 * 
	 * @param strCode
	 *            使用分隔符转为ASCII码的字符
	 * @param regex
	 *            分隔符正则表达式
	 * @return
	 */
	public static String ASCIIWithSpliterToStr(String strCode, String regex) {
		if (strCode == null) {
			return null;
		}
		String str = "";
		String[] ch = strCode.split(regex);
		for (int i = 0; i < ch.length; i++) {
			str += (char) Integer.parseInt(ch[i]);
		}
		return str;
	}

}
