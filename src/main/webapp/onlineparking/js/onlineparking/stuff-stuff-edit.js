//添加停车场管理用户
var flag = false ;
function save(){
	var uID = $("#uID").val() ;
	var managerId = $("#managerId").val() ;
	var oldPhone = $("#oldPhone").val() ;//从后台返回的手机号
	var phone = $("#phone").val() ;
	var managerName = $("#managerName").val() ;
	
	if(managerName==""){
		$("#managerName").tips({
			side:1,
            msg:"用户名不可以为空",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}
	
	//判断电话是否改动过
	if(oldPhone!=phone){
		checkPhone() ;
		if(!flag){
			return false ;
		}
	}
	//alert("managerId:"+managerId+"oldPhone:"+oldPhone+"phone:"+phone+"managerName:"+managerName) ;
	var jsonstr = {"managerId":managerId,"phone":phone,"managerName":managerName,"oldPhone":oldPhone} ;
	/*if(flag){*/
	if(!checkInvalid()){return false} ; //判断session是否失效 
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'upHandsetManagerPhone',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				if(data.result=="1"){
					$("#zhongxin").tips({
						side:1,
			            msg:"修改成功",
			            bg:'#AE81FF',
			            time:3
			        });
					setTimeout("hideF()",2000);
				}else{
					$("#zhongxin").tips({
						side:1,
			            msg:"修改失败",
			            bg:'#AE81FF',
			            time:3
			        });
				}
			}
			
		}) ;
	/*}else{
		checkPhone() ;
	}*/
	
}


//隐藏 窗口
function hideF(){
	$("#zhongxin").hide();
	top.Dialog.close();
}

//检测添加员工的电话号码是否存在 存在则不可以添加
function checkPhone(){
	var phone = $("#phone").val() ;
	if(phone==""){
		$("#phone").tips({
			side : 1,
			msg : '请输入电话号码',
			bg : '#AE81FF',
			time : 3
		});
		flag = false ;
		return false ;
	}else{
		var reg = /^[1][0-9]{10}$/ ;
		if(!reg.test(phone)){
			$("#phone").tips({
				side : 1,
				msg : '电话为以1开头的11位纯数字',
				bg : '#AE81FF',
				time : 3
			});
			flag = false ;
			return false ;
		}
	}
	
	var jsonstr = {"handsetManagerPhone":phone} ;
	if(!checkInvalid()){return false} ; //判断session是否失效 
	$.ajax({
		type: "POST",
		contentType : 'application/json',
		url: '/OnlineParking/hasManagerPhone',
		data:$.toJSON(jsonstr),
		dataType:'json',
		cache: false,
		success: function(data){
			if(data.result=="1"){ //表示存在 不可添加
				$("#phone").tips({
					side:1,
		            msg:"手机号已经存在,不可用",
		            bg:'#AE81FF',
		            time:3
		        });
				flag = false ;
				return false ;
			}else{  //0 表示不存在 可以添加
				flag = true ;
				return true ; 
			}
		}
	}) ;
}