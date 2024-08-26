package com.luv2code.cruddemo.UselessDAO;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO{
    private final EntityManager entityManager;
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


    @Override
    public List<Student> findByLastName(String lastName) {
       TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where last_name=: theData", Student.class);
       theQuery.setParameter("theData", lastName);
       return theQuery.getResultList();


    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override   @Transactional
    public  int  delAll(){
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}