package com.edu.rozvrhHodin.service;

import com.edu.rozvrhHodin.backend.ConsoleService;
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
            Subject newSubject = compareHourAndWeekDay(subject,student,false);
            studentSubject.setSubject(newSubject);
            studentSubject.setStudent(student);
            studentSubject.setWeekday(newSubject.getWeekday());
            studentSubject.setClassHour(newSubject.getHour());
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



     Random random = new Random();
        int i;
        for (Student student : students
                ) {
            i = random.nextInt(5);

            StudentSubject studentSubject1 = new StudentSubject();
            Subject newSubject1 = compareHourAndWeekDay(subjects.get(i),student,true);
            studentSubject1.setSubject(newSubject1);
            studentSubject1.setStudent(student);
            studentSubject1.setClassHour(newSubject1.getHour());
            studentSubject1.setWeekday(newSubject1.getWeekday());
            studentSubject1.setModificationDate(Calendar.getInstance());
            saveStudentSubject(studentSubject1);

            StudentSubject studentSubject2 = new StudentSubject();
            Subject newSubject2 = compareHourAndWeekDay(subjects.get(i +1),student,true);
            studentSubject2.setSubject(newSubject2);
            studentSubject2.setStudent(student);
            studentSubject2.setClassHour(newSubject2.getHour());
            studentSubject2.setWeekday(newSubject2.getWeekday());
            studentSubject2.setModificationDate(Calendar.getInstance());
            saveStudentSubject(studentSubject2);


            StudentSubject studentSubject3 = new StudentSubject();
            Subject newSubject3 = compareHourAndWeekDay(subjects.get(i + 2), student, true);
            studentSubject3.setSubject(newSubject3);
            studentSubject3.setStudent(student);
            studentSubject3.setClassHour(newSubject3.getHour());
            studentSubject3.setWeekday(newSubject3.getWeekday());
            studentSubject3.setModificationDate(Calendar.getInstance());
            saveStudentSubject(studentSubject3);

            StudentSubject studentSubject4 = new StudentSubject();
            Subject newSubject4 = compareHourAndWeekDay(subjects.get(i + 3), student, true);
            studentSubject4.setSubject(newSubject4);
            studentSubject4.setStudent(student);
            studentSubject4.setClassHour(newSubject4.getHour());
            studentSubject4.setWeekday(newSubject4.getWeekday());
            studentSubject4.setModificationDate(Calendar.getInstance());
            saveStudentSubject(studentSubject4);

            StudentSubject studentSubject5 = new StudentSubject();
            Subject newSubject5 = compareHourAndWeekDay(subjects.get(i + 4),student,true);
            studentSubject5.setSubject(newSubject5);
            studentSubject5.setStudent(student);
            studentSubject5.setClassHour(newSubject5.getHour());
            studentSubject5.setWeekday(newSubject5.getWeekday());
            studentSubject5.setModificationDate(Calendar.getInstance());
            saveStudentSubject(studentSubject5);


        }


    }

    public void saveStudentSubject(StudentSubject studentSubject) {
        RepositoryLocator.getStudentSubjectRepository().saveStudentSubject(studentSubject);
    }

    private Subject compareHourAndWeekDay(Subject subject, Student student, boolean prepare) {
        List<Subject> subjects = RepositoryLocator.getSubjectRepository().findByStudentWeekDayAndHour(student.getId(), subject.getWeekday(), subject.getHour());
        Long id;

        if (!subjects.isEmpty()) {

            if (prepare) {
                id = gamble(subject.getId());
            } else {
                ConsolePresentation.compareHourDayOdWeekStudent(subject);
                id = ConsoleService.idInput(subject.getId());
            }
            subject = RepositoryLocator.getSubjectRepository().findByID(id);
            return compareHourAndWeekDay(subject, student, prepare);
        }
        return subject;
    }

    private Long gamble(Long id) {
        Random random = new Random();
        Long newId = Integer.toUnsignedLong(random.nextInt(9) + 1);
        if (id.equals(newId))
            return gamble(newId);
        return newId;
    }
}

