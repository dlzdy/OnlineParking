		
	//提交键与enter键绑定
		function enterDown(){
			var event = arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异 
			 if(event.keyCode == 13){
				 login() ;
			 }
		}
		
	
	
      // =============================登录==========================================

		//公共数据
		var $loginname=$("#loginname"),
	    $password=$("#password");
		
		//加载后默认用户名输入框获得焦点
		$loginname.focus();
		
		//校验用户信息
		function login(){
			
			
			//校验用户名为空
			if ($loginname.val() =="") {
				$loginname.tips({
					side : 2,
					msg : '用户名不得为空',
					bg : '#AE81FF',
					time : 3
				}) ;
				$loginname.focus();
				return false;
			}
			
			//校验密码为空
			if ($password.val() =="") {
				$password.tips({
					side : 2,
					msg : '密码不得为空',
					bg : '#AE81FF',
					time : 3
				}) ;
				$password.focus();
				return false;
			}
			
			//校验用户名合法性
			var reg = /^[1][0-9]{10}$/ ;
			if(!reg.test($loginname.val())){//不合法提示
				$loginname.tips({
					side : 2,
					msg : "用户名为以1开头的11位纯数字",
					bg : '#AE81FF',
					time : 3
				});
				$loginname.focus();
		 	  return false ;
			}
			else{//合法
				if(!isFlag()){//非注册用户提示
					return false;
				}
				
			    //登录
				$("#login-box").tips({
	   				side : 1,
	   				msg : '正在登录 , 请稍后 ...',
	   				bg : '#68B500',
	   				time : 5
	   			});
	   			var loginname = $("#loginname").val() ;
	   			var password = $("#password").val() ;
	   		    var jsonstr = {"parkingManagerPhone":loginname,"parkingManagerPsd":password} ;
	  			 $.ajax({
	  				type: "post",
	  				url: 'login',
	  				data:$.toJSON(jsonstr),
	  				dataType:'json',
	  				contentType : 'application/json',
	  				success:function(data){
	  					if(data.result=="1"){
	  						window.location.href="/OnlineParking/index";
	  					}else if(data.result=="0"){
	  						$(".jq_tips_info").remove();
	  						$("#loginname").tips({
	  							side :2,
	  							msg : "用户名或密码错误",
	  							bg : '#AE81FF',
	  							time : 3
	  						});
	  					}
	  				}
	  			}) ;
			}
		}
		//是否为注册用户
	    function isFlag(){
	    	  var flag=false;
	    	  var jsonstr = {"parkingManagerPhone":$("#loginname").val()} ;
	    	  $.ajax({
					type: "post",
					url: 'hasPhoneNumber',
					data:$.toJSON(jsonstr),
					dataType:'json',
					contentType : 'application/json',
					async:false,
					success:function(data){
						if(data.result=="1") {//不存在用户
							$("#loginname").tips({
								side : 2,
								msg : "该用户未注册",
								bg : '#AE81FF',
								time : 3
							});
							flag=false;
						}else {flag=true;}
					}
				}) ; 
			 	return flag;
			 	
	      }
		

