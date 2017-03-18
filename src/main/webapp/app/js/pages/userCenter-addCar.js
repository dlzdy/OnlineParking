/**
 * Created by RuiXue on 2016/1/6.
 */
/**
 * 模拟支付宝的密码输入形式
 */

$(function () {
    //当前激活index
    var activeIndex = -1,
        $inputs = $('#inputBox input');

    $inputs.addClass('empty_input');
    
    $inputs.on('click', function () {
        var $this = $(this);
        if ($this.hasClass('empty_input')) {
            $inputs.each(function () {
                if ($.trim($(this).val()) == "") // 判断value值是否为空
                    $(this).addClass('empty_input');
            });
            $(".empty_input:first").select();
        }
        else {
            $this.select();
        }
    });

    var ok = 0 ;
    $inputs.on('keyup', function () {
        var $this = $(this);
        $this.removeClass('empty_input');
        activeIndex = $this.index() + 1 >= $inputs.length ? $this.index() : $this.index() + 1;
        $inputs[activeIndex].select();
        console.log(activeIndex+'  '+$inputs.length);
        
        var reg =/^([a-z]|[A-Z]|[0-9]){1}$/ ;
    	var target = $("#btnSaveCarNo"); 
        var str = $this.val() ;
        if(str == "" || !reg.test(str)){
        	if(!target.hasClass("disabled")){ 
        		target.addClass("disabled"); 
     		}
    		return false ;
        }
        
        
        var reg = /^([a-z]|[A-Z]|[0-9]){1}$/;
        var target = $("#btnSaveCarNo");
        var str = $this.val();
        //console.log("reg.test(str):"+reg.test(str)) ;
        (str != "" && reg.test(str)) && (ok+=1) || (ok-=1);
        (ok >= 5) && target.removeClass("disabled") || target.addClass("disabled")
        
        
        //遍历inputBox 下的input，获取每个input中的value（不为空，每格一位，数字或字母） -- begin
      /*  var reg =/^([a-z]|[A-Z]|[0-9]){1}$/ ;
    	var target = $("#btnSaveCarNo"); 
        $("#inputBox input").each(function() {
        	var str =  $(this).val() ;
        	//console.log("reg.test(str):"+reg.test(str)) ;
        	if(str == "" || !reg.test(str)){ //如果为空，或者不符合格式 
        		if(!target.hasClass("disabled")){
        			target.addClass("disabled"); 
        		}
        		return false ;
        	}
        	
        	if(target.hasClass("disabled")){ 
    	 		target.removeClass("disabled"); 
    		}
        	
        });*/
        //遍历inputBox 下的input，并获取每个input中的value -- end 
        
    });
    
    
    //点击保存按钮  与ios端交互
	$("#btnSaveCarNo").click(function(e){
		connectWebViewJavascriptBridge(function(bridge) {
		  e.preventDefault() ;
		  var result = getSaveResult() ;
          bridge.send(result, function(responseData) {})
       } )
	})
	
	//获取车牌号
	function getSaveResult(){
			var result = "" ;
			var clientUserCarNo = $("#carNo").html() ;
			$div = $('#inputBox').children('div');
			$div.each(
				function(){
				//这里可以对每一个div进行操作
					clientUserCarNo += $(this).text();
				}
			);
			
			console.log("clientUserCarNo:"+clientUserCarNo) ;
			$.ajax({
				type:'get',
				async: false, //是否为当前的请求触发全局AJAX事件处理函数  
				url:'data/hasCarNo.json' ,
				//url:'/OnlineParking/rest/hasUserCarNo?clientUserCarNo='+clientUserCarNo ,
														/*clientUserSecurity=1'//+clientUserSecurity
														+'&clientUserId=2'//+clientUserId
														+'&clientUserCarPosition=3'//+clientUserCarPosition
														+'&clientUserCarNo='+clientUserCarNo,*/
				success:function(data){
					if(data.result=="1"){
						$.ajax({
							type:'get',
							async: false, //是否为当前的请求触发全局AJAX事件处理函数  
							url:'data/addCarResult.json' ,
							success:function(data){
								result = data ;
							}
						}) ;
					}else{
						result = data ;
					}
				}
			}) ;
			return result ;
	}

    
});










