//添加停车场管理用户
function save(){
	//获取数据
	var parkingInfoId = $("#parkInfoId").val() ;
	var handsetManagerPhone = $("#handsetManagerPhone").val() ;
	var name = $("#name").val() ;
	
	var jsonstr = {"parkingInfoId":parkingInfoId,"handsetManagerPhone":handsetManagerPhone,"handsetManagerName":name}
	
	//判断不可以为空
	if(name==""){
		$("#name").tips({
			side : 1,
			msg : '用户名不得为空',
			bg : '#AE81FF',
			time : 3
		}) ;
		return false ;
	}
	
	if(handsetManagerPhone==""){
		$("#handsetManagerPhone").tips({
			side : 1,
			msg : '手机号不得为空',
			bg : '#AE81FF',
			time : 3
		}) ;
		return false ;
	}
	
	//判断是否合法
	var reg = /^[1][0-9]{10}$/ ;
	if(!reg.test(handsetManagerPhone)){
		$("#handsetManagerPhone").tips({
			side : 1,
			msg : '手机号为以1开头的11位纯数字',
			bg : '#AE81FF',
			time : 3
		}) ;
		return false ;
	}else{ //是否存在
		//debugger ;
		var hasPhone = checkPhone() ;
		if(!hasPhone){
			return false ;
		}
		if(!checkInvalid()){return false} ; //判断session是否失效 
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: 'creatSysHandsetManager',
			data:$.toJSON(jsonstr),
			dataType:'json',
			//cache: false,
			//async:false,
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
	var jsonstr = {"handsetManagerPhone":handsetManagerPhone} ;
	if(!checkInvalid()){return false} ; //判断session是否失效 
	$.ajax({
		type: "POST",
		contentType : 'application/json',
		url: 'hasManagerPhone',
		data:$.toJSON(jsonstr),
		dataType:'json',
		//cache: false,
		async:false,  //默认true 为异步，false为同步
		success: function(data){
			if(data.result=="1"){ //表示存在 不可添加
				$("#handsetManagerPhone").tips({
					side:1,
		            msg:"手机号已经存在,不可用",
		            bg:'#AE81FF',
		            time:3
		        });
				flag = false ;
			}else if(data.result=="0"){
				flag = true ;  //手机号可用
			}
		}
	}) ;
	return flag ;
}


