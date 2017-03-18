/**
 * Project Name:OnlineParking
 * File Name:SystemManagerService.java
 * Package Name:com.yinzitech.onlineparking.service.sys
 * Date:2015年10月13日下午2:41:19
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.sys;

/**
 * ClassName:SystemManagerService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午2:41:19 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface SystemManagerService {

	/**
	 * 
	 * creatSysteManager:(注册管理员帐号). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerId
	 * @param systemManagerUsername
	 * @param systemManagerPsd
	 * @param systemManagerCreateTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String creatSysteManager(String systemManagerUsername, String systemManagerPsd);

	/**
	 * 
	 * selectAllManagerUser:(查询全部用户). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectAllManagerUser(int pageNum,int pageSize);

	/**
	 * 
	 * selectManagerUserByName:(查询用户信息(可用于登录判定)). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerUsername
	 * @param systemManagerPsd
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectManagerUserByName(String systemManagerUsername, String systemManagerPsd);

	/**
	 * 
	 * upLastTimeLogin:(修改用户最后登录时间). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerLastLoginTime
	 * @param systemManagerUsername
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upLastTimeLogin(String systemManagerLastLoginTime, String systemManagerUsername);

	/**
	 * 
	 * upManagerUserPsd:(修改密码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerPsd
	 * @param systemManagerUsername
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upManagerUserPsd(String systemManagerPsd, String systemManagerUsername);

	/**
	 * 
	 * upUserInfo:(更新用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerPhone
	 * @param systemManagerEmail
	 * @param systemManagerState
	 * @param systemManagerUsername
	 * @return
	 * @since JDK 1.8u60
	 */
	public String upUserInfo(String systemManagerPhone, String systemManagerEmail, String systemManagerState,
			String systemManagerUsername);

	/**
	 * 
	 * deleteManagerUser:(通过用户id删除用户信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param systemManagerUsername
	 * @return
	 * @since JDK 1.8u60
	 */
	public String deleteManagerUser(String systemManagerId);
 

}
