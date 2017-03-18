<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>"><!-- jsp文件头和头部 -->
	<!-- jsp文件头和头部 -->
	<meta charset="utf-8">
	<title></title>
	<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="system/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="system/css/font-awesome.min.css" />
	<link rel="stylesheet" href="system/css/chosen.css" />
	<link rel="stylesheet" href="system/css/ace.min.css" />
	<link rel="stylesheet" href="system/css/ace-skins.min.css" />
	<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
	<link rel="stylesheet" href="system/css/datepicker.css" /><!-- 日期框 -->
	<link rel="stylesheet" href="plugins/paginate/css/lanrenzhijia.css" /> <!-- 分页样式 -->
	<!--引入弹窗组件start-->
	<script type="text/javascript" src="system/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
	<script type="text/javascript" src="system/js/jquery.json-2.4.js"></script>
	<script type="text/javascript" src="system/js/jquery.tips.js"></script>
	<script type="text/javascript" src="utiljs/tools.js"></script>
	<script type="text/javascript" src="plugins/datepakier/WdatePicker.js"></script>
	<script type="text/javascript" src="plugins/datepakier/lang/zh-cn.js"></script>
	<script type="text/javascript">
	
	$(function(){
		var allParkInfo = ${allParkInfo} ;
		/* var tradingOrders = ${tradingOrders} ; */
 		for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
			for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
				$("#parkInfoId").append("<option value='"+allParkInfo.datas[i].parkingInfoId+"'>"+allParkInfo.datas[i].parkingInfoName+"</option>");
			}
		}
 		/*  getDataList(tradingOrders) ; */
	 }) ;
	</script>
	</head>
