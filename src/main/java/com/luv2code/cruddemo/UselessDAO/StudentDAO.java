package com.luv2code.cruddemo.UselessDAO;

import com.luv2code.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student studentDAO);

     Student findById(Integer ID);

     List<Student> findAll();

     List<Student> findByLastName(String lastName);

     void update(Student theStudent);


     void delete(Integer id);

     int delAll();
}
