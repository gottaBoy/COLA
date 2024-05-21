package com.zeron.sophon.domain;

/**
 * DomainFactory
 */
public class DomainFactory {

    public static <T> T create(Class<T> entityClz){
        return ApplicationContextHelper.getBean(entityClz);
    }

}
