package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gulj.app.blog.api.bo.BusinessParamBo;
import com.gulj.app.blog.api.bo.PageParamBo;
import com.gulj.app.blog.api.service.BlogArticleService;
import com.gulj.app.blog.api.vo.BlogArticleListVo;
import com.gulj.app.blog.api.vo.JoinGuPageVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author gulj
 * @create 2017-05-18 上午11:20
 **/
@Controller
public class BlogListController {


    @Reference(version = "1.0.0",timeout = 1200000)
    private BlogArticleService blogArticleService;

    @GetMapping("/{moudle}")
    public ModelAndView list(HttpServletRequest request,BusinessParamBo businessParamBo) {
        String page = request.getParameter("page");
        String url = request.getRequestURI();
        ModelAndView mv = new ModelAndView();
        //文章列表
        PageParamBo pageParamBo = new PageParamBo();
        if (!StringUtils.isEmpty(page)) {
            pageParamBo.setPageNumber(Integer.valueOf(page));
        }
        businessParamBo.setUrl(url);
        PageInfo<BlogArticleListVo> list = blogArticleService.listPageIndex(businessParamBo, pageParamBo);
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
        mv.setViewName("views/list");
        return mv;
    }


}
