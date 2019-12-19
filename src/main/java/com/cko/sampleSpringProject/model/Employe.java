package com.cko.sampleSpringProject.model;


import javax.persistence.*;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String fio;

    @Column
    private String phone;

    @Column
    private int experience;

    public Employe(String fio, String phone, int experience) {
        this.fio = fio;
        this.phone = phone;
        this.experience = experience;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
