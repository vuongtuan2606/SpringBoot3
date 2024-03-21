package com.tuandev.springboot.demo.service;

import com.tuandev.springboot.demo.entitty.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById( int theId);

    void  save(Employee theEmployee);

    void deleteById( int theId);
}
