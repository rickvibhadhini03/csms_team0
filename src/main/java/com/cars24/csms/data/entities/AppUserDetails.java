package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Table(name = "User_Details")
@Entity

public class AppUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //helps us to manage or autoincrement ids
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean is_enabled;
}
