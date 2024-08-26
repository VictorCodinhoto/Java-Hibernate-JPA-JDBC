package com.luv2code.cruddemo.UselessDAO;

import com.luv2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployDAO {
    List<Employee> findall();

    Employee findEmployeeById(int id);

    Employee saveEmployee(Employee theEmployee);

    Employee deleteEmployeeById(int id);
}
