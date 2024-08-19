package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Student;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    @GetMapping("/HelloWorld")
    public String helloWorld(){
        return "Hello World!";
    }

   
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new java.util.ArrayList<>(List.of());
        theStudents.add(new Student("Victor","Batista","vitorcodinhoto@outlook.com"));
        theStudents.add(new Student("Victor","Codinhoto","vitorcodinhoto@g.com"));

    }


    @GetMapping("/Students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("Student/{studentId}")
    public Student getStudent(int studentId){
        if(studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student not found " + studentId);
        }
        return theStudents.get(studentId);
    }

}
