/**
 * Project Name:OnlineParking
 * File Name:Math.java
 * Package Name:com.yinzitech.onlineparking.core.math
 * Date:2015年10月13日下午7:30:26
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.core.math;

import java.util.Random;

/**
 * ClassName:MathMethod <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午7:30:26 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class MathMethod {
	/* 短信验证码位数 */
	static int nuCount = 4;

	public static String radomVeriNu() {
		StringBuffer buf = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < nuCount; i++) {
			buf.append(random.nextInt(10));// 取三个随机数追加到StringBuffer
		}
		return buf.toString();
	}

	public static void RunTime(int time) {
		int i = 1;
		new Thread().start();
		while (i < time + 1) {
		//	System.out.println(i);
			try {
				Thread.sleep(1000);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (i >= time) {
			System.out.println("执行....");
		}
	}

	public static void main(String[] args) {
		RunTime(120);
	}
}
