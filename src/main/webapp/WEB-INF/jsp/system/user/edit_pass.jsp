<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="onlineparking/css/bootstrap.min.css" rel="stylesheet" />
		<link href="onlineparking/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link href="onlineparking/css/font-awesome.min.css" rel="stylesheet" />
		<!-- 下拉框 -->
		<!-- <link rel="stylesheet" href="static/css/chosen.css" /> -->
		
		<link rel="stylesheet" href="onlineparking/css/ace.min.css" />
		<link rel="stylesheet" href="onlineparking/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="onlineparking/css/ace-skins.min.css" />
		
		<!-- <link rel="stylesheet" href="static/css/datepicker.css" /> --><!-- 日期框 -->
		<script type="text/javascript" src="onlineparking/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script><!-- 字符串转化成json -->
		<script type="text/javascript" src="onlineparking/js/onlineparking/sys-user-edit-pass.js"></script><!-- 字符串转化成json -->
		
<style type="text/css">
	#zhongxin{
		margin-top:40px ;
	}
</style>
		
<script type="text/javascript">
	
	//加载页面时从后台去数据显示在界面
	var user = ${user} ;
	$(function(){
		$("#parkingManagerId").val(user.datas.parkingManagerId) ;
		$("#parkingManagerPhone").val(user.datas.parkingManagerPhone) ;
		$("#parkingManagerPsd").val(user.datas.parkingManagerPsd) ;
		$("#myParkingManagerPsd").val("") ;
	});	

	//隐藏 窗口
	function hideF(){
		$("#zhongxin").hide();
		top.Dialog.close();
	}
</script>
	</head>
<body>

		<input type="hidden" name="parkingManagerId" id="parkingManagerId" value=""/><!-- 主用户id -->
		<input type="hidden" name="parkingManagerPsd" id="parkingManagerPsd" value=""/><!-- 原始密码 -->
		<div id="zhongxin" >
		
		<table id="table_report" class="table table-striped table-bordered table-hover" style="width:100%;">
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" readonly="readonly">手机号:</td>
				<td><input style="width:95%;" type="text" name="parkingManagerPhone" id="parkingManagerPhone" value="" maxlength="12" readonly="readonly"  /></td>
			</tr>
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" >原始密码:</td>
				<td><input style="width:95%;" type="password" name="myParkingManagerPsd" id="myParkingManagerPsd" value="" maxlength="20" onblur="checkMyPsd();" /></td>
			</tr>
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;">新密码:</td>
				<td><input style="width:95%;" type="password" name="newParkingManagerPsd" id="newParkingManagerPsd" value="" maxlength="20" onblur="checkNewPsd();" /></td>
			</tr>
			
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" >重复密码:</td>
				<td><input style="width:95%;" type="password" name="reParkingManagerPsd" id="reParkingManagerPsd" onblur="checkRePsd();" /></td>
			</tr>
		</table>
		
		 <table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
				</td>
			</tr>
		</table> 
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="onlineparking/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='onlineparking/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="onlineparking/js/bootstrap.min.js"></script>
		<script src="onlineparking/js/ace-elements.min.js"></script>
		<script src="onlineparking/js/ace.min.js"></script>
		<!-- <script type="text/javascript" src="static/js/chosen.jquery.min.js"></script> --><!-- 下拉框 -->
		<!-- <script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script> --><!-- 日期框 -->
		<script type="text/javascript">
		$(top.hangge());
		/* $(function() {
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
		}); */
		
		</script>
</body>
</html>