package com.tuandev.springboot.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {


    @Override
    public void addSillyMember() {
        System.out.println(getClass() + "ADDING A MEMBERSHIP ACCOUNT");
    }
}
