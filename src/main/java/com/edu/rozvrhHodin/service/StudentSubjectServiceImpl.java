package com.edu.rozvrhHodin.service;

import com.edu.rozvrhHodin.frontend.ConsolePresentation;
import com.edu.rozvrhHodin.repository.RepositoryLocator;
import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.StudentSubject;
import com.edu.rozvrhHodin.repository.entity.Subject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class StudentSubjectServiceImpl implements StudentSubjectService {


    public void addStudentOnSubject(Long idStudent, Long idSubject) {
        StudentSubject studentSubject = new StudentSubject();
        Subject subject = RepositoryLocator.getSubjectRepository().findByID(idSubject);
        Student student = RepositoryLocator.getStudentRepository().findByID(idStudent);
        if (student.getActive()) {
            studentSubject.setSubject(subject);
            studentSubject.setStudent(student);
            studentSubject.setWeekday(subject.getWeekday());
            studentSubject.setClassHour(subject.getHour());
            studentSubject.setModificationDate(Calendar.getInstance());
            saveStudentSubject(studentSubject);
        } else
            ConsolePresentation.cannot();
    }


    public void deleteStudentSubject(Long idStudent, Long idSubject) {
        StudentSubject studentSubject = RepositoryLocator.getStudentSubjectRepository().findStudentOnSubject(idStudent, idSubject);
        RepositoryLocator.getStudentSubjectRepository().deleteStudentSubject(studentSubject);
    }

    public void prepareData() {
        List<Student> students = RepositoryLocator.getStudentRepository().findAllStudents();
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findAllSubject();
        List<StudentSubject> studentSubjects = new ArrayList<StudentSubject>();
        Random random = new Random();
        int i;
        for (Student student : students
                ) {
            i = random.nextInt(5);

            StudentSubject studentSubject1 = new StudentSubject();
            studentSubject1.setSubject(subjects.get(i));
            studentSubject1.setStudent(student);
            studentSubject1.setClassHour(subjects.get(i).getHour());
            studentSubject1.setWeekday(subjects.get(i).getWeekday());
            studentSubject1.setModificationDate(Calendar.getInstance());
            studentSubjects.add(studentSubject1);

            StudentSubject studentSubject2 = new StudentSubject();
            studentSubject2.setSubject(subjects.get(i + 1));
            studentSubject2.setStudent(student);
            studentSubject2.setClassHour(subjects.get(i + 1).getHour());
            studentSubject2.setWeekday(subjects.get(i + 1).getWeekday());
            studentSubject2.setModificationDate(Calendar.getInstance());
            studentSubjects.add(studentSubject2);


            StudentSubject studentSubject3 = new StudentSubject();
            studentSubject3.setSubject(subjects.get(i + 2));
            studentSubject3.setStudent(student);
            studentSubject3.setClassHour(subjects.get(i + 2).getHour());
            studentSubject3.setWeekday(subjects.get(i + 2).getWeekday());
            studentSubject3.setModificationDate(Calendar.getInstance());
            studentSubjects.add(studentSubject3);

            StudentSubject studentSubject4 = new StudentSubject();
            studentSubject4.setSubject(subjects.get(i + 3));
            studentSubject4.setStudent(student);
            studentSubject4.setClassHour(subjects.get(i + 3).getHour());
            studentSubject4.setWeekday(subjects.get(i + 3).getWeekday());
            studentSubject4.setModificationDate(Calendar.getInstance());
            studentSubjects.add(studentSubject4);

            StudentSubject studentSubject5 = new StudentSubject();
            studentSubject5.setSubject(subjects.get(i + 4));
            studentSubject5.setStudent(student);
            studentSubject5.setClassHour(subjects.get(i + 4).getHour());
            studentSubject5.setWeekday(subjects.get(i + 4).getWeekday());
            studentSubject5.setModificationDate(Calendar.getInstance());
            studentSubjects.add(studentSubject5);


        }
        for (StudentSubject sS : studentSubjects
                ) {
            saveStudentSubject(sS);
        }
    }

    public void saveStudentSubject(StudentSubject studentSubject) {
        RepositoryLocator.getStudentSubjectRepository().saveStudentSubject(studentSubject);
    }
}
