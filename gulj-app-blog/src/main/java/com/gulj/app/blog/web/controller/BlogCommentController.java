package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gulj.app.blog.api.bo.BusinessParamBo;
import com.gulj.app.blog.api.bo.PageParamBo;
import com.gulj.app.blog.api.service.BlogCommentService;
import com.gulj.app.blog.api.vo.BlogCommentVo;
import com.gulj.app.blog.api.vo.JoinGuPageVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-19 下午5:20
 **/
@Controller
@RequestMapping("/commemt")
public class BlogCommentController {


    @Reference(version = "1.0.0")
    private BlogCommentService blogCommentService;


    /**
     * 根据文章查询文章的所有评论以及回复
     *
     * @param businessParamBo
     * @param pageParamBo
     * @return
     */
    @PostMapping("/queryCommentListByArticleIdPages")
    @ResponseBody
    public JoinGuPageVo queryCommentListByArticleIdPages(BusinessParamBo businessParamBo, PageParamBo pageParamBo) {
        PageInfo<BlogCommentVo> list = blogCommentService.queryCommentListByArticleIdPages(businessParamBo, pageParamBo);
        if (null != list) {
            JoinGuPageVo joinGuPageVo = new JoinGuPageVo();
            joinGuPageVo.setPage(list.getPageNum());
            joinGuPageVo.setTotal(list.getTotal());
            joinGuPageVo.setTotalPage(list.getPages());
            List<BlogCommentVo> appUserLst = list.getList();
            joinGuPageVo.setRows(appUserLst);
            return joinGuPageVo;
        }
        return null;
    }


}
