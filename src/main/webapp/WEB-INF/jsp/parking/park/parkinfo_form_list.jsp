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
	<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script>
	<style type="text/css">
		a{
			margin:4px ;
		}
	</style>
	<script type="text/javascript">
	//debugger ;
	 var parkName = '${parkName}';
	
	var chargeStandars = ${chargeStandars} ;//停车场收费表单列表
	var parkInfo = ${parkInfo} ; //停车场信息
	
	$(function(){
		 $("#indexInfo").html(parkInfo.datas.parkingInfoName); //获取停车场名称 (XXX停车场后台首页)
		 if(chargeStandars.result=="0"){
			 $("#page").html("") ;
				return false ;
		 }
  		 getDataList(chargeStandars);
  		//分页信息
		getPaginate(chargeStandars.datas.pages) ;
		//被点击页码的样式  
		$("#page li:eq("+chargeStandars.datas.pageNum+")").addClass("active");  
	});
	function getDataList(chargeStandars){
		var html = "" ;
		for(var i = 0 ; i < chargeStandars.datas.result.length ; i ++){
			html += "<tr>";
			html += "<td class='center'></td>" ; 
		/* 	html += "<td class='center' style=\"display: none\">"+ chargeStandars.datas.result[i].chargingStandardsId +"</td>"; */
			/* html += "<td class='center' >"+ parkInfo.datas.parkingInfoName +"</td>"; */
			html += "<td class='center' >"+ chargeStandars.datas.result[i].chargingStandardsStep +"</td>";
			html += "<td class='center' >"+ chargeStandars.datas.result[i].chargingStandardsStepStart +"</td>";
			html += "<td class='center' >"+ chargeStandars.datas.result[i].chargingStandardsStepEnd +"</td>";
			html += "<td class='center' >"+ chargeStandars.datas.result[i].chargingStandardsPrise +"</td>";
		/* 	html += "<td class='center' >"+ chargeStandars.datas.result[i].chargingStandardsCreateTime +"</td>"; */
			/* html += "<td class='center' style=\"display:none\">"+ chargeStandars.datas.result[i].chargingStandardsManagerType +"</td>"; *//* 收费标准更改人类型 */
			/* html += "<td class='center'  style=\"display: none\">"+ chargeStandars.datas.result[i].chargingStandardsManagerId +"</td>"; *//* 收费标准改动人员id */
			
		/* 	if(chargeStandars.datas.result[i].chargingStandardsState=="enable"){ *//*可用状态  */
				/* html += "<td class='center'  style=\"display: none\">可用</td>";
			}else{
				html += "<td class='center'  style=\"display: none\">不可用</td>";
			} */
			html += "<td style=\"width: 60px;\" class=\"center\">";
		/* 	html += "<div class='hidden-phone visible-desktop btn-group'>";
			html += "<div style = \"text-align:center\" class=\"inline position-relative\">";
			html += "<button class=\"btn btn-mini btn-info\" data-toggle=\"dropdown\"><i class=\"icon-cog icon-only\"></i></button>";
			html += "<ul class=\"dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close\">"; */
			html += "<a style=\"cursor:pointer;\" title=\"编辑\" onclick=\"edit('"+ chargeStandars.datas.result[i].chargingStandardsId +"');\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"green\"><i class=\"icon-edit\"></i></span></a>";
			if(i==chargeStandars.datas.result.length-1){
				html += "<a style=\"cursor:pointer;\" title=\"删除\" onclick=\"del('"+chargeStandars.datas.result[i].chargingStandardsId+"');\" class=\"tooltip-error\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"red\"><i class=\"icon-trash\"></i></span> </a>";
			}
	/* 		html += "</ul>";
			html += "</div>";
			html += "</div>"; */
			html += "</td>";
			html += "</tr>";
		}
		/* $("#t_data_list").html(html) ;
		sequenceTr('table_report') ;  *///动态获取表 行的序列号	 
		 setRowNumByJSON(chargeStandars,"t_data_list",html);
	}

	</script>
	
	</head>
