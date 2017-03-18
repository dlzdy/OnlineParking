
//添加停车场信息
function save(){
	
	var parkingInfoId = $("#parkingInfoId").val() ; //停车场名称
	var parkingInfoName = $("#parkingInfoName").val() ; //停车场名称
	var parkingInfoLongitude = $("#parkingInfoLongitude").val() ;//经度
	var parkingInfoLatitude = $("#parkingInfoLatitude").val() ;//纬度
	var parkingInfoAddress = $("#parkingInfoAddress").val() ; //地址
	var parkingInfoState = $("#parkingInfoState").val() ; //营业状态
	var parkingInfoParkingSpaces = $("#parkingInfoParkingSpaces").val() ; //总车位数
	var parkingInfoRestParkingSpaces = $("#parkingInfoRestParkingSpaces").val() ; //现有车位数
	var parkingInfoCreateManagerType = $("#parkingInfoCreateManagerType").val() ;//1 后台管理员类型
	var parkingInfoCreateManagerId = $("#parkingInfoCreateManagerId").val() ;//1 后台管理员id
	
	/********************停车场名称***************/
	if(parkingInfoName==""){ //
		$("#parkingInfoName").tips({
			side : 1,
			msg : '请输入停车场名称',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}
	/***********************经度******************/
	if(parkingInfoLongitude==""){   
		$("#parkingInfoLongitude").tips({
			side : 1,
			msg : '请输入经度',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}else{
		var left = parseFloat(73.33);
		var right = parseFloat(135.55);
		if(!isNaN(parkingInfoLongitude)){
			if(parkingInfoLongitude >= left && parkingInfoLongitude <= right){
				//alert("正确");
			}else{
				$("#parkingInfoLongitude").tips({
					side : 1,
					msg : '请输入正确格式的经度(范围：73.33-135.05)',
					bg : '#AE81FF',
					time : 3
				});
				return false ;
			}
		}else{
			$("#parkingInfoLongitude").tips({
				side : 1,
				msg : '请输入正确格式的经度(范围：73.33-135.05)',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}
	}
	
	/*****************纬度***************/
	if(parkingInfoLatitude==""){
		$("#parkingInfoLatitude").tips({
			side : 1,
			msg : '请输入经度',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}else{
		var left = parseFloat(3.51);
		var right = parseFloat(53.33);
		if(!isNaN(parkingInfoLatitude)){
			if(parkingInfoLatitude >= left && parkingInfoLatitude <= right){
				//alert("正确");
			}else{
				$("#parkingInfoLatitude").tips({
					side : 1,
					msg : '请输入正确格式的纬度(范围：3.51-53.33)',
					bg : '#AE81FF',
					time : 3
				});
				return false ;
			}
		}else{
			$("#parkingInfoLatitude").tips({
				side : 1,
				msg : '请输入正确格式的纬度(范围：3.51-53.33)',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}
	}
	/**********************总车位************************/
	if(parkingInfoParkingSpaces==""){
		$("#parkingInfoParkingSpaces").tips({
			side : 1,
			msg : '请输入总车位',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}else{
		var reg = /^[1-9]\d*$/ //不要以零开头  大于零的正整数
		if(!reg.test(parkingInfoParkingSpaces)){
			$("#parkingInfoParkingSpaces").tips({
				side : 1,
				msg : '请输入不以0开头且大于零的正整数',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}else{
			if(parseInt(parkingInfoParkingSpaces)>9999){
				$("#parkingInfoParkingSpaces").tips({
					side : 1,
					msg : '总车位不可超过9999',
					bg : '#AE81FF',
					time : 3
				});
				return false ;
			}
		}
	}
	/**********************剩余车位*****************************/
	if(parkingInfoRestParkingSpaces==""){
		$("#parkingInfoRestParkingSpaces").tips({
			side : 1,
			msg : '请输入剩余车位',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}else{
		var reg = /^[1-9]\d*$/ //不要以零开头  大于零的正整数
		if(!reg.test(parkingInfoRestParkingSpaces)){
			$("#parkingInfoRestParkingSpaces").tips({
				side : 1,
				msg : '请输入不以0开头且大于零的正整数',
				bg : '#AE81FF',
				time : 3
			});
			return false ;
		}
	}

	/**************************等于车位不能大于总车位******************************/
	if(parseInt(parkingInfoRestParkingSpaces)>parseInt(parkingInfoParkingSpaces)){
		
		$("#parkingInfoRestParkingSpaces").tips({
			side : 1,
			msg : '现有车位不可以大于总车位',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}
	
	var jsonstr = {
			"parkingInfoId":parkingInfoId,
			"parkingInfoName":parkingInfoName,
			"parkingInfoAddress":parkingInfoAddress,
			"parkingInfoLongitude":parkingInfoLongitude,
			"parkingInfoLatitude":parkingInfoLatitude,
			"parkingInfoParkingSpaces":parkingInfoParkingSpaces,
			"parkingInfoRestParkingSpaces":parkingInfoRestParkingSpaces,
			"parkingInfoState":parkingInfoState,
			"parkingInfoCreateManagerType":parkingInfoCreateManagerType,
			"parkingInfoCreateManagerId":parkingInfoCreateManagerId} ;
	if(!checkInvalid()){return false} ; //判断session是否失效 
	$.ajax({
		type: "post",
		url: 'updateParkingInfo', //
		data:$.toJSON(jsonstr),
		dataType:'json',
		contentType : 'application/json',
		success:function(data){
			if(data.result=="1"){
				 $("#table_report2").tips({
						side:1,
			            msg:data.info,
			            bg:'#AE81FF',
			            time:3
			        });
				 setTimeout("hideF()",2000);
			}else if(data.result=="0"){
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

//隐藏 窗口
function hideF(){
	$("#zhongxin").hide();
	top.Dialog.close();
}

