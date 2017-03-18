/**
 * Project Name:OnlineParking
 * File Name:Veri4CodeDao.java
 * Package Name:com.yinzitech.onlineparking.core.math.veri
 * Date:2015年10月13日下午9:24:21
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yinzitech.onlineparking.entity.Veri4Code;

/**
 * ClassName:Veri4CodeDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月13日 下午9:24:21 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8
 * @see
 */
public interface Veri4CodeDao {
	/**
	 * 
	 * insert:(新增验证码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param codeId
	 *            验证id
	 * @param codeNu
	 *            验证码
	 * @param codeTime
	 *            验证码生成时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO veri4Code (codeId,codeNu,codeTime) VALUES (#{codeId},#{codeNu},#{codeTime})")
	public int insert(@Param("codeId") String codeId, @Param("codeNu") String codeNu,
			@Param("codeTime") String codeTime);

	/**
	 * 
	 * delete:(通过制定时间删除之前所有验证码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param codeTime
	 *            指定时间
	 * @return
	 * @since JDK 1.8u60
	 */
	@Delete("DELETE FROM veri4Code WHERE codeTime < #{codeTime}")
	public int delete(@Param("codeTime") String codeTime);

	/**
	 * 
	 * query:(查询验证码). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param codeId
	 *            验证码id
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("SELECT codeId,codeNu,codeTime FROM  veri4Code WHERE codeId = #{codeId}")
	public Veri4Code query(@Param("codeId") String codeId);
}
