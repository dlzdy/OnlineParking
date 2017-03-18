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
	<base href="<%=basePath%>"><!-- jsp文件头和头部 -->
	<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="system/css/bootstrap.min.css" rel="stylesheet" />
	 <link href="onlineparking/css/bootstrap-responsive.min.css" rel="stylesheet" /> 
	<link rel="stylesheet" href="system/css/font-awesome.min.css" />
	<!-- page specific plugin styles -->
	<!-- 下拉框-->
	<link rel="stylesheet" href="system/css/chosen.css" />
	<!-- ace styles -->
	<link rel="stylesheet" href="system/css/ace.min.css" />
	<!-- <link rel="stylesheet" href="system/css/ace-responsive.min.css" /> -->
	<link rel="stylesheet" href="system/css/ace-skins.min.css" />
	<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
	<script src="plugins/uploadify/jquery.uploadify.js" type="text/javascript"></script>
	<script type="text/javascript" src="system/js/jquery.tips.js"></script>
	<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
	<link rel="stylesheet" type="text/css" href="plugins/uploadify/uploadify.css">
	
	
	<style type="text/css">
		.divP{
			margin-top: 60px ;
		}
		.model{
			background: #f6f6f6 ;
			border-radius: 10px ;
			float: left; 
			 margin-left: 60px;
		}
		.title{
			background: #d9d9d9 ; 
			width: 320px ;
			height: 50px ;
			line-height: 50px ;
			background: url(system/images/title_img.png);
			
		}
		.title span{
			font-size: 13px ;
    		margin-left: 10px;
		}
		.promptmsg span{
			 display: inline-block;
			 font-size: 14px ;
			 margin:20px  25px ;
		}
		.content{
			width: 300px ;
			height: 180px ;
			background: #fff;
			margin: 0 10px 40px 10px ;
		}
		.content img{
			margin: 5px 9px ;
			width:280px ;
			height:168px ;
		}

		.uploadbtn input[type='file']{
			width: 300px ;
			height: 40px ;
			background: #3a4dd9 ;
			color: #fff ;
			font-size: 16px ;
			border:none;
			border-radius: 5px ;
			margin: 0 10px 40px 10px ;
		}	
		/*修改链接*/
		.divU{
		}
		.modelU{
			 background: #f6f6f6 none repeat scroll 0 0;
			    float: left;
			    margin-left: 60px;
			   /*  margin-top: 60px; */
			     border-radius: 4px;
			     margin-bottom: 45px 
		}	
		.titleU{
			background:url(system/images/title_img2.png);
			 width: 510px ; 
			 height: 50px ; 
		}	
		.titleU span{
			display: inline-block;
			margin-left: 10px ;
			height: 50px ;
			line-height: 50px ;
		}
		.showOldUrl{  margin: 10px 0;     
					width:510px ;
		    		overflow:hidden ;
		}
		.showOldUrl span{
		    display: inline-block;
		    margin-left: 10px;
		
		   /*  margin-top: 15px; */
		} 
		.showOldUrl em{
			padding-right:10px ;
		}
		.saveDiv{
			margin-bottom: 30px ;
		}
		.saveDiv input{border: none;}
		.saveDiv input[type="text"]{
			width: 335px ;
			height: 20px ; 
			margin-left: 10px;
			background-color:#fff;
		}
		.saveDiv input[type="button"]{
			background: #555555 none repeat scroll 0 0;
		    border-radius: 35px;
		    color: #fff;
		    font-size: 14px;
		    height: 32px;
		    width: 116px;
		}
		.breadcrumb{
			   margin: 15px 22px 0 25px;
		}
		hr{
			margin:0 ;
		}
	</style>
	<!--查看图片插件 -->
    <script type="text/javascript" src="system/js/jquery.tips.js"></script>
    <script type="text/javascript">
		var imgInfo = ${imgInfo} ;
		var versionInfo = ${versionInfo} ;
		$(function(){
			if(imgInfo.datas!=null){
				if(imgInfo.datas.sysImgMainName!=null&&
						imgInfo.datas.sysImgMainName!=""){
					$("#mainName").attr("src","download/"+imgInfo.datas.sysImgMainName);   
				}else{
					$("#mainName").attr("src","system/images/default.png");   
				}
				
				if(imgInfo.datas.sysImgAndroidName!=null&&
						imgInfo.datas.sysImgAndroidName!=""){
					$("#androidName").html(imgInfo.datas.sysImgAndroidName) ;
				}else{
					$("#androidName").html("未添加") ;
				}
				if(imgInfo.datas.sysImgIosPath!=null&&
						imgInfo.datas.sysImgIosPath!=""){
					$("#iosName").html(imgInfo.datas.sysImgIosPath) ;
				}else{
					$("#iosName").html("未添加") ;
				}
			
				var versionAndroid = getFirstVerion(versionInfo,"1") ;
				$("#androidVersionName").html(versionAndroid.versionName || "未添加") ;
				$("#androidUpdateContent").html(versionAndroid.updateTips || "未添加") ;
				$("#androidVersionCode").html(versionAndroid.versionCode || "0") ;
				
				var versionIOS = getFirstVerion(versionInfo,"0") ;
				$("#iosVersionName").html(versionIOS.versionName || "未添加") ;
				$("#iosUpdateContent").html(versionIOS.updateTips || "未添加") ;
				$("#iosVersionCode").html(versionIOS.versionCode || "0") ;
			}
			
		}) ;
		
		function getFirstVerion(versionInfo,type){
			//1（android版本信息 ）2（IOS版本信息）
			var verData = "" ;
			for(var i = 0 ; i < versionInfo.datas.length ; i++){
				var version = versionInfo.datas[i] ;
				if(version.appType == type){
					verData = versionInfo.datas[i] ;
					break ;
				}
			}
			return verData ;
		}
    </script>
	</head>