<body  onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> 首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>订单维护<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">支付订单维护</li>
		</ul>
	</div><!--#breadcrumbs-->
						
  <div class="row-fluid">
	<div class="row-fluid">
		<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
		<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
		<table>
				<tr>
					<td style="vertical-align:top;"> 
						<select class="chzn-select" id="parkInfoId" data-placeholder="请选择停车场" style="vertical-align:top;">
					  	<option value="">请选择停车场</option>
					  	</select>
					</td>
						<td style="vertical-align:top;"> 
						<select class="chzn-select" id="state" data-placeholder="请选择订单状态" style="vertical-align:top;">
					  	<option value="">请选择订单状态</option>
					  	<option value="10">订单未完成</option>
					  	<option value="00">等待支付</option>
					  	<option value="01">订单已完成</option>
					  <!-- 	<option value="02">支付成功</option>
					  	<option value="03">支付失败</option> -->
					  	</select>
					</td>
					<td>
						 <input readonly="readonly" type="text" class="Wdate" id="startTime" placeholder="这里输入开始时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</td>
					<td>
						 <input readonly="readonly" type="text" class="Wdate" id="endTime" placeholder="这里输入结束时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
	
		   <table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center"></th>
						<!-- <th class="center" style='display:none'>交易订单id</th> -->
						<th class="center">支付订单</th>
						<th class="center">停车订单</th>
						<th class="center">支付金额</th> 
						<th class="center">订单状态</th>
						<th class="center">创建时间</th>
						<!-- <th class="center">用户手机号</th>
						<th class="center">停车场名称</th> -->
					</tr>
				</thead>
				<tbody id="t_datas">
					<tr>
						<td class="center" colspan="12" >暂无数据</td>
					</tr>
				</tbody>
			</table>
		</div>
		<p id="count" style="display:none"><strong>累计支付金额：</strong><span id="costAll"></span>元</p>		
		<div id="page"> </div>
		
	</div>
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='onlineparking/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="onlineparking/js/bootstrap.min.js"></script>
		<script src="onlineparking/js/ace-elements.min.js"></script>
		<script src="onlineparking/js/ace.min.js"></script>
		
		<script type="text/javascript" src="onlineparking/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="onlineparking/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="onlineparking/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<script type="text/javascript" src="plugins/paginate/js/jquery.paginate.js"></script><!--分页-->
		<!-- 引入 -->
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script><!--提示框-->
		<script type="text/javascript">
		
		$(top.hangge());
		
		//keySearch enter键 触发搜索 
		function keySearch(){
			var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
			 if(event.keyCode == 13){
				 search(1) ;
			 }
		}
		//选择框发生变化触发的事件
		$("#parkInfoId").change(function(){
			giveNum() ;
			search(1);
		});
		
		$("#state").change(function(){
			search(1);
		});
		

		//如果当前页和当前页条数为空 则给默认值
		function giveNum(){
				 $("#currentPage").val("1") ;
				 $("#pageSize").val("20") ;
		}
		//搜索 和选择框发生变化时一样，与分页功能 分离  ，将页码值设为默认值 
		function find(){
			giveNum() ;//点击搜索按钮时，将当前页和每页条数清空,并赋予默认值 
			search(1);
		}
		//检索 
		function search(type){
			top.jzts();
			var currentPage =  $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var parkName = $("#parkInfoId").find("option:selected").text(); //停车场 
			var startTime = $("#startTime").val() ; //开始时间
			var endTime = $("#endTime").val() ;//结束时间
			var state = $("#state").val() ;//状态 
			var jsonstr = {"parkName":parkName,"startTime":startTime,"endTime":endTime,"state":state,"currentPage":currentPage,"pageSize":pageSize} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectPayOrderMaintenance',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(tradingOrders){
					if(tradingOrders.result=="0"){
						var html = "" ;
						html +="<tr>" ;
						html +="<td class=\"center\" colspan=\"12\" >暂无数据</td>" ;
						html +="</tr>" ;
						$("#t_datas").html(html) ;
						 $("#count").hide() ;//隐藏统计 
						$("#page").html("") ;
						return false ;
					}
					$("#currentPage").val(tradingOrders.datas.pageNum) ;
					$("#pageSize").val(tradingOrders.datas.pageSize) ;
					getDataList(tradingOrders) ;
					//分页信息 
					
					if(type!="paginate"){
						getPaginate(tradingOrders.datas.pages) ;
					}
					
					//设置样式					
					$("#page li:eq("+tradingOrders.datas.pageNum+")").addClass("active");   
					//统计	
					$("#count").show() ;
					$("#costAll").html(getAll('t_datas',3)) ;//该发放放在jquery-1.7.2.js中
				}
			}) ;
		}
		
		function getDataList(tradingOrders){
			var parkName = $("#parkInfoId").find("option:selected").text(); //停车场 
			var html = "" ;
			for(var i = 0 ; i <tradingOrders.datas.result.length ; i++){/*  */
				html += "<tr>" ;
				html += "  <td class=\"center\" style=\"width: 30px;\"></td>" ;
				/* html += "  <td class=\"center\" style='display:none'>"+tradingOrders.datas[i].orderId+"</td>" ; */
				/* 支付订单 */
				html += "  <td class=\"center\">"+tradingOrders.datas.result[i].tradingOrderId+"</td>" ;
				
				/* html += "  <td class=\"center\"></td>" ; */
				/* html += "  <td class=\"center\">"+parkName+"</td>" ; */
				/* 停车订单 */
				html += "  <td class=\"center\">"+tradingOrders.datas.result[i].tradingOrderParkingOrderId+"</td>" ;
				/* html += "  <td class=\"center\">"+tradingOrders.datas.result[i].tradingOrderId+"</td>" ; */
				/*支付金额  */
				html += "  <td class=\"center\">"+tradingOrders.datas.result[i].tradingOrderTranAmount+"</td>" ;
				/* 支付状态 */
				if(tradingOrders.datas.result[i].tradingOrderState=="00"){
					html += "  <td class=\"center\">等待支付</td>" ;
				}else if(tradingOrders.datas.result[i].tradingOrderState=="01"){
					html += "  <td class=\"center\">订单已完成</td>" ;
				}else if(tradingOrders.datas.result[i].tradingOrderpayState=="10"){
					html += "  <td class=\"center\">订单未完成</td>" ;
				}/* else if(tradingOrders.datas.result[i].tradingOrderpayState=="03"){
					html += "  <td class=\"center\">支付失败</td>" ;
				}else{//10
					html += "  <td class=\"center\">未支付</td>" ;
				} */
				
				/* 创建时间 */
				html += "  <td class=\"center\">"+tradingOrders.datas.result[i].tradingOrderCreateTime+"</td>" ;
				html += " </tr>" ;
			}
			//动态获取行号 
			setRowNumByJSON(tradingOrders,'t_datas',html) ;
		}
	    $(function(){
	    	//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
	   
			//日期框
			$('.date-picker').datepicker();
	    }) ;
		
		</script>
	</body>
</html>

