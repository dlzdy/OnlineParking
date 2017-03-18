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
		<title>停车场企业后台</title>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="<%=basePath %>/onlineparking/css/bootstrap.min.css" rel="stylesheet" />
		<link href="<%=basePath %>/onlineparking/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=basePath %>/onlineparking/css/font-awesome.css" />
		<link rel="stylesheet" href="<%=basePath %>/onlineparking/css/ace.min.css" />
		<link rel="stylesheet" href="<%=basePath %>/onlineparking/css/ace-responsive.min.css" />
		<style type="text/css">
				
			/*给body加背景图片 */
			body.login-layout{
				background-image: url("images/banner_slide_03.jpg");
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
			
		   #findpw-box .toolbar {
		    background: #08c none repeat scroll 0 0;
		    border-top: 2px solid #08c;
		    padding: 9px 18px;
			}
		
		
			#findpw-box .toolbar {
			    background: white none repeat scroll 0 0;
			}
		
			/*隐藏的div toolbar样式  */
			 #forlogin .toolbar {
			    background: #08c none repeat scroll 0 0;
			    border-top: 2px solid #08c;
			    padding: 9px 18px;
			}
			
			/*隐藏的div toolbar样色   */
			#forlogin .toolbar {
			    background: white none repeat scroll 0 0;
			}
		</style>
	</head>
	<body class="login-layout" onkeydown="enterDown();" >
		<!-- <div class="container-fluid" id="main-container"> -->
			<!-- <div id="main-content"> -->
				<div class="row-fluid">
					<div class="span12">
