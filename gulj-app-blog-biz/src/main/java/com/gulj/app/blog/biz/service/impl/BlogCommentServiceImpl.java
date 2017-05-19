package com.gulj.app.blog.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
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
     * @param articleId
     * @return
     */
    public List<BlogCommentVo> queryCommentListByArticleId(Integer articleId) {
        List<BlogCommentVo> blogCommentVoList = blogCommentMapper.queryCommentListByArticleId(articleId);
        if (null != blogCommentVoList && blogCommentVoList.size() > 0) {
            for (int i = 0; i < blogCommentVoList.size(); i++) {
                blogCommentVoList.get(i).setBlogReplyVoList(blogReplyService.queryReplyListByCommentId(blogCommentVoList.get(i).getId()));
            }
        }
        return blogCommentVoList;
    }


}
