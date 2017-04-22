package com.app.admin.biz.test;

import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by gulj on 2017/4/22.
 */
@SpringBootTest
@SpringBootApplication
@ComponentScan(basePackages = {"com.gulj.app.**.config"},nameGenerator = JoinAnnotationBeanNameGenerator.class)
public class TestAdminBizApplication {

    public static void main(String[] args) throws  Exception{
        SpringApplication.run(TestAdminBizApplication.class);
    }
}
