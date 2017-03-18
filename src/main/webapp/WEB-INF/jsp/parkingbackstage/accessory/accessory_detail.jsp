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
		<!-- jsp文件头和头部 -->
		<%@ include file="../../system/admin/top.jsp"%> 
		<link rel="stylesheet" type="text/css" href="plugins/webuploader/webuploader.css" />
		<link rel="stylesheet" type="text/css" href="plugins/webuploader/style.css" />
		<script type="text/javascript" src="system/js/jquery.tips.js"></script>
		<style type="text/css">
			#dialog-add,#dialog-message,#dialog-comment{width:100%; height:100%; position:fixed; top:0px; z-index:99999999; display:none;}
			.controls-tit{border: 1px solid #d5d5d5;margin:7px 0 10px 0;}
			.controls-tit input{display: block;width: 100%;border:none;padding:4px 0;line-height:20px;margin:0;}
			.ace-file-multiple label:before{content:"单机上传图片";display:block;text-align:center;}
			.ace-file-multiple label{border:none;border-radius:0;}
			*:focus {outline: none;}
			.imgSize{
				width:50px ;
				height:50px ;
			}
		</style>
	</head> 
	<body>

<!-- 公告 -->
	
<div id="zhongxin">	
<div class="container-fluid" id="main-container">
<div id="page-content" class="clearfix">
  <div class="row-fluid">
 		<div class="widget-main">
 			<form name="addAccessoryForm" id="addAccessoryForm" action="" method="POST"  enctype="multipart/form-data" target="hidden_frame" >   
	 			<h4 class="lighter">公告内容</h4>
				<div class="controls controls-tit">
					<input type="text" maxlength="50" id="subject" name="subject" value="${message.msgName }" readonly="readonly" placeholder="主题......">
				</div>
				<div class="controls controls-tit">
					<input type="text" maxlength="50" id="subject" name="subject" value="${message.msgSendName }" readonly="readonly" placeholder="发送人......">
				</div>
				<div class="row-fluid">
					<textarea class="span12" id="content" name="content"  maxlength="50" readonly="readonly" placeholder="内容......" style="height:100px;">${message.msgBody }</textarea>
				</div>
				<h4 class="lighter">公告图片</h4>
				<div class="">
					<c:if test="${not empty message.msgBodyImgUrl}">
						<img id="msgBodyImgUrl" alt="" src="${message.msgBodyImgUrl}" width="100" height="100" >
					</c:if>
					<c:if test="${empty message.msgBodyImgUrl}">
						<img id="msgBodyImgUrl" alt="" src="system/images/position.jpg" width="100" height="100" >
					</c:if>
				</div>
			</form>
			<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>  
		</div>
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
</div>
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='onlineparking/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="system/js/bootstrap.min.js"></script>
		<script src="system/js/ace-elements.min.js"></script>
		<script src="system/js/ace.min.js"></script>
    	<script type="text/javascript">
    	$('#file').ace_file_input({
			style:'well',
			btn_choose:'Drop files here or click to choose',
			btn_change:null,
			no_icon:'icon-cloud-upload',
			droppable:true,
			onchange:null,
			thumbnail:'small',
			before_change:function(files, dropped) {
				return true;
			}
		}).on('change', function(){
		});
    	</script>
	</body>
</html>

