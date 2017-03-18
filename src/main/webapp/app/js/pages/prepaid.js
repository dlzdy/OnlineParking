/**
 * Created by RuiXue on 2015/12/14.
 */
$(function () {
    var $userMoneyInput = $("#userMoneyInput"),
        $moneys = $("#money input"),
        $btns = $("#money :button");
    /**
     * 根据点击赋值
     */
    $("#money input").click(function () {
        var $this = $(this);
        $userMoneyInput.val($this.val());
    });
    /**
     * 监听用户输入数值，用符合条件的数值，激活对应的按钮
     */
    $userMoneyInput.keyup(function () {
        //var thisVal = parseInt($(this).val());
        var thisVal = $(this).val();
        if (thisVal!="") {
            if ((/^(\+|-)?\d+$/.test( thisVal ))) {
                for (var i = 0; i < $moneys.length; i++) {
                    var $temInput = $($moneys[i]);
                    if (thisVal == $temInput.val()) {
                        remoOtherClass();
                        $temInput.addClass("focus");
                        return;
                    } else {
                        remoOtherClass();
                    }
                }
            } else {
                alert("输入错误，请重新输入！");
            }
        }
    });
    /**
     * remOtherClass
     */
    function remoOtherClass() {
        $moneys.removeClass("focus");
    }

    $btns.click(function () {
        $btns.removeClass("focus");
        $(this).addClass("focus");
    });
});