<!-- *********************************************login 表单界面布局控制En*********************************************-->

						
<div class="login-container" >

 <div class="space-6" style="margin-top:180px"></div> 
 <div class="row-fluid">
 <div class="position-relative">
	<!-- 隐藏的div -->
	<div  id="forlogin" class="widget-box no-border" style="width:500px;height:400px" >
		<div class="widget-body" style="height:400px">
		 <div class="widget-main">
			<h4 class="header lighter bigger">注册协议</h4>
			<div class="space-6"></div>
			<p></p>
			 <fieldset>
			 	<label>
						<span class="block input-icon input-icon-right">
							<div style="width:400px;height:200px" >
								【审慎阅读】您在申请注册流程中点击同意前，应当认真阅读以下协议。请您务必审慎阅读、充分理解协议中相关条款内容，其中包括：</br>
									1、与您约定免除或限制责任的条款；</br>
									2、与您约定法律适用和管辖的条款；</br>
									3、其他以粗体下划线标识的重要条款。</br>
									如您对协议有任何疑问，可向平台客服咨询。</br>
								【特别提示】当您按照注册页面提示填写信息.您应立即停止注册程序。</br>
							</divs>
						</span>
				</label>
			 </fieldset>
		</div><!-- /widget-main -->
		<div class="toolbar center"> 
			<a  onclick="show_box('signup-box'); return false;" style="cursor:pointer" class="back-to-login-link">同意协议 </a>
		</div>
		</div><!--/widget-body-->
	</div><!-- 隐藏div结束 -->
	<!-- 登录界面 -->
	<div id="login-box" class="visible widget-box no-border">
		<div class="widget-body">
		 <div class="widget-main">
				<h4 id="loginErrorMsg" class="header lighter bigger" style="font-size:18px;font-family:微软雅黑"><img alt="" src="images/icon_login.png">&nbsp;&nbsp;Online停车后台</h4>
			<div class="space-6"></div>
				<fieldset> 
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text"  id="loginname" name="loginname" class="span12" placeholder="用户名" maxlength="12" /><!-- onblur="checkUserName();" -->
							<i class="icon-user"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="password" id="password" name="password" class="span12" placeholder="密码" maxlength="20" /><!-- onblur="checkUserPassWord();" -->
							<i class="icon-lock"></i>
						</span>
					</label>
					<!-- <div class="space"></div> -->
					<div class="row-fluid">
						<!-- <label class="span8">
							<input type="checkbox"><span class="lbl">记住密码</span>
						</label> -->
						<button id="loginBox" class="span4 btn btn-small btn-primary" style="width:100%" onclick="login();"><i class="icon-key"></i> 登录</button>
					</div>
					
				  </fieldset> 
		 </div><!--/widget-main-->
		 <div class="toolbar clearfix">
			<div>
				<a class="forgot-password-link" style="cursor: pointer"  onclick="show_box('forgot-box')"><i class="icon-arrow-left"></i> 忘记密码</a>
			</div>
			<div>
			 <a  class="user-signup-link" style="cursor:pointer" onclick="show_box('signup-box')">注册 <i class="icon-arrow-right"></i></a>
			</div>
		 </div><!--/toolbar clearfix -->
		</div><!--/widget-body-->
	</div><!--/login-box-->
	
	
	<!-- 注册界面 -->
	<div id="signup-box" class=" widget-box no-border">
		<div class="widget-body">
		 <div class="widget-main">
			<h4 class="header lighter bigger"><i class="icon-coffee green"></i>新用户注册</h4>
			<div class="space-6"></div>
			<p></p>
				 <fieldset>
					<!-- <label>
						<span class="block input-icon input-icon-right">
							<input type="text" class="span12" placeholder="用户ID" id="userId" name="userId"  maxlength="20" />
							<i class="icon-envelope"></i>
						</span>
					</label> -->
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text" class="span12" placeholder="请输入电话" id="userPhone" name="userPhone" maxlength="12" onblur="checkPhone();"/>
							<i class="icon-user"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="password" class="span12" placeholder="请输入密码" id="userPassWord" name="userPassWord" maxlength="20" onblur="checkPassWord();"/>
							<i class="icon-lock"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="password" class="span12" placeholder="请重新输入密码" id="repeatUserPassWord" name="repeatUserPassWord" maxlength="20" onblur="checkRePassWord();"  />
							<i class="icon-retweet"></i>
						</span>
					</label>
					
					<label>
						<input type="checkbox" id="acceptPapers" onclick="checkPaper();"><span class="lbl"> 我接受用户协议<a onclick="show_box('forlogin')">注册协议</a></span>
					</label>
					
					<div class="space-24"></div>
					<div class="row-fluid">
						<!-- <button type="reset" class="span4 btn btn-small btn-primary"><i class="icon-key"></i>重置</button> -->
						<button id="signBtn" class="span4 btn btn-small btn-primary"  style="margin-left: 110px" disabled="disabled" ><i class="icon-key"></i>注册</button>
					</div>
				  </fieldset>
			</div>
			<div class="toolbar center">
				<a class="back-to-login-link" style="cursor:pointer" onclick="show_box('login-box')"  ><i class="icon-arrow-left"></i> 返回到登录界面</a>
			</div><!-- toolbar center -->
	 </div><!--/widget-body-->
	</div><!--/signup-box--><!-- 注册界面结束 -->
	
	
	<!-- 忘记密码 界面 -->
	<div id="forgot-box" class=" widget-box no-border">
		<div class="widget-body">
		 <div class="widget-main">
			<h4 class="header lighter bigger" id="fPass"><i class="icon-coffee green"></i> 找回密码</h4>
			<div class="space-6"></div>
				 <fieldset>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="text" id="fPhone" class="span12" maxlength="11" placeholder="请输入电话" onblur="checkFPhone();"/>
							<i class="icon-envelope"></i>
						</span>
					</label>
				   <div>
						<span class="block input-icon input-icon-right">
							<input type="text" id="verifycode" name="verifycode" class="span12" placeholder="验证码" style="width:75px"/>
							<button id="checkBtn" class="btn btn-small btn-primary" style="margin-left:15px"  onclick="getCode();" >获取验证码</button><!-- -->
						</span>
					</div>
	
					<div class="row-fluid" style="margin-top:10px">
						<button  id="subBtn" class="span4 btn btn-small btn-primary"><i class="icon-key"></i>确定</button>
					</div>
					
				  </fieldset>
		 </div><!--/widget-main-->
		
		 <div class="toolbar center"> 
			<a onclick="show_box('login-box')" style="cursor:pointer" class="back-to-login-link">返回到登录界面 <i class="icon-arrow-right"></i></a>
		 </div><!-- /toolbar center -->
		</div><!--/widget-body-->
	</div><!--/forgot-box--><!-- 忘记密码界面 结束 -->
	
	
	<!-- 重新找回密码界面 -->
	<div id="findpw-box" class=" widget-box no-border">
		<div class="widget-body">
		 <div class="widget-main">
			<h4 class="header lighter bigger"><i class="icon-coffee green"></i> 设置密码</h4>
			<div class="space-6"></div>
				 <fieldset>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="password" id="fPassWord" class="span12" maxlength="20" placeholder="请输入新密码" />
							<i class="icon-lock"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="password" id="fRePassWord" class="span12" maxlength="20" placeholder="请再次输入密码" />
							<i class="icon-retweet"></i>
						</span>
					</label>
	
					<div class="row-fluid" style="margin-top:10px">
						<button  id="reSetPass" class="span4 btn btn-small btn-primary"><i class="icon-key"></i>确定</button>
					</div>
				  </fieldset>
		 </div><!--/widget-main-->
		 
		
		 <div class="toolbar center"> 
			<div><a onclick="show_box('login-box')" style="cursor:pointer" class="back-to-login-link">返回到登录界面 <i class="icon-arrow-right"></i></a></div>
		 </div>
	  </div><!--/widget-body-->
	</div><!--/findpw-box--><!-- 重置密码界面 结束 -->
	
  </div><!--/position-relative-->
  </div><!--/row-fluid  -->
  </div><!-- /space-6 -->	
  			
