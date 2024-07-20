package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImp implements StudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAOImp (EntityManager TheEntityManager){
        entityManager = TheEntityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
            entityManager.persist(theStudent);
    }
}
