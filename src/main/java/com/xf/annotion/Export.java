package com.xf.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
public @interface Export {
    //导出得标题名称
    String showHeader() default "";
    //是否导出
    boolean isExport() default false;


}
