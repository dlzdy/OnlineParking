<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 停车订单维护 -->
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>"><!-- jsp文件头和头部 -->
	<!-- jsp文件头和头部 -->
	<meta charset="utf-8">
	<title></title>
	<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="system/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="system/css/font-awesome.min.css" />
	<link rel="stylesheet" href="system/css/chosen.css" />
	<link rel="stylesheet" href="system/css/ace.min.css" />
	<link rel="stylesheet" href="system/css/ace-skins.min.css" />
	<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>	
	<link rel="stylesheet" href="system/css/datepicker.css" /><!-- 日期框 -->	
	<link rel="stylesheet" href="plugins/paginate/css/lanrenzhijia.css" /> <!-- 分页样式 -->
	<!--引入弹窗组件start-->
	<script type="text/javascript" src="system/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
	<script type="text/javascript" src="system/js/jquery.json-2.4.js"></script>
	<script type="text/javascript" src="system/js/jquery.tips.js"></script>
	<script type="text/javascript" src="utiljs/tools.js"></script>  
	<!--引入弹窗组件end-->
	<!--<script type="text/javascript" src="js/jquery.tips.js"></script>-->
	<style type="text/css">
	
		#table_report tr.trHeight td{
			padding: 0 8px;
		}
		
	</style>
	<script type="text/javascript">
	/* var pOrders = ${pOrders} ; */
		$(function(){
			var allParkInfo = ${allParkInfo} ;
			for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
				for(var i = 0 ; i < allParkInfo.datas.length ; i ++){
					$("#parkInfoId").append("<option value='"+allParkInfo.datas[i].parkingInfoId+"'>"+allParkInfo.datas[i].parkingInfoName+"</option>");
				}
			}
		}) ;
	</script>
	</head>
<body  onkeydown="keySearch();">
		
