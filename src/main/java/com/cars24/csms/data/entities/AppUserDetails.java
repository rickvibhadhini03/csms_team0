package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="userdetails")
@Entity
public class AppUserDetails {

    @Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name="username",nullable = false)
    private String username;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="isenable")
    private boolean isEnable;


}
