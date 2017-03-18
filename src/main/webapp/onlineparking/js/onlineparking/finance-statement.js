//年报搜索
function searchYear(){
	if(!checkInvalid()){return false} ; //判断session是否失效 
	var uID = $("#uID").val() ;
	var year = $("#year").val() ;
	var  month= $("#month").val() ;
	var quarter = $("#quarter").val() ;
	//alert("uID:"+uID) ;
	if(year=="0"){
		$("#year").tips({
			side : 1,
			msg : '请选择年份',
			bg : '#AE81FF',
			time : 3
		});
 	 return false ;
	}
	
	window.location.href  = "/OnlineParking/getYearReportForm?year="+year+"&uID="+uID+"&month="+month+"&quarter="+quarter ;
	/*var jsonstr = {"year":year} ;
	alert("jsonstr:"+jsonstr) ;*/
	/* $.ajax({
		type: "post",
		url: '/OnlineParking/getYearCarsReportForm',
		data:$.toJSON(jsonstr),
		dataType:'json',
		contentType : 'application/json',
		success:function(data){
			if(data.result=="1"){
			}
			alert(data.data) ;
			$("#chartDiv").html(data.data) ;
			var dataXml = "" ;
			dataXml += "<graph caption='每月销售额柱形图' xAxisName='月份' yAxisName='Units' showNames='1' decimalPrecision='0' formatNumberScale='0'>" +
					"<set name='一月' value='462' color='AFD8F8' />" +
					"<set name='二月' value='857' color='F6BD0F' />" +
					"<set name='三月' value='671' color='8BBA00' />" +
					"<set name='四月' value='494' color='FF8E46' />" +
					"<set name='五月' value='761' color='008E8E' />" +
					"<set name='六月' value='960' color='D64646' />" +
					"<set name='七月' value='629' color='8E468E' />" +
					"<set name='八月' value='622' color='588526' />" +
					"<set name='九月' value='376' color='B3AA00' />" +
					"<set name='十月' value='494' color='008ED6' />" +
					"<set name='十一月' value='761' color='9D080D' />" +
					"<set name='十二月' value='960' color='A186BE' /></graph>";
			var myChart2 = new FusionCharts("../../fusioncharts/Area2D.swf","myChartId2", "600","300");
			alert(myChart2);
			myChart2.setDataURL(dataXml);
		    myChart2.render("chartdiv");
			
		}
	}) ;*/
	
}


//季报搜索
function searchQuarter(){
	if(!checkInvalid()){return false} ; //判断session是否失效 
	var uID = $("#uID").val() ;
	var year = $("#year").val() ;
	var  month= $("#month").val() ;
	var quarter = $("#quarter").val() ;
	
	if(year=="0"){
		$("#year").tips({
			side : 1,
			msg : '请选择年份',
			bg : '#AE81FF',
			time : 3
		});
 	 return false ;
	}
	if(quarter=="0"){
		$("#quarter").tips({
			side : 1,
			msg : '请选择季度',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}
	var lastDay = new Date(year,month,0).getDate();
	window.location.href  = "/OnlineParking/getquarterReportForm?year="+year+"&userID="+uID+"&month="+month+"&quarter="+quarter +"&lastDay="+lastDay;
	
	
}


//月报搜索

function searchMonth(){
	if(!checkInvalid()){return false} ; //判断session是否失效 
	var uID = $("#uID").val() ;
	var year = $("#year").val() ;
	var  month= $("#month").val() ;
	var quarter = $("#quarter").val() ;
	if(year=="0"){
		$("#year").tips({
			side : 1,
			msg : '请选择年份',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}
	if(month=="0"){
		$("#month").tips({
			side : 1,
			msg : '请选择年份',
			bg : '#AE81FF',
			time : 3
		});
		return false ;
	}
	
	var lastDay = new Date(year,month,0).getDate();
	window.location.href  = "/OnlineParking/toFinancialStatement?year="+year+"&userID="+uID+"&month="+month+"&quarter="+quarter +"&lastDay="+lastDay;
	
}
