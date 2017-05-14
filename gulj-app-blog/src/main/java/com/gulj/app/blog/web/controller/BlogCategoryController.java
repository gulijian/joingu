package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.entity.BlogCategory;
import com.gulj.app.blog.api.service.BlogCategoryService;
import com.gulj.app.blog.api.vo.BlogCategoryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gulj
 * @create 2017-05-14 下午4:37
 **/
@Controller
@RequestMapping("/category")
public class BlogCategoryController {


    @Reference(version = "1.0.0")
    private BlogCategoryService blogCategoryService;


    /**
     * 查询博客分类列表
     *
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public List<BlogCategoryVo> list() {
        BlogCategoryVo blogCategoryVo = null;
        List<BlogCategoryVo> blogCategoryVoList =null;
        List<BlogCategory> blogCategoryList = blogCategoryService.queryRootBlogCategory();
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
                List<BlogCategory> blogSubCategoryList = blogCategoryService.querySubBlogCategory(blogCategoryVoList.get(j).getId());
                blogCategoryVoList.get(j).setSubBlogCategory(blogSubCategoryList);
            }
        }
        return blogCategoryVoList;
    }


    /**
     * 测试
     */
    @GetMapping("/test")
    @ResponseBody
    public void test(){
        return;
    }
}
