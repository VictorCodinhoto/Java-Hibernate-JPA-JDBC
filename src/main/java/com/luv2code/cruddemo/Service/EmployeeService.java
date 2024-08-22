package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findEmployeeById(int id);

    Employee saveEmployee(Employee theEmployee);

    Employee deleteEmployeeById(int id);
}
