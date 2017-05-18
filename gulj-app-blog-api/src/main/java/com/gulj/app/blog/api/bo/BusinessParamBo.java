package com.gulj.app.blog.api.bo;

import lombok.Data;

/**
 * @author gulj
 * @create 2017-05-15 下午4:23
 **/
@Data
public class BusinessParamBo implements java.io.Serializable {

    private String title;//文章标题

    private Integer stand = 100;//首页文章展示的标准分数（love + hit + comment）总数

    private String url;//分类url
}
