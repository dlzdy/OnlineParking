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
		
		/*  td{
			word-break:keep-all;  
		    white-space:nowrap;
		    overflow:hidden;
		    text-overflow:ellipsis;
		} */
		
		/*改变操作中的三个图片的位置*/
		.operate-btn a {
		    color: #08c;
		    display: inline-block;
		    margin-left: 10px;
		    text-decoration: none;
		} 
	</style>
	
	<script type="text/javascript">
	 var allMessages = ${allMessages} ;
	 $(function(){
		 if(allMessages.result=="0"){
			 $("#page").html("") ;
			 return false ;
		 }
		getDataList(allMessages) ;
		//$("#page").html( getPage(allMessages) );  
		getPaginate(allMessages.datas.pages) ;
		//设置页码被选中的样式					
		//$("#page li:eq("+allMessages.datas.pageNum+")").addClass("active");
	 }) ;
	 function getDataList(allMessages){
		  var html = "" ;
			 for(var i = 0 ; i < allMessages.datas.result.length ; i ++){
				html +=	"<tr>" ;
				html +=	"<td class=\"center\"></td>" ;
				html +=	"<td class=\"center\" style='display:none'>"+allMessages.datas.result[i].msgId+"</td>" ;
				html +=	"<td class=\"center\"><a style='cursor:pointer' onclick=\"showDetailInfo('"+allMessages.datas.result[i].msgId+"')\">"+allMessages.datas.result[i].msgName+"</a></td>" ;
				if(allMessages.datas.result[i].msgStatus=="0"){
					html +=	"<td class=\"center\">未发送</td>" ;
				}else if(allMessages.datas.result[i].msgStatus=="1"){
					html +=	"<td class=\"center\">已发送</td>" ;
				}else if(allMessages.datas.result[i].msgStatus=="2"){
					html +=	"<td class=\"center\">发送完成</td>" ;
				}
				if(allMessages.datas.result[i].msgBody==""||allMessages.datas.result[i].msgBody==null){
					html +=	"<td class=\"center titleholder \">无</td>" ;
				}else{
					html +=	"<td class=\"center titleholder\">"+allMessages.datas.result[i].msgBody+"</td>" ;
				}
				
				/* html +=	"<td class=\"center\">"+allMessages.datas.result[i].msgBodyImgUrl+"</td>" ; */
				html +=	"<td class=\"center\">"+allMessages.datas.result[i].msgTime+"</td>" ;
				html +=	"<td class=\"center\" style='display:none'>"+allMessages.datas.result[i].msgSendTime+"</td>" ;
				if(allMessages.datas.result[i].msgSendName==null||allMessages.datas.result[i].msgSendName==""){
					html +=	"<td class=\"center\"></td>" ;
				}else{
					html +=	"<td class=\"center\">"+allMessages.datas.result[i].msgSendName+"</td>" ;
				}
				html +=	"<td class=\"center\" style='display:none'>"+allMessages.datas.result[i].msgUserId+"</td>" ;
				html +=	"<td style=\"width: 40px;\" class=\"center operate-btn\">" ;
				
				if(allMessages.datas.result[i].msgStatus!="0"){
					html +=	"<a style=\"cursor:pointer;\" title=\"删除\" onclick=\"del('确定要删除选中的数据吗?');\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"red\"><i class=\"icon-trash\"></i></span></a>" ;
				}else{
					html +=	"<a style=\"cursor:pointer;\" title=\"编辑\" onclick=\"editAccessory('"+allMessages.datas.result[i].msgId+"');\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"green\"><i class=\"icon-edit\"></i></span></a>" ;
					html +=	"<a style=\"cursor:pointer;\" title=\"发送\" onclick=\"sendMessage('"+allMessages.datas.result[i].msgName+"');\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"green\"><i class=\"icon-envelope\"></i></span></a>" ;
					html +=	"<a style=\"cursor:pointer;\" title=\"删除\" onclick=\"del('确定要删除选中的数据吗?');\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"red\"><i class=\"icon-trash\"></i></span></a>" ;
				}
				html +=	"  </td>" ;
				html +=	"</tr>" ;
			 }
			 
			//动态获取行号
			 setRowNumByJSON(allMessages,'t_datas',html) ;
	 }
	</script>
	</head>
