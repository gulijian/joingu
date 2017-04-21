/**
 * 上海旗顾 问股平台
 */

package com.gulj.entity.common.bo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义Spring注解bean的命名策略
 */
public class JoinAnnotationBeanNameGenerator extends AnnotationBeanNameGenerator {
	
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition) {
        String className = definition.getBeanClassName();
        try {
            Class<?> clazz = Class.forName(className);

            Controller controller = clazz.getAnnotation(Controller.class);
            RestController restController = clazz.getAnnotation(RestController.class);
            Repository repository = clazz.getAnnotation(Repository.class);
            Service service = clazz.getAnnotation(Service.class);
            if ((repository != null && StringUtils.isEmpty(repository.value())) || (service != null && StringUtils.isEmpty(service.value())) || (controller != null && StringUtils.isEmpty(controller.value())) || (restController != null && StringUtils.isEmpty(restController.value()))) {
                if (className.toLowerCase().endsWith("impl")) {
                    className = className.substring(0, className.length() - 4);
                }
                className = StringUtils.replace(className.toLowerCase(), "\\.", "_");
            } else {
                className = super.buildDefaultBeanName(definition);
            }
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            className = super.buildDefaultBeanName(definition);
        }
        return className;
    }
}
