var locat = (window.location+'').split('/'); 
$(function(){if('main'== locat[3]){locat =  locat[0]+'//'+locat[2];}else{locat =  locat[0]+'//'+locat[2]+'/'+locat[3];};});


//菜单状态切换
var fmid = "fhindex";
var mid = "fhindex";
var iframeUrl='';
function siMenu(id,fid,MENU_NAME,MENU_URL){
	if(id != mid){
		$("#"+mid).removeClass();
		mid = id;
	}
	if(fid != fmid){
		$("#"+fmid).removeClass();
		fmid = fid;
	}
	$("#"+fid).attr("class","active open");
	$("#"+id).attr("class","active");
	
	//session失效
	var win=window;
	$.ajax({
 		type: "POST",
		contentType : 'application/json',
		url: 'getSession',
		//data:$.toJSON(jsonstr),
		dataType:'json',
		cache: false,
		success: function(data){
			
		  if(data.result==null||data.result=="null"||data.result==""){
			  setTimeout(alert('登录超时，请重新登录'),3000);
			  win.location='onlineparking/';
		  }else{
			  top.mainFrame.tabAddHandler(id,MENU_NAME,MENU_URL);
			  jzts(); 
		  }
		}
 		
 	});
}

$(function(){

	//换肤
	$("#skin-colorpicker").ace_colorpicker().on("change",function(){
		var b=$(this).find("option:selected").data("class");
		hf(b);
		var url = locat+'/head/setSKIN.do?SKIN='+b+'&tm='+new Date().getTime();
		$.get(url,function(data){});
	
	});
});





//关联停车场  by xumingyue
function relativePark(){
	var userID  = $("#userID").val() ; //userID放在 system/admin/index.jsp中<!-- 登录时的用户名 即为电话号码 -->
	var uID  = $("#uID").val() ; //uID放在 system/admin/index.jsp中<!-- 后台通过电话号码将 用户id取出 -->
	 jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="关联停车场";
	 diag.URL = 'toInsertInfoId?userID='+userID+'&uID='+uID;
	 diag.Width = 300;
	 diag.Height = 200;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
}

//查看个人资料 by xumingyue
function editUserH(){
	var userID  = $("#userID").val() ; //userID放在 system/admin/index.jsp中<!-- 登录时的用户名 即为电话号码 -->
	var uID  = $("#uID").val() ; //uID放在 system/admin/index.jsp中<!-- 后台通过电话号码将 用户id取出 -->
	 jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="个人资料";
	 diag.URL = locat+'/goEditU?userID='+userID+'&uID='+uID;
	 diag.Width = 300;
	 diag.Height = 400;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
}
//修改用户手机号  by xumingyue
function updateUserPhone(){
	var userID  = $("#userID").val() ; //userID放在 system/admin/index.jsp中<!-- 登录时的用户名 即为电话号码 -->
	var uID  = $("#uID").val() ; //uID放在 system/admin/index.jsp中<!-- 后台通过电话号码将 用户id取出 -->
	 jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="更换手机号";
	 diag.URL = locat+'/updateUserPhone?userID='+userID+'&uID='+uID;
	 diag.Width = 300;
	 diag.Height = 400;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
}
//修改用户密码  by xumingyue
function updateUserPass(){
	var userID  = $("#userID").val() ; //userID放在 system/admin/index.jsp中<!-- 登录时的用户名 即为电话号码 -->
	var uID  = $("#uID").val() ; //uID放在 system/admin/index.jsp中<!-- 后台通过电话号码将 用户id取出 -->
	jzts();
	var diag = new top.Dialog();
	diag.Drag=true;
	diag.Title ="修改密码";
	diag.URL = locat+'/updateUserPass?userID='+userID+'&uID='+uID;
	diag.Width = 300;
	diag.Height = 400;
	diag.CancelEvent = function(){ //关闭事件
		diag.close();
	};
	diag.show();
}

//清除加载进度
function hangge(){
	$("#jzts").hide();
}

//显示加载进度
function jzts(){
	$("#jzts").show();
}
$(function(){  //界面加载时  如果是关联停车场界面  隐藏右上角的小差
	if($('#_Title_0').text()=="关联停车场"){
		$('#_ButtonClose_0').hide();
	}
})
