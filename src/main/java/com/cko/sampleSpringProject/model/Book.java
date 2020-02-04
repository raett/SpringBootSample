package com.cko.sampleSpringProject.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long numberOrder;

    @Column
    private String fio;

    @Column
    private String phone;

    @Column
    private String date;

    @Column
    private String typeOrder;

    @Column
    private String masterName;

    @Column
    private String timeOrder;

    @Column
    private String gender;

    @Column
    private String statusOrder;

    public Book() {
    }


    public Book(long numberOrder, String fio,
                String phone, String date,
                String typeOrder, String masterName,
                String timeOrder, String gender,
                String statusOrder) {
        this.numberOrder = numberOrder;
        this.fio = fio;
        this.phone = phone;
        this.date = date;
        this.typeOrder = typeOrder;
        this.masterName = masterName;
        this.timeOrder = timeOrder;
        this.gender = gender;
        this.statusOrder = statusOrder;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public long getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(long numberOrder) {
        this.numberOrder = numberOrder;
    }
}


