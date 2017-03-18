/**
 * Created by RuiXue on 2015/12/17.
 */
$(function () {
    var currYear = (new Date()).getFullYear();
    var opt = {};
    opt.date = {preset: 'date'};
    //opt.datetime = { preset : 'datetime', minDate: new Date(2012,3,10,9,22), maxDate: new Date(2014,7,30,15,44), stepMinute: 5  };
    opt.datetime = {preset: 'datetime'};
    opt.time = {preset: 'time'};
    opt.default = {
        theme: 'android-ics light', //皮肤样式
        display: 'modal', //显示方式
        mode: 'scroller', //日期选择模式
        lang: 'zh',
        dateFormat: 'yy年mm月dd日', //返回结果格式化为年月格式
        dateOrder:'yymmdd' , //日期顺序
        startYear: currYear - 100, //开始年份
        endYear: currYear + 10, //结束年份
        maxDate:new Date()
    };

    $("#appDate").val('').scroller('destroy').scroller($.extend(opt['date'], opt['default']));
    //控制弹窗位置
    $('.modal').on('show.bs.modal', function () {
        $(".userCenter-userInfo").height($(window).height());
        $(this).css({
            'top': '50%',
            'margin-top': function () {
                var modalHeight = $(window).height();
                //console.log(modalHeight);
                return -(modalHeight / 2 - 200);
            }
        });
    });

    //选择性别
    $('#chooseSex :radio').on('ifChecked', function(){
        $("#appSex").text($(this).parents(".radio-group-item").text());
        $("#chooseSex").modal("hide");
        $(this).parents(".radio-group-item").click();
    });

    //返回
    $('.icon-back').on('click',function(){
        client.goback();
    });

    /*//邮箱验证
    $("#appEmail").blur(function () {
        var $this=$(this),
            thisVal = $this.val();
        if(thisVal=="") return;
        var reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        !reg.test(thisVal)? alert("请检查邮箱格式"):null;
    });*/


	//第一次进入选择框 默认选中
 	$("#selectSex").on('click',function(){
 		var sex =$("#appSex").text().trim() ;
 		if(sex=='女'){
 			$('#womenInput').iCheck('check');
 		}else{
 			$('#manInput').iCheck('check');
 		}
 	})

});