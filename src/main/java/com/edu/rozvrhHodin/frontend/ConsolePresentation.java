package com.edu.rozvrhHodin.frontend;

import com.edu.rozvrhHodin.repository.entity.Subject;

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
        System.out.println("findStudentsSubjects - vypíše rozvrh dvou vybraných studentů");
        System.out.println("findStudentsOnSubject - vypíše seznam studentů zapsaných na předmětu");
        System.out.println("findFreeTime - vypíše rozvrh dvou vybraných studentů, zobrazí volný čas");
        System.out.println("deactivateStudent - deaktivuje studenta");
        System.out.println("editStudent - spustí editaci vybraného studenta");
        System.out.println("editSubject - spustí editaci vybraného předmětu");
        System.out.println("addStudentToSubject - zapíše studenta na předmět");
        System.out.println("deleteStudentFromSubject - odepíše studenta z předmětu");


    }

    public static void studentNull() {
        System.out.println("Zadaný student neexistuje!");
    }
    public static void subjectNull() {
        System.out.println("Zadaný předmět neexistuje!");
    }
    public static void studentDeactivated() {
        System.out.println("Zadaný student je neaktivní!");
    }
    public static void studentSubjectNull() {
        System.out.println("Zadaná kombinace studenta a předmětu neexistuje!");
    }

    public static void userNameInput(boolean input) {
        if (input)
            System.out.println("Zadej přihlašovací jméno");
        else
            System.out.println("Zadej přihlašovací jméno, prázdný text pro pokračování bez změny.");
    }

    public static void firstNameInput(boolean input) {
        if (input)
            System.out.println("Zadej jméno studenta");
        else
            System.out.println("Zadej jméno studenta, prázdný text pro pokračování bez změny.");
    }

    public static void lastNameInput(boolean input) {
        if (input)
            System.out.println("Zadej příjmení studenta");
        else
            System.out.println("Zadej přijmení studenta, prázdný text pro pokračování bez změny.");
    }

    public static void emailInput(boolean input) {
        if (input)
            System.out.println("Zadej email studenta");
        else
            System.out.println("Zadej email studenta, prázdný text pro pokračování bez změny.");
    }
    public static void abbrevInput(boolean input){
        if (input)
            System.out.println("Zadej zkratku předmětu");
        else
            System.out.println("Zadej zkratku předmětu, prázdný text pro pokračování bez změny.");
    }
    public static void nameInput(boolean input){
        if (input)
            System.out.println("Zadej název předmětu");
        else
            System.out.println("Zadej název předmětu, prázdný text pro pokračování bez změny.");
    }
    public static void lectorNameInput(boolean input){
        if (input)
            System.out.println("Zadej jméno vyučujícího");
        else
            System.out.println("Zadej jméno vyučujícího, prázdný text pro pokračování bez změny.");
    }
    public static void roomNoInput(boolean input){
        if (input)
            System.out.println("Zadej číslo učebny");
        else
            System.out.println("Zadej číslo učebny, prázdný text pro pokračování bez změny.");
    }
    public static void dayOfWeekInput(boolean input){
        if (input)
            System.out.println("Zadej den, kdy se bude předmět konat");
        else
            System.out.println("Zadej den, kdy se bude předmět konat, prázdný text pro pokračování bez změny.");
    }
    public static void hourInput(boolean input){
        if (input)
            System.out.println("Zadej hodinu, kdy se bude předmět konat");
        else
            System.out.println("Zadej hodinu, kdy se bude předmět konat, prázdný text pro pokračování bez změny.");
    }
    public static void compateHourDayOfWeekRoomNo(Subject subject){
        System.out.println("Předmět " + subject.getName() + " je v tento den (" + subject.getWeekday().toString() + "), v této místnosti v této hodině(" + subject.getHour() + ").");
        System.out.println("Zadej jinou hodinu:");
    }
    public static void compareHourDayOdWeekStudent(){
        System.out.println("Student v tento den a hodinu již má předmět.");
        System.out.println("Zadej jiný předmět:");
    }

    public static void printTimeTable(String timetable[][],boolean freetime){
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < timetable.length; i++) {
            for (int j = 0; j < timetable[i].length; j++) {
                String string = timetable[i][j];
                if (string == null)
                    if (freetime)
                        System.out.printf("|      %-10s |", " Volno ");
                    else
                        System.out.printf("|      %-10s |", " xxx ");
                else {
                    System.out.printf("|      %-10s |", string);

                }
            }
            System.out.println();
        }
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------+");

    }

}
