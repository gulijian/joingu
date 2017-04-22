package com.app.admin.biz.test;

import com.gulj.app.admin.biz.entity.User;
import com.gulj.app.admin.biz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gulj on 2017/4/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestAdminBizApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void checkUser(){

        User user = userService.checkUser("admin","123456");

        System.out.println(user.getNickName());
    }




}
