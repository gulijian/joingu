package com.gulj.app.blog.biz.mapper;

import com.gulj.app.blog.api.entity.BlogReply;
import com.gulj.app.blog.api.vo.BlogReplyVo;
import com.gulj.app.blog.biz.JoinGuMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogReplyMapper extends JoinGuMapper<BlogReply> {

    /**
     * 查询评论下的所有回复
     *
     * @param commentId
     * @return
     */
    List<BlogReplyVo> queryReplyListByCommentId(@Param("commentId") Integer commentId);
}