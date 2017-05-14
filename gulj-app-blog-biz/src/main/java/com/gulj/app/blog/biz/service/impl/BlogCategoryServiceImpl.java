package com.gulj.app.blog.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gulj.app.blog.api.entity.BlogCategory;
import com.gulj.app.blog.api.service.BlogCategoryService;
import com.gulj.app.blog.biz.mapper.BlogCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-14 下午4:11
 **/
@Service(version = "1.0.0")
public class BlogCategoryServiceImpl implements BlogCategoryService {

    @Autowired
    private BlogCategoryMapper mapper;

    @Override
    public List<BlogCategory> queryRootBlogCategory() {
        Example example = new Example(BlogCategory.class);
        example.createCriteria().andEqualTo("isParent", 1)
                .andEqualTo("parentId", 0)
                .andEqualTo("isDelete", 0)
                .andEqualTo("isShow", 1);
        return mapper.selectByExample(example);
    }

    @Override
    public List<BlogCategory> querySubBlogCategory(long parentCategoryId) {
        Example example = new Example(BlogCategory.class);
        example.createCriteria().andEqualTo("isParent", 0)
                .andEqualTo("parentId", parentCategoryId)
                .andEqualTo("isDelete", 0)
                .andEqualTo("isShow", 1);
        return mapper.selectByExample(example);
    }
}
