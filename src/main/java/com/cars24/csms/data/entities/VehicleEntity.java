package com.cars24.csms.data.entities;


import jakarta.persistence.*;
import lombok.Data;

@Table(name ="vehicles")
@Entity
@Data
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vehicle_id;

    @Column(name = "customer_id")
    private int customer_id;


    @Column(name ="license_plate")
    private String license_plate;

    @Column(name = "model")
    private String modelName;

    @Column(name = "make")
    private String make;

    @Column(name = "year")
    private int year;

    @Column(name = "color")
    private String color;

//    @Column(name = "isDeleted")
//    private Boolean isDeleted;
}
