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

    // create a pointcut for getter methods
    @Pointcut("execution(* com.tuandev.springboot.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.tuandev.springboot.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ===> Executing @Before advice on mothod");
    }

    // reuse
    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}











