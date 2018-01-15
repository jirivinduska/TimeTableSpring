package com.edu.rozvrhHodin.presentation;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.Subject;

import java.util.List;

public class SubjectPresentationImpl implements SubjectPresentation {
    public void printSubjects(List<Subject> subjects) {
        System.out.format("+------+----------+----------------------------------------------------+-----------------+--------+-----------------+------+%n");
        System.out.format("| Id   | Abbrev   | Name                                               | Lector Name     | RoomNo | WeekDay         |Hour  |%n");
        System.out.format("+------+----------+----------------------------------------------------+-----------------+--------+-----------------+------+%n");
        String leftAlignFormat = "| %-4s | %-8s | %-50s | %-15s | %-4s   |%-15s  |%-4s  |%n";
        for (Subject subject:subjects
                ) {
            if (subject!=null)
                System.out.format(leftAlignFormat,subject.getId(),subject.getAbbrev(),subject.getName(),subject.getLectorName(),subject.getRoomNo(),subject.getWeekday().toString(),subject.getHour());

        }
        System.out.format("+------+----------+----------------------------------------------------+-----------------+--------+-----------------+------+%n");
    }
}
