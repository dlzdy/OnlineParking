//查看个人资料 by xumingyue
function editUserH(){
	var systemManagerId = $("#systemManagerId").val() ;//隐藏域 存放在 parkingbackstage/logindefault/login.jsp
	var systemManagerPsd = $("#systemManagerPsd").val() ;//隐藏域 存放在 parkingbackstage/logindefault/login.jsp
	var systemManagerUsername = $("#systemManagerUsername").val() ;//隐藏域 存放在 parkingbackstage/logindefault/login.jsp
	 jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="修改密码";
	 diag.URL = '/OnlineParking/toUpdateUserInfo';
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

//检测新密
function checkNewPassWord(){
	var systemManagerPsd = $("#systemManagerPsd").val() ;
	var newSystemManagerPsd = $("#newSystemManagerPsd").val() ;
	if(newSystemManagerPsd==""){
		$("#newSystemManagerPsd").tips({
			side:1,
            msg:"请输入新密码",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}else{
		if(systemManagerPsd==newSystemManagerPsd){
			$("#newSystemManagerPsd").tips({
				side:1,
	            msg:"新密码不可与旧密码一致",
	            bg:'#AE81FF',
	            time:3
	        });
			return false ;
		}
	}
	return true ;
}

//检测重复密码
function checkRePassWord(){
	var newSystemManagerPsd = $("#newSystemManagerPsd").val() ;
	var reSystemManagerPsd = $("#reSystemManagerPsd").val() ;
	if(reSystemManagerPsd==""){
		$("#reSystemManagerPsd").tips({
			side:1,
            msg:"请重新输入密码",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}else{
		if(reSystemManagerPsd!=newSystemManagerPsd){
			$("#reSystemManagerPsd").tips({
				side:1,
	            msg:"两次密码不一致",
	            bg:'#AE81FF',
	            time:3
	        });
			return false ;
		}
	}
	return true ;
}




//保存
function save(){
	var systemManagerUsername = $("#systemManagerUsername").val() ;
	var newSystemManagerPsd = $("#newSystemManagerPsd").val() ;
	if(checkNewPassWord()&& checkRePassWord()){
		var jsonstr = {"systemManagerUsername":systemManagerUsername,
				"newSystemManagerPsd":newSystemManagerPsd} ;
		if(!checkInvalid()){return false} ; //判断session是否失效 
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: '/OnlineParking/updateUserInfo',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				 if("1" == data.result){
					 $("#zhongxin").tips({
							side:1,
				            msg:'修改成功!',
				            bg:'#AE81FF',
				            time:3
				        });
					  setTimeout("hideF()",2000); 
				 }else if("0"==data.result){
					$("#zhongxin").tips({
						side:1,
			            msg:'修改失败!',
			            bg:'#AE81FF',
			            time:3
			        });
					return false;
				 }
			}
		});
	}
}
//隐藏 窗口
function hideF(){
	$("#zhongxin").hide();
	top.Dialog.close();
}