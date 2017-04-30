package com.gulj.app.blog.api.service;

import com.gulj.app.blog.api.entity.Article;

/**
 * 文章dubbo服务层
 *
 * @author gulj
 * @create 2017-04-30 下午3:07
 **/
public interface ArticleService {

    /**
     * 根据文章id获取文章
     *
     * @param id
     * @return
     */
    Article getById(Long id);

}
