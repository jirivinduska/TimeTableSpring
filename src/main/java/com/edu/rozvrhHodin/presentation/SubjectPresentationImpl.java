package com.edu.rozvrhHodin.presentation;

import com.edu.rozvrhHodin.frontend.ConsolePresentation;
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


                timetable[i][j] = fillTimeTable(j, i, subjects);

            }


        }
        ConsolePresentation.printTimeTable(timetable, false);
    }

    public void printTimeTable(List<Subject> subjects1, List<Subject> subjects2) {
        String[][] timetable = new String[11][7];
        timetable[0][0] = "-Rozvrh-";
        int day = 1;
        for (int i = 1; i < timetable.length; i++) {
            timetable[i][0] = DayOfWeek.of(day).toString();
            if ((i % 2) == 0)
                day++;
        }
        day = 1;
        for (int j = 1; j < timetable[0].length; j++) {
            int time = 7 + j;
            timetable[0][j] = String.format("%d - %d ", time, time + 1);
        }

        for (int i = 1; i < timetable.length; i += 2) {

            for (int j = 1; j < timetable[i].length; j++) {

                timetable[i][j] = fillTimeTable(j, day, subjects1);
            }
            day++;
        }
        day = 1;
        for (int i = 2; i < timetable.length; i+= 2) {

            for (int j = 1; j < timetable[i].length; j++) {

                timetable[i][j] = fillTimeTable(j, day, subjects2);
            }
            day++;
        }

        ConsolePresentation.printTimeTable(timetable, false);
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
        ConsolePresentation.printTimeTable(timetable, true);
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

    private String fillTimeTable(int hour, int day, List<Subject> subjects) {
        String string = null;
        for (Subject subject : subjects
                ) {
            if (day == subject.getWeekday().getValue()) {
                if (hour == subject.getHour())
                    string = subject.getAbbrev();
            }
        }
        return string;
    }
}
