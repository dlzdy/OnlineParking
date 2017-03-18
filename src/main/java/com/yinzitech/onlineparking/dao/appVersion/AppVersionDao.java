/**
 * Project Name:OnlineParking
 * File Name:AppVersionDao.java
 * Package Name:com.yinzitech.onlineparking.appVersion
 * Date:2016年7月4日上午10:56:10
 * Copyright (c) 2016, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.appVersion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yinzitech.onlineparking.entity.appVersion.AppVersion;

/**
 * ClassName:AppVersionDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年7月4日 上午10:56:10 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface AppVersionDao {
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
	public int addAppVersion(AppVersion appVersion);

	/**
	 * 
	 * getAppVersion:(获取app版本内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param id
	 * @return
	 * @since JDK 1.8u60
	 */
	public List<AppVersion> getAppVersion(@Param("id") String id, @Param("appType") String appType);

	/**
	 * 
	 * upAppVersion:(更新app版本内容). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param appVersion
	 *            <br/>
	 *            appName，versionCode，versionName，apkUrl，changeLog，updateTips，id
	 * @return
	 * @since JDK 1.8u60
	 */
	public int upAppVersion(AppVersion appVersion);

}
