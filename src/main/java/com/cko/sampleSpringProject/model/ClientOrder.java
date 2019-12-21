package com.cko.sampleSpringProject.model;


import javax.persistence.*;

@Entity
public class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String fio;

    @Column
    private String phone;

    @Column
    private String date;

    @Column
    private String typeOrder;

    @Column
    private String gender;
    public ClientOrder() {
    }

    public ClientOrder(String fio, String phone, String data, String typeOrder, String gender) {
        this.fio = fio;
        this.phone = phone;
        this.date = data;
        this.typeOrder = typeOrder;
        this.gender = gender;
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

    public long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
