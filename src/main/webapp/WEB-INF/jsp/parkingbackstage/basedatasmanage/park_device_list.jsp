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
	<meta charset="utf-8" />
	<title></title>
	<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="system/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="system/css/font-awesome.min.css" />
	<link rel="stylesheet" href="system/css/chosen.css" />
	<link rel="stylesheet" href="system/css/ace.min.css" />
	<link rel="stylesheet" href="system/css/ace-skins.min.css" />
	<link rel="stylesheet" href="plugins/paginate/css/lanrenzhijia.css" /> <!-- 分页样式 -->
	<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="plugins/paginate/js/jquery.paginate.js"></script><!--分页-->
	<link rel="stylesheet" href="system/css/datepicker.css" /><!-- 日期框 -->
	<script type="text/javascript" src="system/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
	
	<script type="text/javascript">
	$(function(){
		var allParkInfo = ${allParkInfo} ;
		for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
			for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
				$("#parkInfoId").append("<option value='"+allParkInfo.datas[i].parkingInfoId+"'>"+allParkInfo.datas[i].parkingInfoName+"</option>");
			}
		}
		/* getDataList(devices) ; */ //1版去掉 ： 进入界面查询全部 
	}) ;
		
		
	</script>
	</head>
<body onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">
<div id="page-content" class="clearfix">
		<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i>首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>基础数据维护<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">停车场设备管理</li>
		</ul>
	</div><!--#breadcrumbs-->

  <div class="row-fluid">
      
	<div class="row-fluid">
			<table>
				<tr>
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="parkInfoId" id="parkInfoId" data-placeholder="请选择停车场" style="vertical-align:top;">
					  	<option value="">请选择停车场</option>
					  	</select>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="deviceId"  maxlength="100" placeholder="这里输入设备ID" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="name" maxlength="20" placeholder="这里输入姓名" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="phone" maxlength="11" placeholder="这里输入手机号" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
			<!-- 检索  -->
			<!-- </form> -->
			<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" style="width:30px"></th>
						<td class="center" style="display:none"></td>
						<th class="center">设备ID</th>
						<th class="center">所属停车场</th>
						<th class="center">可用状态</th>
						<th class="center">收费员姓名</th>
						<th class="center">收费员手机号</th>
						<th class="center">操作</th>
					</tr>
				</thead>
														
				<tbody id="t_datas">
					<tr>
						<td colspan="7" class="center">暂无数据</td>
					</tr>
				<!-- 	<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td class="center">
						<button class="btn btn-mini btn-danger" onclick="del();">解除绑定</button>
					</td> -->
				</tbody>
			</table>
		<div class="page-header position-relative">	
			 <div id="page"> </div>
		 </div>
		<!-- </form> -->
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
		<script type="text/javascript">window.jQuery || document.write("<script src='system/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="system/js/bootstrap.min.js"></script>
		<script src="system/js/ace-elements.min.js"></script>
		<script src="system/js/ace.min.js"></script>
		
		<script type="text/javascript" src="system/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="system/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="system/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		<script type="text/javascript" src="system/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript" src="system/js/jquery.json-2.4.js"></script><!--提示框-->
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
			var currentPage = $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var deviceId = $("input[name='deviceId']").val().trim() ;
			var name = $("input[name='name']").val().trim() ;
			var phone = $("input[name='phone']").val().trim() ;
			var parkInfoId = $("#parkInfoId").val() ;
			var jsonstr = {"parkInfoId":parkInfoId,"deviceId":deviceId,"name":name,"phone":phone,"currentPage":currentPage,"pageSize":"20"} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectSysParkDevice',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(devices){
					if(devices.datas.length==0){
						var html = "" ;
						 html += "<tr>" ;
						 html += "<td colspan=\"7\" class=\"center\">暂无数据</td>" ;
						 html += "</tr>" ;
						 $("#t_datas").html(html) ;
						 $("#page").html("") ;
						 return false ;
					}
					$("#currentPage").val(devices.datas.pageNum) ;
					$("#pageSize").val(devices.datas.pageSize) ;
					getDataList(devices) ;
					//分页信息
					if(type!="paginate"){
						getPaginate( devices.datas.pages) ;
					}
					//设置页码被选中的样式					
					$("#page li:eq("+devices.datas.pageNum+")").addClass("active");   				}
			}) ;
		}
		
		function getDataList(devices){
			var parkName = $("#parkInfoId").find("option:selected").text(); 
			var html = "" ;
			for(var i = 0 ; i < devices.datas.result.length ; i ++){
				html += "<tr>";
				html += "<td class='center'> </td>"
				html += "<td class='center' style='display:none'>"+devices.datas.result[i].handsetManagerId+"</td>"
				if(devices.datas.result[i].handsetId==""||devices.datas.result[i].handsetId==null){
					html += "<td class=\"center\">未绑定设备</td>";
				}else{
					html += "<td class=\"center\">"+devices.datas.result[i].handsetId+"</td>";
				}
				html += "<td class=\"center\">"+parkName+"</td>";
				if(devices.datas.result[i].handsetManagerActiveMark="enable"){
					html += "<td class=\"center\">可用</td>";
				}else{
					html += "<td class=\"center\">不可用</td>";
				}
				if(devices.datas.result[i].handsetManagerName==""||devices.datas.result[i].handsetManagerName==null){
					html += "<td class=\"center\">未填</td>";
				}else{
					html += "<td class=\"center\">"+devices.datas.result[i].handsetManagerName+"</td>";
				}
				
				html += "<td class=\"center\">"+devices.datas.result[i].handsetManagerPhone+"</td>";
				html += "<td class=\"center\">";
				if(devices.datas.result[i].handsetId==""||devices.datas.result[i].handsetId==null){
					html += "<button class=\"btn btn-mini btn-danger\" title=\"删除\" onclick=\"del('"+devices.datas.result[i].handsetManagerId+"');\"><i class=\"icon-trash\"></i></button>";
				}else{
					html += "<button class=\"btn btn-mini btn-yellow\" title=\"解除绑定\" onclick=\"bound('"+devices.datas.result[i].handsetId+"','"+devices.datas.result[i].handsetManagerPhone+"');\"><i class=\"icon-flag\"></i></button>";
				}
				html += "</td> ";
				html += "</tr>";
			}
			//动态获取行号
			 setRowNumByJSON(devices,'t_datas',html) ;
		}
		
		//新增 by xumingyue
		function add(){
 			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toSystemAddStuff';
			 diag.Width = 300;
			 diag.Height = 380;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						 search() ;
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				} 
				diag.close();
			 };
			 diag.show();
		}
		
		//停车场通过员工id 删除该员工信息
		function del(handsetManagerId){
			var deviceId = $("input[name='deviceId']").val() ;
			var name = $("input[name='name']").val() ;
			var phone = $("input[name='phone']").val() ;
			var parkInfoId = $("#parkInfoId").val() ;
			var jsonstr = {"handsetManagerId":handsetManagerId,"deviceId":deviceId,
					"name":name,"phone":phone,"parkInfoId":parkInfoId} ;
			bootbox.confirm("确定要删除这条数据吗?", function(result) {
				if(result) {
					var url = "/OnlineParking/delSysParkDevice";
					if(!checkInvalid()){return false} ; //判断session是否失效 
					$.ajax({
						type:"post" ,
						url:url ,
						data:$.toJSON(jsonstr),
						dataType:'json',
						contentType : 'application/json',
						success:function(devices){
							 top.jzts();
							 search() ;
						}
					}) ;
				}
			});
		}
		//解除绑定
		
		function bound(handsetId,handsetManagerPhone){
			var deviceId = $("input[name='deviceId']").val() ;
			var name = $("input[name='name']").val() ;
			var phone = $("input[name='phone']").val() ;
			var parkInfoId = $("#parkInfoId").val() ;
			var jsonstr = {"handsetId":handsetId,"handsetManagerPhone":handsetManagerPhone,"deviceId":deviceId,
					"name":name,"phone":phone,"parkInfoId":parkInfoId} ;
			bootbox.confirm("确定要解除绑定吗?", function(result) {
				if(result) {
					var url = "/OnlineParking/delBoundSysParkDevice";
					if(!checkInvalid()){return false} ; //判断session是否失效 
					$.ajax({
						type:"post" ,
						url:url ,
						data:$.toJSON(jsonstr),
						dataType:'json',
						contentType : 'application/json',
						success:function(devices){
							 top.jzts();
							 search() ;
						}
					}) ;
				}
			});
		}
		</script>
		
		<script type="text/javascript">
		
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

