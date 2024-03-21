package com.tuandev.springboot.aopdemo.dao;

import com.tuandev.springboot.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {

        // Pass in tripWire = false
        // Don't throw an exception
        return findAccounts(false);
    }
    @Override
    public List<Account> findAccounts(boolean tripWire) {
        // for academic purposes ... simulate an exception
        if (tripWire) {
            throw new RuntimeException("No ========!!!");
        }

        List<Account> myAccounts = new ArrayList<>();
        // create sample accounts
        Account temp1 = new Account("tuan", "silver");
        Account temp2 = new Account("quang", "Platium");
        Account temp3 = new Account("thang", "gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);


        return myAccounts;
    }


    @Override
    public void addAccount(Account account, boolean vipFlag ) {

        System.out.println(getClass() + "--ADDING A ACCOUNT");

    }


    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }


    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
