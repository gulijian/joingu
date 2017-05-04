package com.gulj.app.blog.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gulj.app.blog.api.entity.SysMenu;
import com.gulj.app.blog.api.service.SysMenuService;
import com.gulj.app.blog.biz.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author gulj
 * @create 2017-05-04 下午3:41
 **/
@Service(version = "1.0.0")
public class SysMenuServiceImpl implements SysMenuService {


    @Autowired
    private SysMenuMapper mapper;


    @Override
    public List<SysMenu> list() {
        return mapper.selectAll();
    }
}
