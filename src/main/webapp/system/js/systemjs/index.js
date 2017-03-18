		
	//提交键与enter键绑定
		function enterDown(){
			var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
			 if(event.keyCode == 13){
				 login() ;
			 }
		}
		
		function login(){
			var userName = $("#userName").val() ;
			var passWord = $("#passWord").val() ;
			//判断不为空
			if(userName==""){
				$("#userName").tips({
					side : 2,
					msg : '请输入用户名',
					bg : '#AE81FF',
					time : 3
				});
		 	  return false ;
			}else{
				//判断用户名为6-20位的数字、字母 或者 组合
				var reg = /[0-9a-zA-Z]{4,20}/ ;
				if(!reg.test(userName)){
					$("#userName").tips({
						side : 2,
						msg : '用户名为4-20位的数字、字母 或者 组合',
						bg : '#AE81FF',
						time : 3
					});
			 	  return false ;
				}
			}
			
			if(passWord==""){
				$("#passWord").tips({
					side : 2,
					msg : '请输入密码',
					bg : '#AE81FF',
					time : 3
				});
		 	  return false ;
			}
			
			 $("#login-box").tips({
					side : 1,
					msg : '正在登录，请稍后...',
					bg : '#68B500',
					time : 3
				});
			 
			 
			 var jsonstr = {"userName":userName,"passWord":passWord} ;
			 $.ajax({
				 type: "POST",
					contentType : 'application/json',
					url: 'systemUserlogin',
					data:$.toJSON(jsonstr),
					dataType:'json',
					cache: false,
					success: function(data){
						if(data.result=="1"){
							window.location.href="/OnlineParking/toSystemLogin" ;
						}else{
							$(".jq_tips_info").remove();
							 $("#userName").tips({
									side : 2,
									msg : '用户名或密码有错误',
									bg : '#AE81FF',
									time : 3
								});
						}
					}
			 }) ;
			
		}
		
		
		
		
		
		
		
		
		
		

/*后台系统登录界面js*/
//检查电话号码
/*var flagUserName = false ;
function checkUserName(){
	var userName = $("#userName").val() ;
	if(userName==""){
		$("#userName").tips({
			side : 2,
			msg : '请输入用户名',
			bg : '#AE81FF',
			time : 3
		});
 	  return false ;
	}
	else{
		//判断用户名为6-20位的数字、字母 或者 组合
		var reg = /[0-9a-zA-Z]{4,20}/ ;
		if(!reg.test(userName)){
			$("#userName").tips({
				side : 2,
				msg : '用户名为4-20位的数字、字母 或者 组合',
				bg : '#AE81FF',
				time : 3
			});
	 	  return false ;
		}
	}
	flagUserName = true ;
}

//检查登录密码
var flagPassWord = false ;
function checkPassWord(){
	var passWord = $("#passWord").val() ;
	if(passWord==""){
		$("#passWord").tips({
			side : 2,
			msg : '请输入密码',
			bg : '#AE81FF',
			time : 3
		});
 	  return false ;
	}
	flagPassWord = true ;
}

//登录
 function login(){
	 var userName = $("#userName").val() ;
	 var passWord = $("#passWord").val() ;
	 if(flagUserName){
		 if(flagPassWord){
			 
			 $("#login-box").tips({
					side : 1,
					msg : '正在登录，请稍后...',
					bg : '#68B500',
					time : 3
				});
			 
			 
			 var jsonstr = {"userName":userName,"passWord":passWord} ;
			 $.ajax({
				 type: "POST",
					contentType : 'application/json',
					url: 'systemUserlogin',
					data:$.toJSON(jsonstr),
					dataType:'json',
					cache: false,
					success: function(data){
						if(data.result=="1"){
							window.location.href="/OnlineParking/toSystemLogin" ;
						}else{
							$(".jq_tips_info").remove();
							 $("#userName").tips({
									side : 2,
									msg : '用户名或密码有错误',
									bg : '#AE81FF',
									time : 3
								});
						}
					}
			 }) ;
		 }else{
			 checkPassWord(); 
		 }
	 }else{
		 checkUserName() ; 
	 }
 }*/
 
//检测 用户名
 function checkSignUserName(){
	 var signUserName = $("#signUserName").val() ;
	 if(signUserName==""){
		 $("#signUserName").tips({
				side : 2,
				msg : '请输入用户名',
				bg : '#AE81FF',
				time : 3
			});
		 return false ;
	 }else{
		 var reg = /[0-9a-zA-Z]{4,20}/ ;
		 if(!reg.test(signUserName)){
				$("#signUserName").tips({
					side : 2,
					msg : '用户名为4-20位的数字、字母 或者 组合',
					bg : '#AE81FF',
					time : 3
				});
		 	  return false ;
			}
	 }
	 return true ;
 }
//检测密码
 function checkSignPassWord(){
	 var signPassWord = $("#signPassWord").val() ;
	 if(signPassWord==""){
		 $("#signPassWord").tips({
				side : 2,
				msg : '请输入密码',
				bg : '#AE81FF',
				time : 3
			});
		 return false ;
	 }
	 return true ;
 }
 
 //检测重复密码
 function checkRePassWord(){
	 var repeatPassWord = $("#repeatPassWord").val() ;
	 var signPassWord = $("#signPassWord").val() ;
	 if(repeatPassWord==""){
		 $("#repeatPassWord").tips({
				side : 2,
				msg : '请输入重复密码',
				bg : '#AE81FF',
				time : 3
			});
		 return false ;
	 }else{
		 if(repeatPassWord!=signPassWord){
			 $("#repeatPassWord").tips({
					side : 2,
					msg : '两次输入的密码不一致',
					bg : '#AE81FF',
					time : 3
				});
			 return false ; 
		 }
	 }
	 return true ;
 }

//注册
function signUser(){
	 var signUserName = $("#signUserName").val() ;
	 var signPassWord = $("#signPassWord").val() ;
	if(checkSignUserName()&&checkSignPassWord()&&checkRePassWord()){
		 var jsonstr = {"signUserName":signUserName,"signPassWord":signPassWord} ;
		 $.ajax({
			 type: "POST",
				contentType : 'application/json',
				url: 'systemUserSign',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(data){
					if(data.result=="1"){
						window.location.href="/OnlineParking/toSystemLogin" ;
					}else{
						 $("#signErrorMsg").tips({
								side : 1,
								msg : '注册失败....',
								bg : '#AE81FF',
								time : 3
							});
					}
				}
		 }) ;
	}
} 





