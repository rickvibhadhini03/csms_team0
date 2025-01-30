package com.cars24.csms.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

@Table(name= "services")
@Entity
//@Data
public class ServicesEntity {
    @Id
    @jakarta.persistence.Column(name="service_id")
    private int id;
    @Column(name="service_name", nullable = false)//can use another name, column has other parameters also like nullable, unique etc
    private String name;
    @NonNull
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}