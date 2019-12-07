package com.cko.sampleSpringProject.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String color;

    @Column
    private String model;

    @Column
    private int price;

    public Car(){

    };

    public Car(String color, String model, int price) {
        this.color = color;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
