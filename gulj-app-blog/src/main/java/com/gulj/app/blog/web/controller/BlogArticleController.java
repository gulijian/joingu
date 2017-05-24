package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gulj.app.blog.api.bo.BusinessParamBo;
import com.gulj.app.blog.api.bo.PageParamBo;
import com.gulj.app.blog.api.entity.BlogArticle;
import com.gulj.app.blog.api.service.BlogArticleService;
import com.gulj.app.blog.api.service.BlogCommentService;
import com.gulj.app.blog.api.vo.BlogArticleListVo;
import com.gulj.app.blog.api.vo.BlogCommentVo;
import com.gulj.app.blog.api.vo.JoinGuPageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private Logger logger = LoggerFactory.getLogger(BlogArticleController.class);


    @Reference(version = "1.0.0", timeout = 1200000)
    private BlogArticleService articleService;

    @Reference(version = "1.0.0", timeout = 1200000)
    private BlogCommentService blogCommentService;


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
        BusinessParamBo businessParamBo = new BusinessParamBo();
        businessParamBo.setArticleId(articleId);
        PageInfo<BlogCommentVo> list = blogCommentService.queryCommentListByArticleIdPages(businessParamBo, new PageParamBo());
        JoinGuPageVo joinGuPageVo = null;
        if (null != list) {
            joinGuPageVo = new JoinGuPageVo();
            joinGuPageVo.setPage(list.getPageNum());
            joinGuPageVo.setTotal(list.getTotal());
            joinGuPageVo.setTotalPage(list.getPages());
            List<BlogCommentVo> appUserLst = list.getList();
            joinGuPageVo.setRows(appUserLst);
        }
        mv.setViewName("views/detail");
        mv.addObject("commetReplyPageVo",joinGuPageVo);
        logger.info(""+articleId);
        return mv;
    }


}