</div>		<!-- /login-container -->
					</div><!--/span12-->
				</div><!-- row-fluid -->
		
		
	<script src="<%=basePath %>/onlineparking/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="<%=basePath %>/onlineparking/js/jquery.json-2.4.js"></script>
	<script type="text/javascript" src="<%=basePath %>/onlineparking/js/jquery.tips.js"></script>
	<script type="text/javascript" src="<%=basePath %>/onlineparking/js/onlineparking/findpass.js"></script>
	<script type="text/javascript" src="<%=basePath %>/onlineparking/js/onlineparking/login.js"></script>
	<script type="text/javascript">

      
	//=======================================注册用户 （添加用户） by xumingyue======================================
		
		$("#signBtn").click(function(){
			var userPhone = $("#userPhone").val() ; 
			var userPassWord = $("#userPassWord").val() ; 
			var repeatUserPassWord = $("#repeatUserPassWord").val() ;
		  /*   if(checkPhone()&&checkPassWord()&&checkPassWord()&&checkPaper()){ */
		    	
				var jsonstr = {"parkingManagerPhone":userPhone,"parkingManagerPsd":userPassWord} ;
				 $.ajax({
					type: "post",
					url: 'parkingManagerSignUp',
					data:$.toJSON(jsonstr),
					dataType:'json',
					contentType : 'application/json',
					success:function(data){
						if(data.result=="1"){
							window.location.href="/OnlineParking/index";
						}else if(data.result=="0"){
							$("#signup-box").tips({
								side : 1,
								msg : data.info,
								bg : '#AE81FF',
								time : 3
							});
						}
					}
				}) ;
		   /*  } */
			
		}) ; 
			
	  //验证电话是否存在
	  var flag = false ;
	  var flag1 = false ; //验证密码
	  var flag2 = false ; //验证重复密码
	  var flag3 = false ; //是否接受协议
	  function checkPhone(){
		  var reg = /^[1][0-9]{10}$/ ;
		  var userPhone = $("#userPhone").val() ; 
		  if(userPhone==""){
		    	$("#userPhone").tips({
					side : 2,
					msg : '请输入电话',
					bg : '#AE81FF',
					time : 3
				});
		    	 return false ;
			}else{
			 	if(!reg.test(userPhone)){
			 		$("#userPhone").tips({
						side : 2,
						msg : '电话为以1开头的11位纯数字',
						bg : '#AE81FF',
						time : 3
					});
			 	 return false ;
			 	}
		  	}
		  var jsonstr = {"parkingManagerPhone":userPhone} ;
		  	//debugger ;
			 $.ajax({
				type: "post",
				url: 'hasPhoneNumber',
				data:$.toJSON(jsonstr),
				dataType:'json',
				contentType : 'application/json',
				success:function(data){
					if(data.result=="0"){//不能注册
						$("#userPhone").tips({
							side : 1,
							msg : data.info,
							bg : '#AE81FF',
							time : 3
						});
						flag = false ;
						if(flag&&flag1&&flag2&&flag3){
							$("#signBtn").attr("disabled", false);
						}else{
							$("#signBtn").attr("disabled", true);
						}
						return true ;
					}else if(data.result=="1"){//可以注册
						$("#userPhone").tips({
							side : 1,
							msg : data.info,
							bg : '#AE81FF',
							time : 3
						});						
						flag = true ;	
					//	 alert(flag1+":"+flag2+":"+flag3);
						if(flag&&flag1&&flag2&&flag3){
							$("#signBtn").attr("disabled", false);
						}else{
							$("#signBtn").attr("disabled", true);
						}
						return false ;
					}
				}
			 
			}) ;
			
	  }
	  
	  //验证密码
	  //var flag1 = false ;
	  function checkPassWord(){
		  var userPassWord = $("#userPassWord").val() ;
		  if(userPassWord==""){
				$("#userPassWord").tips({
					side : 2,
					msg : '请输入密码',
					bg : '#AE81FF',
					time : 3
				});
				flag1 = false ;
				if(flag&&flag1&&flag2&&flag3){
					$("#signBtn").attr("disabled", false);
				}else{
					$("#signBtn").attr("disabled", true);
				}
				return false ;
		  }
		  flag1 = true ;
			if(flag&&flag1&&flag2&&flag3){
				$("#signBtn").attr("disabled", false);
			}else{
				$("#signBtn").attr("disabled", true);
			}
		  return true ;
		  
	  }
     //验证重复密码
    // var flag2 = false ;
	  function checkRePassWord(){
		  var repeatUserPassWord = $("#repeatUserPassWord").val() ;
		  var userPassWord= $("#userPassWord").val() ;
		  if(repeatUserPassWord==""){
				$("#repeatUserPassWord").tips({
					side : 2,
					msg : '请输入重复密码',
					bg : '#AE81FF',
					time : 3
				});
				flag2 = false ;
				return false ;
			} 
			
			if(!(repeatUserPassWord==userPassWord)){
				
				$("#repeatUserPassWord").tips({
					side : 2,
					msg : '两次密码输入不一致',
					bg : '#AE81FF',
					time : 3
				});
				flag2 = false ;
				return false ;
			}
			flag2 = true ;
			if(flag&&flag1&&flag2&&flag3){
				$("#signBtn").attr("disabled", false);
			}else{
				$("#signBtn").attr("disabled", true);
			}
		  return true ;
	  }
		//清除注册表单的数据 by xuminyue
		function clearData(){
			$("#userPhone").val("") ;
			$("#userPassWord").val("") ;
			$("#repeatUserPassWord").val("") ;
			 $("#signBtn").attr("disabled", true);
			$("#acceptPapers").attr("checked",false)
		}		
		
	
	   //接受协议事件
	  //var flag3 =false ;
	  function checkPaper(){
		  	 flag3 = false ;		  
			  if($("#acceptPapers").prop("checked")){
				 // alert()
			      flag3 = true ;
			  }else{
				  flag3 =false ;
			  }
			  if(flag && flag1 && flag2 && flag3 ){
				  $("#signBtn").attr("disabled", false); 
				  flag3 = true;
			  }else{
				  $("#signBtn").attr("disabled", true); 
				  flag3 = false ;
				  return false ;
			  }
			  return true ;
	  }
	/*   $("#acceptPapers").change(function(){
		  		  
		  if($("#acceptPapers").prop("checked")){
			  if(flag){
				  $("#signBtn").attr("disabled", false); 
			  }
		  }else{
			  $("#signBtn").attr("disabled", true); 
		  }
	  }); */
	  
		//接受用户协议
		function accept(){
		  /*  var diag = new Dialog();
			diag.Width = 600;
			diag.Height = 500;
			diag.Title = "注册协议";
			diag.InvokeElementId="forlogin" ;
			diag.OKEvent = function(){};//点击确定后调用的方法
			diag.show();		   */
	    }
	   
	   //三个界面切换的方法
		function show_box(id) {
			 if(id=="signup-box"){
				clearData() ;
			} 
			 if(id=="forgot-box"){
				 $("#fPhone").val("") ;
				 $("#verifycode").val("") ;
				 $("#password").val("") ;
				 $("#fRePassWord").val("") ;
			 }
		 $('.widget-box.visible').removeClass('visible');
		 $('#'+id).addClass('visible');
		}
	
	</script>
	</body>