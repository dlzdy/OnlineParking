<%
	String pathl = request.getContextPath();
	String basePathl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathl+"/";
%>

<!-- 涉及到的样式写在了 index.jsp中 -->
		<!-- 本页面涉及的js函数，都在head.jsp页面中     -->
		<div id="sidebar" ><!--  class="menu-min" --> 

				<ul class="nav nav-list">

					<li class="active" id="fhindex">
					<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z19','lm19','首页','/OnlineParking/login_default?uID=<%=session.getAttribute("uID")%>')">
					 <i class="icon-dashboard"></i><span>首页</span></a>
					</li>
					<li id="lm2">
						<a style="cursor:pointer;" class="dropdown-toggle"><img alt="" src="onlineparking/images/sutffmanage.png"> <em>员工管理</em>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<%-- <li id="z3">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z3','lm2','财务人员管理','/OnlineParking/toStuffList?m=1&num=1&userID=<%=session.getAttribute("uID")%>')"><!-- 路径不正确 确定后需要修改 -->
								 <i class="icon-double-angle-right"></i>财务人员管理(待定)
								</a>
							</li>
							<li id="z4">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z4','lm2','登录记录','/OnlineParking/toStuffList?m=1&num=2&userID=<%=session.getAttribute("uID")%>')"><!-- 路径不正确 确定后需要修改 -->
								 <i class="icon-double-angle-right"></i>登录记录(待定)
								</a>
							</li>
							<li id="z5">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z5','lm2','提现记录','/OnlineParking/toStuffList?m=1&num=3&userID=<%=session.getAttribute("uID")%>')"><!-- 路径不正确 确定后需要修改 -->
								 <i class="icon-double-angle-right"></i>提现记录(待定)
								</a>
							</li> --%>
							<li id="z6">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z6','lm2','收费员管理','/OnlineParking/toStuffList?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>收费员管理
								</a>
							</li>
							<%-- <li id="z7">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z7','lm2','收费员交接班记录','/OnlineParking/toStuffShiftRecord?m=1&num=5&userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>收费员交接班记录
								</a>
							</li> --%>
							<li id="z8">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z8','lm2','收费员流水','/OnlineParking/toStuffRunWater?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>收费员流水
								</a>
							</li>
						</ul>
					</li>
					
					<li id="lm3">
						<a style="cursor:pointer;" class="dropdown-toggle"><img alt="" src="onlineparking/images/park.png"> <em>停车场管理</em>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z9">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z9','lm3','停车场信息','/OnlineParking/findParkList?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>停车场信息
								</a>
							</li>
							<li id="z11">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z11','lm3','停车场订单记录','/OnlineParking/toRunWaterRecord?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>订单记录
								</a>
							</li>
							<li id="z10">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z10','lm3','停车场收费表单','/OnlineParking/toCostForm?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>收费标准
								</a>
							</li>
						<%-- 	<li id="z11">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z11','lm3','设备管理','/OnlineParking/findDeviceList?m=2&num=9&userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>设备管理
								</a>
							</li> --%>
							<li id="z12">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z12','lm3','收款卡号设置/支付设置','/OnlineParking/toPay?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>收款卡号设置/支付设置
								</a>
							</li>
						</ul>
					</li>
					
			<%-- 		<li id="lm4">
						<a style="cursor:pointer;" class="dropdown-toggle"><i class="icon-comments"></i><span>停车场订单记录</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z13">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z13','lm4','停车场订单记录','/OnlineParking/toRunWaterRecord?m=3&num=11&userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>停车场订单记录
								</a>
							</li>
						</ul>
					</li> --%>
					
					<li id="lm5">
						<a style="cursor:pointer;" class="dropdown-toggle"><img alt="" src="onlineparking/images/financial.png"> <em>财务管理</em>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z14">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z14','lm5','财务报表','/OnlineParking/toFinancialStatement?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>财务报表
								</a>
							</li>
							<li id="z15">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z15','lm6','提现','/OnlineParking/toWithdrawals?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>提现（待定）
								</a>
							</li>
						</ul>
					</li>
					
					<li id="lm6">
						<a style="cursor:pointer;" class="dropdown-toggle"><img alt="" src="onlineparking/images/accessory.png"> <em>通知公告</em>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z16">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z16','lm7','通知公告管理','/OnlineParking/toAccessory?userID=<%=session.getAttribute("uID")%>')">
								 <i class="icon-double-angle-right"></i>通知公告
								</a>
							</li>
						</ul>
					</li>
					
					
					<!-- 附件停车场信息后台 -->
					<!-- <li id="lm7">
						<a style="cursor:pointer;" class="dropdown-toggle"><i class="icon-comments"></i><span>基础数据维护(后台)</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z17">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z17','lm8','停车场信息维护','/OnlineParking/toParkInfo?m=6&num=15')">
								 <i class="icon-double-angle-right"></i>停车场信息维护
								</a>
							</li>
						</ul>
					</li> -->
					
					<!--订单维护后台 -->
					<!-- <li id="lm8">
						<a style="cursor:pointer;" class="dropdown-toggle"><i class="icon-comments"></i><span>订单维护 (后台)</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z18">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z18','lm8','支付订单维护','/OnlineParking/toPayOrderMaintenance?m=7&num=16')">
								 <i class="icon-double-angle-right"></i>支付订单维护
								</a>
							</li>
						</ul>
					</li>
					 -->
					<!--产品主页管理 -->
					<!-- <li id="lm9">
						<a style="cursor:pointer;" class="dropdown-toggle"><i class="icon-comments"></i><span>产品主页管理(后台)</span>
						<b class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li id="z19">
								<a style="cursor:pointer;" target="mainFrame" onclick="siMenu('z19','lm9','banner图替换','/OnlineParking/toChangeBannerPicture?m=8&num=17')">
								 <i class="icon-double-angle-right"></i>banner图替换
								</a>
							</li>
						</ul>
					</li> -->

				</ul><!--/.nav-list-->

				 <!--  <div id="sidebar-collapse"><i class="icon-double-angle-left"></i></div> --> 

			</div><!--/#sidebar-->

