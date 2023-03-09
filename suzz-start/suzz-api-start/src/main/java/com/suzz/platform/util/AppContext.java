package com.suzz.platform.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author subo
 * @date 2022/4/23 0:07
 **/
@Component
public class AppContext implements ApplicationContextAware {
    static ApplicationContext appContext;

    public AppContext() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    public static <T> T getBean(Class<T> requiredType) {
        return !Objects.isNull(appContext) && !Objects.isNull(requiredType) ? appContext.getBean(requiredType) : null;
    }

    public static Object getBean(String name) {
        return !Objects.isNull(appContext) && !StringUtils.isEmpty(name) ? appContext.getBean(name) : null;
    }
}