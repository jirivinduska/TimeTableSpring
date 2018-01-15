package com.edu.rozvrhHodin.backend;

import com.edu.rozvrhHodin.frontend.ConsolePresentation;
import com.edu.rozvrhHodin.service.ServiceLocator;
import com.edu.rozvrhHodin.service.StudentService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ConsoleBackend {
    private Scanner sc = new Scanner(System.in, "UTF-8");

    public  boolean methodReader(){
        System.out.println("Zadej jmeno metody:");
        String string =  sc.nextLine();

        if (string.equals("end"))
            return false;

        try {
            Method method = this.getClass().getDeclaredMethod(string);
            try {
                method.invoke(this);
            } catch (InvocationTargetException e) {
                //throw new RuntimeException(e);
                System.out.println("Not such class");
                return false;
            }
        } catch (NoSuchMethodException e) {
            // throw new RuntimeException(e);
            System.out.println("Not such method");
            return methodReader();
        } catch (IllegalAccessException e) {
            // throw new RuntimeException(e);
            System.out.println("Illegal Access");
            return false;
        }

        return true;

    }

    private void addStudent(){
        ServiceLocator.getStudentService().addStudent();
    }
    private void addSubject(){
        ServiceLocator.getSubjectService().addSubject();
    }
    private void editStudent(){

    }
    private void editSubject(){

    }
    private void findStudent(){
        System.out.println("Podle čeho chcete hledat? (ID,firstName,lastName, userName nebo firstLastName): ");
        ConsoleService.findStudentSwitch();
    }


    private void findSubject(){

    }

    private void findAllStudents(){
        ServiceLocator.getStudentService().printAllStudents();
    }

    private void findAllSubjects(){
        ServiceLocator.getSubjectService().printAllSubjects();
    }

    private void findFreeTime(){

    }
    private void findStudentSubject(){

    }

    private void findStudentsSubjects(){

    }

    private void findStudentsOnSubject(){
        System.out.println("Zadejte ID předmětu:");
        Long id;
        id = ConsoleService.idInput();
        ServiceLocator.getStudentService().printStudentBySubject(id);
    }

    private void deactivateStudent(){

    }

    private void addStudentToSubject(){

    }

    private void deleteStudentFromSubject(){

    }

    private void help(){
        ConsolePresentation.consoleHelp();
    }

}
