package com.gulj.app.blog.biz;

import com.gulj.app.blog.biz.GuljAppBlogBizApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GuljAppBlogBizApplication.class);
	}

}
