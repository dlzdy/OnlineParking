/**
 * Project Name:onlineParking
 * File Name:ParkFinancialStatement.java
 * Package Name:com.yz.ParkDemo.controller.financial
 * Date:2015年9月28日上午10:39:24
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package com.yinzitech.onlineparking.controller.financial;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yinzitech.onlineparking.entity.count.CountOrder;
import com.yinzitech.onlineparking.service.count.CountOrderService;
import com.yinzitech.onlineparking.service.parkingInfo.ParkingInfoService;
import com.yinzitech.onlineparking.service.parkingSys.ParkingManagerService;
import com.yinzitech.onlineparking.utils.ObjectExcelView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:ParkFinancialStatement <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 财务报表
 * Date:     2015年9月28日 上午10:39:24 <br/>
 * @author   xumingyue
 * @version  
 * @since    JDK 1.8u60
 * @see 	 
 */
@Controller
public class ParkFinancialStatementController {
	

	@Autowired
	ParkingManagerService pmService ;  //用户Service
	
	@Autowired
	ParkingInfoService pInfoService ; //停车场信息Service
	
	@Autowired
	CountOrderService countOrderService ; //(统计订单信息)
	/**
	 * toFinancialStatement:财务报表
	 * @author ziheng
	 * @return
	 * @since JDK 1.8u60
	 */
	//第一次进入界面 获取当月 月报
	@RequestMapping(value="toFinancialStatement")
	public ModelAndView toFinancialStatement(HttpServletRequest request){
		String FLAG = "" ; //根据该参数，判断下载传入方法的参数
		//获取系统年 月
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String yearMonth = df.format(new Date());// new Date()为获取当前系统时间
		String[] strYearMonth= yearMonth.split("-");
		System.err.println("strYearMonth:"+strYearMonth[0]+";"+strYearMonth[1]+";"+strYearMonth[2]);
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  
		String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		//判断页面是否首次进入，
		String lastDay =request.getParameter("lastDay");
		String quarter = request.getParameter("quarter") ;
		Integer intLastDay =0;
		String result= "";
		String year_web = "";
		String month_web = "";
		//首次进入		
		boolean flag = false ;
		if(lastDay == null){	
			SimpleDateFormat format = new SimpleDateFormat("dd"); 
	        intLastDay =Integer.parseInt(format.format(new Date())); 
	        year_web = strYearMonth[0];
			month_web = strYearMonth[1];
			result= countOrderService.getCountOrder("day", "", "", "",parkingInfoId,year_web+"-"+month_web+"-01 00:00:00", 
					year_web+"-"+month_web+"-"+strYearMonth[2]+" 23:59:59", 1, 50) ;
			FLAG = "0" ;//第一次进入参数为0
			System.err.println("第一次进入"+year_web+"*"+month_web+"*"+strYearMonth[2]);
			flag = true;
		}
		//再次带参进入	
		else{			
			year_web = request.getParameter("year");
			month_web = request.getParameter("month");
			result= countOrderService.getCountOrder("day", "", "", "",parkingInfoId, 
					year_web+"-"+month_web+"-01 00:00:00", 
					year_web+"-"+month_web+"-"+lastDay+" 23:59:59", 1, 50) ;
			System.err.println("再次带参进入"+yearMonth+"_"+strYearMonth[0]);
			intLastDay =Integer.parseInt(lastDay);
			FLAG = "2" ;//查询年报
			System.err.println("第二次进入");
		}
		
		System.err.println(result);
		JSONObject data = JSONObject.fromObject(result) ;
		JSONObject datas = data.getJSONObject("datas") ;
		 //获取一个json数组
		 JSONArray array = datas.getJSONArray("result");
		//月报表（车辆）
		//1.首先判断该月有多少天
		
		//2.获取后台json，将其内部countOrder对象遍历，获取每天的值以及countCar, cost
		String arrColrs[] = {"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
							"D64646","8E468E","588526","B3AA00","008ED6",
							"9D080D","A186BE","8BBA00","FF8E46","008E8E",
							"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
							"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
							"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E","AFD8F8","F6BD0F"} ; //初始化一个存31个颜色的数组，代表一月内每天的颜色
		//构造一个strXML
		String[] day = new String[32];
		String[] car = new String[32] ;
		String[] cost = new String[32] ;
		int allCars = 0 ;//统计车辆
		Double allCost = 0.0 ;//统计金额
	
		for(int i=1; i <= intLastDay; i ++){
			for(int j=0; j < array.size() ; j++){//遍历json数组中的CountOrder对象
				 JSONObject object =(JSONObject)array.get(j);  //依次获取CountOrder对象
				if(object.get("day").equals(i+"")){ //如果对象中的day属性和外层的i（即天数）相等
					day[i] = (String) object.get("day") ;
					car[i] = (String) object.get("countCar") ;
					allCars += Integer.parseInt(car[i]) ;
					//System.err.println("objectget:"+object.get("cost"));
					if(!object.get("cost").equals(null)){
						cost[i] = (String)object.get("cost") ;	
						/*System.err.println("cost"+cost[i]);*/
						allCost+=Double.parseDouble(cost[i]) ;
					}
				}
			}
		}
		String strXML = "";
		strXML += "<graph caption='"+year_web+"年"+month_web+"月   车辆月报统计' xAxisName='天' yAxisName='值(车辆数/天)' decimalPrecision='0' formatNumberScale='0'>";
		for(int k = 1 ; k < day.length; k++){
			if(day[k]==null){
				strXML += "<set name='"+k+"' value='0' color='"+arrColrs[k]+"'/>";
			}else{
				strXML += "<set name='"+day[k]+"' value='"+car[k]+"' color='"+arrColrs[k]+"'/>";
			}
		}
		strXML += "</graph>" ;
		
		//月报表（金额）
		String strCostXML = "";
		strCostXML += "<graph caption='"+year_web+"年"+month_web+"月   金额月报统计' xAxisName='天' yAxisName='值(金额/天)' decimalPrecision='0' formatNumberScale='0'>";
		for(int k = 1 ; k < day.length; k++){
			if(day[k]==null){
				strCostXML += "<set name='"+k+"' value='0' color='"+arrColrs[k]+"'/>";
			}else{
				strCostXML += "<set name='"+day[k]+"' value='"+cost[k]+"' color='"+arrColrs[k]+"'/>";
			}
		}
		strCostXML += "</graph>" ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/finance/statement");
		mv.addObject("parkInfo", parkInfo) ;
		mv.addObject("strXML", strXML) ;
		mv.addObject("strCostXML",strCostXML) ;
		if(flag){ //如果是第一次进入
			mv.addObject("quarter", "0") ;
			mv.addObject("year", "0") ;
			mv.addObject("month", "0") ;
		}else{
			mv.addObject("quarter",quarter) ;
			mv.addObject("year", year_web) ;
			mv.addObject("month", month_web) ;
		}
		mv.addObject("allCars", allCars) ;
		mv.addObject("allCost", allCost) ;
		mv.addObject("FLAG", FLAG) ;//该参数供下载时使用
		return mv ;
	}
	//年报
	@RequestMapping(value="/getYearReportForm")
	public ModelAndView getYearCarsReportForm(HttpServletRequest request){
		String uID=  request.getParameter("uID") ; //(1)首先获取UID  uID存在seesion中 
		String year = request.getParameter("year") ;
		String m = request.getParameter("month") ;
		String quarter = request.getParameter("quarter") ;
		
		String startYear = year+"-1-1 00:00:00" ;
		String endYear = year+"-12-31 23:59:59" ;
		String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		
		String result = countOrderService.getCountOrder("mouth", "", "", "",parkingInfoId, startYear, endYear, 1, 50) ;
		JSONObject data = JSONObject.fromObject(result) ;
		JSONObject datas = data.getJSONObject("datas") ;
		 //获取一个json数组
		 JSONArray array = datas.getJSONArray("result");
		System.err.println("result:"+result);
		String arrColrs[] = {"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
				"D64646","8E468E","588526","B3AA00","008ED6",
				"9D080D","A186BE","8BBA00","FF8E46","008E8E",
				"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
				"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
				"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E","AFD8F8","F6BD0F"} ; //初始化一个存31个颜色的数组，代表一月内每天的颜色
				//构造一个strXML
				String[] month = new String[13];
				String[] car = new String[13] ;
				String[] cost = new String[13] ;
				int allCars = 0 ;//统计车辆
				Double allCost = 0.0 ;//统计金额
				for(int i=1; i <= 12 ; i ++){
					for(int j=0; j < array.size() ; j++){//遍历json数组中的CountOrder对象
						 JSONObject object =(JSONObject)array.get(j);  //依次获取CountOrder对象
						if(object.get("month").equals(i+"")){ //如果对象中的day属性和外层的i（即天数）相等
							month[i] = (String) object.get("month") ;
							car[i] = (String) object.get("countCar") ;
							allCars += Integer.parseInt(car[i]) ;
							//System.err.println("objectget:"+object.get("cost"));
							if(!object.get("cost").equals(null)){
								cost[i] = (String)object.get("cost") ;
								allCost += Double.parseDouble(cost[i]) ;
							}
						}
					}
				}
				
				String strXML = "";
				strXML += "<graph caption='"+year+"年   车辆年报统计' xAxisName='月' yAxisName='值(车辆数/月)' decimalPrecision='0' formatNumberScale='0'>";
				for(int k = 1 ; k < month.length; k++){
					if(month[k]==null){
						strXML += "<set name='"+k+"' value='0' color='"+arrColrs[k]+"'/>";
					}else{
						strXML += "<set name='"+month[k]+"' value='"+car[k]+"' color='"+arrColrs[k]+"'/>";
					}
				}
				strXML += "</graph>" ;
				String strCostXML = "";
				strCostXML += "<graph caption='"+year+"年 金额年报统计' xAxisName='月' yAxisName='值(金额/天)' decimalPrecision='0' formatNumberScale='0'>";
				for(int k = 1 ; k < month.length; k++){
					System.err.println("month["+k+"]:"+month[k]);
					if(month[k]==null){
						strCostXML += "<set name='"+k+"' value='0' color='"+arrColrs[k]+"'/>";
					}else{
						strCostXML += "<set name='"+month[k]+"' value='"+cost[k]+"' color='"+arrColrs[k]+"'/>";
					}
				}
				strCostXML += "</graph>" ;
				ModelAndView mv = new ModelAndView() ;
				mv.setViewName("parking/finance/statement");
				mv.addObject("parkInfo", parkInfo) ;
				mv.addObject("strXML", strXML) ;
				mv.addObject("strCostXML",strCostXML) ;
				mv.addObject("month",m) ;
				mv.addObject("quarter",quarter) ;
				mv.addObject("year", year) ;
				mv.addObject("allCost", allCost) ;
				mv.addObject("allCars", allCars) ;
				mv.addObject("FLAG", "1"); 
				return mv ;
	}
	
