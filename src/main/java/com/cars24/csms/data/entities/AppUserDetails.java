package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="appUserDetails")
@Entity
@Data
public class AppUserDetails {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="Appid")
    int id;
    @Column(name="name")
    String name;
    @Column(name="password")
    String password;
    @Column(name="IsActive")
    boolean IsActive;

}
