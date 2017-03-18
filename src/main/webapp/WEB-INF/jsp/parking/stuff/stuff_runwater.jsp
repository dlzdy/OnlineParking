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
	<script type="text/javascript" src="plugins/datepakier/lang/zh-cn.js"></script>
	<script type="text/javascript" src="utiljs/tools.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script>
	</head>
	
	<script type="text/javascript">
	    var handsetOrders = ${handsetOrders} ; 
		$(function(){
			var parkInfo = ${parkInfo} ; //停车场信息
			$("#indexInfo").html(parkInfo.datas.parkingInfoName); //获取停车场名称 (XXX停车场后台首页)
			$("#parkingInfoId").val(parkInfo.datas.parkingInfoId); //获取停车场id
			if(handsetOrders.result=="0"){
				$("#page").html("") ;
				countHide(); //隐藏统计 该方法在jquery-1.7.2.js中
				return false ;
			}
			getDataList(handsetOrders) ;
			//分页信息
			getPaginate(handsetOrders.datas.pages)
			//被点击页码的样式 
			$("#page li:eq("+handsetOrders.datas.pageNum+")").addClass("active");  
			
			//统计			
			countShow();//显示统计
			$("#costAll").html(getAll('data_list',3)) ;
			$("#recordAll").html(getAll('data_list',4)) ;
		}) ;
		function getDataList(handsetOrders){
			var html = "" ;
			for(var i = 0 ; i < handsetOrders.datas.result.length; i ++){
				html += "<tr>" ;
				html += "<td class=\"center\"></td>" ;
				html += "<td class=\"center\">"+handsetOrders.datas.result[i].managerName+"</td>" ;
				html += "<td class=\"center\">"+handsetOrders.datas.result[i].phone+"</td>" ;
				if(handsetOrders.datas.result[i].sumCost==null||handsetOrders.datas.result[i].sumCost==""){
					html += "<td class=\"center\">0</td>" ;
				}else{
					html += "<td class=\"center\">"+handsetOrders.datas.result[i].sumCost+"</td>" ;
				}
				html += "<td class=\"center\">"+handsetOrders.datas.result[i].orderNomber+"</td>" ;
				html += "<td class=\"center\">"+handsetOrders.datas.result[i].startTime+"</td>" ;
				html += "<td class=\"center\">"+handsetOrders.datas.result[i].endTime+"</td>" ;
				html += "</tr>" ;
			}
			/* $("#data_list").html(html) ;
			sequenceTr("table_report") ; */
			 //重写行号
	        setRowNumByJSON(handsetOrders,"data_list",html);
		}	
	</script>
<body onkeydown="enterDown();" >
		
<div class="container-fluid" id="main-container">

<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="tab.do" id="indexInfo"></a><span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>员工管理<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">收费员流水</li>
		</ul>
		<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->	
						
  <div class="row-fluid">

	<div class="row-fluid">
			<input id="parkingInfoId" type="hidden"/>
			<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<!-- 检索  -->
			<table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="stuffPhone" value="" maxlength="20" placeholder="请输入手机号" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="stuffName" value="" maxlength="20" placeholder="请输入姓名" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							 <input readonly="readonly" type="text" class="Wdate" id="startTime" placeholder="这里输入开始时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						</span>
					</td>
					<td>
						<span class="input-icon">
							 <input readonly="readonly" type="text" class="Wdate" id="endTime" placeholder="这里输入结束时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						</span>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" style="width:30px"></th>
						<th class="center">姓名</th>
						<th class="center">手机号</th>
						<th class="center">累计金额(元/天)</th>
						<th class="center">接单总数(单/天)</th>
						<th class="center">开始时间</th>
						<th class="center">结束时间</th>
					</tr>
				</thead>
										
				<tbody id="data_list">
					<tr><td class="center" colspan="7">暂无数据</td></tr>
				</tbody>
			</table>
	</div>
	<p id="count"><strong>累计金额：</strong><span id="costAll"></span>元；<strong>接单总数：</strong><span id="recordAll"></span>单；</p>
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
		
	
		
		$(top.hangge());
		
		//提交键与enter键绑定
		function enterDown(){
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
		
		//检索
		function search(type){
			top.jzts();
			var currentPage = $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var parkingInfoId = $("#parkingInfoId").val() ;
			var startTime = $("#startTime").val() ;
			var endTime = $("#endTime").val() ;
			var stuffPhone = $("input[name='stuffPhone']").val().trim() ;
			var stuffName = $("input[name='stuffName']").val().trim() ;
			var jsonstr = {"parkingInfoId":parkingInfoId,"stuffPhone":stuffPhone,"startTime":startTime,"endTime":endTime,"stuffName":stuffName,"currentPage":currentPage,"pageSize":"20"} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: 'selectStuffRunWater',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(handsetOrders){
					if(handsetOrders.result=="0"){
						var html = "" ;
						html += "<tr><td class=\"center\" colspan=\"7\">暂无数据</td></tr>" ;
						$("#data_list").html(html) ;
						$("#page").html("") ;
						 countHide(); //隐藏统计 该方法在jquery-1.7.2.js中
						top.hangge() ;
						return false ;
					}
					$("#currentPage").val(handsetOrders.datas.pageNum) ;
					$("#pageSize").val(handsetOrders.datas.pageSize) ;
					getDataList(handsetOrders) ;
					//分页信息
					if(type!="paginate"){
						getPaginate( handsetOrders.datas.pages) ;
					}
					//被点击页码的样式 
					$("#page li:eq("+handsetOrders.datas.pageNum+")").addClass("active");  
					 countShow();  //隐藏统计 该方法在jquery-1.7.2.js中
					 $("#costAll").html(getAll('data_list',3)) ;
					 $("#recordAll").html(getAll('data_list',4)) ;
					top.hangge() ;
				}
			}) ;
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

