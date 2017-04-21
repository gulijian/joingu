package com.gulj.admin.web.mapper;

import com.gulj.admin.web.entity.User;
import com.gulj.admin.web.pojo.FjParamPojo;

import java.util.List;

public interface UserMapper {


    User checkUser(User user);

    List<User> queryUserLst();

    List<User> queryListPageInfo(User user);

    int addEmployee(User user);

    int delEmployee(FjParamPojo fjParamPojo);

}
