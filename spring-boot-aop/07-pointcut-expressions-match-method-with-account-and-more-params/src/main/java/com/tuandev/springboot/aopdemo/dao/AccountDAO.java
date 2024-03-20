package com.tuandev.springboot.aopdemo.dao;

import com.tuandev.springboot.aopdemo.model.Account;

public interface AccountDAO {

    void addAccount(Account account,boolean vipFlag);


}
