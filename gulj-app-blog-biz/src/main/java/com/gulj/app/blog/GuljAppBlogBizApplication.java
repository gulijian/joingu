package com.gulj.app.blog;

import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gulj.app.blog.config"}, nameGenerator = JoinAnnotationBeanNameGenerator.class)
public class GuljAppBlogBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuljAppBlogBizApplication.class, args);
	}
}
