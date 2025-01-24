package com.cars24.csms.data.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "UserType")
public class AppUserDetails {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="username",nullable = false,unique = true)
    @Email(message = "Enter a valid email Id !!")
    private String username;


    @Column(name="password",nullable = false,unique = true)
    private String password;

    @Column(name="isEnabled")
    private boolean isEnabled;

    @Column(name="user_type",nullable = false)
    private String user_type;

    @JsonBackReference
    @OneToOne(mappedBy = "userDetailsEntity")
    private CustomerEntity customerEntity;

}
