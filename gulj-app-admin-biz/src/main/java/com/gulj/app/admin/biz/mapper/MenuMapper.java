package com.gulj.app.admin.biz.mapper;

import com.gulj.app.admin.biz.entity.Menu;
import com.gulj.app.admin.biz.entity.User;

import java.util.List;

public interface MenuMapper {

    User queryUserList();

    List<Menu> getRootMenuLst();

    List<Menu> queryMenuByUserId(Integer userId);

    List<Menu> getUserRootMenuLst(Integer userId);

    List<Menu> querySideBarParentMenu(int menuId);

    List<Menu> querySideBarChildMenu(int menuId);

}
