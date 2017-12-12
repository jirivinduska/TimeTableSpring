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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaintenanceMan {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Scanner sc;
    EntityManager entityManager;
    StudentSubject sS;
    List<Subject> predmets;
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
        predmets = new ArrayList<Subject>();
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
        Subject pr2 = new Subject("INAR1", "Teorie automatického řízení I", "Tomáš Jedno", 1, DayOfWeek.MONDAY, 2);
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
        //endTransaction();

    }

    public void addStudent(){
        System.out.println("Zadej přihlašovací jméno");
        String username = usernameInput();
        System.out.println("Zadej jméno studenta");
        String firstname = nameInput();
        System.out.println("Zadej přijmení studenta");
        String lastname = nameInput();
        System.out.println("Zadej email studenta");
        String email = emailInput();
        Student student = new Student(username,firstname,lastname,email);
        entityManager.persist(student);
    }
    public void addSubject(){
        startTransaction();
        System.out.println("Zadej zkratku předmětu");
        String abrev = abrevInput();
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
        Subject subject = new Subject(abrev,name,lectorName,roomNo,weekday,hour);
        compareHour(subject);
        entityManager.persist(subject);
        commitTransaction();
        endTransaction();
    }
 private String  usernameInput() {
            String username = sc.nextLine();
            username = username.toLowerCase();
        return username;
 }
 private String nameInput(){
     String name = sc.nextLine();
     if(name.length() < 2){
         System.out.println("Jmeno, příjmení a název předmětu nesmí být jedno písmenné");
         return nameInput();
     }
         name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
         return name;
 }
 private String emailInput(){
     String email = sc.nextLine();
     if (!validate(email)){
         System.out.println("Zadaný text není email!");
         return  emailInput();
     }
         return email;
 }
private String abrevInput(){
    String abrev = sc.nextLine();
    if (abrev.length()>5){
        System.out.println("Zkratka předmětu musí být maximálně pět písmen");
        return abrevInput();
    }
    abrev = abrev.toUpperCase();
    return abrev;
}
private String lectorNameInput(){
    String lectorName = sc.nextLine();
    if(lectorName.length() < 2){
        System.out.println("Jmeno učitele nesmí být kratší než jedno písmeno");
        return nameInput();
    }
    try {
        String name[] = lectorName.split(" ");
        name[0] = name[0].substring(0, 1).toUpperCase() + name[0].substring(1).toLowerCase();
        name[1] = name[1].substring(0, 1).toUpperCase() + name[1].substring(1).toLowerCase();
        lectorName = name[0] + " " + name[1];
    }
    catch (Exception e){
        System.out.println("Zadej jmeno a prijmeni, v zadaném textu musí být mezera");
        return lectorNameInput();
    }
    return lectorName;
}
private int roomNoInput(){
    int number;
    try{
         number = Integer.parseInt(sc.nextLine());
         if (number > 20 || number==0){
             System.out.println("Naše škola má jenom 20 učeben a neexistuje nultá učebna");
             return roomNoInput();
         }

    }
    catch (Exception e){
        System.out.println("Musíš zadat číslo!");
        return roomNoInput();
    }
    return number;
}
    private int hourInput(){
        int number;
        try{
            number = Integer.parseInt(sc.nextLine());
            if (number > 6 || number == 0){
                System.out.println("Naše škola má jenom 6 vyučovacích hodin a nelze mít nultou hodinu");
                return hourInput();
            }

        }
        catch (Exception e){
            System.out.println("Musíš zadat číslo!");
            return hourInput();
        }
        return number;
    }

private DayOfWeek dayOfWeekInput(){
    DayOfWeek dayOfWeek;
    try{
       dayOfWeek = DayOfWeek.valueOf(sc.nextLine().toUpperCase());
    }catch (Exception e){
        System.out.println("Musíš zadat den ve tvaru: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY");
    return dayOfWeekInput();
    }
    return dayOfWeek;
}
private int setNewHour(int hour){
    int newHour = hourInput();
    if(newHour == hour){
        System.out.println("Musíš zadat jinou hodinu než " + hour);
        return setNewHour(hour);
    }
    return newHour;

}
private void compareHour(Subject predmet){
    List<Subject> duplicatesWeekday = new ArrayList<Subject>();
    List<Subject> duplicatesRoom = new ArrayList<Subject>();
    for(Subject subject : predmets)
    {
        if(subject.getWeekday().compareTo(predmet.getWeekday())==0)
        {
            duplicatesWeekday.add(subject);
        }
    }
    for (Subject subject:duplicatesWeekday
         ) {
        if (subject.getRoomNo() == predmet.getRoomNo()){
            duplicatesRoom.add(subject);
        }
    }
    for (Subject subject : duplicatesRoom
            ) {
        if (subject.getHour() == predmet.getHour()){
            System.out.println("Předmět " + subject.getName() + " je v tento den, v této místnosti v této hodině("+subject.getHour()+")");
            System.out.println("Zadej jinou hodinu");
            predmet.setHour(setNewHour(subject.getHour()));
            compareHour(predmet);
            break;

        }
    }

}


    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
}
