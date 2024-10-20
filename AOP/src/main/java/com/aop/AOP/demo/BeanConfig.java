package com.aop.AOP.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.aop.AOP.demo")
@EnableAspectJAutoProxy
public class BeanConfig {
}
