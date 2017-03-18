<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- *********************************************login 表单界面布局控制*******************Start*********************************************-->
	<head>
		<meta charset="utf-8" />
		<title>停车场企业后台</title>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="<%=basePath %>/static/login/bootstrap.min.css" rel="stylesheet" />
		<link href="<%=basePath %>/static/login/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=basePath %>/static/login/font-awesome.css" />
		<link rel="stylesheet" href="<%=basePath %>/static/css/ace.min.css" />
		<link rel="stylesheet" href="<%=basePath %>/static/css/ace-responsive.min.css" />
		 <!-- 控制图片 -->
		 <link rel="stylesheet" href="<%=basePath %>/static/login/css/camera.css" />
		<style type="text/css">
				
			/*给body加背景图片 */
			body.login-layout{
				background-image: url("static/login/images/banner_slide_03.jpg");
				background-repeat:no-repeat;
			}
			
		
			/*设置form 背景颜色*/
			 .login-layout .widget-box{
				   background-color: rgba(0, 0, 0, 0.5);
			} 
			/*设置form 表单为透明颜色 */
			.login-layout .widget-box .widget-main{
					 background-color: none;
			}
			
			/*将背景图片 放在下层 */
			.camera_wrap{
				z-index:-1
			}
			
			/*注册按钮颜色*/
			.btn-success{
			    background-color: #08c!important;
   				border-color: #08c;
			}
			
			/*忘记密码的 背景 虚影去掉 */
			.login-layout .widget-box .widget-body .toolbar>div>a {
			  text-shadow : none
			}
			
			/*注册界面 最下面的toolbar*/
			#signup-box .toolbar {
			    background: #08c;
			    border-top: 2px solid #08c;
			    padding: 9px 18px;
			}
			
			/*忘记密码界面的toolbar */
			#forgot-box .toolbar {
			    background: #08c;
			    border-top: 2px solid #08c;
			    padding: 9px 18px;
			}
			
			/**找回密码的toolbar字体颜色 */
			#forgot-box .back-to-login-link{
				    color: #FFF;
			}
			
			/*注册界面的toolbar字体颜色*/
			#forgot-box .back-to-login-link, #signup-box .back-to-login-link{
				color: #FFF;
			}
			
		   
		</style>
	</head>
	<body class="login-layout">
		<!-- <div class="container-fluid" id="main-container"> -->
			<!-- <div id="main-content"> -->
				<div class="row-fluid">
					<div class="span12">
<!-- *********************************************login 表单界面布局控制En*********************************************-->

						
<div class="login-container" >

 <div class="space-6" style="margin-top:180px"></div> 
 <div class="row-fluid">
