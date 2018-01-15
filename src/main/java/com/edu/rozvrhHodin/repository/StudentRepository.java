package com.edu.rozvrhHodin.repository;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.Subject;

import java.util.List;

public interface StudentRepository {



    List<Student> findAllStudents();
    Student findByID(Long id);
    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByUserName(String userName);
    List<Student> findBySubject(Long id);
    List<Student> findByFirstNameAndLastName(String firstName,String lastName);
    
    
    void saveStudent(Student student);
}
