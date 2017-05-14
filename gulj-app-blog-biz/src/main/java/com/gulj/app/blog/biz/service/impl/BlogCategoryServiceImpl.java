package com.gulj.app.blog.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gulj.app.blog.api.entity.BlogCategory;
import com.gulj.app.blog.api.service.BlogCategoryService;
import com.gulj.app.blog.api.vo.BlogCategoryVo;
import com.gulj.app.blog.biz.mapper.BlogCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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


    public List<BlogCategoryVo> list() {
        BlogCategoryVo blogCategoryVo = null;
        List<BlogCategoryVo> blogCategoryVoList = null;
        List<BlogCategory> blogCategoryList = queryRootBlogCategory();
        if (null != blogCategoryList && blogCategoryList.size() > 0) {
            blogCategoryVoList = new ArrayList<>(blogCategoryList.size());
            for (int i = 0; i < blogCategoryList.size(); i++) {
                blogCategoryVo = new BlogCategoryVo();
                blogCategoryVo.setId(blogCategoryList.get(i).getId());
                blogCategoryVo.setName(blogCategoryList.get(i).getName());
                blogCategoryVo.setUrl(blogCategoryList.get(i).getUrl());
                blogCategoryVo.setParentId(blogCategoryList.get(i).getParentId());
                blogCategoryVo.setSort(blogCategoryList.get(i).getSort());
                blogCategoryVo.setIsParent(blogCategoryList.get(i).getIsParent());
                blogCategoryVo.setIsShow(blogCategoryList.get(i).getIsShow());
                blogCategoryVo.setIsDelete(blogCategoryList.get(i).getIsDelete());
                blogCategoryVo.setCreateTime(blogCategoryList.get(i).getCreateTime());
                blogCategoryVo.setUpdateTime(blogCategoryList.get(i).getUpdateTime());
                blogCategoryVoList.add(blogCategoryVo);
            }
            for (int j = 0; j < blogCategoryVoList.size(); j++) {
                List<BlogCategory> blogSubCategoryList = querySubBlogCategory(blogCategoryVoList.get(j).getId());
                blogCategoryVoList.get(j).setSubBlogCategory(blogSubCategoryList);
            }
        }
        return blogCategoryVoList;
    }


}
