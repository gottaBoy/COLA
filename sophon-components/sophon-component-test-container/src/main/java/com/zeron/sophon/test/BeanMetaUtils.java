package com.zeron.sophon.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * BeanMetaUtils
 *
 */
public class BeanMetaUtils {
    public static Method findMethod(Class clazz, Class<? extends Annotation> annotationType){
        Method[] allMethods = clazz.getMethods();
        for (Method method : allMethods){
            Annotation[] annotations = method.getAnnotations();
            for(Annotation item : annotations){
                if(item.annotationType().equals(annotationType)){
                    return method;
                }
            }
        }
        return null;
    }
}
