package com.edu.rozvrhHodin.service;

import com.edu.rozvrhHodin.backend.ConsoleService;
import com.edu.rozvrhHodin.presentation.PresentationLocator;
import com.edu.rozvrhHodin.repository.RepositoryLocator;
import com.edu.rozvrhHodin.repository.entity.Student;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.edu.rozvrhHodin.backend.ConsoleService.*;


public class StudentServiceImpl implements StudentService {

    public void printAllStudents() {
        List<Student> students = RepositoryLocator.getStudentRepository().findAllStudents();
        PresentationLocator.getStudentPresentation().printStudents(students);
    }

    public void printStudentByID(Long id) {
        List<Student> students = new ArrayList<Student>();
        Student student = RepositoryLocator.getStudentRepository().findByID(id);
        students.add(student);
        PresentationLocator.getStudentPresentation().printStudents(students);
    }


    public void printStudentByFirstName(String firstName) {
        List<Student> students = RepositoryLocator.getStudentRepository().findByFirstName(firstName);
        PresentationLocator.getStudentPresentation().printStudents(students);
    }

    public void printStudentByLastName(String lastName) {
        List<Student> students = RepositoryLocator.getStudentRepository().findByLastName(lastName);
        PresentationLocator.getStudentPresentation().printStudents(students);
    }

    public void printStudentBySubject(Long id) {
        List<Student> students = RepositoryLocator.getStudentRepository().findBySubject(id);
        PresentationLocator.getStudentPresentation().printStudents(students);
    }

    public void printStudentByUserName(String userName) {
        List<Student> students = RepositoryLocator.getStudentRepository().findByUserName(userName);
        PresentationLocator.getStudentPresentation().printStudents(students);
    }

    public void printStudentByFistNameLastName(String firstName, String lastName) {
        List<Student> students = RepositoryLocator.getStudentRepository().findByFirstNameAndLastName(firstName,lastName);
        PresentationLocator.getStudentPresentation().printStudents(students);
    }

    public void deactivateStudentByID(Long id) {
        Student student = RepositoryLocator.getStudentRepository().findByID(id);
        student.deactivate();
        saveStudent(student);
    }

    public void deactivateStudentByFirstName(String firstName) {
        List<Student> students = RepositoryLocator.getStudentRepository().findByFirstName(firstName);
        for (Student student:students
             ) {
            student.deactivate();
            saveStudent(student);
        }
    }

    public void deactivateStudentByLastName(String lastName) {
        List<Student> students = RepositoryLocator.getStudentRepository().findByLastName(lastName);
        for (Student student:students
                ) {
            student.deactivate();
            saveStudent(student);
        }
    }

    public void deactivateStudentByFirstNameLastName(String firstName, String lastName) {
        List<Student> students = RepositoryLocator.getStudentRepository().findByFirstNameAndLastName(firstName,lastName);
        for (Student student:students
                ) {
            student.deactivate();
            saveStudent(student);
        }
    }

    public void addStudent() {
        System.out.println("Zadej přihlašovací jméno");
        String username = usernameInput();
        System.out.println("Zadej jméno studenta");
        String firstname = nameInput();
        System.out.println("Zadej přijmení studenta");
        String lastname = nameInput();
        System.out.println("Zadej email studenta");
        String email = emailInput();
        Student student = new Student(username, firstname, lastname, email);
        saveStudent(student);
    }

    public void editStudentByID(Long id) {

    }

    public void editStudentByFirstName(String firstName) {

    }

    public void editStudentByLastName(String lastName) {

    }

    public void editStudentByFirstNameLastName(String firstName, String lastName) {

    }

    public void prepareData() {
        List<Student> students = new ArrayList<Student>();
        Student st1 = new Student("st1", "Bernard", "Škorpík", "Bernard@skorpik.cz");
        students.add(st1);
        Student st2 = new Student("st2", "Svatopluk", "Kubát", "Svatopluk@Kubat.cz");
        students.add(st2);
        Student st3 = new Student("st3", "Ambrož", "Andrle", "Ambroz@Andrle.cz");
        students.add(st3);
        Student st4 = new Student("st4", "Stanislav", "Zadražil", "Stanislav@Zadrazil.cz");
        students.add(st4);
        Student st5 = new Student("st5", "Tamara", "Škrabalová", "Tamara@skrabalova.cz");
        students.add(st5);
        Student st6 = new Student("st6", "Bořek", "Brabenec", "Borek@Brabenec.cz");
        students.add(st6);
        Student st7 = new Student("st7", "Alois", "Vosátka", "Alois@Vosatka.cz");
        students.add(st7);
        Student st8 = new Student("st8", "Tadeáš", "Štípek", "Tadeas@stipek.cz");
        students.add(st8);
        Student st9 = new Student("st9", "Bohdana", "Větrovcová", "Bohdana@Vetrovcova.cz");
        students.add(st9);
        Student st10 = new Student("st10", "Soběslav", "Jirásek", "Sobeslav@Jirasek.cz");
        students.add(st10);
        for (Student student : students
                ) {
            saveStudent(student);
        }
    }

    public void saveStudent(Student student) {
        RepositoryLocator.getStudentRepository().saveStudent(student);
    }


}
