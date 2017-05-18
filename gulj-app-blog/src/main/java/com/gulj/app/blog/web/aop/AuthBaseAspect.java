package com.gulj.app.blog.web.aop;

import com.gulj.app.blog.api.service.BlogCategoryService;
import com.gulj.app.blog.api.vo.BlogCategoryVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Api基础切面类 - 登录鉴权包装
 *
 * @author gulj
 * @create 2017-05-18 下午2:24
 **/
public class AuthBaseAspect {


    public Object process(ProceedingJoinPoint point,BlogCategoryService blogCategoryService) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        HttpSession session = req.getSession();
        //分类列表
        List<BlogCategoryVo> blogCategoryVoList = (List<BlogCategoryVo>) session.getAttribute("blogCategoryVoList");
        if (null == blogCategoryVoList) {
            blogCategoryVoList = blogCategoryService.list();
            session.setAttribute("blogCategoryVoList", blogCategoryVoList);
        }
        Object object = point.proceed();
        return object;
    }
}
