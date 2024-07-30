package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImp;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;

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
	private void createMultipleStudents(StudentDAO studentDAO){
		Scanner sc = new Scanner(System.in);
		int i = 1;
		String firstName,lastName,email;

		while (i == 1){
			System.out.println("Digite 1 para cadastrar um novo usuário, 2 para parar de cadastrar!");
			i = sc.nextInt();
			if(i == 2){
				break;
			}
			System.out.println("Digite seu primeiro nome: ");
			firstName = sc.nextLine();
			System.out.println("Digite seu último nome: ");
			lastName =  sc.nextLine();
			System.out.println("Por último, digite seu email: ");
			email = sc.nextLine();

			Student tempStudent = new Student(firstName,lastName,email);
			studentDAO.save(tempStudent);
			System.out.println("Cadastro Realizado! ID do estudante: " + tempStudent.getId());
		}

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student!");

		Student tempStudent = new Student("Victor","Codinhoto","victorcodinhoto@gmail.com");

		System.out.println("Salving your new Student!");
		studentDAO.save(tempStudent);

		System.out.println("The new Id is createad with number:" + tempStudent.getId());
	}
}
