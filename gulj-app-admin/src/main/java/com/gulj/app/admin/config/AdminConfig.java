package com.gulj.app.admin.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gulj.common.util.AdminUtil;
import com.gulj.entity.common.bo.JoinAnnotationBeanNameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gulj
 * @create 2017-04-21 下午6:49
 **/

@Configuration
@ComponentScan(basePackages = {"com.gulj.app.admin.web"}, nameGenerator = JoinAnnotationBeanNameGenerator.class)
public class AdminConfig extends WebMvcConfigurerAdapter {


    @SuppressWarnings("unused")
    private final static Logger logger = LoggerFactory.getLogger(AdminConfig.class);


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    };


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }



    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")) {

            @Override
            protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException {
                String input = new BufferedReader(new InputStreamReader(inputMessage.getBody()))
                        .lines().collect(Collectors.joining("\n"));
                return AdminUtil.stripXSS(input);
            }
        });
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .serializationInclusion(JsonInclude.Include.NON_NULL);
        ObjectMapper ob = builder.build();
//        SimpleModule simpleModule = new SimpleModule();
//
////        ob.getFactory().setCharacterEscapes(new OwaspCharacterEscapes());
//        simpleModule.addDeserializer(Object.class, new EscapeDeserializer());
//        ob.registerModule(simpleModule);
        MappingJackson2HttpMessageConverter htmlEscapingConverter = new MappingJackson2HttpMessageConverter(ob) {
//            @Override
//            protected void writeInternal(Object object,
//                                         HttpOutputMessage outputMessage) throws IOException,
//                    HttpMessageNotWritableException {
//                //使用Jackson的ObjectMapper将Java对象转换成Json String
//                ObjectMapper mapper = new ObjectMapper();
//                String json = mapper.writeValueAsString(object);
//                String result = InstituUtils.stripXSS(json);
//                outputMessage.getBody().write(result.getBytes());
//            }


            @Override
            public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
                JavaType javaType = getJavaType(type, contextClass);
                // String input = inputMessage.getBody().toString();
                String input = new BufferedReader(new InputStreamReader(inputMessage.getBody()))
                        .lines().collect(Collectors.joining("\n"));
                String result = AdminUtil.stripXSS(input);
                return this.objectMapper.readValue(result.getBytes(), javaType);
            }

//            @Override
//            protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
//                JavaType javaType = getJavaType(clazz, null);
//                String input = inputMessage.getBody().toString();
//                String result = InstituUtils.stripXSS(input);
//                return this.objectMapper.readValue(result.getBytes(), javaType);
//            }
        };
        converters.add(htmlEscapingConverter);
        // converters.add(new
        // MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
    }







}
