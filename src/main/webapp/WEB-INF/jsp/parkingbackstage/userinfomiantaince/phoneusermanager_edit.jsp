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
		<link href="system/css/bootstrap.min.css" rel="stylesheet" />
		<link href="system/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="system/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="system/css/chosen.css" />
		
		<link rel="stylesheet" href="system/css/ace.min.css" />
		<link rel="stylesheet" href="system/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="system/css/ace-skins.min.css" />
		
		<!-- <link rel="stylesheet" href="system/css/datepicker.css" /> --><!-- 日期框 -->
		<script type="text/javascript" src="plugins/datepakier/WdatePicker.js"></script>
		<script type="text/javascript" src="plugins/datepakier/lang/zh-cn.js"></script>
		
		<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="system/js/jquery.tips.js"></script>
		<script type="text/javascript" src="system/js/jquery.json-2.4.js "></script>
		<script type="text/javascript" src="system/js/systemjs/phoneusermanager-edit.js"></script>
	<style type="text/css">
	.chzn-container{
	 	width:235px !important;
	 }
	 .Wdate{
	 	width:240px ;
	 }
	</style>
	<script type="text/javascript">
		var phoneUser = ${phoneUser} ;
	    $(function(){
	    	$("#clientUserId").val(phoneUser.datas[0].clientUserId) ;
	    	$("#clientUserNickName").val(phoneUser.datas[0].clientUserNickName) ;
	    	$("#clientUserSex").val(phoneUser.datas[0].clientUserSex) ;
	    	$("#clientUserBirthday").val(phoneUser.datas[0].clientUserBirthday) ;/* phoneUser.datas[0].clientUserBirthday */
	    	$("#clientUserCellphone").val(phoneUser.datas[0].clientUserCellphone) ;
	    	$("#newClientUserCellphone").val(phoneUser.datas[0].clientUserCellphone) ;
	    	$("#clientUserAutoPay").val(phoneUser.datas[0].clientUserAutoPay) ;
	    	$("#clientUserSecurity").val(phoneUser.datas[0].clientUserSecurity) ;
	    }) ;
	</script>
	</head>
<body>
		<input type="hidden" id="clientUserId" value=""/><!-- 用户id -->
		<input type="hidden" id="clientUserSecurity"/><!-- 用户id -->
		<input type="hidden" id="clientUserCellphone" value=""/><!-- 手机号 -->
		<div id="zhongxin" style="margin-top:20px">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<table id="table_report2" class="table table-striped table-bordered table-hover">
			<tbody>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">昵称:</td>
				<td><input style="width:95%;" type="text" id="clientUserNickName"  maxlength="50" placeholder="请输入昵称" title=""></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">性别:</td>
				<td><select class="chzn-select" id="clientUserSex" data-placeholder="请选择性别" style="vertical-align:top;">
						<option value="">请选择性别</option>
					  	<option value="1">男</option>
					  	<option value="0">女</option>
					  	</select></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">生日:</td>
	<td><input readonly="readonly" type="text" class="Wdate"  id="clientUserBirthday"placeholder="这里输入生日" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日'})"/></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">手机号:</td>
				<td><input style="width:95%;" type="text" id="newClientUserCellphone" maxlength="11" placeholder="请输入手机号" title=""></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">自动支付:</td>
				<td><select class="chzn-select" id="clientUserAutoPay" data-placeholder="请选择是否自动支付" style="vertical-align:top;">
					  	<option value="">请选择是否自动支付</option>
					  	<option value="1">是</option>
					  	<option value="0">否</option>
					  	</select></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="system/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='system/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="system/js/bootstrap.min.js"></script>
		<script src="system/js/ace-elements.min.js"></script>
		<script src="system/js/ace.min.js"></script>
		<script type="text/javascript" src="system/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="system/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			 $(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
		});
		
		</script>
</body>
</html>