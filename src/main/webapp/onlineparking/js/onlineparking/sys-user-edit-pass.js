//原始密码检查
function checkMyPsd(){
	var  parkingManagerPsd = $("#parkingManagerPsd").val() ;// 原始密码
	var  myParkingManagerPsd = $("#myParkingManagerPsd").val() ;// 输入的原始密码
	if(myParkingManagerPsd==""){
		$("#myParkingManagerPsd").tips({
			side : 1,
			msg : '请输入原始密码',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}
	/*else{
		if(!(parkingManagerPsd==myParkingManagerPsd)){
			$("#myParkingManagerPsd").tips({
				side : 1,
				msg : '原始密码不正确',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}
	}*/
	return true ;
}

//新密码检测
function checkNewPsd(){
	var  newParkingManagerPsd = $("#newParkingManagerPsd").val() ;//  新密码
	if(newParkingManagerPsd==""){
		$("#newParkingManagerPsd").tips({
			side : 1,
			msg : '请输入新密码',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}
	return true ;
}

//重复密码检测
function checkRePsd(){
	if(checkNewPsd()){
		var  newParkingManagerPsd = $("#newParkingManagerPsd").val() ;//  新密码
		var  reParkingManagerPsd = $("#reParkingManagerPsd").val() ;// 重复密码
		if(reParkingManagerPsd==""){
			$("#reParkingManagerPsd").tips({
				side : 1,
				msg : '请重新输入密码',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}else{
			if(!(newParkingManagerPsd==reParkingManagerPsd)){
				$("#reParkingManagerPsd").tips({
					side : 1,
					msg : '两次密码不一致',
					bg : '#AE81FF',
					time : 3
				});
				return false ;
			}
		}
		return true ;
		
	}
}
//保存
function save(){
	var parkingManagerPhone = $("#parkingManagerPhone").val() ;
	var  newParkingManagerPsd = $("#newParkingManagerPsd").val() ;//  新密码
	var  myParkingManagerPsd = $("#myParkingManagerPsd").val() ;
	if(checkMyPsd()&&checkNewPsd()&&checkRePsd()){
		var jsonstr = {"parkingManagerPhone":parkingManagerPhone,
				"parkingManagerPsd":newParkingManagerPsd,
				"myParkingManagerPsd":myParkingManagerPsd} ;
		if(!checkInvalid()){return false} ; //判断session是否失效 
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'updateParkingManagerPsd',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				 if("1" == data.result){
					 $("#zhongxin").tips({
							side:1,
				            msg:"修改成功",
				            bg:'#AE81FF',
				            time:3
				        });
					  setTimeout("hideF()",2000); 
				 }else if("0"==data.result){
					$("#zhongxin").tips({
						side:1,
			            msg:"修改失败",
			            bg:'#AE81FF',
			            time:3
			        });
					return false;
				 }else if(data.result=="2"){
					 $("#myParkingManagerPsd").tips({
							side:1,
				            msg:"原始密码输入错误",
				            bg:'#AE81FF',
				            time:3
				        });
						return false;
				 }
				 else if(data.result=="3"){
					 $("#newParkingManagerPsd").tips({
							side:1,
				            msg:"新密码与旧密码重复，不可修改",
				            bg:'#AE81FF',
				            time:3
				        });
						return false;
				 }
			}
		});
		
	}
	
}
