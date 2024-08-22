package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.EmployDAO;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImp implements  EmployeeService{
    private EmployDAO employeedao;
    @Autowired
    public void EmployeeServiceImpl(EmployDAO employDAO){
         this.employeedao = employDAO;
    }
    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeedao.findall();
    }
    @Transactional
    @Override
    public Employee findEmployeeById(int id) {
       return employeedao.findEmployeeById(id);

    }
    @Transactional
    @Override
    public Employee saveEmployee(Employee theEmployee) {
        return employeedao.saveEmployee(theEmployee);
    }
    @Transactional
    @Override
    public Employee deleteEmployeeById(int id) {
        return employeedao.deleteEmployeeById(id);

    }

}
