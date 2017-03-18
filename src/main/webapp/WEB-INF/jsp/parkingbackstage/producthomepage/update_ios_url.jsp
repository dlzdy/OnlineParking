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
		<script src="system/js/systemjs/upload_util.js" type="text/javascript"></script>
		<script src="plugins/uploadify/jquery.uploadify.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="plugins/uploadify/uploadify.css">
	</head>
<body>
		<div id="zhongxin" style="margin-top:35px">
		<input type="hidden" name="username" id="username">
		<input type="hidden" name="iosVersionCode" id="iosVersionCode">
		<input type="hidden" name="iosVersionName" id="iosVersionName">
		<table id="table_report" class="table table-striped table-bordered table-hover">
		
			<tr>
			<td style="width:100px;text-align: right;padding-top: 13px;">版本号</td>
			<td style="vertical-align:top;"> 
			 	<input style="width:95%;" type="text" name="versionCode" id="versionCode" value="" maxlength="6" placeholder="请输入版本号" title=""/>
			</td>
			</tr>
			<tr>
			<td style="width:100px;text-align: right;padding-top: 13px;">版本名</td>
			<td style="vertical-align:top;"> 
			 	<input style="width:95%;" type="text" name="version" id="version" value="" maxlength="10" placeholder="请输入版本名" title=""/>
			</td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">更新内容</td>
				<td><textarea  rows="3" cols="20" type="text" name="content" id="content" value=""  placeholder="请输入更新内容" title=""></textarea></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">路径</td>
				<td style="text-align: center;" colspan="10">
					<input type="text" id="iosSrc">
				</td>
			</tr>
			<tr>
				
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="upIosSrc()">提交</a>
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
		
		function hideF(){
			$("#zhongxin").hide();
			top.Dialog.close() ;
		}
		
		//上传ios路径
		function upIosSrc(){
			if(!checkInvalid()){return false} ; //判断session是否失效 
			 var iosVersionCode = parseInt($("#iosVersionCode").val() );
			 var versionCode = parseInt($("#versionCode").val() );
			 var username = $("#username").val() ;
			 var version = $("#version").val() ;
			 var iosVersionName = $("#iosVersionName").val() ; //旧版本号
			 var content = $("#content").val() ;
			 var iosSrc = $("#iosSrc").val() ;
			 if(versionCode == "" || versionCode == null){
				 $("#versionCode").tips({
						side : 1,
						msg : '请输入版本号',
						bg : '#AE81FF',
						time : 3
					});
				 return false ;
			 }
			 var reg = /^[0-9]*[1-9][0-9]*$/ ;
			 if(!(reg.test(versionCode)&&iosVersionCode<versionCode)){
				 $("#versionCode").tips({
						side : 1,
						msg : '请输入大于'+iosVersionCode+'的版本号',
						bg : '#AE81FF',
						time : 3
					});
				 return false ;
			 }
			 if( !checkVersionName(version,iosVersionName,"version")){
				 return false ;
			 } 
			 if(content==""||content==null){
				 $("#content").tips({
						side : 1,
						msg : '请输入更新内容',
						bg : '#AE81FF',
						time : 3
					});
				 return false ;
			 }
			 if(iosSrc==""||iosSrc==null){
				 $("#iosSrc").tips({
						side : 1,
						msg : '请添加文件路径',
						bg : '#AE81FF',
						time : 3
					});
				 return false ;
			 }
			 var jsonstr = {'username':username,'versionCode':versionCode,'version':version,'content':content,'iosSrc':iosSrc} ;
			 $.ajax({
					type: "POST",
					contentType : 'application/json',
					url: 'upIosPic',
					data:$.toJSON(jsonstr),
					dataType:'json',
					cache: false,
					success: function(data){
						if(data.result=="1"){
							$("#zhongxin").tips({
								side:1,
					            msg:"更新成功",
					            bg:'#AE81FF',
					            time:3
					        });
							setTimeout("hideF()",2000); 
						}else{
							$("#zhongxin").tips({
								side:1,
					            msg:"更新失败",
					            bg:'#AE81FF',
					            time:3
					        });
						}
					}
					
				}) ;
			 
			 
		
		}
		</script>
</body>
</html>