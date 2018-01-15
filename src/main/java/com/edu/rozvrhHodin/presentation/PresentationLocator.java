package com.edu.rozvrhHodin.presentation;

import com.edu.rozvrhHodin.repository.StudentRepository;
import com.edu.rozvrhHodin.repository.StudentRepositoryImpl;
import com.edu.rozvrhHodin.repository.entity.Subject;

public class PresentationLocator {
    private static StudentPresentation studentPresentation;
    private static SubjectPresentation subjectPresentation;

    public PresentationLocator() {

    }

    public static StudentPresentation getStudentPresentation(){
        if (studentPresentation == null) {
            studentPresentation = new StudentPresentationImpl();
        }

        return studentPresentation;
    }
    public static SubjectPresentation getSubjectPresentation(){
        if (subjectPresentation == null) {
            subjectPresentation = new SubjectPresentationImpl();
        }

        return subjectPresentation;
    }

    }

