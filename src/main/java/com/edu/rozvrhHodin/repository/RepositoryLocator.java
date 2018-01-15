package com.edu.rozvrhHodin.repository;

import com.edu.rozvrhHodin.repository.entity.Student;

public class RepositoryLocator {

    private static StudentRepository studentRepository;
    private static SubjectRepository subjectRepository;
    private static StudentSubjectRepository studentSubjectRepository;
    public RepositoryLocator() {
    }

    public static StudentRepository getStudentRepository(){
        if (studentRepository == null) {
            studentRepository = new StudentRepositoryImpl();
        }

        return studentRepository;
    }

    public static SubjectRepository getSubjectRepository(){
        if (subjectRepository == null) {
            subjectRepository = new SubjectRepositoryImpl();
        }

        return subjectRepository;
    }

    public static StudentSubjectRepository getStudentSubjectRepository(){
        if (studentSubjectRepository == null) {
            studentSubjectRepository = new StudentSubjectRepositoryImpl();
        }

        return studentSubjectRepository;
    }


}
