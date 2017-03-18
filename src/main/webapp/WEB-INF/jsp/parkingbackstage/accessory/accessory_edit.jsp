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
			.ace-file-input{
			    width: 530px;
			        display: inline-block;
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
 				<input type="hidden" name="msgSendName"  value="<%=session.getAttribute("systemManagerUsername") %>">
	 			<h4 class="lighter"  id="showMsg">公告内容</h4>
				<input type="hidden" name="msgId" value="${message.msgId }" />
				<div class="controls controls-tit">
					<input type="text" maxlength="50" id="subject" name="subject" value="${message.msgName }"  placeholder="这里输入主题......">
				</div>
				<%-- <div class="controls controls-tit">
					<input type="text" maxlength="20" id="msgSendName" name="msgSendName" value="${message.msgSendName }"  placeholder="这里发送者姓名......">
				</div> --%>
				<div class="row-fluid">
					<textarea class="span12" id="content" name="content"  maxlength="50" placeholder="这里输入内容......" style="height:110px;overflow:hidden">${message.msgBody }</textarea>
				</div>
				<h4 class="lighter">上传图片</h4>
				<div class="">
					<c:if test="${not empty message.msgBodyImgUrl}">
						<img id="msgBodyImgUrl" alt="" src="${message.msgBodyImgUrl}" width="100" height="100" >
					</c:if>
					<c:if test="${empty message.msgBodyImgUrl}">
						<img id="msgBodyImgUrl" alt="" src="system/images/position.jpg" width="90" height="90" >
					</c:if>
					<input multiple type="file" id="file" name="file"/>
				</div>
				<div style="text-align:right;margin-top:20px">
					<a onclick="saveAccessory();" class="btn btn-small btn-success">提交</a>
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
	<!-- 	<script type="text/javascript" src="plugins/webuploader/webuploader.js"></script>
    	<script type="text/javascript" src="plugins/webuploader/upload.js"></script> -->
    	<script type="text/javascript">
    	  function checkFileType(){   
	    	$("#file").tips({
					side : 1,
					msg : '图片限于bmp,png,gif,jpeg,jpg格式 ',
					bg : '#AE81FF',
					time : 3 ,
					y : 100
				});
    	  }
    	  
    	  
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
       	function saveAccessory() {
   			var subject = $("#subject").val() ;
   			var msgSendName = $("#msgSendName").val() ;
   			var content = $("#content").val() ;
   			var file = $("#file").val() ;
    		if(subject==""){
    			$("#subject").tips({
					side : 1,
					msg : '请输入主题 ',
					bg : '#AE81FF',
					time : 3
				});
    			return false ;
    		}
/*     		if(msgSendName==""){
    			$("#msgSendName").tips({
					side : 1,
					msg : '请输入发送者姓名 ',
					bg : '#AE81FF',
					time : 3
				});
    			return false ;
    		} */
    		if(content==""){
    			$("#content").tips({
					side : 1,
					msg : '请输入内容',
					bg : '#AE81FF',
					time : 3
				});
    			return false ;
    		}
    		$('#addAccessoryForm').attr("action", "/OnlineParking/editSysAccessory").submit();
    	
    	}
    	
    	function showInfo(data){
    		if(data.result=="1"){ 
    			$("#showMsg").tips({
    				side : 1,
    				msg : '更新消息成功',
    				bg : '#AE81FF',
    				time : 100000,
    				y:450,
    				x:15
    			});
    			setTimeout("hideF()",2000); 
    		 }else{
    			$("#showMsg").tips({
    				side : 1,
    				msg : '更新消息失败',
    				bg : '#AE81FF',
    				time : 3 ,
    				y:450,
    				x:15
    			});
    		} 
    
    	}
    	
    	//文件超过500K 提示信息
    	function fileExceededInfo(){
    		  $("#file").tips({
					side : 1,
					msg : "文件不可超过500K",
					bg : '#AE81FF',
					time : 3 ,
					y : 100
				});
    	}
    	
    	//隐藏 窗口
    	function hideF(){
    		$("#zhongxin").hide();
    		top.Dialog.close();
    	}
    	</script>
	</body>
</html>

