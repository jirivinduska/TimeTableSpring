package com.edu.rozvrhHodin.repository.entity;


import javax.persistence.*;
import java.time.DayOfWeek;

import java.time.LocalTime;
import java.util.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 5)
    private String abbrev;

    private String name;

    @Column(name = "lector_name")
    private String lectorName;

    @Column(name = "room_number")
    private int roomNo;

    @Enumerated(EnumType.STRING)
    private DayOfWeek weekday;


    private int hour;

    @OneToMany(mappedBy = "subject")
    public Set<StudentSubject> studentSubjectSet = new HashSet<StudentSubject>();

    public Subject() {

    }

    public Subject(String abbrev, String name, String lectorName, int roomNo, DayOfWeek weekday, int hour) {

        this.abbrev = abbrev;
        this.name = name;
        this.lectorName = lectorName;
        this.roomNo = roomNo;
        this.weekday = weekday;

        this.hour = hour;
    }


    public Long getId() {
        return id;
    }

    public Set<StudentSubject> getStudentSubjectSet() {
        return studentSubjectSet;
    }

    public void setStudentSubjectSet(Set<StudentSubject> studentSubjectSet) {
        this.studentSubjectSet = studentSubjectSet;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abrev) {
        this.abbrev = abrev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLectorName() {
        return lectorName;
    }

    public void setLectorName(String lectorName) {
        this.lectorName = lectorName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public DayOfWeek getWeekday() {
        return weekday;
    }

    public void setWeekday(DayOfWeek weekday) {
        this.weekday = weekday;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;

    }

}
