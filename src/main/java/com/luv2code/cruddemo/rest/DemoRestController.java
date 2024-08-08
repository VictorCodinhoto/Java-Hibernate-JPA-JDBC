package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    @GetMapping("/HelloWorld")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/Students")
    public List<Student> getStudents(){
        List<Student> theStudents = new java.util.ArrayList<>(List.of());
        theStudents.add(new Student("Victor","Batista","vitorcodinhoto@outlook.com"));
        theStudents.add(new Student("Victor","Codinhoto","vitorcodinhoto@g.com"));
        return theStudents;
    }
}
