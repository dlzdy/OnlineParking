function save(){
	var clientUserId = $("#clientUserId").val() ;
	var clientUserNickName = $("#clientUserNickName").val() ;
	var clientUserSex = $("#clientUserSex").val() ;
	var clientUserBirthday = $("#clientUserBirthday").val() ;
	var clientUserCellphone = $("#clientUserCellphone").val() ;//后台返回的手机号
	var newClientUserCellphone = $("#newClientUserCellphone").val() ;//重新输入的手机号
	var clientUserAutoPay = $("#clientUserAutoPay").val() ;
	var clientUserSecurity = $("#clientUserSecurity").val() ;
	var flag = check() ;
	if(check()){
		var jsonstr = {"clientUserId":clientUserId,"clientUserNickName":clientUserNickName,
				"clientUserSex":clientUserSex,"clientUserBirthday":clientUserBirthday,
				"clientUserCellphone":newClientUserCellphone,"clientUserAutoPay":clientUserAutoPay,
				"clientUserSecurity":clientUserSecurity};
		if(!checkInvalid()){return false} ; //判断session是否失效 
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'editPhoneUser',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
 				if(data.result=="1"){ //表示存在 不可添加
					$("#table_report2").tips({
						side:1,
			            msg:"修改成功",
			            bg:'#AE81FF',
			            time:3
			        });
					 setTimeout("hideF()",2000);
				}else{
					$("#table_report2").tips({
						side:1,
			            msg:data.info,
			            bg:'#AE81FF',
			            time:3
			        });
					return false;
				}
			}
		}) ;
	}
}

//
function check(){
	var clientUserId = $("#clientUserId").val() ;
	var clientUserNickName = $("#clientUserNickName").val() ;
	var clientUserSex = $("#clientUserSex").val() ;
	var clientUserBirthday = $("#clientUserBirthday").val() ;
	var clientUserCellphone = $("#clientUserCellphone").val() ;//后台返回的手机号
	var newClientUserCellphone = $("#newClientUserCellphone").val() ;//重新输入的手机号
	var clientUserAutoPay = $("#clientUserAutoPay").val() ;
	var clientUserSecurity = $("#clientUserSecurity").val() ;
	if(clientUserCellphone!=newClientUserCellphone){//如果后台返回的手机号与新输入的手机号不同
		if(newClientUserCellphone==""||newClientUserCellphone==null){
			$("#newClientUserCellphone").tips({
				side : 1,
				msg : '请输入电话号码',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}else{
			var reg = /^[1][0-9]{10}$/ ;
			if(!reg.test(newClientUserCellphone)){
				$("#newClientUserCellphone").tips({
					side : 1,
					msg : '电话为以1开头的11位纯数字',
					bg : '#AE81FF',
					time : 3
				});
				return false ;
			}
		}
		//如果格式都正确 则 判断是否该手机号在数据库中是否存在
		var jsonstr = {"clientUserCellphone":newClientUserCellphone} ;
		if(!checkInvalid()){return false} ; //判断session是否失效 
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'checkPhoneNumber',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				if(data.result=="0"){ //0表示存在，不可以添加      1表示不存在 可以添加
					$("#newClientUserCellphone").tips({
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
	return true ;
}


//隐藏 窗口
function hideF(){
	$("#zhongxin").hide();
	top.Dialog.close();
}
