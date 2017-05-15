package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.entity.BlogArticle;
import com.gulj.app.blog.api.service.BlogArticleService;
import com.gulj.app.blog.api.service.BlogCategoryService;
import com.gulj.app.blog.api.vo.BlogCategoryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author gulj
 * @create 2017-05-14 下午3:14
 **/
@Controller
public class BlogIndexController {

    @Reference(version = "1.0.0")
    private BlogCategoryService blogCategoryService;

    @Reference(version = "1.0.0")
    private BlogArticleService blogArticleService;

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        //分类列表
        List<BlogCategoryVo> blogCategoryVoList = (List<BlogCategoryVo>) session.getAttribute("blogCategoryVoList");
        if (null == blogCategoryVoList) {
            blogCategoryVoList = blogCategoryService.list();
            session.setAttribute("blogCategoryVoList", blogCategoryVoList);
        }
        //文章列表
        List<BlogArticle> blogArticleList = blogArticleService.queryList();
        mv.addObject("blogArticleList",blogArticleList);
        mv.setViewName("views/index");
        return mv;
    }


}
