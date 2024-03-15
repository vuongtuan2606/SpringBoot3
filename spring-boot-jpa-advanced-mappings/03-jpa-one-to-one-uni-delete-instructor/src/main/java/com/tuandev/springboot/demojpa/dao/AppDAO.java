package com.tuandev.springboot.demojpa.dao;


import com.tuandev.springboot.demojpa.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

}
