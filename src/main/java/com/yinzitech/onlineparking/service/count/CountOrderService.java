/**
 * Project Name:OnlineParking
 * File Name:CountOrderService.java
 * Package Name:com.yinzitech.onlineparking.service.count
 * Date:2015年11月11日上午11:22:04
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.count;

/**
 * ClassName:CountOrderService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月11日 上午11:22:04 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface CountOrderService {
	/**
	 * 
	 * getCountOrder:(统计订单信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param key
	 *            day,mouth,year
	 * @param payState
	 *            NoPaid 表示车辆未完成付款 Paid 表示车辆已经完成付款
	 * 
	 * @param payCash
	 *            是否现金支付 0为网结 1为现结
	 * @param parkingInfoId
	 *            停车场id
	 * @param numberState
	 *            0 该车辆不是Online停车平台在管车辆,只需要在手机端对车辆进行停车的计时就可以 1
	 *            该车辆为Onoline停车平台在管车辆
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */

	public String getCountOrder(String key, String payState, String payCash, String numberState, String parkingInfoId,
			String startTime, String endTime, int pageNumber, int pageSize);

}
