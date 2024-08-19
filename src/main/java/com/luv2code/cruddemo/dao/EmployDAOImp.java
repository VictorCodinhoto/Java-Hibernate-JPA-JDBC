package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployDAOImp implements  EmployDAO{
    private EntityManager entityManager;
    @Autowired
    public void EmployeeDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findall() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("From entity",Employee.class);
        return theQuery.getResultList();
    }
}
