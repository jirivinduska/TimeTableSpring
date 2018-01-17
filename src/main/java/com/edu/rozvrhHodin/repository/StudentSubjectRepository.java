package com.edu.rozvrhHodin.repository;

import com.edu.rozvrhHodin.repository.entity.StudentSubject;

public interface StudentSubjectRepository {

    StudentSubject findStudentOnSubject(Long idStudent,Long idSubject);
    void saveStudentSubject(StudentSubject studentSubject);
    void deleteStudentSubject(StudentSubject studentSubject);
}
