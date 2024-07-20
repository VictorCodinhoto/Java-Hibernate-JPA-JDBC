package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImp;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
		   createStudent(studentDAO);

		};

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student!");

		Student tempStudent = new Student("Victor","Codinhoto","victorcodinhoto@gmail.com");

		System.out.println("Salving your new Student!");
		studentDAO.save(tempStudent);

		System.out.println("The new Id is createad with number: " + tempStudent.getId());
	}
}
