package com.cars24.csms.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.Column;
//import javax.validation.Valid;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

@Valid
@Data
public class CreateEmployeeRequest {

    //@Email
    //@NotNull()
    //@NotBlank
    //@Max

    @Valid
    @NotNull
    private String name;

    @Valid
    @NotNull
    private String phone;

    @Valid
    @Email
    @NotBlank
    private String email;

    private String role;

    @Valid
    @Min(value = 1, message = "Invalid amt")
    private float salary;

//    @Override
//    public String toString() {
//        return "CreateEmployeeRequest{" +
//                "name='" + name + '\'' +
//                ", phone='" + phone + '\'' +
//                ", email='" + email + '\'' +
//                ", role='" + role + '\'' +
//                ", salary=" + salary +
//                '}';
//    }


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