package cn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 留言版
 */
@Getter
@Setter
public class TbArticle {

    //文章ID
    private String articleId;

    //文章标题
    private String articleTitle;

    //发布者
    private String articleUserId;

    //点赞数
    private int likeNum;

    //阅读数
    private int readingNum;

    //收藏数
    private int collectNum;

    //文章内容
    private String articleContent;

    //文章关键字
    private String keywordIds;

    //留言时间
    private Date articleCreate;

    //修改时间
    private Date articleUpdate;

}
