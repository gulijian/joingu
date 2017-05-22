package com.gulj.app.blog.api.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "blog_reply")
public class BlogReply implements Serializable {
    @Id
    private Integer id;

    /**
     * 评论id
     */
    @Column(name = "comment_id")
    private Integer commentId;

    /**
     * 回复目标id
     */
    @Column(name = "reply_id")
    private Integer replyId;

    /**
     * 回复类型(1.comment针对评论进行回复，2.reply针对回复进行回复)
     */
    @Column(name = "reply_type")
    private Byte replyType;

    /**
     * 回复目标id
     */
    @Column(name = "from_uid")
    private Integer fromUid;

    /**
     * 目标用户id
     */
    @Column(name = "to_uid")
    private Integer toUid;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 回复内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取评论id
     *
     * @return comment_id - 评论id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置评论id
     *
     * @param commentId 评论id
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取回复目标id
     *
     * @return reply_id - 回复目标id
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * 设置回复目标id
     *
     * @param replyId 回复目标id
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    /**
     * 获取回复类型(1.comment针对评论进行回复，2.reply针对回复进行回复)
     *
     * @return reply_type - 回复类型(1.comment针对评论进行回复，2.reply针对回复进行回复)
     */
    public Byte getReplyType() {
        return replyType;
    }

    /**
     * 设置回复类型(1.comment针对评论进行回复，2.reply针对回复进行回复)
     *
     * @param replyType 回复类型(1.comment针对评论进行回复，2.reply针对回复进行回复)
     */
    public void setReplyType(Byte replyType) {
        this.replyType = replyType;
    }

    /**
     * 获取回复目标id
     *
     * @return from_uid - 回复目标id
     */
    public Integer getFromUid() {
        return fromUid;
    }

    /**
     * 设置回复目标id
     *
     * @param fromUid 回复目标id
     */
    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    /**
     * 获取目标用户id
     *
     * @return to_uid - 目标用户id
     */
    public Integer getToUid() {
        return toUid;
    }

    /**
     * 设置目标用户id
     *
     * @param toUid 目标用户id
     */
    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取回复内容
     *
     * @return content - 回复内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置回复内容
     *
     * @param content 回复内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}