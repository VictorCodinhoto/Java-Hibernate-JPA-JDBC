package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImp;
import com.luv2code.cruddemo.entity.Student;
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

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
		   //createStudent(studentDAO);
//		   createMultipleStudents(studentDAO);
//		   //readStudent(studentDAO);
//		   readAllStudent(studentDAO);
//		   queryStudentsByLastName(studentDAO);
//		   updateStudent(studentDAO);
//		   deleteStudent(studentDAO);
//		   deletE(studentDAO);
		};

	}

	private void deletE(StudentDAO studentDAO) {
		studentDAO.delAll();
		System.out.println("All deleted.");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Scanner sc = new Scanner(System.in);
		int id;
		System.out.println("Digite o id que está buscando: ");
		id = sc.nextInt();
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Scanner sc = new Scanner(System.in);
		int studentID;
		String newFirstName;
		System.out.println("Digite o ID: ");
		studentID = sc.nextInt();

		Student theStudent  =  studentDAO.findById(studentID);


		System.out.println("Digite o novo firstname: ");
		newFirstName = sc.nextLine();
		theStudent.setFirstName(newFirstName);

		studentDAO.update(theStudent);

		sc.close();






	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escreva o ultimo nome: ");
		String lastname = sc.nextLine();
		 List<Student> theStudents =  studentDAO.findByLastName(lastname);
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
		sc.close();
	}

	private void readAllStudent(StudentDAO studentDAO) {
		System.out.println("Getting All the Students!");
		List<Student> theStudents = studentDAO.findAll();
		for(Student tempStudent : theStudents){
				System.out.println(tempStudent);
		}
	}

	private  void readStudent(StudentDAO studentDAO){
		System.out.println("Getting Student Data...");
		Student tempStudent = new Student("Cro","Ny","cronycodinhoto@hotmail.com");
		studentDAO.save(tempStudent);
		int theId = tempStudent.getId();
		Student Student =studentDAO.findById(theId);
	}
	private void createMultipleStudents(StudentDAO studentDAO){
		Scanner sc = new Scanner(System.in);
		int i = 1;
		String firstName,lastName,email;

		while (i == 1){
			System.out.println("Digite 1 para cadastrar um novo usuário, 2 para parar de cadastrar!");
			i = sc.nextInt();
			sc.nextLine();
			if(i == 2){
				break;
            }
			System.out.println("Digite seu primeiro nome: ");
			firstName = sc.nextLine();
			System.out.println("Obrigado!");
			System.out.println("Digite seu último nome: ");
			lastName =  sc.nextLine();
			System.out.println("Obrigado!");
			System.out.println("Por último, digite seu email: ");
			email = sc.nextLine();
			System.out.println("Obrigado!");

			Student tempStudent = new Student(firstName,lastName,email);
			studentDAO.save(tempStudent);
			System.out.println("Cadastro Realizado! ID do estudante: " + tempStudent.getId());

		}
		sc.close();

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student!");

		Student tempStudent = new Student("Victor","Codinhoto","victorcodinhoto@gmail.com");

		System.out.println("Salving your new Student!");
		studentDAO.save(tempStudent);

		System.out.println("The new Id is createad with number:" + tempStudent.getId());
	}
}
