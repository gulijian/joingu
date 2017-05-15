package com.gulj.app.blog.biz.mapper;

import com.gulj.app.blog.api.bo.BusinessParamBo;
import com.gulj.app.blog.api.entity.BlogArticle;
import com.gulj.app.blog.api.vo.BlogArticleListVo;
import com.gulj.app.blog.biz.JoinGuMapper;

import java.util.List;

public interface BlogArticleMapper extends JoinGuMapper<BlogArticle> {
    /**
     * 分页查询首页的文章列表
     *
     * @param businessParamBo
     * @return
     */
    List<BlogArticleListVo> queryListPageIndexInfo(BusinessParamBo businessParamBo);
}