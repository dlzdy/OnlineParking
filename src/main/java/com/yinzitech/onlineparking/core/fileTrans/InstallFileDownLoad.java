/**
 * Project Name:OnlineParking
 * File Name:InstallFileDownLoad.java
 * Package Name:com.yinzitech.onlineparking.core.fileTrans
 * Date:2015年10月15日上午4:18:38
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.core.fileTrans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:InstallFileDownLoad <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月15日 上午4:18:38 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public class InstallFileDownLoad extends HttpServlet {

	/**
	 * 
	 * Title: 空参构造方法<br/>
	 * Description:<br/>
	 */
	public InstallFileDownLoad() {
	}

	public void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = request.getParameter("filename");
		System.err.println(fileName);

		response.setContentType(getServletContext().getMimeType(fileName));
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

		String fullFileName = getServletContext().getRealPath("/download/" + fileName);

		InputStream in = new FileInputStream(fullFileName);
		OutputStream out = response.getOutputStream();
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
		}
		in.close();
		out.close();
	}

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 1902250152599196832L;

}
