package cn.controller;

import cn.constant.ResultMsg;
import cn.entity.TbArticle;
import cn.service.IArticleService;
import cn.util.EmojiCharacterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 文章管理业务层
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private IArticleService IArticleService;

    @PostMapping("publishArticle")
    public ResultMsg publishArticle(@RequestBody TbArticle tbArticle, HttpServletRequest request) {
        ResultMsg resultMsg = new ResultMsg();

        tbArticle.setArticleCreate(new Date());
        tbArticle.setArticleUpdate(new Date());
        tbArticle.setArticleContent(EmojiCharacterUtil.escape(tbArticle.getArticleContent()));
        int flag = IArticleService.insertArticle(tbArticle);
        if(flag == 1) {
            resultMsg.setCode(200);
            resultMsg.setMsg("发布成功");
        } else {
            resultMsg.setCode(-1);
            resultMsg.setMsg("发布失败，请联系管理员！");
        }
        return resultMsg;
    }
}
