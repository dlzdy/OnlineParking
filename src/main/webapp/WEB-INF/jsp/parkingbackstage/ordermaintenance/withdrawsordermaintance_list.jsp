<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 提现订单维护 -->
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
	<!-- 日期框 -->
	<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
	<!--引入弹窗组件start-->
	<script type="text/javascript" src="system/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
	<!--引入弹窗组件end-->
	<!--<script type="text/javascript" src="js/jquery.tips.js"></script>-->
	</head>
<body>
		
<div class="container-fluid" id="main-container">

<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="#">首页</a><span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>订单维护<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">提现订单维护</li>
		</ul>
	</div><!--#breadcrumbs-->

  <div class="row-fluid">
      
	<div class="row-fluid">
	
			<!-- 检索  -->
			<form action="" method="post" name="Form" id="Form">
			<table>
				<tbody><tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="" value="" placeholder="这里输入提现方式">
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input class="span10 date-picker" name="lastLoginStart" id="lastLoginStart"
							type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:130px;" placeholder="提现时间"/>
						</span>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="search();" title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</tbody></table>
			<!-- 检索  -->

		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				
				<thead>
					<tr>
						<th class="center">
						<label><input type="checkbox" id="zcheckbox"><span class="lbl"></span></label>
						</th>
						<th class="center">订单ID</th>
						<th class="center">订单金额</th>
						<th class="center">提现时间</th>
						<th class="center">提现方式</th>
						<th class="center">提现流水金额</th>
					</tr>
				</thead>
						<style type="text/css">
						.btn-mini{margin:0 5px;}
						</style>				
				<tbody>
					
				<!-- 开始循环 -->	
							<tr>
								<td class="center" style="width: 30px;">
									<label><input type="checkbox" name="ids" value=""><span class="lbl"></span></label>
								</td>
								<td class="center">2204221985101011689</td>
								<td class="center">100</td>
								<td class="center">2015.10.12</td>
								<td class="center">100</td>
								<td class="center">28元</td>
							</tr>
						
							
							<tr>
								<td colspan="100" class="center">您无权查看</td>
							</tr>
						<!-- <tr class="main_info">
							<td colspan="100" class="center" >没有相关数据</td>
						</tr> -->
					
				
				</tbody>
			</table>
			
		<div class="page-header position-relative">
		<table style="width:100%;">
			<tbody><tr>
				<td style="vertical-align:top;">
					<div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">
						<ul>
							<li><a>共<font color="red">1</font></a></li>
							<li>
								<input type="number" placeholder="页码" style="width:50px;text-align:center;float:left" id="toGoPage" value="">
							</li>
							<li style="cursor:pointer;"><a class="btn btn-mini btn-success" onclick="toTZ();">跳转</a></li>
							<li><a>首页</a></li>
							<li><a>上页</a></li>
							<li><a>共<font color="#808080">1</font>条</a></li>
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
		</tbody>
		</table>
		</div>
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
		<script src="system/js/bootstrap.min.js"></script>
		<script src="system/js/ace-elements.min.js"></script>
		<script src="system/js/ace.min.js"></script>
		
		<script type="text/javascript" src="system/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="system/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="system/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		<!-- <script type="text/javascript" src="js/jquery.tips.js"></script>--><!--提示框-->

		<!--引入属于此页面的js -->
		<script type="text/javascript" src="system/js/systemjs/head.js"></script>
		<script type="text/javascript">
		
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
			 diag.URL = '/OnlineParking/toAddStuff';
			 diag.Width = 350;
			 diag.Height = 500;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('' == '0'){ */
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 /* }else{
						// nextPage();
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
					var url = "http://172.29.5.71:8080/OnlineParking/command/delete.do?COMMAND_ID="+Id+"&tm="+new Date().getTime();
					$.get(url,function(data){
						//nextPage();
					});
				}
			});
		}
		
		//修改 by xumingyue
		function edit(){
			 // top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = "/OnlineParking/editStuff";
			 diag.Width = 350;
			 diag.Height = 500
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
								url: 'http://172.29.5.71:8080/OnlineParking/command/deleteAll.do?tm='+new Date().getTime(),
						    	data: {DATA_IDS:str},
								dataType:'json',
								//beforeSend: validateData,
								cache: false,
								success: function(data){
									 $.each(data.list, function(i, list){
										//	nextPage();
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
			//window.location.href='http://172.29.5.71:8080/OnlineParking/command/excel.do';
		}

		</script>
		
	


</body></html>