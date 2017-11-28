package com.edu.rozvrhHodin.backend;

import com.edu.rozvrhHodin.frontend.ConsoleWriter;
import com.edu.rozvrhHodin.repository.entity.Predmet;
import com.edu.rozvrhHodin.repository.entity.Student;

import java.time.DayOfWeek;
import java.util.Scanner;

public class Guts {
    int menu;
    int podmenu;
    Scanner sc = new Scanner(System.in, "Windows-1250");
    public void initMain(Studenti studenti, Predmety predmety){
        for (DayOfWeek den : DayOfWeek.values()
                ) {
            if (den == DayOfWeek.SATURDAY)
                break;
            predmety.getPredmets().add(new Predmet("TV", "Telocvik", "Stojan Jakotyc", 2, den, 1));
            predmety.getPredmets().add(new Predmet("TV", "Telocvik", "Stojan Jakotyc", 2, den, 2));
            for (int i = 1; i < 3; i++) {
                predmety.getPredmets().add(new Predmet("ALG", "Algoritmizace", "Tomáš Houby", 1, den, 0 + i));
                predmety.getPredmets().add(new Predmet("PROG", "Programovani", "Prokop Buben", 2, den, 1 + i));
            }
        }
        studenti.getStudents().put("LOJZA", new Student("LOJZA", "Lojza", "Cumil", "asdfda"));
        studenti.getStudents().get("LOJZA").getPredmety().add(predmety.getPredmets().get(1));
        studenti.getStudents().get("LOJZA").getPredmety().add(predmety.getPredmets().get(2));
        studenti.getStudents().put("KUBA", new Student("KUBA", "Kuba", "Kubícek", "asdfda"));
        studenti.getStudents().get("KUBA").getPredmety().add(predmety.getPredmets().get(2));
        studenti.getStudents().get("KUBA").getPredmety().add(predmety.getPredmets().get(29));

    }

    public boolean menuReader(Studenti studenti, Predmety predmety) {
        menu = sc.nextInt();
        switch (menu) {
            case 1:
                studenti.addStudent();
                return true;
            case 2:
                predmety.addPredmet();
                return true;
            case 3:
                ConsoleWriter.informationWriter();
                //TODO
                databaseSwitch();
                return true;
            case 4:
                //TODO
                return true;
            case 5:
                //TODO
                return true;
            case 6:
                //TODO

                return true;
            case 7:
                //TODO

                return true;
            case 8:
                //TODO

                return true;

            default:
                return false;

        }

    }

    public void databaseSwitch() {
        podmenu = sc.nextInt();
        switch (podmenu) {
            case 1:
                //TODO

            case 2:

                //TODO
            case 3:

                //TODO


            case 4:
                //TODO

            case 5:
                //TODO

            case 6:
                //TODO


            case 7:
                //TODO


            case 8:
                //TODO
            case 9:
                System.out.println("musim to dodelat");


            default:
                break;

        }
    }

}
