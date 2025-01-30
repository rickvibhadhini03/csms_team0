package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;
<<<<<<< HEAD
@Entity
@Table(name="userdetails")
@Data
public class AppUserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private boolean isEnabled;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
=======
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user_details")
public class AppUserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @jakarta.persistence.Column(name="user_id")
    @NonNull
    private Integer id;

    @jakarta.persistence.Column(name="user_name")
    private String name;

    @jakarta.persistence.Column(name="user_password")
    private String password;

    @jakarta.persistence.Column(name="Active")
    Boolean Isactive;



>>>>>>> fa380fb6e3222d72ff9983df3de66a1d21cc313f
}
