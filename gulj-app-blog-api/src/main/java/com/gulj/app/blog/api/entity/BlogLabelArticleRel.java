package com.gulj.app.blog.api.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "blog_label_article_rel")
public class BlogLabelArticleRel implements Serializable {
    @Id
    private Integer id;

    @Column(name = "label_id")
    private Integer labelId;

    @Column(name = "article_id")
    private Integer articleId;

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
     * @return label_id
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * @param labelId
     */
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    /**
     * @return article_id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}