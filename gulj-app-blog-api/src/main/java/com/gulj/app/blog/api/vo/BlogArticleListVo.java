package com.gulj.app.blog.api.vo;

import com.gulj.app.blog.api.entity.BlogArticle;
import lombok.Data;

/**
 * @author gulj
 * @create 2017-05-15 下午4:26
 **/
@Data
public class BlogArticleListVo extends BlogArticle {

    private Integer stand;//标准分数

    private Integer categoryId;//分类id

    private String url;//分类url

    private String categoryName;//分类名称

}
