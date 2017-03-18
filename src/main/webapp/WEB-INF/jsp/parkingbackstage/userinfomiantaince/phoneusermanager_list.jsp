<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- 手机用户管理 -->
	<!DOCTYPE html>
    <html lang="en"><head>
	<meta charset="utf-8">
	<title></title>
	<meta name="description" content="overview &amp; stats">
	<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
	<!-- basic styles -->
	<link href="system/css/bootstrap.min.css" rel="stylesheet">
	<link href="system/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link rel="stylesheet" href="system/css/font-awesome.min.css">
	<!-- page specific plugin styles -->
	<!-- 下拉框-->
	<link rel="stylesheet" href="system/css/chosen.css">
	<!-- ace styles -->
	<link rel="stylesheet" href="system/css/ace.min.css">
	<link rel="stylesheet" href="system/css/ace-responsive.min.css">
	<link rel="stylesheet" href="system/css/ace-skins.min.css">
	<link rel="stylesheet" href="system/css/datepicker.css">
	<link rel="stylesheet" href="plugins/paginate/css/lanrenzhijia.css" /> <!-- 分页样式 -->
	<!-- 日期框 -->
	<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="plugins/paginate/js/jquery.paginate.js"></script><!--分页-->
	<!--引入弹窗组件start-->
	<script type="text/javascript" src="system/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script>
	<script type="text/javascript">
		/* var clientUsers = ${clientUsers} ;
		$(function(){
			getDataList(clientUsers) ;
		}) */
	</script>
	<!--引入弹窗组件end-->
	<!--<script type="text/javascript" src="js/jquery.tips.js"></script>-->
	</head>
<body   onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">
<div id="page-content" class="clearfix">
		<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> 首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>用户信息维护<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">手机用户管理</li>
		</ul>
	</div><!--#breadcrumbs-->

	<div class="row-fluid">
		<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
		<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<!-- 检索  -->
			<table>
				<tbody><tr>
					<td style="vertical-align:top;"> 
						<select class="chzn-select" id="autoPay" data-placeholder="请选择是否自动支付（待定）" style="vertical-align:top;">
					  	<option value="">请选择是否自动支付（待定）</option>
					  	<option value="0">否</option>
					  	<option value="1">是</option>
					  	</select>
					</td> 
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="userPhone" maxlength="11" placeholder="这里输入手机号">
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
				<!-- 	<td style="vertical-align:top;"> 
						<select class="chzn-select" id="sex" data-placeholder="请选择性别" style="vertical-align:top;">
					  	<option value="">请选择性别</option>
					  	<option value="1">男</option>
					  	<option value="0">女</option>
					  	</select>
					</td>  -->
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();" title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</tbody></table>
			<!-- 检索  -->
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="center"></th>
					<th class="center">用户ID</th>
					<th class="center">昵称</th>
					<th class="center">手机号</th>
					<th class="center">性别</th>
					<th class="center">生日</th>
					<th class="center">绑定车辆</th>
					<th class="center">自动支付</th>
					<th class="center">状态</th>
					<th class="center">注册时间</th>
					<th class="center">操作</th>
				</tr>
			</thead>
			<style type="text/css">
			.btn-mini{margin:0 5px;}
			</style>				
			<tbody id="t_datas">
			<!-- 开始循环 -->	
				<tr>
					<td class='center' colspan='11' >暂无数据</td>
				</tr>
			</tbody>
		</table>
		<div class="page-header position-relative">
			<div id="page"> </div>
		</div>
	</div>
	<!-- PAGE CONTENT ENDS HERE -->
  </div>
  <!--/row-->
