var $backToTopEle = $('<a href="javascript:void(0)" class="Hui-iconfont toTop" title="返回顶部" alt="返回顶部" style="display:none">^^</a>').appendTo($("body")).click(function () {
    $("html, body").animate({scrollTop: 0}, 120);
});
var backToTopFun = function () {
    var st = $(document).scrollTop(), winh = $(window).height();
    (st > 0) ? $backToTopEle.show() : $backToTopEle.hide();
    /*IE6下的定位*/
    if (!window.XMLHttpRequest) {
        $backToTopEle.css("top", st + winh - 166);
    }
};
$(function () {
    $(window).on("scroll", backToTopFun);
    backToTopFun();

    /*导入头部和尾部*/
    $("#header").load("header");
    $("#footer").load("footer");

    //这里写时间到后执行的代码
      setTimeout(function(){
    var ali = $("#starlist li");
    $("#starlist li").click(function () {
        for (i = 0; i < ali.length; i++) {
            ali[i].className = ""
        };
        this.className = "selected";
    });
     }, 1200);
});