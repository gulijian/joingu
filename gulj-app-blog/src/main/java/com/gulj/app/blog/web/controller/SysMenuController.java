package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.entity.SysMenu;
import com.gulj.app.blog.api.service.SysMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-04 下午5:11
 **/
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {


    @Reference(version = "1.0.0")
    private SysMenuService sysMenuService;

    @GetMapping("/list")
    public List<SysMenu> list() {
        return sysMenuService.list();
    }


}
