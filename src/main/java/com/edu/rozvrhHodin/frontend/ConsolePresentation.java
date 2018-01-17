package com.edu.rozvrhHodin.frontend;

public class ConsolePresentation {
    public static void consoleWelcome() {
        System.out.println("-----------------------------------------------WELCOME-----------------------------------------------");
        System.out.println("Všechny příkazy a celé ovládání programu je case sensitive!");
        System.out.println("Zadejte název metody z následujícího výčtu: help, addStudent, addSubject, findAllStudents, findStudent, findAllSubjects,");
        System.out.println(" findStudentSubject, findSubject,findStudentsSubjects, findStudentsOnSubject, deactivateStudent,findFreeTime, editStudent, deleteStudentFromSubject, addStudentToSubject, editSubject");
        System.out.println("Pro ukončení programu napište: end");
        System.out.println("-----------------------------------------------------------------------------------------------------");

    }

    public static void consoleHelp() {
        System.out.println("Příkaz - Co dělá");
        System.out.println("end - ukončí program");
        System.out.println("help - vypíše tuto nápovědu");
        System.out.println("addStudent - přidá studenta");
        System.out.println("addSubject - přidá předmět");
        System.out.println("findAllStudents - vypíše všechny studenty");
        System.out.println("findAllSubjects - vypíše všechny předměty");
        System.out.println("findStudent - vypíše studenta podle zadaného identifikátoru");
        System.out.println("findSubject - vypíše předmět podle zadaného identifikátoru");
        System.out.println("findStudentSubject - vypíše seznam předmětů na které je student zapsaný nebo vypíše jeho rozvrh");
        System.out.println("findStudentsSubjects - vypíše rozvrh dvou vybraných studentů(společné předměty jsou zobrazeny pouze jednou)");
        System.out.println("findStudentsOnSubject - vypíše seznam studentů zapsaných na předmětu");
        System.out.println("findFreeTime - vypíše rozvrh dvou vybraných studentů, zobrazí volný čas");
        System.out.println("deactivateStudent - deaktivuje studenta");
        System.out.println("editStudent - spustí editaci vybraného studenta");
        System.out.println("editSubject - spustí editaci vybraného předmětu");
        System.out.println("addStudentToSubject - zapíše studenta na předmět");
        System.out.println("deleteStudentFromSubject - odepíše studenta z předmětu");


    }

    public static void cannot() {
        System.out.println("Zadaný student je neaktivní, nelze ho přidat na předmět");
    }
}
