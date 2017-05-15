package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gulj.app.blog.api.bo.BusinessParamBo;
import com.gulj.app.blog.api.bo.PageParamBo;
import com.gulj.app.blog.api.entity.BlogArticle;
import com.gulj.app.blog.api.service.BlogArticleService;
import com.gulj.app.blog.api.vo.BlogArticleListVo;
import com.gulj.app.blog.api.vo.JoinGuPageVo;
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
     *
     * @param id
     * @return
     */
    @GetMapping("/getById")
    @ResponseBody
    public BlogArticle getById(@RequestParam Integer id) {
        return articleService.getById(id);
    }


    /**
     * 分页查询文章列表
     *
     * @param businessParamBo
     * @param pageParamBo
     * @return
     */
    @PostMapping("/listPage")
    @ResponseBody
    public JoinGuPageVo listPage(BusinessParamBo businessParamBo, PageParamBo pageParamBo) {
        PageInfo<BlogArticleListVo> pageInfo = articleService.listPageIndex(businessParamBo, pageParamBo);
        return null;
    }


}
