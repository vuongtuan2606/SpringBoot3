package com.tuandev.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //  add all of my related advices for logging

    // @Before advice
    // .. match on any number of arguments
    @Before("execution(* add*(com.tuandev.springboot.aopdemo.model.Account, ..))")
    public void beforeAddAccountAdvice() {

        System.out.println("\n ===> Executing @Before advice on mothod");

    }
}











