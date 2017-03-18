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
	</head>
<body>
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
						
  <div class="row-fluid">

	<div class="row-fluid">
	
			<!-- 检索  -->
			<form action="" method="post" name="" id="">
			<table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="" value="" placeholder="请输入姓名" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="" value="" placeholder="请输入手机号" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input class="span10 date-picker" name="lastLoginStart" id="lastLoginStart"
							type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:130px;" placeholder="开始日期"/>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input class="span10 date-picker" name="lastLoginStart" id="lastLoginStart"
							type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:130px;" placeholder="结束日期"/>
						</span>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="search();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center">人员ID</th>
						<th class="center">姓名</th>
						<th class="center">职务</th>
						<th class="center">时间</th>
						<th class="center">单日流水合计</th>
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
					<tr>
						<td class='center' style="width: 70px;">1001</td>
						<td  class='center' style="width: 70px;">张三</td>
						<td  class='center' style="width: 70px;">收费员</td>
						<td  class='center' style="width: 70px;">2015-02-10</td>
						<td  class='center' style="width: 70px;">90</td>
					</tr>
					
					<tr>
						<td class='center' style="width: 70px;">1001</td>
						<td  class='center' style="width: 70px;">张三</td>
						<td  class='center' style="width: 70px;">收费员</td>
						<td  class='center' style="width: 70px;">2015-02-10</td>
						<td  class='center' style="width: 70px;">90</td>
					</tr>
					
						<tr>
						<td class='center' style="width: 70px;">1001</td>
						<td  class='center' style="width: 70px;">张三</td>
						<td  class='center' style="width: 70px;">收费员</td>
						<td  class='center' style="width: 70px;">2015-02-10</td>
						<td  class='center' style="width: 70px;">90</td>
					</tr>
				</tbody>
			</table>
			
		
		</form>
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
		
		//检索
		function search(){
			top.jzts();
			$("#Form").submit();
		}
		
		//跳转到收费员这天内的所有流水明细。
		function showDetailInfo(){
			top.mainFrame.tabAddHandler("detailList","流水明细列表","/OnlineParking/");
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
		
		
		//批量操作
		function makeAll(msg){
			bootbox.confirm(msg, function(result) {
				if(result) {
					var str = '';
					for(var i=0;i < document.getElementsByName('ids').length;i++)
					{
						  if(document.getElementsByName('ids')[i].checked){
						  	if(str=='') str += document.getElementsByName('ids')[i].value;
						  	else str += ',' + document.getElementsByName('ids')[i].value;
						  }
					}
					if(str==''){
						bootbox.dialog("您没有选择任何内容!", 
							[
							  {
								"label" : "关闭",
								"class" : "btn-small btn-success",
								"callback": function() {
									//Example.show("great success");
									}
								}
							 ]
						);
						
						$("#zcheckbox").tips({
							side:3,
				            msg:'点这里全选',
				            bg:'#AE81FF',
				            time:8
				        });
						
						return;
					}else{
						if(msg == '确定要删除选中的数据吗?'){
							top.jzts();
							$.ajax({
								type: "POST",
								url: '<%=basePath%>command/deleteAll.do?tm='+new Date().getTime(),
						    	data: {DATA_IDS:str},
								dataType:'json',
								//beforeSend: validateData,
								cache: false,
								success: function(data){
									 $.each(data.list, function(i, list){
										//	nextPage(${page.currentPage});
									 });
								}
							});
						}
					}
				}
			});
		}
		
		//导出excel
		function toExcel(){
			window.location.href='<%=basePath%>command/excel.do';
		}
		</script>
		
	</body>
</html>

