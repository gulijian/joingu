package com.gulj.app.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 打开首页
     */
    @RequestMapping("/sys/index")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/sys/indexContent")
    public String showIndexContent() {
        return "indexContent";
    }


    /**
     * 展示其他页面
     * <p>
     * Title: showpage
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param page
     * @return
     */
    @RequestMapping("/sys/{model}/{page}")
    public String showpage(@PathVariable String model, @PathVariable String page) {
        return "/sys/" + model + "/" + page;
    }

}
