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
	<%@ include file="../../system/admin/top.jsp"%> 
	<script type="text/javascript" src="onlineparking/js/onlineparking/finance-statement.js"></script>  
	<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script>  
	<script type="text/javascript">
		$(function(){
			var parkInfo = ${parkInfo} ; //停车场信息
			$("#indexInfo").html(parkInfo.datas.parkingInfoName); //获取停车场名称 (XXX停车场后台首页)
			var year = ${year} ;
			var month = ${month} ;
			var quarter = ${quarter} ;
			$("#year").val(year) ;
			$("#month").val(month) ;
			$("#quarter").val(quarter) ;
			
			$("#Year").val(year) ;
			$("#Month").val(month) ;
			$("#Quarter").val(quarter) ;
		}) ;
	
	</script>
	</head>
<body>
		
<div class="container-fluid" id="main-container">

<div id="page-content" class="clearfix">

    <div id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="icon-home"></i> <a href="tab.do" id="indexInfo"></a><span class="divider"><i class="icon-angle-right"></i></span></li>
				<li>财务管理<span class="divider"><i class="icon-angle-right"></i></span></li>
				<li class="active">财务报表</li>
			</ul>
			<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->	
	
						
  <div class="row-fluid">

	<div class="row-fluid">
			<input type="hidden" value="<%=session.getAttribute("uID")%>" id="uID"/>
			<input type="hidden"  id="Year" />
			<input type="hidden"  id="Month" />
			<input type="hidden" id="Quarter" />
			<input type="hidden" value="${FLAG}" id="FLAG" />
			<!-- 检索  -->
			<table>
				<tr>
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="year" id="year" data-placeholder="请选择年"  style="vertical-align:top;">
					  	<option value="0">请选择年</option>
					  	<option value="2015">2015年</option>
					  	<option value="2016">2016年</option>
					  	<option value="2017">2017年</option>
					  	</select>
					</td>
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="month" id="month" data-placeholder="请选择月" style="vertical-align:top;">
					  	<option value="0">请选择月</option>
					  	<option value="1">1月</option>
					  	<option value="2">2月</option>
					  	<option value="3">3月</option>
					  	<option value="4">4月</option>
					  	<option value="5">5月</option>
					  	<option value="6">6月</option>
					  	<option value="7">7月</option>
					  	<option value="8">8月</option>
					  	<option value="9">9月</option>
					  	<option value="10">10月</option>
					  	<option value="11">11月</option>
					  	<option value="12">12月</option>
					  	</select>
					</td>
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="quarter" id="quarter"  data-placeholder="请选择季度" style="vertical-align:top;">
					  	<option value="0">请选择季度</option>
					  	<option value="1">第一季度</option>
					  	<option value="2">第二季度</option>
					  	<option value="3">第三季度</option>
					  	<option value="4">第四季度</option>
					  	</select>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="searchYear();"  title="年报检索"><i id="nav-search-icon" class="icon-search"></i>年报</button></td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="searchMonth();"  title="月报检索"><i id="nav-search-icon" class="icon-search"></i>月报</button></td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="searchQuarter();"  title="季报检索"><i id="nav-search-icon" class="icon-search"></i>季报</button></td>
					<td style="vertical-align:top;"><a class="btn btn-mini btn-light" onclick="toExcel();" title="导出到EXCEL"><i id="nav-search-icon" class="icon-download-alt"></i></a></td>
				</tr>
				
			</table>

			<table>
			
			</table>
						
			<%-- 		 <%
					String strXML = "";

					strXML += "<graph caption='年报表' xAxisName='月份' yAxisName='值(车辆数/月)' decimalPrecision='0' formatNumberScale='0'>";
					strXML += "<set name='1' value='462' color='AFD8F8'/>";
					strXML += "<set name='2' value='857' color='F6BD0F'/>";
					strXML += "<set name='3' value='671' color='8BBA00'/>";
					strXML += "<set name='4' value='494' color='FF8E46'/>";
					strXML += "<set name='5' value='761' color='008E8E'/>";
					strXML += "<set name='6' value='960' color='D64646'/>";
					strXML += "<set name='7' value='629' color='8E468E'/>";
					strXML += "<set name='8' value='622' color='588526'/>";
					strXML += "<set name='9' value='376' color='B3AA00'/>";
					strXML += "<set name='10' value='494' color='008ED6'/>";
					strXML += "<set name='11' value='761' color='9D080D'/>";
					strXML += "<set name='12' value='960' color='A186BE'/>";
					strXML += "</graph>";
			%> --%> 
			<div style="margin-top:30px;margin-top:20px">
		
						<div id=""></div>
								<!-- 柱状图 -->
						<div class="center">
							<div style="float:left;">
								<table border="0" width="50%">
								<%-- <caption align="top">车辆年报统计</caption>  --%> 
									<tr>
										<td id="chartDiv"> <jsp:include
												page="../../FusionChartsHTMLRenderer.jsp" flush="true">
												<jsp:param name="chartSWF" value="onlineparking/fusioncharts/Area2D.swf" />
												<jsp:param name="strURL" value="" />
												<jsp:param name="strXML" value="${strXML }" />
												<jsp:param name="chartId" value="myNext" />
												<jsp:param name="chartWidth" value="500" />
												<jsp:param name="chartHeight" value="300" />
												<jsp:param name="debugMode" value="false" />
											</jsp:include></td>
									</tr>
								</table>
								<div>合计：${allCars }辆</div>
							</div>
							<div style="float:right;margin-right:230px">
								<table border="0" width="50%">
								<%-- <caption align="top">金额年报统计</caption>   --%>
									<tr>
										<td><jsp:include
												page="../../FusionChartsHTMLRenderer.jsp" flush="true">
												<jsp:param name="chartSWF" value="onlineparking/fusioncharts/Area2D.swf" />
												<jsp:param name="strURL" value="" />
												<jsp:param name="strXML" value="${strCostXML }" />
												<jsp:param name="chartId" value="myNext" />
												<jsp:param name="chartWidth" value="500" />
												<jsp:param name="chartHeight" value="300" />
												<jsp:param name="debugMode" value="false" />
											</jsp:include></td>
									</tr>
								</table>
								<div>合计：${allCost }元</div>
							</div>
				</div>
						
	</div>
 
 
 
 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='onlineparking/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="onlineparking/js/bootstrap.min.js"></script>
		<script src="onlineparking/js/ace-elements.min.js"></script>
		<script src="onlineparking/js/ace.min.js"></script>
		
		<script type="text/javascript" src="onlineparking/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="onlineparking/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="onlineparking/js/bootbox.min.js"></script><!-- 确认窗口 -->
		
		<script type="text/javascript" src="onlineparking/js/jquery-ui-1.10.2.custom.min.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.ui.touch-punch.min.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.slimscroll.min.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.easy-pie-chart.min.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.sparkline.min.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.flot.min.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.flot.pie.min.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.flot.resize.min.js"></script>  
		<!-- 引入 -->
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript">
			
		var data = {"result":"1"} ;
		$(top.hangge());
		</script>
		
		<script type="text/javascript">
			$(function() {
				
				//下拉框
				$(".chzn-select").chosen(); 
				$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
				
				//日期框
				$('.date-picker').datepicker();
				
				//复选框
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
				
			});
		
		
		//导出excel
		function toExcel(){
			var year = $("#Year").val() ;
			var month = $("#Month").val() ;
			var quarter = $("#Quarter").val() ;
			var uID = $("#uID").val() ;
			var FLAG = $("#FLAG").val() ;
			window.location.href='/OnlineParking/exportExcel?year='+year+'&month='+month+'&quarter='+quarter+'&userID='+uID+'&FLAG='+FLAG;
		}
		</script>
		
	</body>
</html>

