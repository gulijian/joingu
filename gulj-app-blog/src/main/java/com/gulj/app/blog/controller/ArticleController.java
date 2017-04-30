package com.gulj.app.blog.controller;

import com.gulj.app.blog.api.entity.Article;
import com.gulj.app.blog.api.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gulj
 * @create 2017-04-30 下午3:10
 **/
@RestController("/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;


    @GetMapping("/getById")
    public Article getById(@RequestParam Long id) {
        return articleService.getById(id);
    }


}
