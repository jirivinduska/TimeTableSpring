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

      //  mM.initMain();

      //  mM.addStudent();
       mM.addSubject();

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

      //  ServiceLocator.shutdown();

    }

}
