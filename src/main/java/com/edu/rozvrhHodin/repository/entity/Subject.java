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
    private long id;

    @Column(length = 5)
    private String abrev;

    private String name;

    @Column(name = "lector_name")
    private String lectorName;

    @Column(name="room_number")
    private int roomNo;

    @Enumerated(EnumType.STRING)
    private DayOfWeek weekday;


    private int hour;

    @OneToMany(mappedBy = "subject")
    public Set<StudentSubject> studentSubjectSet = new HashSet<StudentSubject>();

    public Subject(String abrev, String name, String lectorName, int roomNo, DayOfWeek weekday, int hour) {

        this.abrev = abrev;
        this.name = name;
        this.lectorName = lectorName;
        this.roomNo = roomNo;
        this.weekday = weekday;

        this.hour = hour;
    }

    public long getId() {
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

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
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

    @Override
    public String toString() {
        return "Predmet{" +
                "abrev='" + abrev + '\'' +
                ", name='" + name + '\'' +
                ", lectorName='" + lectorName + '\'' +
                ", roomNo=" + roomNo +
                ", weekday=" + weekday +
                ", hour=" + hour +
                '}';
    }
}
