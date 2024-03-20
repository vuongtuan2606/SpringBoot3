package com.tuandev.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.tuandev.springboot.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ===> Executing @Before advice on mothod");
    }


}











