/**
 * 上海旗顾 问股平台
 */

package com.ncm.app.institu.config;

import com.ncm.common.bo.NCMAnnotationBeanNameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ncm.app.institu.busi"}, nameGenerator = NCMAnnotationBeanNameGenerator.class)
public class InstituBusiConfig {

    private final static Logger logger = LoggerFactory.getLogger(InstituBusiConfig.class);


    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public String getStr() {
        logger.info("++++加载的数据源信息 url：{}", dataSourceProperties.getUrl());
        return "ok";
    }
}
