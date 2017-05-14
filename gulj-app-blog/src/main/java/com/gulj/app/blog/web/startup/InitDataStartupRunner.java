package com.gulj.app.blog.web.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author gulj
 * @create 2017-05-14 下午6:05
 **/
@Component
@Order(value = 1)
public class InitDataStartupRunner implements CommandLineRunner {


    @Override
    public void run(String... strings) throws Exception {

        System.out.println("初始化数据开始");


    }


}
