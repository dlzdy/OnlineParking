<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="top.jsp"%>
<script type="text/javascript">
$(function(){
   var parkName = ${parkName} ;
	$("#indexInfo").html(parkName.datas.parkingInfoName);
}); 
</script>
 <link rel="stylesheet" href="onlineparking/css/bootstrap.min.2.3.5.css"/>
<link rel="stylesheet" href="onlineparking/css/index.css"/>
</head>
<body>
<!--Begin主体内容-->
<div class="container-fluid">
    <!--Begin当月统计-->
    <div class="col-sm-6">

        <!--Panel with Header-->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <i class="icon-mouth"></i>
                    当月统计
                </h3>
            </div>
            <div class="panel-body">
                <!--收入总金额-->
                <div class="item">
                    <label>收入总额：</label>
                    <span id="money" class="strong"></span>
                    <span>（元）</span>
                </div>

                <!--总停车数-->
                <div class="item">
                    <label>总停车数：</label>
                    <span id="car" class="strong">1920</span>
                    <span>（车/次）</span>
                </div>

                <!--日期-->
                <div class="pull-right date-time">
                    <i></i>
                    今天　<span></span>
                </div>

            </div>
        </div>
        <!--End Panel with Header-->

    </div>
    <!--End当月统计-->

    <!--Begin人员管理-->
    <div class="col-sm-6">

        <!--Panel with Header-->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <i class="icon-person"></i>
                    人员管理
                </h3>
            </div>
            <div class="panel-body">
                <!--收费员-->
                <div class="item">
                    <label>收费员：</label>
                    <span id="handManager" class="strong"></span>
                    <span>（人）</span>
                </div>

                <!--后台管理员-->
                <div class="item">
                    <label>后台管理员：</label>
                    <span id="parkingManager" class="strong"></span>
                    <span>（人）</span>
                </div>

                <!--日期-->
                <div class="pull-right date-time">
                    <i></i>
                    今天　<span></span>
                </div>

            </div>
        </div>
        <!--End Panel with Header-->

    </div>
    <!--End人员管理-->

    <!--Begin用户使用-->
    <div class="col-sm-6">

        <!--Panel with Header-->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <i class="icon-use"></i>
                    用户使用
                </h3>
            </div>
            <div class="panel-body">
                <!--注册用户-->
                <div class="item">
                    <label>注册用户：</label>
                    <span id="user" class="strong"></span>
                    <span>（人/次）</span>
                </div>

                <!--非注册用户-->
                <div class="item">
                    <label>非注册用户：</label>
                    <span  id="nullUser"  class="strong"></span>
                    <span>（人/次）</span>
                </div>

                <!--日期-->
                <div class="pull-right date-time">
                    <i></i>
                    今天　<span></span>
                </div>

            </div>
        </div>
        <!--End Panel with Header-->

    </div>
    <!--End用户使用-->

    <!--Begin订单统计-->
    <div class="col-sm-6">

        <!--Panel with Header-->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <i class="icon-order"></i>
                    订单统计
                </h3>
            </div>
            <div class="panel-body">
                <!--当月订单-->
                <div class="item">
                    <label>当月订单：</label>
                    <span  id="mouthOrder"  class="strong"></span>
                    <span>（笔）</span>
                </div>

                <!--当日订单-->
                <div class="item">
                    <label>当日订单：</label>
                    <span id="dayOrder" class="strong"></span>
                    <span>（笔）</span>
                </div>

                <!--日期-->
                <div class="pull-right date-time">
                    <i></i>
                    今天　<span></span>
                </div>

            </div>
        </div>
        <!--End Panel with Header-->

    </div>
    <!--End订单统计-->
</div>
<!--End主体内容-->
	
	
	
	
	
	<!-- basic scripts -->
	<!-- <script src="onlineparking/1.9.1/jquery.min.js"></script> -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='onlineparking/js/jquery-1.9.1.min.js'>\x3C/script>");
	</script>

	<script src="onlineparking/js/bootstrap.min.js"></script>
	<!-- page specific plugin scripts -->

	<!--[if lt IE 9]>
		<script type="text/javascript" src="onlineparking/js/excanvas.min.js"></script>
		<![endif]-->
	<script type="text/javascript" src="onlineparking/js/jquery-ui-1.10.2.custom.min.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.easy-pie-chart.min.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.flot.min.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.flot.pie.min.js"></script>
	<script type="text/javascript" src="onlineparking/js/jquery.flot.resize.min.js"></script>  
	<!-- ace scripts -->
	<script src="onlineparking/js/ace-elements.min.js"></script>
	<script src="onlineparking/js/ace.min.js"></script>
	<!-- inline scripts related to this page -->


	<script type="text/javascript">
		 $(top.hangge());
		 
		//绑定数据
		var indexData = ${indexData};		
		
		//总金额
		$("#money").text(indexData.datas.money==null?0:indexData.datas.money);
		
		//总停车数
		$("#car").text(indexData.datas.car);
		
		//收费员
		$("#handManager").text(indexData.datas.handManager);
		
		//后台管理员
		$("#parkingManager").text(indexData.datas.parkingManager);
		
		//注册用户
		$("#user").text(indexData.datas.user);
		
		//非注册用户
		$("#nullUser").text(indexData.datas.nullUser);
		
		//当月订单
		$("#mouthOrder").text(indexData.datas.mouthOrder);
		
		//当日订单
		$("#dayOrder").text(indexData.datas.dayOrder);
		
		
		
		var seviceDate ="${seviceDate}";
		$(".date-time span").text(seviceDate.substr(0,10));
		
	</script>
	
	
	
	
	
</body>
</html>
