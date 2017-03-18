//判断新手机号码
function checkNewPhone(){
	var  parkingManagerPhone = $("#parkingManagerPhone").val() ; //原始密码
	var newParkingManagerPhone = $("#newParkingManagerPhone").val() ; //新密码
	if(newParkingManagerPhone==""){
		$("#newParkingManagerPhone").tips({
			side:1,
            msg:"请输入新手机号",
            bg:'#AE81FF',
            time:3
        });
	   return false ;
	}else{
		var reg = /^[1][0-9]{10}$/ ;
		if(!reg.test(newParkingManagerPhone)){
			$("#newParkingManagerPhone").tips({
				side : 1,
				msg : '电话为以1开头的11位纯数字',
				bg : '#AE81FF',
				time : 3
			});
	 	 return false ;
		}
	}
	
	if(parkingManagerPhone==newParkingManagerPhone){
		 $("#newParkingManagerPhone").tips({
				side:1,
	            msg:"手机号没有改变，不可以修改",
	            bg:'#AE81FF',
	            time:3
	        });
		return false ;
	}
	
	
	var jsonstr = {"parkingManagerPhone":newParkingManagerPhone} ;
	$.ajax({
		
		type: "POST",
		contentType : 'application/json',
		url: 'hasPhoneNumber',
		data:$.toJSON(jsonstr),
		dataType:'json',
		cache: false,
		success: function(data){
			if(data.result=="1"){ //表示不存在
			  return true ;
			}else{  //0表示已经存在 不可用
				 $("#newParkingManagerPhone").tips({
						side:1,
			            msg:"手机号已经存在,不可用",
			            bg:'#AE81FF',
			            time:3
			        });
			  return false ;
			}
		}
		
	}) ;
	
	return true ;
}
//获取验证码 
function getCode(){
	
	if(checkNewPhone()){
		   var fPhone = $("#newParkingManagerPhone").val() ;
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
					  return true ;
					}else{
					  return false ;
					}
				}
		 		
		 	});
	}
}

//保存

function save(){
	var verifycode = $("#verifycode").val() ;
	if(checkNewPhone()){
		if(!(verifycode=="")){  //验证码不为空
			var  parkingManagerId = $("#parkingManagerId").val() ; 
			var newParkingManagerPhone = $("#newParkingManagerPhone").val() ; //新密码
			var jsonstr = {"parkingManagerId":parkingManagerId,"parkingManagerPhone":newParkingManagerPhone,"verifycode":verifycode}
			if(!checkInvalid()){return false} ; //判断session是否失效 
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: 'modiUserPhone',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(data){
					 if("1" == data.result){
						 $("#zhongxin").tips({
								side:1,
					            msg:data.info,
					            bg:'#AE81FF',
					            time:3
					        });
						 setTimeout("hideF()",2000); 
					 }else if("0"==data.result){
						$("#verifycode").tips({
							side:1,
				            msg:"验证码输入有误",
				            bg:'#AE81FF',
				            time:3
				        });
						return false;
					 }
				}
			});
		}else{
			 $("#verifycode").tips({
					side:1,
		            msg:"请输入验证码",
		            bg:'#AE81FF',
		            time:3
		        });
			 return false ;
		}
		
	}
}



