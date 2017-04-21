package com.gulj.app.admin.biz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gulj.app.admin.biz.entity.ReqParam;
import com.gulj.app.admin.biz.entity.User;
import com.gulj.app.admin.biz.mapper.UserMapper;
import com.gulj.common.page.PageParam;
import com.gulj.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User checkUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Util.getMd5(password));
        return userMapper.checkUser(user);
    }


    public PageInfo<User> queryListPageInfo(User user, PageParam pageParam) {
        //判断是否含有排序的字符串
        PageHelper.startPage(pageParam.getPageNumber(), pageParam.getPageSize());
        List<User> resultList = userMapper.queryListPageInfo(user);
        return new PageInfo<User>(resultList);
    }

    /**
     * 新增员工
     *
     * @param user
     * @return
     */
    public boolean addEmployee(User user) {
        user.setPassword("123456");
        user.setPassword(MD5Util.getMd5(user.getPassword()));
        int flag = userMapper.addEmployee(user);
        return flag > 0 ? true : false;
    }

    /**
     * 删除员工
     *
     * @param fjParamBo
     * @return
     */
    public boolean delEmployee(ReqParam fjParamBo) {
        int flag = userMapper.delEmployee(fjParamBo);
        return flag > 0 ? true : false;
    }


}
