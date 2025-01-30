package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="employees")
@Entity
//@Data
public class EmployeeEntity {
    String UserType ;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="employee_id")
    private Integer id;

    //@jakarta.persistence.Column(name="name")
    private String name;

    //@jakarta.persistence.Column(name="phone")
    private String phone;

    //@jakarta.persistence.Column(name="email")
    private String email;

    //@jakarta.persistence.Column(name="role")
    private String role;

    //@Column(name="salary")
    private float salary;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
