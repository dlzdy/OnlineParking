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
		<script type="text/javascript" src="onlineparking/js/onlineparking/park-parkinfo-form-add.js"></script>
		
		<script type="text/javascript">
				var allForms = ${allForms} ;
				$(function(){
					if(allForms.result=="0"){
						$("#chargingStandardsStep").val("1"); //如果数据为空 ，收费阶梯值为1
						$("#chargingStandardsStepStart").val("0") ;//如果数据为空 ，开始时间为0
						return false ;
					}
					getDataList(allForms) ;
				}) ;
				
				function getDataList(allForms){
					var html = "" ;
					for(var i = 0 ; i < allForms.datas.length ; i ++){
						html+="<tr>" ;
						html+="<td class='center'>"+allForms.datas[i].chargingStandardsStep+"</td>" ;
						html+="<td class='center'>"+allForms.datas[i].chargingStandardsStepStart+"</td>" ;
						html+="<td class='center'>"+allForms.datas[i].chargingStandardsStepEnd+"</td>" ;
						html+="<td class='center'>"+allForms.datas[i].chargingStandardsPrise+"</td>" ;
						html+="</tr>" ;
					}
					$("#t_datas").html(html) ;
				}
		</script>
	</head>
<body>
		<input type="hidden" name="uID" id="uID" value="<%=session.getAttribute("uID")%>"/><!--用户ID -->
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
			<tbody id="t_datas">
			
			</tbody>
		 	<tr>
		 	  	 <td style="display:none">
		 	   		<input style="width:95%;text-align:center;" type="text"  id="chargingStandardsManagerId" value="2" maxlength="100"/><!--1后台管理员id 2停车场场主管理员id  -->
			 	 </td>
			 	 <input type="hidden" value="enable" id="chargingStandardsState"/>
			 	 <!-- <td>
			 	 	<input style="width:95%;" type="text" name="" id="chargingStandardsManagerType" value="停车场场主管理员" maxlength="2"/> 1后台管理员 2停车场场主管理员
			 	 </td>-->
	<!-- 			<td><select style="width:100%;" type="text" name="" id="chargingStandardsState" value="enable" maxlength="7" placeholder="请选择">
					<option value="enable" >可用</option>
					<option value="disable">不可用</option>
				</select></td>  -->
			   <td>
			   		<input type="text" placeholder="请输入" style="width:95%;text-align:center;float:left" id="chargingStandardsStep" maxlength="2" value="${maxStep }"  readonly="readonly">
			   	</td>
				<td>
					<input type="text" placeholder="请输入" style="width:95%;text-align:center;float:left" id="chargingStandardsStepStart" maxlength="5" value="${maxStepEnd}" readonly="readonly">
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