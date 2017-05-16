package com.gulj.app.blog.api.bo;

import lombok.Data;

/**
 * 分页参数
 *
 * @author gulj
 * @create 2017-05-15 下午4:18
 **/
@Data
public class PageParamBo implements java.io.Serializable{

    private String order;
    private int limit; //每页的大小
    private int offset; // 偏移量 0.16,32

    private int pageNumber = 1; //页码
    private int pageSize = 5; //每页的大小

}
