package com.gulj.app.blog.biz.bo;

import com.gulj.app.blog.api.entity.BlogCategory;

/**
 * @author gulj
 * @create 2017-05-14 下午4:07
 **/
public class BlogCategoryBo extends BlogCategory {


    private BlogCategory subBlogCategory;


    public BlogCategory getSubBlogCategory() {
        return subBlogCategory;
    }

    public void setSubBlogCategory(BlogCategory subBlogCategory) {
        this.subBlogCategory = subBlogCategory;
    }
}
