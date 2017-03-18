/**
 * Project Name:OnlineParking
 * File Name:messageDao.java
 * Package Name:com.yinzitech.onlineparking.dao.msg
 * Date:2015年10月19日下午5:42:40
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.dao.msg;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yinzitech.onlineparking.entity.msg.Message;

/**
 * ClassName:messageDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月19日 下午5:42:40 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface MessageDao {
	/**
	 * 
	 * creatmessage:(创建一条消息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgId
	 * @param msgName
	 * @param msgStatus
	 * @param msgBody
	 * @param msgTime
	 * @param msgUserId
	 * @param msgBodyImgUrl
	 * @return
	 * @since JDK 1.8u60
	 */
	@Insert("INSERT INTO message (msg_id, msg_name, msg_status, msg_body, msg_time, msg_user_id,msg_body_img_url) VALUES (#{msgId}, #{msgName}, #{msgStatus}, #{msgBody}, #{msgTime}, #{msgUserId},#{msgBodyImgUrl})")
	public int creatMessage(@Param("msgId") String msgId, @Param("msgName") String msgName,
			@Param("msgStatus") String msgStatus, @Param("msgBody") String msgBody, @Param("msgTime") String msgTime,
			@Param("msgUserId") String msgUserId, @Param("msgBodyImgUrl") String msgBodyImgUrl);

	/**
	 * 
	 * TODO(修改消息内容).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgId
	 * @param msgName
	 * @param msgBody
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE message SET msg_body= #{msgBody} WHERE  msg_name= #{msgName} AND msg_id = #{msgId} ")
	public int upMessageByBody(@Param("msgId") String msgId, @Param("msgName") String msgName,
			@Param("msgBody") String msgBody);

	/**
	 * 
	 * addmessageImg:(插入图片). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgBodyImgUrl
	 * @param msgName
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE message SET msg_body_img_url= #{msgBodyImgUrl} WHERE  msg_name= #{msgName} AND msg_id = #{msgId} ")
	public int addMessageImg(@Param("msgBodyImgUrl") String msgBodyImgUrl, @Param("msgName") String msgName,
			@Param("msgId") String msgId);

	/**
	 * 
	 * upmessagesSendInfo:(修改人更新). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgSendTime
	 * @param msgSendName
	 * @param msgId
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE message SET msg_send_time= #{msgSendTime}, msg_send_name= #{msgSendName} WHERE (msg_name= #{msgName})")
	public int upMessagesSendInfo(@Param("msgSendTime") String msgSendTime, @Param("msgSendName") String msgSendName,
			@Param("msgName") String msgName);

	/**
	 * 
	 * upmessagesStatus:(修改消息状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgStatus
	 *            0：创建消息<br/>
	 *            1：发送消息<br/>
	 *            2：消息已投送<br/>
	 * @param msgUserId
	 *            id用户。手持机id
	 * @return
	 * @since JDK 1.8u60
	 */
	@Update("UPDATE message SET msg_status= #{msgStatus} WHERE  msg_id= #{msgId} AND msg_user_id= #{msgUserId}")
	public int upMessagesStatus(@Param("msgStatus") String msgStatus, @Param("msgUserId") String msgUserId,
			@Param("msgId") String msgId);

	/**
	 * 
	 * selectMessageByMsgName:(查询消息名称). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgName
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select msg_name as msgName ," + "msg_id as msgId ,msg_status as msgStatus,"
			+ " msg_body as msgBody, msg_body_img_url as msgBodyImgUrl,"
			+ " msg_time msgTime,msg_send_time as msgSendTime,msg_send_name as msgSendName,"
			+ "msg_user_id as msgUserId  FROM message WHERE msg_name = #{msgName} ")
	public List<Message> selectMessageByMsgName(@Param("msgName") String msgName);

	/**
	 * 
	 * querymessageByUserIdWhereStatus:(查询用户 信息状态). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgUserId
	 * @param msgStatus
	 * 
	 *            0：创建消息<br/>
	 *            1：发送消息<br/>
	 *            2：消息已投送<br/>
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select msg_name as msgName ," + "msg_id as msgId ,msg_status as msgStatus,"
			+ " msg_body as msgBody, msg_body_img_url as msgBodyImgUrl,"
			+ " msg_time msgTime,msg_send_time as msgSendTime,msg_send_name as msgSendName,"
			+ "msg_user_id as msgUserId  FROM message WHERE msg_user_id= #{msgUserId} AND msg_status= #{msgStatus}")
	public List<Message> queryMessageByUserIdWhereStatus(@Param("msgUserId") String msgUserId,
			@Param("msgStatus") String msgStatus);

	/**
	 * 
	 * selectHistory:(查询历史消息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	@Select("select msg_name as msgName ," + "msg_id as msgId ,msg_status as msgStatus,"
			+ " msg_body as msgBody, msg_body_img_url as msgBodyImgUrl,"
			+ " msg_time msgTime,msg_send_time as msgSendTime,msg_send_name as msgSendName,"
			+ "msg_user_id as msgUserId from message  GROUP BY msg_name  ")
	public List<Message> selectHistory();

}
