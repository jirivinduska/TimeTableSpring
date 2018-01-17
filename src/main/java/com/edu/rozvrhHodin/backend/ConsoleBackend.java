package com.edu.rozvrhHodin.backend;

import com.edu.rozvrhHodin.frontend.ConsolePresentation;
import com.edu.rozvrhHodin.repository.RepositoryLocator;
import com.edu.rozvrhHodin.service.ServiceLocator;
import com.edu.rozvrhHodin.service.StudentService;

import javax.xml.ws.Service;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ConsoleBackend {
    private Scanner sc = new Scanner(System.in, "UTF-8");

    public boolean methodReader() {
        System.out.println("Zadej jmeno metody:");
        String string = sc.nextLine();

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

    private void addStudent() {
        ServiceLocator.getStudentService().addStudent();
    }

    private void addSubject() {
        ServiceLocator.getSubjectService().addSubject();
    }

    private void editStudent() {
        System.out.println("Zadejte ID studenta:");
        Long id = ConsoleService.idInput();
        ServiceLocator.getStudentService().editStudentByID(id);
    }

    private void editSubject() {
        System.out.println("Zadejte ID předmětu:");
        Long id = ConsoleService.idInput();
        ServiceLocator.getSubjectService().editSubjectByID(id);
    }

    private void findStudent() {
        System.out.println("Podle čeho chcete hledat? (ID, firstName, lastName, userName nebo firstLastName): ");
        ConsoleService.findStudentSwitch();
    }

    private void findSubject() {
        System.out.println("Podle čeho chcete hledat? (ID, abbrev, name, hour, lectorName, roomNo, weekday): ");
        ConsoleService.findSubjectSwitch();
    }

    private void findAllStudents() {
        ServiceLocator.getStudentService().printAllStudents();
    }

    private void findAllSubjects() {
        ServiceLocator.getSubjectService().printAllSubjects();
    }

    private void findFreeTime() {
        System.out.println("Zadejte ID prvního studenta:");
        Long id1;
        id1 = ConsoleService.idInput();
        System.out.println("Zadejte ID druhého studenta:");
        Long id2;
        id2 = ConsoleService.idInput();
        ServiceLocator.getSubjectService().printTimeTableStudents(id1, id2, true);
    }

    private void findStudentSubject() {
        System.out.println("Zadejte ID studenta:");
        Long id;
        id = ConsoleService.idInput();
        System.out.println("Chete vypsat rozvrh studenta? (true/false)");
        ConsoleService.findStudentSubjectSwitch(id);

    }

    private void findStudentsSubjects() {
        System.out.println("Zadejte ID prvního studenta:");
        Long id1;
        id1 = ConsoleService.idInput();
        System.out.println("Zadejte ID druhého studenta:");
        Long id2;
        id2 = ConsoleService.idInput();
        ServiceLocator.getSubjectService().printTimeTableStudents(id1, id2, false);
    }

    private void findStudentsOnSubject() {
        System.out.println("Zadejte ID předmětu:");
        Long id;
        id = ConsoleService.idInput();
        ServiceLocator.getStudentService().printStudentBySubject(id);
    }

    private void deactivateStudent() {
        System.out.println("Zadejte ID studenta:");
        Long id;
        id = ConsoleService.idInput();
        ServiceLocator.getStudentService().deactivateStudentByID(id);
    }

    private void addStudentToSubject() {
        System.out.println("Zadejte ID studenta:");
        Long idStudent = ConsoleService.idInput();
        System.out.println("Zadejte ID předmětu:");
        Long idSubject = ConsoleService.idInput();
        ServiceLocator.getStudentSubjectService().addStudentOnSubject(idStudent, idSubject);
    }

    private void deleteStudentFromSubject() {
        System.out.println("Zadejte ID studenta:");
        Long idStudent = ConsoleService.idInput();
        System.out.println("Zadejte ID předmětu:");
        Long idSubject = ConsoleService.idInput();
        ServiceLocator.getStudentSubjectService().deleteStudentSubject(idStudent, idSubject);
    }

    private void help() {
        ConsolePresentation.consoleHelp();
    }

}
