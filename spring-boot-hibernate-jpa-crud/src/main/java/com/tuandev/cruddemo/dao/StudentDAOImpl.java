package com.tuandev.cruddemo.dao;

import com.tuandev.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // xác định entity manager
    private EntityManager entityManager;

    // tạo constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /* @Transactional
    * dùng khi cập nhật hoặc sửa đổi trong db
    * */
    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        // save
        entityManager.persist(theStudent);
    }

    //implement FindByID method
    @Override
    public Student FindByID(Integer id) {
        return entityManager.find(Student.class, id);
    }


    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> listsv = entityManager.createQuery("FROM Student order by id desc ", Student.class);

        // return query results
        return listsv.getResultList();
    }


    @Override
    public List<Student> FindByName(String theName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE name=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theName);

        // return query results
        return theQuery.getResultList();
    }


    @Override
    @Transactional
    public void update(Student sv) {
        // update
        entityManager.merge(sv);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student
        Student sv = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(sv);
    }

    @Override
    @Transactional
    public int deleteAll() {
        //executeUpdate sửa đổi cơ sở dữ liệu
        int numRowsDeleted = entityManager.createQuery("DELETE from Student ").executeUpdate();
        return numRowsDeleted;
    }


}










