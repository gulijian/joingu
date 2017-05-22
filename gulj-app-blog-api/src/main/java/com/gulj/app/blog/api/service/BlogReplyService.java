package com.gulj.app.blog.api.service;

import com.gulj.app.blog.api.vo.BlogReplyVo;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-19 下午2:42
 **/
public interface BlogReplyService {

    /**
     * 查询评论下的所有回复
     *
     * @param commentId
     * @return
     */
    List<BlogReplyVo> queryReplyListByCommentId(Integer commentId);
}
