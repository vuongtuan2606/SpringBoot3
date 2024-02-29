package com.tuandev.springboot.demo.rest;

import com.tuandev.springboot.demo.entitty.Employee;
import com.tuandev.springboot.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {


 /*   private EmployeeDAO employeeDAO;
    // quick and dirty : inject employee dao(use constructor injection)
    public RestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }*/

    private EmployeeService employeeService;

    public RestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employee" and return a list of employee
    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET / employees / { employeeId}
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployes = employeeService.findById(employeeId);

        if(theEmployes == null){
            throw  new RuntimeException("Employee id not found" +employeeId);
        }

        return theEmployes;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employee")
    public  Employee updateEmployee(@RequestBody Employee theEmployee ){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String DeleteEmployee(@PathVariable int employeeId) {
        Employee theEmployes = employeeService.findById(employeeId);

        //throw exception if null
        if(theEmployes== null){
            throw new RuntimeException("Employee id not found" +employeeId);
        }

        employeeService.deleteById(employeeId);

        return "deteled employee id "+ employeeId;
    }

}
