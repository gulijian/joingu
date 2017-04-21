package com.gulj.admin.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.gulj.admin.web.entity.User;
import com.gulj.admin.web.pojo.BusinessParamPojo;
import com.gulj.admin.web.pojo.FjParamPojo;
import com.gulj.admin.web.pojo.ResponseResultPojo;
import com.gulj.admin.web.service.UserService;
import com.gulj.common.page.BootStrapPage;
import com.gulj.common.page.PageParam;
import com.gulj.common.util.FeijianCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("sys/sys/user")
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/queryUserLst")
    @ResponseBody
    public BootStrapPage queryUserLst(BusinessParamPojo bussinessParam, PageParam pageParam) {
        User user = null;
        user = new User();
        user.setUsername(bussinessParam.getUsername());
        user.setPhone(bussinessParam.getPhone());
        PageInfo<User> list = userService.queryListPageInfo(user, pageParam);
        if (null != list) {
            BootStrapPage bootStrapPage = new BootStrapPage();
            bootStrapPage.setPage(list.getPageNum());
            bootStrapPage.setTotal(list.getTotal());
            bootStrapPage.setTotalPage(list.getPages());
            List<User> appUserLst = list.getList();
            bootStrapPage.setRows(appUserLst);
            return bootStrapPage;
        }
        return null;
    }

    /**
     * 跳转到编辑页面
     * 方法名：toEditPage
     * 创建人：gulj
     * 时间：2016年4月18日-下午6:22:22
     *
     * @return ModelAndView
     * @throws
     * @since 1.0.0
     */
    @RequestMapping("toEditPage")
    public ModelAndView toEditPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sys/sys/employee/edit");
        return mv;
    }

    /**
     * 跳转到编辑页面
     * 方法名：toEditPage
     * 创建人：gulj
     * 时间：2016年4月18日-下午6:22:22
     *
     * @return ModelAndView
     * @throws
     * @since 1.0.0
     */
    @RequestMapping("toAddPage")
    public ModelAndView toAddPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sys/sys/employee/add");
        return mv;
    }

    /**
     * 新增员工
     *
     * @param user
     * @return
     */
    @RequestMapping("/addEmployee")
    @ResponseBody
    public ResponseResultPojo addEmployee(User user) {
        ResponseResultPojo responseResultPojo = new ResponseResultPojo();
        String returnCode = null;
        try {
            boolean flag = userService.addEmployee(user);
            if (flag) {
                returnCode = FeijianCode.SAVE_SUCCESS.toString();
            } else {
                returnCode = FeijianCode.SAVE_ERROR.toString();
            }
        } catch (Exception e) {
            returnCode = FeijianCode.SAVE_ERROR.toString();
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        responseResultPojo = JSONObject.parseObject(returnCode, ResponseResultPojo.class);
        return responseResultPojo;
    }


    /**
     * 删除员工
     * @param fjParamPojo
     * @return
     */
    @RequestMapping("/delEmployee")
    @ResponseBody
    public ResponseResultPojo delEmployee(FjParamPojo fjParamPojo) {
        ResponseResultPojo responseResultPojo = new ResponseResultPojo();
        String returnCode = null;
        try {
            boolean flag = userService.delEmployee(fjParamPojo);
            if (flag) {
                returnCode = FeijianCode.DELETE_SUCCESS.toString();
            } else {
                returnCode = FeijianCode.DELETE_ERROR.toString();
            }
        } catch (Exception e) {
            returnCode = FeijianCode.DELETE_ERROR.toString();
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        responseResultPojo = JSONObject.parseObject(returnCode, ResponseResultPojo.class);
        return responseResultPojo;
    }


}
