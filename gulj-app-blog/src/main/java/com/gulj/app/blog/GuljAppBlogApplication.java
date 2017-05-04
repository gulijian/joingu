package com.gulj.app.blog;

import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 平台后台启动配置类
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.gulj.app.blog.config"}, nameGenerator = JoinAnnotationBeanNameGenerator.class)
@EnableAsync
public class GuljAppBlogApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF)
				.sources(GuljAppBlogApplication.class).run(args);
	}
}
