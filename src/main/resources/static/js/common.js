$(function() {
    var currentPageNum;
    var pathName = window.location.pathname;
    switch(pathName){
        case "/index.html":
            currentPageNum = 0;
            break;
        case  "/about.html":
            currentPageNum = 1;
            break;
        case  "/technology.html":
            currentPageNum = 2;
            break;
        case  "/writeArticle.html":
            currentPageNum = 3;
            break;
        case "/time.html":
            currentPageNum = 4;
            break;
        case  "/comment.html":
            currentPageNum = 5;
            break;
    }
    setTimeout(function() {
        var ali = $("#starlist li");
        for (i = 0; i < ali.length; i++) {
            ali[i].className = "";
        };
        ali[currentPageNum].className = "selected";
    }, 50);

});