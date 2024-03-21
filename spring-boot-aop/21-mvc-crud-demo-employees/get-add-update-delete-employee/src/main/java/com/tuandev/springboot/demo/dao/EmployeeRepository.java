package com.tuandev.springboot.demo.dao;

import com.tuandev.springboot.demo.entitty.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
    // spring Data JPA will parse the method name
    // lock for a specific formar and patern
    // creates appropriate query ... behind the scenes
}