<div class="position-relative">

	<!-- 登录界面 -->
	<div id="login-box" class="visible widget-box no-border">
		<div class="widget-body">
		 <div class="widget-main">
		 <input type="hidden" value="${msg}" id="msgInput" />
			<h4 class="header lighter bigger"><i class="icon-coffee green"></i> 请输入您的信息</h4>
			
			<div class="space-6"></div>
			
			<form  id="loginForm"  method = "post" >
				<fieldset> 
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text"  id="loginname" name="loginname" class="span12" placeholder="用户名" />
							<i class="icon-user"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="password" id="password" name="password" class="span12" placeholder="密码" />
							<i class="icon-lock"></i>
						</span>
					</label>
					<div class="space"></div>
					<div class="row-fluid">
						<label class="span8">
							<!-- <input type="checkbox"><span class="lbl">记住密码</span> -->
						</label>
						<button id="loginBox" class="span4 btn btn-small btn-primary"><i class="icon-key"></i> 登录</button>
					</div>
					
				  </fieldset> 
			</form>
		 </div><!--/widget-main-->
		
		 <div class="toolbar clearfix">
			<div>
				<a  onclick="show_box('forgot-box'); return false;" class="forgot-password-link" style="cursor: pointer"><i class="icon-arrow-left"></i> 忘记密码</a>
			</div>
			<div>
				<a  onclick="show_box('signup-box'); return false;" class="user-signup-link" style="cursor:pointer">注册 <i class="icon-arrow-right"></i></a>
			</div>
		 </div>
		</div><!--/widget-body-->
	</div><!--/login-box-->
	
	
	
	<!-- 忘记密码 界面 -->
	<div id="forgot-box" class="widget-box no-border">
		<div class="widget-body">
		 <div class="widget-main">
			<h4 class="header lighter bigger"><i class="icon-coffee green"></i> 找回密码</h4>
			
			<div class="space-6"></div>
			
			<p>
				输入您的电子邮件并接收指令
			</p>
			<form>
				 <fieldset>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="email" class="span12" placeholder="邮箱" />
							<i class="icon-envelope"></i>
						</span>
					</label>
	
					<div class="row-fluid">
						<label class="span8">
						</label>
						<button onclick="return false;" class="span4 btn btn-small btn-primary"><i class="icon-key"></i> 发送</button>
					</div>
					
				  </fieldset>
			</form>
		 </div><!--/widget-main-->
		
		 <div class="toolbar center"> 
			<a  onclick="show_box('login-box'); return false;" style="cursor:pointer" class="back-to-login-link">返回到登录界面 <i class="icon-arrow-right"></i></a>
		 </div>
		</div><!--/widget-body-->
	</div><!--/forgot-box--><!-- 忘记密码界面 结束 -->
	
	
	<!-- 注册界面 -->
	<div id="signup-box" class="widget-box no-border">
		<input type="hidden" value="${signErrorMsg}" id="signErrorMsg"/> 
		<div class="widget-body">
		 <div class="widget-main">
			<h4 class="header lighter bigger"><i class="icon-coffee green"></i>新用户注册</h4>
			<div class="space-6"></div>
			<p>
				
			</p>
			
			<form id="singupForm" ><!-- method="post" --> 
				 <fieldset>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text" class="span12" placeholder="用户ID" id="userId" name="userId"  maxlength="20" />
							<i class="icon-envelope"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text" class="span12" placeholder="电话" id="userPhone" name="userPhone" maxlength="20"  />
							<i class="icon-user"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text" class="span12" placeholder="信息" id="userBasic" name="userBasic" maxlength="20"/>
							<i class="icon-user"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text" class="span12" placeholder="MD5校验" id="mD5" name="mD5" maxlength="20"  />
							<i class="icon-retweet"></i>
						</span>
					</label>
					
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text" class="span12" placeholder="余额" id="userBalance" name="userBalance" maxlength="20" />
							<i class="icon-retweet"></i>
						</span>
					</label>
					
					<label>
						<input type="checkbox" id="acceptPapers" ><span class="lbl"> 我接受用户协议</span>
					</label>
					
					<div class="space-24"></div>
					
					<div class="row-fluid">
						<button type="reset" class="span4 btn btn-small btn-primary"><i class="icon-key"></i>重置</button>
						<button id="signBtn" class="span4 btn btn-small btn-primary"  style="margin-left: 110px" disabled="disabled" ><i class="icon-key"></i>注册</button>
					</div>
					
				  </fieldset>
			</form>
		</div>
		
		
		<div class="toolbar center">
			<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link"><i class="icon-arrow-left"></i> 返回到登录界面</a>
		</div>
	 </div><!--/widget-body-->
	</div><!--/signup-box--><!-- 注册界面结束 -->
	
</div><!--/position-relative-->
	
