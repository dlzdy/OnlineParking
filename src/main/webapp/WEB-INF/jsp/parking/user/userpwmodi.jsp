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
		
<script type="text/javascript">
	
	
	//保存
	function save(){
		if($("#newPassWord").val()==""){
			$("#newPassWord").tips({
				side:2,
	            msg:'请输入新密码',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#newPassWord").focus();
			return false;
		}
		if($("#repeatPassWord").val()==""){
			$("#repeatPassWord").tips({
				side:2,
	            msg:'请再次输入密码',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#repeatPassWord").focus();
			return false;
		}
		//debugger ;
		var newPassWord = $("#newPassWord").val();
		var repeatPassWord = $("#repeatPassWord").val();
		//判断两次密码是否一致
		if(!(newPassWord==repeatPassWord)){
			$("#repeatPassWord").tips({
				side:2,
	            msg:'两次密码不一致',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#repeatPassWord").focus();
			return false;
		}
		var jsonstr = {"newPassWord" : newPassWord, "repeatPassWord" : repeatPassWord};
		$.ajax({
			type: "post",
			contentType : 'application/json',
			url:'updateUserPW',
	    	data:$.toJSON(jsonstr),
			dataType:'json',
			success: function(data){
				var result = data.result;
				 if("success" == result){
					 $("#userName").tips({
							side:1,
				            msg:'密码修改成功',
				            bg:'green',
				            time:3
				        });
				 }else{
					$("#userName").tips({
						side:1,
			            msg:'密码修改失败!',
			            bg:'red',
			            time:3
			        });
					return false;
				 }
			}
		});
		//hasK();
	}
	
	//输入的字段符合条件 提交表单  进行保存密码 
	function hasK(){
		
	}
	
</script>

	<style type="text/css">
		#table_report{
			margin-top: 10%;
    		margin-left: 30%;
		}
	</style>
	</head>
<body>

	<form action="" name="Form" id="Form" method="post">
		<div id="zhongxin" style="align:center">
		<table id="table_report"  style="width:50%;">
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">用户名:</td>
				<td><input style="width:50%;" type="text" name="" id="userName" value="<%=session.getAttribute("loginname") %>" maxlength="20" placeholder="" title="" /></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">新密码:</td>
				<td><input style="width:50%;" type="text" name="newPassWord" id="newPassWord" value="" maxlength="20" placeholder="请输入新秘密啊" title=""/></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">确认密码:</td>
				<td><input style="width:50%;" type="text" name="repeatPassWord" id="repeatPassWord" value="" maxlength="20" placeholder="请再次输入密码" title=""  /></td>
			</tr>
			
			<tr>
				<td></td>
				<td style="text-align: center;">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
				</td>
			</tr>
		</table>
		
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="onlineparking/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
	</form>
	
	
	
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