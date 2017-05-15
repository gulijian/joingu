package com.gulj.app.blog.api.vo;

import lombok.Data;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-15 下午4:17
 **/
@Data
public class JoinGuPageVo {

    private List<?> rows;

    // 当前页码
    private Integer page = 1;

    // 总页数
    private Integer totalPage = 0;

    // 总记录数
    private long total = 0;
}
