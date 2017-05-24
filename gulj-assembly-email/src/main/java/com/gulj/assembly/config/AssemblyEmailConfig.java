package com.gulj.assembly.config;

import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author gulj
 * @create 2017-05-24 下午3:21
 **/

@Configuration
@PropertySources({@PropertySource("classpath:config/gulj-assembly-email.properties")})
@ComponentScan(basePackages = {"com.gulj.assembly.email"}, nameGenerator = JoinAnnotationBeanNameGenerator.class)
public class AssemblyEmailConfig {



}
