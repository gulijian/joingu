package com.gulj.app.blog.api.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "blog_comment")
public class BlogComment implements Serializable {
    @Id
    private Integer id;

    /**
     * 文章主键
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 评论用户id
     */
    @Column(name = "from_uid")
    private Integer fromUid;

    /**
     * 评论的点赞数
     */
    private Integer hit;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 评论内容
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
     * 获取文章主键
     *
     * @return article_id - 文章主键
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置文章主键
     *
     * @param articleId 文章主键
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取评论用户id
     *
     * @return from_uid - 评论用户id
     */
    public Integer getFromUid() {
        return fromUid;
    }

    /**
     * 设置评论用户id
     *
     * @param fromUid 评论用户id
     */
    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    /**
     * 获取评论的点赞数
     *
     * @return hit - 评论的点赞数
     */
    public Integer getHit() {
        return hit;
    }

    /**
     * 设置评论的点赞数
     *
     * @param hit 评论的点赞数
     */
    public void setHit(Integer hit) {
        this.hit = hit;
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
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}