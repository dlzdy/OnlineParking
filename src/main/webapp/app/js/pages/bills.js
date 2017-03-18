/**
 * Created by RuiXue on 2015/12/14.
 */
$(function () {
    /**
     * tab菜单
     */
    $.navMini();
    $("#bills-histroy").click(function () {
        $(".remind-box").removeClass("active");
    });
    /**
     * 点击提醒设置
     */
    $("#takeUp,#btn_cancel,#btn_ok").click(function () {
        $.activeToggle(".remind-box")
    });
    //删除影响菜单固顶的Bug
    setTimeout(function () {
        $(".bills").removeClass("page-moveFromLeft");
    }, 1000)

})


