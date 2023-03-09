package com.suzz.mini.annotation;

import java.lang.annotation.*;

/**
 * 标记需要转换字典的DTO类
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DicMark {
}