<body>
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> 首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>产品主页管理<span class="divider"></span></li>
		</ul>
	</div>
				<!-- 上传图片 -->
	<div class="divP">
		<div class="model">
			<div id="msg"></div>
			<div class="title" ><span>产品主页背景图片上传</span></div>
			<div class="promptmsg"><span>文件格式：*.png *.jpg  *.gif <br>
				文件大小：不超过500K
			</span></div>
			<div class="content"><img src="" id="mainName"></div>
			<div class="uploadbtn">
			    <input type="hidden" id="username" value="<%=session.getAttribute("systemManagerUsername")%>">
			 	<input id="file_upload" name="file_upload" type="file" multiple="true"></div>
		</div>
	</div>
	<!--更改地址-->
	<div class="divU">
		<div class="modelU">
			<div class="titleU" id="msgAndroid">
				<span>安卓apk包上传</span>
			</div>
			<!-- <input id="androidVersionCode" type="hidden"> -->
			<div class="promptmsg"><span>文件格式：*.apk</span></div><hr>
			 <div class="showOldUrl"><span>apk包名：<em  id="androidName"></em></span></div>
			 <div class="showOldUrl"><span>内部版本号：<em  id="androidVersionCode"></em></span></div>
			 <div class="showOldUrl"><span>版本名称：<em  id="androidVersionName"></em></span></div>
			 <div class="showOldUrl"><span>更新内容：<em  id="androidUpdateContent"></em></span></div>
			<!-- <div class="saveDiv"><input id="android_file_upload" name="android_file_upload" type="file" multiple="true"></div>  -->
			<div class="saveDiv"><input type="button" onclick="toUpdateAndroid()" value="上传"></div>
		</div>

		<div class="modelU">
			<div class="titleU" id="msgIos">
				<span>ios 添加apk路径</span>
			</div>
			<form action="upIosPic" target="ajaxUp" id="iosSrcForm" method="post">
			 <div class="showOldUrl"><span >路径：<em id="iosName"></em></span></div>
			 <div class="showOldUrl"><span>内部版本号：<em  id="iosVersionCode"></em></span></div>
			 <div class="showOldUrl"><span>版本名称：<em  id="iosVersionName"></em></span></div>
			 <div class="showOldUrl"><span>更新内容：<em  id="iosUpdateContent"></em></span></div>
			 <div class="saveDiv"><input type="button" onclick="toUpdateIOS()" value="更新版本"></div>
			<!-- <div class="saveDiv"><input type="text" name="iosUrl" id="iosSrc"><input type="button" onclick="upIosSrc();" value="保存"></div>  -->
			</form>
			<iframe name="ajaxUp" style="display:none"></iframe>
		</div>
	</div>
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='system/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="system/js/bootstrap.min.js"></script>
		<script src="system/js/ace-elements.min.js"></script>
		<script src="system/js/ace.min.js"></script>
		<!-- 引入 -->
		<script type="text/javascript">
	$(function() {
			$('#file_upload').uploadify({
				'multi':false, //只能上传一个
				'buttonText':'点我替换图片',
				 /* 'auto':false,   */
				 'formData'     : {
					 'username':'sys'
				}, 
				'swf'      : 'plugins/uploadify/uploadify.swf', 
				 'uploader' : 'upBannerPic' ,
				 'fileObjName' : 'bannerFileName',  
				 'fileTypeExts':'*.gif;*.jpg;*.png' , 
				 'fileSizeLimit' : '500',  
				 /*  'onQueueComplete' : function(queueData) {  
	                    alert(queueData.uploadsSuccessful + ' files were successfully uploaded.');  
	             } , */
	             'onUploadError':function(file, data, response){//上传失败时触发该事件
	            	/*  alert(data) ; */
	             },
	             'onDialogOpen' : function(){
	            		if(!checkInvalid()){return false} ; //判断session是否失效 
	             },
	             'onUploadSuccess':function(file, data, response){//每一个文件上传成功时触发该事件
	            	 var data =	eval('('+data+')') ;
	            	  if(data.result=="success"){
	             		$("#msg").tips({
	        				side : 1,
	        				msg : '上传成功',
	        				bg : '#AE81FF',
	        				time : 3 ,
	        			});
	             		$("#mainName").attr("src","download/"+data.mainName);   
	             	 }else{
	             		$("#msg").tips({
	        				side : 1,
	        				msg : '上传失败',
	        				bg : '#AE81FF',
	        				time : 3 ,
	        			});
	             	 } 
	             }
	     
			});
		});
	
	
	//上传ios路径
	function upIosSrc(){
		if(!checkInvalid()){return false} ; //判断session是否失效 
		var iosSrc = $("#iosSrc").val() ;
		if(iosSrc==""||iosSrc==null){
			$("#iosSrc").tips({
				side : 1,
				msg : '请填写路径名称',
				bg : '#AE81FF',
				time : 3 ,
			});
			return false ;
		}
		   $("#iosSrcForm").submit();
	}
	//ios提交路径， 从后台返回的提示信息
	function showInfo(data){
		if(data.result=="1"){
			$("#msgIos").tips({
				side : 1,
				msg : '更新成功',
				bg : '#AE81FF',
				time : 3 ,
			});
		}else{
			$("#msgIos").tips({
				side : 1,
				msg : '更新失败',
				bg : '#AE81FF',
				time : 3 ,
			});
		}
	}
	
	//跳转到上传安卓包的界面
	function toUpdateAndroid(){
		 top.jzts();
		 var diag = new top.Dialog();
		 var username = $('#username').val() ;
		 var versionOldCode = $('#androidVersionCode').html() ;
		 var versionOldName = $('#androidVersionName').html() ;
		 diag.Drag=true;
		 diag.Title ="上传安卓开发包";
		 diag.URL = '/OnlineParking/toUpdateAndroidApk';
		 diag.Width = 360;
		 diag.Height =450;
		 diag.CancelEvent = function(){ //关闭事件
			 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
			 		$("#androidVersionCode").html( $(diag.innerFrame.contentWindow.document.getElementById('versionCode')).val()) ;
			 		$("#androidVersionName").html( $(diag.innerFrame.contentWindow.document.getElementById('versionName')).val()) ;
			 		$("#androidUpdateContent").html( $(diag.innerFrame.contentWindow.document.getElementById('content')).val()) ;
			 		$("#androidName").html($(diag.innerFrame.contentWindow.document.getElementById('apkName')).val() ) ;
			} 
			 diag.close();
		 };
		 diag.show();
		 diag.OnLoad=function(){ //弹出框载入完成之后执行
			 $(diag.innerFrame.contentWindow.document.getElementById('username')).val(username) ;
			 $(diag.innerFrame.contentWindow.document.getElementById('versionOldCode')).val( versionOldCode ||'0') ;
			 $(diag.innerFrame.contentWindow.document.getElementById('versionOldName')).val( versionOldName) ;
		};
	}
		
	/*跳转到ios界面*/
	function toUpdateIOS() {
		 top.jzts();
		 var diag = new top.Dialog();
		 var username = $('#username').val() ;
		 var iosVersionCode = $('#iosVersionCode').html() ;
		 var iosVersionName = $('#iosVersionName').html() ;
		 diag.Drag=true;
		 diag.Title ="更改ios版本";
		 diag.URL = '/OnlineParking/toUpdateIosApk';
		 diag.Width = 350;
		 diag.Height =400;
		 diag.CancelEvent = function(){ //关闭事件
			 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
				 $("#iosVersionCode").html( $(diag.innerFrame.contentWindow.document.getElementById('versionCode')).val()) ;
				 $("#iosVersionName").html( $(diag.innerFrame.contentWindow.document.getElementById('version')).val()) ;
				 $("#iosUpdateContent").html( $(diag.innerFrame.contentWindow.document.getElementById('content')).val()) ;
				 $("#iosName").html( $(diag.innerFrame.contentWindow.document.getElementById('iosSrc')).val()) ;
			 }
			 diag.close();
		 };
		 diag.show();
		 diag.OnLoad=function(){ //弹出框载入完成之后执行
			 $(diag.innerFrame.contentWindow.document.getElementById('username')).val(username) ;
			 $(diag.innerFrame.contentWindow.document.getElementById('iosVersionCode')).val(iosVersionCode) ;
			 $(diag.innerFrame.contentWindow.document.getElementById('iosVersionName')).val(iosVersionName) ;
		};
		 
		 
	}
		</script>
	
	</body>
</html>