	//季报
	@RequestMapping(value="getquarterReportForm")
	public ModelAndView getquarterReportForm(HttpServletRequest request){
		//获取系统年 月
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String yearMonth = df.format(new Date());// new Date()为获取当前系统时间
		String[] strYearMonth= yearMonth.split("-");
		System.err.println("strYearMonth:"+strYearMonth[0]+";"+strYearMonth[1]);
		String uID=  request.getParameter("userID") ; //(1)首先获取UID  
		String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
		JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
		JSONObject obj1 = obj.getJSONObject("datas");
		String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
		//通过停车场id获取停车场信息   然后在前台获取停车名称
		String parkInfo = pInfoService.getParkingInfoById(parkingInfoId) ;
		
		String year_web = request.getParameter("year") ;
		String quarter_web = request.getParameter("quarter") ;
		String month_web = request.getParameter("month") ;
		String beginMonth ="";
		String endMonth ="";		
		String lastDay =request.getParameter("lastDay");
		
		switch(quarter_web){
		case "1":
			beginMonth="01";
			endMonth="03";
			break;
		case "2":
			beginMonth="04";
			endMonth="06";
			break;
		case "3":
			beginMonth="07";
			endMonth="09";
			break;
		case "4":
			beginMonth="10";
			endMonth="12";
			break;
		default:
			break;
		}
		
		
		String result= countOrderService.getCountOrder("mouth", "", "", "",parkingInfoId, 
				year_web+"-"+beginMonth+"-01 00:00:00", 
				year_web+"-"+endMonth+"-"+lastDay+" 23:59:59", 1, 50) ;
		
		
		System.err.println(result);
		JSONObject data = JSONObject.fromObject(result) ;
		JSONObject datas = data.getJSONObject("datas") ;
		 //获取一个json数组
		 JSONArray array = datas.getJSONArray("result");
		//月报表（车辆）
		//1.首先判断该月有多少天
		
		//2.获取后台json，将其内部countOrder对象遍历，获取每天的值以及countCar, cost
		String arrColrs[] = {"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
							"D64646","8E468E","588526","B3AA00","008ED6",
							"9D080D","A186BE","8BBA00","FF8E46","008E8E",
							"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
							"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E",
							"AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E","AFD8F8","F6BD0F"} ; //初始化一个存31个颜色的数组，代表一月内每天的颜色
		//构造一个strXML
		String[] month = new String[13];
		String[] car = new String[13] ;
		String[] cost = new String[13] ;
		int allCars = 0 ;//统计车辆
		Double allCost = 0.0 ;//统计金额
		int bMonth = Integer.parseInt(beginMonth) ;//将开始月份转化为整形
		int eMonth = Integer.parseInt(endMonth) ;
		for( int i = bMonth; i <= eMonth; i ++){
			for(int j=0; j < array.size() ; j++){//遍历json数组中的CountOrder对象
				 JSONObject object =(JSONObject)array.get(j);  //依次获取CountOrder对象
				if(object.get("month").equals(i+"")){ //如果对象中的day属性和外层的i（即天数）相等
					month[i] = (String) object.get("month") ;
					car[i] = (String) object.get("countCar") ;
					allCars += Integer.parseInt(car[i]) ;
					//System.err.println("objectget:"+object.get("cost"));
					if(!object.get("cost").equals(null)){
						cost[i] = (String)object.get("cost") ;
						allCost += Double.parseDouble(cost[i]) ;
				/*		System.err.println("cost["+i+"]:"+cost[i]);
						System.err.println("allCost:"+allCost);*/
					}
				}
			}
		}
		String strXML = "";
		strXML += "<graph caption='"+year_web+"年"+quarter_web+"季度   车辆统计' xAxisName='月' yAxisName='值(车辆数/月)' decimalPrecision='0' formatNumberScale='0'>";
		for(int k = bMonth ; k <= eMonth; k++){
			if(month[k]==null){
				strXML += "<set name='"+k+"' value='0' color='"+arrColrs[k]+"'/>";
			}else{
				strXML += "<set name='"+month[k]+"' value='"+car[k]+"' color='"+arrColrs[k]+"'/>";
			}
		}
		strXML += "</graph>" ;
		
		//月报表（金额）
		String strCostXML = "";
		strCostXML += "<graph caption='"+year_web+"年"+quarter_web+"季度   金额统计' xAxisName='月' yAxisName='值(金额/月)' decimalPrecision='0' formatNumberScale='0'>";
		for(int k = bMonth ; k <= eMonth; k++){
			if(month[k]==null){
				strCostXML += "<set name='"+k+"' value='0' color='"+arrColrs[k]+"'/>";
			}else{
				strCostXML += "<set name='"+month[k]+"' value='"+cost[k]+"' color='"+arrColrs[k]+"'/>";
			}
		}
		strCostXML += "</graph>" ;
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("parking/finance/statement");
		mv.addObject("parkInfo", parkInfo) ;
		mv.addObject("strXML", strXML) ;
		mv.addObject("strCostXML",strCostXML) ;
		mv.addObject("year", year_web) ;
		mv.addObject("month", month_web) ;
		mv.addObject("quarter", quarter_web) ;
		mv.addObject("allCars", allCars) ;
		mv.addObject("allCost", allCost) ;
		mv.addObject("FLAG", "3"); 
		
		return mv ;
	}
	
