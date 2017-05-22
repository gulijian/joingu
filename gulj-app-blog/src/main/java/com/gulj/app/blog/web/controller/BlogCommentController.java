package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.service.BlogCommentService;
import com.gulj.app.blog.api.vo.BlogCommentVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * @param articleId
     * @return
     */
    @GetMapping("/queryCommentListByArticleId")
    @ResponseBody
    public List<BlogCommentVo> queryCommentListByArticleId(@RequestParam Integer articleId) {
        return blogCommentService.queryCommentListByArticleId(articleId);
    }


}
