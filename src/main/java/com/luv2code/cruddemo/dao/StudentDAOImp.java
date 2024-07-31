package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(Integer ID) {
        return entityManager.find(Student.class, ID);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);

        return theQuery.getResultList();
    }
}
