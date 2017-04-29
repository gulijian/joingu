package com.gulj.app.admin.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.gulj.app.admin.biz.entity.Menu;
import com.gulj.app.admin.biz.entity.User;
import com.gulj.app.admin.biz.service.MenuService;
import com.gulj.app.admin.biz.service.UserService;
import com.gulj.app.admin.web.constant.AdminConstant;
import com.gulj.app.admin.web.enums.FeijianCodeEnum;
import com.gulj.app.admin.web.constant.FeijianConstant;
import com.gulj.common.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;


    /**
     * @param request
     * @return
     */
    @SuppressWarnings({"static-access", "null"})
    @RequestMapping("logined")
    @ResponseBody
    public JSONObject logined(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            User user = userService.checkUser(username, password);
            if (user == null) {//账户不存在
                return jsonObject.parseObject(FeijianCodeEnum.USERORPWD_ERROR.toString());
            }
            if (user.getStatus().equals("1")) {//账号被禁止
                return jsonObject.parseObject(FeijianCodeEnum.USER_FIBINDDEN_ERROR.toString());
            }
            //用户信息放入session
            session.setAttribute(Const.SESSION_USER, user);
            //获取用户角色一级菜单
            List<Menu> rootMenuLst = menuService.getUserRootMenuLst(user.getSid());
            if (null == rootMenuLst && rootMenuLst.size() == 0) {
                return jsonObject.parseObject(FeijianCodeEnum.USEROR_NONE_TOP_MENU.toString());
            }
            //放入session
            session.setAttribute("rootMenuLst", rootMenuLst);
            //获取第一个一级菜单下左侧的导航菜单
            Menu firstRootMenu = rootMenuLst.get(0);
            //获取一级菜单下左侧的导航的一级菜单
            List<Menu> sideBarParentMenuLst = menuService.querySideBarParentMenu(firstRootMenu.getMenuId());
            if (null == sideBarParentMenuLst && sideBarParentMenuLst.size() == 0) {
                return jsonObject.parseObject(FeijianCodeEnum.USEROR_NONE_CHILD_MENU.toString());
            }
            //放入session
            session.setAttribute("sideBarParentMenuLst", sideBarParentMenuLst);
            for (Menu parentMenu : sideBarParentMenuLst) {
                if (parentMenu.getIsParent() > 0) {//含有子节点
                    List<Menu> sideBarChildMenuLst = menuService.querySideBarChildMenu(parentMenu.getMenuId());
                    if (null != sideBarChildMenuLst && sideBarChildMenuLst.size() > 0) {
                        parentMenu.setSubMenu(sideBarChildMenuLst);
                    }
                }
            }
            jsonObject = jsonObject.parseObject(FeijianCodeEnum.USEROR_LOGIN_SUCCESS.toString());
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject = jsonObject.parseObject(FeijianCodeEnum.SYS_EXCEPTION.toString());
        }
        return jsonObject;
    }


    /**
     * 切换一级菜单，改变左侧的菜单
     *
     * @param request
     * @return
     */
    @RequestMapping("changeMenuManage")
    @ResponseBody
    public ModelAndView changeMenuManage(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String menuId = request.getParameter("menuId");
        //获取一级菜单下左侧的导航的一级菜单
        List<Menu> sideBarParentMenuLst = menuService.querySideBarParentMenu(Integer.valueOf(menuId));
        if (null != sideBarParentMenuLst && sideBarParentMenuLst.size() > 0) {
            for (Menu parentMenu : sideBarParentMenuLst) {
                if (parentMenu.getIsParent() > 0) {//含有子节点
                    List<Menu> sideBarChildMenuLst = menuService.querySideBarChildMenu(parentMenu.getMenuId());
                    if (null != sideBarChildMenuLst && sideBarChildMenuLst.size() > 0) {
                        parentMenu.setSubMenu(sideBarChildMenuLst);
                    }
                }
            }
        }
        mv.addObject("sideBarParentMenuLst", sideBarParentMenuLst);
        mv.setViewName(AdminConstant.VIEW_ROOT+"sys/sidebartemplate");
        return mv;
    }


    /**
     * 页面登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        User user = (User) session.getAttribute(FeijianConstant.SESSION_USER);
        if (null != user) {
            return "index";
        }
        return "/views/login";
    }

    /**
     * 退出
     *
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

}
