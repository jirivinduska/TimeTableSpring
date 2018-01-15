package com.edu.rozvrhHodin.service;

import com.edu.rozvrhHodin.repository.entity.Subject;

public interface SubjectService {
    void printAllSubjects();

    void printSubjectByName(String name);
    void printSubjectByAbbrev(String abbrev);
    void printSubjectByID(Long id);

    void printSubjectByStudent(Long id);

    void addSubject();

    void editSubjectByName(String name);
    void editSubjectByAbbrev(String abbrev);
    void editSubjectByID(Long id);

    void prepareData();

    void saveSubject(Subject subject);
}
