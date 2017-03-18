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
	<div class="page-header position-relative">
		<h1>
			<span id="indexInfo"></span>后台首页 <small><i class="icon-double-angle-right"></i> </small>
		</h1>
	</div>
						
  <div class="row-fluid">

	<div class="row-fluid">
	
			<!-- 检索  -->
			<form action="" method="post" name="" id="">
			<table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="" value="" placeholder="请输入收费员ID" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
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
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="search();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
			
			<div class="page-header position-relative">
		<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
					<a class="btn btn-small btn-success" onclick="add();">新增</a>
					<a class="btn btn-small btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" title="批量删除" ><i class='icon-trash'></i></a>
				</td>
				<td style="vertical-align:top;">
					<div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">
				
					</div>
				</td>
			</tr>
		</table>
		</div>
			
			<!-- 检索  -->
		
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				
				<thead>
					<tr>
						<th class="center">
						<label><input type="checkbox" id="zcheckbox" /><span class="lbl"></span></label>
						</th>
						<th class="center">设备ID</th>
						<th class="center">收费员ID</th>
						<th class="center">姓名</th>
						<th class="center">手机号</th>
						<th class="center">密码</th>
						<th class="center">卡号</th>
						<th class="center">操作</th>
					</tr>
				</thead>
										
				<tbody>
					
				<!-- 开始循环 -->	
					<tr>
						<td class='center' style="width: 30px;">
							<label><input type='checkbox' name='ids' value="" /><span class="lbl"></span></label>
						</td>
						<td class='center' style="width: 70px;">1001</td>
						<td class='center' style="width: 70px;">1111</td>
						<td  class='center' style="width: 70px;">北北</td>
						<td  class='center' style="width: 70px;">15678900876</td>
						<td  class='center' style="width: 70px;">0900998</td>
						<td  class='center' style="width: 70px;">622220989765655</td>
						<td style="width: 40px;" class="center">
							<a style="cursor:pointer;" title="编辑" onclick="userEdit();" class="tooltip-success" data-rel="tooltip" title="" data-placement="left"><span class="green"><i class="icon-edit"></i></span></a>
						</td>
					</tr>
					<tr>
						<td class='center' style="width: 30px;">
							<label><input type='checkbox' name='ids' value="" /><span class="lbl"></span></label>
						</td>
						<td class='center' style="width: 70px;">1001</td>
						<td class='center' style="width: 70px;">1112</td>
						<td  class='center' style="width: 70px;">北北</td>
						<td  class='center' style="width: 70px;">15678900876</td>
						<td  class='center' style="width: 70px;">0900998</td>
						<td  class='center' style="width: 70px;">622220989765655</td>
						<td style="width: 40px;" class="center">
							<a style="cursor:pointer;" title="编辑" onclick="userEdit();" class="tooltip-success" data-rel="tooltip" title="" data-placement="left"><span class="green"><i class="icon-edit"></i></span></a>
						</td>
					</tr>
					<tr>
						<td class='center' style="width: 30px;">
							<label><input type='checkbox' name='ids' value="" /><span class="lbl"></span></label>
						</td>
						<td class='center' style="width: 70px;">1001</td>
						<td class='center' style="width: 70px;">1113</td>
						<td  class='center' style="width: 70px;">北北</td>
						<td  class='center' style="width: 70px;">15678900876</td>
						<td  class='center' style="width: 70px;">0900998</td>
						<td  class='center' style="width: 70px;">622220989765655</td>
						<td style="width: 40px;" class="center">
							<a style="cursor:pointer;" title="编辑" onclick="userEdit();" class="tooltip-success" data-rel="tooltip" title="" data-placement="left"><span class="green"><i class="icon-edit"></i></span></a>
						</td>
					</tr>
					
					
				</tbody>
			</table>
			
		
		</form>
	</div>
 
 	<div class="page-header position-relative">
		<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
					<div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">
						<ul>
							<li><a>共<font color="red">1</font>条</a></li>
							<li>
								<input type="number" placeholder="页码" style="width:50px;text-align:center;float:left" id="toGoPage" value="">
							</li>
							<li style="cursor:pointer;"><a class="btn btn-mini btn-success" onclick="toTZ();">跳转</a></li>
							<li><a>首页</a></li>
							<li><a>上页</a></li>
							<li><a><font color="#808080">1</font></a></li>
							<li><a>下页</a></li>
							<li><a>尾页</a></li>
							<li><a>第一页</a></li>
							<li><a>共一页</a></li>
							<li>
							    <select onchange="changeCount(this.value)" style="width:55px;float:left;" title="显示条数">
									<option value="10">10</option>
									<option value="10">10</option>
									<option value="20">20</option>
									<option value="30">30</option>
									<option value="40">40</option>
									<option value="50">50</option>
									<option value="60">60</option>
									<option value="70">70</option>
									<option value="80">80</option>
									<option value="90">90</option>
									<option value="99">99</option>
								</select>
							</li>
						</ul>
					</div>
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
		//员工编辑 by xumingyue
		function userEdit(){
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = '/OnlineParking/toEditTollCollector';
			 diag.Width = 300;
			 diag.Height = 370;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				} 
				diag.close();
			 };
			 diag.show();
		}
		
		
		$(top.hangge());
		
		//检索
		function search(){
			top.jzts();
			$("#Form").submit();
		}
		
		//新增 by xumingyue
		function add(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toAddTollCollector';
			 diag.Width = 300;
			 diag.Height = 450;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				} 
				diag.close();
			 };
			 diag.show();
		}
		
		//删除
		function del(Id){
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					top.jzts();
					var url = "<%=basePath%>command/delete.do?COMMAND_ID="+Id+"&tm="+new Date().getTime();
					$.get(url,function(data){
						//nextPage(${page.currentPage});
					});
				}
			});
		}
		
		//修改
		function edit(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = "/OnlineParking/toEditDevice";
			 diag.Width = 300;
			 diag.Height = 450;
			 diag.CancelEvent = function(){ //关闭事件
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