</div>
<!--/#page-content-->
</div>
<!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		
		<!-- 引入 -->
		<script src="system/js/bootstrap.min.js"></script>
		<script src="system/js/ace-elements.min.js"></script>
		<script src="system/js/ace.min.js"></script>
		
		<script type="text/javascript" src="system/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="system/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="system/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		 <script type="text/javascript" src="system/js/jquery.tips.js"></script><!--提示框-->

		<!--引入属于此页面的js -->
		<script type="text/javascript" src="system/js/systemjs/head.js"></script>
		<script type="text/javascript">
		
		$(top.hangge());
		//keySearch enter键 触发搜索 
		function keySearch(){
			var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
			 if(event.keyCode == 13){
				 search(1) ;
			 }
		}
		//选择框发生变化触发的事件
		$("#autoPay").change(function(){
			giveNum() ;
			search(1);
		});
		//如果当前页和当前页条数为空 则给默认值
		function giveNum(){
				 $("#currentPage").val("1") ;
				 $("#pageSize").val("20") ;
		}
		//搜索 和选择框发生变化时一样，与分页功能 分离  ，将页码值设为默认值 
		function find(){
			giveNum() ;//点击搜索按钮时，将当前页和每页条数清空,并赋予默认值 
			search(1);
		}
		//检索
		function search(type){
			top.jzts();
			var currentPage =  $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var userPhone = $("input[name='userPhone']").val().trim() ;
			var sex = $("#sex").val() ;
			var autoPay = $("#autoPay").val() ;
			var jsonstr = {"userPhone":userPhone,"sex":sex,"autoPay":autoPay,"currentPage":currentPage,"pageSize":pageSize} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectPhoneUser',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(clientUsers){
					if(clientUsers.result=="0"){
						var html = "" ;
						html +="<tr>" ;
						html +="<td class='center' colspan='11'>暂无数据</td>" ;
						html +="</tr>" ;
						$("#t_datas").html(html) ;
						$("#page").html("") ;
						return false  ;
					}
					$("#currentPage").val(clientUsers.datas.pageNum) ;
					$("#pageSize").val(clientUsers.datas.pageSize) ;
					 getDataList(clientUsers) ;
					 //分页xinx
						if(type!="paginate"){
							getPaginate( clientUsers.datas.pages) ;
						}
					//设置页码被选中的样式					
					$("#page li:eq("+clientUsers.datas.pageNum+")").addClass("active");   
				}
			}) ;
		}
		function getDataList(clientUsers){
			var html = "" ;
			for(var i = 0 ; i < clientUsers.datas.result.length ; i ++){
				html+="<tr>" ;
				html+="<td class=\"center\" style=\"width: 30px;\"></td>" ;
				html+="<td class=\"center\">"+clientUsers.datas.result[i].clientUserId+"</td>" ;
				html+="<td class=\"center\">"+clientUsers.datas.result[i].clientUserNickName+"</td>" ;
				html+="<td class=\"center\">"+clientUsers.datas.result[i].clientUserCellphone+"</td>" ;
				if(clientUsers.datas.result[i].clientUserSex=="1"){
					html+="<td class=\"center\">男</td>" ;
				}else if(clientUsers.datas.result[i].clientUserSex=="0"){
					html+="<td class=\"center\">女</td>" ;
				}else{
					html+="<td class=\"center\">未填</td>" ;
				}
				if(clientUsers.datas.result[i].clientUserBirthday==""||clientUsers.datas.result[i].clientUserBirthday==null){
					html+="<td class=\"center\">未填</td>" ;
				}else{
					html+="<td class=\"center\">"+clientUsers.datas.result[i].clientUserBirthday+"</td>" ;
				}
				html+="<td class=\"center\"><a style='cursor:pointer' onclick=\"findBoundCar('"+clientUsers.datas.result[i].clientUserId+"');\">查询 </a></td>" ;
				if(clientUsers.datas.result[i].clientUserAutoPay=="0"){
					html+="<td class=\"center\">否</td>" ;
				}else{
					html+="<td class=\"center\">是</td>" ;
				}
				if(clientUsers.datas.result[i].clientUserActiveMark=="enable"){
					html+="<td class=\"center\">可用</td>" ;
				}else if(clientUsers.datas.result[i].clientUserActiveMark=="disable"){
					html+="<td class=\"center\">冻结</td>" ;
				}
				html+="<td class=\"center\">"+clientUsers.datas.result[i].clientUserSignUpTime+"</td>" ;/*  注册时间 */
				html+="<td style=\"width: 30px;\" class=\"center\">";
				html+="<div class='hidden-phone visible-desktop btn-group'>";
				html+="<div class=\"inline position-relative\">";
				html+="<button class=\"btn btn-mini btn-info\" data-toggle=\"dropdown\"><i class=\"icon-cog icon-only\"></i></button>";
				html+="<ul class=\"dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close\">";
				html+="<li><a style=\"cursor:pointer;\" title=\"编辑\" onclick=\"edit('"+clientUsers.datas.result[i].clientUserId+"');\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"green\"><i class=\"icon-edit\"></i></span></a></li>";
				if(clientUsers.datas.result[i].clientUserActiveMark=="enable"){
				html+="<li><a style=\"cursor:pointer;\" title=\"冻结\" onclick=\"updateState('"+clientUsers.datas.result[i].clientUserCellphone+"','"+clientUsers.datas.result[i].clientUserActiveMark+"');\" class=\"tooltip-error\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"red\"><i class=\"icon-share-alt\"></i></span> </a></li>";
				}else{
				html+="<li><a style=\"cursor:pointer;\" title=\"可用\" onclick=\"updateState('"+clientUsers.datas.result[i].clientUserCellphone+"','"+clientUsers.datas.result[i].clientUserActiveMark+"');\" class=\"tooltip-error\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"green\"><i class=\"icon-share-alt\"></i></span> </a></li>";
				}
/* 				html+="<li><a style=\"cursor:pointer;\" title=\"删除\" onclick=\"del('"+clientUsers.datas.result[i].clientUserId+"');\" class=\"tooltip-error\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"red\"><i class=\"icon-trash\"></i></span> </a></li>"; */
				html+="</ul>";
				html+="</div>";
				html+="</div>";
				html+="</td>";
				html+="</tr>";
			}
			/* $("#t_datas").html(html); */
			//动态获取行号 
			setRowNumByJSON(clientUsers,'t_datas',html) ;
		}
		//新增 by xumingyue
		function add(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toAddPhoneUser';
			 diag.Width = 350;
			 diag.Height = 450;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('' == '0'){ */
						 top.jzts();
						search() ;
					 /* }else{
						// nextPage();
					 } */
				} 
				diag.close();
			 };
			 diag.show();
		}
		
		//将用户手机号冻结
		function updateState(userPhone,activeMark){
			bootbox.confirm("确定要冻结该手机号吗?", function(result) {
				var jsonstr = {"userPhone":userPhone,"activeMark":activeMark} ;
				if(!checkInvalid()){return false} ; //判断session是否失效 
				$.ajax({
					type: "POST",
					contentType : 'application/json',
					url: '/OnlineParking/updateActiveMark',
					data:$.toJSON(jsonstr),
					dataType:'json',
					cache: false,
					success: function(){
						search() ;
					}
				});
			});
		}
		//查找绑定的车辆
		function findBoundCar(userID){
			window.location.href="/OnlineParking/toChangeCarManage?userID="+userID ;
		}
		
		//删除
		function del(clientUserId){
			bootbox.confirm("确定要删除吗?", function(result) {
				var userPhone = $("input[name='userPhone']").val() ;
				var sex = $("#sex").val() ;
				var autoPay = $("#autoPay").val() ;
				var jsonstr = {"clientUserId":clientUserId,"userPhone":userPhone,"sex":sex,"autoPay":autoPay} ;
				if(!checkInvalid()){return false} ; //判断session是否失效 
				$.ajax({
					type: "POST",
					contentType : 'application/json',
					url: '/OnlineParking/delPhoneUser',
					data:$.toJSON(jsonstr),
					dataType:'json',
					cache: false,
					success: function(clientUsers){
						search() ;
					}
				});
			});
		}
		
		//修改 by xumingyue
		function edit(clientUserId){
			 // top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = "/OnlineParking/toEditPhoneUser?clientUserId="+clientUserId;
			 diag.Width = 350;
			 diag.Height = 450
			 diag.CancelEvent = function(){ //关闭事件
				diag.close();
			 	search() ;
			 };
			 diag.show();
		}
		</script>
		
		<script type="text/javascript">
		
		$(function() {
			
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
			//复选框
			$('table th input:checkbox').on('click' , function(){
				var that = this;
				$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
					
			});
			
		});
	 </script>
		
	


</body></html>