package com.gulj.app.admin.web.controller.blog;

import com.gulj.app.admin.web.constant.AdminConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gulj
 * @create 2017-05-25 下午2:13
 **/
@Controller
@RequestMapping("/sys/blog/article")
public class BlogArticleController {



    @RequestMapping("/list")
    public String list() {
        return AdminConstant.VIEW_ROOT_SYS_BLOG + "article/list";
    }








}
