package com.edu.rozvrhHodin;



import com.edu.rozvrhHodin.backend.MaintenanceMan;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.service.ServiceLocator;

import javax.persistence.EntityManager;
import java.util.Map;

//https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console

public class Main {

    public static void main(String[] args) {


        MaintenanceMan mM = new MaintenanceMan();
       mM.startTransaction();
     //   mM.initMain();

       // mM.addStudent();
        mM.addSubject();
       mM.commitTransaction();
        mM.endTransaction();








        ServiceLocator.shutdown();


    }

}
