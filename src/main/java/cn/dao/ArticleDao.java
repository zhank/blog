package cn.dao;

import cn.entity.TbArticle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

/**
 * 文章管理数据访问层
 */
@Repository
public interface ArticleDao {


    @SelectKey(keyProperty = "articleId",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
    @Options(keyProperty = "articleId", useGeneratedKeys = true)
    @Insert("insert into tb_article (article_id, article_title, article_userId, reading_num, like_num, collect_num, article_content" +
            ", keywordIds, article_create, article_update) values(#{articleId}, #{articleTitle}, #{articleUserId}, #{likeNum}, #{readingNum}, #{collectNum}, #{articleContent}," +
            "#{keywordIds}, #{articleCreate}, #{articleUpdate})")
    public int insertArticle(TbArticle tbArticle);

}
