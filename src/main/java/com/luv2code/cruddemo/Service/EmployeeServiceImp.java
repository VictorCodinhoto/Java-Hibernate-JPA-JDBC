package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImp implements  EmployeeService{
    private EmployeeService employeeService;
    @Autowired
    public void EmployeeServiceImpl(EmployeeService employeeService){
         this.employeeService = employeeService;
    }
    @Override
    public List<Employee> findall() {
        return employeeService.findall();
    }

}
