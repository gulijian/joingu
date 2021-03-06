package com.gulj.app.admin.config;

import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:config/mybatis.properties")
@ComponentScan(basePackages = {"com.gulj.app.admin.biz.service"}, nameGenerator = JoinAnnotationBeanNameGenerator.class)
@MapperScan(basePackages = "com.gulj.app.admin.biz.mapper")
public class AdminBizConfig {

   /* private final static Logger logger = LoggerFactory.getLogger(AdminBizConfig.class);


    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public String getStr() {
        logger.info("++++加载的数据源信息 url：{}", dataSourceProperties.getUrl());
        return "ok";
    }*/
}
