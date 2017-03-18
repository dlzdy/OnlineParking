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
		<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script>
		<script type="text/javascript" src="onlineparking/js/onlineparking/park-parkinfo-form-edit.js"></script>
		
<script type="text/javascript">

//页面加载 通过费用表单id  从后台获取该表单信息
	var chargerStandardInfo = ${chargerStandardInfo} ;
		$(function(){
			//alert(chargerStandardInfo) ;
			$("#chargingStandardsId").val(chargerStandardInfo.datas.chargingStandardsId) ;
			$("#parkingInfoId").val(chargerStandardInfo.datas.parkingInfoId) ;
			$("#chargingStandardsState").val(chargerStandardInfo.datas.chargingStandardsState) ;
			$("#chargingStandardsStepStart").val(chargerStandardInfo.datas.chargingStandardsStepStart) ;
			$("#chargingStandardsStepEnd").val(chargerStandardInfo.datas.chargingStandardsStepEnd) ;
			$("#chargingStandardsStep").val(chargerStandardInfo.datas.chargingStandardsStep) ;
			$("#chargingStandardsPrise").val(chargerStandardInfo.datas.chargingStandardsPrise) ;
	}) ;


</script>
	</head>
<body>
        <input type="hidden" value="<%=session.getAttribute("uID") %>" id="uID"/>
		<input type="hidden" name="chargingStandardsId" id="chargingStandardsId" /><!-- 停车场表单id-->
		<input type="hidden" name="parkingInfoId" id="parkingInfoId" /><!-- 停车场id-->
		<input type="hidden" name="chargingStandardsManagerType" id="chargingStandardsManagerType" value="2" /><!-- 更改人类型-->
		<input type="hidden" name="chargingStandardsState" id="chargingStandardsState" /><!-- 可用状态-->
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover" style="margin-top:20px">
		<thead>
			<tr>
		        <th class="center" style="display:none">操作人员ID</th>
				<!-- <th class="center">更改人类型</th>
				<th class="center">可用状态</th> -->
				<th class="center">阶梯值</th> 
				<th class="center">开始时间(分)</th>
				<th class="center">结束时间(分)</th>
				<th class="center">收费标准(元/时段)</th>
				<!-- <th class="center">操作</th> -->
			</tr>
		</thead>
		 	<tr>
		 	  	 <td style="display:none">
		 	   		<input style="width:95%;text-align:center;" type="text"  id="chargingStandardsManagerId" value="2" maxlength="100"/><!--1后台管理员id 2停车场场主管理员id  -->
			 	 </td>
			 	 <!-- <td>
			 	 	<input style="width:95%;" type="text" name="" id="chargingStandardsManagerType" value="停车场场主管理员" maxlength="2"/> 1后台管理员 2停车场场主管理员
			 	 </td>
				<td><select style="width:100%;" type="text" name="" id="chargingStandardsState" value="" maxlength="7" placeholder="">
					<option value="enable" >可用</option>
					<option value="disable">不可用</option>
				</select></td> -->
				  <td>
			   		<input type="text" placeholder="请输入" style="width:95%;text-align:center;float:left" id="chargingStandardsStep" maxlength="2" readonly="readonly">
			   	</td>
				<td>
					<input type="text" placeholder="请输入" style="width:95%;text-align:center;float:left" id="chargingStandardsStepStart" maxlength="5" readonly="readonly">
				</td>
			   <td>
			   		<input type="text" placeholder="请输入" style="width:95%;text-align:center;float:left" id="chargingStandardsStepEnd"  maxlength="5">
			   </td>
				<td>
					<input  type="text" placeholder="请输入" style="width:95%;text-align:center;" id="chargingStandardsPrise"maxlength="4" title=""/>
				</td>
			   <!-- 	<td>
			   	   <button class="btn btn-mini btn-info" title="添加收费标准"  onclick="add_tr(this)"><i class="icon-plus"></i></button>
			   		<button class="btn btn-mini btn-info" title="删除收费标准"  onclick="del_tr(this)"><i class="icon-minus"></i></button>
			   	</td> -->
		 	</tr>
		 	
		</table>
		<table id="table_report2" class="table table-striped table-bordered table-hover">
		   <tr>
		 		<td style="text-align: center;">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
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