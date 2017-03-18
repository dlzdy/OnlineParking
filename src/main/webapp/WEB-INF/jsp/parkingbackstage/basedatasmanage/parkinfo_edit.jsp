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
		<script type="text/javascript" src="system/js/systemjs/park-info-edit.js "></script>
		
<script type="text/javascript">
	 var parkInfo = ${parkInfo} ;
	 $(function(){
		 $("#parkingInfoId").val(parkInfo.datas.parkingInfoId);
		 $("#parkingInfoName").val(parkInfo.datas.parkingInfoName);
		 $("#parkingInfoLongitude").val(parkInfo.datas.parkingInfoLongitude);
		 $("#parkingInfoLatitude").val(parkInfo.datas.parkingInfoLatitude);
		 $("#parkingInfoAddress").val(parkInfo.datas.parkingInfoAddress);
		 $("#parkingInfoState").val(parkInfo.datas.parkingInfoState);
		 $("#parkingInfoParkingSpaces").val(parkInfo.datas.parkingInfoParkingSpaces);
		 $("#parkingInfoRestParkingSpaces").val(parkInfo.datas.parkingInfoRestParkingSpaces);
	 }) ;
	
</script>
<style type="text/css">
	.chzn-container-single{
		width:332px!important ;
	}

</style>
	</head>
<body>
		<input type="hidden" name="parkingInfoCreateManagerType" id="parkingInfoCreateManagerType" value="1"/><!--  1 后台管理员 2 停车场场主管理员 -->
		<input type="hidden" name="parkingInfoCreateManagerId" id="parkingInfoCreateManagerId" value="1"/>
		<input type="hidden" name="parkingInfoId" id="parkingInfoId" />
		<div id="zhongxin" style="margin-top:35px">
			<table id="table_report2" class="table table-striped table-bordered table-hover">
			<tbody>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">停车场名称:</td>
				<td><input style="width:95%;" type="text" name="parkingInfoName" id="parkingInfoName" value="" maxlength="500" placeholder="请输入车场名称" title=""></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">经度:</td>
				<td><input style="width:95%;" type="text" name="parkingInfoLongitude" id="parkingInfoLongitude" value="" maxlength="50" placeholder="请输入经纬度" title=""></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">纬度:</td>
				<td><input style="width:95%;" type="text" name="parkingInfoLatitude" id="parkingInfoLatitude" value="" maxlength="50" placeholder="请输入经纬度" title=""></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">地址:</td>
				<td><input style="width:95%;" type="text" name="parkingInfoAddress" id="parkingInfoAddress" value="" maxlength="200" placeholder="请输入地址" title=""></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">营业状态:</td>
				</td>
					 <td style="vertical-align:top;"> 
						<select class="chzn-select" id="parkingInfoState" data-placeholder="请选择工作状态" style="vertical-align:top;">
					  	<option value="enable">可用</option>
						<option value="disable">不可用</option>
					  	</select>
					</td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">总车位数:</td>
				<td><input style="width:95%;" type="text" name="parkingInfoParkingSpaces" id="parkingInfoParkingSpaces" value="" maxlength="50" placeholder="请输入总车位数" title=""></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">现有车位数:</td>
				<td><input style="width:95%;" type="text" name="parkingInfoRestParkingSpaces" id="parkingInfoRestParkingSpaces" value="" maxlength="50" placeholder="请输入现有车位数" title=""></td>
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
			
			//日期框
			/* $('.date-picker').datepicker(); */
			
		});
		
		</script>
</body>
</html>