package com.gulj.app.blog.api.service;

import com.gulj.app.blog.api.entity.BlogCategory;
import com.gulj.app.blog.api.vo.BlogCategoryVo;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-14 下午4:02
 **/
public interface BlogCategoryService {


    /**
     * 获取一级分类
     *
     * @return
     */
    List<BlogCategory> queryRootBlogCategory();

    /**
     * 根据父节点获取对应的子节点分类
     *
     * @param parentCategoryId
     * @return
     */
    List<BlogCategory> querySubBlogCategory(long parentCategoryId);

    /**
     * 获取分类列表
     *
     * @return
     */
    List<BlogCategoryVo> list();


}
