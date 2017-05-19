package com.gulj.app.blog.biz.mapper;

import com.gulj.app.blog.api.entity.BlogComment;
import com.gulj.app.blog.api.vo.BlogCommentVo;
import com.gulj.app.blog.biz.JoinGuMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogCommentMapper extends JoinGuMapper<BlogComment> {

    /**
     * 根据文章id查询文章根评论
     *
     * @param articleId
     * @return
     */
    List<BlogCommentVo> queryCommentListByArticleId(@Param("articleId") Integer articleId);
}