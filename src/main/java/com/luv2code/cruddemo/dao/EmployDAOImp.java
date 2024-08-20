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

    @Override
    public Employee findEmployeeById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee saveEmployee(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public Employee deleteEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
        return employee;
    }
}
