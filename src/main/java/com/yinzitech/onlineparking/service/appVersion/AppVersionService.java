/**
 * Project Name:OnlineParking
 * File Name:AppVersionService.java
 * Package Name:com.yinzitech.onlineparking.service.appVersion
 * Date:2016年7月4日上午11:37:49
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.appVersion;

import com.yinzitech.onlineparking.entity.appVersion.AppVersion;

/**
 * ClassName:AppVersionService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年7月4日 上午11:37:49 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface AppVersionService {
	/**
	 * 
	 * addAppVersion:(新增app版本). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param appVersion
	 * @return
	 * @since JDK 1.8u60
	 */
	public String addAppVersion(AppVersion appVersion);

	/**
	 * 
	 * getAppVersion:(获取app版本内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getAppVersion();

	/**
	 * 
	 * getAppVersionList:(获取app版本内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String getAppVersionList(String id ,String appType);

	/**
	 * 
	 * upAppVersion:(更新app版本内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upAppVersion(AppVersion appVersion);

}
