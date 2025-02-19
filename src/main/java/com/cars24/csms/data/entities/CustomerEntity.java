package com.cars24.csms.data.entites;

import lombok.Data;


import javax.persistence.*;
@Data
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "customers")
public class CustomerEntity {

    @jakarta.persistence.Id
    @Column(name = "customer_id" , nullable = false , unique = true)
    private int customer_id;


    @Column(name = "name")
    private String name;


    @Column(name = "phone", unique = true)
    private String phone ;

    @Column(name = "email")
    private String email ;


    @Column(name = "address", nullable = false)
    private String address ;

    @Column(name = "user_id")
    private int user_id;
}
