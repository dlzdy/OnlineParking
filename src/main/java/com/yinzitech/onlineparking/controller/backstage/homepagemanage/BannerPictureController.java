/**
 * Project Name:OnlineParking
 * File Name:ProductHomePageController.java
 * Package Name:com.yinzitech.onlineparking.controller.backstage.homepagemanage
 * Date:2015年10月13日上午10:56:58
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.backstage.homepagemanage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.yinzitech.onlineparking.alipay.utils.UtilDate;
import com.yinzitech.onlineparking.entity.appVersion.AppVersion;
import com.yinzitech.onlineparking.service.appVersion.AppVersionService;
import com.yinzitech.onlineparking.service.sys.SysImgService;
import com.yinzitech.onlineparking.utils.MatrixToImageWriter;

import net.sf.json.JSONObject;

/**
 * ClassName:ProductHomePageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月13日 上午10:56:58 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class BannerPictureController{

	
	@Autowired
	SysImgService sysImgService ;
	
	@Autowired
	AppVersionService appVersionService ;
	/**
	 * toChangeBannerPicture:跳转到banner图片列表界面
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toChangeBannerPicture")
	public ModelAndView toChangeBannerPicture(){
		String result = sysImgService.getSysImg() ;
		String versionInfo = appVersionService.getAppVersionList("", "") ;
		System.err.println("versionInfo:"+versionInfo);
		System.err.println(result);
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/producthomepage/upload_pictures");
		mv.addObject("imgInfo", result) ;
		mv.addObject("versionInfo",versionInfo);
		return mv ;
	}
	
	/**
	 * 
	 * toUpdateAndroidApk:(这里用一句话描述这个方法的作用). <br/>
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toUpdateAndroidApk")
	public ModelAndView toUpdateAndroidApk(){
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/producthomepage/update_android_apk");
		return mv ;
	}
	
	/**
	 * 
	 * toUpdateIosApk:
	 *
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/toUpdateIosApk")
	public ModelAndView toUpdateIosApk(){
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parkingbackstage/producthomepage/update_ios_url");
		return mv ;
	}
	
	
	/**
	 * upBannerPic:上传产品主页背景图片
	 * @author xumingyue
	 * @return
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/upBannerPic",method=RequestMethod.POST)
	@ResponseBody
	public String upBannerPic(
			@RequestParam MultipartFile bannerFileName,
			@RequestParam String username,
			HttpServletRequest request){
		System.err.println("*****************userName:"+username);
		/* String newFileName ="";*/
		 String saveFilePath = "" ;
		 String oldFileName ="" ;
		 //获取系统时间
		 Date date=new Date();
		 DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String sysImgUpTime=format.format(date); 
		 // 判断文件是否为空  
        if (!bannerFileName.isEmpty()) {  
         
        	saveFilePath = request.getSession().getServletContext().getRealPath("/") + "download" + File.separator; 
        	oldFileName = bannerFileName.getOriginalFilename() ;
        	System.err.println("文件上传路径："+saveFilePath);
        	/* 构建文件目录 */
	        File fileDir = new File(saveFilePath);
	        if (!fileDir.exists()) {
	            fileDir.mkdirs();
	        }
	    /*    newFileName = new Date().getTime()+ oldFileName ;*/
	        try {
	            FileOutputStream out = new FileOutputStream(saveFilePath + oldFileName);
	            // 写入文件
	            out.write(bannerFileName.getBytes());
	            out.flush();
	            out.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
        }  
		
		String result = sysImgService.upMainImg(username, sysImgUpTime, oldFileName, saveFilePath) ;
		JSONObject o = JSONObject.fromObject(result) ;
		String msg = "" ;
		String mainName = "" ;
		String info = "" ; //返回界面的信息
		if(o.get("result").equals("1")){
			msg = "success" ;
			String msgInfo = sysImgService.getSysImg() ;
			System.err.println("msgInfo:"+msgInfo);
			JSONObject obj = JSONObject.fromObject(msgInfo) ;
			JSONObject datas = (JSONObject) obj.get("datas") ;
			mainName = (String) datas.get("sysImgMainName") ; //获取图片名字
			System.err.println("mainName:"+mainName);
		}else{
			msg = "error" ;
		}
		info = "{\"result\":\""+msg+"\",\"mainName\":\""+mainName+"\"}" ;
		System.err.println("result:"+result+";username:"+username+";sysImgUpTime:"+sysImgUpTime+";oldFileName:"+oldFileName+";saveFilePath:"+saveFilePath);
		return info;
	}
	

	/**
	 * upAndroidApk:上传android apk
	 * @author xumingyue
	 * @return
	 * @throws WriterException 
	 * @throws IOException 
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/upAndroidApk",method=RequestMethod.POST)
	@ResponseBody
	public String upAndroidApk(
			@RequestParam(required = false) MultipartFile androidFileName,
			HttpServletRequest request) throws WriterException, IOException{
		String username = request.getParameter("username") ;
		String versionCode = request.getParameter("versionCode") ;
		String versionName = request.getParameter("versionName") ;
		String content = request.getParameter("content") ;
		String versionNameID = UtilDate.getOrderNum() ;
		String oldFileName = "" ;
		 String saveFilePath = "" ;
		 //获取系统时间
		 Date date=new Date();
		 DateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String sysImgUpTime=f.format(date); 
		 // 判断文件是否为空  
        if (!androidFileName.isEmpty()) {  
         
        	saveFilePath = request.getSession().getServletContext().getRealPath("/") + "download" + File.separator; 
        	 oldFileName = androidFileName.getOriginalFilename() ;
        	System.err.println("文件上传路径："+saveFilePath);
        	/* 构建文件目录 */
	        File fileDir = new File(saveFilePath);
	        if (!fileDir.exists()) {
	            fileDir.mkdirs();
	        }
	       // newFileName = new Date().getTime()+ oldFileName ;
	        try {
	            FileOutputStream out = new FileOutputStream(saveFilePath + oldFileName);
	            // 写入文件
	            out.write(androidFileName.getBytes());
	            out.flush();
	            out.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
        }  
        
        // apk 上传路径生成二维码
     		String saveGifPath = request.getServletContext().getRealPath("/home/images/");
     		String remoteAddr = request.getServerName().toString() ;
     		 int port = request.getServerPort() ;
     		System.err.println("remoteAddr:"+ remoteAddr+";port:"+ port);
     		//下载路径
     		String text = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/download/"+oldFileName;
     		System.err.println("text:"+text);
     		int width = 600;
     		int height = 600;
     		// 二维码的图片格式
     		String format = "png";
     		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
     		// 内容所使用编码
     		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
     		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
     		// 生成二维码
     		File outputFile = new File(saveGifPath + File.separator + "android.png");
     		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
     		
     	AppVersion  appVersion = new AppVersion( versionNameID, "OnlineParking", versionCode, versionName, text, "", content, sysImgUpTime, "", "1") ;//appType: 1/android 0/IOS
    	String addVersionResult = appVersionService.addAppVersion(appVersion) ;
    	System.err.println("addVersionResult:"+addVersionResult); 
    	
    	String msg = "error" ;
    	String info = "" ; //返回界面的信息
    	JSONObject vObject = JSONObject.fromObject(addVersionResult) ;
    	if(vObject.get("result").equals("1")){
    		String result = sysImgService.upAndroidImg(username, sysImgUpTime, oldFileName, saveFilePath, saveFilePath+oldFileName) ; //上传文件
    		JSONObject o = JSONObject.fromObject(result) ;
    		if(o.get("result").equals("1")){
    			msg = "success" ;
    		}else{
    			msg = "error" ;
    		}
    	}
    	info = "{\"result\":\""+msg+"\"}" ;
    	return info ;
		
		
	/*	String sysImgAndroidName = "" ;
		String info = "" ; //返回界面的信息
		if(o.get("result").equals("1")){
			msg = "success" ;
			String msgInfo = sysImgService.getSysImg() ;
			System.err.println("msgInfo:"+msgInfo);
			JSONObject obj = JSONObject.fromObject(msgInfo) ;
			JSONObject datas = (JSONObject) obj.get("datas") ;
			sysImgAndroidName = (String) datas.get("sysImgAndroidName") ; //获取图片名字
			System.err.println("sysImgAndroidName:"+sysImgAndroidName);
		}else{
			msg = "error" ;
		}
		info = "{\"result\":\""+msg+"\",\"sysImgAndroidName\":\""+sysImgAndroidName+"\"}" ;
		*/
	}
	
	/**
	 * upBannerPic:上传IOS图片
	 * @author xumingyue
	 * @return
	 * @throws WriterException 
	 * @throws IOException 
	 * @since JDK 1.8u60
	 */
	@RequestMapping(value="/upIosPic",method=RequestMethod.POST)
	@ResponseBody
	public String upIosPic(
			@RequestBody Map<String,String> map,
			HttpServletRequest request) throws WriterException, IOException{
		
		String username = map.get("username") ;
		String versionCode = map.get("versionCode") ;
		String versionName = map.get("version") ;
		String content = map.get("content") ;
		String iosUrl = map.get("iosSrc") ;
		String oldFileName = "" ;
		 //获取系统时间
		 Date date=new Date();
		 DateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String sysImgUpTime=f.format(date); 
        // apk 上传路径生成二维码
 		String saveGifPath = request.getServletContext().getRealPath("/home/images/");
 		String remoteAddr = request.getServerName().toString() ;
 		 int port = request.getServerPort() ;
 		String iosEWMUrl =  request.getScheme()+"://"+remoteAddr+":"+port+request.getContextPath()+"/home/images/ios.png"; //二维码路径
 		System.err.println("remoteAddr:"+ remoteAddr+";port:"+ port);
 		//下载路径
 		String text = iosUrl;
 		System.err.println("text:"+text);
 		int width = 600;
 		int height = 600;
 		// 二维码的图片格式
 		String format = "png";
 		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
 		// 内容所使用编码
 		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
 		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
 		// 生成二维码
 		File outputFile = new File(saveGifPath + File.separator + "ios.png");
 		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
 		System.out.println(outputFile);
        
		String result = sysImgService.upIosImg(username, sysImgUpTime, oldFileName, text, iosEWMUrl) ;
		String versionNameID = UtilDate.getOrderNum() ;
		AppVersion  appVersion = new AppVersion( versionNameID, "", versionCode, versionName, text, "", content, sysImgUpTime, "", "0") ;//appType: 1/android 0/IOS
		System.err.println("appVersion:"+appVersion+";versionNameID:"+versionNameID);
	    appVersionService.addAppVersion(appVersion) ;
	    return result;
	}

}