<body>
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="icon-home"></i> <a href="tab.do" id="indexInfo"></a><span class="divider"><i class="icon-angle-right"></i></span></li>
				<li>停车场管理<span class="divider"><i class="icon-angle-right"></i></span></li>
				<li class="active">收费标准</li>
			</ul>
			<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->				
						
  <div class="row-fluid">

	<div class="row-fluid">
			<input type="hidden" value="<%=session.getAttribute("uID") %>" id="uID"/>
			<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<table id="table_report" class="table table-striped table-bordered table-hover">
				
				<thead>
					<tr>
					    <th class="center" style="width:30px"></th> 
						<!-- <th class="center" style="display: none">停车场收费标准id</th> -->
						<!-- <th class="center">所属停车场</th> -->
						<th class="center">阶梯值</th>
						<th class="center">开始时间(分)</th>
						<th class="center">结束时间(分)</th>
						<th class="center">收费标准(元/时段)</th>
						<!-- <th class="center" style="display:none">收费标准更改人类型</th>
						<th class="center"  style="display: none">收费标准改动人员id</th>
						<th class="center" style="display: none">可用状态</th> -->
						<th class="center">操作</th>
					</tr>
				</thead>
										
				<tbody id="t_data_list">
				<!-- 开始循环 -->	
					<tr><td  class="center" colspan="11">暂无数据 </td></tr>
				</tbody>
			</table>
			
		
		</form>
	</div>
 	
 	<div class="page-header position-relative">
			 	<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
					<a class="btn btn-small btn-success" onclick="add();">新增</a>
				</td>
				</tr><tr>
				<!-- 分页 -->
				<td style="vertical-align:top;" id="page">
				</td> 
			</tr>
		</table>
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
		<!-- 引入 -->
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript">
		
		$(top.hangge());
		//如果当前页和当前页条数为空 则给默认值
		function giveNum(){
				 $("#currentPage").val("1") ;
				 $("#pageSize").val("20") ;
		}
		//检索
		function search(){
			top.jzts();
			var uID = $("#uID").val() ;
			var currentPage = $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var jsonstr = {"uID":uID,"currentPage":currentPage,"pageSize":"20"} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectCostForm',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(chargeStandars){
					 if(chargeStandars.result=="0"){
						 var html = "" ;
						 html +=" <tr><td  class=\"center\" colspan=\"11\">暂无数据 </td></tr>" ;
						 $("#t_data_list").html(html) ;
						 $("#page").html("") ;
						 top.hangge() ;
						 return false ;
					 }	
					$("#currentPage").val(chargeStandars.datas.pageNum) ;
					$("#pageSize").val(chargeStandars.datas.pageSize) ;
					getDataList(chargeStandars) ;
					//被点击页码的样式  
					$("#page li:eq("+chargeStandars.datas.pageNum+")").addClass("active");  
					top.hangge() ;
				}
			}) ;
		}
		
		
		var diag = new top.Dialog();
		//新增设备界面 by xumingyue
		function add(){
			 top.jzts();
			 var uID = $("#uID").val() ;
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toAddChangStandards?uID='+uID;
			 diag.Width = 1200;
			 diag.Height = 300;
			 diag.CancelEvent = function(){ //关闭事件
			 	// if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						 search() ;
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				// } 
				diag.close();
			 };
			 diag.show();
		}
		
		//通过订单编号 id  删除 xumingyue
		function del(chargingStandardsId){
			var uID = $("#uID").val() ;
			var chargingStandardsId = chargingStandardsId ;
			var jsonstr = {"chargingStandardsId":chargingStandardsId} ;
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
				//	top.jzts();
				  
					var url = "/OnlineParking/delChargeStandardsById";
					if(!checkInvalid()){return false} ; //判断session是否失效 
					$.ajax({
						type:"post" ,
						url:url ,
						data:$.toJSON(jsonstr),
						dataType:'json',
						contentType : 'application/json',
						success:function(data){
							 search() ;
						}
					}) ;
				}
			});
		}
		
		
		//通过订单编号 id 编辑 xumingyue
		 function edit(chargingStandardsId){
			 top.jzts();
			// alert(top) ;
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = "/OnlineParking/toEditChangStandards?chargingStandardsId="+chargingStandardsId;
			 diag.Width = 1200;
			 diag.Height = 300;
			 diag.CancelEvent = function(){ //关闭事件
				 //if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
						/*  if('${page.currentPage}' == '0'){ */
							 top.jzts();
							 search() ;
						 /* }else{
							// nextPage(${page.currentPage});
						 } */
					// } 
					diag.close();
			 };
			 diag.show();
		} 
		
		 function add_tr(obj) {
			    var tr = $(obj).parent().parent();
			    tr.after(tr.clone());
			 }
			
		</script>
		
	</body>
</html>

