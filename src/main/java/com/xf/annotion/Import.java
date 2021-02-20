package com.xf.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
public @interface Import {
    //对应的表头名称
    String columnName() default "";
    //是否导出
    boolean isAllowEmpty() default true;
    //错误提示
    String errorMessage() default "";

}
