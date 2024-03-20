package com.tuandev.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //  add all of my related advices for logging

    // @Before advice

    // match methods in a Package
    // return type - package - class - method - params
    @Pointcut("execution(* com.tuandev.springboot.aopdemo.dao.*.*(..))")
    // name of poincut declaration - can have any name
    private  void forDaoPackage(){};

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n ===> Executing @Before advice on mothod");

    }

    // reuse
    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}











