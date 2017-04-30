package com.gulj.app.blog.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gulj.app.blog.api.entity.Article;
import com.gulj.app.blog.api.service.ArticleService;

/**
 * 文章dubbo服务层实现
 *
 * @author gulj
 * @create 2017-04-30 下午3:08
 **/
@Service(version = "1.0.0")
public class ArticleServiceImpl implements ArticleService {


    @Override
    public Article getById(Long id) {
        return new Article("文章标题", "文章内容");
    }

}
