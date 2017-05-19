package com.gulj.app.blog.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gulj.app.blog.api.service.BlogReplyService;
import com.gulj.app.blog.api.vo.BlogReplyVo;
import com.gulj.app.blog.biz.mapper.BlogReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-19 下午2:45
 **/
@Service(version = "1.0.0")
public class BlogReplyServiceImpl implements BlogReplyService {


    @Autowired
    private BlogReplyMapper blogReplyMapper;


    /**
     * 查询评论下的所有回复
     *
     * @param commentId
     * @return
     */
    public List<BlogReplyVo> queryReplyListByCommentId(Integer commentId) {
        return blogReplyMapper.queryReplyListByCommentId(commentId);
    }


}
