package com.yinzitech.onlineparking.wexin.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import com.yinzitech.onlineparking.wexin.common.Constants;
import com.yinzitech.onlineparking.wexin.common.XMLParser;
import com.yinzitech.onlineparking.wexin.model.ScanPayQueryReqData;
import com.yinzitech.onlineparking.wexin.model.UnifiedorderPayReqDate;

public class WeixinUtils {

	public static String getOut_trade_no() {
		String out_trade_no = String.format("NO%s%s", DateUtil.formatDate(new Date(), DateUtil.LOCATE_DATE_FORMAT),
				getRandomNumber(10));
		return out_trade_no;
	}

	public static String getRandomNumber(int n) {
		if (n <= 0)
			return null;
		String str = "";
		for (int i = 0; i < n; i++) {
			str += (int) (Math.random() * 10);
		}
		return str;
	}

	/**
	 * 统一下单
	 * 
	 * @param name
	 *            商品名称
	 * @param total_fee
	 *            价格（单位：分）
	 * @param ip
	 *            ip
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, String> payUnifiedorder(String name, int total_fee, String ip, String out_trade_no) {

		String time_start = DateUtil.formatDate(DateUtil.addSecond(new Date(), 0), DateUtil.LOCATE_DATE_FORMAT);
		String time_expire = DateUtil.formatDate(DateUtil.addSecond(new Date(), 3000), DateUtil.LOCATE_DATE_FORMAT);
		UnifiedorderPayReqDate unifiedorderPayReqDate = new UnifiedorderPayReqDate(Constants.APP_ID, Constants.MCH_ID,
				"", name, "", "", out_trade_no, "", total_fee, ip, time_start, time_expire, "", Constants.NOTIFY_URL,
				"APP", "", "");
		String postDataXML = unifiedorderPayReqDate.toXml();
		postDataXML = "\n" + postDataXML;
		try {
			String res = HttpUtils.postXml(Constants.PAY_UNFIFIEDORDER, postDataXML);
			Map<String, String> map = XMLParser.getMapFromXML(res);
			System.out.println(map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Map<String, String> payOrderquery(String out_trade_no) {
		ScanPayQueryReqData scanPayQueryReqData = new ScanPayQueryReqData(null, out_trade_no);
		String postDataXML = scanPayQueryReqData.toXml();
		postDataXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + postDataXML;
		try {
			String res = HttpUtils.postXml(Constants.PAY_QUERY_API, postDataXML);
			Map<String, String> map = XMLParser.getMapFromXML(res);
			System.out.println(map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Map<String, String> closeOrder(String out_trade_no) {
		ScanPayQueryReqData scanPayQueryReqData = new ScanPayQueryReqData(null, out_trade_no);
		String postDataXML = scanPayQueryReqData.toXml();
		postDataXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + postDataXML;
		try {
			String res = HttpUtils.postXml(Constants.PAY_CLOSE_API, postDataXML);
			Map<String, String> map = XMLParser.getMapFromXML(res);
			System.out.println(map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
