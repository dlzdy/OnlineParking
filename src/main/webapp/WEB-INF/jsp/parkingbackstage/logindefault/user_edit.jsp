<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="system/css/bootstrap.min.css" rel="stylesheet" />
		<link href="system/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link href="system/css/font-awesome.min.css" rel="stylesheet"/>
		
		<link rel="stylesheet" href="system/css/ace.min.css" />
		<link rel="stylesheet" href="system/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="system/css/ace-skins.min.css" />
		<script type="text/javascript" src="system/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="system/js/jquery.tips.js"></script>
		<script type="text/javascript" src="system/js/jquery.json-2.4.js"></script><!-- 字符串转化成json -->
		<script type="text/javascript" src="system/js/systemjs/user_edit.js"></script>
		
<style type="text/css">
	#zhongxin{
		margin-top:40px ;
	}
</style>
		
<script type="text/javascript">
	
</script>
	</head>
<body>
		<div id="zhongxin" >
		
		<table id="table_report" class="table table-striped table-bordered table-hover" style="width:100%;">
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" readonly="readonly">用户名:</td>
				<td><input style="width:95%;" type="text" name="systemManagerUsername" id="systemManagerUsername" value="<%=session.getAttribute("systemManagerUsername") %>" maxlength="12" readonly="readonly"  /></td>
			</tr>
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" readonly="readonly">原始密码:</td>
				<td><input style="width:95%;" type="password" name="systemManagerPsd" id="systemManagerPsd" value="<%=session.getAttribute("systemManagerPsd") %>" maxlength="20" readonly="readonly"  /></td>
			</tr>
			
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" >新密码:</td>
				<td><input style="width:95%;" type="password" name="newSystemManagerPsd" id="newSystemManagerPsd" maxlength="20" onblur="checkNewPassWord();"/></td>
			</tr>
			
			<tr>
				<td style="width:90px;text-align: right;padding-top: 18px;" >重复密码:</td>
				<td><input style="width:95%;" type="password" name="reSystemManagerPsd" id="reSystemManagerPsd" maxlength="20" onblur="checkRePassWord(); "/></td>
			</tr>
		</table>
		   <table id="table_report" class="table table-striped table-bordered table-hover">
				<tr>
					<td style="text-align: center;" colspan="10">
						<a class="btn btn-mini btn-primary" onclick="save();">提交</a>
					</td>
				</tr>
			</table> 
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="system/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='system/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="system/js/bootstrap.min.js"></script>
		<script src="system/js/ace-elements.min.js"></script>
		<script src="system/js/ace.min.js"></script>
		<script type="text/javascript">
			$(top.hangge());
		</script>
</body>
</html>