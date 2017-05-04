package com.gulj.app.blog.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gulj.app.blog.api.entity.SysMenu;
import com.gulj.app.blog.api.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "系统菜单", description = "系统菜单", tags = "blog-menu")
public class SysMenuController {


    @Reference(version = "1.0.0")
    private SysMenuService sysMenuService;

    @GetMapping("/list")
    @ApiOperation(value="获取菜单列表", notes="获取菜单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "PageParamBo", value = "查询条件页码参数相关", required = true, dataType = "long")
    })
    public List<SysMenu> list() {
        return sysMenuService.list();
    }


}
