package com.tuandev.springboot.demo.dao;

import ch.qos.logback.core.joran.conditional.ThenAction;
import com.tuandev.springboot.demo.entitty.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimp implements EmployeeDAO{

    //define field for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    public EmployeeDAOimp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

        // execute query and get  result list
        List<Employee> employee = theQuery.getResultList();

        // return the results
        return employee;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // return employee
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        // return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void  deleteById(int theId) {
        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);
        //remove employee
        entityManager.remove(theEmployee);

    }
}
