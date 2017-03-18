/**
 * Created by RuiXue on 2015/12/3.
 */
!(function ($) {

    $.extend({
        /**
         * navMini
         */
        navMini: function () {
            $(".nav-mini-li").on("click", function () {
                var $this = $(this),
                    $active_under_line = $(".active-under-line"),
                    liW = $this.width(),
                    liIndex = $this.index(),
                    $nav_mini_content = $(".nav-mini-content");

                $active_under_line.animate({
                    left: liW * liIndex + "px"
                }, {
                    easing: 'easeOutQuart',
                    duration: 300
                })

                $(".nav-mini-li").removeClass("active");
                $this.addClass("active");

                $nav_mini_content.hide();
                $nav_mini_content.eq(liIndex).show();
            });
        },

        /**
         * addActive
         */
        activeToggle: function (obj,setClass, fn) {
            var $obj =getObj(obj),
                classStr=setClass||"active";
            $obj.hasClass(classStr)?$obj.removeClass(classStr):$obj.addClass(classStr);
        }
    });
    /**
     * 自动获取JQuery对象
     * @param {String} obj
     */
    function getObj(obj){
        return $(obj) || $("."+obj) || $("#"+obj);
    }

    /**
     *设置radio父元素影响事件
     */
    $(":radio").parents("li").on("click",function(){
        $(this).find(":radio").iCheck("check");
    });

    /**
     *设置li元素点击事件的页面跳转
     */
    $("li").on("click",function(){
        var href=$(this).attr("href");
        href?window.location=href:null;
    });

    /**
     * 模拟原生APP页面交互
     */
    var $body = $(document.body);
    $body.addClass("page-moveFromLeft");
    /*$(window).on('beforeunload',function(){
        $body.addClass("page-moveToRight");
    });*/
})(jQuery)






