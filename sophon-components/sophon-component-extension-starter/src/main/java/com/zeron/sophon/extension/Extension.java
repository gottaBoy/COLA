package com.zeron.sophon.extension;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Extension
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Repeatable(Extensions.class)
@Component
public @interface Extension {
    String bizId()  default BizScenario.DEFAULT_BIZ_ID;
    String useCase() default BizScenario.DEFAULT_USE_CASE;
    String scenario() default BizScenario.DEFAULT_SCENARIO;
}
