package com.yinzitech.onlineparking.alipay.common;

public class AlipayConfig {

	public static String partner = "2088021873973583";

	public static String private_key = "ivcm7coc3anufz0ac82szbha04qkze4p";

	// 支付宝的公钥，无需修改该值
	public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8bo5JWW4E6j7UF9G6sYSP8Gi3q9VXP9A4DH+jusHddEe6EMrS6u8S5vEY6jvXuMBCngocqZhR3V6b4n6YlRQ1NGA0aq8dLtR5VcjvMf/NDq+jEwi1Fu/jYlk+GNn5JBskpuGpl/Mx3POXmC570d1fNQz2ss5PodlJf/Clvw/KUwIDAQAB";

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";
	
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 签名方式 不需修改
	public static String sign_type = "RSA";

}
