package com.gulj.app.blog.api.vo;

import com.gulj.app.blog.api.entity.BlogComment;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-19 下午2:46
 **/
public class BlogCommentVo extends BlogComment {

    private String fromUserName;//文章评论人


    private List<BlogReplyVo> blogReplyVoList;//回复列表


    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public List<BlogReplyVo> getBlogReplyVoList() {
        return blogReplyVoList;
    }

    public void setBlogReplyVoList(List<BlogReplyVo> blogReplyVoList) {
        this.blogReplyVoList = blogReplyVoList;
    }
}
