/**
 * Project Name:OnlineParking
 * File Name:SpringApplicationContext.java
 * Package Name:com.yinzitech.onlineparking.core.context.springCore
 * Date:2015年10月4日上午6:28:48
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.core.context.springCore;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ClassName:SpringApplicationContext <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月4日 上午6:28:48 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class SpringApplicationContext implements ApplicationContextAware {
	private static ApplicationContext appCtx;

	/**
	 * 此方法可以把ApplicationContext对象inject到当前类中作为一个静态成员变量。
	 * 
	 * @param applicationContext
	 *            ApplicationContext 对象.
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext;
	}

	/**
	 * 这是一个便利的方法，帮助我们快速得到一个BEAN
	 * 
	 * @param beanName
	 *            bean的名字
	 * @return 返回一个bean对象
	 */
	public static Object getBean(String beanName) {
		return appCtx.getBean(beanName);
	}
}
