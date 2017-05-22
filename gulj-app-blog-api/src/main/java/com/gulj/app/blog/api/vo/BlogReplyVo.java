package com.gulj.app.blog.api.vo;

import com.gulj.app.blog.api.entity.BlogReply;

/**
 * @author gulj
 * @create 2017-05-19 下午2:58
 **/
public class BlogReplyVo extends BlogReply {


    private String fromUserName;
    private String toUserName;


    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
}
