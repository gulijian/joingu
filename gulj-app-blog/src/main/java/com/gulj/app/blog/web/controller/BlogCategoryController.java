package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.service.BlogCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gulj
 * @create 2017-05-14 下午4:37
 **/
@Controller
@RequestMapping("/category")
public class BlogCategoryController {


    @Reference(version = "1.0.0")
    private BlogCategoryService blogCategoryService;



}
