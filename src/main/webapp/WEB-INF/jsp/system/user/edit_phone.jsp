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
		<link href="onlineparking/css/font-awesome.min.css"  rel="stylesheet"/>
		<!-- 下拉框 -->
		<!-- <link rel="stylesheet" href="static/css/chosen.css" /> -->
		
		<link rel="stylesheet" href="onlineparking/css/ace.min.css" />
		<link rel="stylesheet" href="onlineparking/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="onlineparking/css/ace-skins.min.css" />
		
	<!-- 	<link rel="stylesheet" href="static/css/datepicker.css" /> --><!-- 日期框 -->
		<script type="text/javascript" src="onlineparking/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script><!-- 字符串转化成json -->
		<script type="text/javascript" src="onlineparking/js/onlineparking/sys-user-edit-phone.js"></script><!-- 字符串转化成json -->
		
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
	});	
		
	
	//提交 用户更换手机号码
	/* function save(){
		var  parkingManagerId = $("#parkingManagerId").val() ; 
		var  parkingManagerPhone = $("#parkingManagerPhone").val() ; //原始密码
		var newParkingManagerPhone = $("#newParkingManagerPhone").val() ; //新密码
		if(newParkingManagerPhone==""){
			$("#newParkingManagerPhone").tips({
				side:1,
	            msg:"请输入新手机号",
	            bg:'#AE81FF',
	            time:3
	        });
		   return false ;
		}else{
			var reg = /^[1][0-9]{10}$/ ;
			if(!reg.test(newParkingManagerPhone)){
				$("#newParkingManagerPhone").tips({
					side : 1,
					msg : '电话为以1开头的11位纯数字',
					bg : '#AE81FF',
					time : 3
				});
		 	 return false ;
			}
		}
		if(parkingManagerPhone==newParkingManagerPhone){
			 $("#newParkingManagerPhone").tips({
					side:1,
		            msg:"手机号没有改变，不可以修改",
		            bg:'#AE81FF',
		            time:3
		        });
			return false ;
		}
		var jsonstr = {"parkingManagerId":parkingManagerId,"parkingManagerPhone":newParkingManagerPhone}
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'modiUserPhone',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				 if("1" == data.result){
					 $("#zhongxin").tips({
							side:1,
				            msg:data.info,
				            bg:'#AE81FF',
				            time:3
				        });
					 setTimeout("hideF()",2000); 
				 }else if("0"==data.result){
					$("#zhongxin").tips({
						side:1,
			            msg:data.info,
			            bg:'#AE81FF',
			            time:3
			        });
					return false;
				 }
			}
		});
	} */
		//隐藏 窗口
		function hideF(){
			$("#zhongxin").hide();
			top.Dialog.close();
		}
    </script>
	</head>
    <body>

		<input type="hidden" name="parkingManagerId" id="parkingManagerId" value=""/><!-- 主用户id -->
		<div id="zhongxin" >
		<table id="table_report" class="table table-striped table-bordered table-hover" style="width:100%;">
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;">原始手机号：</td>
				<td><input style="width:95%;" type="text" name="parkingManagerPhone" id="parkingManagerPhone" value="" maxlength="12" readonly="readonly" /></td>
			</tr>
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" >新手机号：</td>
				<td><input style="width:95%;" type="text" name="newParkingManagerPhone" id="newParkingManagerPhone" value="" maxlength="12" onblur="checkNewPhone();" /></td>
			</tr>
			<tr>
			  <td style="width:90px;text-align: right;padding-top: 18px;" >验证码：</td>
			  <td><input type="text" id="verifycode" name="verifycode"  placeholder="验证码" style="width:60px;margin-top: 10px;"/>
			  <button id="checkBtn" class="btn btn-small btn-primary"   >获取验证码</button></td><!-- onclick="getCode();" -->
			</tr>
		</table>
		
	   <table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">提交</a>
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