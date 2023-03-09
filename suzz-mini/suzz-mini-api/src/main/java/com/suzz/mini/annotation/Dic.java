package com.suzz.mini.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dic {

    /**
     * 字典值code
     */
    String code() default "";

    /**
     * 标识该字段转换后的多语言所被赋值的字段
     */
     String target() default "";
}
