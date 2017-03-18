
//手机号输入框 获得焦点 
var t=$("#managerPhone").val(); 
$("#managerPhone").val("").focus().val(t); 

//添加停车场管理用户
var flag = false ;
function save(){
	var parkingManagerId = $("#parkingManagerId").val() ;
	var parkingInfoId = $("#parkInfoId").val() ;
	var managerName = $("#managerName").val() ;
	var managerPhone = $("#managerPhone").val() ;
	var oldPhone = $("#oldPhone").val() ;
	var parkingManagerActiveMark = $("#parkingManagerActiveMark").val() ;
	var parkingManagerCreateTime = $("#parkingManagerCreateTime").val() ;
	var managerPsw = $("#parkingManagerPsd").val() ;
//	var managerRePsw = $("#managerRePsw").val() ;
	var jsonstr = {"parkingManagerId":parkingManagerId,"parkingInfoId":parkingInfoId,"managerName":managerName,
			"managerPhone":managerPhone,"managerPsw":managerPsw,"parkingManagerActiveMark":parkingManagerActiveMark} ;
	if(parkingInfoId==""){
		$("#parkingInfoId").tips({
			side:1,
            msg:"请选择停车场",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}
	
	if(managerName==""){
		$("#managerName").tips({
			side:1,
            msg:"请输入联系人姓名",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}
	
	if(managerPhone==""){
		$("#managerPhone").tips({
			side:1,
            msg:"请输入用户名",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}
	
	
	//判断是否合法
	var reg = /^[1][0-9]{10}$/ ;
	if(!reg.test(managerPhone)){
		$("#managerPhone").tips({
			side : 1,
			msg : '电话为以1开头的11位纯数字',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}else{
		
		if(managerPhone!=oldPhone){
			if(!checkPhone()){
				return false ;
			}
		}
		if(!checkInvalid()){return false} ; //判断session是否失效 
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'editParkingManager',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				if(data.result=="1"){
					$("#zhongxin").tips({
						side:1,
			            msg:"更新成功",
			            bg:'#AE81FF',
			            time:3
			        });
					setTimeout("hideF()",2000); 
				}else{
					$("#zhongxin").tips({
						side:1,
			            msg:"更新失败",
			            bg:'#AE81FF',
			            time:3
			        });
				}
			}
			
		}) ;
	}
}


//隐藏 窗口
function hideF(){
	$("#zhongxin").hide();
	top.Dialog.close();
}

//检测添加员工的电话号码是否存在 存在则不可以添加
function checkPhone(){
	var flag = false ;
	var managerPhone = $("#managerPhone").val() ;
	var oldPhone = $("#oldPhone").val() ;
	if(managerPhone==oldPhone){
		return false ;
	}
	var jsonstr = {"managerPhone":managerPhone}
	if(!checkInvalid()){return false} ; //判断session是否失效 
	$.ajax({
		type: "POST",
		contentType : 'application/json',
		url: 'toCheckPhoneNumber',
		data:$.toJSON(jsonstr),
		dataType:'json',
		cache: false,
		async:false,
		success: function(data){
			if(data.result=="0"){ //表示存在 不可添加
				$("#managerPhone").tips({
					side:1,
		            msg:"用户名已经存在,不可用",
		            bg:'#AE81FF',
		            time:3
		        });
				flag = false ;
			}else{  //0 表示不存在 可以添加
				flag = true ;
			}
		}
	}) ;
	return flag ;
}

//重置密码
function resetPsw(){
	var oldPhone = $("#oldPhone").val() ;
	var jsonstr = {"managerPhone":oldPhone,"managerPsw":"123456"} ;
	if(!checkInvalid()){return false} ; //判断session是否失效 
	bootbox.confirm("确定要重置密码吗?", function(result) {
		if(result){
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: 'resetPsd',
				data:$.toJSON(jsonstr),
				dataType:'json',
				cache: false,
				success: function(data){
					if(data.result=="1"){
						$("#zhongxin").tips({
							side:1,
				            msg:"重置密码成功",
				            bg:'#AE81FF',
				            time:3
				        });
						setTimeout("hideF()",2000); 
					}else{
						$("#zhongxin").tips({
							side:1,
				            msg:"重置密码失败",
				            bg:'#AE81FF',
				            time:3
				        });
					}
				}
				
			}) ;
		}
	});
}


