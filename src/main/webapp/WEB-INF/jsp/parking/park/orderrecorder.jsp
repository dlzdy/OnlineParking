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
	<link rel="stylesheet" href="plugins/paginate/css/lanrenzhijia.css" /> <!-- 分页样式 -->
	<script type="text/javascript" src="plugins/paginate/js/jquery.paginate.js"></script><!--分页-->
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
			if(pOrders.result=="0"){
				$("#page").html("") ;
				countHide(); //隐藏统计 该方法在jquery-1.7.2.js中
				return false ;
			}
			getListDatas(pOrders) ;
			//分页信息
			getPaginate(pOrders.datas.pages) ;
			//被点击页码的样式  
			$("#page li:eq("+pOrders.datas.pageNum+")").addClass("active");  
			countShow();//显示统计
			$("#costAll").html(getAll('t_data_list',9) ) ; //赋值
		}) ;
		
		function getListDatas(pOrders){
			var html ="" ;
			for(var i = 0 ; i < pOrders.datas.result.length ; i++){
				html += "<tr>" ;
				html += "<td class='center'></td>" ;  
				html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderId+"</td>";
				html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCarNo+"</td>";
				/* html += "<td class='center'></td>"; */
				/* html += "<td class='center' style=\"display:none\">"+pOrders.datas.result[i].parkingOrderCarManageId+"</td>";
				html += "<td class='center'  style=\"display:none\">"+pOrders.datas.result[i].parkingOrderClientUserId+"</td>"; */
				if(pOrders.datas.result[i].parkingOrderCarEnterTime==""||pOrders.datas.result[i].parkingOrderCarEnterTime==null){
					html += "<td class='center'></td>";
				}else{
					html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCarEnterTime+"</td>";
				}
				if(pOrders.datas.result[i].parkingOrderCarExitTime==""||pOrders.datas.result[i].parkingOrderCarExitTime==null){
					html += "<td class='center'>停留中</td>";
				}else{
					html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCarExitTime+"</td>";
				}
				if(pOrders.datas.result[i].parkingOrderCarStayTime==""||pOrders.datas.result[i].parkingOrderCarStayTime==null){
					html += "<td class='center'>停留中</td>";
				}else{
					html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCarStayTime+"</td>";
				}
				
				if(pOrders.datas.result[i].parkingOrderParkingState=="quiet"){ 
					html += "<td class='center'>离开车场</td>";
				}else if(pOrders.datas.result[i].parkingOrderParkingState=="stay"){
					html += "<td class='center'>停留中</td>";
				}
				if(pOrders.datas.result[i].parkingOrderPayState=="NoPaid"){ 
					html += "<td class='center'><font color='red'>未支付</font></td>";
				}else if(pOrders.datas.result[i].parkingOrderPayState=="Paid"){
					html += "<td class='center'><font color='green'>已支付</font></td>";
				}
				if(pOrders.datas.result[i].parkingOrderCarNumberState=="1"){
					html += "<td class='center'>注册</td>";
					
				}else if(pOrders.datas.result[i].parkingOrderCarNumberState=="0"){
					html += "<td class='center'>未注册</td>";
				}
				if(pOrders.datas.result[i].parkingOrderCost==""||pOrders.datas.result[i].parkingOrderCost==null){
					html += "<td class='center'>0</td>";
				}else{
					html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCost+"</td>";
				}
				if(pOrders.datas.result[i].parkingOrderPayCash=="1"){
					html += "<td class='center'>现金</td>";
				}else if(pOrders.datas.result[i].parkingOrderPayCash=="0"){
					html += "<td class='center'>非现金</td>";
				}
				 if(pOrders.datas.result[i].parkingOrderType=="0") {
					html += "<td class='center'><img src='system/images/shouchiji.png' title='手持机' style='width:25px'></td>";
				}else if(pOrders.datas.result[i].parkingOrderType=="1"){
					html += "<td class='center'><img src='system/images/zhagan.png' title='闸杆' style='width:25px'></td>";
				}else {
					html += "<td class='center'><img src='system/images/weixin.png' title='微信' style='width:25px'></td>";
				}
				/* html += "<td class='center' style=\"display:none\">"+pOrders.datas.result[i].parkingOrderHandSetId+"</td>";
				html += "<td class='center'  style=\"display:none\">"+pOrders.datas.result[i].parkingOrderHandsetManagerId+"</td>";
				html += "<td class='center' style=\"display:none\">"+pOrders.datas.result[i].parkingOrderParkingInfoId+"</td>"; */
				html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCreateTime+"</td>";
				html += "</tr>";
			}
			
	        //重写行号
	        setRowNumByJSON(pOrders,"t_data_list",html);
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
			<li class="active">订单记录</li>
		</ul>
		<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->	
  <div class="row-fluid">

	<div class="row-fluid">
			<input type="hidden" id="parkingInfoId"/>
			<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<!-- 检索  -->
			<table>
				<tr>
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="" id="payState" data-placeholder="请选择支付状态" style="vertical-align:top;">
					  	<option value="">请选择支付状态</option>
					  	<option value="Paid">已支付</option>
					  	<option value="NoPaid">未支付</option>
					  	</select>
					</td>
							<td style="vertical-align:top;"> 
						<select class="chzn-select" name="" id="parkingOrderType" data-placeholder="请选择订单类型" style="vertical-align:top;">
					  	<option value="">请选择订单类型</option>
					  	<option value="0">手持机</option>
					  	<option value="1">闸杆</option>
					  	<option value="2">微信</option>
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
							<input autocomplete="off" id="nav-search-input" type="text" name="carNo" maxlength="50" placeholder="请输入车牌号" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
				<!-- 	<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="stuffName" maxlength="20" placeholder="请输入收费员" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td> -->
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
						<td colspan="4"></td>
						<td colspan="3" class='center'>时间</td>
						<td colspan="3" class='center'>状态</td>
						<td colspan="4"></td>
					</tr>
					<tr>
					    <th class="center" style="width:30px"></th>
						<th class="center">订单号</th><!-- parkingOrderId -->
						<th class="center" style="width:70px">车牌号</th><!-- parkingOrderCarNo -->
						<!-- <th class="center">收费员姓名</th> --><!-- parkingOrderId -->
						<!-- <th class="center" style="display:none">订单编号</th> --><!-- parkingOrderCarManageId -->
						<!-- <th class="center" style="display:none">订单客户端使用者id</th> --><!-- parkingOrderClientUserId  -->
						<th class="center">入场时间</th><!-- parkingOrderCarEnterTime  -->
						<th class="center">出场时间</th><!-- parkingOrderCarExitTime  -->
						<th class="center">停留时间</th> <!-- parkingOrderCarStayTime  -->
						<th class="center">停车<br/>状态</th><!-- parkingOrderParkingState  -->
						<th class="center">订单支付<br/>状态</th><!-- parkingOrderPayState  -->
						<th class="center">在管<br/>状态</th><!-- 该车辆不是Online停车平台在管车辆 是否被停车场管理 --><!-- parkingOrderCarNumberState --> 
						<th class="center">停车费用</th><!-- parkingOrderCost  -->
						<th class="center">支付方式</th><!-- parkingPayCash  -->
						<th class="center">订单类型</th><!--0手持 1刀闸   。。。-->
						<!-- <th class="center" style="display:none">车辆被识别时使用的手持机id</th> --><!-- parkingOrderHandSetId  -->
						<!-- <th class="center" style="display:none">停车场管理员id</th> --><!-- parkingOrderCarManageId  -->
						<!-- <th class="center" style="display:none">扫描车牌的手持机的管理员所属的停车场id</th> --><!-- parkingOrderParkingInfoId  -->
						<th class="center">创建时间</th><!-- parkingOrderCreateTime  -->
					</tr>
				</thead>
				<tbody id="t_data_list">
						<tr><td class="center" colspan="12">暂无数据</td></tr>
				</tbody>
			</table>
	</div>
	<p style="display:none" id="count"><strong>累计停车费用：</strong><span id="costAll"></span></p>
 		<div class="page-header position-relative">
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
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript">
		$(top.hangge());
		//提交键与enter键绑定
		function enterDown(){
			var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
			 if(event.keyCode == 13){
				 search(1) ;
			 }
		}


	
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

		$("#payState").change(function(){
			giveNum() ;
			search(1);
		});
		
		$("#parkingOrderType").change(function(){
			search(1);
		});
		//检索
		function search(type){
			top.jzts();
			var currentPage = $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var parkingInfoId = $("#parkingInfoId").val() ;
			var orderID = $("input[name='orderID']").val().trim() ;
			var carNo = $("input[name='carNo']").val().trim() ;
			var stuffName = $("input[name='stuffName']").val() ;
			var startTime = $("#startTime").val() ;
			var endTime = $("#endTime").val() ;
			var payState = $("#payState").val() ;
			var parkingOrderType = $("#parkingOrderType").val() ; //订单类型
			var jsonstr = {"parkingInfoId":parkingInfoId,"orderID":orderID,"stuffName":stuffName,"startTime":startTime,"endTime":endTime,
					"payState":payState,"currentPage":currentPage,"pageSize":"20","parkingOrderType":parkingOrderType,"carNo":carNo} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
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
						 html +=" <tr><td  class=\"center\" colspan=\"13\">暂无数据 </td></tr>" ;
						 $("#t_data_list").html(html) ;
						 $("#page").html("") ;
						 countHide(); //隐藏统计 该方法在jquery-1.7.2.js中
						 top.hangge() ;
						 return false ;
					 }	
					$("#currentPage").val(pOrders.datas.pageNum) ;
					$("#pageSize").val(pOrders.datas.pageSize) ;
					getListDatas(pOrders) ;
					//分页信息
					if(type!="paginate"){
						getPaginate( pOrders.datas.pages) ;
					}
					
					//被点击页码的样式  
					$("#page li:eq("+pOrders.datas.pageNum+")").addClass("active");  
					 countShow();  //隐藏统计 该方法在jquery-1.7.2.js中
					 $("#costAll").html(getAll('t_data_list',9) ) ;
					top.hangge() ;
				}
			}) ;
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

