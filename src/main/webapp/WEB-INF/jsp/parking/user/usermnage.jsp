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
		<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script><!-- 字符串转化成json -->
		
<style type="text/css">
	#zhongxin{
		margin-top:50px ;
	}
</style>
		
<script type="text/javascript">
	
	//加载页面时从后台去数据显示在界面
	var str = ${json} ;
	$(function(){
		$("#parkName").val(str.datas.parkName) ;
		
		
		//字段正则表达式判断
		//身份证 15或18位 数字 或 数字+字母
		 $("#IDCard").blur(function(){
			//正则表达式验证身份证格式 15位或18位，数字或数字+字母
			var IDCard = $("#IDCard").val() ;
		      if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(IDCard))) {
				$("#IDCard").tips({
					side:1,
		            msg:'身份证号格式不正确',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#IDCard").focus();
			}
		}) ; 
		//邮箱
		/* 验证邮箱
		验证规则：姑且把邮箱地址分成“第一部分@第二部分”这样
		第一部分：由字母、数字、下划线、短线“-”、点号“.”组成，
		第二部分：为一个域名，域名由字母、数字、短线“-”、域名后缀组成，
		而域名后缀一般为.xxx或.xxx.xx，一区的域名后缀一般为2-4位，如cn,com,net，现在域名有的也会大于4位 */
		$("#email").blur(function(){
			 var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/ ;
			 var email = $("#email").val() ;
			 if(!reg.test(email)){
				 $("#email").tips({
						side:1,
			            msg:'邮箱格式不正确 ',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#eamil").focus();
			 }
		});
		
		//手机号
		$("#phoneNumber").blur(function(){
			//手机号码以1开头的11位纯数字
			var phoneNumber = $("#phoneNumber").val() ;
			var reg = /^[1][0-9]{10}$/ ;
			if(!reg.test(phoneNumber)){
		 		$("#phoneNumber").tips({
					side : 1,
					msg : '电话为以1开头的11位纯数字',
					bg : '#AE81FF',
					time : 3
				});
		 	}
		});
		
	}); 
	
	
	//保存
	function save(){
		if($("#parkName").val()==""){
			$("#parkName").tips({
				side:1,
	            msg:'请输入停车场名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#parkName").focus();
			return false;
		}
		if($("#name").val()==""){
			$("#name").tips({
				side:1,
	            msg:'请输入场主姓名',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#name").focus();
			return false;
		}
		if($("#IDCard").val()==""){
			$("#IDCard").tips({
				side:1,
	            msg:'请输入身份证号',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#IDCard").focus();
			return false;
		}else{
			//正则表达式验证身份证格式 15位或18位，数字或数字+字母
			var IDCard = $("#IDCard").val() ;
			  if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(IDCard))) {
				$("#IDCard").tips({
					side:1,
		            msg:'身份证号格式不正确',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#IDCard").focus();
				return false;
			}
		}
		if($("#CompanyName").val()==""){
			$("#CompanyName").tips({
				side:1,
	            msg:'请输入公司名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#CompanyName").focus();
			return false;
		}
		if($("#state").val()==""){
			$("#state").tips({
				side:1,
	            msg:'请输入状态',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#state").focus();
			return false;
		}
		if($("#phoneNumber").val()==""){
			$("#phoneNumber").tips({
				side:1,
	            msg:'请输入手机号',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#phoneNumber").focus();
			return false;
		}else{
			//手机号码以1开头的11位纯数字
			var phoneNumber = $("#phoneNumber").val() ;
			var reg = /^[1][0-9]{10}$/ ;
			if(!reg.test(phoneNumber)){
		 		$("#phoneNumber").tips({
					side : 1,
					msg : '电话为以1开头的11位纯数字',
					bg : '#AE81FF',
					time : 3
				});
		 		return false ;
		 	}
		}

		if($("#eamil").val()==""){
			$("#eamil").tips({
				side:1,
	            msg:'请输入邮箱 ',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#eamil").focus();
			return false;
		}else{
			
			 var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/ ;
			 var email = $("#email").val() ;
			 if(!reg.test(email)){
				 $("#eamil").tips({
						side:1,
			            msg:'邮箱格式不正确 ',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#eamil").focus();
					return false; 
			 }
		}
	
		var jsonstr = {"email":"835575116@qq.com"} ;
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'saveUserInfo',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					 $("#zhongxin").tips({
							side:1,
				            msg:'保存成功!',
				            bg:'#AE81FF',
				            time:3
				        });
				 }else{
					$("#zhongxin").tips({
						side:1,
			            msg:'保存失败!',
			            bg:'#AE81FF',
			            time:3
			        });
					return false;
				 }
			}
		});
	}
	
</script>
	</head>
<body>

	<form action="" name="Form" id="Form" method="post">
		<input type="hidden" name="" id="" value=""/>
		<div id="zhongxin" >
		
		<table id="table_report" class="table table-striped table-bordered table-hover" style="width:100%;">
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;" maxlength="40">停车场名称:</td>
				<td><input style="width:95%;" type="text" name="parkName" id="parkName" value="" maxlength="40" placeholder="" title="" /></td>
				<td style="width:80px;text-align: right;padding-top: 13px;" >场主姓名:</td>
				<td><input style="width:95%;" type="text" name="" id="name" value="" maxlength="40" placeholder="" title=""  /></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">身份证号:</td>
				<td><input style="width:95%;" type="text" name="IDCard" id="IDCard" value="" maxlength="40" placeholder="" title=""/></td>
				<td style="width:80px;text-align: right;padding-top: 13px;">公司名称:</td>
				<td><input style="width:95%;" type="text" name="CompanyName" id="CompanyName" value="" maxlength="40" placeholder="" title=""/></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">状态:</td>
				<td><input style="width:95%;" type="text" name="state" id="state" value="" maxlength="40" placeholder="" title=""  /></td>
				<td style="width:80px;text-align: right;padding-top: 13px;" >手机号:</td>
				<td><input style="width:95%;" type="text" name="phoneNumber" id="phoneNumber" value="" maxlength="40" placeholder="" title=""  /></td>
			</tr>
			<tr>
				<td style="width:80px;text-align: right;padding-top: 13px;">邮箱:</td>
				<td><input style="width:95%;" type="text" name="email" id="email" value="" maxlength="40" placeholder="" title=""  /></td>
				<td style="width:80px;text-align: right;padding-top: 13px;"></td>
				<td></td>
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