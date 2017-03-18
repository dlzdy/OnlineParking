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
		
		<link rel="stylesheet" href="system/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="system/js/jquery.tips.js"></script>
		<script type="text/javascript" src="system/js/jquery.json-2.4.js "></script>
		<script type="text/javascript" src="system/js/systemjs/park-stuff-add.js"></script>
		
		<script type="text/javascript">
			$(function(){
				var allParkInfo = ${allParkInfo} ;
				for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
					for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
						$("#parkInfoId").append("<option value='"+allParkInfo.datas[i].parkingInfoId+"'>"+allParkInfo.datas[i].parkingInfoName+"</option>");
					}
				}
			}) ;
		</script>
	</head>
<body>
		<div id="zhongxin" style="margin-top:35px">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<!-- <tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">用户名:</td>
				<td><input style="width:95%;" type="text" name="name" id="name" value="" maxlength="500" placeholder="请输入用户名" title=""/></td>
			</tr> -->
			<tr>
			<td style="width:100px;text-align: right;padding-top: 13px;">停车场:</td>
			<td style="vertical-align:top;"> 
			 	<select class="chzn-select" name="parkInfoId" id="parkInfoId" data-placeholder="请选择停车场" style="vertical-align:top;">
			  	</select>
			</td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">姓名:</td>
				<td><input style="width:95%;" type="text" name="name" id="name" value="" maxlength="10" placeholder="请输入姓名" title=""/></td>
			</tr>
			<!-- <tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">身份证:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="500" placeholder="请输入身份证" title=""/></td>
			</tr> -->
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">手机号:</td>
				<td><input style="width:95%;" type="text" name="handsetManagerPhone" id="handsetManagerPhone" value="" maxlength="11" placeholder="请输入手机号" /></td><!-- onblur="checkPhone();" -->
			</tr>
			<!-- <tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">工作状态:</td>
				<td style="vertical-align:top;"> 
				 	<select class="chzn-select" name="" id="" data-placeholder="请选择工作状态" style="vertical-align:top;width:246px;">
						<option value=""></option>
						<option value="1" >上班</option>
						<option value="2" >下班</option>
				  	</select>
				</td>
			</tr> -->
			<!-- <tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">银行卡号:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="500" placeholder="请输入银行卡号" title=""/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">设备ID:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="500" placeholder="请输入设备ID" title=""/></td>
			</tr> -->
			
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
			
			//日期框
			/* $('.date-picker').datepicker(); */
			
		});
		
		</script>
</body>
</html>