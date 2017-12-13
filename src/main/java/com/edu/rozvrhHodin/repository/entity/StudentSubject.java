package com.edu.rozvrhHodin.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Calendar;

@Entity
@Table(name = "students_subjects")
public class StudentSubject implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;


    private int classHour;

    @Enumerated(EnumType.STRING)
    private DayOfWeek weekday;

    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar modificationDate;

    public DayOfWeek getWeekday() {
        return weekday;
    }

    public Calendar getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Calendar modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setWeekday(DayOfWeek weekday) {
        this.weekday = weekday;
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
