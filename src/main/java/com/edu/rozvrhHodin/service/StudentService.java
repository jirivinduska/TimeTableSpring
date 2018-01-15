package com.edu.rozvrhHodin.service;

import com.edu.rozvrhHodin.repository.entity.Student;

import java.beans.Customizer;

public interface StudentService {
    void printAllStudents();

    void printStudentByID(Long id);
    void printStudentByFirstName(String firstName);
    void printStudentByLastName(String lastName);
    void printStudentByUserName(String userName);
    void printStudentByFistNameLastName(String firstName,String lastName);

    void printStudentBySubject(Long id);

    void deactivateStudentByID(Long id);
    void deactivateStudentByFirstName(String firstName);
    void deactivateStudentByLastName(String lastName);
    void deactivateStudentByFirstNameLastName(String firstName,String lastName);

    void addStudent();

    void editStudentByID(Long id);
    void editStudentByFirstName(String firstName);
    void editStudentByLastName(String lastName);
    void editStudentByFirstNameLastName(String firstName,String lastName);

    void prepareData();

    void saveStudent(Student student);


}
