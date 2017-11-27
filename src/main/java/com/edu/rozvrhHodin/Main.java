package com.edu.rozvrhHodin;

import com.edu.rozvrhHodin.backend.Predmety;
import com.edu.rozvrhHodin.backend.Studenti;
import com.edu.rozvrhHodin.repository.entity.Predmet;
import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.service.ServiceLocator;

import javax.persistence.EntityManager;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

//https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = ServiceLocator.createEntityManager();
        entityManager.getTransaction().begin();


        Studenti studenti = new Studenti();
        Predmety predmety = new Predmety();
        predmety.addPredmet();
        studenti.addStudent();
        studenti.getStudents().get("K").getPredmety().add(predmety.getPredmets().get("A"));






        for(Map.Entry<String, Student> entry : studenti.getStudents().entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            entityManager.persist(value);
            // do what you have to do here
            // In your case, another loop.
        }



        entityManager.getTransaction().commit();
        entityManager.close();
        ServiceLocator.shutdown();


    }
}
