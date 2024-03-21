package com.tuandev.springboot.aopdemo.dao;

import com.tuandev.springboot.aopdemo.model.Account;

import java.util.List;

public interface AccountDAO {
    // add a new method: findAccounts()

    List<Account> findAccounts();
    void addAccount(Account account,boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
