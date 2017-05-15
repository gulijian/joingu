package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.entity.BlogArticle;
import com.gulj.app.blog.api.service.BlogArticleService;
import org.springframework.web.bind.annotation.*;

/**
 * @author gulj
 * @create 2017-04-30 下午3:10
 **/
@RestController
@RequestMapping("/article")
public class BlogArticleController {


    @Reference(version = "1.0.0")
    BlogArticleService articleService;


    /**
     * 根据文章id查询指定文章
     * @param id
     * @return
     */
    @GetMapping("/getById")
    @ResponseBody
    public BlogArticle getById(@RequestParam Integer id) {
        return articleService.getById(id);
    }





}
