package com.luv2code.cruddemo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EntityScan(basePackages = "com.luv2code.cruddemo.entity")
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
//		return runner -> {
//		   //createStudent(studentDAO);
////		   createMultipleStudents(studentDAO);
////		   //readStudent(studentDAO);
////		   readAllStudent(studentDAO);
////		   queryStudentsByLastName(studentDAO);
////		   updateStudent(studentDAO);
////		   deleteStudent(studentDAO);
////		   deletE(studentDAO);
//		};

}



