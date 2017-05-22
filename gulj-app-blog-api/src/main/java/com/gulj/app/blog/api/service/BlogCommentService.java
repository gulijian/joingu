package com.gulj.app.blog.api.service;

import com.gulj.app.blog.api.vo.BlogCommentVo;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-19 下午2:42
 **/
public interface BlogCommentService {


    /**
     * 根据文章查询文章的所有评论以及回复
     *
     * @param articleId
     * @return
     */
    List<BlogCommentVo> queryCommentListByArticleId(Integer articleId);

}
