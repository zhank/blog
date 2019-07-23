package cn.jsoso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {

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
    @GetMapping("modList")
    public String getModList() {
        return "modList";
    }

}
