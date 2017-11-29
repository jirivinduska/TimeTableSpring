package com.edu.rozvrhHodin.backend;


import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.StudentSubject;
import com.edu.rozvrhHodin.repository.entity.Subject;
import com.edu.rozvrhHodin.service.ServiceLocator;
import sun.nio.cs.StandardCharsets;

import javax.persistence.EntityManager;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class MaintenanceMan {
    Scanner sc;
    EntityManager entityManager;
    StudentSubject sS;
    public MaintenanceMan() {
        sc = new Scanner(System.in, "UTF-8");
        entityManager = ServiceLocator.createEntityManager();
        Subject freeTime = new Subject("VOLNO", "VOLNO");
        entityManager.persist(freeTime);
        sS = new StudentSubject();
    }
    public void startTransaction(){
        entityManager.getTransaction().begin();
    }
    public void commitTransaction(){
        entityManager.getTransaction().commit();
    }
    public void endTransaction(){
        entityManager.close();
    }
    public void initMain(){
        List<Student> students = new ArrayList<Student>();
        List<Subject> predmets = new ArrayList<Subject>();
        startTransaction();
      //Vytváření studentů
        Student st1 = new Student("st1","Bernard","Škorpík","Bernard@skorpik.cz");
        students.add(st1);
        Student st2 = new Student("st2","Svatopluk","Kubát","Svatopluk@Kubat.cz");
        students.add(st2);
        Student st3 = new Student("st3","Ambrož","Andrle","Ambroz@Andrle.cz");
        students.add(st3);
        Student st4 = new Student("st4","Stanislav","Zadražil","Stanislav@Zadrazil.cz");
        students.add(st4);
        Student st5 = new Student("st5","Tamara","Škrabalová","Tamara@skrabalova.cz");
        students.add(st5);
        Student st6 = new Student("st6","Bořek","Brabenec","Borek@Brabenec.cz");
        students.add(st6);
        Student st7 = new Student("st7","Alois","Vosátka","Alois@Vosatka.cz");
        students.add(st7);
        Student st8 = new Student("st8","Tadeáš","Štípek","Tadeas@stipek.cz");
        students.add(st8);
        Student st9 = new Student("st9","Bohdana","Větrovcová","Bohdana@Vetrovcova.cz");
        students.add(st9);
        Student st10 = new Student("st10","Soběslav","Jirásek","Sobeslav@Jirasek.cz");
        students.add(st10);
        for (Student student:students
             ) {
            entityManager.persist(student);
        }
        //Vytváření předmětů
        Subject pr1 = new Subject("INSZD", "Statistické metody zpracování dat", "Prokop Dveře", 1, DayOfWeek.MONDAY, 1);
        predmets.add(pr1);
        Subject pr2 = new Subject("INAR1", "Teorie automatického řízení I", "Tomáš Jedno", 2, DayOfWeek.MONDAY, 2);
        predmets.add(pr2);
        Subject pr3 = new Subject("INVKM", "Vybrané kapitoly z matematiky", "Kamil Čůral", 3, DayOfWeek.TUESDAY, 4);
        predmets.add(pr3);
        Subject pr4 = new Subject("INZM", "Základy mechatroniky", "Jarmila Okapová", 1, DayOfWeek.TUESDAY, 4);
        predmets.add(pr4);
        Subject pr5 = new Subject("INMRF", "Marketingové řízení firmy", "Ludmila Chovaná", 1, DayOfWeek.WEDNESDAY, 1);
        predmets.add(pr5);
        Subject pr6 = new Subject("INAPE", "Ochrana osobních dat a autorských práv", "Bohdan Prosil", 1, DayOfWeek.THURSDAY, 2);
        predmets.add(pr6);
        Subject pr7 = new Subject("INPI", "Podniková informatika", "Viktor Šourek", 4, DayOfWeek.FRIDAY, 2);
        predmets.add(pr7);
        Subject pr8 = new Subject("INAR3", "Teorie automatického řízení III", "Amadeus Mozart", 1, DayOfWeek.FRIDAY, 3);
        predmets.add(pr8);
        Subject pr9 = new Subject("INLC2", "Laboratorní cvičení z oboru II", "Ignác Cézar", 2, DayOfWeek.THURSDAY, 3);
        predmets.add(pr9);
        Subject pr10 = new Subject("INSEP", "Semestrální projekt", "Mitch Bjůkenen", 2, DayOfWeek.WEDNESDAY, 3);
        predmets.add(pr10);
        for (Subject subject : predmets
                ) {
            entityManager.persist(subject);

        }


        sS.setSubject(pr1);
        sS.setStudent(st1);
        sS.setClassHour(pr1.getHour());
        sS.setWeekday(pr1.getWeekday());
        sS.setModificationDate(Calendar.getInstance());


        entityManager.persist(sS);
        entityManager.flush();
        commitTransaction();
        endTransaction();

    }

    public void addStudent(){
        System.out.println("Zadej přihlašovací jméno");
        String username = sc.nextLine();
        System.out.println("Zadej jméno studenta");
        String firstname = sc.nextLine();
        System.out.println("Zadej přijmení studenta");
        String lastname = sc.nextLine();
        System.out.println("Zadej email studenta");
        String email = sc.nextLine();
        Student student = new Student(username,firstname,lastname,email);
        entityManager.persist(student);
    }
    public void addSubject(){
        System.out.println("Zadej zkratku předmětu");
        String abrev = sc.nextLine();
        System.out.println("Zadej název předmětu");
        String name = sc.nextLine();
        System.out.println("Zadej jméno vyučujícího");
        String lectorName = sc.nextLine();
        System.out.println("Zadej číslo učebny");
        int roomNo = Integer.parseInt(sc.nextLine());
        System.out.println("Zadej den, kdy se bude předmět konat");
        DayOfWeek weekday = DayOfWeek.valueOf(sc.nextLine());
        System.out.println("Zadej hodinu, kdy se bude předmět konat");
        int hour = Integer.parseInt(sc.nextLine());
        Subject subject = new Subject(abrev,name,lectorName,roomNo,weekday,hour) ;
        entityManager.persist(subject);
    }
    public void freeTime(){

    }
}
