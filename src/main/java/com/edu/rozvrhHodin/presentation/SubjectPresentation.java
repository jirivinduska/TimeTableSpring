package com.edu.rozvrhHodin.presentation;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.Subject;

import java.util.List;

public interface SubjectPresentation {
    void printSubjects(List<Subject> subjects);
    void printTimeTable(List<Subject> subjects);
    void printTimeTable(List<Subject> subjects1,List<Subject> subjects2);
    void printTimeTableInverted(List<Subject> subjects);
}
