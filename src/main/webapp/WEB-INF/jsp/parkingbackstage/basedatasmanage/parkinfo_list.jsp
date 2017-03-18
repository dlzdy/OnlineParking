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
	<link href="system/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="system/css/font-awesome.min.css" />
	<link rel="stylesheet" href="system/css/chosen.css" />
	<link rel="stylesheet" href="system/css/ace.min.css" />
	<link rel="stylesheet" href="system/css/ace-skins.min.css" />
	<link rel="stylesheet" href="plugins/paginate/css/lanrenzhijia.css" /> <!-- 分页样式 -->
	<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="plugins/paginate/js/jquery.paginate.js"></script><!--分页-->
	<link rel="stylesheet" href="system/css/datepicker.css" /><!-- 日期框 -->
	<script type="text/javascript" src="utiljs/tools.js"></script>
	<script type="text/javascript">
	
	 var allParkInfo = ${allParkInfo} ;
	//alert(allParkInfo.datas.length) ;
	$(function(){
		/* for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
			for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
				$("#parkInfoId").append("<option value='"+allParkInfo.datas[i].parkingInfoId+"'>"+allParkInfo.datas[i].parkingInfoName+"</option>");
			}
		} */
		if(allParkInfo.result=="0"){
			var html = "" ;
			html+="<tr>" ;
			html+="<td colspan=\"10\" class='center'>暂无数据 </td>" ;
			html+="</tr>" ;
			$("#t_datas").html(html) ;
			$("#page").html("") ;
			return false ;
		}
		
		getDataList(allParkInfo) ;
		getPaginate( allParkInfo.datas.pages) ;
		//获取分页信息
		//$("#page").html(getPage(allParkInfo)) ;
		//设置页码被选中的样式					
		//$("#page li:eq("+allParkInfo.datas.pageNum+")").addClass("active");   
		
	 }) ;
	
	function getDataList(allParkInfo){
		var html = "" ;
		for(var i = 0 ; i < allParkInfo.datas.result.length ; i ++){
			html += "<tr>"  ;
			html += "<td class='center'></td>" ;
		/* 	html+="<td class='center' style=\"display:none\">"+allParkInfo.datas[i].parkingInfoId+"</td>"; */
			html+="<td class='center'>"+allParkInfo.datas.result[i].parkingInfoName+"</td>";
			if(allParkInfo.datas.result[i].parkingInfoAddress==null){
				html+="<td class='center'></td>";
			}else{
				html+="<td style='text-align:left'>"+allParkInfo.datas.result[i].parkingInfoAddress+"</td>";
			}
			html+="<td class='center'>"+allParkInfo.datas.result[i].parkingInfoLongitude+"</td>";
			html+="<td class='center'>"+allParkInfo.datas.result[i].parkingInfoLatitude+"</td>";
			html+="<td class='center'>"+allParkInfo.datas.result[i].parkingInfoParkingSpaces+"</td>";
			html+="<td class='center'>"+allParkInfo.datas.result[i].parkingInfoRestParkingSpaces+"</td>";
			if(allParkInfo.datas.result[i].parkingInfoState=="enable"){
				html+="<td class='center'>可用</td>";
			}else{
				html+="<td class='center'>不可用</td>";
			}
			html+="<td class='center'>"+allParkInfo.datas.result[i].parkingInfoCreateTime+"</td>";
			/* html+="<td class='center' style=\"display:none\">"+allParkInfo.datas.result[i].parkingInfoCreateManagerType+"</td>";
			html+="<td class='center' style=\"display:none\">"+allParkInfo.datas.result[i].parkingInfoCreateManagerId+"</td>"; */
			html+="<td style=\"width: 30px;\" class=\"center\">";
			html+="<div class='hidden-phone visible-desktop btn-group'>";
			html+="<div class=\"inline position-relative\">";
			html+="<button class=\"btn btn-mini btn-info\" data-toggle=\"dropdown\"><i class=\"icon-cog icon-only\"></i></button>";
			html+="<ul class=\"dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close\">";
			html+="<li><a style=\"cursor:pointer;\" title=\"编辑\" onclick=\"edit('"+allParkInfo.datas.result[i].parkingInfoId+"');\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"green\"><i class=\"icon-edit\"></i></span></a></li>";
			html+="<li><a style=\"cursor:pointer;\" title=\"删除\" onclick=\"del('"+allParkInfo.datas.result[i].parkingInfoId+"');\" class=\"tooltip-error\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"red\"><i class=\"icon-trash\"></i></span> </a></li>";
			html+="</ul>";
			html+="</div>";
			html+="</div>";
			html+="</td>";
		    html += "</tr>" ;
		}
		//动态获取行号
		 setRowNumByJSON(allParkInfo,'t_datas',html) ;
	}
	
		
	</script>
	</head>
