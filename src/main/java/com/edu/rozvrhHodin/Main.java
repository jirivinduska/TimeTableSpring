package com.edu.rozvrhHodin;



import com.edu.rozvrhHodin.backend.ConsoleBackend;
import com.edu.rozvrhHodin.backend.ConsoleService;
import com.edu.rozvrhHodin.frontend.ConsolePresentation;
import com.edu.rozvrhHodin.service.ServiceLocator;

//https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console

public class Main {

    public static void main(String[] args) {
        ConsoleBackend consoleBackend = new ConsoleBackend();

       ConsoleService.initConsole();
        ConsolePresentation.consoleWelcome();
        while(consoleBackend.methodReader());
//ServiceLocator.getStudentService().printStudentBySubject(1l);
//ServiceLocator.getSubjectService().printTimeTableStudent(1l);

        ServiceLocator.shutdown();

    }

}
