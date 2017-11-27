package com.edu.rozvrhHodin.backend;

import com.edu.rozvrhHodin.repository.entity.Student;

import java.util.*;

public class Studenti {
    private Map<String ,Student> students;
    private Scanner sc;

    public Studenti() {
        students = new HashMap<String, Student>();
        sc = new Scanner(System.in, "Windows-1250");

    }
    public void addStudent(){
        System.out.println("Zadej jméno studenta");
        String jmeno = sc.nextLine();
        System.out.println("Zadej příjmení studenta");
        String prijmeni = sc.nextLine();
        System.out.println("Zadej přihlašovací jméno studenta");
        String username  = sc.nextLine();
        System.out.println("Zadej email studenta");
        String email  = sc.nextLine();
        Student student = new Student(username,jmeno,prijmeni,email);
        students.put(username ,student);

    }

    public Map<String, Student> getStudents() {
        return students;
    }
}
