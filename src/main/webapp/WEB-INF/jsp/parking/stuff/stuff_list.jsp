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
	<script type="text/javascript" src="utiljs/tools.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script>
	<script type="text/javascript" src="plugins/datepakier/WdatePicker.js"></script>
	<script type="text/javascript" src="plugins/datepakier/lang/zh-cn.js"></script>
	<script type="text/javascript">
 	    var stuffs = ${stuffs} ;//获取停车场所有员工信息
	    var parkInfo = ${parkInfo} ; //停车场信息
		$(function(){
			$("#indexInfo").html(parkInfo.datas.parkingInfoName); //获取停车场名称 (XXX停车场后台首页)
			$("#parkingInfoId").val(parkInfo.datas.parkingInfoId) ;//获取停车场id 显示的列表中每行都有停车场id且相同，但是动态不好处理
			if(stuffs.result=="0"){
				$("#page").html("") ;
				return false ;
			}
			getDataList(stuffs) ;
			//$("#page").html(getPage(stuffs)) ;
			getPaginate(stuffs.datas.pages) ;
			$("#page li:eq("+stuffs.datas.pageNum+")").addClass("active");
		}) ;
		
		
	</script>
	</head>
<body  onkeydown="enterDown();">
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
			
	<div id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="tab.do" id="indexInfo"></a><span class="divider"><i class="icon-angle-right"></i></span></li>
			<li>员工管理<span class="divider"><i class="icon-angle-right"></i></span></li>
			<li class="active">收费员管理</li>
		</ul>
		<!--.breadcrumb-->
	</div>
	<!--#breadcrumbs-->			
			
  <div class="row-fluid">
      
	<div class="row-fluid">
			<input type="hidden" value="" id="currentPage" /><!-- 当前页 -->
			<input type="hidden" value="" id="pageSize" /><!-- 每页多少条-->
			<input type="hidden" id="uID" value="<%=session.getAttribute("uID")%>"/> <!-- 将放在session中的用户id取出来 -->
			<!-- 检索  -->
			<table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="stuffName" maxlength="20" placeholder="这里输入姓名" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="stuffPhone" maxlength="11" placeholder="这里输入手机号" />
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
			<!-- 检索  -->
		
			<input type="hidden" value="" id="parkingInfoId" /><!-- 将停车场id隐藏 -->
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" style="width:30px;"></th>
						<th class="center" style="display:none">停车场手持机ID</th><!-- handsetId -->
						<th class="center" style="display:none">停车场手持机收费员用户账号主键id</th><!-- handset_manager_id -->
						<th class="center" style="display:none">停车场手持机管理员用户安全识令牌</th><!-- handsetManagerPhone -->
						<th class="center">手机号</th><!-- handsetId -->
						<th class="center">姓名</th>  <!--handsetManagerName  手持机收费员用户账号关联停车场id-->
						<th class="center">账号状态</th><!--handsetManagerActiveMark  -->
						<th class="center">创建时间</th><!-- handsetManagerCreateTime -->
						<th class="center" style="display:none">姓名</th><!-- 预留 -->
						<th class="center" style="display:none">身份证号</th><!-- 预留 -->
						<th class="center">操作</th>
					</tr>
				</thead>
										
				<tbody id="t_datas">
					<tr><td class="center" colspan="6">暂无数据</td></tr>
				</tbody>
			</table>
			
		<div class="page-header position-relative">
			<table style="width:100%;">
			<tr>
				<td style="vertical-align:top;">
					<a class="btn btn-small btn-success" onclick="add();">新增</a>
				<!-- 	<a class="btn btn-small btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" title="批量删除" ><i class='icon-trash'></i></a> -->
				</td>
			</tr><tr>
			 	<td style="vertical-align:top;" id="page">
				</td> 
			</tr>
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
		<script type="text/javascript" src="onlineparking/js/jquery.json-2.4.js"></script><!--提示框-->
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
			var uID  = $("#uID").val() ;
			var stuffName = $("input[name='stuffName']").val().trim() ; 			
			var stuffPhone = $("input[name='stuffPhone']").val().trim() ; 		
			var startTime = $("#startTime").val() ; 		
			var endTime = $("#endTime").val() ; 		
			var jsonstr = {"uID":uID,"stuffName":stuffName,"stuffPhone":stuffPhone,"startTime":startTime,"endTime":endTime,"currentPage":currentPage,"pageSize":"20"} ;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: 'selectStuffList',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(stuffs){
					if(stuffs.result=="0"){
						var html = "" ;
						html+="<tr><td class=\"center\" colspan=\"6\">暂无数据</td></tr>" ;
						$("#t_datas").html(html) ;
						$("#page").html("") ;
						top.hangge() ;
						return false ;
					}
					$("#currentPage").val(stuffs.datas.pageNum) ;
					$("#pageSize").val(stuffs.datas.pageSize) ;
					getDataList(stuffs) ;
					//分页信息
					if(type!="paginate"){
						getPaginate( stuffs.datas.pages) ;
					}
					//被点击页码的样式  
					$("#page li:eq("+stuffs.datas.pageNum+")").addClass("active");  
					top.hangge() ;
				}
			}) ;
		}
		
		function getDataList(stuffs){
			var html = "" ;
			for(var i = 0 ; i < stuffs.datas.result.length ; i++){
				html += "<tr>" ;
				html += "<td class=\"center\"></td>" ;
				html+="<td class='center' style=\"display:none\">"+stuffs.datas.result[i].handsetId+"</td>";
				html+="<td class='center' style=\"display:none\">"+stuffs.datas.result[i].handsetManagerId+"</td>";
				html+="<td class='center' style=\"display:none\">"+stuffs.datas.result[i].handsetManagerSecurity+"</td>";
				html+="<td class='center'>"+stuffs.datas.result[i].handsetManagerPhone+"</td>";
				if(stuffs.datas.result[i].handsetManagerName==""||stuffs.datas.result[i].handsetManagerName==null){
					html+="<td class='center'>未填</td>"; 
				}else{
					html+="<td class='center'>"+stuffs.datas.result[i].handsetManagerName+"</td>"; 
				}
				if(stuffs.datas.result[i].handsetManagerActiveMark=="enable"){
					html+="<td class='center'>可用</td>";
				}else{
					html+="<td class='center'>不可用</td>";
				}
				html+="<td class='center'>"+stuffs.datas.result[i].handsetManagerCreateTime+"</td>";
				html+="<td class='center' style=\"display:none\"></td>";
				html+="<td class='center'style=\"display:none\" ></td>";
				html+="<td style=\"width: 30px;\" class=\"center\">";
				html+="<div class='hidden-phone visible-desktop btn-group'>";
				html+="<div class=\"inline position-relative\">";
				html+="<button class=\"btn btn-mini btn-info\" data-toggle=\"dropdown\"><i class=\"icon-cog icon-only\"></i></button>";
				html+="<ul class=\"dropdown-menu dropdown-icon-only dropdown-light pull-right dropdown-caret dropdown-close\">";
				html+="<li><a style=\"cursor:pointer;\" title=\"编辑\" onclick=\"edit('"+stuffs.datas.result[i].handsetManagerId+"');\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"green\"><i class=\"icon-edit\"></i></span></a></li>";
				html+="<li><a style=\"cursor:pointer;\" title=\"删除\" onclick=\"del('"+stuffs.datas.result[i].handsetManagerId+"');\" class=\"tooltip-error\" data-rel=\"tooltip\" title=\"\" data-placement=\"left\"><span class=\"red\"><i class=\"icon-trash\"></i></span> </a></li>";
				html+="</ul>";
				html+="</div>";
				html+="</div>";
				html+="</td>";
				html+="</tr>";
			}
			/* $("#t_datas").html(html) ;
			sequenceTr("table_report") ; */
			 //重写行号
	        setRowNumByJSON(stuffs,"t_datas",html);
		}
		
		//新增 by xumingyue
		function add(){
			var parkingInfoId = $("#parkingInfoId").val() ;
 			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增";
			 diag.URL = '/OnlineParking/toAddStuff?parkingInfoId='+parkingInfoId;
			 diag.Width = 350;
			 diag.Height = 290;
			 diag.CancelEvent = function(){ //关闭事件
			 	 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					/*  if('${page.currentPage}' == '0'){ */
						 top.jzts();
						search() ;
					 /* }else{
						// nextPage(${page.currentPage});
					 } */
				} 
				diag.close();
			 };
			 diag.show();
		}
		
		//停车场通过员工id 删除该员工信息
		function del(handsetManagerId){
			var uID = $("#uID").val() ; //取出隐藏的用户id  uID
			var jsonstr = {"handsetManagerId":handsetManagerId} ;
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					var url = "/OnlineParking/delHandsetManagerByManagerId";
					if(!checkInvalid()){return false} ; //判断session是否失效 
					$.ajax({
						type:"post" ,
						url:url ,
						data:$.toJSON(jsonstr),
						dataType:'json',
						contentType : 'application/json',
						success:function(data){
							search() ;
						}
					}) ;
				}
			});
		}
		
		//修改 by xumingyue
		function edit(managerId){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = "/OnlineParking/toEditStuff?managerId="+managerId;
			 diag.Width = 350;
			 diag.Height = 300
			 diag.CancelEvent = function(){ //关闭事件
					search() ;
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

