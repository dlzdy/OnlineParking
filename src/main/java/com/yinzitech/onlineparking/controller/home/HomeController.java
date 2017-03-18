/**
 * Project Name:OnlineParking
 * File Name:HomeController.java
 * Package Name:com.yinzitech.onlineparking.controller.home
 * Date:2015年11月4日下午6:36:40
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.home;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinzitech.onlineparking.service.sys.SysImgService;

import net.sf.json.JSONObject;

/**
 * ClassName:HomeController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月4日 下午6:36:40 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class HomeController {
	@Autowired
	SysImgService sysImgService ;
	
	@RequestMapping(value="home/getUrl")
	@ResponseBody
	public String getUrl(){
		
		String result =  sysImgService.getSysImg() ;
		return result ;
	}
	

	/**
	 * downloadBannerPictures:主页点击二维码  下载客户端
	 * @author xumingyeu
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @since JDK 1.8u60
	 */
	    @RequestMapping("home/downloadOnlinePark")  
	    public void downLoadPath(HttpServletRequest request, HttpServletResponse response)  
	            throws Exception {  
	    	
	    	String flag = request.getParameter("flag") ;
	    	
	    	String s = sysImgService.getSysImg() ;
	    	JSONObject object = (JSONObject) JSONObject.fromObject(s).get("datas");
	    	
	    	//android的文件名 + 路径
	    	String fileName ="" ;//获取apk文件名称
	    	String path = "" ;//获取apk存放路径
	       
	    	switch (flag) {
				case "1":
					fileName = (String) object.get("sysImgAndroidName") ; 
		    		path = (String) object.get("sysImgAndroidPath") ;
					break;
	
				case "2":
					fileName = (String) object.get("sysImgIosName") ; 
		    		path = (String) object.get("sysImgIosPath") ;
					break;
			}
	    	
	    /*	if(flag.equals("1")){
	    		fileName = (String) object.get("sysImgAndroidName") ; 
	    		path = (String) object.get("sysImgAndroidPath") ;
	    	}else{
	    		fileName = (String) object.get("sysImgIosName") ; 
	    		path = (String) object.get("sysImgIosPath") ;
	    	}*/
	    	
	    	// 设置响应头，控制浏览器下载该文件
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
			// 读取要下载的文件，保存到文件输入流
			FileInputStream in = new FileInputStream(path+fileName);
			System.out.println(in);
			// 创建输出流
			OutputStream out = response.getOutputStream();
			// 创建缓冲区
			byte buffer[] = new byte[1024];
			int len = 0;
			// 循环将输入流中的内容读取到缓冲区当中
			while ((len = in.read(buffer)) > 0) {
				// 输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
			}
			// 关闭文件输入流
			in.close();
			// 关闭输出流
			out.close();

			return;
	    }
	
}

