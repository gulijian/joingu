package com.gulj.app.blog.api.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "blog_article")
public class BlogArticle implements Serializable {
    @Id
    private Integer id;

    /**
     * 博客创建者外键
     */
    @Column(name = "sys_user_id")
    private Integer sysUserId;

    /**
     * 文章分类Id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 点赞数
     */
    private Long love;

    /**
     * 热度(浏览数)
     */
    private Long hot;

    /**
     * 评论总数
     */
    private Long comment;

    /**
     * 是否推荐(0:不是,1:是)
     */
    @Column(name = "is_recommed")
    private Byte isRecommed;

    /**
     * 是否显示(1.显示，0.不显示)
     */
    @Column(name = "is_show")
    private Boolean isShow;

    /**
     * 是否删除(1.是，0.否)
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 文章内容
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
     * 获取博客创建者外键
     *
     * @return sys_user_id - 博客创建者外键
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置博客创建者外键
     *
     * @param sysUserId 博客创建者外键
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取文章分类Id
     *
     * @return category_id - 文章分类Id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置文章分类Id
     *
     * @param categoryId 文章分类Id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取封面
     *
     * @return cover - 封面
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面
     *
     * @param cover 封面
     */
    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    /**
     * 获取点赞数
     *
     * @return love - 点赞数
     */
    public Long getLove() {
        return love;
    }

    /**
     * 设置点赞数
     *
     * @param love 点赞数
     */
    public void setLove(Long love) {
        this.love = love;
    }

    /**
     * 获取热度(浏览数)
     *
     * @return hot - 热度(浏览数)
     */
    public Long getHot() {
        return hot;
    }

    /**
     * 设置热度(浏览数)
     *
     * @param hot 热度(浏览数)
     */
    public void setHot(Long hot) {
        this.hot = hot;
    }

    /**
     * 获取评论总数
     *
     * @return comment - 评论总数
     */
    public Long getComment() {
        return comment;
    }

    /**
     * 设置评论总数
     *
     * @param comment 评论总数
     */
    public void setComment(Long comment) {
        this.comment = comment;
    }

    /**
     * 获取是否推荐(0:不是,1:是)
     *
     * @return is_recommed - 是否推荐(0:不是,1:是)
     */
    public Byte getIsRecommed() {
        return isRecommed;
    }

    /**
     * 设置是否推荐(0:不是,1:是)
     *
     * @param isRecommed 是否推荐(0:不是,1:是)
     */
    public void setIsRecommed(Byte isRecommed) {
        this.isRecommed = isRecommed;
    }

    /**
     * 获取是否显示(1.显示，0.不显示)
     *
     * @return is_show - 是否显示(1.显示，0.不显示)
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示(1.显示，0.不显示)
     *
     * @param isShow 是否显示(1.显示，0.不显示)
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取是否删除(1.是，0.否)
     *
     * @return is_delete - 是否删除(1.是，0.否)
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除(1.是，0.否)
     *
     * @param isDelete 是否删除(1.是，0.否)
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}