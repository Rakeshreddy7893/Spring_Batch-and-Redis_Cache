package com.aop.AOP.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.aop.AOP.demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {

        if (jp.getArgs().length > 0) {
            System.out.println(jp.getArgs()[0].toString());
        }
        System.out.println("Logging before checkout method execution");
    }

    @After("execution(* com.aop.AOP.demo.ShoppingCart.checkout(..))")
    public void afterLogger() {
        System.out.println("Logging after checkout method execution");
    }


    @Pointcut("execution(* com.aop.AOP.demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {
    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After Returning: " + retVal);
    }
}
