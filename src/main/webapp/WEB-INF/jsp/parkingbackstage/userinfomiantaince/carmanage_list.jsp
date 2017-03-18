<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- 车辆管理 -->
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
	<script type="text/javascript" src="system/js/jquery.json-2.4.js"></script>
	<script type="text/javascript">
	var carManagers= ${carManagers} ;
		$(function(){
			if(carManagers.result=="0"){
				$("#page").html("") ;
				return false ;
			}
			getDataList(carManagers) ;
			//$("#page").html(getPage(carManagers)) ;
			search(1) ;
			//设置页码被选中的样式					
			$("#page li:eq("+carManagers.datas.pageNum+")").addClass("active");   
		}) ;
	</script>
	<style type="text/css">
		.btn-mini{margin:0 5px;}
	</style> 	
			
	<!--引入弹窗组件end-->
	</head>
<body onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
   	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i>首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>用户信息维护<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">车辆管理</li>
		</ul>
	</div><!--#breadcrumbs-->

	<div class="row-fluid">
		<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
		<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<!-- 检索  -->
			<table>
				<tbody><tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="userID" maxlength="100" placeholder="这里输入用户ID" value="${userID }">
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="carNo" maxlength="100" placeholder="这里输入车牌号">
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();" title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</tbody></table>
			<!-- 检索  -->
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="center" style="width:30px"></th>
					<th class="center">车辆ID</th>
					<th class="center">车牌号</th>
					<th class="center">车辆状态</th>
					<th class="center">用户ID</th>
				</tr>
			</thead>
			
			<tbody id="t_datas">
			<!-- 开始循环 -->	
				<tr>
					<td colspan="5" class="center">暂无数据</td>
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
		// 检索
		function search(type){
			top.jzts();
			var currentPage =  $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var userID = $("input[name='userID']").val().trim() ;
			var carNo = $("input[name='carNo']").val().trim() ;
			var jsonstr = {"userID":userID,"carNo":carNo,"currentPage":currentPage,"pageSize":pageSize} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectCarManage',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(carManagers){
					
					if(carManagers.datas==""||carManagers.datas==null||carManagers.result=="0"){
						var html = "" ;
						html+="<tr>" ;
						html+="<td colspan=\"5\" class=\"center\">暂无数据</td>" ;
						html+="</tr>" ;
						$("#t_datas").html(html) ;
						$("#page").html("") ;
						return false ;
					}
					$("#currentPage").val(carManagers.datas.pageNum) ;
					$("#pageSize").val(carManagers.datas.pageSize) ;
					getDataList(carManagers) ;
					//获取分页信息
					if(type!="paginate"){
						getPaginate( carManagers.datas.pages) ;
					}
					//设置页码被选中的样式					
					$("#page li:eq("+carManagers.datas.pageNum+")").addClass("active");   
				}
			}) ;			
		}
		
		function getDataList(carManagers){

			var html = "" ;
			for(var i = 0 ; i < carManagers.datas.result.length ; i ++){
				html += "<tr>";
				html += "<td class=\"center\" style=\"width: 30px;\"></td>";
				html += "<td class=\"center\">"+carManagers.datas.result[i].carManageId+"</td>";
				html += "<td class=\"center\">"+carManagers.datas.result[i].clientUserCarNo+"</td>";
				if(carManagers.datas.result[i].clientUserCarActiveMark=="enable"){
					html += "<td class=\"center\">可用</td>";
				}else{
					html += "<td class=\"center\">不可用</td>";
				}
				
				html += "<td class=\"center\">"+carManagers.datas.result[i].clientUserId+"</td>";
				html += "</tr>";
			}
			//动态设置行号 
			setRowNumByJSON(carManagers,'t_datas',html) ;
			
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