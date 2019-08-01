package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlController {


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


    @GetMapping("/")
    public String getIndex_1() {
        return "index";
    }

    //首页
    @GetMapping("index")
    public String getIndex() {
        return "index";
    }

    //关于
    @GetMapping("about")
    public String getAbout() {
        return "about";
    }

    //文章
    @GetMapping("article")
    public String getArticle() {
        return "article";
    }

    //文件详情
    @GetMapping("article_detail")
    public String getArticle_detail() {
        return "article_detail";
    }

    //留言
    @GetMapping("comment")
    public String getComment() {
        return "comment";
    }

    //
    @GetMapping("moodList")
    public String getMoodList() {
        return "moodList";
    }

    //header
    @GetMapping("header")
    public String getHeader() {
        return "header";
    }

    //footer
    @GetMapping("footer")
    public String getFooter() {
        return "footer";
    }

    //messageInput
    @GetMapping("messageInput")
    public String getMessageInput() {
        return "messageInput";
    }

    //时间轴
    @GetMapping("time")
    public String getTime() {
        return "time";
    }

    //时间轴
    @GetMapping("edit")
    public String getEdit() {
        return "edit";
    }

    //测试
    @GetMapping("writeArticle")
    public String getTest() {
        return "writeArticle";
    }

    //测试
    @GetMapping("main")
    public String getMain() {
        return "main";
    }

    //测试
    @GetMapping("index2")
    public String getIndex2() {
        return "index2";
    }

}
