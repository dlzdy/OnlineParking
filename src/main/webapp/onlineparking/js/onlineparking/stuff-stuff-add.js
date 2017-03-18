//添加停车场管理用户
var flag = false ;
function save(){
	var parkingInfoId = $("#parkingInfoId").val() ;
	var handsetManagerPhone = $("#handsetManagerPhone").val() ;
	var handsetManagerName = $("#handsetManagerName").val() ;
	var jsonstr = {"parkingInfoId":parkingInfoId,"handsetManagerPhone":handsetManagerPhone,"handsetManagerName":handsetManagerName} ;
	if(handsetManagerName==""){
		$("#handsetManagerName").tips({
			side:1,
            msg:"姓名不可以为空",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}
	
	if(handsetManagerPhone==""){
		$("#handsetManagerPhone").tips({
			side:1,
            msg:"请输入手机号码",
            bg:'#AE81FF',
            time:3
        });
		return false ;
	}
	
	//判断是否合法
	var reg = /^[1][0-9]{10}$/ ;
	if(!reg.test(handsetManagerPhone)){
		$("#handsetManagerPhone").tips({
			side : 1,
			msg : '电话为以1开头的11位纯数字',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}else{
		
		if(!checkPhone()){
			return false ;
		}
		if(!checkInvalid()){return false} ; //判断session是否失效 
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'creatHandsetManager',
			data:$.toJSON(jsonstr),
			dataType:'json',
			cache: false,
			success: function(data){
				if(data.result=="1"){
					$("#zhongxin").tips({
						side:1,
			            msg:"添加成功",
			            bg:'#AE81FF',
			            time:3
			        });
					setTimeout("hideF()",2000); 
				}else{
					$("#zhongxin").tips({
						side:1,
			            msg:"添加失败",
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
	var handsetManagerPhone = $("#handsetManagerPhone").val() ;
	var jsonstr = {"handsetManagerPhone":handsetManagerPhone}
	if(!checkInvalid()){return false} ; //判断session是否失效 
	$.ajax({
		type: "POST",
		contentType : 'application/json',
		url: 'hasManagerPhone',
		data:$.toJSON(jsonstr),
		dataType:'json',
		cache: false,
		async:false,
		success: function(data){
			if(data.result=="1"){ //表示存在 不可添加
				$("#handsetManagerPhone").tips({
					side:1,
		            msg:"手机号已经存在,不可用",
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