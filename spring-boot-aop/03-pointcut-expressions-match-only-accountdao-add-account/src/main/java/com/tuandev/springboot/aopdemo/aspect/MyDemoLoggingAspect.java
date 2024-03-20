package com.tuandev.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //  add all of my related advices for logging

    // @Before advice

    @Before("execution(public void com.tuandev.springboot.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n ===> Executing @Before advice on addAccount()");

    }
}











