package com.gulj.app.admin.biz.mapper;

import com.gulj.app.admin.biz.entity.User;
import com.gulj.app.admin.biz.bo.FjParamBo;

import java.util.List;

public interface UserMapper {


    User checkUser(User user);

    List<User> queryUserLst();

    List<User> queryListPageInfo(User user);

    int addEmployee(User user);

    int delEmployee(FjParamBo fjParamBo);

}
