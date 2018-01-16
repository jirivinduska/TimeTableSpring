package com.edu.rozvrhHodin.service;

import com.edu.rozvrhHodin.repository.entity.Subject;

import java.time.DayOfWeek;

public interface SubjectService {
    void printAllSubjects();

    void printSubjectByName(String name);
    void printSubjectByAbbrev(String abbrev);
    void printSubjectByID(Long id);
    void printSubjectByRoomNo(int roomNo);
    void printSubjectByHour(int hour);
    void printSubjectByDayOfWeek(DayOfWeek dayOfWeek);
    void printSubjectByLectorName(String lectorName);

    void printSubjectByStudent(Long id);
    void printTimeTableStudent(Long id);
    void printTimeTableStudents(Long id1,Long id2);

    void addSubject();


    void editSubjectByID(Long id);

    void prepareData();

    void saveSubject(Subject subject);
}
