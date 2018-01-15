package com.edu.rozvrhHodin.frontend;

public class ConsolePresentation {
    public static void consoleWelcome(){
        System.out.println("-----------------------------------------------WELCOME-----------------------------------------------");
        System.out.println("Zadejte název metody z následujícího výčtu: help, addStudent, addSubject, findAllStudents, findStudent, findAllSubjects");
        System.out.println("Pro ukončení programu napište: end");
        System.out.println("-----------------------------------------------------------------------------------------------------");

    }
    public static void consoleHelp(){
        System.out.println("Zadejte název metody z následujícího výčtu: help, addStudent, addSubject, findAllStudents, findStudent");
        System.out.println("Pro ukončení programu napište: end");
    }
}