</div>
</div>				
					
					</div><!--/span-->
				</div>
		
		
	<script src="<%=basePath %>/static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/js/jquery.json-2.4.js"></script>
	<script src="<%=basePath %>/static/login/js/jquery.easing.1.3.js"></script>
	<script src="<%=basePath %>/static/login/js/jquery.mobile.customized.min.js"></script>
	<script src="<%=basePath %>/static/login/js/camera.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/js/jquery.tips.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/js/jquery.cookie.js"></script>
	<script type="text/javascript">
		
	
      // =============================登录==========================================
		$("#loginBox").click(function(){
			
			var loginname = $("#loginname").val() ;
			var password = $("#password").val() ;
			//1.判断用户名不能为空
			if(loginname == ""){
				$("#loginname").tips({
					side : 2,
					msg : '用户名不得为空',
					bg : '#AE81FF',
					time : 3
				}) ;
				
				$("#loginname").focus() ;
				return false ;
			}else{
				$("#loginname").val(jQuery.trim($('#loginname').val()));			
			}
			

			//2.判断密码不能为空
			if(password == ""){
				$("#password").tips({
					side : 2,
					msg : '密码不得为空',
					bg : '#AE81FF',
					time : 3
				});

				$("#password").focus();
				return false;
			}
			
			//点击登录按钮 
			$("#login-box").tips({
				side : 1,
				msg : '正在登录 , 请稍后 ...',
				bg : '#68B500',
				time : 10
			});
			
		    $("#loginForm").attr("action", "/ParkingDemo/selectParkUser");
			$("#loginForm").submit() ; 
			/* 
			 $.ajax({
				type: "post",
				url: 'http://localhost:8080/ParkingDemo/selectParkUser',
		    	data: {password:$("#password").val()},
				dataType:'json'
			}) ; */
			
		}) ;
      
     
	   $(document).ready(function(){ 
		   //登录失败 页面重新定向 返回错误信心
		if($("#msgInput").val()=="error"){
			$("#loginname").tips({
				side : 2,
				msg : '用户名或密码错误',
				bg : 'red',
				time : 10
			});
		}
		  //注册失败 页面重新定向 返回错误信心
		if($("#signErrorMsg").val=="error"){
			$("#signup-box").tips({
				side : 2,
				msg : '注册失败',
				bg : 'red',
				time : 10
			});
		}
	 });   
      
	//=======================================注册用户 （添加用户） by xumingyue======================================
		$("#signBtn").click(function(){
		 	//debugger ;
			var userId = $("#userId").val() ; //不可为空
			var userPhone = $("#userPhone").val() ; //不可为空
			var mD5 = $("#mD5").val() ; //不可为空
			if(userId==""){
				$("#userId").tips({
					side : 2,
					msg : '用户Id不可为空',
					bg : 'red',
					time : 3
				});
				return false ;
			}else{
				 var reg = /[a-zA-Z0-9\u4e00-\u9fa5]/ ;
				 if(!reg.test(userId)){
					  $("#userId").tips({
							side : 2,
							msg : '用户名为英文字母大小写、中文、数字及组合',
							bg : 'red',
							time : 3
						});
					  return false ;
				  }
			}
			
			if(userPhone==""){
				$("#userPhone").tips({
					side : 2,
					msg : '电话不可为空',
					bg : 'red',
					time : 3
				});
				return false ;
			}else{
				var reg = /^[1][0-9]{10}$/ ;
			 	if(!reg.test(userPhone)){
			 		$("#userPhone").tips({
						side : 2,
						msg : '电话为以1开头的11位纯数字',
						bg : 'red',
						time : 3
					});
			 	 return false ;
			 	}
			}
			
			if(mD5==""){
				$("#mD5").tips({
					side : 2,
					msg : 'MD5不可为空',
					bg : 'red',
					time : 3
				});
				return false ;
			}
			
			var jsonstr = {"userId":userId,"userPhone":userPhone,"mD5":mD5,"userBasic":userBasic} ;
			debugger ;
			 $.ajax({
				type: "post",
				url: '/insertParkUser',
				data:$.toJSON(jsonstr),
				dataType:'json',
				contentType : 'application/json',
				success:function(data){
					alert(data.result) ;
				},
				error:function(data){
					alert(data) ;
				}
			}) ;
			//$("#singupForm").attr("action", "/ParkingDemo/insertParkUser");
			//$("#singupForm").submit() ; 
			
		}) ; 
			
	

	   
		//清除注册表单的数据 by xuminyue
		function clearData(){
			$("#userId").val("") ;
			$("#userPhone").val("") ;
			$("#userBasic").val("") ;
			$("#mD5").val("") ;
			$("#userBalance").val("") ;
		}		
		
	  //判断注册界面电话格式（以1开头的11位纯数字）
	  	$("#userPhone").blur(function(){
	  		var str = $("#userPhone").val() ;
		 	var reg = /^[1][0-9]{10}$/ ;
		 	if(!reg.test(str)){
		 		$("#userPhone").tips({
					side : 2,
					msg : '电话为以1开头的11位纯数字',
					bg : 'red',
					time : 3
				});
		 	}
		});
	  
	  //用户名不能为空 且不超过20字符
	  $("#userId").blur(function(){
		  var str = $("#userId").val() ;
		  var reg = /[a-zA-Z0-9\u4e00-\u9fa5]/ ;
		  if(!reg.test(str)){
			  $("#userId").tips({
					side : 2,
					msg : '用户名为英文字母大小写、中文、数字及组合',
					bg : 'red',
					time : 3
				});
		  }
	  }) ;
	
	  //接受协议事件
	  $("#acceptPapers").change(function(){
		  if($("#acceptPapers").prop("checked")){
			  $("#signBtn").attr("disabled", false); 
		  }else{
			  $("#signBtn").attr("disabled", true); 
		  }
	  });
	  
	   //三个界面切换的方法
		function show_box(id) {
			if(id=="signup-box"){
				clearData() ;
			}
		 $('.widget-box.visible').removeClass('visible');
		 $('#'+id).addClass('visible');
		}
	
	</script>
	</body> --%>