	//导出excel
		@RequestMapping(value="/exportExcel") //导出excel
		public ModelAndView exportExcel(HttpServletRequest request){
			String year = request.getParameter("year") ;
			String month = request.getParameter("month") ;
			String quarter = request.getParameter("quarter") ;
			String FLAG = request.getParameter("FLAG") ;
			System.err.println("year:"+year+";month:"+month+";quarter:"+quarter);
			String uID=  request.getParameter("userID") ; //(1)首先获取UID  
			String userInfo =   pmService.getParkingManagerByParkingManagerId(uID) ;//(2) 通过uID
			JSONObject obj = JSONObject.fromObject(userInfo); // (3)获取停车场ID
			JSONObject obj1 = obj.getJSONObject("datas");
			String parkingInfoId =(String) obj1.get("parkingInfoId"); //获取停车场id
			
			//获取系统年 月
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String yearMonth = df.format(new Date());// new Date()为获取当前系统时间
			String[] strYearMonth= yearMonth.split("-");
			String result = "" ;
			if(FLAG.equals("0")){ //第一次进入  ，导出报表
				result= countOrderService.getCountOrder("day", "", "", "",parkingInfoId,strYearMonth[0]+"-"+strYearMonth[1]+"-01 00:00:00", 
						strYearMonth[0]+"-"+strYearMonth[1]+"-"+strYearMonth[2]+" 23:59:59", 1, 50) ;
				System.err.println("result:"+result);
				System.err.println("strYearMonth[0]:"+strYearMonth[0]+";strYearMonth[1]:"+strYearMonth[1]+";strYearMonth[2]"+strYearMonth[2]);
			}else if(FLAG.equals("1")){ //导出年报
				String startYear = year+"-1-1 00:00:00" ;
				String endYear = year+"-12-31 23:59:59" ;
				result = countOrderService.getCountOrder("mouth", "", "", "","", startYear, endYear, 1, 50) ;
			}else if(FLAG.equals("2")){ //导出月报
				Calendar cal = Calendar.getInstance();   
				cal.set(Calendar.YEAR, Integer.parseInt(year));
			    cal.set(Calendar.MONTH, Integer.parseInt(month)-1);
			    cal.set(Calendar.DAY_OF_MONTH, 1);
				int endday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
				System.err.println("endday:"+endday);
				result= countOrderService.getCountOrder("day", "", "", "",parkingInfoId, 
						year+"-"+month+"-01 00:00:00", 
						year+"-"+month+"-"+endday+" 23:59:59", 1, 50) ;
			}else if(FLAG.equals("3")){//导出季报
				String beginMonth ="" ;
				String endMonth ="" ;
				switch(quarter){
				case "1":
					beginMonth="01";
					endMonth="03";
					break;
				case "2":
					beginMonth="04";
					endMonth="06";
					break;
				case "3":
					beginMonth="07";
					endMonth="09";
					break;
				case "4":
					beginMonth="10";
					endMonth="12";
					break;
				default:
					break;
				}
				result= countOrderService.getCountOrder("mouth", "", "", "",parkingInfoId, 
						year+"-"+beginMonth+"-01 00:00:00", 
						year+"-"+endMonth+"-"+strYearMonth[2]+" 23:59:59", 1, 50) ;
			}
			ModelAndView mv = new ModelAndView();
			try{
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				titles.add("年");	//1
				titles.add("月");	//2
				titles.add("日");	//3
				titles.add("车辆");	//4
				titles.add("金额");	//5
				dataMap.put("titles", titles);
				
				
				//List<PageData> varOList = commandService.listAll(pd);
				//String result = countOrderService.getCountOrder("day", "", "", "","", "","", 1, 50) ;
				JSONObject data = JSONObject.fromObject(result) ;
				//获取一个json数组
				JSONObject a = data.getJSONObject("datas") ;
				JSONArray array = a.getJSONArray("result");
				
				System.err.println("array:"+array.size());
				//将json数组 转换成List<CountOrder>泛型
				List<CountOrder> list = new ArrayList<CountOrder>();
				   for (int i =0; i < array.size(); i++){   
				           JSONObject object =(JSONObject)array.get(i);  
				           CountOrder counter =(CountOrder)JSONObject.toBean(object,
				        		   CountOrder.class);
				           if(counter != null){
				           list.add(counter);
				           }
				    }  
				           
				           
				List<Map<String,String>> varList = new ArrayList<Map<String,String>>();
				for(int j =0;j<list.size();j++){
					Map<String,String>  vpd = new HashMap<String,String>();
					vpd.put("var1", list.get(j).getYear());	//1
					vpd.put("var2", list.get(j).getMonth());	//2
					vpd.put("var3", list.get(j).getDay());	//3
					vpd.put("var4", list.get(j).getCountCar());	//4
					vpd.put("var5", list.get(j).getCost());	//5
					varList.add(vpd);
				}
				dataMap.put("varList", varList);
				ObjectExcelView erv = new ObjectExcelView();
				mv = new ModelAndView(erv,dataMap);
			}catch(Exception e){
				
			}
			return mv;
		}
	 
}

