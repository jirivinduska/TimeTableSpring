package com.edu.rozvrhHodin.service;

import com.edu.rozvrhHodin.repository.entity.StudentSubject;

public interface StudentSubjectService {

    void addStudentOnSubject(Long idStudent,Long idSubject);

    void deleteStudentSubject(Long idStudent,Long idSubject);

    void prepareData();

    void saveStudentSubject(StudentSubject studentSubject);

}
