package com.tuandev.springboot.aopdemo.dao;

import com.tuandev.springboot.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account) {

        System.out.println(getClass() + "ADDING A ACCOUNT");

    }
}
