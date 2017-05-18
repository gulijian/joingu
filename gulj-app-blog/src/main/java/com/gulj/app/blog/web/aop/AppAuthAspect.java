package com.gulj.app.blog.web.aop;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.service.BlogCategoryService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author gulj
 * @create 2017-05-18 下午2:23
 **/
@SuppressWarnings("ALL")
@Aspect
@Component
public class AppAuthAspect extends AuthBaseAspect{

    private final static Logger logger = LoggerFactory.getLogger(AppAuthAspect.class);

    @Reference(version = "1.0.0", timeout = 1200000)
    private BlogCategoryService blogCategoryService;

    @Pointcut("execution(public * com.gulj.app.blog.web.controller..*.*(..))")
    public void apiAuth() {

    }

    @Around("apiAuth()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println(blogCategoryService);
        return process(point,blogCategoryService);
    }


}
