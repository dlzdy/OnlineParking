 
package kevinTest;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.yinzitech.onlineparking.entity.common.ResultMap;
import com.yinzitech.onlineparking.wexin.utils.WeixinUtils;

import net.sf.json.JSONObject;

/**
 * ClassName:WeiXinPay <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年12月15日 下午3:05:19 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class WeiXinPay {
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		// WeixinUtils.payOrderquery("NO201512171036249534942410");

//		 String out_trade_no = WeixinUtils.getOut_trade_no();
//		 WeixinUtils.payUnifiedorder("平台充值", 1, "172.29.5.15", out_trade_no);
//		 Map<String, String> datas = WeixinUtils.payUnifiedorder("平台充值", 1,
//		 "172.29.5.15", out_trade_no);
//		// WeixinUtils.payOrderquery("NO201512171646148115154140");
//		 System.out.println(ResultMap.obj2JsonResult("1", "2", datas));

		 WeixinUtils.closeOrder("NO201512291135006152322872");
		// double i = 111111111;
		// System.out.println(i / 100);
		//
		// double m = 7237.3589;
		// DecimalFormat df = new DecimalFormat("#.00");
		// String w =df.format(m);
		// System.out.println(df.format(m));
	}

}
