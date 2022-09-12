package com.huike.web.controller.common.minIO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationContextAwareCustom implements ApplicationContextAware, InitializingBean {


    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextAwareCustom.applicationContext = applicationContext;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("===================>"+beanDefinitionName);
        }
    }


}