package com.edu.rozvrhHodin.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "students_subjects")
public class StudentSubject {
    @Id
    @GeneratedValue
    @Column(name = "Student_Subject_ID")
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;


    private int classHour;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getClassHour() {
        return classHour;
    }

    public void setClassHour(int classHour) {
        this.classHour = classHour;
    }
}
