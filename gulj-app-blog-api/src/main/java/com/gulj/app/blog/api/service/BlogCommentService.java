package com.gulj.app.blog.api.service;

import com.github.pagehelper.PageInfo;
import com.gulj.app.blog.api.bo.BusinessParamBo;
import com.gulj.app.blog.api.bo.PageParamBo;
import com.gulj.app.blog.api.vo.BlogCommentVo;

/**
 * @author gulj
 * @create 2017-05-19 下午2:42
 **/
public interface BlogCommentService {


    /**
     * 根据文章查询文章的所有评论以及回复
     *
     * @param businessParamBo
     * @param pageParamBo
     * @return
     */
    PageInfo<BlogCommentVo> queryCommentListByArticleIdPages(BusinessParamBo businessParamBo, PageParamBo pageParamBo);

}
