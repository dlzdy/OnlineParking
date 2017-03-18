<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<table id="table_report" class="table table-striped table-bordered table-hover">
				<input type="hidden" name="username" id="username">
				<input type="hidden" name="versionOldCode" id="versionOldCode">
				<input type="hidden" name="versionOldName" id="versionOldName">
			<tr>
			<td style="width:100px;text-align: right;padding-top: 13px;">版本号</td>
			<td style="vertical-align:top;"> 
			 	<input style="width:95%;" type="text" name="versionCode" id="versionCode" value="" maxlength="6" placeholder="请输入版本号" title=""/>
			</td>
			</tr>
			<tr>
			<td style="width:100px;text-align: right;padding-top: 13px;">版本名</td>
			<td style="vertical-align:top;"> 
			 	<input style="width:95%;" type="text" name="versionName" id="versionName" value="" maxlength="10" placeholder="请输入版本名" title=""/>
			</td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">更新内容</td>
				<td><textarea  rows="3" cols="20" type="text" name="content" id="content" value=""  placeholder="请输入更新内容" title=""></textarea></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">选择文件</td>
				<td style="text-align: center;" colspan="10">
					<input id="android_file_upload" name="android_file_upload" type="file" multiple="true">
					<input id="apkName" name="apkName" type="hidden">
				</td>
			</tr>
			<tr>
				
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary"  onclick="uploadAndroidApk();">提交</a>
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
		$(function(){
			$('#android_file_upload').uploadify({
				'multi':false, //只能上传一个
				'buttonText':'点我选择文件',
				'auto':false, 
				'swf': 'plugins/uploadify/uploadify.swf', 
				'uploader' : 'upAndroidApk' ,
				 'fileObjName' : 'androidFileName',  
				 'fileTypeExts':'*.apk' , 
	             'onDialogOpen' : function(){
	            		if(!checkInvalid()){return false} ; //判断session是否失效 
	             },
	             'onUploadStart':function(file){
	            	 $('#android_file_upload').uploadify('settings','formData',{'username':$("#username").val(),'versionName':$("#versionName").val(),'versionCode':$("#versionCode").val(),'content':$("#content").val()});
	            	 $("#apkName").val(file.name) ;
	             } ,
				 'onUploadSuccess':function(file, data, response){//每一个文件上传成功时触发该事件
	            	 var data =	eval('('+data+')') ;
	            	  if(data.result=="success"){
	             		$("#table_report").tips({
	        				side : 1,
	        				msg : '上传成功',
	        				bg : '#AE81FF',
	        				time : 3 ,
	        			});
             			/* $("#androidName").html(data.sysImgAndroidName) ; */
             			setTimeout("hideF()",2000) ;
	             		
	             	 }else{
	             		$("#table_report").tips({
	        				side : 1,
	        				msg : '上传失败',
	        				bg : '#AE81FF',
	        				time : 3 ,
	        			});
	             	 } 
	             }
			}) ;
		}) ;
		
		function hideF(){
			$("#zhongxin").hide();
			top.Dialog.close() ;
		}
		
		function uploadAndroidApk(){
			 var versionCode = $("#versionCode").val() ;
			 var versionOldName = $("#versionOldName").val() ;
			 var versionName = $("#versionName").val() ;
			 var content = $("#content").val() ;
			 var filename = $('#android_file_upload-queue .fileName').html() ;
			 if(!checkVersionCode(versionCode)){
				 return false ;
			 }
			 
			 if( !checkVersionName(versionName,versionOldName,"versionName")){
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
			 if(filename==""||filename==null){
				 $("#android_file_upload").tips({
						side : 1,
						msg : '请选择文件',
						bg : '#AE81FF',
						time : 3
					});
				 return false ;
			 }
			$('#android_file_upload').uploadify('upload','*') ;
		}
		
		
		function checkVersionCode(versionCode){
			var versionOldCode = parseInt($("#versionOldCode").val());
			var versionCode = parseInt($("#versionCode").val());
			var reg = /^[0-9]*[1-9][0-9]*$/ ;
			if(versionCode=="" || versionCode==null){
				$("#versionCode").tips({
					side : 1,
					msg : '请输入版本号',
					bg : '#AE81FF',
					time : 3
				});
			 return false ;
			}
			if(!(reg.test(versionCode) && (versionOldCode<versionCode))){
				 $("#versionCode").tips({
						side : 1,
						msg : '请输入大于'+versionOldCode+'的正整数',
						bg : '#AE81FF',
						time : 3
					});
				 return false ;
			}
			return true ;
		}
		
		</script>
</body>
</html>