package com.edu.rozvrhHodin.service;

import com.edu.rozvrhHodin.presentation.PresentationLocator;
import com.edu.rozvrhHodin.repository.RepositoryLocator;
import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.Subject;

import javax.persistence.EntityManager;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.edu.rozvrhHodin.backend.ConsoleService.*;

public class SubjectServiceImpl implements SubjectService {

    public void printAllSubjects() {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findAllSubject();
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }

    public void printSubjectByName(String name) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByName(name);
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }

    public void printSubjectByAbbrev(String abbrev) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByAbbrev(abbrev);
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }

    public void printSubjectByID(Long id) {
        List<Subject> subjects = new ArrayList<Subject>();
        Subject subject = RepositoryLocator.getSubjectRepository().findByID(id);
        subjects.add(subject);
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }


    public void printSubjectByRoomNo(int roomNo) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByRoomNo(roomNo);
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }


    public void printSubjectByHour(int hour) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByHour(hour);
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }


    public void printSubjectByDayOfWeek(DayOfWeek dayOfWeek) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByWeekday(dayOfWeek);
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }


    public void printSubjectByLectorName(String lectorName) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByLectorName(lectorName);
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }

    public void printSubjectByStudent(Long id) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByStudent(id);
        PresentationLocator.getSubjectPresentation().printSubjects(subjects);
    }


    public void printTimeTableStudent(Long id) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByStudent(id);
        ServiceLocator.getStudentService().printStudentByID(id);
        PresentationLocator.getSubjectPresentation().printTimeTable(subjects);
    }


    public void printTimeTableStudents(Long id1, Long id2, boolean inverted) {
        List<Subject> subjects1 = RepositoryLocator.getSubjectRepository().findByStudent(id1);
        List<Subject> subjects2 = RepositoryLocator.getSubjectRepository().findByStudent(id2);

        for (Subject subject : subjects2) {
            if (!subjects1.contains(subject))
                subjects1.add(subject);
        }
        ServiceLocator.getStudentService().printStudentByID(id1);
        ServiceLocator.getStudentService().printStudentByID(id2);
        if (!inverted)
            PresentationLocator.getSubjectPresentation().printTimeTable(subjects1);
        else
            PresentationLocator.getSubjectPresentation().printTimeTableInverted(subjects1);
    }

    public void addSubject() {
        System.out.println("Zadej zkratku předmětu");
        String abbrev = abbrevInput();
        System.out.println("Zadej název předmětu");
        String name = nameInput();
        System.out.println("Zadej jméno vyučujícího");
        String lectorName = lectorNameInput();
        System.out.println("Zadej číslo učebny");
        int roomNo = roomNoInput();
        System.out.println("Zadej den, kdy se bude předmět konat");
        DayOfWeek weekday = dayOfWeekInput();
        System.out.println("Zadej hodinu, kdy se bude předmět konat");
        int hour = hourInput();
        Subject subject = new Subject(abbrev, name, lectorName, roomNo, weekday, hour);
        compareHourAndDayOfWeek(subject);
        saveSubject(subject);
    }


    public void editSubjectByID(Long id) {
        Subject subject = RepositoryLocator.getSubjectRepository().findByID(id);
        System.out.println("Zadej zkratku předmětu, prázdný text pro pokračování bez změny.");
        String abbrev = editAbbrev(subject.getAbbrev());
        subject.setAbbrev(abbrev);
        System.out.println("Zadej název předmětu, prázdný text pro pokračování bez změny.");
        String name = editName(subject.getName());
        subject.setName(name);
        System.out.println("Zadej jméno vyučujícího, prázdný text pro pokračování bez změny.");
        String lectorName = editLectorName(subject.getLectorName());
        subject.setLectorName(lectorName);
        System.out.println("Zadej číslo učebny, prázdný text pro pokračování bez změny.");
        int roomNo = editRoomNo(subject.getRoomNo());
        subject.setRoomNo(roomNo);
        System.out.println("Zadej den, kdy se bude předmět konat, prázdný text pro pokračování bez změny.");
        DayOfWeek weekday = editDayOfWeek(subject.getWeekday());
        subject.setWeekday(weekday);
        System.out.println("Zadej hodinu, kdy se bude předmět konat, prázdný text pro pokračování bez změny.");
        int hour = editHour(subject.getHour());
        if (hour == subject.getHour())
            subject.setHour(hour);
        else {
            subject.setHour(hour);
            compareHourAndDayOfWeek(subject);
        }
        saveSubject(subject);
    }

    public void prepareData() {
        List<Subject> subjects = new ArrayList<Subject>();
        Subject pr1 = new Subject("INSZD", "Statistické metody zpracování dat", "Prokop Dveře", 1, DayOfWeek.MONDAY, 1);
        subjects.add(pr1);
        Subject pr2 = new Subject("INAR1", "Teorie automatického řízení I", "Tomáš Jedno", 1, DayOfWeek.MONDAY, 2);
        subjects.add(pr2);
        Subject pr3 = new Subject("INVKM", "Vybrané kapitoly z matematiky", "Kamil Čůral", 3, DayOfWeek.TUESDAY, 4);
        subjects.add(pr3);
        Subject pr4 = new Subject("INZM", "Základy mechatroniky", "Jarmila Okapová", 1, DayOfWeek.TUESDAY, 4);
        subjects.add(pr4);
        Subject pr5 = new Subject("INMRF", "Marketingové řízení firmy", "Ludmila Chovaná", 1, DayOfWeek.WEDNESDAY, 1);
        subjects.add(pr5);
        Subject pr6 = new Subject("INAPE", "Ochrana osobních dat a autorských práv", "Bohdan Prosil", 1, DayOfWeek.THURSDAY, 2);
        subjects.add(pr6);
        Subject pr7 = new Subject("INPI", "Podniková informatika", "Viktor Šourek", 4, DayOfWeek.FRIDAY, 2);
        subjects.add(pr7);
        Subject pr8 = new Subject("INAR3", "Teorie automatického řízení III", "Amadeus Mozart", 1, DayOfWeek.FRIDAY, 3);
        subjects.add(pr8);
        Subject pr9 = new Subject("INLC2", "Laboratorní cvičení z oboru II", "Ignác Cézar", 2, DayOfWeek.THURSDAY, 3);
        subjects.add(pr9);
        Subject pr10 = new Subject("INSEP", "Semestrální projekt", "Mitch Bjůkenen", 2, DayOfWeek.WEDNESDAY, 3);
        subjects.add(pr10);
        for (Subject subject : subjects
                ) {
            saveSubject(subject);

        }
    }

    public void saveSubject(Subject subject) {
        RepositoryLocator.getSubjectRepository().saveSubject(subject);
    }


    private void compareHourAndDayOfWeek(Subject predmet) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByHourAndDayOfWeek(predmet.getHour(), predmet.getWeekday(), predmet.getRoomNo());
        for (Subject subject : subjects) {
            if (subject.getHour() == predmet.getHour()) {
                System.out.println("Předmět " + subject.getName() + " je v tento den (" + subject.getWeekday().toString() + "), v této místnosti v této hodině(" + subject.getHour() + ")");
                System.out.println("Zadej jinou hodinu");
                predmet.setHour(setNewHour(subject.getHour()));
                compareHourAndDayOfWeek(predmet);
                break;

            }
        }


    }
}
