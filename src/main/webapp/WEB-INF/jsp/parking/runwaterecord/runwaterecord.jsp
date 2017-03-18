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
	<script type="text/javascript" src="utiljs/tools.js"></script>  
	<script type="text/javascript" src="plugins/datepakier/WdatePicker.js"></script>
	<script type="text/javascript" src="plugins/datepakier/lang/zh-cn.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script>
	<style type="text/css">
		.chzn-container{
			width:235px;
		}
		
		#table_report tr.trHeight td{
			padding: 0 8px;
		}
	</style>
	<script type="text/javascript">
		var pOrders = ${pOrders} ;//停车场所有表单信息 
		$(function(){
			var parkInfo = ${parkInfo} ; //停车场信息
			$("#indexInfo").html(parkInfo.datas.parkingInfoName); //获取停车场名称 (XXX停车场后台首页)
			$("#parkingInfoId").val(parkInfo.datas.parkingInfoId) ;
			getListDatas(pOrders) ;
			
		}) ;
		
		function getListDatas(pOrders){
			var html ="" ;
			for(var i = 0 ; i < pOrders.datas.length ; i++){
				html += "<tr>" ;
				html += "<td class='center'></td>" ;  
				html += "<td class='center'>"+pOrders.datas[i].parkingOrderId+"</td>";
				html += "<td class='center'>"+pOrders.datas[i].parkingOrderCarNo+"</td>";
				html += "<td class='center' style=\"display:none\">"+pOrders.datas[i].parkingOrderCarManageId+"</td>";
				html += "<td class='center'  style=\"display:none\">"+pOrders.datas[i].parkingOrderClientUserId+"</td>";
				if(pOrders.datas[i].parkingOrderCarEnterTime==""||pOrders.datas[i].parkingOrderCarEnterTime==null){
					html += "<td class='center'></td>";
				}else{
					html += "<td class='center'>"+pOrders.datas[i].parkingOrderCarEnterTime+"</td>";
				}
				if(pOrders.datas[i].parkingOrderCarExitTime==""||pOrders.datas[i].parkingOrderCarExitTime==null){
					html += "<td class='center'>停留中</td>";
				}else{
					html += "<td class='center'>"+pOrders.datas[i].parkingOrderCarExitTime+"</td>";
				}
				if(pOrders.datas[i].parkingOrderCarStayTime==""||pOrders.datas[i].parkingOrderCarStayTime==null){
					html += "<td class='center'>停留中</td>";
				}else{
					html += "<td class='center'>"+pOrders.datas[i].parkingOrderCarStayTime+"</td>";
				}
				
				if(pOrders.datas[i].parkingOrderParkingState=="quiet"){ 
					html += "<td class='center'>离开车场</td>";
				}else if(pOrders.datas[i].parkingOrderParkingState=="stay"){
					html += "<td class='center'>停留中</td>";
				}
				if(pOrders.datas[i].parkingOrderPayState=="NoPaid"){ 
					html += "<td class='center'><font color='red'>未完成支付</font></td>";
				}else if(pOrders.datas[i].parkingOrderPayState=="Paid"){
					html += "<td class='center'><font color='green'>已完成支付</font></td>";
				}
				if(pOrders.datas[i].parkingOrderCarNumberState=="1"){
					html += "<td class='center'>在管</td>";
					
				}else if(pOrders.datas[i].parkingOrderCarNumberState=="0"){
					html += "<td class='center'>非管</td>";
				}
				if(pOrders.datas[i].parkingOrderCost==""||pOrders.datas[i].parkingOrderCost==null){
					html += "<td class='center'></td>";
				}else{
					html += "<td class='center'>"+pOrders.datas[i].parkingOrderCost+"</td>";
				}
				
				html += "<td class='center' style=\"display:none\">"+pOrders.datas[i].parkingOrderHandSetId+"</td>";
				html += "<td class='center'  style=\"display:none\">"+pOrders.datas[i].parkingOrderHandsetManagerId+"</td>";
				html += "<td class='center' style=\"display:none\">"+pOrders.datas[i].parkingOrderParkingInfoId+"</td>";
				html += "<td class='center'>"+pOrders.datas[i].parkingOrderCreateTime+"</td>";
				html += "</tr>";
			}
			//通过table id 自动生成行号
			$("#t_data_list").html(html) ;
			   var len = $('#t_data_list tr').length;
		        for(var i = 0;i<len;i++){
		            $('#t_data_list tr:eq('+i+') td:first').text(i+1);
		        } 
		}
	
	</script>
	</head>
