package com.gulj.app.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gulj
 * @create 2017-05-14 下午3:14
 **/
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String index() {
        return "views/index";
    }


}
