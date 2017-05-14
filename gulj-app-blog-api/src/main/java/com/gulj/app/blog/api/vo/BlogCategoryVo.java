package com.gulj.app.blog.api.vo;

import com.gulj.app.blog.api.entity.BlogCategory;
import lombok.Data;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-14 下午4:07
 **/
@Data
public class BlogCategoryVo extends BlogCategory {


    private List<BlogCategory> subBlogCategory;


}
