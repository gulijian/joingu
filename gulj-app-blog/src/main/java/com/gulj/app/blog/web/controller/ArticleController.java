package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.entity.Article;
import com.gulj.app.blog.api.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gulj
 * @create 2017-04-30 下午3:10
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {


    @Reference(version = "1.0.0")
    private ArticleService articleService;


    @GetMapping("/getById")
    public Article getById() {
        return articleService.getById(1L);
    }


}
