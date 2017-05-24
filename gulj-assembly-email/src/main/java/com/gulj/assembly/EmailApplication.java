package com.gulj.assembly;

import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author gulj
 * @create 2017-05-24 下午3:33
 **/
@SpringBootTest
@SpringBootApplication
@ComponentScan(basePackages = {"com.gulj.assembly.**.config"},nameGenerator = JoinAnnotationBeanNameGenerator.class)
public class EmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

}
