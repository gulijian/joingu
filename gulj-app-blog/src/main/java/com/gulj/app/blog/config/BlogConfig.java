package com.gulj.app.blog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 统一配置
 *
 * @author gulj
 * @create 2017-04-21 下午6:49
 **/

@Configuration
//@ComponentScan(basePackages = {"com.gulj.app.blog.aop"}, nameGenerator = JoinAnnotationBeanNameGenerator.class)
public class BlogConfig extends WebMvcConfigurerAdapter {


    @SuppressWarnings("unused")
    private final static Logger logger = LoggerFactory.getLogger(BlogConfig.class);


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    ;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }


}
