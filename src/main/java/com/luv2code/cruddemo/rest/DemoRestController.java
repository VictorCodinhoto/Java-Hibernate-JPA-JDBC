package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.Service.EmployeeService;
import com.luv2code.cruddemo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.*;

@RestController
public class DemoRestController {
    //@GetMapping("/HelloWorld")
//    public String helloWorld(){
//        return "Hello World!";
//    }
//
//
//    private List<Student> theStudents;
//
//    @PostConstruct
//    public void loadData(){
//        theStudents = new java.util.ArrayList<>(List.of());
//        theStudents.add(new Student("Victor","Batista","vitorcodinhoto@outlook.com"));
//        theStudents.add(new Student("Victor","Codinhoto","vitorcodinhoto@g.com"));
//
//    }
//
//
//    @GetMapping("/Students")
//    public List<Student> getStudents(){
//        return theStudents;
//    }
//
//    @GetMapping("Student/{studentId}")
//    public Student getStudent(int studentId){
//        if(studentId >= theStudents.size() || studentId < 0){
//            throw new StudentNotFoundException("Student not found " + studentId);
//        }
//        return theStudents.get(studentId);
//    }
//    private EmployDAO employDAO;
//    public DemoRestController(EmployDAO employDAO){
//        this.employDAO = employDAO;
//    }
//
    private  EmployeeService employeeService;
    @Autowired
    public void EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    @GetMapping("/employees")
    public  List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{Id}")
    public Employee getEmployee(@PathVariable() int Id){
        Employee employee = employeeService.findEmployeeById(Id);
        if(employee == null){
            throw new RuntimeException("Employ Id Not Found " + Id);
        }
        return employee;

    }
    @PostMapping("/employees")
    //Sempre set o id para 0 para ele não se transformar em um update, mas sim em um new, o JDBC IRÁ TRATAR ISSO
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.saveEmployee(employee);
    }
    @PutMapping("/employees")
    // Quando não set o id para 0 ele atualiza um existente
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.saveEmployee(theEmployee);


    }
    @DeleteMapping("employees/{Id}")
    public String deleteEmployee(@PathVariable  Integer Id){
        Employee employee =  employeeService.findEmployeeById(Id);
        if(employee == null){
            throw new RuntimeException("Id not found");
        }
        employeeService.deleteEmployeeById(employee.getId());
        return "Employ " + employee.getId() + " Deleted";
    }
}
