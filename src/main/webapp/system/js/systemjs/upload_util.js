//检测版本名称是否合法

function checkVersionName(versionName,versionOldName,element){
	var reg=/^[1-9]\.[0-9]+\.[0-9]+\.[0-9]+$/; 
	 if(versionName == "" || versionName == null){
		 $("#"+element).tips({
				side : 1,
				msg : '请输入版本名称',
				bg : '#AE81FF',
				time : 3
			});
		 return false ;
	 } 
	 if(!reg.test(versionName)){
		 $("#"+element).tips({
				side : 1,
				msg : '请输入正确的版本名称(格式如:1.0.0.0)',
				bg : '#AE81FF',
				time : 3
			});
		 return false ;
	 }else{
		 if(!isValidate(versionOldName,versionName)){
			 $("#"+element).tips({
					side : 1,
					msg : '新版本名称必须大于旧版本名称('+versionOldName+')',
					bg : '#AE81FF',
					time : 3
				});
			 return false ; 
		 }
	 }
	 if(versionName == "" || versionName == null){
		 var reg = '/^\d{1,2}(\.\d{1,2}){2,3}$/' ;
		 $("#"+element).tips({
				side : 1,
				msg : '请输入版本名称',
				bg : '#AE81FF',
				time : 3
			});
		 return false ;
	 } 
	 
	 
	 return true ;
}



//判断两个版本号大小
function isValidate(str1,str2){
	var arr1 = str1.split('.') ;
	var arr2 = str2.split('.') ;
	balanceLen(arr1,arr2) ;//统一长度
	for(var i = 0 ; i < arr1.length ; i++){
		var a1 = parseInt(arr1[i]) ;
		var a2 = parseInt(arr2[i]) ;
		if(a1 > a2){
			return false ;
		}if(a1 == a2){
			continue ;
		}else{
			return true ;
		}
	}
}

//统一长度
function  balanceLen(arr1,arr2){
	//debugger ;
	var len = arr1.length>=arr2.length?arr1.length-arr2.length:arr2.length-arr1.length ;
	if(arr1.length >= arr2.length){
		for(var i = 0 ; i <  len  ; i ++){
			arr2.push('0') ;
		}
	}else{
		for(var i = 0 ; i < len ; i ++){
			arr1.push('0') ;
		}
	}
}