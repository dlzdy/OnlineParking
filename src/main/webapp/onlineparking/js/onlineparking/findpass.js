// ==========================密码找回====================
	/* 	$("#subBtn").click(function(){
			//debugger ;
			var userPhone = $("#fPhone").val() ; 
			var userPassWord = $("#fPassWord").val() ; 
			var repeatUserPassWord = $("#fRePassWord").val() ;
		
			var reg = /^[1][0-9]{10}$/ ;
			if(userPhone==""){
				$("#fPhone").tips({
					side : 2,
					msg : '请输入电话',
					bg : '#AE81FF',
					time : 3
				});
		 	  return false ;
			}else{
			 	if(!reg.test(userPhone)){
			 		$("#fPhone").tips({
						side : 2,
						msg : '电话为以1开头的11位纯数字',
						bg : '#AE81FF',
						time : 3
					});
			 	 return false ;
			 	}
			}
			
			if(userPassWord==""){
				$("#fPassWord").tips({
					side : 2,
					msg : '请输入密码',
					bg : '#AE81FF',
					time : 3
				});
				return false ;
			}
			
			if(repeatUserPassWord==""){
				$("#fRePassWord").tips({
					side : 2,
					msg : '请输入重复密码',
					bg : '#AE81FF',
					time : 3
				});
				return false ;
			}
			
			if(!(repeatUserPassWord==userPassWord)){
				
				$("#fRePassWord").tips({
					side : 2,
					msg : '两次密码输入不一致',
					bg : '#AE81FF',
					time : 3
				});
				return false ;
			}
			var jsonstr = {"parkingManagerPhone":userPhone,"parkingManagerPsd":userPassWord} ;
			 $.ajax({
				type: "post",
				url: 'updateParkingManagerPsd',
				data:$.toJSON(jsonstr),
				dataType:'json',
				contentType : 'application/json',
				success:function(data){
					if(data.result=="1"){
						window.location.href="http://localhost:8080/OnlineParking/toIndex?parkingManagerPhone="+userPhone;
					}else if(data.result=="0"){
						$("#forgot-box").tips({
							side : 1,
							msg : data.info,
							bg : '#AE81FF',
							time : 3
						});
					}
				}
			}) ;
			
		}) ;  */
	
		 
	    //获取验证码
	    var codeFlag = false ;
	    var InterValObj; //timer变量，控制时间
	    var count = 5; //间隔函数，1秒执行
	    var curCount ;
	    function getCode(){
	    	
	    	if( checkFPhone()){
	    		 curCount = 60;//当前剩余秒数
	  		   //设置button效果，开始计时
	  		     $("#checkBtn").attr("disabled", "true");
	  		     $("#checkBtn").html("请在" + curCount + "秒内输入验证码");
	  		     InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
				 var fPhone = $("#fPhone").val() ;
					var jsonstr = {"telNumber":fPhone} ;
				 	$.ajax({
				 		type: "POST",
						contentType : 'application/json',
						url: 'getCode',
						data:$.toJSON(jsonstr),
						dataType:'json',
						cache: false,
						success: function(data){
							if(data.result=="1"){
							  $("#verifycode").val(data.code) ;
							  codeFlag = true ;
							  return true ;
							}else{
							  codeFlag = false ;
							  return false ;
							}
						}
				 		
				 	});
	    	}
		}
		 
	  //timer处理函数
	    function SetRemainTime() {
	                if (curCount == 0) {                
	                    window.clearInterval(InterValObj);//停止计时器
	                    $("#checkBtn").removeAttr("disabled");//启用按钮
	                    $("#checkBtn").html("重新发送验证码");
	                }
	                else {
	                    curCount--;
	                    $("#checkBtn").html("请在" + curCount + "秒内输入验证码");
	                }
	            }
	    
	   //判断手机号
 	   var checkPFlag = false ;
	   function checkFPhone(){
		   var fPhone = $("#fPhone").val() ;
		   if(fPhone==""){
			   $("#fPhone").tips({
					side :2,
					msg : "请输入手机号",
					bg : '#AE81FF',
					time : 3
				});
			   return false ;
		   }else{
			   var reg = /^[1][0-9]{10}$/ ;
			   if(!reg.test(fPhone)){
			 		$("#fPhone").tips({
						side : 2,
						msg : '电话为以1开头的11位纯数字',
						bg : '#AE81FF',
						time : 3
					});
			 	 return false ;
			 	}
		   
		   }
		   
			var fPhone = $("#fPhone").val() ;
    		var jsonstr = {"parkingManagerPhone":fPhone} ;
			$.ajax({
				type: "post",
				url: 'hasPhoneNumber',
				data:$.toJSON(jsonstr),
				dataType:'json',
				contentType : 'application/json',
				success:function(data){
					if(data.result=="1") {//不存在用户
						$("#fPhone").tips({
							side : 2,
							msg : "用户不在",
							bg : '#AE81FF',
							time : 3
						});
						checkPFlag = false ;
					    return false ;
					}else if(data.result=="0"){ //用户存在
						checkPFlag = true ;
						return true ;
					}
				}
				
			})  ;
			
		   return true ;
	 }
		  
	   //找回密码界面提交 手机号+验证码
	   $("#subBtn").click(function(){
		  // alert(checkPFlag) ;
		   if(checkPFlag){
			   var verifycode =  $("#verifycode").val() ;
			   if(verifycode==""){
				   $("#verifycode").tips({
						side : 2,
						msg : "请输入验证码" ,
						bg : '#AE81FF',
						time : 3
					});
				   return false ;
			   }
		   }else{
			   checkFPhone() ;
			   return false ;
		   }
		   var fPhone = $("#fPhone").val() ;
		 //  var verifycode = $("#verifycode").val() ;
		   var jsonstr = {"parkingManagerPhone":fPhone,"verifycode":verifycode} ;
			 $.ajax({
				type: "post",
				url: 'checkPCode',
				data:$.toJSON(jsonstr),
				dataType:'json',
				contentType : 'application/json',
				success:function(data){
					if(data.result=="1"){
						show_box('findpw-box');
					}else if(data.result=="0"){
						$("#verifycode").tips({
							side : 2,
							msg : '验证码输入有误',
							bg : '#AE81FF',
							time : 3
						});
						return false ;
					}
				}
			}) ;
		 
	   });
	   
	   
	   //重置密码
	 	$("#reSetPass").click(function(){
		//debugger ;
		var userPhone = $("#fPhone").val() ; 
		var userPassWord = $("#fPassWord").val() ; 
		var repeatUserPassWord = $("#fRePassWord").val() ;
	
		
		
		if(userPassWord==""){
			$("#fPassWord").tips({
				side : 2,
				msg : '请输入密码',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}
		
		if(repeatUserPassWord==""){
			$("#fRePassWord").tips({
				side : 2,
				msg : '请输入重复密码',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}
		
		if(!(repeatUserPassWord==userPassWord)){
			
			$("#fRePassWord").tips({
				side : 2,
				msg : '两次密码输入不一致',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}
		var jsonstr = {"parkingManagerPhone":userPhone,"parkingManagerPsd":userPassWord} ;
		 $.ajax({
			type: "post",
			url: 'updateParkingManagerPsd',
			data:$.toJSON(jsonstr),
			dataType:'json',
			contentType : 'application/json',
			success:function(data){
				if(data.result=="1"){
					window.location.href="/OnlineParking/index";
				}else if(data.result=="0"){
					$("#findpw-box").tips({
						side : 1,
						msg : data.info,
						bg : '#AE81FF',
						time : 3
					});
				}
			}
		}) ;
		
	}) ; 

	   