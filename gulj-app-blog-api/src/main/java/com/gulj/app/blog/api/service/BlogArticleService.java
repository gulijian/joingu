package com.gulj.app.blog.api.service;

import com.gulj.app.blog.api.entity.BlogArticle;

import java.util.List;

/**
 * 文章dubbo服务层
 *
 * @author gulj
 * @create 2017-04-30 下午3:07
 **/
public interface BlogArticleService {

    /**
     * 根据文章id获取文章
     *
     * @param id
     * @return
     */
    BlogArticle getById(Integer id);

    /**
     * 获取文章列表
     * @return
     */
    List<BlogArticle> queryList();

}
