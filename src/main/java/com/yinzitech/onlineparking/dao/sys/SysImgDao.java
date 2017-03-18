/**
 * Project Name:OnlineParking
 * File Name:SysImgDao.java
 * Package Name:com.yinzitech.onlineparking.dao.sys
 * Date:2015年10月13日上午11:13:32
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.sys;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.sys.SysImg;

/**
 * ClassName:SysImgDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 上午11:13:32 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface SysImgDao {
	/**
	 * 
	 * upMainImg:(更新系统主页图片). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param sysImgUpUserName
	 * @param sysImgUpTime
	 * @param sysImgMainName
	 * @param sysImgMainPath
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE sys_img SET sys_img_up_userName= #{sysImgUpUserName}, sys_img_up_time= #{sysImgUpTime}, sys_img_main_name= #{sysImgMainName}, sys_img_main_path= #{sysImgMainPath} WHERE (sys_img_id='1')")
	public int upMainImg(@Param("sysImgUpUserName") String sysImgUpUserName, @Param("sysImgUpTime") String sysImgUpTime,
			@Param("sysImgMainName") String sysImgMainName, @Param("sysImgMainPath") String sysImgMainPath);

	/**
	 * 
	 * upIosImg:(更新ios二维码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param sysImgUpUserName
	 * @param sysImgUpTime
	 * @param sysImgIosName
	 * @param sysImgIosPath
	 * @param sysImgIosUrl
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE sys_img SET sys_img_up_userName= #{sysImgUpUserName}, sys_img_up_time= #{sysImgUpTime}, sys_img_ios_name= #{sysImgIosName}, sys_img_ios_path= #{sysImgIosPath}, sys_img_ios_url= #{sysImgIosUrl} WHERE (sys_img_id='1')")
	public int upIosImg(@Param("sysImgUpUserName") String sysImgUpUserName, @Param("sysImgUpTime") String sysImgUpTime,
			@Param("sysImgIosName") String sysImgIosName, @Param("sysImgIosPath") String sysImgIosPath,
			@Param("sysImgIosUrl") String sysImgIosUrl);

	/**
	 * 
	 * upAndroidImg:(更新Android二维码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param sysImgUpUserName
	 * @param sysImgUpTime
	 * @param sysImgAndroidName
	 * @param sysImgAndroidPath
	 * @param sysImgAndroidUrl
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE sys_img SET sys_img_up_userName= #{sysImgUpUserName}, sys_img_up_time= #{sysImgUpTime}, sys_img_android_name= #{sysImgAndroidName}, sys_img_android_path= #{sysImgAndroidPath}, sys_img_android_url= #{sysImgAndroidUrl} WHERE (sys_img_id='1')")
	public int upAndroidImg(@Param("sysImgUpUserName") String sysImgUpUserName, @Param("sysImgUpTime") String sysImgUpTime,
			@Param("sysImgAndroidName") String sysImgAndroidName, @Param("sysImgAndroidPath") String sysImgAndroidPath,
			@Param("sysImgAndroidUrl") String sysImgAndroidUrl);

	/**
	 * 
	 * upServerAddress:(更新服务器地址). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param sysImgUpUserName
	 * @param sysImgUpTime
	 * @param sysImgServerAddres
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE sys_img SET sys_img_up_userName= #{sysImgUpUserName}, sys_img_server_addres= #{sysImgServerAddres} WHERE (sys_img_id='1')")
	public int upServerAddress(@Param("sysImgUpUserName") String sysImgUpUserName,
			@Param("sysImgUpTime") String sysImgUpTime, @Param("sysImgServerAddres") String sysImgServerAddres);

	/**
	 * 
	 * getSysImg:(查询主页图片地址). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param sysImgId
	 * @param sysImgUpUserName
	 * @param sysImgUpTime
	 * @param sysImgCreatTime
	 * @param sysImgMainName
	 * @param sysImgMainPath
	 * @param sysImgIosName
	 * @param sysImgIosPath
	 * @param sysImgIosUrl
	 * @param sysImgAndroidName
	 * @param sysImgAndroidPath
	 * @param sysImgAndroidUrl
	 * @param sysImgServerAddres
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT sys_img_id as sysImgId,sys_img_up_userName as sysImgUpUserName,"
			+ "sys_img_up_time as sysImgUpTime,sys_img_creat_time as sysImgCreatTime,"
			+ " sys_img_main_name as sysImgMainName,sys_img_main_path as sysImgMainPath,"
			+ " sys_img_ios_name as sysImgIosName,sys_img_ios_path as sysImgIosPath, "
			+ "sys_img_ios_url as sysImgIosUrl,sys_img_android_name as sysImgAndroidName,"
			+ " sys_img_android_path as sysImgAndroidPath,sys_img_android_url as sysImgAndroidUrl,"
			+ " sys_img_server_addres as sysImgServerAddres"
			+ " FROM sys_img")
	public SysImg getSysImg();
}
