package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gulj.app.blog.api.bo.BusinessParamBo;
import com.gulj.app.blog.api.bo.PageParamBo;
import com.gulj.app.blog.api.service.BlogArticleService;
import com.gulj.app.blog.api.service.BlogCategoryService;
import com.gulj.app.blog.api.vo.BlogArticleListVo;
import com.gulj.app.blog.api.vo.BlogCategoryVo;
import com.gulj.app.blog.api.vo.JoinGuPageVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author gulj
 * @create 2017-05-14 下午3:14
 **/
@Controller
public class BlogIndexController {

    @Reference(version = "1.0.0",timeout = 1200000)
    private BlogCategoryService blogCategoryService;

    @Reference(version = "1.0.0",timeout = 1200000)
    private BlogArticleService blogArticleService;

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session, HttpServletRequest request) {
        String page = request.getParameter("page");
        ModelAndView mv = new ModelAndView();
        //分类列表
        List<BlogCategoryVo> blogCategoryVoList = (List<BlogCategoryVo>) session.getAttribute("blogCategoryVoList");
        if (null == blogCategoryVoList) {
            blogCategoryVoList = blogCategoryService.list();
            session.setAttribute("blogCategoryVoList", blogCategoryVoList);
        }
        //文章列表
        PageParamBo pageParamBo = new PageParamBo();
        if (!StringUtils.isEmpty(page)){
            pageParamBo.setPageNumber(Integer.valueOf(page));
        }
        PageInfo<BlogArticleListVo> list = blogArticleService.listPageIndex(new BusinessParamBo(), pageParamBo);
        JoinGuPageVo joinGuPageVo = null;
        if (null != list) {
            joinGuPageVo = new JoinGuPageVo();
            joinGuPageVo.setPage(list.getPageNum());
            joinGuPageVo.setTotal(list.getTotal());
            joinGuPageVo.setTotalPage(list.getPages());
            List<BlogArticleListVo> appUserLst = list.getList();
            joinGuPageVo.setRows(appUserLst);
        }
        mv.addObject("pageArticleListVo", joinGuPageVo);
        mv.setViewName("views/index");
        return mv;
    }


}
