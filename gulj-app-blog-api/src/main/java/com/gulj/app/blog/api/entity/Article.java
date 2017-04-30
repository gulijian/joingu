package com.gulj.app.blog.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author gulj
 * @create 2017-04-30 下午3:52
 **/
@Data
public class Article  implements  java.io.Serializable{

    private Long id;
    private String title;
    private String content;
    private Date create_time;


    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
