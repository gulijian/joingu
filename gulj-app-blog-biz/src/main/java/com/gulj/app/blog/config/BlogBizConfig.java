package com.gulj.app.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author gulj
 * @create 2017-04-30 下午4:44
 **/
@Configuration
@PropertySource(value = "classpath:config/mybatis.properties")
@MapperScan(basePackages = "com.gulj.app.blog.biz.mapper")
public class BlogBizConfig {



}
