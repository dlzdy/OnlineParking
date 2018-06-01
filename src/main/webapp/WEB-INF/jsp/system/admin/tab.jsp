<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

	<head>
	<base href="<%=basePath%>">
	
    <script type="text/javascript" src="onlineparking/js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="onlineparking/myplugins/tab/js/framework.js"></script>
	<link href="onlineparking/myplugins/tab/css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link  rel="stylesheet" type="text/css" id="skin" prePath="onlineparking/myplugins/tab/" /><!--默认相对于根目录路径为../，可添加prePath属性自定义相对路径，如prePath="<%=request.getContextPath()%>"-->
	<script type="text/javascript" charset="utf-8" src="onlineparking/myplugins/tab/js/tab.js"></script>
	</head>
	
	
<body>
<div style="min-width:800px;">
 <div id="tab_menu" style="height:30px;display:none"></div> 
<div style="width:100%;">
			<input type="hidden" id="userID" value="<%=session.getAttribute("loginname") %>"> <!-- 登录时的用户名 即为电话号码 -->
		<input type="hidden" id="uID" value="<%=session.getAttribute("uID") %>"> <!-- 后台通过电话号码将 用户id取出 -->
	<div id="page" style="width:100%;height:100%;"></div>
</div>		
</div>
</body>
<script type="text/javascript">

function tabAddHandler(mid,mtitle,murl){
	tab.update({
		id :mid,
		title :mtitle,
		url :murl,
		isClosed :true
	});
	tab.add({
		id :mid,
		title :mtitle,
		url :murl,
		isClosed :true
	});

	tab.activate(mid);
}
 var tab;	
$( function() {
	var userID  = $("#userID").val() ; //userID放在 system/admin/index.jsp中<!-- 登录时的用户名 即为电话号码 -->
	var uID  = $("#uID").val() ; //uID放在 system/admin/index.jsp中<!-- 后台通过电话号码将 用户id取出 -->
	 tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab1',
		position :"top"
	});
	tab.add( {
		id :'tab1_index1',
		title :"首页",
		url :"/OnlineParking/login_default?userID=" +userID+ "&uID="+uID,
		isClosed :false
	});
	/**tab.add( {
		id :'tab1_index1',
		title :"主页",
		url :"/per/undoTask!gettwo",
		isClosed :false
	});
	**/
});

	function cmainFrameT(){
		var hmainT = document.getElementById("page");
		var bheightT = document.documentElement.clientHeight;
		hmainT .style.width = '100%';
		hmainT .style.height = (bheightT  - 31) + 'px';
	}
	cmainFrameT();
	window.onresize=function(){  
		cmainFrameT();
	};

</script>
</html>