<body onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">
<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> 首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>通知公告<span class="divider"></span></li>
		</ul>
	</div>
	<!--#breadcrumbs-->	
	<div class="row-fluid">
			<!-- 检索  -->
			<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<div class="row-fluid">
			
			<table>
				<tr>
					<td style="vertical-align:top;"> 
					<select class="chzn-select" id="msgStatus" data-placeholder="请选择消息状态" style="vertical-align:top;">
				  	<option value="">请选择消息状态</option>
				  	<option value="0">未发送</option>
				  	<option value="1">已发送</option>
				  	<option value="2">发送完成</option>
				  	</select>
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
			
			
			<input type="hidden" id="systemManagerUsername" value="<%=session.getAttribute("systemManagerUsername") %>"/>
			<table id="table_report" class="table table-striped table-bordered table-hover table-fixed">
				<thead>
					<tr>
						<th class="center" style="width:30px"></th>
						<th class="center" style='display:none'>消息ID</th>
						<th class="center">公告标题</th>
						<th class="center">消息状态</th>
						<th class="center">公告内容</th>
						<!-- <th class="center">消息图片路径</th> -->
						<th class="center">创建时间</th>
						<!-- <th class="center" style="display:none">消息发送时间</th> -->
						<th class="center">消息发送人</th>
						<!-- <th class="center" style="display:none">发送用户Id</th> -->
						<th class="center" style="width:80px" >操作</th>
						
					</tr>
				</thead>
										
				<tbody id="t_datas">
				<!-- 开始循环 -->	
				<tr><td class='center' colspan='7'>暂无数据</td></tr>
				</tbody>
			</table>
		</div>
	</div>
 	
 	<div class="page-header position-relative">
			<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
					<a class="btn btn-small btn-success" onclick="addAccessory();">新增</a>
				</td>
			</tr>
			<tr>
			 	<td style="vertical-align:top;" id="page">
					 
				</td> 
			</tr>
		</table>
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
	
		//显示公告 详细信息 by xumingyue
		function showDetailInfo(msgId){
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="公告详细信息";
			 diag.URL = '/OnlineParking/toSysAccDetailInfo?msgId='+msgId;
			 diag.Width = 700;
			 diag.Height = 500;
			 diag.CancelEvent = function(){ //关闭事件
			 	// if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				// } 
				diag.close();
			 };
			 diag.show();
		}
		
		
		
		
		//通知公告编辑 by xumingyue
		function editAccessory(msgId){
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = '/OnlineParking/toSysEditAccessory?msgId='+msgId;
			 diag.Width = 720;
			 diag.Height = 520;
			 diag.CancelEvent = function(){ //关闭事件
			 	// if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				// } 
				diag.close();
			 };
			 diag.show();
		}
		
		
		$(top.hangge());
		
		$("#msgStatus").change(function(){
			giveNum() ;
			search(1) ;
		}) ;
		
		function find(){
			search(1) ;
		}
		
		
		function search(type){
			 var msgStatus =  $("#msgStatus").val() ;
			 var startTime =  $("#startTime").val() ;
			 var endTime =  $("#endTime").val() ;
			 var currentPage =  $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ; 
			var jsonstr = {"msgStatus":msgStatus,"startTime":startTime,"endTime":endTime,"currentPage":currentPage,"pageSize":pageSize} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectSystemAccessory',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(allMessages){
					if(allMessages.datas.total=="0"){
						var html = "" ;
						html +="<tr>" ;
						html +="<td class='center' colspan='7'>暂无数据</td>" ;
						html +="</tr>" ;
						$("#t_datas").html(html) ;
						$("#page").html("") ;
						return false  ;
					}
					$("#currentPage").val(allMessages.datas.pageNum) ;
					$("#pageSize").val(allMessages.datas.pageSize) ;
					 getDataList(allMessages) ;
					//获取分页信息
					if(type!="paginate"){
						getPaginate( allMessages.datas.pages) ;
					}
					//设置页码被选中的样式					
					$("#page li:eq("+allMessages.datas.pageNum+")").addClass("active");   
				}
			}) ;
		}
		//新增公告 by xumingyue
		function addAccessory(){
		//	 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toSystemAddAccessory';
			 diag.Width = 600;
			 diag.Height = 450;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						// top.jzts();
						search() ;
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				} 
				diag.close();
			 };
			 diag.show();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		}
		

		//发送消 息1消息主题2消息发送者
		function sendMessage(msgName,msgSendName){
			var msgSendName = $("#systemManagerUsername").val() ;
			var jsonstr = {"msgName":msgName,"msgSendName":msgSendName} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/sendMessage',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(stuffs){
					alert("消息发送成功 ");
					top.jzts();
					search() ;
				}
			}) ;
		}
		//删除
		function del(Id){
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					top.jzts();
				}
			});
		}
		
		//隐藏 窗口
    	function hideF(){
    		$("#zhongxin").hide();
    		top.Dialog.close();
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

