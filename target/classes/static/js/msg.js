var get = {
    byId: function (id) {
        return typeof id === "string" ? document.getElementById(id) : id
    },
    byClass: function (sClass, oParent) {
        var aClass = [];
        var reClass = new RegExp("(^| )" + sClass + "( |$)");
        var aElem = this.byTagName("*", oParent);
        for (var i = 0; i < aElem.length; i++) reClass.test(aElem[i].className) && aClass.push(aElem[i]);
        return aClass
    },
    byTagName: function (elem, obj) {
        return (obj || document).getElementsByTagName(elem)
    }
};

// 可输入字数监听
$("#txaArticle").keyup(function () {
    if ($("#txaArticle").val().length > 140) {
        $("#txaArticle").val($("#txaArticle").val().substring(0, 140));
    }
    $(".maxNum").text(140 - $("#txaArticle").val().length);
});

var aImg = $("#face img");

//人物图标点击事件
$("#face img").click(function () {
    for (i = 0; i < aImg.length; i++) {
        aImg[i].className = ""
    }
    ;
    this.className = "current";
});

//格式化时间, 如果为一位数时补0
function format(str) {
    return str.toString().replace(/^(\d)$/, "0$1")
}

function getMsgCount() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: '/msg/getMsgCount',
        contentType: "application/json",
        success: function(result) {
            if (result.code == 200) {
                var totalRecord = result.data;
                var totalPage  = Math.ceil(totalRecord/ 10);


                var element = $('#pageUl');
                var options = {
                    bootstrapMajorVersion:3, //bootstrap的版本要求
                    currentPage: 1,          //设置当前页
                    numberOfPages: totalPage,		 //设置可以点击到的页数范围
                    totalPages:totalPage,           //设置总页数
                    //          numberOfPages:5        //一页列出多少数据
                    onPageClicked:function(event, originalEvent, type, page) {
                        initMessage(page);
                    }
                }
                element.bootstrapPaginator(options);

                $("#msgCount").text(result.data);
            }
        }
    });
}



function sendMsg() {
    var oLi = $("#comments .list li");
    var oList = get.byClass("list")[0];
    var oUl = get.byTagName("ul", oList)[0];
    var aLi = get.byTagName("li", oList);
    var msgDate = new Date();
    var userName = $("#msgBox #inpName").val();
    var msgContent = $("#txaArticle").val().replace('<br/>', '/n');
    var headUrl = get.byClass("current", get.byId("face"))[0].src
    oLi = document.createElement("li");
    oLi.innerHTML = "<div class=\"userPic\"><img src=\"" + headUrl + "\"></div>\
							 <div class=\"content\">\
							 	<div class=\"userName\"><a href=\"javascript:;\">" + userName + "</a>:</div>\
								<div class=\"msgInfo\">" + msgContent + "</div>\
								<div class=\"times\"><span>" + format(msgDate.getMonth() + 1) + "\u6708" + format(msgDate.getDate()) + "\u65e5 " + format(msgDate.getHours()) + ":" + format(msgDate.getMinutes()) + "</span><a class=\"del\" href=\"javascript:;\">\u5220\u9664</a></div>\
							 </div>";
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/msg/addMsg',
        contentType: "application/json",
        data: JSON.stringify({"userName": userName, "msgContent": msgContent, "msgDate": msgDate, "headUrl":headUrl}),
        success: function (result) {
            if (result.code == 200) {
                //插入元素    创建元素
                aLi.length ? oUl.insertBefore(oLi, aLi[0]) : oUl.appendChild(oLi);
                getMsgCount();
            } else {
                alert("system error, please wait for moment!")
            }
        }
    });
}

//初始化留言板数据
function initMessage(pageNum) {
    if(pageNum == undefined || pageNum == "") {
        pageNum = 1;
    } else {
        $('#comments .list ul li').remove();
    }
    $.ajax({
        type: "GET",
        url: '/msg/getMsgByPageNum?pageNum=' + pageNum,
        success: function (result) {
            if (result.code == 200) {
                var oLi = $("#comments .list li");
                var oList = get.byClass("list")[0];
                var oUl = get.byTagName("ul", oList)[0];
                var aLi = get.byTagName("li", oList);
                for(var i = 0; i < result.data.length; i++) {
                    var userName = result.data[i].userName;
                    var msgContent = result.data[i].msgContent;
                    var headUrl = result.data[i].headUrl;
                    var msgDate = new Date(result.data[i].msgDate);
                    oLi = document.createElement("li");
                    oLi.innerHTML = "<div class=\"userPic\"><img src=\"" + headUrl + "\"></div>\
							 <div class=\"content\">\
							 	<div class=\"userName\"><a href=\"javascript:;\">" + userName + "</a>:</div>\
								<div class=\"msgInfo\">" + msgContent + "</div>\
								<div class=\"times\"><span>" + format(msgDate.getMonth() + 1) + "\u6708" + format(msgDate.getDate()) + "\u65e5 " + format(msgDate.getHours()) + ":" + format(msgDate.getMinutes()) + "</span><a class=\"del\" href=\"javascript:;\">\u5220\u9664</a></div>\
							 </div>";
                    //插入元素    创建元素
                    aLi.length ? oUl.insertBefore(oLi, aLi[0]) : oUl.appendChild(oLi);
                }
            } else {
                alert("system error, please wait for moment!")
            }
        }
    });
}