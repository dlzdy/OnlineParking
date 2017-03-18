
<div class="navbar navbar-inverse">
		  <div class="navbar-inner">
		   <div class="container-fluid">
			  <a class="brand" href="/OnlineParking/onlineparking"><img alt="" src="onlineparking/images/icon.png"><span class="adminTit" id="parkingInfoName"></span></a>
			  
			  <ul class="nav ace-nav pull-right">
			
					<li class="light-blue user-profile">
						<a class="user-menu dropdown-toggle" href="javascript:;" data-toggle="dropdown">
							<img alt="Online Parking" src="onlineparking/images/user.jpg" class="nav-user-photo" />
							<span id="user_info">
								<small>欢迎,</small>
								<%=session.getAttribute("loginname") %>
							</span>
							<i class="icon-caret-down"></i>
						</a>
						<ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
						     <li><a onclick="editUserH();" style="cursor:pointer;"><i class="icon-user"></i>查看用户资料</a></li>
						     <li><a onclick="updateUserPass();" style="cursor:pointer;"><i class="icon-user"></i>修改密码</a></li>
						    <!--  <li><a onclick="updateUserPhone();" style="cursor:pointer;"><i class="icon-user"></i>更换手机号</a></li> -->
							<li class="divider"></li> 
							<li><a href="/OnlineParking/onlineparking"><i class="icon-off"></i> 退出</a></li>
						</ul>
					</li>
			  </ul><!--/.ace-nav-->
		   </div><!--/.container-fluid-->
		  </div><!--/.navbar-inner-->
		</div><!--/.navbar-->
	
	
		<!--引入属于此页面的js -->
		<script type="text/javascript" src="onlineparking/js/onlineparking/head.js"></script>
