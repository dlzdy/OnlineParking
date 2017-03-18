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
		<link href="onlineparking/css/font-awesome.min.css" rel="stylesheet"/>
		
		<link rel="stylesheet" href="onlineparking/css/ace.min.css" />
		<link rel="stylesheet" href="onlineparking/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="onlineparking/css/ace-skins.min.css" />
		<script type="text/javascript" src="onlineparking/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script><!-- 字符串转化成json -->
		
<style type="text/css">
	#zhongxin{
		margin-top:40px ;
	}
</style>
		
<script type="text/javascript">
	
 	$(function(){

 		//加载页面时从后台去数据显示在界面
 		var user = ${user} ;
 		var parkName = ${parkName} ;
		$("#parkingManagerId").val(user.datas.parkingManagerId) ;
		$("#parkingManagerPhone").val(user.datas.parkingManagerPhone) ;
		//$("#parkingManagerPsd").val(user.datas.parkingManagerPsd) ;
		$("#parkingInfoId").val(user.datas.parkingInfoId) ;
		$("#parkingInfoName").val(parkName.datas.parkingInfoName) ;
		$("#parkingManagerCreateTime").val(user.datas.parkingManagerCreateTime) ;
		//$("#parkingInfoId").vale(parkName.datas.)
		var mark = user.datas.parkingManagerActiveMark ;
		if(mark=="enable"){
			$("#parkingManagerActiveMark").val("可用") ;
		}
		if(mark=="disable"){
			$("#parkingManagerActiveMark").val("不可用") ;
		}
	
	});	
		
	
	//保存
	function save(){
		var  clientUserCellphone = $("#clientUserCellphone").val() ; 
		var  clientUserSex = $("#clientUserSex").val() ; 
		var  clientUserNickName =$("#clientUserNickName").val() ; 
		var  clientUserBirthday = $("#clientUserBirthday").val() ; 
		var clientUserCellphone = $("#clientUserCellphone").val() ; 
		var clientUserSignUpTime =  $("#clientUserSignUpTime").val() ; 
		var clientUserId = $("#clientUserId").val() ; 
		var jsonstr = {"clientUserCellphone":clientUserCellphone,
				"clientUserNickName":clientUserNickName,"clientUserSex":clientUserSex,"clientUserBirthday":clientUserBirthday,"clientUserCellphone":clientUserCellphone,
				"clientUserSignUpTime":clientUserSignUpTime,"clientUserId":clientUserId}
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'saveUser',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				 if("成功" == data.result){
					 $("#zhongxin").tips({
							side:1,
				            msg:'保存成功!',
				            bg:'#AE81FF',
				            time:3
				        });
					  setTimeout("hideF()",2000); 
				 }else if("失败"==data.result){
					$("#zhongxin").tips({
						side:1,
			            msg:'保存失败!',
			            bg:'#AE81FF',
			            time:3
			        });
					return false;
				 }
			},
			error:function(data){
				$("#zhongxin").tips({
					side:1,
		            msg:'保存失败!',
		            bg:'#AE81FF',
		            time:3
		        });
			}
		});
	}
	//隐藏 窗口
	function hideF(){
		$("#zhongxin").hide();
		top.Dialog.close();
	}
</script>
	</head>
<body>

		<input type="hidden" name="parkingManagerId" id="parkingManagerId" value=""/><!-- 主用户id -->
		<input type="hidden"  name="parkingInfoId" id="parkingInfoId" value="" maxlength="20"   />
		<div id="zhongxin" >
		
		<table id="table_report" class="table table-striped table-bordered table-hover" style="width:100%;">
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" readonly="readonly">手机号:</td>
				<td><input style="width:95%;" type="text" name="parkingManagerPhone" id="parkingManagerPhone" value="" maxlength="12" readonly="readonly"  /></td>
			</tr>
			<!-- <tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" readonly="readonly">密码:</td>
				<td><input style="width:95%;" type="password" name="parkingManagerPsd" id="parkingManagerPsd" value="" maxlength="20" readonly="readonly"  /></td>
			</tr> -->
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" readonly="readonly">关联停车场:</td>
				<td><input style="width:95%;" type="text" name="parkingInfoName" id="parkingInfoName" value="" maxlength="20" readonly="readonly"  /></td>
			</tr>
			
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" >注册日期:</td>
				<td><input style="width:95%;" type="text" name="parkingManagerCreateTime" id="parkingManagerCreateTime" readonly="readonly" /></td>
			</tr>
			
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" readonly="readonly">用户账号状态:</td>
				<td><input style="width:95%;" type="text" name="parkingManagerActiveMark" id="parkingManagerActiveMark" value="" maxlength="40" readonly="readonly"  /></td>
			</tr>
		</table>
		
		<!-- <table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
				</td>
			</tr>
		</table> -->
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="onlineparking/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='onlineparking/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="onlineparking/js/bootstrap.min.js"></script>
		<script src="onlineparking/js/ace-elements.min.js"></script>
		<script src="onlineparking/js/ace.min.js"></script>
		<script type="text/javascript">
			$(top.hangge());
		</script>
</body>
</html>