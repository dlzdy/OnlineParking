<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
	<!-- jsp文件头和头部 -->
	<%@ include file="top.jsp"%>
	<style type="text/css">
		.commitopacity{position:absolute; width:100%; height:100px; background:#7f7f7f; filter:alpha(opacity=50); -moz-opacity:0.8; -khtml-opacity: 0.5; opacity: 0.5; top:0px; z-index:99999;}
	</style>
	<script type="text/javascript">
		var parkInfo = ${parkName} ;
	    //如果用户没有关联停车场 先要关联停车场
		 $(function(){
			 $("#parkingInfoName").html(parkInfo.datas.parkingInfoName) ;
			 var checkParkInfoId = '${checkParkInfoId}';
				 if(checkParkInfoId=="notExsit"){
					 relativePark() ; //该方法在head.js中
				}
				 
			 
		 }) ;
	</script>
</head>
<body style="overflow-y:hidden;">

	<!-- 页面顶部¨ -->
	<%@ include file="head.jsp"%>
	<div id="websocket_button"></div>
	<div class="container-fluid" id="main-container">
		<a href="#" id="menu-toggler"><span></span></a>
		<!-- menu toggler -->
		<input type="hidden" id="userID" value="<%=session.getAttribute("loginname") %>"> <!-- 登录时的用户名 即为电话号码 -->
		<input type="hidden" id="uID" value="<%=session.getAttribute("uID") %>"> <!-- 后台通过电话号码将 用户id取出 -->
		<!-- 左侧菜单 -->
		<%@ include file="left.jsp"%>

		<div id="main-content" class="clearfix">

			<div id="jzts" style="display:none; width:100%; position:fixed; z-index:0;">
			<div class="commitopacity" id="bkbgjz"></div>
			<div style="padding-left: 50%;margin-left:-130px;padding-top:50px;">
				<div style="float: left;margin-top: 9px;"><img src="onlineparking/images/loadingi.gif" /> </div>
				<div style="margin-top: 5px;"><h4 class="lighter block red">&nbsp;加载中 ...</h4></div>
			</div>
			</div>

			<div>
				<iframe name="mainFrame" id="mainFrame" frameborder="0" src="tab.do" scrolling="no" style="margin:0 auto;width:100%;height:100%;"></iframe>
			</div>
			
			

			<!--更换界面皮肤 -->
			<!-- <div id="ace-settings-container">
				<div class="btn btn-app btn-mini btn-warning" id="ace-settings-btn">
					<i class="icon-cog"></i>
				</div>
				<div id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hidden">
								<option data-class="default" value="#438EB9"
								<option data-class="skin-1" value="#222A2D"
								<option data-class="skin-2" value="#C6487E"
								<option data-class="skin-3" value="#D0D0D0"
							</select>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>
					<div>
						<label><input type='checkbox' name='menusf' id="menusf"
							onclick="menusf();" /><span class="lbl" style="padding-top: 5px;">菜单缩放</span></label>
					</div>
				</div>
			</div> -->
			<!--/#ace-settings-container-->

		</div>
		<!-- #main-content -->
	</div>
	<!-- 页面底部 -->
	<%@ include file="footer.jsp" %>
	<!--/.fluid-container#main-container-->
	<!-- basic scripts -->
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="onlineparking/js/bootstrap.min.js"></script>
	    <script src="onlineparking/js/ace-elements.min.js"></script>
		<script src="onlineparking/js/ace.min.js"></script>
		<!--引入属于此页面的js -->
		<script type="text/javascript" src="onlineparking/js/onlineparking/index.js"></script>
		<script>
	       $(function(){
	    	    var src=$('#mainFrame').attr('src');
				$('#mainFrame').attr('src').change(function(){
			        alert(0);
			 	});	
			 	$('#mainFrame').click(function(){
			 		alert(1);
			 	});	
			 	//console.log($('#mainFrame').attr('src'));
			 	console.log('654654');
			})
			
			
	</script>
</body>

</html>
