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
	
	
	//保存
	function save(){
			if($("#name").val()==""){
			$("#name").tips({
				side:3,
	            msg:'请输入姓名',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#name").focus();
			return false;
		}
		if($("#CONTENT").val()==""){
			$("#CONTENT").tips({
				side:3,
	            msg:'请输入内容',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#CONTENT").focus();
			return false;
		}
		if($("#BZ").val()==""){
			$("#BZ").tips({
				side:3,
	            msg:'请输入备注',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#BZ").focus();
			return false;
		}
		if($("#STATUS").val()==""){
			$("#form-field-radio1").tips({
				side:3,
	            msg:'请选择状态',
	            bg:'#AE81FF',
	            time:2
	        });
			return false;
		}
		hasK();
	}
	
	//判断关键词是否存在
	function hasK(){
		var KEYWORD = $("#KEYWORD").val();
		var TEXTMSG_ID = "${pd.TEXTMSG_ID}";
		$.ajax({
			type: "POST",
			url: '<%=basePath%>textmsg/hasK.do',
	    	data: {KEYWORD:KEYWORD,TEXTMSG_ID:TEXTMSG_ID,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					$("#Form").submit();
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				 }else{
					$("#KEYWORD").tips({
						side:3,
			            msg:'此关键词已存在(全局)!',
			            bg:'#AE81FF',
			            time:3
			        });
					return false;
				 }
			}
		});
	}
	
	function setType(value){
		$("#STATUS").val(value);
	}
</script>
	</head>
<body>
	<form action="" name="" id="" method="post">
		<input type="hidden" name="" id="" value=""/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">收费员ID:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="1111" readonly="readonly"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">姓名:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="500" placeholder="请输入姓名" title=""/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">手机号:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="500" placeholder="请输入手机号" title=""/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">密码:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="500" placeholder="请输入密码" title=""/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">卡号:</td>
				<td><input style="width:95%;" type="text" name="" id="" value="" maxlength="500" placeholder="请输入卡号" title=""/></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
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