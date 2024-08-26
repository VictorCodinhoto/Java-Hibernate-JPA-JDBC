package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.EmployRep;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements  EmployeeService{
    private EmployRep EmployRep;
    @Autowired
    public void EmployeeServiceImpl(EmployRep employRep){
         this.EmployRep = employRep;
    }

    @Override
    public List<Employee> findAll() {
        return EmployRep.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> result = EmployRep.findById(id);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }else{
            throw  new RuntimeException("Employee is not present: " +id );
        }

        return employee;

    }

    @Override
    public Employee saveEmployee(Employee theEmployee) {
        return EmployRep.save(theEmployee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        EmployRep.deleteById(id);


    }

}
