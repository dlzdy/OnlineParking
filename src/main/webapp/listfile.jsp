<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>下载文件显示页面</title>
</head>



<body>
	<%
		String ip = "http://" + InetAddress.getLocalHost().getHostAddress()
				+ ":80${pageContext.request.contextPath}/down";
	%>
	<a href="${pageContext.request.contextPath}/down"><img id="img"
		src="http://qr.topscan.com/api.php?bg=ffffff&fg=000000&gc=222222&el=l&w=117&m=10&text=http://<% out.println(ip);%>:80${pageContext.request.contextPath}/down" />
	</a>
	<!-- 参数背景颜色(bg)、前景颜色(fg)、渐变颜色(gc)、纠错等级(el)、图片宽度(w)、外边距(m) -->
</body>
</html>