package com.edu.rozvrhHodin.presentation;

import com.edu.rozvrhHodin.repository.entity.Student;

import java.util.List;

public class StudentPresentationImpl implements StudentPresentation{
    public void printStudents(List<Student> students) {
        System.out.format("+------+-----------------+-----------------+-----------------+---------------------------+-----------------+%n");
        System.out.format("| Id   | UserName        | First name      | Last name       | Email                     | Active          |%n");
        System.out.format("+------+-----------------+-----------------+-----------------+---------------------------+-----------------+%n");
        String leftAlignFormat = "| %-4s | %-15s | %-15s | %-15s | %-25s |%-15s  |%n";
        for (Student student:students
                ) {
            if (student!=null)
                System.out.format(leftAlignFormat,student.getId().toString(), student.getUserName(), student.getFirstName(),student.getLastName(),student.getEmail(),student.getActive());


        }
        System.out.format("+------+-----------------+-----------------+-----------------+---------------------------+-----------------+%n");
    }

}
