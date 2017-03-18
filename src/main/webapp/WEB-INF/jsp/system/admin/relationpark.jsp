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
		<link rel="stylesheet" href="onlineparking/css/chosen.css" /><!-- 下拉框 -->
		<link rel="stylesheet" href="onlineparking/css/ace.min.css" /><!-- 基于bootstrap的ui框架 -->
		<link rel="stylesheet" href="onlineparking/css/ace-responsive.min.css" /><!-- 基于bootstrap的ui框架 -->
		<script type="text/javascript" src="onlineparking/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script>
		<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script><!-- 字符串转化成json -->
		
	<style type="text/css">
		#zhongxin{
			margin-top:40px ;
		}
		
		
	</style>
		
	<script type="text/javascript">
		//加载页面时从后台去数据显示在界面
		var allParkInfo = ${allParkInfo}; 
		$(function(){
			addOption() ; //动态生成 将要关联的停车场 
		});
		
		function addOption(){
			for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
				$("#parkInfoId").append("<option value='"+allParkInfo.datas[i].parkingInfoId+"'>"+allParkInfo.datas[i].parkingInfoName+"</option>");
			}
		}
	</script>
	</head>
<body>
		<input type="hidden" name="userID" id="userID" value="<%=session.getAttribute("loginname") %>"/><!-- 主用户id -->
		<div id="zhongxin" >
		<table id="table_report" class="table table-striped table-bordered table-hover" style="width:100%;">
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" >停车场:</td>
				<td>
					<select id="parkInfoId">
					</select>
				</td>
			</tr>
		</table>
		
		 <table id="table_report2" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">关联</a><!-- 方法在本页 -->
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
		<script type="text/javascript">
		$(top.hangge());
		
		//关联停车场
		function save(){
			var parkInfoId = $("#parkInfoId").val() ;
			var userID = $("#userID").val() ;
			var jsonstr = {"parkInfoId":parkInfoId,"userID":userID} ;
			$.ajax({
				type: "post",
				url: 'relativPark',
				data:$.toJSON(jsonstr),
				dataType:'json',
				contentType : 'application/json',
				success:function(data){
					if(data.result=="1"){
						 $("#table_report2").tips({
								side:1,
					            msg:data.info,
					            bg:'#AE81FF',
					            time:3
					        });
						 window.parent.location.href ="/OnlineParking/index";
 						setTimeout(hideF(),5000) ;
						
					}else if(data.result=="0"){
						$("#table_report2").tips({
							side:1,
				            msg:data.info,
				            bg:'#AE81FF',
				            time:3
				        });
						return false;
					}
				}
			}) ;
		}
		
		//隐藏 窗口
		function hideF(){
		    $("#zhongxin").hide();
		    top.Dialog.close();
		}  
		
		$(function() {
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
		});
		
		</script>
</body>
</html>