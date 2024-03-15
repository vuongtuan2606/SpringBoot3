package com.tuandev.springboot.demojpa.dao;


import com.tuandev.springboot.demojpa.entity.Instructor;
import com.tuandev.springboot.demojpa.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetaillById(int theID);
    void deleteInstructorDetailById(int theId);
}
