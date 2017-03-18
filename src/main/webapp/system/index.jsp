<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>停车场系统后台</title>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<link rel="stylesheet" href="css/ace.min.css" />
		<script src="1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.tips.js"></script>
		<script type="text/javascript" src="js/systemjs/index.js"></script>
		<script type="text/javascript" src="js/jquery.json-2.4.js"></script>
		<style type="text/css">
		  /*  #login-box{position: fixed;top:50%;left:50%;margin:-189px 0 0 -194px;width: 388px;height: 317px;} */
			 #login-box{margin-top:150px}
			 #signup-box{margin-top:150px}
			 #login-box .user-signup-link {
			    color: #fff;
			}
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
		<script type="text/javascript">
		//三个界面切换的方法
		function show_box(id) {
			 $('.widget-box.visible').removeClass('visible');
			 $('#'+id).addClass('visible');
		}
		
		
		</script>
	</head>
	<body class="login-layout" onkeydown="enterDown();">
	
		<!-- 系统后台登录界面 -->
		<div class="container-fluid" id="main-container">
			<div id="main-content">
				<div class="row-fluid">
					<div class="span12">
						
						<div class="login-container">
							<div class="row-fluid">
								
							</div>
							<div class="space-6"></div>
							<div class="row-fluid">
								<div class="position-relative">
									<div id="login-box" class="visible widget-box no-border">
										<div class="widget-body">
											<div class="widget-main">
												<h4 id="errorMsg" class="header lighter bigger" style="font-size:18px;font-family:微软雅黑"><img alt="" src="images/icon_login.png">&nbsp;&nbsp;Online停车系统后台</h4>

												<div class="space-6"></div>
													<fieldset>
														<label>
															<span class="block input-icon input-icon-right">
																<input type="text" class="span12" placeholder="用户名" id="userName" maxlength="20" /><!--  onblur="checkUserName();"-->
																<i class="icon-user"></i>
															</span>
														</label>
														<label>
															<span class="block input-icon input-icon-right">
																<input type="password" class="span12" placeholder="密码" maxlength="20" id="passWord" /><!-- onblur="checkPassWord();" -->
																<i class="icon-lock"></i>
															</span>
														</label>
														<div class="space"></div>
														<div class="row-fluid">
															<button onclick="login();" class="span4 btn btn-small btn-primary" style="width:100%"> 登录</button>
														</div>

													</fieldset>
											</div>
											<!--/widget-main-->
											<!-- <div class="toolbar clearfix">
												<div>
												</div>
												<div>
												 <a  class="user-signup-link" style="cursor:pointer" onclick="show_box('signup-box')">注册 <i class="icon-arrow-right"></i></a>
												</div>
											 </div>/toolbar clearfix
										</div> -->
										<!--/widget-body-->
									</div>
									<!--/login-box-->
								
								
									
		<!-- 系统后台注册界面 -->
	<div id="signup-box" class=" widget-box no-border">
		<div class="widget-body">
		 <div class="widget-main">
			<h4 id="signErrorMsg" class="header lighter bigger"><i class="icon-coffee green"></i>新用户注册</h4>
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
							<input type="text" class="span12" placeholder="请输入用户名" id="signUserName" name="signUserName" maxlength="20" onblur="checkSignUserName();"/>
							<i class="icon-user"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="password" class="span12" placeholder="请输入密码" id="signPassWord" name="signPassWord" maxlength="20" onblur="checkSignPassWord();"/>
							<i class="icon-lock"></i>
						</span>
					</label>
					<label>
						<span class="block input-icon input-icon-right">
							<input type="password" class="span12" placeholder="请重新输入密码" id="repeatPassWord" name="repeatPassWord" maxlength="20" onblur="checkRePassWord();"  />
							<i class="icon-retweet"></i>
						</span>
					</label>
					
					<!-- <label>
						<input type="checkbox" id="acceptPapers" onclick="checkPaper();"><span class="lbl"> 我接受用户协议<a onclick="show_box('forlogin')">注册协议</a></span>
					</label> -->
					
					<div class="space-24"></div>
					<div class="row-fluid">
						<!-- <button type="reset" class="span4 btn btn-small btn-primary"><i class="icon-key"></i>重置</button> -->
						<button id="signBtn" onclick="signUser();" class="span4 btn btn-small btn-primary"  style="margin-left: 110px"><i class="icon-key"></i>注册</button>
					</div>
				  </fieldset>
			</div>
			<div class="toolbar center">
				<a class="back-to-login-link" style="cursor:pointer" onclick="show_box('login-box')"  ><i class="icon-arrow-left"></i> 返回到登录界面</a>
			</div><!-- toolbar center -->
	 </div><!--/widget-body-->
	</div><!--/signup-box--><!-- 注册界面结束 -->
								
								</div><!--/position-relative-->
							</div>
						</div>
					</div><!--/span-->
				</div><!--/row-->
			</div>
		</div><!--/.fluid-container-->
	
	</body>
</html>
