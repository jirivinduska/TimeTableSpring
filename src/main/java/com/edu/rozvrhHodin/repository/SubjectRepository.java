package com.edu.rozvrhHodin.repository;

import com.edu.rozvrhHodin.repository.entity.Subject;

import java.time.DayOfWeek;
import java.util.List;

public interface SubjectRepository {
    
    List<Subject> findAllSubject();
    List<Subject> findByHourAndDayOfWeek(int hour, DayOfWeek dayOfWeek);
    Subject findByID(Long id);
    List<Subject> findByAbbrev(String abbrev);
    List<Subject> findByName(String name);
    List<Subject> findByStudent(Long id);

    void saveSubject(Subject subject);


}
