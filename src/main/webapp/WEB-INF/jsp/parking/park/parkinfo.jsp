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
		<link rel="stylesheet" href="onlineparking/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="onlineparking/css/chosen.css" />
		
		<link rel="stylesheet" href="onlineparking/css/ace.min.css" />
		<link rel="stylesheet" href="onlineparking/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="onlineparking/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="onlineparking/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="onlineparking/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script>
		
<script type="text/javascript">

	$(function(){
	 var parkInfo = ${parkInfo} ;
	 //将停车场信息放在后台首页
		$("#indexInfo").html(parkInfo.datas.parkingInfoName) ;
//	 debugger ;
		$("#parkingInfoId").val(parkInfo.datas.parkingInfoId) ;
		$("#parkingInfoName").val(parkInfo.datas.parkingInfoName) ;
		$("#parkingInfoAddress").val(parkInfo.datas.parkingInfoAddress) ;
		$("#parkingInfoLongitude").val(parkInfo.datas.parkingInfoLongitude) ;
		$("#parkingInfoLatitude").val(parkInfo.datas.parkingInfoLatitude) ;
		$("#parkingInfoParkingSpaces").val(parkInfo.datas.parkingInfoParkingSpaces) ;
		$("#parkingInfoRestParkingSpaces").val(parkInfo.datas.parkingInfoRestParkingSpaces) ;
		var state = parkInfo.datas.parkingInfoState ;
		if(state=="enable"){
			$("#parkingInfoState").val("可用") ;
		}else if(state=="disable"){
			$("#parkingInfoState").val("不可用") ;
		}
		
		$("#parkingInfoCreateTime").val(parkInfo.datas.parkingInfoCreateTime) ;
		
	}) ;

</script>
	</head>
<body>


		
<div class="container-fluid" id="main-container">

<div id="page-content" class="clearfix">

		<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="tab.do" id="indexInfo"></a><span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>停车场管理<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">停车场信息</li>
		</ul>
		<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->	

						
  <div class="row-fluid">

	<div class="row-fluid">

	<form action="" name="Form" id="Form" method="post">
		<input type="hidden" name="parkingInfoId" id="parkingInfoId" value=""/><!-- 停车场ID -->
		<div id="zhongxin" >
		<table id="table_report" class="table table-striped table-bordered " style="width:100%;">
			<tr>
				<td>
					<ul class="unstyled spaced2">
						<li class="text-warning orange"><i class="icon-star blue"></i>
							停车场基本信息
						</li>
					</ul>
				</td>
			</tr>
		</table>
		<table id="table_report" class="table table-striped table-bordered " style="width:100%;">
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;" >停车场名称：</td>
				<td><input style="width:95%;" type="text" name="parkingInfoName" id="parkingInfoName" value=""  readonly="readonly"/></td>
				<td style="width:80px;text-align: right;padding-top: 13px;" >停车场地址：</td>
				<td><input style="width:95%;" type="text" name="parkingInfoAddress" id="parkingInfoAddress" value=""readonly="readonly" /></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;" >经度：</td>
				<td><input style="width:95%;" type="text" name="parkingInfoLongitude" id="parkingInfoLongitude" value="" readonly="readonly"/></td>
				<td style="width:80px;text-align: right;padding-top: 13px;">纬度：</td>
				<td><input style="width:95%;" type="text" name="parkingInfoLatitude" id="parkingInfoLatitude" value=""  readonly="readonly"/></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">总车位数：</td>
				<td><input style="width:95%;" type="text" name="parkingInfoParkingSpaces" id="parkingInfoParkingSpaces" value=""readonly="readonly"/></td>
				<td style="width:80px;text-align: right;padding-top: 13px;" >剩余车位：</td>
				<td><input style="width:95%;" type="text" name="parkingInfoRestParkingSpaces" id="parkingInfoRestParkingSpaces" value="" readonly="readonly"/></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">营业状态：</td>
				<td><input style="width:95%;" type="text" name="parkingInfoState" id="parkingInfoState" value=""readonly="readonly"/></td>
				<td style="width:105px;text-align: right;padding-top: 13px;">停车场注册日期：</td>
				<td><input style="width:95%;" type="text" name="parkingInfoCreateTime" id="parkingInfoCreateTime" value=""readonly="readonly"/></td>
			</tr>
		</table>
		<!-- <table id="table_report" class="table table-striped table-bordered table-hover" style="width:100%;">
			<tr>
				<td>
					<ul class="unstyled spaced2">
						<li class="text-warning orange"><i class="icon-star blue"></i>
							费用表单
						</li>
					</ul>
				</td>
			</tr>
		</table> -->
		<!-- <table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;"  readonly="readonly">费用ID:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="200" placeholder="" title=""/></td>
				<td style="width:80px;text-align: right;padding-top: 13px;"  readonly="readonly">时间范围:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="200" placeholder="" title=""/></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;"  readonly="readonly">费用额度:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="200" placeholder="" title=""/></td>
				<td style="width:80px;text-align: right;padding-top: 13px;"  readonly="readonly">车辆类型:</td>
				<td><select style="width:97%;" type="text" name="" id="" value="" maxlength="200" placeholder="" title="">
				<option value="" name="">车辆类型1</option>
				<option value="" name="">车辆类型2</option>
				</select></td>
			</tr>
		</table> -->
		<!-- <table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table> -->
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="onlineparking/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
	</form>
	
	</div>
  </div>
 </div>
 </div>
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='onlineparking/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="onlineparking/js/bootstrap.min.js"></script>
		<script src="onlineparking/js/ace-elements.min.js"></script>
		<script src="onlineparking/js/ace.min.js"></script>
		<script type="text/javascript" src="onlineparking/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="onlineparking/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
		});
		
		</script>
</body>
</html>