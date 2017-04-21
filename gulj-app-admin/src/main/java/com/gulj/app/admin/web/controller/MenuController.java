package com.gulj.app.admin.web.controller;

import com.gulj.app.admin.biz.entity.Menu;
import com.gulj.app.admin.biz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/getRootMenuLst")
    @ResponseBody
    public List<Menu> getRootMenuLst() {
        return menuService.getRootMenuLst();
    }

}
