package com.gulj.app.blog.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gulj.app.blog.api.entity.BlogArticle;
import com.gulj.app.blog.api.service.BlogArticleService;
import com.gulj.app.blog.biz.mapper.BlogArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 文章dubbo服务层实现
 *
 * @author gulj
 * @create 2017-04-30 下午3:08
 **/
@Service(version = "1.0.0")
public class BlogArticleServiceImpl implements BlogArticleService {


    @Autowired
    private BlogArticleMapper mapper;

    @Override
    public BlogArticle getById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BlogArticle> queryList() {
        return mapper.selectAll();
    }
}