<body onkeydown="enterDown();">
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="tab.do" id="indexInfo"></a><span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>停车场管理<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">停车场订单记录</li>
		</ul>
		<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->	
  <div class="row-fluid">

	<div class="row-fluid">
			<input type="hidden" id="parkingInfoId"/>
			<!-- 检索  -->
			<table>
				<tr>
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="" id="payState" data-placeholder="请选择支付状态" style="vertical-align:top;">
					  	<option value="">请选择支付状态</option>
					  	<option value="Paid">已完成支付</option>
					  	<option value="NoPaid">未完成支付</option>
					  	</select>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="orderID" maxlength="50" placeholder="请输入订单号" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="stuffName" maxlength="20" placeholder="请输入收费员" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							 <input readonly="readonly" type="text" class="Wdate" id="startTime" placeholder="这里输入开始时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						</span>
					</td>
					<td>
						<span class="input-icon">
					 <input readonly="readonly" type="text" class="Wdate" id="endTime" placeholder="这里输入结束时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						</span>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="search();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr class="trHeight">
						<td colspan="3"></td>
						<td colspan="3" class='center'>时间</td>
						<td colspan="3" class='center'>状态</td>
						<td colspan="2"></td>
					</tr>
					<tr>
					    <th class="center" style="width:30px"></th>
						<th class="center">订单号</th><!-- parkingOrderId -->
						<th class="center">车牌号</th><!-- parkingOrderCarNo -->
						<th class="center" style="display:none">订单编号</th><!-- parkingOrderCarManageId -->
						<th class="center" style="display:none">订单客户端使用者id</th><!-- parkingOrderClientUserId  -->
						<th class="center">入场时间</th><!-- parkingOrderCarEnterTime  -->
						<th class="center">出场时间</th><!-- parkingOrderCarExitTime  -->
						<th class="center">停留时间</th> <!-- parkingOrderCarStayTime  -->
						<th class="center">停车状态</th><!-- parkingOrderParkingState  -->
						<th class="center">订单支付状态</th><!-- parkingOrderPayState  -->
						<th class="center">在管状态</th><!-- 该车辆不是Online停车平台在管车辆 是否被停车场管理 --><!-- parkingOrderCarNumberState --> 
						<th class="center">停车费用</th><!-- parkingOrderCost  -->
						<th class="center" style="display:none">车辆被识别时使用的手持机id</th><!-- parkingOrderHandSetId  -->
						<th class="center" style="display:none">停车场管理员id</th><!-- parkingOrderCarManageId  -->
						<th class="center" style="display:none">扫描车牌的手持机的管理员所属的停车场id</th><!-- parkingOrderParkingInfoId  -->
						<th class="center">创建时间</th><!-- parkingOrderCreateTime  -->
					</tr>
				</thead>
				<tbody id="t_data_list">
			
				</tbody>
			</table>
	</div>
 
 	<!-- <div class="page-header position-relative">
		<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
					<div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">
						<ul>
							<li><a>共<font color="red">1</font>条</a></li>
							<li>
								<input type="number" placeholder="页码" style="width:50px;text-align:center;float:left" id="toGoPage" value="">
							</li>
							<li style="cursor:pointer;"><a class="btn btn-mini btn-success" onclick="toTZ();">跳转</a></li>
							<li><a>首页</a></li>
							<li><a>上页</a></li>
							<li><a><font color="#808080">1</font></a></li>
							<li><a>下页</a></li>
							<li><a>尾页</a></li>
							<li><a>第一页</a></li>
							<li><a>共一页</a></li>
							<li>
							    <select onchange="changeCount(this.value)" style="width:55px;float:left;" title="显示条数">
									<option value="10">10</option>
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
									<option value="50">50</option>
									<option value="60">60</option>
									<option value="70">70</option>
									<option value="80">80</option>
									<option value="90">90</option>
									<option value="99">99</option>
								</select>
							</li>
						</ul>
					</div>
				</td>
			</tr>
		</table>
 	</div>
  -->
 
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
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript">
	
		
		//员工编辑
		function userEdit(){
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toAddStuff';
			 diag.Width = 300;
			 diag.Height = 450;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				} 
				diag.close();
			 };
			 diag.show();
		}
		
		
		$(top.hangge());
		

		//提交键与enter键绑定
		function enterDown(){
			var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
			 if(event.keyCode == 13){
				 search() ;
			 }
		}

		//
		$("#payState").change(function(){
			search();
		});
		
		//检索
		function search(){
			var parkingInfoId = $("#parkingInfoId").val() ;
			var orderID = $("input[name='orderID']").val() ;
			var stuffName = $("input[name='stuffName']").val() ;
			var startTime = $("#startTime").val() ;
			var endTime = $("#endTime").val() ;
			var payState = $("#payState").val() ;

			var jsonstr = {"parkingInfoId":parkingInfoId,"orderID":orderID,"stuffName":stuffName,"startTime":startTime,"endTime":endTime,"payState":payState} ;
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectRunWaterRecord',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(pOrders){
					 if(pOrders.result=="0"){
						 var html = "" ;
						 html +=" <tr><td  class=\"center\" colspan=\"11\">暂无数据 </td></tr>" ;
						 $("#t_data_list").html(html) ;
						 return false ;
					 }	
					getListDatas(pOrders) ;
				}
			}) ;
		}
		
		//新增
		function add(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toAddStuff';
			 diag.Width = 300;
			 diag.Height = 450;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				} 
				diag.close();
			 };
			 diag.show();
		}
		
		//删除
		function del(Id){
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					top.jzts();
					var url = "<%=basePath%>command/delete.do?COMMAND_ID="+Id+"&tm="+new Date().getTime();
					$.get(url,function(data){
						//nextPage(${page.currentPage});
					});
				}
			});
		}
		
		//修改
		function edit(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = "/OnlineParking/toEditDevice";
			 diag.Width = 300;
			 diag.Height = 450;
			 diag.CancelEvent = function(){ //关闭事件
				diag.close();
			 };
			 diag.show();
		}
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
		</script>
		
	</body>
</html>

