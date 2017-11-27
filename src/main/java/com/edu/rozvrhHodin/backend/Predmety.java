package com.edu.rozvrhHodin.backend;

import com.edu.rozvrhHodin.repository.entity.Predmet;
import com.edu.rozvrhHodin.repository.entity.Student;

import java.time.DayOfWeek;
import java.util.*;

public class Predmety {
    private Map<String,Predmet> predmets;
    private Scanner sc;

    public Predmety() {
        predmets = new HashMap<String, Predmet>();
        sc = new Scanner(System.in, "Windows-1250");
    }

    public void addPredmet(){
        System.out.println("Zadej zkratku předmětu");
        String abrev = sc.nextLine();
        System.out.println("Zadej jméno predmětu");
        String name = sc.nextLine();
        System.out.println("Zadej jméno učitela");
        String lectorName = sc.nextLine();
        System.out.println("Zadej číslo učebny");
        int roomNO = Integer.parseInt(sc.nextLine());
        System.out.println("Zadej den, kdy bude předmět");
        String dayOfWeek = sc.nextLine();
        System.out.println("Zadej zadej hodinu předmětu");
        int hour = Integer.parseInt(sc.nextLine());
        Predmet predmet = new Predmet(abrev,name,lectorName,roomNO, DayOfWeek.valueOf(dayOfWeek),hour);
        predmets.put(abrev ,predmet);
    }

    public Map<String, Predmet> getPredmets() {
        return predmets;
    }
}
