package com.gulj.admin.web.service;

import com.gulj.admin.web.entity.Menu;
import com.gulj.admin.web.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;


    public List<Menu> getRootMenuLst() {
        return menuMapper.getRootMenuLst();
    }


    /**
     * 获取用户的一级菜单
     *
     * @param userId
     * @return
     */
    public List<Menu> getUserRootMenuLst(Integer userId) {
        return menuMapper.getUserRootMenuLst(userId);
    }

    /**
     * 获取用户一级菜单下左侧的父菜单
     *
     * @param menuId
     * @return
     */
    public List<Menu> querySideBarParentMenu(int menuId) {
        return menuMapper.querySideBarParentMenu(menuId);
    }

    /**
     * 获取用户一级菜单下左侧的父菜单的字菜单
     *
     * @param menuId
     * @return
     */
    public List<Menu> querySideBarChildMenu(int menuId) {
        return menuMapper.querySideBarChildMenu(menuId);
    }


}
