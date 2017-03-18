/**
 * Project Name:OnlineParking
 * File Name:Test.java
 * Package Name:com.yinzitech.onlineparking.controller
 * Date:2015年11月2日上午10:20:00
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.yinzitech.onlineparking.alipay.utils.AlipayNotify;
import com.yinzitech.onlineparking.dao.client.QueryClientUserDao;
import com.yinzitech.onlineparking.dao.order.ChargingOrderDao;
import com.yinzitech.onlineparking.entity.client.user.ClientUser;
import com.yinzitech.onlineparking.entity.order.ChargingOrder;
import com.yinzitech.onlineparking.service.client.ClientUserService;
import com.yinzitech.onlineparking.service.client.carManage.ClinetUserCarManageService;
import com.yinzitech.onlineparking.service.count.CountOrderService;
import com.yinzitech.onlineparking.service.fundAccountManage.FundAccountManageService;
import com.yinzitech.onlineparking.service.fundAccountManage.SubFundAccountSeqService;
import com.yinzitech.onlineparking.service.handsetSys.HandsetSysService;
import com.yinzitech.onlineparking.service.massage.MessageService;
import com.yinzitech.onlineparking.service.order.ChargingOrderService;
import com.yinzitech.onlineparking.service.order.ParkingOrderService;
import com.yinzitech.onlineparking.service.order.TradingOrdersService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.sys.ParkingCountService;
import com.yinzitech.onlineparking.service.sys.SysImgService;
import com.yinzitech.onlineparking.service.sys.ToolsService;
import com.yinzitech.onlineparking.utils.MatrixToImageWriter;
import com.yinzitech.onlineparking.utils.TimeTools;

import net.sf.json.JSONObject;

/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月2日 上午10:20:00 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
@Controller
public class Test {
	@Autowired
	SysImgService ss;
	@Autowired
	HandsetSysService hs;
	@Autowired
	FundAccountManageService fam;
	@Autowired
	ParkingInfoService pf;
	@Autowired
	ClientUserService cu;
	@Autowired
	ClinetUserCarManageService cuc;
	@Autowired
	CountOrderService cos;
	@Autowired
	SubFundAccountSeqService sfs;
	@Autowired
	MessageService ms;
	@Autowired
	ChargingOrderService co;
	@Autowired
	ParkingOrderService pos;
	@Autowired
	TradingOrdersService toc;
	@Autowired
	ParkingCountService pcs;
	@Autowired
	ToolsService ts;
	@Autowired
	ClientUserService cus;
	@Autowired
	ParkingOrderService po;
	@Autowired
	ChargingOrderDao chargingOrderDao;
	@Autowired
	QueryClientUserDao qUser;
	
	 
	
	

	@RequestMapping("mess")
	@ResponseBody
	public String mess() {
		// po.selectParkingOrderParkId("2300cda8a92f4b869dc025a6fba7121c", "",
		// "", "");
		po.enter("京DDDDDD", "2300cda8a92f4b869dc025a6fba7121c");

		return null;
	}

	@RequestMapping("exit")
	@ResponseBody
	public String exit() {
		po.exit("京DDDDDD", "2300cda8a92f4b869dc025a6fba7121c");
		return null;
	}

	@RequestMapping("getNo")
	@ResponseBody
	public String getNo(ServletRequest request) throws UnsupportedEncodingException {

		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();

		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
			System.out.println(name);
		}
		System.out.println(params.size());
		if (params.size() > 0) {
			// 商户订单号
			String outTradeNo = request.getParameter("out_trade_no");
			// 交易状态
			String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
			// 交易金额
			String totalFee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"), "UTF-8");
			// 支付宝买家账号
			String buyerId = new String(request.getParameter("buyer_id").getBytes("ISO-8859-1"), "UTF-8");

			if (AlipayNotify.verify(params)) {

				if (tradeStatus.equals("TRADE_FINISHED")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序
					System.out.println("TRADE_FINISHED");
					co.upType(outTradeNo, tradeStatus);
				} else if (tradeStatus.equals("TRADE_SUCCESS")) {
					// 验证成功
					System.out.println("订单号：" + outTradeNo);
					System.out.println("交易状态:" + tradeStatus);
					System.out.println("交易金额:" + totalFee);
					System.out.println("支付宝买家账号:" + buyerId);
					System.out.println(params.toString());
					co.upType(outTradeNo, tradeStatus);
					System.out.println("充值状态更新");
					ChargingOrder chargingOrder = chargingOrderDao.getOutTradeNo(outTradeNo);
					String userId = chargingOrder.getChargingOrder2ClientUserId();
					List<ClientUser> user = qUser.getUser(userId, "", "", "", "", "", "", "", "", "", "", "");
					String clientUserSecurity = user.get(0).getClientUserSecurity();
					System.out.println("验证令牌");
					co.inpour(userId, clientUserSecurity, outTradeNo);

				}

				return "success";

			} else {
				// 验证失败
				System.out.println("fail");
				return "fail";
			}

		}

		return null;
	}

	@RequestMapping("stay")
	public ModelAndView stay() throws Exception {
		String handsetManagerId = "b343999e2fa948fb84ee1e25a2de8d7c";
		String parkingInfoId = "2300cda8a92f4b869dc025a6fba7121c";
		String parkingOrderCarNo = "京AF6655";
		String parkingOrderHandSetId = "861351020653759";
		String j = po.creatParkingOrder(parkingOrderCarNo, parkingOrderHandSetId, parkingInfoId, handsetManagerId);
		JSONObject jsonObj = JSONObject.fromObject(j);
		String parkingOrderId = jsonObj.getJSONObject("datas").get("parkingOrderId").toString();

		String parkingOrderPayState = "Paid";

		po.updateParkingOrder(parkingOrderPayState, parkingOrderId);

		po.updateOrderPayState(parkingOrderPayState, parkingOrderId);

		return null;

	}

	// 手持人员
	@RequestMapping("UnifiedOrder")
	public ModelAndView UnifiedOrder() {
		String userId = "859a482637f045bc959f1e2eff21692e";
		String clientUserSecurity = "208171a2c9fa463d8510a29d482f2912";
		String chargingOrderChargingType = "2";
		String chargingOrderChargingAccount = "1";
		String chargingOrderAmount = "1";
		String i = co.unifiedOrder(userId, chargingOrderChargingType, chargingOrderChargingAccount, chargingOrderAmount,
				clientUserSecurity);
		// String outTradeNo = "NO201512171646148115154140";
		// co.inpour(userId, clientUserSecurity, outTradeNo);
		System.out.println(i);
		return null;
	}

	// 手持人员
	@RequestMapping("upFundAccountManageState")
	public ModelAndView upFundAccountManageState() {
		fam.upFundAccountManageState("72bc14e0356d491382fc09a96c1d219f", "00");
		return null;
	}

	@RequestMapping("selectParkingOrderByUserId")
	public ModelAndView selectParkingOrderByUserId() {

		po.selectParkingOrderByUserId("72bc14e0356d491382fc09a96c1d219f", "", "", "",
				"1336e16d895446f089c7677b82d20a48");
		return null;
	}

	@RequestMapping("cus")
	public ModelAndView cus() {

		System.out.println(cus.getUserSecurity("3ba41866402b4f5ea662779a9ff28ce2", "6216967316fd407b997d62a02f0a6829"));
		return null;
	}

	@RequestMapping("ts")
	public ModelAndView ts() {

		System.out.println(ts.getSysTime());
		return null;
	}

	@RequestMapping("pcs")
	public ModelAndView pcs() {

		System.out.println(pcs.getParkingCount("2300cda8a92f4b869dc025a6fba7121c", TimeTools.getStartMouthDay(),
				TimeTools.getTimesnight(), TimeTools.getCurrentTime(), 10));
		return null;
	}

	@RequestMapping("xxxx")
	public ModelAndView xxxx() {
		hs.insertHandesetOrder();

		return null;
	}

	// 交易订单分页
	@RequestMapping("toc")
	public ModelAndView toc() {
		System.out.println(toc.queryTradingOrdersLimit("", "", "", "", "", "", "", "", 2, 5));
		return null;
	}

	// 停车订单分页
	@RequestMapping("pos")
	public ModelAndView pos() {
		System.out.println(pos.queryParkOrderLimit("", "", "", "", "", "", "", "", "", "", "", "", "", "1", 1, 5));
		return null;
	}

	// 充值订单分页
	@RequestMapping("co")
	public ModelAndView co() {
		System.out.println(co.queryChargingOrderLimit("", "", "", "", "", 1, 5));
		return null;
	}

	// 消息历史分页
	@RequestMapping("ms")
	public ModelAndView ms() {
		System.out.println(ms.selectHistoryMessageLimit(1, 5));
		return null;
	}

	// 账单信息分页
	@RequestMapping("sfs")
	public ModelAndView sfs() {
		System.out.println(sfs.getSubFundLimit("", "", "", "", "", "", "", "", "", "", 1, 5));
		return null;
	}

	// 获取资金账户信息
	@RequestMapping("sc")
	public ModelAndView sc() {
		System.out.println(fam.getFundLimit("", "", "", "", "", "", "", 1, 5));
		return null;
	}

	// 手持统计
	@RequestMapping("cos")
	public ModelAndView cos() {
		System.out.println(cos.getCountOrder("day", "", "", "", "", "", "", 1, 5));
		System.out.println(cos.getCountOrder("mouth", "", "", "", "", "", "", 1, 5));
		System.out.println(cos.getCountOrder("year", "", "", "", "", "", "", 1, 5));
		return null;
	}

	// 人员车辆
	@RequestMapping("cuc")
	public ModelAndView cuc() {
		cuc.getUserCarLimit("", "", "", "", "", "", 1, 2);
		System.out.println(cuc.getUserCarLimit("", "", "", "", "", "", 1, 2));
		return null;
	}

	// 人员
	@RequestMapping("cu")
	public ModelAndView cu() {
		cu.getUserLimit("", "", "", "", "", "", "", "", "", 1, 5);
		System.out.println(cu.getUserLimit("", "", "", "", "", "", "", "", "", 1, 5));
		return null;
	}

	// 手持人员
	@RequestMapping("fam")
	public ModelAndView fam() {

		System.out.println(hs.getHandSetLimit("", "", "", "2300cda8a92f4b869dc025a6fba7121c", "", "", "", "", 1, 13));
		return null;
	}

	// 停车场
	@RequestMapping("pf")
	public ModelAndView pf() {

		System.out.println(pf.getParkingInfoLimit(1, 13));
		return null;
	}

	@RequestMapping("hs")
	public ModelAndView hs() {

		fam.upFundAccountManageState("72bc14e0356d491382fc09a96c1d219f", "01");

		return null;
	}

	@RequestMapping("up")
	public void up(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		String fileName = "";
		String path = "";
		String savePath = request.getServletContext().getRealPath("/WEB-INF/download");
		System.out.println(savePath);
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<?> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					fileName = file.getOriginalFilename();
					path = savePath + "\\" + fileName;
					File localFile = new File(path);
					file.transferTo(localFile);
				}
			}
			// apk 上传路径生成二维码
			String saveGifPath = request.getServletContext().getRealPath("/home/images/");
			// 下载路径
			String text = "http://www.baidu.com";
			int width = 300;
			int height = 300;
			// 二维码的图片格式
			String format = "gif";
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			// 内容所使用编码
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
			// 生成二维码
			File outputFile = new File(saveGifPath + File.separator + "android.gif");
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
			System.out.println(outputFile);
			// 更新到数据库
			ss.upAndroidImg("sys", "2015-11-12 16:44:43", fileName, savePath, path);
		}

		return;
	}

	/**
	 * 
	 * down:(下载apk). <br/>
	 * TODO(测试地址 http://172.29.4.1:8080/OnlineParking/listfile.jsp).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author ziheng
	 * @param request
	 * @param response
	 * @throws IOException
	 * @since JDK 1.8u60
	 */
	@RequestMapping("down")
	public void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/**
		 * 通过数据库获取
		 */
		String s = ss.getSysImg();
		System.out.println("filepath="
				+ JSONObject.fromObject(JSONObject.fromObject(s).get("datas")).get("sysImgAndroidPath") + ",filename="
				+ JSONObject.fromObject(JSONObject.fromObject(s).get("datas")).get("sysImgAndroidName") + "");
		// 设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(
				JSONObject.fromObject(JSONObject.fromObject(s).get("datas")).get("sysImgAndroidName").toString(),
				"UTF-8"));
		// 读取要下载的文件，保存到文件输入流
		FileInputStream in = new FileInputStream(
				JSONObject.fromObject(JSONObject.fromObject(s).get("datas")).get("sysImgAndroidPath") + "\\"
						+ JSONObject.fromObject(JSONObject.fromObject(s).get("datas")).get("sysImgAndroidName"));
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
