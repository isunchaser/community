package com.example.community.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示注解在方法上生效
@Target(ElementType.METHOD)
//声明注解有效时长--程序运行的时候有效
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {

}
