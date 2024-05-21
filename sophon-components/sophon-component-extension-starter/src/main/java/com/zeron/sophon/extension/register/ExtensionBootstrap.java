package com.zeron.sophon.extension.register;

import com.zeron.sophon.extension.Extension;
import com.zeron.sophon.extension.ExtensionPointI;
import com.zeron.sophon.extension.Extensions;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * ExtensionBootstrap
 */
@Component
public class ExtensionBootstrap implements ApplicationContextAware {

    @Resource
    private ExtensionRegister extensionRegister;

    private ApplicationContext applicationContext;

    @PostConstruct
    public void init(){
        Map<String, Object> extensionBeans = applicationContext.getBeansWithAnnotation(Extension.class);
        extensionBeans.values().forEach(
                extension -> extensionRegister.doRegistration((ExtensionPointI) extension)
        );

        // handle @Extensions annotation
        Map<String, Object> extensionsBeans = applicationContext.getBeansWithAnnotation(Extensions.class);
        extensionsBeans.values().forEach( extension -> extensionRegister.doRegistrationExtensions((ExtensionPointI) extension));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
