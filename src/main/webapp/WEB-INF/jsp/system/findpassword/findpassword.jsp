<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		<title>找回密码</title>
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
	
	<!-- 忘记密码 界面 -->
	<div id="forgot-box" class="visible widget-box no-border">
		<div class="widget-body">
		 <div class="widget-main">
			<h4 class="header lighter bigger"><i class="icon-coffee green"></i> 找回密码</h4>
			
			<div class="space-6"></div>
			<form>
				 <fieldset>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text" id="telNumber" class="span12" placeholder="请输入您的手机号" />
							<i class="icon-envelope"></i>
						</span>
					</label>
						
				    <div>
						<span class="block input-icon input-icon-right">
							<input type="email" class="span12" placeholder="验证码" style="width:180px"/>
							<button onclick="getCode();" class="btn btn-small btn-primary" style="margin-left:25px"> 获取验证码</button>
						</span>
					</div>
	
					<div class="row-fluid" style="margin-top:10px">
						<button onclick="findPassWord();" class="span4 btn btn-small btn-primary"><i class="icon-key"></i>确定</button>
					</div>
					
				  </fieldset>
			</form>
		 </div><!--/widget-main-->
		
		 <div class="toolbar center"> 
			<a  href="/ParkingDemo/" style="cursor:pointer" class="back-to-login-link">返回到登录界面 <i class="icon-arrow-right"></i></a>
		 </div>
		</div><!--/widget-body-->
	</div><!--/forgot-box--><!-- 忘记密码界面 结束 -->
	
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
		
		//验证手机号码
		//debugger ;
		$("#telNumber").blur(function(){
			var telNumber = $("#telNumber").val() ;
			var reg = /^[1][0-9]{10}$/ ;
		 	if(!reg.test(telNumber)){
		 		$("#telNumber").tips({
					side : 2,
					msg : '电话为以1开头的11位纯数字',
					bg : '#AE81FF',
					time : 3
				});
		 	}
		}) ;
		  
	 });  
	   
	   //获取验证码
	   function getCode(){
		   var telNumber = $("#telNumber").val() ;
		   debugger ;
		   var reg = /^[1][0-9]{10}$/ ;
		   if(telNumber==""){
			   $("#telNumber").tips({
					side : 2,
					msg : '请输入电话号码',
					bg : '#AE81FF',
					time : 3
				});
			   $("#telNumber").focus() ;
			   return false;
		   }
		 	if(!reg.test(telNumber)){
		 		$("#telNumber").tips({
					side : 2,
					msg : '电话为以1开头的11位纯数字',
					bg : '#AE81FF',
					time : 3
				});
		 		 $("#telNumber").focus() ;
				   return false;
		 	}
		 	
		 	var jsonstr = {"telNumber":telNumber}
		 	$.ajax({
		 		type: "POST",
				contentType : 'application/json',
				url: 'getCode',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(data){
					alert(data.telNumber) ;
				}
		 		
		 	});
	   }
      
	</script>
	</body>