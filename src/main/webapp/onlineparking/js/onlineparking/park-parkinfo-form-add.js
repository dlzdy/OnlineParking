
 	function check(str)//验证输入的是否是半角, True 没有全角，False有全角
	    {
	        for (var i = 0; i < str.length; i++)
	        {
	            strCode = str.charCodeAt(i);
	            if ((strCode > 65248) || (strCode == 12288))
	            {
	                return false;
	            }
	        }
	        return true;
	    }
		//保存停车场收费表单 
		function save(){
		//	getDatas();
		var uID  = $("#uID").val() ; //uID放在 parking/park/parkinfo_form_add.jsp中<!-- 后台通过电话号码将 用户id取出 -->
		var chargingStandardsManagerId = $("#chargingStandardsManagerId").val() ; //操作人员id
		var chargingStandardsManagerType = $("#chargingStandardsManagerType").val() ; //更改人类型
		var chargingStandardsState = $("#chargingStandardsState").val() ;//可用状态
		var chargingStandardsStepStart = $("#chargingStandardsStepStart").val() ;//起始时间
		var chargingStandardsStepEnd = $("#chargingStandardsStepEnd").val() ;//截止时间
		var chargingStandardsStep = $("#chargingStandardsStep").val() ;//收费阶梯chargingStandardsStep
		var chargingStandardsPrise = $("#chargingStandardsPrise").val() ;//收费标准
		
	    var reg = /^[0-9]\d*$/ ; //不要以零开头的正整数
	   
	    //alert(check(chargingStandardsStepEnd)+":True没有全角") 
		//debugger ;
		   
			 if(chargingStandardsStepStart==""){ //判断 起始时间
				 $("#chargingStandardsStepStart").tips({
						side:1,
			            msg:"请输入 起始时间",
			            bg:'#AE81FF',
			            time:3
			        });
				 return false ;
			}else {
				if(!reg.test(chargingStandardsStepStart)){
					 $("#chargingStandardsStepStart").tips({
							side:1,
				            msg:"请输入非负整数",
				            bg:'#AE81FF',
				            time:3
				        });
					 return false; 
				}
			}
			 
			 
		 if(chargingStandardsStepEnd==""){ //判断 截止时间
			 $("#chargingStandardsStepEnd").tips({
					side:1,
		            msg:"请输入截止时间",
		            bg:'#AE81FF',
		            time:3
		        });
			 return false ;
		}else if(!check(chargingStandardsStepEnd)){//check() True 没有全角，False有全角
			 $("#chargingStandardsStepEnd").tips({
					side:1,
		            msg:"请输入英文半角数字",
		            bg:'#AE81FF',
		            time:3
		        });
			 return false; 
		}else{
			if(!reg.test(chargingStandardsStepEnd)){
				$("#chargingStandardsStepEnd").tips({
					side:1,
		            msg:"请输入非负整数",
		            bg:'#AE81FF',
		            time:3
		        });
			 return false ;
			}
		}
		 
			if(parseInt(chargingStandardsStepStart)>parseInt(chargingStandardsStepEnd)||
					parseInt(chargingStandardsStepStart)==  parseInt(chargingStandardsStepEnd)){
				$("#chargingStandardsStepEnd").tips({
					side:1,
		            msg:"截止时间不可小于起始时间",
		            bg:'#AE81FF',
		            time:3
		        });
				return false ;
			}
		 
		 
			 if(chargingStandardsStep==""){ //判断 收费阶梯
				 $("#chargingStandardsStep").tips({
						side:1,
			            msg:"请输入 收费阶梯",
			            bg:'#AE81FF',
			            time:3
			        });
				 return false ;
			}else{
				if(!reg.test(chargingStandardsStep)){
					$("#chargingStandardsStep").tips({
						side:1,
			            msg:"请输入非负整数",
			            bg:'#AE81FF',
			            time:3
			        });
				 return false ;
				}
			}
				

			 if(chargingStandardsPrise==""){//收费标准
					 $("#chargingStandardsPrise").tips({
							side:1,
				            msg:"请输入收费标准",
				            bg:'#AE81FF',
				            time:3
				        });
					 return false ;
			 }else if(!check(chargingStandardsPrise)){
				 $("#chargingStandardsPrise").tips({
						side:1,
			            msg:"请输入英文半角数字",
			            bg:'#AE81FF',
			            time:3
			        });
				 return false ;
			 }else{
					if(!reg.test(chargingStandardsPrise)){
						$("#chargingStandardsPrise").tips({
							side:1,
				            msg:"请输入非负整数",
				            bg:'#AE81FF',
				            time:3
				        });
					 return false ;
					}
				}
		var jsonstr = {
				"uID":uID ,//通过该参数 在后台获取停车场id --->  parkingInfoId
				"chargingStandardsManagerId":chargingStandardsManagerId,
				 "chargingStandardsManagerType":"2",
				 "chargingStandardsState":"enable",
				 "chargingStandardsPrise":chargingStandardsPrise,
				 "chargingStandardsStepStart":chargingStandardsStepStart,
				 "chargingStandardsStepEnd":chargingStandardsStepEnd,
				 "chargingStandardsStep":chargingStandardsStep}	;
			if(!checkInvalid()){return false} ; //判断session是否失效 
			 $.ajax({
					type: "post",
					url: 'addChangStandards',
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
//							 reSet() ;
							setTimeout(hideF(),2000) ;
							 window.location.href="/OnlineParking/toCostForm?userID="+uID ;
							/*alert(window.parent.getDataList()) ; */
						}else if(data.result=="0"){
							$("#table_report2").tips({
								side:1,
					            msg:data.info,
					            bg:'#AE81FF',
					            time:3
					        });
							return false;
						}else if(data.result=="2"){
							$("#chargingStandardsStep").tips({
								side:1,
					            msg:"阶梯值不可以重复",
					            bg:'#AE81FF',
					            time:3
					        });
							return false;
						}
					}
			});
		}
	function reSet(){
		//$("#chargingStandardsManagerId").val("") ; //操作人员id
		//$("#chargingStandardsManagerType").val("") ; //更改人类型
		//$("#chargingStandardsState").val("可用") ;//可用状态
		$("#chargingStandardsStepStart").val("") ;//起始时间
		$("#chargingStandardsStepEnd").val("") ;//截止时间
		$("#chargingStandardsStep").val("") ;//收费阶梯chargingStandardsStep
		$("#chargingStandardsPrise").val("") ;//收费标准
		
	}
		
	//添加费用标准  点击后添加一行
	//在table表中追加一行 
	 function add_tr(obj) {
	   /* var tr = $(obj).parent().parent();
	    tr.after(tr.clone());*/
		// 取得表格对象
		 var oTable = $("#table_report") ;
		 // 调用table对象的insertRow方法,增加一个新行到表格末尾,并返回新增的tr对象
		 var oTr = oTable.insertRow();
	 }
	
	 
	//隐藏 窗口
	 function hideF(){
	     $("#zhongxin").hide();
	     top.Dialog.close();
	 }  
      
		
		
		
	//-----------------------------停车场--->---表单收费-->添加----------------

		
		//开始是时间和结束时间判断有问题？？？？	
		  //我这里是通过点击 来获取 table中的td的数据，其中一个td包含一个input标签
		/*	function getDatas() { 
				 //来获回去所有行的对象，
				 var arrTR = $("#table_report").children();
				 var str ="";
				 str += "[" ;
				 //遍历行
				 $("#table_report").find("tr").each(function () {
					 //遍历改行的列
					// var startime = "" ;
					 $(this).children("td").each(function(i){
						//debugger ;
						 if(i=="2"){
							// alert(i);[{"key":value},{"key":value}]
							 var idData = $(this).find("select").attr("id");
							 if(idData=="chargingStandardsState"){
									var chargingStandardsState = $("#chargingStandardsState").val() ;//可用状态
									if(chargingStandardsState==""){ //可用状态
										chargingStandardsState = "enable" ;
									}
							 }
							 str += "{,'chargingStandardsState':"+chargingStandardsState ;
						 }else{
							 var idData = $(this).find("input").attr("id");
							 if(idData=="chargingStandardsManagerId"){
								 var chargingStandardsManagerId = $("#chargingStandardsManagerId").val() ; //操作人员id
								 str += "{'chargingStandardsManagerId':"+chargingStandardsManagerId;
							 }
							 if(idData=="chargingStandardsManagerType"){
								 var chargingStandardsManagerType = $("#chargingStandardsManagerType").val() ; //更改人类型
								 str += ",'chargingStandardsManagerType':"+chargingStandardsManagerType ;
							 }
						//	 debugger ;
							
							 if(idData=="chargingStandardsStepStart"){
								 var chargingStandardsStepStart = $("#chargingStandardsStepStart").val() ;//起始时间
								 startime =  chargingStandardsStepStart;
								 if(chargingStandardsStepStart==""){ //判断 起始时间
									 $("#chargingStandardsStepStart").tips({
											side:1,
								            msg:"请输入 起始时间",
								            bg:'#AE81FF',
								            time:3
								        });
									 return false ;
								}
								 str += ",'chargingStandardsStepStart':"+chargingStandardsStepStart ;
							 }
							 if(idData=="chargingStandardsStepEnd"){
								   var chargingStandardsStepStart = $("#chargingStandardsStepStart").val() ;//起始时间
									var chargingStandardsStepEnd = $("#chargingStandardsStepEnd").val() ;//截止时间
									if(chargingStandardsStepEnd==""){ //判断 截止时间
										 $("#chargingStandardsStepEnd").tips({
												side:1,
									            msg:"请输入截止时间",
									            bg:'#AE81FF',
									            time:3
									        });
										 return false ;
									}else{
										if(chargingStandardsStepStart>chargingStandardsStepEnd||chargingStandardsStepStart==chargingStandardsStepEnd){
											$("#chargingStandardsStepEnd").tips({
												side:1,
									            msg:"截止时间不可小于起始时间",
									            bg:'#AE81FF',
									            time:3
									        });
										}
										return false ;
									}
									 str += ",'chargingStandardsStepEnd':"+chargingStandardsStepEnd ;
							 }
							 if(idData=="chargingStandardsStep"){
								 var chargingStandardsStep = $("#chargingStandardsStep").val() ;//收费阶梯
								 if(chargingStandardsStep==""){ //判断 收费阶梯
									 $("#chargingStandardsStep").tips({
											side:1,
								            msg:"请输入 收费阶梯",
								            bg:'#AE81FF',
								            time:3
								        });
									 return false ;
								}
								 str += ",'chargingStandardsStep':"+chargingStandardsStep ;
							 }
							

							 if(idData=="chargingStandardsPrise"){
									var chargingStandardsPrise = $("#chargingStandardsPrise").val() ;//收费标准
									 $("#chargingStandardsPrise").tips({
											side:1,
								            msg:"请输入收费标准",
								            bg:'#AE81FF',
								            time:3
								        });
									 return false ;
							 }
							 str += ",'chargingStandardsPrise':"+chargingStandardsPrise+"}," ;
						 }
						
						  
					   }) ;
				});  //遍历行结束
				 str.substring(0,str.length-1) ;
				 str += "]" ;
				 alert(str) ;
			}*/
			
			
					 //arrtd.eq(0) 来获取行内所有的td
				//	 tdContext = $.trim(arrtd.eq(0).text());
					 
//					 tdContext += ":" + arrtd.eq(2).find("input").val() + ";";
//					     Context += tdContext;
//					  }) ;
//				 	Context= Context.substring(Context.indexOf(";")+1);
//				 	alert(Context) ;
			
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		