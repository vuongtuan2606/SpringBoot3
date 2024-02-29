package com.tuandev.springboot.demo.dao;

import com.tuandev.springboot.demo.entitty.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "nhanvien")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
