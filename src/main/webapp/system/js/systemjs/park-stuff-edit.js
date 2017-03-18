//添加停车场管理用户
var flag = false ;
function save(){
	var parkingInfoId = $("#parkInfoId").val() ;
	var managerId = $("#managerId").val() ;
	var managerName = $("#managerName").val() ;
	var handsetManagerPhone = $("#phone").val() ;
	var oldPhone = $("#oldPhone").val() ;//原始手机号
	var handsetId = $("#handsetId").val() ;//绑定的设备id
	var oldParkInfoId = $("#oldParkInfoId").val() ;//旧停车场id
	
	if((handsetId!="noBound")){//如果绑定设备,
		 if(oldParkInfoId!=parkingInfoId){//并且将停车场修改
				$("#parkInfoId").tips({
					side:3,
		            msg:"解除设备绑定后对停车场进行修改",
		            bg:'#AE81FF',
		            time:3
		        });
				return false ;
		 }
	}
	
	if(managerName==""){
		$("#managerName").tips({
			side:1,
            msg:"姓名不可以为空",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}
	
	//alert("handsetManagerPhone:"+handsetManagerPhone+";oldPhone:"+oldPhone) ;
	//判断电话是否改动过
	if(oldPhone!=handsetManagerPhone){
		checkPhone() ;
		if(!flag){
			return false ;
		}
	}
	
	var jsonstr = {"parkingInfoId":parkingInfoId,"managerId":managerId,"handsetManagerPhone":handsetManagerPhone,"managerName":managerName,
			"oldPhone":oldPhone}
	if(!checkInvalid()){return false} ; //判断session是否失效 
	/*if(flag){*/
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'upSysHandsetManagerPhone',
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
		checkPhone()
	}
	*/
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
		url: 'hasManagerPhone',
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