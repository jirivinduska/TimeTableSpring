package com.edu.rozvrhHodin.presentation;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.Subject;

import java.time.DayOfWeek;
import java.util.List;

public class SubjectPresentationImpl implements SubjectPresentation {
    public void printSubjects(List<Subject> subjects) {
        System.out.format("+------+----------+----------------------------------------------------+-----------------+--------+-----------------+------+%n");
        System.out.format("| Id   | Abbrev   | Name                                               | Lector Name     | RoomNo | WeekDay         |Hour  |%n");
        System.out.format("+------+----------+----------------------------------------------------+-----------------+--------+-----------------+------+%n");
        String leftAlignFormat = "| %-4s | %-8s | %-50s | %-15s | %-4s   |%-15s  |%-4s  |%n";
        for (Subject subject : subjects
                ) {
            if (subject != null)
                System.out.format(leftAlignFormat, subject.getId(), subject.getAbbrev(), subject.getName(), subject.getLectorName(), subject.getRoomNo(), subject.getWeekday().toString(), subject.getHour());

        }
        System.out.format("+------+----------+----------------------------------------------------+-----------------+--------+-----------------+------+%n");
    }


    public void printTimeTable(List<Subject> subjects) {
        String[][] timetable = timeTablePreparation();
        for (int i = 1; i < timetable.length; i++) {
            for (int j = 1; j < timetable[i].length; j++) {

                for (Subject subject : subjects
                        ) {
                    if (i == subject.getWeekday().getValue()) {
                        if (j == subject.getHour())
                            timetable[i][j] = subject.getAbbrev();
                    }
                }
            }
        }

        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < timetable.length; i++) {
            for (int j = 0; j < timetable[i].length; j++) {
                String string = timetable[i][j];
                if (string == null)
                    System.out.printf("|      %-10s |", " xxx ");
                else
                    System.out.printf("|      %-10s |", string);
            }
            System.out.println();
        }
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------+");
    }


    public void printTimeTableInverted(List<Subject> subjects) {
        String[][] timetable = timeTablePreparation();
        for (int i = 1; i < timetable.length; i++) {
            for (int j = 1; j < timetable[i].length; j++) {

                for (Subject subject : subjects
                        ) {
                    if (i == subject.getWeekday().getValue()) {
                        if (j == subject.getHour())
                            timetable[i][j] = " xxx";
                    }
                }
            }
        }
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < timetable.length; i++) {
            for (int j = 0; j < timetable[i].length; j++) {
                String string = timetable[i][j];
                if (string == null)
                    System.out.printf("|      %-10s |", " Volno ");
                else
                    System.out.printf("|      %-10s |", string);
            }
            System.out.println();
        }
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------+");
    }


    private String[][] timeTablePreparation() {

        String[][] timetable = new String[6][7];
        timetable[0][0] = "-Rozvrh-";

        for (int i = 1; i < timetable.length; i++) {
            timetable[i][0] = DayOfWeek.of(i).toString();
        }

        for (int j = 1; j < timetable[0].length; j++) {
            int time = 7 + j;
            timetable[0][j] = String.format("%d - %d ", time, time + 1);
        }

        return timetable;
    }
}
