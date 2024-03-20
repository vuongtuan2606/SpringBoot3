package com.tuandev.springboot.aopdemo.dao;

import com.tuandev.springboot.aopdemo.model.Account;

public interface AccountDAO {

    void addAccount(Account account,boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
