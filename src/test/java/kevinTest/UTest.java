 

package kevinTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class UTest {
	private static int COMPANY_ID = 67;
	private static int PARK_ID = 514;
	private static String no = "京QUN276";

	public static void main(String[] args) throws Exception {
		// JSONObject jo1 = new JSONObject();
		// jo1.accumulate("companyID", COMPANY_ID);
		// jo1.accumulate("plate", no);
		// // 接口测试
		// String json = HttpPostUtils.executeRequest("calfee", jo1);
		Properties pps = new Properties();
		pps.load(new FileInputStream("src//main//resources//conf//jdbc.properties"));
		Enumeration<?> enum1 = pps.propertyNames();// 得到配置文件的名字
		while (enum1.hasMoreElements()) {
			String strKey = (String) enum1.nextElement();
			String strValue = pps.getProperty(strKey);
			System.out.println(strKey + "=" + strValue);
		}

	}

}
