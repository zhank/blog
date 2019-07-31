package cn.service.impl;

import cn.dao.ArticleDao;
import cn.entity.TbArticle;
import cn.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章业务层
 */
@Service
public class IArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public int insertArticle(TbArticle tbArticle) {
        return articleDao.insertArticle(tbArticle);
    }
}
