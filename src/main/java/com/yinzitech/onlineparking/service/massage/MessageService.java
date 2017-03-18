/**
 * Project Name:OnlineParking
 * File Name:MassageService.java
 * Package Name:com.yinzitech.onlineparking.service.massage
 * Date:2015年10月19日下午7:05:14
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.service.massage;

/**
 * ClassName:MassageService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年10月19日 下午7:05:14 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public interface MessageService {
	/**
	 * 
	 * creatMassage:(创建一条消息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgName
	 * @param msgBody
	 * @param msgBodyImgUrl
	 *            可为空
	 * @return
	 * @since JDK 1.8u60
	 */
	public String creatMessage(String msgName, String msgBody, String msgBodyImgUrl);

	/**
	 * 
	 * addMassageImg:(插入图片). <br/>
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
	public String addMessageImg(String msgBodyImgUrl, String msgName, String msgSendName);

	/**
	 * 
	 * sendMessages:(确认发送消息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgName
	 * @param msgSendName
	 * @return
	 * @since JDK 1.8u60
	 */
	public String sendMessages(String msgName, String msgSendName);

	/**
	 * 
	 * queryMassageByUserIdWhereStatus:(查询用户 信息状态). <br/>
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
	public String queryMessageByUserIdWhereStatus(String msgUserId, String msgStatus, String clientUserSecurity);

	/**
	 * 
	 * SelectHistoryMessage:(历史消息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectHistoryMessage();

	/**
	 * 
	 * upMessageByBody:(修改消息内容). <br/>
	 * TODO(消息尚未发送时可做修改操作 – 可选).<br/>
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
	public String upMessageByBody(String msgId, String msgName, String msgBody, String msgSendName);

	/**
	 * 
	 * selectHistoryMessageLimit:(历史消息分页). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @since JDK 1.8u60
	 */
	public String selectHistoryMessageLimit(int pageNumber, int pageSize);

	/**
	 * 
	 * countMessage:(统计信息). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	public String countMessage(String userId);

	/**
	 * 
	 * queryMessage:(消息条件检索). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param msgId
	 * @param msgStatus
	 * @param startTime
	 * @param endTime
	 * @return
	 * @since JDK 1.8u60
	 */
	public String queryMessage(String msgStatus, String startTime, String endTime, int pageNumber, int pageSize);

}
