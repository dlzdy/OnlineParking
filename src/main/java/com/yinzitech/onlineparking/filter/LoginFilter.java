/**
 * Project Name:OnlineParking
 * File Name:LoginFilter.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.filter
 * Date:2015年11月30日上午10:14:25
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName:LoginFilter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月30日 上午10:14:25 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
public class LoginFilter  implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	 private static final String[] IGNORE_URI = {"/system","/onlineparking","/home","/app"};
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		 boolean flag = false;
		 String url = req.getRequestURL().toString(); //获取访问地址url
	       // System.err.println("**************"+url);
	        for (String s : IGNORE_URI) {
	            if (url.contains(s)) { //判断地址栏中的路径是否包含{"/system","/onlineparking","/home"}
	                flag = true;
	                break;
	            }
	        }
	       // System.err.println("flag:"+flag);
	        if (!flag) { //如果地址栏中的路径不包含{"/system","/onlineparking","/home"}，则进行session判断
	        	
	        	HttpSession session = req.getSession();
	        	if(url.contains("/index")){ //如果是停车后台http://localhost:8080/OnlineParking/index
	        		if (session.getAttribute("loginname") == null) {
		    			res.sendRedirect("/OnlineParking/onlineparking");
		    		}
		    		else {
		    			chain.doFilter(request, response);
		    		}
	        	}
	        	else if(url.contains("/toSystemLogin")){//如果是系统后台http://localhost:8080/OnlineParking/toSystemLogin
	        		if (session.getAttribute("systemManagerUsername") == null) {
		    			res.sendRedirect("/OnlineParking/system");
		    		}
		    		else {
		    			chain.doFilter(request, response);
		    		}
	        	}
	        	else{
	        		chain.doFilter(request, response);
	        	}
	    	
	        }else {
    			chain.doFilter(request, response);
    		}
		
	}


	public void destroy() {
		System.err.println("destroy()");
	}


}