<body onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
		<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> 首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>基础数据维护<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">停车场信息管理</li>
		</ul>
	</div><!--#breadcrumbs-->				
  <div class="row-fluid">
	<div class="row-fluid">
		<table>
				<tr>
					
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="parkingInfoName" maxlength="200" placeholder="这里输入停车场名称" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="parkingInfoAddress" maxlength="200" placeholder="这里输入停车场地址" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="parkingInfoState" id="parkingInfoState" data-placeholder="请选择停车场状态" style="vertical-align:top;">
					  	<option value="">请选择停车场状态</option>
					  	<option value="enable">可用</option>
					  	<option value="disable">不可用</option>
					  	</select>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
			<!-- 检索  -->
	 	<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
					    <th class="center" style="width:30px"></th>
						<!-- <th class="center" style="display:none">停车场id</th> --><!-- parkingInfoId -->
						<th class="center" >停车场名称</th><!-- parkingInfoName -->
						<th class="center" >停车场地址</th><!-- parkingInfoAddress -->
						<th class="center" >停车场经度</th><!-- parkingInfoLongitude -->
						<th class="center" >停车场纬度</th><!-- parkingInfoLatitude -->
						<th class="center" >停车场车位数</th><!-- parkingInfoParkingSpaces -->
						<th class="center" >停车场 剩余 车位数</th><!-- parkingInfoRestParkingSpaces -->
						<th class="center" >停车场状态</th><!-- parkingInfoState -->
						<th class="center" >停车场注册日期</th><!--  parkingInfoCreateTime-->
					<!-- 	<th class="center" style="display:none">停车场信息改动人员类型</th> --><!-- parkingInfoCreateManagerType -->
						<!-- <th class="center" style="display:none">停车场信息改动人员id</th> --><!-- parkingInfoCreateManagerId -->
						<th class="center">操作</th>
					</tr>
				</thead>
				<tbody id="t_datas">
					<tr>
						<td colspan="10" class="center">暂无数据</td>
					</tr>
				</tbody>
			</table>
			<div class="page-header position-relative">
				<table style="width:100%;">
					<tr>
						<td style="vertical-align:top;">
							<a class="btn btn-small btn-success" onclick="add();">新增</a>
						</td>
					</tr><tr>
						 <td style="vertical-align:top;" id="page">
					 
						</td> 
					</tr>
				</table>
			</div>
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
		
		$("#parkingInfoState").change(function(){
			search(1);
		});
		
		function find() {
			giveNum() ;
			search(1) ;
		}
	
		//检索
		function search(type){
			top.jzts();
			var parkingInfoName = $("input[name='parkingInfoName']").val().trim() ;
			var parkingInfoAddress = $("input[name='parkingInfoAddress']").val().trim() ;
			var parkingInfoState = $("#parkingInfoState").val() ;
			var currentPage = $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			//alert("currentPage:"+currentPage+";pageSize:"+pageSize) ;
			var jsonstr = {"parkingInfoName":parkingInfoName,"parkingInfoAddress":parkingInfoAddress,"parkingInfoState":parkingInfoState,"currentPage":currentPage,"pageSize":"20"} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectParkInfo',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(allParkInfo){
					if(allParkInfo.datas.total=="0"){
						var html = "" ;
						html += "<tr>" ;
						html += "<td  colspan=\"10\" class=\"center\">暂无数据</td>" ;
						html += "</tr>" ;
						$("#t_datas").html(html) ; 
						$("#page").html("") ;
						return false ;
					}
					$("#currentPage").val(allParkInfo.datas.pageNum) ;
					$("#pageSize").val(allParkInfo.datas.pageSize) ;
					getDataList(allParkInfo) ;
					//获取分页信息
					if(type!="paginate"){
						getPaginate( allParkInfo.datas.pages) ;
					}
					//设置页码被选中的样式					
					$("#page li:eq("+allParkInfo.datas.pageNum+")").addClass("active");  
				}
			}) ;
		}
		
		//新增 by xumingyue
		function add(){
			
			if(!checkInvalid()){return false} ; //判断session是否失效 
			
 			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toAddParkInfo';
			 diag.Width = 450;
			 diag.Height =600;
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
		
		//停车场停车场ID  删除停车场
		function del(parkingInfoId){
			var jsonstr = {"parkingInfoId":parkingInfoId} ;
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					var url = "/OnlineParking/delParkInfo";
					$.ajax({
						type:"post" ,
						url:url ,
						data:$.toJSON(jsonstr),
						dataType:'json',
						contentType : 'application/json',
						success:function(data){
							 top.jzts();
							 setTimeout("self.location=self.location",100);
						}
					}) ;
				}
			});
		}
		//停车场停车场ID  更新 停车场 信息 
		function edit(parkInfoId){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = '/OnlineParking/toEditParkInfo?parkInfoId='+parkInfoId;
			 diag.Width = 450;
			 diag.Height =600;
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
		
		$(function() {
			
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
		});
		</script>
	</body>
</html>

