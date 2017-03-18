<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>停车场系统后台</title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link rel="stylesheet" href="system/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="system/css/bootstrap-responsive.min.css"/>
		<link rel="stylesheet" href="system/css/font-awesome.min.css" />
		<link rel="stylesheet" href="system/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="system/css/ace-skins.min.css" />
		<link rel="stylesheet" href="system/css/ace.min.css" />
		<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
		<script type="text/javascript" src="system/zDialog/zDrag.js"></script>
		<script type="text/javascript" src="system/js/systemjs/user_edit.js"></script>
	
		<style type="text/css">
			.commitopacity{position:absolute; width:100%; height:100px; background:#7f7f7f; filter:alpha(opacity=50); -moz-opacity:0.8; -khtml-opacity: 0.5; opacity: 0.5; top:0px; z-index:99999;}
			.position-relative h1{font-size:20px;font-family:"\5FAE\8F6F\96C5\9ED1";}
		</style>

	</head>
	<body>
	<input type="hidden" id="systemManagerUsername" value="<%=session.getAttribute("systemManagerUsername") %>"/>
	<input type="hidden" id="systemManagerPsd" value="<%=session.getAttribute("systemManagerPsd") %>"/>
	<input type="hidden" id="systemManagerId" value="<%=session.getAttribute("systemManagerId") %>"/>
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
			   <div class="container-fluid">
					<a class="brand" href="/OnlineParking/system/"><small><img alt="" src="system/images/icon.png"></small> </a>
					<ul class="nav ace-nav pull-right">
						<li class="light-blue user-profile">
							<a class="user-menu dropdown-toggle" href="javascript:;" data-toggle="dropdown">
								<img alt="Online Parking" src="system/images/user.jpg" class="nav-user-photo">
								<span id="user_info">
								<small>欢迎,</small>
								<%=session.getAttribute("systemManagerUsername") %>
							</span>
							<i class="icon-caret-down"></i>
							</a>
							<ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
								<!-- <li><a onclick="editUserH();" style="cursor:pointer;"><i class="icon-user"></i>编辑用户信息</a></li> -->
								<li><a onclick="editUserH();" style="cursor:pointer;"><i class="icon-user"></i>修改密码</a></li>
								<!-- <li><a onclick="updateUserPhone();" style="cursor:pointer;"><i class="icon-user"></i>更换手机号</a></li> -->
								<li class="divider"></li> 
								<li><a href="/OnlineParking/system/"><i class="icon-off"></i> 退出</a></li>
							</ul>
						</li>
					</ul><!--/.ace-nav-->
				</div>
			</div>
		</div>
		<!--/.navbar-inner-->
		</div>
		<!--/.navbar-->

		<div class="container-fluid" id="main-container">
			<a href="#" id="menu-toggler"><span></span></a><!-- menu toggler -->
			<!-- siderber -->
			<div id="sidebar" class="">

				<ul class="nav nav-list">

					<li class="active" id="fhindex">
					  <a onclick="change(1);"><i class="icon-dashboard"></i><span>首页</span></a>
					</li>
					<li id="lm2">
						<a style="cursor:pointer;" class="dropdown-toggle" onclick="change(2);"><i class="icon-list-alt"></i><span>产品主页管理</span>
						<b class="arrow "></b></a>
					</li> 	
					<li id="lm2">
						<a style="cursor:pointer;" class="dropdown-toggle"><i class="icon-desktop"></i><span>基础数据维护</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z3">
								<a style="cursor:pointer;" target="mainFrame" onclick="change(17);">
								 <i class="icon-double-angle-right"></i>停车场管理员信息
								</a>
							</li>
							<li id="z3">
								<a style="cursor:pointer;" target="mainFrame" onclick="change(3);"><!-- 路径不正确 确定后需要修改 -->
								 <i class="icon-double-angle-right"></i>停车场人员管理
								</a>
							</li>
							<li id="z4">
								<a style="cursor:pointer;" target="mainFrame" onclick="change(4);"><!-- 路径不正确 确定后需要修改 -->
								 <i class="icon-double-angle-right"></i>停车场信息管理
								</a>
							</li>
							<li id="z5">
								<a style="cursor:pointer;" target="mainFrame" onclick="change(16);">
								 <i class="icon-double-angle-right"></i>停车场设备管理
								</a>
							</li>
						</ul>
					</li>
					
					<li id="lm3">
						<a style="cursor:pointer;" class="dropdown-toggle"><i class="icon-list"></i><span>订单维护</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z9">
								<a style="cursor:pointer;" target="mainFrame" onclick="change(5);">
								 <i class="icon-double-angle-right"></i>停车订单维护
								</a>
							</li>
							<li id="z10">
								<a style="cursor:pointer;" target="mainFrame"  onclick="change(6);">
								 <i class="icon-double-angle-right"></i>充值订单维护
								</a>
							</li>
							<li id="z11">
								<a style="cursor:pointer;" target="mainFrame"  onclick="change(7);">
								 <i class="icon-double-angle-right"></i>支付订单维护
								</a>
							</li>
							<!-- <li id="z12">
								<a style="cursor:pointer;" target="mainFrame"  onclick="change(8);">
								 <i class="icon-double-angle-right"></i>提现订单流水
								</a>
							</li> -->
						</ul>
					</li>
					
					<li id="lm4">
						<a style="cursor:pointer;" class="dropdown-toggle"><i class="icon-calendar"></i><span>用户信息维护</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z14">
								<a style="cursor:pointer;" target="mainFrame"  onclick="change(10);">
								 <i class="icon-double-angle-right"></i>手机用户管理
								</a>
							</li>
							<li id="z15">
								<a style="cursor:pointer;" target="mainFrame"  onclick="change(11);">
								 <i class="icon-double-angle-right"></i>车辆管理
								</a>
							</li>
							<li id="z16">
								<a style="cursor:pointer;" target="mainFrame"  onclick="">
								 <i class="icon-double-angle-right"></i>充值渠道账号管理(待定)
								</a>
							</li>
						</ul>
					</li>
					
					<li id="lm7">
						<a style="cursor:pointer;" class="dropdown-toggle"  onclick="change(14);"><i class="icon-bullhorn"></i><span>通知公告</span>
						<b class="arrow"></b></a>
					</li>
					<li id="lm8">
						<a style="cursor:pointer;" class="dropdown-toggle" ><i class="icon-briefcase"></i><span>客服</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z14">
								<a style="cursor:pointer;" target="mainFrame"  onclick="change(15);">
								 <i class="icon-double-angle-right"></i>用户反馈记录
								</a>
							</li>
					    </ul>
					</li>
					<li id="lm9">
						<a style="cursor:pointer;" class="dropdown-toggle" ><i class="icon-refresh"></i><span>资金账户变动记录</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z15">
								<a style="cursor:pointer;" target="mainFrame"  onclick="change(12);">
								 <i class="icon-double-angle-right"></i>账户充值变动（待定）
								</a>
							</li>
							<li id="z16">
								<a style="cursor:pointer;" target="mainFrame"  onclick="change(13);">
								 <i class="icon-double-angle-right"></i>资金交易变动（待定）
								</a>
							</li>
					    </ul>
					</li>
					<li id="lm10">
						<a style="cursor:pointer;" class="dropdown-toggle"  onclick="change(18);"><i class="icon-random"></i><span>充电桩</span>
						</a>
					</li>
				</ul><!--/.nav-list-->
			</div>
			<!-- end siderber -->
			<div id="main-content" class="clearfix">
				<!-- <div id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home"></i> <a href="#">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
						<li class="active">导航</li>
					</ul>.breadcrumb
				</div> --><!--#breadcrumbs-->
				<!-- iframe -->
				<iframe id="mainFrame" style="overflow-x: hidden; display: inline;" allowtransparency="true" frameborder="0" width="100%" height="100%" src="/OnlineParking/toChangeBannerPicture"></iframe>
				<!-- end iframe -->
			</div>
			<!-- #main-content -->
		</div>
		
		<!-- 页面底部 -->
		<%@ include file="../../system/admin/footer.jsp" %>
		<script src="system/js/bootstrap.min.js"></script>
		<script src="system/js/ace-elements.min.js"></script>
		<script src="system/js/ace.min.js"></script>
		
		<script type="text/javascript">
	
			$(function() {
				
				//主框架 自适应宽度
					function cmainFrame(){
						var hmain = document.getElementById("mainFrame");
						var bheight = document.documentElement.clientHeight;
						hmain .style.width = '100%';
						hmain .style.height = (bheight  - 51) + 'px';
						/* var bkbgjz = document.getElementById("bkbgjz");
						bkbgjz .style.height = (bheight  - 41) + 'px'; */
						
					}
					cmainFrame();
					window.onresize=function(){  
						cmainFrame();
					};
					jzts();
					
			});
			
		
			
			
			function change(i){
				if(!checkInvalid()){return false} ; //判断session是否失效 
				
				if(i==2){
					document.getElementById("mainFrame").src="/OnlineParking/toChangeBannerPicture"; //产品主页管理
				}
				if(i==17){
					document.getElementById("mainFrame").src="/OnlineParking/toManagerInfo"; //基础数据维护-->停车场管理员信息 
				}
				if(i==3){
					document.getElementById("mainFrame").src="/OnlineParking/toParkStuff"; //基础数据维护-->停车场员工管理 
				}
				if(i==4){
					document.getElementById("mainFrame").src="/OnlineParking/toParkInfo";//基础数据维护-->停车场信息维护
				}
				if(i==16){
					document.getElementById("mainFrame").src="/OnlineParking/toParkDevice";//基础数据维护-->停车场设备管理
				}
				if(i==5){
					document.getElementById("mainFrame").src="/OnlineParking/toParkCarOrder"; //订单维护--->停车订单维护
				}
				if(i==6){
					document.getElementById("mainFrame").src="/OnlineParking/toRechargeOrder"; //订单维护--->充值订单维护
				}
				if(i==7){
					document.getElementById("mainFrame").src="/OnlineParking/toPayOrderMaintenance";//订单维护--->支付订单维护
				}
				if(i==8){
					document.getElementById("mainFrame").src="/OnlineParking/toWithDrawsOrder"; //订单维护---> 提现订单维护
				}
				if(i==9){
					
					document.getElementById("mainFrame").src="rechargeordermaintance.jsp";
				}
				if(i==10){
					document.getElementById("mainFrame").src="/OnlineParking/toPhoneUser"; //用户信息维护--->手机用户管理
				}
			
				if(i==11){
					document.getElementById("mainFrame").src="/OnlineParking/toCarManage";//用户信息维护--->车辆 管理
				}
			
				if(i==14){
					document.getElementById("mainFrame").src="/OnlineParking/toSystemAccessory";//通知公告
				}
				
				if(i==15){
					document.getElementById("mainFrame").src="/OnlineParking/toFeedbackRecord";//用户反馈记录
				}
				
				//充电桩 
				if(i==18){
					document.getElementById("mainFrame").src="/OnlineParking/toChargingPile"; //充电桩 
				}
			}
		/* 	$(function(){
				$('#mainFrame').find('.tooltip-success').live('click',function(){
					
				})
			}) */
		</script>
	</body>
</html>
