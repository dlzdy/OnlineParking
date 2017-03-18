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
	<%@ include file="../../system/admin/top.jsp"%> 
	<link rel="stylesheet" href="plugins/paginate/css/lanrenzhijia.css" /> <!-- 分页样式 -->
	<script type="text/javascript" src="plugins/paginate/js/jquery.paginate.js"></script><!--分页-->
	<script type="text/javascript" src="plugins/datepakier/WdatePicker.js"></script>
	<script type="text/javascript" src="utiljs/tools.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script>
	
	<script type="text/javascript">
	 var allMessages = ${allMessages} ;
	 $(function(){
		 if(allMessages.result=="0"){
			 $("#page").html("") ;
			 return false ;
		 }
		 getDataList(allMessages);
		//分页信息
		getPaginate(allMessages.datas.pages) ;
		//被点击页码的样式  
		$("#page li:eq("+allMessages.datas.pageNum+")").addClass("active");  
	 }) ;
	 
	 function getDataList(allMessages){
		 var html = "" ;
		 for(var i = 0 ; i < allMessages.datas.result.length ; i ++){
			html +=	"<tr>" ;
			html +=	"<td class=\"center\"></td>" ;
			html +=	"<td class=\"center\"><a style='cursor:pointer' onclick=\"showDetailInfo('"+allMessages.datas.result[i].msgId+"')\">"+allMessages.datas.result[i].msgName+"</a></td>" ;
			if(allMessages.datas.result[i].msgBody==""||allMessages.datas.result[i].msgBody==null){
				html +=	"<td class=\"center titleholder\">无</td>" ;
			}else{
				html +=	"<td class=\"center titleholder\">"+allMessages.datas.result[i].msgBody+"</td>" ;
			}
			html +=	"<td class=\"center\">"+allMessages.datas.result[i].msgTime+"</td>" ;
			html +=	"</tr>" ;
		 }
        //重写行号
        setRowNumByJSON(allMessages,"t_datas",html);
	 }
	</script>
	</head>
<body onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">
<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="icon-home"></i> <a href="tab.do" >首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
				<li>通知公告<span class="divider"></span></li>
			</ul>
			<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->	
	<div class="row-fluid">
			<table>
				<tr>
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
			<table id="table_report" class="table table-striped table-bordered table-hover table-fixed">
				<thead>
					<tr>
					    
						<th class="center" style="width:30px"></th>
						<!-- <th class="center" style='display:none'>消息ID</th> -->
						<th class="center">公告标题</th>
						<!-- <th class="center">消息状态</th> -->
						<th class="center">公告内容</th>
						<!-- <th class="center" style='display:none'>消息图片路径</th> -->
						<th class="center">创建时间</th>
						<!-- <th class="center" style="display:none">消息发送时间</th> -->
						<!-- <th class="center">消息发送人</th> -->
						<!-- <th class="center" style="display:none">发送用户Id</th> -->
						
					</tr>
				</thead>
										
				<tbody id="t_datas">
				<!-- 开始循环 -->	
				<tr><td  class="center" colspan="6">暂无数据 </td></tr>
				</tbody>
			</table>
	</div>
 	
 	<div class="page-header position-relative">
		 <div id="page"> </div>
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
		
		$(top.hangge());
		
		function find(){
			giveNum() ;
			search(1);
		}
		
		//检索
		function search(type){
			top.jzts();
			 var msgStatus =  $("#msgStatus").val() ;
			 var startTime =  $("#startTime").val() ;
			 var endTime =  $("#endTime").val() ;
			var currentPage = $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var jsonstr = {"msgStatus":msgStatus,"startTime":startTime,"endTime":endTime,"currentPage":currentPage,"pageSize":"20"} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectAccessory',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(allMessages){
					 if(allMessages.datas.total=="0"){
						 var html = "" ;
						 html +=" <tr><td  class=\"center\" colspan=\"11\">暂无数据 </td></tr>" ;
						 $("#t_datas").html(html) ;
						 $("#page").html("") ;
						 top.hangge() ;
						 return false ;
					 }	
					$("#currentPage").val(allMessages.datas.pageNum) ;
					$("#pageSize").val(allMessages.datas.pageSize) ;
					getDataList(allMessages) ;
					//获取分页信息
					if(type!="paginate"){
						getPaginate( allMessages.datas.pages) ;
					}
					//被点击页码的样式  
					$("#page li:eq("+allMessages.datas.pageNum+")").addClass("active");  
					top.hangge() ;
				}
			}) ;
		}
		//显示公告 详细信息 by xumingyue
		function showDetailInfo(msgId){
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="公告详细信息";
			 diag.URL = '/OnlineParking/toAccDetailInfo?msgId='+msgId;
			 diag.Width = 700;
			 diag.Height = 500;
			 diag.CancelEvent = function(){ //关闭事件
			 	// if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
					//	 top.jzts();
					//	 setTimeout("self.location=self.location",100);
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				//} 
				diag.close();
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
		
	</body>
</html>

