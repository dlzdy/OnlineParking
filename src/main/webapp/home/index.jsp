<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title></title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/index.css" />
    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
    $(function(){
        var _height=$(window).height()-218;
        var _centerHeight=$('.cneter').css({height:_height});
       /*  $.ajax({
			 type: "get",
				contentType : 'application/json',
				url: 'getUrl',
 				dataType:'json',
				cache: false,
				success: function(imgInfos){
					if(imgInfos.datas.sysImgAndroidName==""||imgInfos.datas.sysImgAndroidName==null){
						 $("#androidImg").attr("src","images/position.jpg");
					}else{
						 $("#androidImg").attr("src","../home/images/android.png");
					}
					
					if(imgInfos.datas.sysImgIosName==""||imgInfos.datas.sysImgIosName==null){
						 $("#iosImg").attr("src","images/position.jpg");
					}else{
						 $("#iosImg").attr("src","../home/images/ios.png");
					}
					
					var sysImgAndroidUrl = imgInfos.datas.sysImgAndroidUrl ;
					var sysImgIosUrl = imgInfos.datas.sysImgIosUrl ;
					$("#androidUrl").attr("href","/OnlineParking/home/downloadOnlinePark?flag=1"); 
					$("#iosUrl").attr("href","/OnlineParking/home/downloadOnlinePark?flag=2"); 
				}
		 }) ; */
        
    })
    </script>
</head>
<body>
    <div class="header">
        <div class="w1100">
            <a class="logo l" href=""><img src="images/logo_03.png" alt=""></a>
            <ul class="nav r">
                <li><a class="cur" href="">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
                <li><a href="">用户体验</a></li>
                <li><a href="">联系我们</a></li>
                <li><a href="">关于我们</a></li>
            </ul>
        </div>
    </div>
    <div class="cneter clearfix ">
         <img class="img" src="images/main3.png">
    </div>
    <div class="footer">
        <div class="footeroDiv">
            <div class="w1100 footer-w">
                <div class="footLeft">
                    <span class="span-f01">版权信息<br />最终解释权归<br />北京银资科技有限公司所有<br /></span> 
					<span class="span-f01">联系我们<br />010-84470260<br /> <br /></span>
					<p>京ICP备21111260551号-x / 京ICP证130164号北京市公安局朝阳分局备案编号:21111260551</p>
                </div>
                <div class="erweima">
                    <div class="relative">
                       <a href="/OnlineParking/home/downloadOnlinePark?flag=1" id="androidUrl"> <img src="images/android.png" class="ios"  id="androidImg"></a><!-- images/position.jpg -->
                       <a href="/OnlineParking/home/downloadOnlinePark?flag=2" id="iosUrl"> <img src="images/ios.png" class="android" id="iosImg"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>