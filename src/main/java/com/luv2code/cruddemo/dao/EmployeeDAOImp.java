package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImp implements  EmployeeDAO{
    private EntityManager entityManager;

    public  EmployeeDAOImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM employee",Employee.class);

        List<Employee> employee = theQuery.getResultList();


        return employee;
    }
}
