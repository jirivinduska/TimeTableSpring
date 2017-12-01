package com.edu.rozvrhHodin.repository.entity;


import javax.persistence.*;
import java.sql.Time;
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

    @OneToMany(mappedBy = "subject")
    private List<TimeSchedule> timeSchedules = new ArrayList<TimeSchedule>();

    @OneToMany(mappedBy = "subject")
    private List<StudentSubject> studentSubjectSet = new ArrayList<StudentSubject>();



    public Subject(String abrev, String name, String lectorName, int roomNo) {

        this.abrev = abrev;
        this.name = name;
        this.lectorName = lectorName;
        this.roomNo = roomNo;

    }

    public Subject(String abrev, String name) {
        this.abrev = abrev;
        this.name = name;
    }

    public Subject() {
    }

    public List<TimeSchedule> getTimeSchedules() {
        return timeSchedules;
    }

    public void setTimeSchedules(List<TimeSchedule> timeSchedules) {
        this.timeSchedules = timeSchedules;
    }

    public long getId() {
        return id;
    }

    public List<StudentSubject> getStudentSubjectSet() {
        return studentSubjectSet;
    }

    public void setStudentSubjectSet(List<StudentSubject> studentSubjectSet) {
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



    @Override
    public String toString() {
        return "Predmet{" +
                "abrev='" + abrev + '\'' +
                ", name='" + name + '\'' +
                ", lectorName='" + lectorName + '\'' +
                ", roomNo=" + roomNo +

                '}';
    }
}
