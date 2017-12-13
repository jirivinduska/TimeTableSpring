package com.edu.rozvrhHodin;



import com.edu.rozvrhHodin.backend.MaintenanceMan;
import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.Subject;
import com.edu.rozvrhHodin.service.ServiceLocator;

import javax.persistence.EntityManager;
import java.time.DayOfWeek;
import java.util.*;

//https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console

public class Main {

    public static void main(String[] args) {


      MaintenanceMan mM = new MaintenanceMan();

     mM.initMain();

      //  mM.addStudent();
     //  mM.addSubject();

     /*   List<Subject> predmets = new ArrayList<Subject>();
        Subject pr1 = new Subject("INSZD", "Statistické metody zpracování dat", "Prokop Dveře", 1, DayOfWeek.MONDAY, 1);
        predmets.add(pr1);
        Subject pr2 = new Subject("INAR1", "Teorie automatického řízení I", "Tomáš Jedno", 1, DayOfWeek.MONDAY, 2);
        predmets.add(pr2);
        Subject pr3 = new Subject("INVKM", "Vybrané kapitoly z matematiky", "Kamil Čůral", 3, DayOfWeek.TUESDAY, 4);
        predmets.add(pr3);
        Subject pr4 = new Subject("INZM", "Základy mechatroniky", "Jarmila Okapová", 1, DayOfWeek.THURSDAY, 4);
        predmets.add(pr4);
*/

     //   List<Student> students = new ArrayList<Student>();

        //Vytváření studentů
/*        Student st1 = new Student("st1","Bernard","Škorpík","Bernard@skorpik.cz");
        students.add(st1);
        Student st2 = new Student("st2","Svatopluk","Kubát","Svatopluk@Kubat.cz");
        students.add(st2);
        Student st3 = new Student("st3","Ambrož","Andrle","Ambroz@Andrle.cz");
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-25s |%n";

        System.out.format("+-----------------+-----------------+-----------------+---------------------------+%n");
        System.out.format("| UserName        | First name      | Last name       | email                     |%n");
        System.out.format("+-----------------+-----------------+-----------------+---------------------------+%n");
        for (Student student:students
             ) {
            System.out.format(leftAlignFormat, student.getUserName(), student.getFirstName(),student.getLastName(),student.getEmail());
        }
        System.out.format("+-----------------+-----------------+-----------------+---------------------------+%n");*/
/*int[][] cisla= new int[6][6];
String[][] timetable = new String[6][7];
timetable[0][0] = "   xxx ";
for (int i = 1;i<timetable.length;i++){
    timetable[i][0]=DayOfWeek.of(i).toString();

}
     for (int j = 1;j<timetable[0].length;j++) {
            int time = 7+ j;
                    timetable[0][j]=String.format("  %d - %d ",time,time+1);
  }

        for (int i = 1;i<timetable.length;i++){
            for (int j = 1;j<timetable[i].length;j++){

                    for (Subject subject : predmets
                            ) {
                        if (i == subject.getWeekday().getValue()) {
                            if (j == subject.getHour())
                                timetable[i][j] = subject.getAbrev();
                        }
                    }
            }
        }
        for (int i = 0;i<timetable.length;i++){
            for (int j = 0;j<timetable[i].length;j++){
                String string = timetable[i][j];
                System.out.printf("%-10s|", string);
            }
            System.out.println();
        }*/



        ServiceLocator.shutdown();

    }

}
