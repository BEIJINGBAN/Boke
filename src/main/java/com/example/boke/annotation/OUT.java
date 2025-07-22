package com.example.boke.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OUT {
    String message() default "我用了注解";
    boolean logBefore() default false;
    boolean logAfter() default true;
}
