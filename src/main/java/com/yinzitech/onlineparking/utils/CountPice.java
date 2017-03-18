/**
 * Project Name:OnlineParking
 * File Name:CountPice.java
 * Package Name:com.yinzitech.onlineparking.utils
 * Date:2015年10月6日下午11:57:17
 * Copyright (c) 2015,  ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.utils;

import java.text.DecimalFormat;
import java.util.List;

import com.yinzitech.onlineparking.entity.parkingInfo.ChargingStandards;

/**
 * ClassName:CountPice <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月6日 下午11:57:17 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class CountPice {
	public static double getPice(final List<ChargingStandards> list, long time) {
		Double cost = (double) 0;
		SortListObject.sortList(list, "chargingStandardsStep", "ASC");
		int number = 0;
		for (ChargingStandards chargingStandards : list) {
			String prise = chargingStandards.getChargingStandardsPrise();
			number++;
			long l = (Long.valueOf(chargingStandards.getChargingStandardsStepEnd()).longValue()
					- Long.valueOf(chargingStandards.getChargingStandardsStepStart()).longValue()) * 60;
			if (l % time > 0 & time > l) {

				cost = cost + Double.valueOf(prise);
				System.out.println(prise);
				System.out.println(cost);
				time = time - l;
				if (list.size() == number) {
					double j = Math.ceil(time / (double) l);
					if (cost > 0) {
						System.out.println(Double.valueOf(prise) * new Double(j));
						cost = cost + (Double.valueOf(prise) * new Double(j));
					}
				}
 
			} else {
				cost = cost + (Double.valueOf(prise));
				break;
			}
		}
		DecimalFormat df = new DecimalFormat("#.00");
		String w = df.format(cost);
		System.out.println("价格 ：" + w);

		return Double.valueOf(w);
	}
}
