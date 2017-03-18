<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>"><!-- jsp文件头和头部 -->
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
	<script type="text/javascript" src="plugins/datepakier/WdatePicker.js"></script>
	<script type="text/javascript" src="plugins/paginate/js/jquery.paginate.js"></script><!--分页-->
	<!--引入弹窗组件start-->
	<script type="text/javascript" src="system/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
	<script type="text/javascript" src="utiljs/tools.js"></script>
	<script type="text/javascript" src="system/js/jquery.json-2.4.js"></script>
	<style type="text/css">
		/*定义表格布局 使内容溢出不显示 */
		 #table_report{
			table-layout:fixed;
		}
		
		
		/*改变操作中的三个图片的位置*/
		a {
		    color: #08c;
		    display: inline-block;
		    margin-left: 10px;
		    text-decoration: none;
		}
	</style>
	
	<script type="text/javascript">
	 
	var opinions = ${opinions} ;
	 $(function(){
		 if(opinions.result=="0"){
			 $("#page").html("") ;
			 return false ;
		 }
		 getDataList(opinions) ;
		 //分页信息
		 getPaginate( opinions.datas.pages) ;
		//设置页码被选中的样式					
		$("#page li:eq("+opinions.datas.pageNum+")").addClass("active");
	 }) ;
	 function getDataList(opinions){
		 var html = "" ;
		  for(var i = 0 ; i < opinions.datas.result.length ; i ++){
			html +=	"<tr>" ;
			html +=	"<td class='center'></td>" ;
			html +=	"<td class='center'>"+opinions.datas.result[i].opinionUserPhone+"</td>" ;
			html +=	"<td class='center titleholder'>"+opinions.datas.result[i].opinionBody+"</td>" ;
			html +=	"<td class='center'>"+opinions.datas.result[i].opinionTime+"</td>" ;
			html += "</tr>" ;
		 } 
		  //动态获取行号
		 setRowNumByJSON(opinions,'t_datas',html)
	 }
	</script>
	</head>
<body onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">
<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i>首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>客服<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">用户反馈记录</li>
		</ul>
			<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->	
						
  <div class="row-fluid">

	<div class="row-fluid">
	
			<table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="opinionUserPhone" maxlength="11" placeholder="这里输入手机号" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
					 	<input readonly="readonly" type="text" class="Wdate" id="startTime" placeholder="这里选择起始时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</td>
					<td>
						 <input readonly="readonly" type="text" class="Wdate" id="endTime" placeholder="这里选择结束时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
	
			<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<!-- 检索  -->
			<table id="table_report" class="table table-striped table-bordered table-hover">
				
				<thead>
					<tr>
					  <th class='center' style='width:30px'></th>
					  <th class='center'>手机号</th>
					  <th class='center'>反馈内容</th>
					  <th class='center'>时间</th>
					</tr>
				</thead>
										
				<tbody id="t_datas">
				<!-- 开始循环 -->	
					<tr>
						<td colspan="4" class="center">暂无数据</td>
					</tr>
				</tbody>
			</table>
			<div class="page-header position-relative">
			<table style="width:100%;">
				<tbody>
				    <tr>
						<td style="vertical-align:top;" id="page">
						</td> 
					</tr>
				</tbody>
				</table>
			</div>
	</div>

 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='onlineparking/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="onlineparking/js/bootstrap.min.js"></script>
		<script src="onlineparking/js/ace-elements.min.js"></script>
		<script src="onlineparking/js/ace.min.js"></script>
		
		<script type="text/javascript" src="onlineparking/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="onlineparking/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="onlineparking/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		<script type="text/javascript" src="onlineparking/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript">
		function keySearch(){
			var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
			 if(event.keyCode == 13){
				 search(1) ;
			 }
		}
		
		
		function find(){
			giveNum();
			search(1) ;
		}
		
		function search(type){
			var opinionUserPhone =  $("input[name='opinionUserPhone']").val().trim() ;
			var startTime =  $("#startTime").val() ;
			var endTime =  $("#endTime").val() ;
			var currentPage =  $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ; 
			var jsonstr = {"opinionUserPhone":opinionUserPhone,"startTime":startTime,"endTime":endTime,"currentPage":currentPage,"pageSize":pageSize} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectFeedbackRecord',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(opinions){
					if(opinions.datas.total=="0"){
						var html = "" ;
						html +="<tr>" ;
						html +="<td class='center' colspan='4'>暂无数据</td>" ;
						html +="</tr>" ;
						$("#t_datas").html(html) ;
						$("#page").html("") ;
						return false  ;
					}
					$("#currentPage").val(opinions.datas.pageNum) ;
					$("#pageSize").val(opinions.datas.pageSize) ;
					 getDataList(opinions) ;
					//获取分页信息
					if(type!="paginate"){
						getPaginate( opinions.datas.pages) ;
					}
					//设置页码被选中的样式					
					$("#page li:eq("+opinions.datas.pageNum+")").addClass("active");
				}
			}) ;
		}
		
		
		
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
		
	</body>
</html>

