package com.gulj.admin.web.mapper;

import com.gulj.admin.web.entity.Menu;
import com.gulj.admin.web.entity.User;

import java.util.List;

public interface MenuMapper {

    User queryUserList();

    List<Menu> getRootMenuLst();

    List<Menu> queryMenuByUserId(Integer userId);

    List<Menu> getUserRootMenuLst(Integer userId);

    List<Menu> querySideBarParentMenu(int menuId);

    List<Menu> querySideBarChildMenu(int menuId);

}
