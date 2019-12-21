package com.cko.sampleSpringProject.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    String day;

    public Day() {

    }

    public Day(String day) {
        this.day = day;
    }

    public long getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
