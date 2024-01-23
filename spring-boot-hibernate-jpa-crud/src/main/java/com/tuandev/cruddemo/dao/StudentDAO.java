package com.tuandev.cruddemo.dao;

import com.tuandev.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    //save db
    void save(Student theStudent);

    // find by id
    Student FindByID(Integer id);

    // find all
    List<Student> findAll();

    // find by name
    List<Student> FindByName(String theName);

    //update
    void update(Student sv);

    //delete
    void delete(Integer id);

    //deleteAll
    int deleteAll();
}
