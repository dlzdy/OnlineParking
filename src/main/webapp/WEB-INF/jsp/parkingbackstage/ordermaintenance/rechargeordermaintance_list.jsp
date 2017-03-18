<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 充值订单维护 -->
<!DOCTYPE html>
<html lang="en"><head>
		<meta charset="utf-8">
	<title></title>
	<meta name="description" content="overview &amp; stats">
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
	<script type="text/javascript" src="system/js/jquery.tips.js"></script>
	<!--引入弹窗组件start-->
	<script type="text/javascript" src="system/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="system/zDialog/zDialog.js"></script>
	<script type="text/javascript" src="plugins/datepakier/WdatePicker.js"></script>
	<script type="text/javascript" src="plugins/datepakier/lang/zh-cn.js"></script>
	<script type="text/javascript">
	 	/* $(function(){
	 		var rechargeorders = ${rechargeorders} ;	
	 		getDataList(rechargeorders) ;
	 	}) ; */
	</script>
	<!--引入弹窗组件end-->
	<style type="text/css">
		input[readonly]{
			border-radius: 4px !important;
			margin-right:10px ;
		}
	</style>
	</head>
<body  onkeydown="keySearch();"> 
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i>首页<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>订单维护<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">充值订单维护</li>
		</ul>
	</div><!--#breadcrumbs-->
						
  	<div class="row-fluid">
	<div class="row-fluid">
			<!-- 检索  -->
			<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<table>
				<tbody><tr>
					<td style="vertical-align:top;"> 
						<select class="chzn-select" id="payMentWay" data-placeholder="请选择支付方式" style="vertical-align:top;">
					  	<option value="">请选择充值方式</option>
					  	<option value="1">支付宝支付</option>
					  	<option value="2">微信支付</option>
					  	<option value="3">银联宝支付</option>
					  	</select>
					</td>
					<td style="vertical-align:top;"> 
						<select class="chzn-select" id="rechargeState" data-placeholder="请选择充值状态" style="vertical-align:top;">
					  	<option value="">请选择充值状态</option>
					  	<option value="SUCCESS">充值成功</option>
					  	<option value="REFUND">转入退款</option>
					  	<option value="NOTPAY">未充值</option>
					  	<option value="CLOSED">已关闭</option>
					  	<option value="REVOKED">已撤销</option>
					  	<option value="USERPAYING">充值中</option>
					  	<option value="PAYERROR">充值失败</option>
					  	</select>
					</td> 
				<!-- 	<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="phone" maxlength="11" placeholder="这里输入手机号">
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td> -->
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="userID" maxlength="100" placeholder="这里输入用户ID">
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						 <input readonly="readonly" type="text" class="Wdate" id="rechargeStartTime" placeholder="这里输入充值开始时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</td>
					<td>
						 <input readonly="readonly" type="text" class="Wdate" id="rechargeEndTime" placeholder="这里输入充值结束时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</td>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="find();" title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</tbody></table>
			<!-- 检索  -->
			<style type="text/css">
			.btn-mini{margin:0 5px;}
			</style>	
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center"></th>
						<th class="center">用户ID</th>
						<!-- <th class="center">用户手机</th> -->
						<th class="center">充值金额（元）</th>
						<th class="center">充值时间</th>
						<th class="center">支付方式</th>
						<!-- <th class="center">支付账号</th> -->
						<th class="center">充值状态</th>
					</tr>
				</thead>
									
				<tbody id="t_datas">
					<tr>
						<td colspan="12" class="center" id="noDatas">暂无数据</td>
					</tr>
				<!-- 开始循环 -->	
				</tbody>
			</table>
		</div>
		<p id="count" style="display:none"><strong>累计充值金额：</strong><span id="costAll"></span>元</p>	
		 <div id="page"> </div>
	</div>
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
</div><!--/#page-content-->
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
		<!--引入属于此页面的js -->
		<script type="text/javascript" src="system/js/systemjs/head.js"></script>
		<script type="text/javascript" src="system/js/jquery.json-2.4.js"></script>
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
		$("#payMentWay").change(function(){
			giveNum() ;
			search(1);
		});
		$("#rechargeState").change(function(){
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
			var phone = $("input[name='phone']").val() ;
			var userID = $("input[name='userID']").val().trim() ;
			var payMentWay = $("#payMentWay").val() ;
			var rechargeState = $("#rechargeState").val() ;//支付状态
			var rechargeStartTime = $("#rechargeStartTime").val() ;
			var rechargeEndTime = $("#rechargeEndTime").val() ;
			
			var jsonstr = {"phone":phone,"userID":userID,"payMentWay":payMentWay,"rechargeState":rechargeState,"rechargeStartTime":rechargeStartTime,"rechargeEndTime":rechargeEndTime
					,"currentPage":currentPage,"pageSize":pageSize} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: '/OnlineParking/selectRechargeOrder',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(rechargeorders){
					if(rechargeorders.datas.length==0||rechargeorders.result=="0"){
						var html = "" ;
						html+="<tr>" ;
						html+="<td colspan=\"12\" class=\"center\">暂无数据</td>" ;
						html+="</tr>" ;
						$("#t_datas").html(html);
						 $("#count").hide() ;//隐藏统计 
						$("#page").html("") ;
						return false ;
					}
					$("#currentPage").val(rechargeorders.datas.pageNum) ;
					$("#pageSize").val(rechargeorders.datas.pageSize) ;
					getDataList(rechargeorders) ;
					 //分页信息 
						if(type!="paginate"){
							getPaginate( rechargeorders.datas.pages) ;
						}
					 //设置样式					
					$("#page li:eq("+rechargeorders.datas.pageNum+")").addClass("active");   
					//统计	
					$("#count").show() ;
					$("#costAll").html(getAll('t_datas',2)) ;//该发放放在jquery-1.7.2.js中
				}
			}) ;
		}
		function getDataList(rechargeorders){
			var html = "" ;
			for(var i = 0 ; i < rechargeorders.datas.result.length ; i ++){
				html += "<tr>";
				html += "<td class=\"center\" style=\"width: 30px;\"></td>";
				html += "<td class=\"center\">"+rechargeorders.datas.result[i].chargingOrder2ClientUserId+"</td>";
				/* html += "<td class=\"center\"></td>"; */
				html += "<td class=\"center\">"+rechargeorders.datas.result[i].chargingOrderAmount+"</td>";
				html += "<td class=\"center\">"+rechargeorders.datas.result[i].chargingOrderCreateTime+"</td>";
				if(rechargeorders.datas.result[i].chargingOrderChargingType=="1"){
					html += "<td class=\"center\">支付宝支付</td>";
				}else if(rechargeorders.datas.result[i].chargingOrderChargingType=="2"){
					html += "<td class=\"center\">微信支付</td>";
				}else if(rechargeorders.datas.result[i].chargingOrderChargingType=="3"){
					html += "<td class=\"center\">银联宝支付</td>";
				}
	/* 			html += "<td class=\"center\">"+rechargeorders.datas.result[i].chargingOrderChargingAccount+"</td>"; */
				if(rechargeorders.datas.result[i].chargingOrderChargingType=="2"){
					if(rechargeorders.datas.result[i].chargingOrderPaymentPlatformFeedback=="SUCCESS"){
						html += "<td class=\"center\">充值成功</td>";
					}else if(rechargeorders.datas.result[i].chargingOrderPaymentPlatformFeedback=="REFUND"){
						html += "<td class=\"center\">转入退款 </td>";
					}else if(rechargeorders.datas.result[i].chargingOrderPaymentPlatformFeedback=="NOTPAY"){
						html += "<td class=\"center\">未充值</td>";
					}else if(rechargeorders.datas.result[i].chargingOrderPaymentPlatformFeedback=="CLOSED"){
						html += "<td class=\"center\">已关闭</td>";
					}else if(rechargeorders.datas.result[i].chargingOrderPaymentPlatformFeedback=="REVOKED"){
						html += "<td class=\"center\">已撤销</td>";
					}else if(rechargeorders.datas.result[i].chargingOrderPaymentPlatformFeedback=="USERPAYING"){
						html += "<td class=\"center\">充值中</td>";
					}else if(rechargeorders.datas.result[i].chargingOrderPaymentPlatformFeedback=="PAYERROR"){
						html += "<td class=\"center\">充值失败</td>";
					}
					
				}else{
					html += "<td class=\"center\">"+rechargeorders.datas.result[i].chargingOrderPaymentPlatformFeedback+"</td>";
				}
				html += "</tr>";
			}
			/* $("#t_datas").html(html); */
			//动态获取行号 
			setRowNumByJSON(rechargeorders,'t_datas',html) ;
		}
		
		
		</script>
		<script type="text/javascript">
		$(function() {
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
		});
		</script>
</body>
</html>