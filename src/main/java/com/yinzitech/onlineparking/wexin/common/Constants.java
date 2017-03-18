package com.yinzitech.onlineparking.wexin.common;

public class Constants {

	/** 微信支付功能 **/

	/**
	 * 商户号
	 */
	// public static final String MCH_ID = "1292051201";// 测试环境
	public static final String MCH_ID = "1292050601";// 生产环境

	/**
	 * appi
	 */
	// public static final String APP_ID = "wx1c7082bc346ce415";// 测试环境
	public static final String APP_ID = "wx1b161f44307ebb59";// 生产环境
	/**
	 * key
	 */
	// public static final String KEY = "ZDxR53wfH2I8IqMLkIwSgo74KbFGUBHs";//
	// 测试环境
	public static final String KEY = "CJMcczC3M9FyXjcSF4ojtSuYm0gAGnx7";// 生产环境

	/**
	 * app_secret
	 */
	public static final String APP_SECRET = "d4624c36b6795d1d99dcf0547af5443d";

	/**
	 * 支付完成后的回调处理页面 配置见config配置文件
	 */
	public static String NOTIFY_URL = "http://[ip]:[port]/project/weixin/payNotify";

	// 统一下单
	public static String PAY_UNFIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	// 查询API
	public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

	// 关闭订单
	public static String PAY_CLOSE_API = "https://api.mch.weixin.qq.com/pay/closeorder";

}
