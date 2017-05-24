package com.gulj.app.blog.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gulj.app.blog.api.bo.BusinessParamBo;
import com.gulj.app.blog.api.bo.PageParamBo;
import com.gulj.app.blog.api.service.BlogCommentService;
import com.gulj.app.blog.api.service.BlogReplyService;
import com.gulj.app.blog.api.vo.BlogCommentVo;
import com.gulj.app.blog.biz.mapper.BlogCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-19 下午2:43
 **/
@Service(version = "1.0.0")
public class BlogCommentServiceImpl implements BlogCommentService {


    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Autowired
    private BlogReplyService blogReplyService;


    /**
     * 根据文章查询文章的所有评论以及回复
     *
     * @param businessParamBo
     * @param pageParamBo
     * @return
     */
    public PageInfo<BlogCommentVo> queryCommentListByArticleIdPages(BusinessParamBo businessParamBo, PageParamBo pageParamBo) {
        //判断是否含有排序的字符串
        PageHelper.startPage(pageParamBo.getPageNumber(), pageParamBo.getPageSize());
        List<BlogCommentVo> blogCommentVoList = blogCommentMapper.queryCommentListByArticleId(businessParamBo.getArticleId());
        if (null != blogCommentVoList && blogCommentVoList.size() > 0) {
            for (int i = 0; i < blogCommentVoList.size(); i++) {
                blogCommentVoList.get(i).setBlogReplyVoList(blogReplyService.queryReplyListByCommentId(blogCommentVoList.get(i).getId()));
            }
        }
        return new PageInfo<>(blogCommentVoList);
    }


}
