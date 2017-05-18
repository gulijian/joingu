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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author gulj
 * @create 2017-04-30 下午3:10
 **/
@RestController
@RequestMapping("/article")
public class BlogArticleController {


    @Reference(version = "1.0.0", timeout = 1200000)
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
        PageInfo<BlogArticleListVo> list = articleService.listPageIndex(businessParamBo, pageParamBo);
        if (null != list) {
            JoinGuPageVo joinGuPageVo = new JoinGuPageVo();
            joinGuPageVo.setPage(list.getPageNum());
            joinGuPageVo.setTotal(list.getTotal());
            joinGuPageVo.setTotalPage(list.getPages());
            List<BlogArticleListVo> appUserLst = list.getList();
            joinGuPageVo.setRows(appUserLst);
            return joinGuPageVo;
        }
        return null;
    }


    /**
     * 文章详情
     *
     * @param articleId
     * @return
     */
    @GetMapping("/{articleId}.html")
    @ResponseBody
    public ModelAndView detail(@PathVariable Integer articleId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/detail");
        System.out.println(articleId);
        return mv;
    }


}