<div class="container-fluid" id="main-container">
<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i>首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>订单维护<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">停车订单维护</li>
		</ul>
	</div><!--#breadcrumbs-->

  <div class="row-fluid">
	<div class="row-fluid">
				<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<!-- 检索  -->
			<table>
				<tr>
					<td style="vertical-align:top;"> 
					 	<select class="chzn-select" name="parkInfoId" id="parkInfoId" data-placeholder="请选择停车场" style="vertical-align:top;">
					  	<option value="">请选择停车场</option>
					  	</select>
					</td>
						<td style="vertical-align:top;"> 
					  	<select class="chzn-select" name="" id="payState" data-placeholder="请选择支付状态" style="vertical-align:top;">
					  	<option value="">请选择支付状态</option>
					  	<option value="Paid">已支付</option>
					  	<option value="NoPaid">未支付</option>
					  	</select>
					</td>
						<td style="vertical-align:top;"> 
						<select class="chzn-select" name="" id="parkingOrderType" data-placeholder="请选择订单类型" style="vertical-align:top;">
					  	<option value="">请选择订单类型</option>
					  	<option value="0">手持机</option>
					  	<option value="1">闸杆</option>
					  	<option value="2">微信</option>
					  	</select>
					</td>
				    <!-- <td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="stuffName" maxlength="20" placeholder="请输入收费员" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td> -->
					 <td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="carNo" maxlength="20" placeholder="请输入车牌号" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();"  title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
			        <tr class="trHeight">
			        	<td colspan="3"></td>
			        	<td colspan="3" class="center">时间</td>
			        	<td colspan="3" class="center">状态</td>
			        	<td colspan="4" class="center"></td>
			        </tr> 
					<tr>
					    <th class="center" style="width:30px"></th>
						<th class="center">车牌号</th><!-- parkingOrderCarNo -->
						<th class="center" >用户ID</th><!-- parkingOrderClientUserId  -->
						<th class="center">入场时间</th><!-- parkingOrderCarEnterTime  -->
						<th class="center">出场时间</th><!-- parkingOrderCarExitTime  -->
						<th class="center">停留时间</th> <!-- parkingOrderCarStayTime  -->
						<th class="center">停车状态</th><!-- parkingOrderParkingState  -->
						<th class="center">支付状态</th><!-- parkingOrderPayState  -->
						<th class="center">在管状态</th><!-- 该车辆不是Online停车平台在管车辆 是否被停车场管理 --><!-- parkingOrderCarNumberState --> 
						<th class="center">停车费用</th><!-- parkingOrderCost  -->
						<th class="center">支付方式</th><!-- parkingOrderPayCash  -->
						<th class="center">订单类型</th><!--0手持 1刀闸   。。。parkingOrderType-->
						<th class="center">创建时间</th><!-- parkingOrderCreateTime  -->
					</tr>
					
				</thead>
				<tbody id="t_data_list">
					<tr>
						<td colspan="16" class="center">暂无数据</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
		<p id="count" style="display:none"><strong>累计停车费用：</strong><span id="costAll"></span>元</p>		
		 <div id="page"> </div>
		<!-- </form> -->
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
		<script type="text/javascript" src="plugins/paginate/js/jquery.paginate.js"></script><!--分页-->
		<!-- 引入 -->
		<!-- <script type="text/javascript" src="js/jquery.tips.js"></script>--><!--提示框-->
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
		$("#parkInfoId").change(function(){
			giveNum() ;
			search(1);
		});
		$("#payState").change(function(){
			search(1);
		});
		$("#parkingOrderType").change(function(){
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
			//$("#Form").submit();
			var currentPage =  $("#currentPage").val() ;
			var pageSize = $("#pageSize").val() ;
			var stuffName = $("input[name='stuffName']").val() ;
			var carNo = $("input[name='carNo']").val().trim() ;
			var payState = $("#payState").val() ;
			var parkInfoId = $("#parkInfoId").val() ;
			var parkingOrderType = $("#parkingOrderType").val() ; //订单类型
			var jsonstr = {"stuffName":stuffName,"carNo":carNo,"payState":payState,"parkInfoId":parkInfoId,"currentPage":currentPage,"pageSize":pageSize,"parkingOrderType":parkingOrderType} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectParkOrder',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(pOrders){
					if(pOrders.datas.length==0){
						var html = "" ;
						html+="<tr>" ;
						html+="<td colspan=\"16\" class=\"center\">暂无数据</td>" ;
						html+="</tr>" ;
						$("#t_data_list").html(html) ;
						 $("#count").hide() ;//隐藏统计 
						 $("#page").html("") ;
						return false ;
					}
					getDataList(pOrders) ;
					$("#currentPage").val(pOrders.datas.pageNum) ;
					$("#pageSize").val(pOrders.datas.pageSize) ;
					//分页信息 
					
						if(type!="paginate"){
							getPaginate( pOrders.datas.pages) ;
						}
						
					/* var pageHtml = getPage(pOrders) ; 
					$("#page").html(pageHtml) ;
					$("#page li:eq("+pOrders.datas.pageNum+")").addClass("active");  */
					//统计	
					$("#count").show() ;
					$("#costAll").html(getAll('t_data_list',9)) ;//该发放放在jquery-1.7.2.js中
				}
			});
		}

		function getDataList(pOrders){
			var html ="" ;
			for(var i = 0 ; i < pOrders.datas.result.length ; i++){
				html += "<tr>" ;
				html += "<td class='center'></td>" ;  
				html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCarNo+"</td>";
				if(pOrders.datas.result[i].parkingOrderClientUserId==""||pOrders.datas.result[i].parkingOrderClientUserId==null){
					html += "<td class='center' >非注册用户</td>";
				}else{
					html += "<td class='center' >"+pOrders.datas.result[i].parkingOrderClientUserId+"</td>";
				}
				if(pOrders.datas.result[i].parkingOrderCarEnterTime==""||pOrders.datas.result[i].parkingOrderCarEnterTime==null){
					html += "<td class='center'></td>";
				}else{
					html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCarEnterTime+"</td>";
				}
				if(pOrders.datas.result[i].parkingOrderCarExitTime==""||pOrders.datas.result[i].parkingOrderCarExitTime==null){
					html += "<td class='center'>停留中</td>";
				}else{
					html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCarExitTime+"</td>";
				}
				if(pOrders.datas.result[i].parkingOrderCarStayTime==""||pOrders.datas.result[i].parkingOrderCarStayTime==null){
					html += "<td class='center'>停留中</td>";
				}else{
					html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCarStayTime+"</td>";
				}
				if(pOrders.datas.result[i].parkingOrderParkingState=="quiet"){ 
					html += "<td class='center'>离开车场</td>";
				}else if(pOrders.datas.result[i].parkingOrderParkingState=="stay"){
					html += "<td class='center'>停留中</td>";
				}
				if(pOrders.datas.result[i].parkingOrderPayState=="NoPaid"){ 
					html += "<td class='center'><font color='red'>未支付</font></td>";
				}else if(pOrders.datas.result[i].parkingOrderPayState=="Paid"){
					html += "<td class='center'><font color='green'>已支付</font></td>";
				}
				if(pOrders.datas.result[i].parkingOrderCarNumberState=="1"){
					html += "<td class='center'>注册</td>";
					
				}else if(pOrders.datas.result[i].parkingOrderCarNumberState=="0"){
					html += "<td class='center'>未注册</td>";
				}
				if(pOrders.datas.result[i].parkingOrderCost==""||pOrders.datas.result[i].parkingOrderCost==null){
					html += "<td class='center'>0</td>";
				}else{
					html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCost+"</td>";
				}
				if(pOrders.datas.result[i].parkingOrderPayCash=="1"){
					html += "<td class='center'>现金</td>";
				}else if(pOrders.datas.result[i].parkingOrderPayCash=="0"){
					html += "<td class='center'>非现金</td>";
				}
				
				
				 if(pOrders.datas.result[i].parkingOrderType=="0") {
					html += "<td class='center'><img src='system/images/shouchiji.png' title='手持机' style='width:25px'></td>";
				}else if(pOrders.datas.result[i].parkingOrderType=="1"){
					html += "<td class='center'><img src='system/images/zhagan.png' title='闸杆' style='width:25px'></td>";
				}else {
					html += "<td class='center'><img src='system/images/weixin.png' title='微信' style='width:25px'></td>";
				}
				html += "<td class='center'>"+pOrders.datas.result[i].parkingOrderCreateTime+"</td>";
				html += "</tr>";
			}
			setRowNumByJSON(pOrders,'t_data_list',html) ;
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
		</script>
		
	


</body></html>