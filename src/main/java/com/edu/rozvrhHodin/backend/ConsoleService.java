package com.edu.rozvrhHodin.backend;

import com.edu.rozvrhHodin.service.ServiceLocator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleService {
    private static Scanner sc = new Scanner(System.in, "UTF-8");
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static String usernameInput() {
        String username = sc.nextLine();
        username = username.toLowerCase();
        return username;
    }

    public static String nameInput() {
        String name = sc.nextLine();
        if (name.length() < 2) {
            System.out.println("Jmeno, příjmení a název předmětu nesmí být jedno písmenné");
            return nameInput();
        }
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }

    public static String emailInput() {
        String email = sc.nextLine();
        if (!validate(email)) {
            System.out.println("Zadaný text není email! Očekává vstup ve tvaru email@email.cz");
            return emailInput();
        }
        return email;
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static String abbrevInput() {
        String abbrev = sc.nextLine();
        if (abbrev.length() > 5) {
            System.out.println("Zkratka předmětu musí být maximálně pět písmen");
            return abbrevInput();
        }
        abbrev = abbrev.toUpperCase();
        return abbrev;
    }

    public static String lectorNameInput() {
        String lectorName = sc.nextLine();
        if (lectorName.length() < 2) {
            System.out.println("Jmeno učitele nesmí být kratší než jedno písmeno");
            return lectorNameInput();
        }
        try {
            String name[] = lectorName.split(" ");
            name[0] = name[0].substring(0, 1).toUpperCase() + name[0].substring(1).toLowerCase();
            name[1] = name[1].substring(0, 1).toUpperCase() + name[1].substring(1).toLowerCase();
            lectorName = name[0] + " " + name[1];
        } catch (Exception e) {
            System.out.println("Zadej jmeno a prijmeni, v zadaném textu musí být mezera");
            return lectorNameInput();
        }
        return lectorName;
    }

    public static int roomNoInput() {
        int number;
        try {
            number = Integer.parseInt(sc.nextLine());
            if (number > 20 || number == 0) {
                System.out.println("Naše škola má jenom 20 učeben a neexistuje nultá učebna");
                return roomNoInput();
            }

        } catch (Exception e) {
            System.out.println("Musíš zadat číslo!");
            return roomNoInput();
        }
        return number;
    }

    public static Long idInput() {
        Long id;
        try {
            id = Long.parseLong(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Musíš zadat číslo!");
            return idInput();
        }
        return id;
    }

    public static int hourInput() {
        int number;
        try {
            number = Integer.parseInt(sc.nextLine());
            if (number > 6 || number == 0) {
                System.out.println("Naše škola má jenom 6 vyučovacích hodin a nelze mít nultou hodinu");
                return hourInput();
            }

        } catch (Exception e) {
            System.out.println("Musíš zadat číslo!");
            return hourInput();
        }
        return number;
    }

    public static DayOfWeek dayOfWeekInput() {
        DayOfWeek dayOfWeek;
        try {
            dayOfWeek = DayOfWeek.valueOf(sc.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Musíš zadat den ve tvaru: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY");
            return dayOfWeekInput();
        }
        if (dayOfWeek.compareTo(DayOfWeek.SATURDAY) == 0 || dayOfWeek.compareTo(DayOfWeek.SUNDAY) == 0) {
            System.out.println("Vyučování se nekoná o víkendu!");
            return dayOfWeekInput();
        }

        return dayOfWeek;
    }

    public static int setNewHour(int hour) {
        int newHour = hourInput();
        if (newHour == hour) {
            System.out.println("Musíš zadat jinou hodinu než " + hour);
            return setNewHour(hour);
        }
        return newHour;

    }

    public static boolean findStudentSwitch() {
        String string = sc.nextLine();
        switch (string) {
            case "ID":
                System.out.println("Zadejte ID: ");
                Long id = ConsoleService.idInput();
                ServiceLocator.getStudentService().printStudentByID(id);
                break;
            case "firstName":
                System.out.println("Zadejte jméno: ");
                String firstName = ConsoleService.nameInput();
                ServiceLocator.getStudentService().printStudentByFirstName(firstName);
                break;
            case "lastName":
                System.out.println("Zadejte příjmení: ");
                String lastName = ConsoleService.nameInput();
                ServiceLocator.getStudentService().printStudentByLastName(lastName);
                break;
            case "userName":
                System.out.println("Zadejte přihlašovací jméno: ");
                String userName = ConsoleService.usernameInput();
                ServiceLocator.getStudentService().printStudentByUserName(userName);
                break;
            case "firstLastName":
                System.out.println("Zadejte jméno: ");
                String firstName1 = ConsoleService.nameInput();
                System.out.println("Zadejte příjmení: ");
                String lastName1 = ConsoleService.nameInput();
                ServiceLocator.getStudentService().printStudentByFistNameLastName(firstName1, lastName1);
                break;
            default:
                System.out.println("Musíte zadat: ID, firstName, lastName, userName nebo firstLastName");
                return findStudentSwitch();
        }
        return true;
    }

    public static void findStudentSubjectSwitch(Long id) {
        String string = sc.nextLine();
        if (string.equals("true"))
            ServiceLocator.getSubjectService().printTimeTableStudent(id);
        else
            ServiceLocator.getSubjectService().printSubjectByStudent(id);


    }

    public static boolean findSubjectSwitch() {
        String string = sc.nextLine();
        switch (string) {
            case "ID":
                System.out.println("Zadejte ID: ");
                Long id = ConsoleService.idInput();
                ServiceLocator.getSubjectService().printSubjectByID(id);
                break;
            case "abbrev":
                System.out.println("Zadejte abbrev: ");
                String abbrev = ConsoleService.abbrevInput();
                ServiceLocator.getSubjectService().printSubjectByAbbrev(abbrev);
                break;
            case "name":
                System.out.println("Zadejte jméno předmětu: ");
                String name = ConsoleService.nameInput();
                ServiceLocator.getSubjectService().printSubjectByName(name);
                break;
            case "hour":
                System.out.println("Zadejte hodinu předmětu: ");
                int hour = ConsoleService.hourInput();
                ServiceLocator.getSubjectService().printSubjectByHour(hour);
                break;
            case "lectorName":
                System.out.println("Zadejte vyučujícího předmětu: ");
                String lectorName = ConsoleService.lectorNameInput();
                ServiceLocator.getSubjectService().printSubjectByLectorName(lectorName);
                break;
            case "roomNo":
                System.out.println("Zadejte číslo místnosti předmětu: ");
                int roomNoInput = ConsoleService.roomNoInput();
                ServiceLocator.getSubjectService().printSubjectByRoomNo(roomNoInput);
                break;

            case "weekday":
                System.out.println("Zadejte den předmětu(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY): ");
                DayOfWeek dayOfWeek = ConsoleService.dayOfWeekInput();
                ServiceLocator.getSubjectService().printSubjectByDayOfWeek(dayOfWeek);
                break;
            default:
                System.out.println("Musíte zadat: ID, abbrev, name, hour, lectorName, roomNo, weekday");
                return findSubjectSwitch();
        }
        return true;
    }

    public static void initConsole() {
        ServiceLocator.getStudentService().prepareData();
        ServiceLocator.getSubjectService().prepareData();
        ServiceLocator.getStudentSubjectService().prepareData();
    }

    public static String editUsername(String username) {
        String newUsername = sc.nextLine();
        if (newUsername.equals(""))
            return username;
        newUsername = newUsername.toLowerCase();
        return newUsername;
    }

    public static String editName(String name) {
        String newName = sc.nextLine();
        if (newName.equals(""))
            return name;
        if (newName.length() < 2) {
            System.out.println("Jmeno, příjmení a název předmětu nesmí být jedno písmenné");
            return editName(name);
        }
        newName = newName.substring(0, 1).toUpperCase() + newName.substring(1).toLowerCase();
        return newName;
    }

    public static String editEmail(String email) {
        String newEmail = sc.nextLine();
        if (newEmail.equals(""))
            return email;
        if (!validate(newEmail)) {
            System.out.println("Zadaný text není email! Očekává vstup ve tvaru email@email.cz");
            return editEmail(email);
        }
        return newEmail;
    }

    public static String editAbbrev(String abbrev) {
        String newAbbrev = sc.nextLine();
        if (newAbbrev.equals(""))
            return abbrev;
        if (newAbbrev.length() > 5) {
            System.out.println("Zkratka předmětu musí být maximálně pět písmen");
            return editAbbrev(abbrev);
        }
        newAbbrev = newAbbrev.toUpperCase();
        return newAbbrev;
    }

    public static String editLectorName(String lectorName) {
        String newLectorName = sc.nextLine();
        if (newLectorName.equals(""))
            return lectorName;
        if (newLectorName.length() < 2) {
            System.out.println("Jmeno učitele nesmí být kratší než jedno písmeno");
            return editLectorName(lectorName);
        }
        try {
            String name[] = newLectorName.split(" ");
            name[0] = name[0].substring(0, 1).toUpperCase() + name[0].substring(1).toLowerCase();
            name[1] = name[1].substring(0, 1).toUpperCase() + name[1].substring(1).toLowerCase();
            newLectorName = name[0] + " " + name[1];
        } catch (Exception e) {
            System.out.println("Zadej jmeno a prijmeni, v zadaném textu musí být mezera");
            return editLectorName(lectorName);
        }
        return newLectorName;

    }

    public static int editHour(int hour) {
        int newHour;
        String string = sc.nextLine();
        if (string.equals(""))
            return hour;
        try {
            newHour = Integer.parseInt(string);
            if (newHour > 6 || newHour == 0) {
                System.out.println("Naše škola má jenom 6 vyučovacích hodin a nelze mít nultou hodinu");
                return editHour(hour);
            }

        } catch (Exception e) {
            System.out.println("Musíš zadat číslo!");
            return editHour(hour);
        }
        return newHour;

    }

    public static int editRoomNo(int roomNo) {
        int newRoomNo;
        String string = sc.nextLine();
        if (string.equals(""))
            return roomNo;
        try {
            newRoomNo = Integer.parseInt(string);
            if (newRoomNo > 20 || newRoomNo == 0) {
                System.out.println("Naše škola má jenom 20 učeben a neexistuje nultá učebna");
                return editRoomNo(roomNo);
            }

        } catch (Exception e) {
            System.out.println("Musíš zadat číslo!");
            return editRoomNo(roomNo);
        }
        return newRoomNo;
    }

    public static DayOfWeek editDayOfWeek(DayOfWeek dayOfWeek) {
        DayOfWeek newDayOfWeek;
        String string = sc.nextLine();
        if (string.equals(""))
            return dayOfWeek;
        try {
            newDayOfWeek = DayOfWeek.valueOf(string.toUpperCase());
        } catch (Exception e) {
            System.out.println("Musíš zadat den ve tvaru: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY");
            return editDayOfWeek(dayOfWeek);
        }
        if (newDayOfWeek.compareTo(DayOfWeek.SATURDAY) == 0 || newDayOfWeek.compareTo(DayOfWeek.SUNDAY) == 0) {
            System.out.println("Vyučování se nekoná o víkendu!");
            return editDayOfWeek(dayOfWeek);
        }

        return newDayOfWeek;
    }

}
